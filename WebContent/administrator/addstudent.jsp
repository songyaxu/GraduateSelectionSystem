<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加学生 -管理员</title>
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
								<h2>添加学生</h2>
							</div>
							
						</div>
					</div>
					<div class="table">
						<form action="addStudent">
							<div class="article">
								<ul>
								<li style="color: #FFFFFF;"><s:property value="message"/></li>
								</ul>
								<ul class="baseinfo">
									<s:token></s:token>
									<s:actionerror/>
									<li>学号<input type="text" name="student.id" value="" required="required"/>&nbsp;&nbsp;&nbsp;姓名<input type="text" name="student.name" value="" required="required"/></li>
									<li>性别<input type="text" name="student.gender" value=""/>&nbsp;&nbsp;&nbsp;生日<input type="text" name="student.birthday" value=""/></li>
									<li>手机<input type="text" name="student.phone" value=""/>&nbsp;&nbsp;&nbsp;
										班级
										<select name="student.classId">
							   	                <option value="-1" selected="selected">请选择</option>
							   	               	<s:iterator value="#request.clazzs" id="clazz">
								                	 <s:iterator value="#request.majors" id="major">
								                		<s:if test="#major.id==#clazz.majorId">
								                			<option value="<s:property value="#clazz.id"/>"><s:property value="#major.name"/><s:property value="#clazz.name"/></option>
								                		</s:if>
								                	</s:iterator>
								                </s:iterator>
									    </select>
									</li>
									<li>邮箱<input type="text" name="student.email" value=""/>&nbsp;&nbsp;&nbsp;QQ<input type="text" name="student.qq" value=""/></li>
								</ul>
								<input type="hidden" name="student.password" value="<s:property value="#request.student.password"/>"/>
								<input type="hidden" name="student.autoMatch" value="<s:property value="#request.student.autoMatch"/>"/>
								<input type="hidden" name="student.isMatched" value="<s:property value="#request.student.isMatched"/>"/>
								<div class="pagenav">
								<ul>
									<li><input type="submit" class="btu" value="提交信息"/></li>
									<li><a href="" class="btu">批量添加</a></li>
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
