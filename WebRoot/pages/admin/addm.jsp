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
<s:form action="insertm" method="post">
<s:textfield label="学院" name="academy"></s:textfield>
<s:textfield label="专业" name="major_name"></s:textfield>
<s:submit value="提交" class="btn-success btn-sm"></s:submit>
</s:form>
</div>
<jsp:include page="../login/part2.jsp"/>
</body>
</html>