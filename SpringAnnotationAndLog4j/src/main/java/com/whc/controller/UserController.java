package com.whc.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.whc.service.UserService;

@Controller
public class UserController {
	
	//���������Զ�װ��һ��UserService
	//���ж��UserService��ʵ�����ʱ�򣬿���ʹ��@Qualifier()�ķ�ʽֱ����ȷָ��ʹ����һ��ʵ������в���
	//@Qualifier(value="userServiceImpl2")
	//@Autowired
	
	//����ʹ��@Resourceֱ��ָ�����ƽ���װ��
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
