<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<script src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<style>
a{
  text-decoration:none;
  color:white;
}
a:hover{
  color:red;
}
</style>
</head>
<body>
<jsp:include page="../login/part1.jsp"/>
<table class="table table-bordered" align="center">
<tr>
            <th>标题</th>
			<th>时间</th>
</tr>
<s:iterator value="posts" var="post" status="st">
                  <tr> 
		                <td><a href="find?post_id=<s:property value="#post.post_id"/>"><s:property value="#post.post_title"/></a></td>
						<td><s:property value="#post.post_time"/></td>
                      
			     </tr>
</s:iterator>

</table>
<jsp:include page="../login/part2.jsp"/>
</body>
</html>