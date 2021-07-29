/**
 * 
 */
package com.sample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.entity.FavouriteAccount;

/**
 * @author HCL
 *
 */
@Repository
public interface FavouriteAccountRepository extends JpaRepository<FavouriteAccount, Integer> {
	
	
	@Query(value = "SELECT * FROM favourite_account fav WHERE fav.customer_id=?1",
			countQuery = "SELECT count(*) FROM favourite_account fav WHERE fav.customer_id=?1",
			nativeQuery = true)
	public Page<FavouriteAccount> findByCustomerId(String customerId, Pageable pageable);
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public FavouriteAccount findByAccountNumber(final String accountNumber);
}
