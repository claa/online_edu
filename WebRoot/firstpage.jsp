<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'firstpage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="font-size:30px;">
  		<center>这是首页<br><a href="postpage.jsp">去论坛</a></center>
  		<hr>
  		这是一堆课程，点击课程可以在课程下进行提问互动
  		<br>
		<a href="select_Forum?course_id=1&sign=<s:property value="%{#session.sign}"/>">课程一</a>
		<br>
		<br>
		<br>
		<a href="select_Forum?course_id=2&sign=<s:property value="%{#session.sign}"/>">课程二</a>
		<br>
		<br>
		<br>
		<hr>
		<a href="teacherReceiveInfo">老师收件箱</a>
  </body>
</html>
