<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页-学生</title>
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
								<h2>首页公告</h2>
							</div>
							<div class="searchbody">
								<ul>
									<li><input type="text" id="keyword" /></li>
									<li><button class="searchBut" onclick="javascript:window.location.href='SearchNotice?keyword='+ document.getElementById('keyword').value" >搜索</button></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="table">
						<div class="article">
							<ul class="articleitem">
								<s:iterator value="#session.loginIndexnotices" id="notices">
									<li><a href="DetailNotice!stuDetail.action?id=<s:property value="#notices.id" />"><s:property value="#notices.title" /></a></li>
								</s:iterator>
							</ul>
							<ul>
								<li style="color: #F5F5F5; border: none; font-size: 14px; margin-top: 9px;">总记录数：<s:property value="#session.loginNoticePage.totalCount" /> &nbsp;&nbsp;每页记录数：<s:property value="#session.loginNoticePage.everyPage" /> 
									&nbsp;&nbsp;总页数：<s:property value="#session.loginNoticePage.totalPage" />&nbsp;&nbsp;当前位置：第<s:property value="#session.loginNoticePage.currentPage" />页
									
								<li>
							</ul>
						<div class="pagenav">
								<ul>
									<s:if test="#session.loginNoticePage.hasPrePage==true">
									<li><a href="NoticeIndex!frontPage.action?currentPage=<s:property value="#session.loginNoticePage.currentPage" />" class="btu">上一页</a></li>
									</s:if>
									<li><a href="#" class="btu active"><s:property value="#session.loginNoticePage.currentPage" /></a></li>
									<s:if test="#session.loginNoticePage.currentPage+1<=#session.loginNoticePage.totalPage">
									<li><a href="NoticeIndex!nextPage.action?currentPage=<s:property value="#session.loginNoticePage.currentPage" />" class="btu"><s:property value="#session.loginNoticePage.currentPage+1" /></a></li>
									</s:if>
									<s:if test="#session.loginNoticePage.currentPage+2<=#session.loginNoticePage.totalPage">
									<li><a href="NoticeIndex!nextPage.action?currentPage=<s:property value="#session.loginNoticePage.currentPage+1" />" class="btu"><s:property value="#session.loginNoticePage.currentPage+2" /></a></li>
									</s:if>
									<s:if test="#session.loginNoticePage.currentPage+3<=#session.loginNoticePage.totalPage">
									<li><a href="NoticeIndex!nextPage.action?currentPage=<s:property value="#session.loginNoticePage.currentPage+2" />" class="btu"><s:property value="#session.loginNoticePage.currentPage+3" /></a></li>
									</s:if>
									<s:if test="#session.loginNoticePage.hasNextPage==true">
									<li><a href="NoticeIndex!nextPage.action?currentPage=<s:property value="#session.loginNoticePage.currentPage" />" class="btu">下一页</a></li>
									<li><a href="NoticeIndex!nextPage.action?currentPage=<s:property value="#session.loginNoticePage.totalPage-1" />" class="btu">最后一页</a></li>
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
