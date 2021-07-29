/**
 * 
 */
package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Customer;

/**
 * @author HCL
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public Customer findByCustomerId(final String customerId);
}
