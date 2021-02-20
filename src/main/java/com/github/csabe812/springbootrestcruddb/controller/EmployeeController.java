package com.github.csabe812.springbootrestcruddb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.csabe812.springbootrestcruddb.domain.Employee;
import com.github.csabe812.springbootrestcruddb.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public List<Employee> home() {
		return employeeService.findAll();
	}

}
