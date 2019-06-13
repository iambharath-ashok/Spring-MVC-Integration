package com.guru.bharath.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.bharath.springmvc.model.User;
import com.guru.bharath.springmvc.service.UserService;

@Controller
@RequestMapping({ "/", "/user" })
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	public String listAllUsers(ModelMap modelMap) {
		List<User> users = userService.findAllUsers();
		modelMap.addAttribute("users", users);
		return "usersList";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		return "home";
	}

}
