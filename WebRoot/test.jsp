<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
  <table>
      <s:iterator var="li" value="receiveInfoList">
          <tr>
              <td><s:property value="#li.prletter_id"/></td>
              <td><s:property value="#li.sender_Email"/></td>
              <td><s:property value="#li.receiver_Email"/></td>
              <td><s:property value="#li.prletter_time"/></td>
              <td><s:property value="#li.prletter_content"/></td>
          </tr>
      </s:iterator>
  </table>
  </body>
</html>
