package com.springdemo.reposity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.model.Users;

//@Repository
public interface UsersReposity extends PagingAndSortingRepository< Users,Integer>{

	public Page<Users> findAll(Pageable pageable) ;
}
