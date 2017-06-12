<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页-教师</title>
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
								<h2>写留言</h2>
							</div>
							
						</div>
					</div>
					<div class="table">
						<form action="MessageAction!send.action">
							<div class="article">
								<ul>
								<li style="color: #FFFFFF;"><s:property value="pageMessage"/></li>
								</ul>
								<ul>
									<li style="padding-left: 40px;">编号:<input type="text" name="message.sendId" value="<s:property value="#session.teacher.id"/> " readonly="readonly"/></li>
									<li style="padding-left: 40px;">姓名:<input type="text" name="message.sendName" value="<s:property value="#session.teacher.name"/>" readonly="readonly" /></li>
									<li style="padding-left: 40px;">接收人:
										<select name="type">
						   	                <option value="all" selected="selected">所有用户</option>
							                <option value="admin">管理员</option>
									        <option value="teacher">教师</option>
									        <option value="student">学生</option>
									    </select>
									</li>
									<li>（可以指定发给某一群体，通过不指定接收人ID）</li>
									<li style="padding-left: 40px;">接收人ID:<input type="text" name="message.receiveId"/></li>
								</ul>
									<input type="hidden" name="message.sendType" value="teacher"/>
								<div class="messagebody">
									<h3 style="color: #FFFFFF;">留言内容</h3>
									<textarea style="font-size: 15px;" cols="92" rows="13" required="true" name="message.content"></textarea>
								</div>
								<div class="pagenav">
								<ul>
									<li><input type="submit" class="btu" value="发送"/></li>
									<li><input type="reset" class="btu" value="重置"/></li>
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