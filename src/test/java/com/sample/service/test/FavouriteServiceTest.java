package com.sample.service.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sample.entity.FavouriteAccount;
import com.sample.repository.FavouriteAccountRepository;
import com.sample.service.FavouriteService;

@ExtendWith(SpringExtension.class)
public class FavouriteServiceTest {
	
	@MockBean
	private FavouriteAccountRepository dao;
	
	@InjectMocks
	private FavouriteService favService;
	
	@Test
	void testGetFavouriteAccountByCustomerId() {
		FavouriteAccount favAccountOne = new FavouriteAccount("Test-Account-1","ABCD 1234 456 789");
		FavouriteAccount favAccountTwo = new FavouriteAccount("Test-Account-2","ABCD 1234 456 123");
		FavouriteAccount favAccountThree = new FavouriteAccount("Test-Account-3","ABCD 1234 456 456");
	}
}
