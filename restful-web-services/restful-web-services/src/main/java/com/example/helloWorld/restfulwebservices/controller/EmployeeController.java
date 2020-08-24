package com.example.helloWorld.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloWorld.restfulwebservices.dto.Employee;
import com.example.helloWorld.restfulwebservices.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

}
