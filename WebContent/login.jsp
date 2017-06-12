<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>内蒙古大学计算机学院毕业设计（论文）选题系统</title>
		<link rel="stylesheet" type="text/css" href="/GraduateSelectionSystem/css/login.css"/>
		<link rel="stylesheet" type="text/css" href="/GraduateSelectionSystem/css/reset.css"/>
	</head>
	<script type='text/javascript'>
			function login(){
				 if(document.loginform.id.value == ""){
					alert("请输入您的帐号");
					document.loginform.id.focus();
					return;
			     }
				 if(documet.loginform.id.value.length<4){
					 alert("账号长度过短");
					 document.loginform.id.focus();
					 return;
				 }
				if(document.loginform.password.value == ""){
					alert("请输入您的密码");
					document.loginform.password.focus();
					return;
			     }
				document.loginform.submit();
			}
	</script>
	<body>
		<div class="header">
			<h1>内蒙古大学计算机学院毕业设计（论文）选题系统</h1>
		</div>
		<div class="wrapper linear">
			
			<div class="loginleft">
				<div style="float: left;">
					<img src="/GraduateSelectionSystem/images/loginpic.jpg"/>					
				</div>
				<div class="notification" style="float: right;">
					<div class="notice">
					<ul>
						<li style="float: left;"><img src="/GraduateSelectionSystem/images/notice.png"/></li>
						<li class="noticeli">
							<marquee scrollamount=3 font style="COLOR=FF0000; FILTER: shadow(color=FFFF33 ); font-size: 9pt; WIDTH: 100%">
								<s:property value="#session.scrolling"/>
							</marquee>
						</li>						
					</ul>						
					</div>
					<div class="noticeitem">
						<div style="height: 22px; border-bottom: 1px solid;padding:5px 5px;">
							<span style="float: left;"><h2>公告通知</h2></span>	
							<span style="float: right;"><a href="NoticeService!more.action">更多</a></span>
						</div>
						<div class="noticeitem_list">
							<ul>	
								<s:iterator value="#request.indexnotices" id="notices">
									<li><a href="DetailNotice.action?id=<s:property value="#notices.id" />"><s:property value="#notices.title" /></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="loginright">
				<h2>账号登录</h2>
				<form name="loginform" action="Login">
					<div id="" class="logininput">
						<ul>
							<li style="float: left;"><img src="/GraduateSelectionSystem/images/user.png"/></li>
							<li style="float: right;"><input type="text" name="id" id="id" placeholder=" 请输入账号"/></li>
						</ul>
					</div>
					<div id="" class="logininput">
						<ul>
							<li style="float: left;"><img src="/GraduateSelectionSystem/images/password.png"/></li>
							<li style="float: right;"><input type="password" name="password" id="password" placeholder=" 请输入密码"/></li>
						</ul>
					</div>
					<div id="" class="loginbut">
						<input class="myButton" type="submit" value="提交" onClick="login(); return false;" style=" margin-left: 20px;float: left;"/>
						<input class="myButton" type="reset" value="重置" style="margin-right: 20px;float: right;"/>
					</div>
					<div class="msg">
						<p><s:property value="message" /></p>
					</div>
				</form>
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