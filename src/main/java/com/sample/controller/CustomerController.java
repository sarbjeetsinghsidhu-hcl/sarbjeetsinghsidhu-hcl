/**
 * 
 */
package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.FavouriteAccount;
import com.sample.service.FavouriteService;

/**
 * Customer controller is the class that will have all the operations related to
 * customer.
 * 
 * @author Sarbjeet
 *
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	/**
	 * 
	 */
	@Autowired
	private FavouriteService favouriteService;

	/**
	 * Accept the customer id and returns list of favourites.
	 * 
	 * @param customerId
	 * @return
	 */
	@GetMapping("/{customerId}/favorite")
	public List<FavouriteAccount> getFavorites(@PathVariable("customerId") String customerId) {
		return null;
	}

	/**
	 * To add a new favorite.
	 */
	@PostMapping("/favorites")
	public void addFavourite() {

	}

	/**
	 * Method to update the favorite.
	 */
	@PutMapping("/favorites")
	public void updateFavorite() {

	}
}
