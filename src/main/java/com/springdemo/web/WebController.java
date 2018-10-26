package com.springdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.model.Users;
import com.springdemo.reposity.UsersReposity;
import com.springdemo.service.UsersService;



@Controller
public class WebController {
	@Value(value="${jdbc.url}")
	private String driver; 
	
	@Autowired
	UsersService u;
	
	@Autowired
	UsersReposity ur;
	
	@RequestMapping(value="/hi")
	public ModelAndView hi(){
		ModelAndView m = new ModelAndView("demol");
		m.addObject("name", "zha gsam");
		System.out.println(driver);
		return m;
	}
	
//	我们可以看到，我们只需要在方法的参数中直接定义一个pageable类型的参数，当Spring发现这个参数时，Spring会自动的根据request的参数来组装该pageable对象，Spring支持的request参数如下：
//
//	page，第几页，从0开始，默认为第0页
//	size，每一页的大小，默认为20
//	sort，排序相关的信息，以property,property(,ASC|DESC)的方式组织，例如sort=firstname&sort=lastname,desc表示在按firstname正序排列基础上按lastname倒序排列
	@GetMapping("/getUser")
	@ResponseBody
	public Page<Users> getUser(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) 
    Pageable pageable){
		System.out.println(ur.findById(1));
		Page<Users> us = u.findAll(pageable);
		System.out.println(us);
		return us;
	}
}
