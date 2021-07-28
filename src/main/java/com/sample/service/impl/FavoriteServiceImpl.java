/**
 * 
 */
package com.sample.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.entity.FavouriteAccount;
import com.sample.repository.CustomerRepository;
import com.sample.repository.FavouriteAccountRepository;
import com.sample.service.FavouriteService;

/**
 * @author HCL
 *
 */
@Component
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
	public List<FavouriteAccount> getFavouriteAccounts(String customerId) {
		// TODO Auto-generated method stub
		return null;
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