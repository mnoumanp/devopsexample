package com.mobileservice.api.model;

import lombok.Data;

@Data
public class ForgotPasswordModel {

	private String userName;
	
	private boolean isValidOtp;
	
	private String enteredOtp;
	
	private String newPassword;
}
