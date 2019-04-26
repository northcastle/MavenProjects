package com.whc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.whc.condition.LinuxCondition;
import com.whc.condition.WindowCondition;
import com.whc.model.User;

@Configuration
public class MainConfig03 {
	
	@Bean("user")
	public User user(){
		return new User("普通人", 18);
	}
	
	//在这里加上window的条件进行选择性的注册组件
	@Conditional({WindowCondition.class})
	@Bean("Bill")
	public User Bill(){
		return new User("Bill Gates", 62);
	}
	
	@Conditional({LinuxCondition.class})
	@Bean("Linus")
	public User Linux(){
		return new User("Linux", 48);
	}

}
