<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../login/part1.jsp"/>
<form action="updatet?major_id=${majored.major_id} " method="post">
学院:<input type="text" name="t_no" value="${majored.academy}">
专业: <input  name="major_name" value="${majored.major_name}">
<input type="submit" value="修改"/>
</form>
<jsp:include page="../login/part2.jsp"/>
</body>
</html>