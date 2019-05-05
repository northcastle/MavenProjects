package com.whc.config;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.whc.model.Boss;
import com.whc.model.House;

//�����Զ�ɨ��İ�
@ComponentScan(value={"com.whc.mapper","com.whc.service.imple","com.whc.controller","com.whc.model"})
@Configuration
public class MainConfig08Autowired {
	
	@Autowired // ��ʱ��Ҳ����ʡ�����ע��
	@Bean("boss2")
	public Boss boss(House house){
		return new Boss(house);
	}
	
	
}
