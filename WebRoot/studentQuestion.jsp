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
    
    <title>My JSP 'studentQuestion.jsp' starting page</title>
    
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
  	<center style="font-size:30px;">给老师邮箱发问题</center>
  	<hr>
    <s:form action="addStudent" method="post">
    	<s:hidden name="courseId" value="%{#parameters.courseId}"></s:hidden>
    	<s:textarea name="prletter_content" style="width:500px;height:200px;overflow:hidden;font-size:20px;" value="请输入想问的问题（0/300）" onfocus="javascript:if(this.value=='请输入想问的问题（0/300）')this.value='';" onblur="javascript:if(this.value=='')this.value='请输入想问的问题（0/300）';"></s:textarea>
    	<s:submit value="提问"></s:submit>
    </s:form>
  </body>
</html>
