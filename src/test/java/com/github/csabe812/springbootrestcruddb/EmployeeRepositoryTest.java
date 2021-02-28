package com.github.csabe812.springbootrestcruddb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.github.csabe812.springbootrestcruddb.domain.Employee;
import com.github.csabe812.springbootrestcruddb.repository.EmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTest {

	private final int DEFAULT_EMPLOYEES = 3;
	private final String DEFAULT_EMPLOYEE_NAME = "Jhonny";

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("Testname");
		employee.setSalary(12345);

		Employee savedEmployee = employeeRepository.save(employee);

		Employee existEmployee = testEntityManager.find(Employee.class, savedEmployee.getId());

		assertThat(existEmployee.getName()).isEqualTo(employee.getName());
	}

	@Test
	public void testFindByName() {
		Employee employee = employeeRepository.findByName(DEFAULT_EMPLOYEE_NAME);
		assertThat(employee.getName()).isEqualTo(DEFAULT_EMPLOYEE_NAME);
	}

	@Test
	public void testNumberOfSavedEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();

		assertThat(employeeList.size()).isEqualTo(DEFAULT_EMPLOYEES);
	}

}
