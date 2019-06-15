package com.guru.bharath.springmvcform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.bharath.springmvcform.dao.EmployeeDao;
import com.guru.bharath.springmvcform.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeDao dao;
	
	
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}
	
	
	public List<Employee> getEmployeeList() {
		return dao.findAllEmployeeList();
	}
	
}
