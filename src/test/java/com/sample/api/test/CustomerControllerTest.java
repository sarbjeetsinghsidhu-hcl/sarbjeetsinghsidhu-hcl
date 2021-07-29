package com.sample.api.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.sample.FavoriteServicesApplication;
import com.sample.controller.CustomerController;
import com.sample.entity.FavouriteAccount;
import com.sample.service.FavouriteService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CustomerController.class)
@ContextConfiguration(classes = FavoriteServicesApplication.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FavouriteService favService;

	private final String mockCustomerId = "789456";

	@Test
	void testGetFavouritesByCustomerId() throws Exception {
		FavouriteAccount favAccount = new FavouriteAccount();
		favAccount.setAccountName("Test-Account-Name");
		favAccount.setAccountNumber("ABCD 1234 456 789");
		List<FavouriteAccount> mockReturnList = Arrays.asList(favAccount);

		when(favService.getFavouriteAccounts(mockCustomerId, 0)).thenReturn(mockReturnList);
		mockMvc.perform(get("/api/v1/customers/" + mockCustomerId + "/favorites")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].accountName", Matchers.is("Test-Account-Name")));
	}
}
