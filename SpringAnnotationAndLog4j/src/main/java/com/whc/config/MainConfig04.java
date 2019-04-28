package com.whc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.whc.model.Color;
import com.whc.model.User;

@Configuration
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})

public class MainConfig04 {
	
	@Bean("user01")
	public User user(){
		return new User("ËÎ½­",38);
	}

}
