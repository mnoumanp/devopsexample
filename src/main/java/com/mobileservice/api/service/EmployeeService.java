package com.mobileservice.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileservice.api.entity.EmployeeEntity;
import com.mobileservice.api.exception.EmployeeNotFoundException;
import com.mobileservice.api.exception.UniqueUserException;
import com.mobileservice.api.model.EmployeeModel;
import com.mobileservice.api.repository.EmployeeRepo;
import com.mobileservice.api.repository.UserRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private UserRepo userRepo;

	public EmployeeModel saveEmployee(EmployeeModel employeeModel) {
		try {
			userRepo.save(employeeModel.getUser());
			employeeModel.getEmployee().setRole(employeeModel.getUser().getUserRole());
			employeeRepo.save(employeeModel.getEmployee());
			employeeModel.getUser().setEmployeeId(employeeModel.getEmployee().getId());
			// update employee id
			userRepo.save(employeeModel.getUser());
		} catch (Exception e) {
			if (e.getMessage().contains("unique_username")) {
				throw new UniqueUserException();
			} else {
				throw e;
			}
		}
		return employeeModel;
	}

	public EmployeeModel updateEmployee(EmployeeModel employeeModel) {
		if (!employeeRepo.existsById(employeeModel.getEmployee().getId())) {
			throw new EmployeeNotFoundException();
		}
		try {
			userRepo.save(employeeModel.getUser());
			employeeModel.getEmployee().setRole(employeeModel.getUser().getUserRole());
			employeeRepo.save(employeeModel.getEmployee());
			employeeModel.getUser().setEmployeeId(employeeModel.getEmployee().getId());
			// update employee id
			userRepo.save(employeeModel.getUser());
		} catch (Exception e) {
			if (e.getMessage().contains("unique_username")) {
				throw new UniqueUserException();
			} else {
				throw e;
			}
		}
		return employeeModel;
	}

	public List<EmployeeEntity> getEmployeesByBranch(String branchId) {
		return employeeRepo.findByBranchId(branchId);
	}

	public EmployeeEntity getEmployeeById(String employeeId) {
		return employeeRepo.findOneById(employeeId);
	}

	public EmployeeEntity updateEmployeeById(String employeeId, String branchId) {
		return null;
	}

}
