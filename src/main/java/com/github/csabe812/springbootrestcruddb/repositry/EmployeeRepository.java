package com.github.csabe812.springbootrestcruddb.repositry;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.csabe812.springbootrestcruddb.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findAll();

}