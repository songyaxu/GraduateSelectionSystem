<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户信息 -学生</title>
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
					<li><a href="StudentService!studentIndex.action" class="active">首页</a></li>
					<li><a href="TopicChoice">选题系统</a></li>
				</ul>
			</div>
			<div class="info">
				<ul>
					<li><a href="StudentService!logout.action">注销</a></li>
					<li><a href="studentInfo">${session.student.name}</a></li>
					
				</ul>
			</div>
		</div>
		<div class="wrapper linear">
		
			<div class="container">
				<div class="nav">
					<details>
                		<summary class="myButton">个人信息</summary>
            			<ul>
                			<li><a href="studentInfo">修改资料</a></li>
            			</ul>
            		</details>
            		<details>
                		<summary class="myButton">选题管理</summary>
            			<ul>
            				<li><a href="TopicService!checkStuTopic.action">我的选题</a></li>
                			<li><a href="StuAddTopicInit">自主选题</a></li>
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
            			<summary class="myButton"><a href="StudentService!studentIndex.action">返回首页</a></summary>
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
								<h2>用户信息</h2>
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
									<s:if test="#request.userType=='teacher'">
									<li>学号:<label><s:property value="#request.teacher.id"/></label>&nbsp;&nbsp;&nbsp;姓名:<label><s:property value="#request.teacher.name"/></label></li>
									<li>性别:<label><s:property value="#request.teacher.gender"/></label>&nbsp;&nbsp;&nbsp;职称:<label><s:property value="#request.position.name"/></label></li>
									<li>手机:<label><s:property value="#request.teacher.phone"/></label>&nbsp;&nbsp;&nbsp;领域:<label><s:property value="#request.field.name"/></label></li>
									<li>邮箱:<label><s:property value="#request.teacher.email"/></label>&nbsp;&nbsp;&nbsp;QQ:<label><s:property value="#request.teacher.qq"/></label></li>
									<s:if test="#request.teacher.qq!=null"><li><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=<s:property value="#request.teacher.qq"/>&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:<s:property value="#request.teacher.qq"/>:51" alt="点击这里给我发消息" title="点击这里给我发消息"/></a></li></s:if>
									</s:if>
									<s:if test="#request.userType=='student'">
										<li>学号:<label><s:property value="#request.student.id"/></label>&nbsp;&nbsp;&nbsp;姓名:<label><s:property value="#request.student.name"/></label></li>
										<li>性别:<label><s:property value="#request.student.gender"/></label>&nbsp;&nbsp;&nbsp;生日:<label><s:property value="#request.student.birthday"/></label></li>
										<li>专业:<label><s:property value="#request.major.name"/></label>&nbsp;&nbsp;&nbsp;班级:<label><s:property value="#request.clazz.name"/></label></li>
										<li>邮箱:<label><s:property value="#request.student.email"/></label>&nbsp;&nbsp;&nbsp;QQ:<label><s:property value="#request.student.qq"/></label></li>
									<s:if test="#request.student.qq!=''"><li><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=<s:property value="#request.student.qq"/>&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:<s:property value="#request.student.qq"/>:51" alt="点击这里给我发消息" title="点击这里给我发消息"/></a></li></s:if>
									</s:if>
									<s:if test="#request.userType=='admin'">
										<li>ID:<label><s:property value="#request.admin.id"/></label></li>
									<li>昵称:<label><s:property value="#request.admin.name"/></label></li>
									</s:if>
								</ul>
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
