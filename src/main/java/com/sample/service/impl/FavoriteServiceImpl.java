/**
 * 
 */
package com.sample.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.entity.BankDetails;
import com.sample.entity.Customer;
import com.sample.entity.FavouriteAccount;
import com.sample.exception.CreationException;
import com.sample.exception.FavouritesNotFound;
import com.sample.exception.RecordExistException;
import com.sample.repository.CustomerRepository;
import com.sample.repository.FavouriteAccountRepository;
import com.sample.service.FavouriteService;

/**
 * @author HCL
 *
 */
@Service
public class FavoriteServiceImpl implements FavouriteService {
	
	/**
	 * Initializing Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(FavoriteServiceImpl.class);

	/**
	 * 
	 */
	@Autowired
	private FavouriteAccountRepository favouriteAccountRepository;
	
	
	/**
	 * 
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 
	 */
	@Autowired
	private CustomerRepository customerRepository;

	/*
	 * (non-Javadoc)
	 * @see com.sample.service.FavouriteService#getFavouriteAccounts(java.lang.String, int)
	 */
	@Override
	public List<FavouriteAccount> getFavouriteAccounts(String customerId, int page) {
		Page<FavouriteAccount> pageList = favouriteAccountRepository.findByCustomerId(customerId,
				PageRequest.of(page, 5, Sort.Direction.ASC, "account_name"));
		if (pageList.isEmpty())
			throw new FavouritesNotFound(String.format("Favourite accounts are not found against customer Id %s", customerId));
		return pageList.getContent();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sample.service.FavouriteService#addFavouriteAccount(java.lang.String, com.sample.entity.FavouriteAccount)
	 */
	@Override
	@Transactional
	public boolean addFavouriteAccount(String customerId, FavouriteAccount favouriteAccount) {
		LOG.info("Adding new account");
		validateRequest(favouriteAccount);		
		ResponseEntity<BankDetails> res = restTemplate.exchange("http://localhost:8081/api/v1/banks/hdfc0009009", HttpMethod.GET, 
				null, BankDetails.class);		
		favouriteAccount.setBankName(res.getBody().getBankName());
		favouriteAccount.setCreatedOn(new Date());
		Customer customer =  customerRepository.findByCustomerId(customerId);
		LOG.debug("Customer id {}",customer);
		favouriteAccount.setCustomer(customer);
		favouriteAccountRepository.save(favouriteAccount);
		return false;
	}

	@Override
	public FavouriteAccount getFavouriteAccount(String favAccountId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param account
	 */
	private void validateRequest(FavouriteAccount account) {
		LOG.info("Adding new accou");
		boolean error = false;
		StringBuilder message = new StringBuilder();
		if (account != null) {
			if (account.getAccountName() == null || "".equalsIgnoreCase(account.getAccountName().trim())) {
				error = true;
				message.append("Account Name Can't be null or empty.");
			}
			if (account.getAccountNumber() == null || "".equalsIgnoreCase(account.getAccountNumber().trim())) {
				error = true;
				message.append("Account Number Can't be null or empty.");
			}
			FavouriteAccount favouriteAccount = favouriteAccountRepository.findByAccountNumber("ABC-123");
			if(favouriteAccount != null) {
				throw new RecordExistException("Favorite account number already registered.");
			}
		}
		if (error) {
			throw new CreationException(message.toString());
		}
	}
}