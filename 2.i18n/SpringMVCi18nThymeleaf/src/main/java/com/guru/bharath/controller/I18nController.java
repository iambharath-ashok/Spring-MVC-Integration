package com.guru.bharath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/i18n")
public class I18nController {

	@GetMapping("/international")
	public String getI18n() {
		return "international";
	}
	
}
