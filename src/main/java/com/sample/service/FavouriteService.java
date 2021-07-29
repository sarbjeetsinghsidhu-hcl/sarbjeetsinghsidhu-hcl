/**
 * 
 */
package com.sample.service;

import java.util.List;

import com.sample.entity.FavouriteAccount;

/**
 * Favorite Service represents the operations 
 * @author Team.
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
	 * 
	 * @param customerId
	 * @param favouriteAccount
	 * @return
	 */
	public boolean addFavouriteAccount(String customerId, FavouriteAccount favouriteAccount);
	
	/**
	 * Returns favorite account corresponding to a particular fav account id.
	 * @param favAccountId
	 * @return
	 */
	public FavouriteAccount getFavouriteAccount(final String favAccountId);
}
