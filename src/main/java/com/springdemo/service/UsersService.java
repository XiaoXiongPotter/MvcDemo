package com.springdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springdemo.model.Users;

public interface UsersService {

	public Page<Users> findAll(Pageable pageable);
}
