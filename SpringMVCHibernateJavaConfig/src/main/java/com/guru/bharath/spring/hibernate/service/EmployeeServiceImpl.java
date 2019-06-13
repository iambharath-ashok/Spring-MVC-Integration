package com.guru.bharath.spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guru.bharath.spring.hibernate.dao.EmployeeDao;
import com.guru.bharath.spring.hibernate.model.Employee;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee findById(Long id) {
		return employeeDao.findEmployeeById(id);
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		return employeeDao.findEmployeeBySsn(ssn);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		employeeDao.deleteEmployeeBySsn(ssn);
	}

	@Override
	public boolean isEmployeeSsnUnique(Long id, String ssn) {
		Employee employee = employeeDao.findEmployeeBySsn(ssn);
		return (employee == null || ((id != null) && (employee.getId() == id)));
	}

}
