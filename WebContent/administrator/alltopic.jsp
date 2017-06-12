<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>选题管理-管理员</title>
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
					<li><a href="AdminService!adminIndex.action" >首页</a></li>
					<li><a href="TopicManage" class="active">选题管理</a></li>
					
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
								<h2>选题管理</h2>
							</div>
							<div class="searchtitle">
								<form action="SearchTopic">
								<ul>
									<li><label>ID:</label></li>
									<li><input type="text" name="id" /></li>
									<li><label>方向:</label></li>
									<li>
										<select name="fieldId">
							   	                <option value="" selected="selected">请选择</option>
											<s:iterator value="#request.fields" id="field">
													<option value="<s:property value="#field.id" />"><s:property value="#field.name" /></option>
											</s:iterator>
										</select>
									</li>
									<li><label>难度:</label></li>
									<li>
										<select name="difficulty">
							   	                <option value="" selected="selected">请选择</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
										</select>
									</li>
									<li><label>状态:</label></li>
									<li>
										<select name="state">
											<option value="" selected="selected">请选择</option>
											<option value="0">可选</option>
											<option value="1">不可选</option>
										</select>
									</li>
									<li><label>选题方式:</label></li>
									<li>
										<select name="matchType">
											<option  value="" selected="selected">请选择</option>
											<option value="0">自选</option>
											<option value="1">系统匹配</option>
										</select>
									</li>
									<li><label>审核:</label></li>
									<li><select name="check">
							   	                <option value="" selected="selected">请选择</option>
												<option value="0">未审核</option>
												<option value="1">未通过审核</option>
												<option value="2">不可审核</option>
												<option value="3">通过审核</option>
										</select>
									</li>
									<li><label>关键字:</label></li>
									<li><input type="text" name="name" /></li>
									<li><button class="searchBut" type="submit">搜索</button></li>
								</ul>
								</form>
							</div>
						</div>
					</div>
					<div class="table">
						<div class="article" style="text-align:center;vertical-align:middle">
								<ul>
									<li style="color: #FFFFFF;"><s:property value="pageMessage"/></li>
									<li style="color: #FFFFFF;"><s:property value="message"/></li>
								</ul>
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
									<td width="12%">审核</td>		
															
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
											<s:if test="#topic.isCheck==2">不可审核</s:if>
											<s:if test="#topic.isCheck==3">审核通过</s:if>
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
										<td>
											<s:if test="#topic.isCheck==3">已通过审核</s:if>
											<s:elseif test="#topic.isCheck==2">不可审核</s:elseif>
											<s:else>
												<a href="TopicManage!Pass.action?id=<s:property value="#topic.id" />">通过</a>&nbsp;&nbsp;&nbsp;
												<a href="TopicManage!NotPass.action?id=<s:property value="#topic.id" />">未通过</a>
											</s:else>
										</td>
									</tr>
								</s:iterator>
							</table>
							<ul>
								<li style="color: #F5F5F5; border: none; font-size: 14px; margin-top: 9px;">总记录数：<s:property value="#request.page.totalCount" /> &nbsp;&nbsp;每页记录数：<s:property value="#request.page.everyPage" /> 
									&nbsp;&nbsp;总页数：<s:property value="#request.page.totalPage" />&nbsp;&nbsp;当前位置：第<s:property value="#request.page.currentPage" />页
									
								<li>
							</ul>
						<div class="pagenav">
								<ul>
									<s:if test="#request.page.hasPrePage==true">
									<li><a href="TopicManage!frontPage.action?currentPage=<s:property value="#request.page.currentPage" />" class="btu">上一页</a></li>
									</s:if>
									<li><a href="#" class="btu active"><s:property value="#request.page.currentPage" /></a></li>
									<s:if test="#request.page.currentPage+1<=#request.page.totalPage">
									<li><a href="TopicManage!nextPage.action?currentPage=<s:property value="#request.page.currentPage" />" class="btu"><s:property value="#request.page.currentPage+1" /></a></li>
									</s:if>
									<s:if test="#request.page.currentPage+2<=#request.page.totalPage">
									<li><a href="TopicManage!nextPage.action?currentPage=<s:property value="#request.page.currentPage+1" />" class="btu"><s:property value="#request.page.currentPage+2" /></a></li>
									</s:if>
									<s:if test="#request.page.currentPage+3<=#request.page.totalPage">
									<li><a href="TopicManage!nextPage.action?currentPage=<s:property value="#request.page.currentPage+2" />" class="btu"><s:property value="#request.page.currentPage+3" /></a></li>
									</s:if>
									<s:if test="#request.page.hasNextPage==true">
									<li><a href="TopicManage!nextPage.action?currentPage=<s:property value="#request.page.currentPage" />" class="btu">下一页</a></li>
									<li><a href="TopicManage!nextPage.action?currentPage=<s:property value="#request.page.totalPage-1" />" class="btu">最后一页</a></li>
									</s:if>
								</ul>
							</div>
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
