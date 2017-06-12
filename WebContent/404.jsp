<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>404</title>
		<link rel="stylesheet" type="text/css" href="/GraduateSelectionSystem/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="/GraduateSelectionSystem/css/style.css"/>
	</head>
	<body>
		<div class="header">
			<h1>内蒙古大学计算机学院毕业设计（论文）选题系统</h1>
		</div>
		<div class="wrapper linear">
			
			<div class="context">
				<div class="title">
					无法访问相应页面，或网站没有此页面
				</div>
				<div class="time">
					<a href="login.html">点此进入登录界面</a>
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
