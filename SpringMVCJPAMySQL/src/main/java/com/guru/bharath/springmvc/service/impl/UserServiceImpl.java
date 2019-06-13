package com.guru.bharath.springmvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.bharath.springmvc.dao.UserDao;
import com.guru.bharath.springmvc.model.User;
import com.guru.bharath.springmvc.service.UserService;


@Service	
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
	
}
