<%@page import="com.seventh.entity.Topic"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
		<title>编辑选题-教师</title>
		<link rel="stylesheet" type="text/css" href="../css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="../css/style.css"/>
		<script type="text/javascript" charset="utf-8" src="../ueditor.config.js"></script>
    	<script type="text/javascript" charset="utf-8" src="../ueditor.all.min.js"> </script>
		<script type="text/javascript" charset="utf-8" src="../lang/zh-cn/zh-cn.js"></script>
	</head>
	<script type="text/javascript">
		function hide(){
			ue.setHide();
		}
		function show(){
			ue.setShow();
		}
	</script>
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
								<h2>编辑选题</h2>
							</div>
							
						</div>
					</div>
					<div class="table">
						<form action="Topicedit!update.action" name="sendform">
							
							<div class="article">
								<ul>
								<li style="color: #FFFFFF;"><s:property value="message"/></li>
								</ul>
								<ul class="linegap">
									<li>
									论文题目:<input type="text" style="height: 30px; width: 320px;" name="topic.title" value="<s:property value="#request.topic.title"/>" required="required"/>
									</li>
									<li>内容<input type="button" onclick="hide();" class="btu" value="隐藏编辑器"/> <input type="button" onclick="show();" class="btu" value="显示编辑器"/></li>
									<li>
										<div>
											<script id="editor" type="text/plain" style="width:100%;height:350px;">
											</script>
											<script type="text/javascript">
								        	var ue = UE.getEditor('editor');
								        	</script>
						   				</div>
									</li>
									<li>描述
										<textarea name="topic.description" cols="47" rows="3"><s:property value="#request.topic.description"/></textarea>
									</li>
									<input type="hidden" name="topic.id" value="<s:property value="#request.topic.id"/>"/>
									<li>环境
										<textarea name="topic.environment" cols="47" rows="3"><s:property value="#request.topic.environment"/></textarea>
									</li>
									<li>难度等级
										<select name="topic.difficulty"  style="height: 20px; width: 320px;">
							   	                <option value="<s:property value="#request.topic.difficulty"/>" selected="selected"><s:property value="#request.topic.difficulty"/></option>
								                <option value="1">1</option>
								                <option value="2">2</option>
								                <option value="3">3</option>
								                <option value="4">4</option>
								                <option value="5">5</option>
									    </select>
									</li>
									<li>需要人数
										<input type="text" name="topic.needNum" value="<s:property value="#request.topic.needNum"/>" style="height: 20px; width: 320px;"/>
									</li>
									<li>研究方向
										<select name="topic.fieldId"  style="height: 20px; width: 320px;">
							   	                <option value="<s:property value="#request.field.id"/>" selected="selected"><s:property value="#request.field.name"/></option>
							   	               	<s:iterator value="#request.fields" id="field">
								                	<option value="<s:property value="#field.id"/>"><s:property value="#field.name"/></option>
								                </s:iterator>
									    </select>
									</li>
								</ul>
								
						   		
								<div class="pagenav">
								<ul>
									
									<li><input type="submit" class="btu" value="发布"/></li>
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
