package com.sample.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	/**
	 * 
	 */
	@Id
	private Integer id;
	
	/**
	 * 
	 */
	@Column(name="customer_id")
	private String customerId;
	
	/**
	 * 
	 */
	@Column(name="password")
	private String password;
	
	/**
	 * 
	 */
	@Column(name="name")
	private String name;
	
	/**
	 * 
	 */
	@OneToMany(mappedBy = "customer")
	private List<FavouriteAccount> favouriteAccounts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FavouriteAccount> getFavouriteAccounts() {
		return favouriteAccounts;
	}

	public void setFavouriteAccounts(List<FavouriteAccount> favouriteAccounts) {
		this.favouriteAccounts = favouriteAccounts;
	}	
}
