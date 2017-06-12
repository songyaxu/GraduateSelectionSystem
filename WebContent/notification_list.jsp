<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>通知公告</title>
		<link rel="stylesheet" type="text/css" href="/GraduateSelectionSystem/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="/GraduateSelectionSystem/css/login.css"/>
	</head>
	<body>
		<div class="header">
			<h1>内蒙古大学计算机学院毕业设计（论文）选题系统</h1>
		</div>
		<div class="wrapper linear">	
			<div class="page">
				<p><a href="NoticeService">首页</a>/<a href="NoticeService!more.action">公告通知</a></p>
			</div>
			<div class="article">
				<h2 align="center" style="color: #FFFFFF;">公告通知</h2>
				<ul class="articleitem">
					<s:iterator value="#request.notices" id="notices">
									<li><a href="DetailNotice.action?id=<s:property value="#notices.id" />"><s:property value="#notices.title" /></a></li>
					</s:iterator>
					
				</ul>
				<ul>
					<li style="color: #F5F5F5; border: none; font-size: 14px; margin-top: 9px;">总记录数：<s:property value="noticePage.totalCount" /> &nbsp;&nbsp;每页记录数：<s:property value="noticePage.everyPage" /> 
						&nbsp;&nbsp;总页数：<s:property value="noticePage.totalPage" />&nbsp;&nbsp;当前位置：第<s:property value="noticePage.currentPage" />页
						
					<li>
				</ul>
			</div>
			<div class="pagenav">
					<ul>
						<s:if test="#request.noticePage.hasPrePage==true">
						<li><a href="NoticeService!frontPage.action?currentPage=<s:property value="noticePage.currentPage" />" class="btu">上一页</a></li>
						</s:if>
						<li><a href="#" class="btu active"><s:property value="noticePage.currentPage" /></a></li>
						<s:if test="#request.noticePage.currentPage+1<=#request.noticePage.totalPage">
						<li><a href="NoticeService!nextPage.action?currentPage=<s:property value="noticePage.currentPage" />" class="btu"><s:property value="noticePage.currentPage+1" /></a></li>
						</s:if>
						<s:if test="#request.noticePage.currentPage+2<=#request.noticePage.totalPage">
						<li><a href="NoticeService!nextPage.action?currentPage=<s:property value="noticePage.currentPage+1" />" class="btu"><s:property value="noticePage.currentPage+2" /></a></li>
						</s:if>
						<s:if test="#request.noticePage.currentPage+3<=#request.noticePage.totalPage">
						<li><a href="NoticeService!nextPage.action?currentPage=<s:property value="noticePage.currentPage+2" />" class="btu"><s:property value="noticePage.currentPage+3" /></a></li>
						</s:if>
						<s:if test="#request.noticePage.hasNextPage==true">
						<li><a href="NoticeService!nextPage.action?currentPage=<s:property value="noticePage.currentPage" />" class="btu">下一页</a></li>
						<li><a href="NoticeService!nextPage.action?currentPage=<s:property value="noticePage.totalPage-1" />" class="btu">最后一页</a></li>
						</s:if>
					</ul>
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
