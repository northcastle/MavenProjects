package com.whc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.whc.model.User;

@Configuration
public class MainConfig03 {
	
	@Bean("user")
	public User user(){
		return new User("∆’Õ®»À", 18);
	}
	
	@Bean("Bill")
	public User Bill(){
		return new User("Bill Gates", 62);
	}
	
	@Bean("Linus")
	public User Linux(){
		return new User("Linux", 48);
	}

}
