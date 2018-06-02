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
<jsp:include page="../login/part1.jsp"/>
<form action="updatet?t_id=${teachered.t_id} " method="post">
教师号:<input type="text" name="t_no" value="${teachered.t_no}">
姓名: <input type="text" name="t_username" value="${teachered.t_username}">
邮箱<input name="t_Email" value="${teachered.t_Email}">
简介:<input name="t_introduce" value="${teachered.t_introduce}">
专业: <input  name="major_name" value="${majored.major_name}">
<input type="submit" value="修改"/>
</form>
<jsp:include page="../login/part2.jsp"/>
</body>
</html>