package com.guru.bharath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	
	@GetMapping("/")
	public ModelAndView welcome(ModelMap map) throws ApplicationException {
		ExceptionThrower();
		return new ModelAndView("welcome");
	}
	
	private void ExceptionThrower() throws ApplicationException {
		throw new ApplicationException();
	}
	
}
