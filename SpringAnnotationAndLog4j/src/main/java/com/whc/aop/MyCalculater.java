package com.whc.aop;

import org.springframework.stereotype.Component;

/**
 * ����һ��ҵ���߼��ࣺ������һ����������
 * @author 10156234c
 *
 */
@Component("MyCalculater")
public class MyCalculater {
	
	//������һ����������ķ���
	public double division(double a,double b){
		return a/b;
	}
	
	public int division2(int a,int b){
		return a/b;
	}

}
