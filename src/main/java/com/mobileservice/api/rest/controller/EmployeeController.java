package com.mobileservice.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobileservice.api.entity.EmployeeEntity;
import com.mobileservice.api.exception.EmployeeNotFoundException;
import com.mobileservice.api.model.EmployeeModel;
import com.mobileservice.api.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/branch/{branchId}/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public @ResponseBody EmployeeModel createEmployeeAndUser(@PathVariable("branchId") String branchId,
			@RequestBody EmployeeModel employeeModel) throws Exception {

		employeeModel.getEmployee().setBranchId(branchId);
		employeeService.saveEmployee(employeeModel);
		return employeeModel;
	}

	@PutMapping("/{employeeId}")
	public @ResponseBody EmployeeModel updateEmployeeAndUser(@PathVariable String employeeId,
			@PathVariable("branchId") String branchId, @RequestBody EmployeeModel employeeModel) throws Exception {

		employeeModel.getEmployee().setBranchId(branchId);
		employeeModel.getEmployee().setId(employeeId);
		employeeService.updateEmployee(employeeModel);
		return employeeModel;
	}

	@GetMapping
	public List<EmployeeEntity> getEmployees(@PathVariable("branchId") String branchId) {
		return employeeService.getEmployeesByBranch(branchId);
	}

	@GetMapping(value = "/{employeeId}")
	public EmployeeEntity getEmployee(@PathVariable String employeeId, @PathVariable("branchId") String branchId) {

		EmployeeEntity theEmployee = employeeService.getEmployeeById(employeeId);
		if (theEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not found " + employeeId);
		}
		return theEmployee;
	}

}
