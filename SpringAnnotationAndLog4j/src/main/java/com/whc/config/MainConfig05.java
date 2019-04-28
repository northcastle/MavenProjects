package com.whc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig05 {
	
	@Bean("colorFactoryBean")
	public MyColorFactoryBean myColorFactoryBean(){
		return new MyColorFactoryBean();
	}

}
