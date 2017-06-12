package com.seventh.entity;

public class Teacher {
	private String id;
	private String password;
	private String name;
	private String gender;
	private int positionId;
	private int fieldId;
	private int maxGuidanceNum;
	private int guidanceNum;
	private String qq;
	private String email;
	private String phone;
	private int questionNum;
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
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	
	public int getGuidanceNum() {
		return guidanceNum;
	}
	public void setGuidanceNum(int guidanceNum) {
		this.guidanceNum = guidanceNum;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMaxGuidanceNum() {
		return maxGuidanceNum;
	}
	public void setMaxGuidanceNum(int maxGuidanceNum) {
		this.maxGuidanceNum = maxGuidanceNum;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	
}
