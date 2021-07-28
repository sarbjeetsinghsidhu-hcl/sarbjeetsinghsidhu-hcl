package com.sample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Login controller class is responsible for authentication and authorization of the user.
 * @author HCL
 *
 */
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

	/**
	 * This method will authenticate the users.
	 */
	@PostMapping("/")
	public void authenticateUser() {
		
	}
}
