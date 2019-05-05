package com.whc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.whc.model.Pserson;

@PropertySource(value={"classpath:person.properties"})
@Configuration
public class MainConfig07PropertyValue {
	
	@Bean("person")
	public Pserson pserson(){
		return new Pserson();
	}

}
