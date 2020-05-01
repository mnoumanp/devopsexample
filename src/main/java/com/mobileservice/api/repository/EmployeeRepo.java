package com.mobileservice.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mobileservice.api.entity.EmployeeEntity;

@Repository
public interface EmployeeRepo extends MongoRepository<EmployeeEntity, String>{
	
	
	public List<EmployeeEntity> findAll();

	public List<EmployeeEntity> findByEmployeeName(String employeeName);

	public List<EmployeeEntity> findByEmployeeAddress(String employeeAddress);

	public EmployeeEntity findOneById(String id);

	//public List<EmployeeEntity> findByEmployeeNameAndBranchName(String employeeName,String branchName);
	
	public List<EmployeeEntity> findByBranchId(String branchId);
	



}
