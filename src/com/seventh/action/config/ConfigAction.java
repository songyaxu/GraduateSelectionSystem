package com.seventh.action.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Config;
import com.seventh.service.ConfigService;

@SuppressWarnings("serial")
public class ConfigAction extends ActionSupport{
	private ConfigService configService;
	private Config config;
	private String message;
	
	public ConfigService getConfigService() {
		return configService;
	}

	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute(){
		config=this.getConfigService().init();
		return SUCCESS;
	}
	public String update(){
		Config s=this.configService.init();
		s.setScrollingNotice(config.getScrollingNotice());
		message="修改成功";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("scrolling", s.getScrollingNotice());
		this.getConfigService().update(s);
		return "update";
	}
	public String config(){
		config=this.getConfigService().init();
		return "config";
	}
	public String configupdate(){
		Config s=this.configService.init();
		s.setStuMaxChoiceNum(config.getStuMaxChoiceNum());
		s.setTeaGuidanceNum(config.getTeaGuidanceNum());
		s.setTeaMinTopicNum(config.getTeaMinTopicNum());
		s.setTopicChoiceLimit(config.getTopicChoiceLimit());
		this.configService.update(s);
		message="修改成功";
		return "modify";
	}
}
