package com.whc.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.mapper.UserMapper;
import com.whc.model.User;
import com.whc.service.UserService;

@Service("service1")
public class UserServiceImpl implements UserService {
	
	//我再这里自动装配一个mapper
	@Autowired(required=false)
	private UserMapper mapper;
	
	public UserMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public String toString() {
		return "UserServiceImpl [mapper=" + mapper + "]";
	}

	@Override
	public User queryOneObject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
