<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<font color="red">${requestScope.error}</font>
<form action="getpass" method="post">
帐号：<input type="text" name="no"><br><font color="red"><s:fielderror fieldName="no"/></font>
用户名：<input type="text" name="username"><br><font color="red"><s:fielderror fieldName="username"/></font>
邮箱:<input type="text" name="email"><br><font color="red"><s:fielderror fieldName="email"/></font>
用户类型：<select name="type">
                  <option>学生</option>
                  <option>教师</option>
         </select><br>
验证码:<input type="text" name="checking">&emsp;<img src="image.jsp"> <font color="red"><a href="" target="_self">看不清，换一张</a><br><s:fielderror fieldName="checking"/></font>
<input type="submit" value="找回密码">
</form>
</body>
</html>