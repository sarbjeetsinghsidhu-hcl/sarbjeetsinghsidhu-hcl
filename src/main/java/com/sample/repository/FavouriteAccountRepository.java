/**
 * 
 */
package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.FavouriteAccount;

/**
 * @author HCL
 *
 */
@Repository
public interface FavouriteAccountRepository extends JpaRepository<FavouriteAccount, Integer> {

}
