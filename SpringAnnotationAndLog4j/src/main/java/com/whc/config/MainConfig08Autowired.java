package com.whc.config;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.whc.model.Boss;
import com.whc.model.House;

//配置自动扫描的包
@ComponentScan(value={"com.whc.mapper","com.whc.service.imple","com.whc.controller","com.whc.model"})
@Configuration
public class MainConfig08Autowired {
	
	@Autowired // 此时，也可以省略这个注解
	@Bean("boss2")
	public Boss boss(House house){
		return new Boss(house);
	}
	
	
}
