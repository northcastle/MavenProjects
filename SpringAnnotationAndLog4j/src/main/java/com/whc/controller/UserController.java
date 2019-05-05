package com.whc.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.whc.service.UserService;

@Controller
public class UserController {
	
	//我在这里自动装配一个UserService
	//当有多个UserService的实现类的时候，可以使用@Qualifier()的方式直接明确指定使用哪一个实现类进行操作
	//@Qualifier(value="userServiceImpl2")
	//@Autowired
	
	//可以使用@Resource直接指定名称进行装配
	@Resource(name="userServiceImpl2")
	private UserService service;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "UserController [service=" + service + "]";
	}
	
	

}
