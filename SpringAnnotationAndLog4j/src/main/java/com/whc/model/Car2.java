package com.whc.model;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javafx.fxml.Initializable;

@Component
public class Car2 implements InitializingBean, DisposableBean {
	
	public Car2() {
		// TODO Auto-generated constructor stub
		System.out.println("Car2 ... Contructor...");
	}

	//������൱���� ���ٷ���
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Car2 ... Destroy...");
	}
	//����൱���ǳ�ʼ������
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Car2 ...Initiaolize...");
	}



}
