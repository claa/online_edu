<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectPost.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		<s:debug></s:debug>
  		<a href="sendPost.jsp?major_id=<s:property value="major_id"/>">发帖</a><br>
  		<hr>
  		本学院老师信息
  		<s:iterator value="teacherList" var="teacher">
	  		<a href="studentQuestion.jsp?courseId=<s:property value="#teacher.course_id"/>">
	  			<ul>
		   			<li><s:property value="#teacher.t_id"/></li>
		   			<li><s:property value="#teacher.t_username"/></li>
		   			<li><s:property value="#teacher.t_no"/></li>
		   			<li><s:property value="#teacher.t_Email"/></li>
		   			<li><s:property value="#teacher.t_introduce"/></li>
		   			<li><s:property value="#teacher.t_major"/></li>
		   			<li><s:property value="#teacher.course_id"/></li>
	   			</ul>
	   		</a>
  		</s:iterator>
  		<hr>
  		这是本专业所有帖子
  		<br>
	  	<s:iterator value="postList" var="posts">
	  		<s:property value="#posts.post_id"/>
	  		<s:if test="#posts.sender_sign==1">
	  			<p>
			  		<a style="color:red;font-weight: " href="post_showPostContent?post_id=<s:property value="#posts.post_id"/>&sender_id=<s:property value="#posts.sender_id"/>&sender_sign=<s:property value="#posts.sender_sign"/>&reply_id=<s:property value="#posts.reply_id"/>">
			  			<s:property value="#posts.post_title"/>
			  			<s:property value="#posts.post_time.toString().substring(0,#posts.post_time.toString().lastIndexOf('.'))"/>
			  			<s:property value="#posts.sender_id"/>
			  			<s:property value="#posts.sender_sign"/>
			  		</a>
	  			</p>
	  		</s:if>
	  		<p>
		  		<a href="post_showPostContent?post_id=<s:property value="#posts.post_id"/>&sender_id=<s:property value="#posts.sender_id"/>&sender_sign=<s:property value="#posts.sender_sign"/>&reply_id=<s:property value="#posts.reply_id"/>">
		  			<s:property value="#posts.post_title"/>
		  			<s:property value="#posts.post_time.toString().substring(0,#posts.post_time.toString().lastIndexOf('.'))"/>
		  			<s:property value="#posts.sender_id"/>
		  			<s:property value="#posts.sender_sign"/>
		  		</a>
	  		</p>
	    </s:iterator>
  </body>
</html>
