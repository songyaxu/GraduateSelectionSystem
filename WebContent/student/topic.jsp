<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的选题-学生</title>
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
					<li><a href="studentInfo">${student.name}</a></li>
					
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
								<h2>我的选题</h2>
							</div>
							
						</div>
					</div>
					<div class="table">
						<div class="article" style="text-align:center;vertical-align:middle">
							<table class="tablestyle">
								<tr style="color: #FFFFFF; width: 100%; background: #4169E1;">
									<td>ID</td>
									<td>选题名称</td>
									<td>选题时间</td>	
									<td>状态</td>				
								</tr>
								
								<s:iterator value="#request.choiceMaps" id="choiceMap">
									<tr>
										<td><s:property value="#choiceMap.topicId" /></td>
										<td><a href="topicdetail.action?id=<s:property value="#choiceMap.topicId" />"><s:property value="#choiceMap.topicTitle" /></a></td>						
										<td><s:property value="#choiceMap.studentName" /></td>	
										<td>
											<s:if test="#choiceMap.state==0">未审核</s:if>
											<s:if test="#choiceMap.state==1">成功选题</s:if>
											<s:if test="#choiceMap.state==2">已被拒绝</s:if>
										</td>	
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
