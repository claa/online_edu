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
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<script src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<table  align="center" class="table table-hover">
<tr>
            <th>序号</th>
            <th>学院 </th>
            <th>专业</th>
			<th>操作</th>
</tr>
<s:iterator value="majors" var="major" status="st">
                  <tr>
                       <td><input type="checkbox" name="attachmentPath" value="${major.major_id}"></td>
		               <td><s:property value="#major.academy"/></td>
						<td><s:property value="#major.major_name"/></td>
                        <td><a href="deletem?major_id=<s:property value="#major.major_id"/>"><button class="btn btn-success btn-sm">删除</button></a></td>
                        <td><a href="findm?major_id=<s:property value="#major.major_id"/>"><button class="btn btn-success btn-sm">修改</button></a></td>
			     </tr>
</s:iterator>

</table>
<div align="center">
<ul class="pagination" >
       <li class="disabled"><a href="#">&laquo;</a></li>
       <li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
       <li><a href="findAllm?id=2">2</a></li>
       <li><a href="findAllm?id=3">3</a></li>
       <li><a href="findAllm?id=4">4</a></li>
       <li><a href="findAllm?id=5">5</a></li>
       <li><a href="#">&raquo;</a></li>
</ul>
</div >
<jsp:include page="../login/part2.jsp"/>
</body>
</html>