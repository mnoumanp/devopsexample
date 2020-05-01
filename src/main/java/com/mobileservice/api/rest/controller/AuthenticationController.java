package com.mobileservice.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobileservice.api.entity.UserEntity;
import com.mobileservice.api.model.ForgotPasswordModel;
import com.mobileservice.api.service.AuthenticationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@GetMapping
	public UserEntity getUser(@RequestParam("employee-id") String employeeId) {
		UserEntity userEntity = authenticationService.getUserByEmployeeId(employeeId);
		return userEntity;
	}

	@PostMapping(path = "/login")
	public @ResponseBody UserEntity autheticateUser(@RequestBody UserEntity userEntity) throws Exception {

		UserEntity authEntity = authenticationService.validateCredentials(userEntity.getUserName(),
				userEntity.getPassword());
		return authEntity;
	}

	@PostMapping(path = "/forget-password")
	public @ResponseBody ForgotPasswordModel forgetPassword(@RequestBody ForgotPasswordModel forgotPasswordModel)
			throws Exception {

		authenticationService.forgetPassword(forgotPasswordModel);
		return forgotPasswordModel;

	}
	
	@PostMapping(path = "/validate-otp")
	public @ResponseBody ForgotPasswordModel validateOtp(@RequestBody ForgotPasswordModel forgotPasswordModel)
			throws Exception {

		forgotPasswordModel = authenticationService.validateOTP(forgotPasswordModel);
		return forgotPasswordModel;

	}

}
