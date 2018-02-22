package com.meh.example.model;

public class UserModel {
	
	
	private String name;
	private String email;
	private String age;
	
	public UserModel(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public UserModel(String name, String email, String age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
