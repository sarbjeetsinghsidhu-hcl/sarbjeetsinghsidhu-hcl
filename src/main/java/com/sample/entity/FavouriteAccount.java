package com.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favourite_account")
public class FavouriteAccount {

	/**
	 * 
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/**
	 * 
	 */
	@Column(name="account_name")
	private String accountName;
	
	
	/**
	 * 
	 */
	@Column(name="account_number")
	private String accountNumber;
	
	@ManyToOne
	private Customer customer;
	
}
