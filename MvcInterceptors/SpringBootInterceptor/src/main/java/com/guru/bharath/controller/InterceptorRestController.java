package com.guru.bharath.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorRestController {

	List<String> names = Arrays.asList("a", "b","c","d");
	
	
	@GetMapping("/users")
	public List<String> userList() {
		return names;
	}
}
