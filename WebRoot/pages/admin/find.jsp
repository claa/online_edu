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
</head>
<body>
<jsp:include page="../login/part1.jsp"/>
<div class="container">
   <div class="panel panel-default row">
      <div class="col-md-6 panel-body" style="background:#f5f5f5;">标题</div>
      <div class="panel-body col-md-6 "><s:property value="posted.post_title"/></div>      
   </div>
   <div class="row panel panel-default">
      <div class="col-md-6 panel-body" style="background-color:#f5f5f5; height:86px; width:580px;">内容</div>
      <div class="col-md-6 panel-body"><s:property value="posted.post_content"/></div>  
   </div>
   <div class="row panel panel-default">
      <div class="col-md-6 panel-body" style="background:#f5f5f5;">时间</div>
      <div class="col-md-6 panel-body"><s:property value="posted.post_time"/></div>  
   </div>
</div>
<table class="table table-bordered" align="center">
<tr>
            <th>标题</th>
            <th>内容</th>
			<th>时间</th>
</tr>
 <tr>
		    <td><s:property value="posted.post_title"/></td>
		    <td><s:property value="posted.post_content"/></td>
	        <td><s:property value="posted.post_time"/></td>
 </tr>

</table>
<jsp:include page="../login/part2.jsp"/>
</body>
</html>