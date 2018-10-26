package com.springdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springdemo.model.Users;
import com.springdemo.reposity.UsersReposity;
import com.springdemo.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersReposity usersReposity;
	
	@Override
	public Page<Users> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return usersReposity.findAll(pageable);
	}
}
