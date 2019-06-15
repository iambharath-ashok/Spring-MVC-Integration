package com.guru.bharath.springmvcform.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.guru.bharath.springmvcform.model.Employee;

@Repository
public class EmployeeDao {

	
	List<Employee> employeeList = new ArrayList();
	
	
	public void saveEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	
	public List<Employee> findAllEmployeeList() {
		Employee emp1 = new Employee();
		emp1.setFirstName("bharath");
		emp1.setLastName("ashok");
		emp1.setEmail("bharath@iambh.com");
		
		Employee emp2 = new Employee();
		emp2.setFirstName("Sharath");
		emp2.setLastName("ashok");
		emp2.setEmail("sharath@iambh.com");
		employeeList.addAll(Arrays.asList(emp1, emp2));
		return employeeList;
	}
	
	
	
}
