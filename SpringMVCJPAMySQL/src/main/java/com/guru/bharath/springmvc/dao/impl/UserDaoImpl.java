package com.guru.bharath.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guru.bharath.springmvc.dao.AbstractDao;
import com.guru.bharath.springmvc.dao.UserDao;
import com.guru.bharath.springmvc.model.User;


@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public List<User> findAllUsers() {
		String query = "select u from User u";
		return (List<User>) getQuery(query).getResultList();
	}

}
