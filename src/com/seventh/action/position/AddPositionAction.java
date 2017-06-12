package com.seventh.action.position;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Position;
import com.seventh.service.PositionService;

@SuppressWarnings("serial")
public class AddPositionAction extends ActionSupport{
	private PositionService positionService;
	private Position position;
	private String message;
	public PositionService getPositionService() {
		return positionService;
	}
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute(){
		this.getPositionService().save(position);
		message="Ìí¼Ó³É¹¦";
		return SUCCESS;
	}
}
