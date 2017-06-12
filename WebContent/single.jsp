<%@page import="com.seventh.util.TimeUtil"%>
<%@page import="com.seventh.entity.Notice"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><s:property value="notice.title"/></title>
		<link rel="stylesheet" type="text/css" href="/GraduateSelectionSystem/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="/GraduateSelectionSystem/css/style.css"/>
	</head>
	<body>
		<div class="header">
			<h1>内蒙古大学计算机学院毕业设计（论文）选题系统</h1>
		</div>
		<div class="wrapper linear">
			<div class="page">
				<p><a href="NoticeService">首页</a>/<a href="NoticeService!more.action">公告通知</a>/<a href="DetailNotice.action?id=<s:property value="notice.id" />"><s:property value="notice.title"/></a></p>
			</div>
			<div class="context">
				<div class="title">
					<s:property value="notice.title"/>
				</div>
				<div class="time">
					发布时间：<%=TimeUtil.getTimeWithoutMilliSecond(((Notice)request.getAttribute("notice")).getCreateTime()) %>
				</div>
				<div class="articlebody">
					<% out.println(((Notice)request.getAttribute("notice")).getContent());%>
				</div>
			</div>
		</div>
		<div class="footer">
			<ul>
				<li><a href="#">关于我们</a></li>
				<li>|</li>
				<li>内蒙古大学计算机学院毕业设计（论文）选题系统</li>
				<li>Copyright</li>
				<li>&copy; 2016.</li>
			</ul>
		</div>
	</body>
</html>
