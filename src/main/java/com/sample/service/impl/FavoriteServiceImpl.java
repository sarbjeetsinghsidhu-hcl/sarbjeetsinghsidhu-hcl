/**
 * 
 */
package com.sample.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sample.entity.FavouriteAccount;
import com.sample.exception.FavouritesNotFound;
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
	 * 
	 */
	@Autowired
	private FavouriteAccountRepository favouriteAccountRepository;
	
	/**
	 * 
	 */
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<FavouriteAccount> getFavouriteAccounts(String customerId, int page) {
		Page<FavouriteAccount> pageList = favouriteAccountRepository.findByCustomerId(customerId, 
				PageRequest.of(page, 5, Sort.Direction.ASC, "account_name"));
		if(pageList.isEmpty())
			throw new FavouritesNotFound("Favourite accounts not found");
		return pageList.getContent();
	}

	@Override
	@Transactional
	public boolean addFavouriteAccount(FavouriteAccount favouriteAccount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FavouriteAccount getFavouriteAccount(String favAccountId) {
		// TODO Auto-generated method stub
		return null;
	}
}