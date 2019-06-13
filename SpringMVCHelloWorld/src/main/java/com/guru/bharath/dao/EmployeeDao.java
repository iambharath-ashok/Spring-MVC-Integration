package com.guru.bharath.dao;

import java.util.List;

import com.guru.bharath.model.Employee;

public interface EmployeeDao {
	
	List<Employee> findAllEmployees();
	
	

}
