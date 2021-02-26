package com.github.csabe812.springbootrestcruddb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.csabe812.springbootrestcruddb.domain.Employee;
import com.github.csabe812.springbootrestcruddb.repositry.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findById(Long employeeId) {
		return employeeRepository.findById(employeeId).orElse(new Employee(0, "Not exists", 0));
	}

	public void delete(Employee employeeToBeDeleted) {
		employeeRepository.delete(employeeToBeDeleted);
	}

}
