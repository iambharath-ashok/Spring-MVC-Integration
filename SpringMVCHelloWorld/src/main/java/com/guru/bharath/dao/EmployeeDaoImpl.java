package com.guru.bharath.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.guru.bharath.model.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> findAllEmployees() {
		
		Employee employee1 = new Employee();
		employee1.setId(1l);
		employee1.setName("Bharath");
		employee1.setEmployeeId("AB40286");
		employee1.setSalary(900000d);
		employee1.setEmail("bharath.ashok@iambh.com");
		
		Employee employee2 = new Employee();
		employee2.setId(1l);
		employee2.setName("Bharath");
		employee2.setEmployeeId("AB40286");
		employee2.setSalary(900000d);
		employee2.setEmail("bharath.ashok@iambh.com");
		return Arrays.asList(employee1, employee2);
	}

}
