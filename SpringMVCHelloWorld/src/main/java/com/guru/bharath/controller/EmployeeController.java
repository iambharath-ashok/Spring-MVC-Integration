package com.guru.bharath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.bharath.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeSerivce;
	
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAllEmployees(ModelMap map) {
		map.addAttribute("employees",employeeSerivce.findAllEmployees());
		return "listEmployees";
	}

}
