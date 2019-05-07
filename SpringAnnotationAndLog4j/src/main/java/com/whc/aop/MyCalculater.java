package com.whc.aop;

import org.springframework.stereotype.Component;

/**
 * 这是一个业务逻辑类：用来做一个除法运算
 * @author 10156234c
 *
 */
@Component("MyCalculater")
public class MyCalculater {
	
	//这里有一个计算除法的方法
	public double division(double a,double b){
		return a/b;
	}
	
	public int division2(int a,int b){
		return a/b;
	}

}
