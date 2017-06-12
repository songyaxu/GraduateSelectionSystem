<%@page import="com.seventh.util.TimeUtil"%>
<%@page import="com.seventh.entity.Topic"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>选题详情-管理员</title>
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
					<li><a href="AdminService!adminIndex.action" class="active">首页</a></li>
					<li><a href="TopicManage">选题管理</a></li>
					
				</ul>
			</div>
			<div class="info">
				<ul>
					<li><a href="AdminService!logout.action">注销</a></li>
					<li><a href="adminInfo">${admin.name}</a></li>
					
				</ul>
			</div>
		</div>
		<div class="wrapper linear">
		
			<div class="container">
				<div class="nav">
					<details>
                		<summary class="myButton">个人信息</summary>
            			<ul>
                			<li><a href="adminInfo">修改资料</a></li>
            			</ul>
            		</details>
            		<details>
                		<summary class="myButton">学生管理</summary>
            			<ul>
                			<li><a href="majorService!checkMajor.action">专业管理</a></li>
                			<li><a href="majorService!checkMajor.action">班级管理</a></li>
                			<li><a href="majorService!checkMajor.action">学生管理</a></li>
                			<li><a href="addStudentInit">添加学生</a></li>
            			</ul>
            		</details>
            		<details>
            			<summary class="myButton">教师管理</summary>
            			<ul>
            				<li><a href="fieldService">领域管理</a></li>
            				<li><a href="positionService">职称管理</a></li>
            				<li><a href="TeacherManage">教师管理</a></li>
            				<li><a href="addteacherInit">添加教师</a></li>
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
            			<summary class="myButton">通知管理</summary>
            			<ul>
            				<li><a href="NoticeIndex">查看通知</a></li>
            				<li><a href="AddNoticeInit">发布通知</a></li>
            				<li><a href="configService">滚动信息</a></li>
						</ul>
            		</details>
            		<details>
            			<summary class="myButton">设置管理</summary>
            			<ul>
            				<li><a href="configService!config.action">选题设置</a></li>
            				
						</ul>
            		</details>
            		<details>
            			<summary class="myButton"><a href="AdminService!adminIndex.action">返回首页</a></summary>
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
								<h2>选题详情</h2>
							</div>
						</div>
					</div>
					<div class="table">
						<div class="article" style="text-align:center;vertical-align:middle">
							<table class="tablestyle">
								<tr style="color: #FFFFFF; width: 100%; background: #4169E1;">
									<td width="100%">选题详情</td>
								</tr>
								<tr>
									<td>
										<table class="tablestyle">
											<tr>
											<s:if test="#request.topic.isStuApply==0">
												<td>邮箱:<s:property value="#request.teacher.email"/> </td>
												<td>手机：<s:property value="#request.teacher.phone"/></td>
												<td>QQ：<s:property value="#request.teacher.qq"/></td>
											</s:if>
											<s:if test="#request.topic.isStuApply==1">
												<td>邮箱:<s:property value="#request.student.email"/> </td>
												<td>手机：<s:property value="#request.student.phone"/></td>
												<td>QQ：<s:property value="#request.student.qq"/></td>
											</s:if>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<table class="tablestyle">
											<tr>
											<td width="50%">选题名称:<s:property value="#request.topic.title"/> </td>
											<td width="20%">出题人：
												<s:if test="#request.topic.isStuApply==0"><a href="UserInfo.action?id=<s:property value="#request.teacher.id"/>&userType=teacher"><s:property value="#request.teacher.name"/></a></s:if>
												<s:if test="#request.topic.isStuApply==1"><a href="UserInfo.action?id=<s:property value="#request.student.id"/>&userType=student"><s:property value="#request.student.name"/></a></s:if>
											</td>
											<td width="30%">是否为学生自题：
												<s:if test="#request.topic.isStuApply==0">否</s:if>
												<s:if test="#request.topic.isStuApply==1">是</s:if>
											</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td height="250px" style=" vertical-align: top; overflow-y: auto;">内容：<br/>
										<% out.println(((Topic)request.getAttribute("topic")).getContent());%>
									</td>
								</tr>
								<tr>
									<td height="100px" style=" vertical-align: top;">描述：<br/>
										<s:property value="#request.topic.description"/>
									</td>
								</tr>
								<tr>
									<td>环境：<br/>
										<s:property value="#request.topic.environment"/>
									</td>
								</tr>
								<tr>
									<td>
										<table class="tablestyle">
											<tr>
											<td>难度：<s:property value="#request.topic.difficulty"/></td>
											<td>需要人数：<s:property value="#request.topic.needNum"/></td>
											<td>研究方向:<s:property value="#request.field.name"/></td>
											<td>是否被确定:
												<s:if test="#request.topic.state==0">否</s:if>
												<s:if test="#request.topic.state==1">是</s:if>
											</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<table class="tablestyle">
											<tr>
											<td>已选择人数：<s:property value="#request.topic.applyNum"/></td>
											<td>是否可选：<s:property value="#request.topic.isEnable"/></td>
											<td>选题方式:
												<s:if test="#request.topic.isAutoMatch==0">自选</s:if>
												<s:if test="#request.topic.isAutoMatch==1">匹配</s:if>
											<td>发布时间:
												<%=TimeUtil.getTimeWithoutMilliSecond(((Topic)request.getAttribute("topic")).getCreatetime()) %>
											</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<a href="TopicManage" class="btu">返回</a>
						</div>
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
