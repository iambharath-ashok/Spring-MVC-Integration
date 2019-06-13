package com.guru.bharath.spring.hibernate.dao;

import java.util.List;

import com.guru.bharath.spring.hibernate.model.Employee;

public interface EmployeeDao {

	List<Employee> findAllEmployees();

	Employee findEmployeeBySsn(String ssn);

	Employee findEmployeeById(Long id);
	
	Long saveEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeBySsn(String ssn);
	
}
