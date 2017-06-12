package com.seventh.action.notice;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Notice;
import com.seventh.service.NoticeService;
import com.seventh.util.TimeUtil;

@SuppressWarnings("serial")
public class AddNoticeAction extends ActionSupport{
	private NoticeService noticeService;
	private Notice notice;
	private String message;
	private String editorValue;
	public NoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getEditorValue() {
		return editorValue;
	}
	public void setEditorValue(String editorValue) {
		this.editorValue = editorValue;
	}
	public String execute(){
		this.notice.setAuthor("admin");
		this.notice.setContent(editorValue);
		this.notice.setCreateTime(TimeUtil.currentTime());
		this.noticeService.save(notice);
		message="发布成功";
		return SUCCESS;
	}
}
