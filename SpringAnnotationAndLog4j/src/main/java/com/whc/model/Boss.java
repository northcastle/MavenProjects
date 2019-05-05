package com.whc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("boss")
public class Boss {
	
	private House house;
	
	
	
	public Boss(@Autowired House house) {
		super();
		this.house = house;
	}

	public House getHouse() {
		return house;
	}

	//写在set方法上面，仍然是这两个注解的搭配使用
//	@Autowired
//	public void setHouse(@Qualifier("house") House house) {
//		this.house = house;
//	}
	
	public void setHouse(House house) {
		this.house = house;
	}
	

	@Override
	public String toString() {
		return "Boss [house=" + house + "]";
	}

	
	

}
