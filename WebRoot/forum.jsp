<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s"  uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forum.jsp' starting page</title>
    
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
         
           <s:form action="add_SForum"  method="post">
    <s:textfield label="标题"  name="forum_title" maxlength="15"  onchange="this.value=this.value.substring(0, 15)"  onkeydown="this.value=this.value.substring(0, 15)" onkeyup="this.value=this.value.substring(0, 15)" placeholder="请一句话说明你的问题，以问号结尾"></s:textfield> 
                 <s:textarea style="width:500px;height:200px;overflow:hidden;font-size:20px;" name="forum_content"  value="%{#session.user.forum_content}"></s:textarea>
                 <s:hidden name="s_id"  value="%{#session.user.s_id}"></s:hidden> 
                 <s:hidden name="course_id"   value="1"></s:hidden>
              <s:submit value="发起问题"></s:submit>
           </s:form>
           
  </body>
</html>
