package com.whc.service.imple;

import org.junit.validator.ValidateWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.whc.model.User;
import com.whc.service.UserService;

//当这个@Service什么都不写的时候，名字默认是 类名的首字母小写userServiceImpl2
@Service
public class UserServiceImpl2 implements UserService {
	
	@Value("this is userserviceimpl2")
	private String servicename;
	
	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	


	@Override
	public String toString() {
		return "UserServiceImpl2 [servicename=" + servicename + "]";
	}

	@Override
	public User queryOneObject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
