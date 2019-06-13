package com.guru.bharath.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.bharath.dao.EmployeeDao;
import com.guru.bharath.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}

}
