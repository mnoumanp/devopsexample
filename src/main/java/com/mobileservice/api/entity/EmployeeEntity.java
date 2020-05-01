package com.mobileservice.api.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mobileservice.api.model.DocumentModel;

import lombok.Data;

@Data
@Document(collection="employees")
public class EmployeeEntity {

	@Id
	private String id;

	private String employeeName;

	private String phoneNumber;

	private String emailId;

	private String gender;

	private int age;

	private String qualification;

	private String role;

	private boolean isEnable;

	private Date dateOfJoining;

	private double salary;

	private String employeeAddress;

	private DocumentModel image;

	private String branchId;

}
