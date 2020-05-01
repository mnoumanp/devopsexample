package com.mobileservice.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="users")
public class UserEntity {
	
	@Id
	private String id;
	
	private String userName;
	
	private String password;
	
	private String userRole;
	
	private String employeeId;
	
	private String otp;

}
