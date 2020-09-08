package com.example.helloWorld.restfulwebservices.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloWorld.restfulwebservices.domain.EmployeeDomain;
import com.example.helloWorld.restfulwebservices.dto.Employee;
import com.example.helloWorld.restfulwebservices.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	Mapper beanMapper;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		List<EmployeeDomain> employeeDomainList = employeeRepository.findAll();
		for (EmployeeDomain employeeDomain : employeeDomainList) {
			Employee employee = beanMapper.map(employeeDomain, Employee.class);
			employees.add(employee);
		}
		return employees;
	}

	public Employee getEmployee(Long id) {
		EmployeeDomain employeeDomain = employeeRepository.getOne(id);
		Employee employee = beanMapper.map(employeeDomain, Employee.class);
		return employee;
	}

}
