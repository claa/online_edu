<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sendPost.jsp' starting page</title>
    
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
  	<s:form action="post_send" method="post">
  		<s:textfield label="帖子标题" style="width:500px;font-size:20px;" name="post_title" value="请输入帖子标题" onfocus="javascript:if(this.value=='请输入帖子标题')this.value='';" onblur="javascript:if(this.value=='')this.value='请输入帖子标题';"></s:textfield>
  		<s:textarea name="post_content" style="width:500px;height:200px;overflow:hidden;font-size:20px;" value="请输入内容（0/300）" onfocus="javascript:if(this.value=='请输入内容（0/300）')this.value='';" onblur="javascript:if(this.value=='')this.value='请输入内容（0/300）';"></s:textarea>
		<s:hidden name="reply_id" value="0"></s:hidden>
		<s:hidden name="sender_id"   value="%{#session.sender_id}"></s:hidden>
  		<s:hidden name="sender_sign" value="%{#session.sender_sign}"></s:hidden>
  		<s:hidden name="like_num"    value="0"></s:hidden>
  		<s:hidden name="watch_num"   value="0"></s:hidden>
  		<s:hidden name="reply_num"   value="0"></s:hidden>
  		<s:hidden name="major_id" value="%{#parameters.major_id}"></s:hidden>
  		<s:submit value="发表帖子"></s:submit>
  	</s:form>
  </body>
</html>
