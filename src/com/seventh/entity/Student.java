package com.seventh.entity;

import java.sql.Date;

public class Student {
	private String  id;
	private String password;
	private String name;
	private String gender;
	private Date birthday;
	private int classId;
	private String email;
	private String qq;
	private String phone;
	private int autoMatch;
	private int isMatched;
	private int choiceNum;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getAutoMatch() {
		return autoMatch;
	}
	public void setAutoMatch(int autoMatch) {
		this.autoMatch = autoMatch;
	}
	public int getIsMatched() {
		return isMatched;
	}
	public void setIsMatched(int isMatched) {
		this.isMatched = isMatched;
	}
	public int getChoiceNum() {
		return choiceNum;
	}
	public void setChoiceNum(int choiceNum) {
		this.choiceNum = choiceNum;
	}
	
}
