package com.sample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * Login controller class is responsible for authentication and authorization of the user.
 * @author HCL
 *
 */
@RestController
@RequestMapping("/api/v1/login")
@Api(value = "Login APIs", tags = {"Customer login APIs"})
public class LoginController {

	/**
	 * This method will authenticate the users.
	 */
	@PostMapping("/")
	public void authenticateUser() {
		
	}
}
