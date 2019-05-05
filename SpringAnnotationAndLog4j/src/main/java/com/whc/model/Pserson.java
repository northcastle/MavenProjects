package com.whc.model;

import org.springframework.beans.factory.annotation.Value;

public class Pserson {
	
	@Value("ÕÅÈý")
	private String name;
	@Value("#{20-2}")
	private int age;
	@Value("${person.nickname}")
	private String nickname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Pserson [name=" + name + ", age=" + age + ", nickname=" + nickname + "]";
	}
	public Pserson(String name, int age, String nickname) {
		super();
		this.name = name;
		this.age = age;
		this.nickname = nickname;
	}
	public Pserson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
