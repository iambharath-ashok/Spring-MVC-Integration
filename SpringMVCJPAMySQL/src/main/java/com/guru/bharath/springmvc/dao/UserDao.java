package com.guru.bharath.springmvc.dao;

import java.util.List;

import com.guru.bharath.springmvc.model.User;

public interface UserDao {

	List<User> findAllUsers();
	
	
}
