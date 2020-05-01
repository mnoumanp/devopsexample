package com.mobileservice.api.model;

import com.mobileservice.api.entity.EmployeeEntity;
import com.mobileservice.api.entity.UserEntity;

import lombok.Data;

@Data
public class EmployeeModel {
	
	
	private EmployeeEntity employee;
	
	private UserEntity user;

}
