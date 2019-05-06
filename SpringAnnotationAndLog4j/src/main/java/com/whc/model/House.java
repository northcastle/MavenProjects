package com.whc.model;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("house")
public class House implements Aware{
	
	@Value("北京二环一套房")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "House [name=" + name + "]";
	}
	
	

}
