<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的选题-教师</title>
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
								<h2>我的选题</h2>
							</div>
							
						</div>
					</div>
					<div class="table">
						<div class="article" style="text-align:center;vertical-align:middle">
							<table class="tablestyle">
								<tr style="color: #FFFFFF; width: 100%; background: #4169E1;">
									<td width="5%">ID</td>
									<td width="28%">选题名称</td>
									<td width="10%">选题方向</td>
									<td width="4%">难度</td>
									<td width="7%">选题人数</td>
									<td width="10%">审核</td>	
									<td width="6%">选题方式</td>
									<td width="8%">是否可选</td>
									<td width="8%">需要人数</td>
									<td width="12%">操作</td>		
															
								</tr>
								
								<s:iterator value="#request.topics" id="topic">
									<tr>
										<td><s:property value="#topic.id" /></td>
										<td><a href="topicdetail.action?id=<s:property value="#topic.id" />"><s:property value="#topic.title" /></a></td>
										<td>
											<s:iterator value="#request.fields" id="field">
												<s:if test="#field.id==#topic.fieldId">
													<s:property value="#field.name" />
												</s:if>
											</s:iterator>
										</td>
										<td><s:property value="#topic.difficulty" /></td>
										<td><a href="CheckChoice.action?id=<s:property value="#topic.id" />"><s:property value="#topic.applyNum" /></a></td>
										<td>
											<s:if test="#topic.isCheck==0">未审核</s:if>
											<s:if test="#topic.isCheck==1">审核未通过</s:if>
											<s:if test="#topic.isCheck==3">审核通过</s:if>
											<s:if test="#topic.isCheck==2">不可审核</s:if>
										</td>
										<td>
											<s:if test="#topic.isAutoMatch==0">自选</s:if>
											<s:if test="#topic.isAutoMatch==1">匹配</s:if>
										</td>
										<td>
											<s:if test="#topic.isEnable==0">可选</s:if>
											<s:if test="#topic.isEnable==1">不可选</s:if>
										</td>
										<td><s:property value="#topic.needNum" /></td>
										<td><a href="Topicedit!init.action?id=<s:property value="#topic.id" />">编辑</a></td>
									</tr>
								</s:iterator>
							</table>
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
