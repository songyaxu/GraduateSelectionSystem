package com.seventh.entity;

public class Config{
	private int id;
	private int stuMaxChoiceNum;
	private String scrollingNotice;
	private int teaGuidanceNum; //教师平均指导数
	private int teaMinTopicNum;  //教师最少出题数
	private int topicChoiceLimit;
	public int getStuMaxChoiceNum() {
		return stuMaxChoiceNum;
	}
	public void setStuMaxChoiceNum(int stuMaxChoiceNum) {
		this.stuMaxChoiceNum = stuMaxChoiceNum;
	}
	public String getScrollingNotice() {
		return scrollingNotice;
	}
	public void setScrollingNotice(String scrollingNotice) {
		this.scrollingNotice = scrollingNotice;
	}
	
	public int getTeaGuidanceNum() {
		return teaGuidanceNum;
	}
	public void setTeaGuidanceNum(int teaGuidanceNum) {
		this.teaGuidanceNum = teaGuidanceNum;
	}
	public int getTeaMinTopicNum() {
		return teaMinTopicNum;
	}
	public void setTeaMinTopicNum(int teaMinTopicNum) {
		this.teaMinTopicNum = teaMinTopicNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTopicChoiceLimit() {
		return topicChoiceLimit;
	}
	public void setTopicChoiceLimit(int topicChoiceLimit) {
		this.topicChoiceLimit = topicChoiceLimit;
	}
	
}
