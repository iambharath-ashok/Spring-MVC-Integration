package com.guru.bharath.springmvcform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.guru.bharath.springmvcform.model.Employee;
import com.guru.bharath.springmvcform.service.EmployeeService;

@Controller
@RequestMapping("/employee")
@SessionAttributes("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addEmployee(ModelMap map) {
		Employee employee = new Employee();
		map.addAttribute("employee", employee);
		return "registerEmployee";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee, BindingResult result, ModelMap map) {
		boolean error = false;
		if (employee.getFirstName().isEmpty()) {
			result.rejectValue("firstName", "error.firstName");
			error = true;
		}

		if (error) {
			return "registerEmployee";
		}
		service.saveEmployee(employee);
		return "redirect:list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) {
		map.addAttribute("employees", service.getEmployeeList());
		return "listEmployee";
	}

}
