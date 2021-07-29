/**
 * 
 */
package com.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.FavouriteAccount;
import com.sample.exception.ErrorResponse;
import com.sample.service.FavouriteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Customer controller is the class that will have all the operations related to
 * customer.
 * 
 * @author Sarbjeet
 *
 */
@RestController
@RequestMapping("/api/v1/customers")
@Api(value = "Customer APIs", tags = {"Customer CRUD APIs"})
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
	@ApiOperation(value = "Get list of favourite accounts", response = FavouriteAccount.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successfull operation", response = FavouriteAccount.class),
		@ApiResponse(code = 404, message = "Favourites not found", response = ErrorResponse.class)
	})
	@GetMapping("/{customerId}/favorites")
	public List<FavouriteAccount> getFavorites(
			@PathVariable("customerId") String customerId,
			@RequestParam("page") Optional<Integer> page) {
		return favouriteService.getFavouriteAccounts(customerId, page.orElse(0));
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
