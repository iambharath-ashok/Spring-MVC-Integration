package com.guru.bharath.spring.hibernate.service;

import java.util.List;

import com.guru.bharath.spring.hibernate.model.Employee;

public interface EmployeeService {

	Employee findById(Long id);

	Employee findEmployeeBySsn(String ssn);

	List<Employee> findAllEmployees();

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployeeBySsn(String ssn);

	boolean isEmployeeSsnUnique(Long id, String ssn);

}
