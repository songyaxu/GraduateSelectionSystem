<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人信息 -教师</title>
		<link rel="stylesheet" type="text/css" href="../css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="../css/style.css"/>
	</head>
	<body>
		<div class="header">
			<div class="logo">
				<h4>内蒙古大学计算机学院毕业设计（论文）选题系统</h4>
			</div>
			<div class="navsmall">
				<ul>
					<li><a href="TeacherService!teacherIndex.action" class="active">首页</a></li>
					<li><a href="TopicChoice">选题系统</a></li>
				</ul>
			</div>
			<div class="info">
				<ul>
					<li><a href="TeacherService!logout.action">注销</a></li>
					<li><a href="TeacherService!teacherDetail.action">${teacher.name}</a></li>
					
				</ul>
			</div>
		</div>
		<div class="wrapper linear">
		
			<div class="container">
				<div class="nav">
					<details>
                		<summary class="myButton">个人信息</summary>
            			<ul>
                			<li><a href="TeacherService!teacherDetail.action">修改资料</a></li>
            			</ul>
            		</details>
            		<details>
                		<summary class="myButton">我的题目</summary>
            			<ul>
                			<li><a href="AddTopicInit">出题</a></li>
                			<li><a href="TopicService!checkTeaTopic.action">查看题目</a></li>
            			</ul>
            		</details>
            		<details>
            			<summary class="myButton">留言建议</summary>
            			<ul>
            				<li><a href="SearchMessage!checkMessage.action">查看留言</a></li>
            				<li><a href="MessageAction!writeInit.action">写留言</a></li>
            			</ul>
            		</details>
            		<details>
            			<summary class="myButton"><a href="NoticeIndex">通知公告</a></summary>
            		</details>
            		<details>
            			<summary class="myButton"><a href="TeacherService!teacherIndex.action">返回首页</a></summary>
            		</details>
				</div>
				<div class="right">
					<div class="head">
						<div class="notice">
							<ul>
								<li style="float: left;"><img src="../images/notice.png"/></li>
								<li class="noticeli">
									<marquee scrollamount=3 font style="COLOR=FF0000; FILTER: shadow(color=FFFF33 ); font-size: 9pt; WIDTH: 100%">
									<s:property value="#session.scrolling"/>
									</marquee>
								</li>						
							</ul>						
						</div>
						<div class="search">
							<div class="searchhead">
								<h2>个人信息</h2>
							</div>
							
						</div>
					</div>
					<div class="table">
						<form action="TeacherInfo!update.action">
							<div class="article">
								<ul>
								<li style="color: #FFFFFF;"><s:property value="message"/></li>
								</ul>
								<ul class="baseinfo">
									<li>学号<input type="text" name="teacher.id" value="<s:property value="#request.teacher.id"/> " readonly="readonly"/>&nbsp;&nbsp;&nbsp;姓名<input type="text" name="teacher.name" value="<s:property value="#request.teacher.name"/>" readonly="readonly" /></li>
									<li>性别<input type="text" name="teacher.gender" value="<s:property value="#request.teacher.gender"/>"/>&nbsp;&nbsp;&nbsp;
									职称
									<input type="text"  value="<s:property value="#session.position.name"/>" readonly="readonly"/></li>
									
									<li>手机<input type="text" name="teacher.phone" value="<s:property value="#request.teacher.phone"/>"/>&nbsp;&nbsp;&nbsp;
									领域<input type="text" value="<s:property value="#session.field.name"/>" readonly="readonly"/></li>
									<li>邮箱<input type="text" name="teacher.email" value="<s:property value="#request.teacher.email"/>"/>&nbsp;&nbsp;&nbsp;QQ<input type="text" name="teacher.qq" value="<s:property value="#request.teacher.qq"/>"/></li>
									<li></li>
								</ul>
								<div class="pagenav">
								<ul>
									<li><input type="submit" class="btu" value="修改信息"/></li>
									<li><a href="TeacherInfo!init.action" class="btu">修改密码</a></li>
								</ul>
								</div>
								
							</div>
							</form>
					</div>
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
