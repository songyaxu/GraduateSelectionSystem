package com.seventh.entity;

public class Admin {
	private String id;
	private String password;
	private String name;
	private int isSuper;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsSuper() {
		return isSuper;
	}
	public void setIsSuper(int isSuper) {
		this.isSuper = isSuper;
	} 
}
