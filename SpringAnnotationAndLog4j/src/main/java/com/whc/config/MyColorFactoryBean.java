package com.whc.config;

import org.springframework.beans.factory.FactoryBean;

import com.whc.model.Color;

public class MyColorFactoryBean implements FactoryBean<Color> {

	@Override
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
