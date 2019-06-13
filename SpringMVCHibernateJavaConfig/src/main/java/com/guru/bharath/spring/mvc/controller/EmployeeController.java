package com.guru.bharath.spring.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.bharath.spring.hibernate.model.Employee;
import com.guru.bharath.spring.hibernate.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		List<Employee> employees = employeeService.findAllEmployees();
		model.addAttribute("employees",employees);
		return "allEmployees";
	}
	
	@RequestMapping(value= {"/new"}, method=RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		return "registration";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			return "registration";
		}
		
		employeeService.saveEmployee(employee);
		model.addAttribute("success", "Employee "+employee.getEmployeeName()+" register successfully");
		return "success";
	}
	
	
	@RequestMapping(value= {"/edit-{ssn}-employee"}, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String ssn, ModelMap model) {
		Employee employee  = employeeService.findEmployeeBySsn(ssn);
		model.addAttribute("employee", employee);
		model.addAttribute("edit",true);
		return "registration";
	}
	
	@RequestMapping(value = {"/edit-{ssn}-employee"}, method = RequestMethod.PUT)
	public String updateEmployee(@Valid Employee employee, BindingResult result, @PathVariable String ssn, ModelMap map) {
		if(result.hasErrors()) {
			return "registration";
		}
		
		employeeService.updateEmployee(employee);
		map.addAttribute("success", "Employee " + employee.getEmployeeName()  + " updated successfully");
		return "success";
	}
	
	@RequestMapping(value= {"/delete-{ssn}-employee"})
	public String deleteEmployee(@PathVariable String ssn, ModelMap map) {
		employeeService.deleteEmployeeBySsn(ssn);
		return "redirect:/list";
	}
	
	
}
