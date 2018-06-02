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
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<script src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<jsp:include page="../login/part1.jsp"/>
<s:action name="findTop" executeResult="true"></s:action>
<hr style="width:20px">
<table class="table table-hover" align="center">
<tr>
            <th>序号</th>
            <th>标题</th>
            <th>内容</th>
			<th>时间</th>
			<th>操作</th>
</tr>
<s:iterator value="posts" var="post" status="st">
                  <tr>
                        <td><input type="checkbox" name="attachmentPath" value="${post.post_id}"></td>
		                <td><s:property value="#post.post_title"/></td>
						<td><s:property value="#post.post_content"/></td>
						<td><s:property value="#post.post_time"/></td>
                        <td><a href="delete?post_id=<s:property value="#post.post_id"/>"><button class="btn btn-success btn-sm">删除</button></a></td>
                        <td><a href="top?post_id=<s:property value="#post.post_id"/>"><button class="btn btn-success btn-sm">置顶</button></a></td>
			     </tr>
</s:iterator>
</table>
<div align="center">
<ul class="pagination" >
       <li class="disabled"><a href="#">&laquo;</a></li>
       <li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
       <li><a href="findAll?id=2">2</a></li>
       <li><a href="findAll?id=3">3</a></li>
       <li><a href="findAll?id=4">4</a></li>
       <li><a href="findAll?id=5">5</a></li>
       <li><a href="#">&raquo;</a></li>
</ul>
</div >
<jsp:include page="../login/part2.jsp"/>
</body>
</html>