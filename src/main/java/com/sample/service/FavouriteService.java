/**
 * 
 */
package com.sample.service;

import java.util.List;

import com.sample.entity.FavouriteAccount;

/**
 * Favourtie Service represents the operations 
 * @author HCL
 *
 */

public interface FavouriteService {

	/**
	 * Returns list of favorite account for the provided customer id.
	 * @param customerId
	 * @return
	 */
	public List<FavouriteAccount> getFavouriteAccounts(String customerId, int page);
	

	/**
	 * Adds a new favorite account in the db.
	 * @param favouriteAccount
	 * @return
	 */
	public boolean addFavouriteAccount(FavouriteAccount favouriteAccount);
	
	/**
	 * Returns favorite account corresponding to a particular fav account id.
	 * @param favAccountId
	 * @return
	 */
	public FavouriteAccount getFavouriteAccount(final String favAccountId);
}
