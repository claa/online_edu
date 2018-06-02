<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../login/part1.jsp"/>
<div align="center">
<s:form action="insertt" method="post">
<s:textfield label="教师号" name="t_no"></s:textfield>
<s:textfield label="姓名" name="t_username"></s:textfield>
<s:textfield label="邮箱" name="t_Email"></s:textfield>
<s:textfield label="简介" name="t_introduce"></s:textfield>
<s:textfield label="专业" name="major_name"></s:textfield>
<s:submit value="提交" class="btn-success btn-sm"></s:submit>
</s:form>
</div>
<jsp:include page="../login/part2.jsp"/>
</body>
</html>