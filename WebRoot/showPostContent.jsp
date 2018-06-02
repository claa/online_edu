<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showPostContent.jsp' starting page</title>
    
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
   	<s:debug></s:debug>
   	<hr>
   	这是楼主
   	<s:if test="postContent.sender_sign==0">
   		<ul>
   			<li>学生id：<s:property value="student.s_id"/></li>
   			<li>学生姓名：<s:property value="student.s_username"/></li>
   			<li>学号：<s:property value="student.s_no"/></li>
   			<li>密码：<s:property value="student.s_password"/></li>
   			<li>学生Email：<s:property value="student.s_Email"/></li>
   			<li>等级：<s:property value="student.s_rank"/></li>
   			<li>标识：<s:property value="student.s_sign"/></li>
   			<li>学院：<s:property value="student.s_major"/></li>
   		</ul>
   	</s:if>
   	<s:else>
   		<ul>
   			<li><s:property value="teacher.t_id"/></li>
   			<li><s:property value="teacher.t_username"/></li>
   			<li><s:property value="teacher.t_no"/></li>
   			<li><s:property value="teacher.t_password"/></li>
   			<li><s:property value="teacher.t_Email"/></li>
   			<li><s:property value="teacher.t_introduce"/></li>
   			<li><s:property value="teacher.t_sign"/></li>
   			<li><s:property value="teacher.t_major"/></li>
   			<li><s:property value="teacher.course_id"/></li>
   		</ul>
   	</s:else>
   	<ul>
   		<li>id：<s:property value="postContent.post_id"/></li>
   		<li>标题：<s:property value="postContent.post_title"/></li>
		<li>内容：<s:property value="postContent.post_content"/></li>
		<li>发送者id：<s:property value="postContent.sender_id"/></li>
		<li>发送者标识：<s:property value="postContent.sender_sign"/></li>
		<li>更新时间：<s:property value="postContent.post_time"/></li>
		<li>回复次数：<s:property value="postContent.reply_num"/></li>
		<li>回复者id：<s:property value="postContent.reply_id"/></li>
		<li>点赞次数：<s:property value="postContent.like_num"/></li>
		<li>查看次数：<s:property value="postContent.watch_num"/></li>
		<li>学院id：<s:property value="postContent.major_id"/></li>
	</ul>
	<s:if test="postContent.reply_num>0">
   	<hr>
   	以下是评论
	<s:iterator value="postList" var="posts">
	  	<ul>
	  		<li>id：<s:property value="#posts.post_id"/></li>
	  		<li>内容：<s:property value="#posts.post_content"/></li>
	  		<li>发送者id：<s:property value="#posts.sender_id"/></li>
	  		<li>发送者标识：<s:property value="#posts.sender_sign"/></li>
	  		<li>更新时间：<s:property value="#posts.post_time"/></li>
	  		<li>回复次数：<s:property value="#posts.reply_num"/></li>
	  		<li>回复者id：<s:property value="#posts.reply_id"/></li>
	  		<li>点赞次数：<s:property value="#posts.like_num"/></li>
	  		<li>查看次数：<s:property value="#posts.watch_num"/></li>
	  		<li>学院id：<s:property value="#posts.major_id"/></li>
	  	</ul>
    </s:iterator>
    <hr>
    	发送者
    <s:iterator value="postCommenterList" var="postCommenter">
    	<s:if test="#postCommenter.sign==0">
	   		<ul>
	   			<li>学生id：<s:property value="#postCommenter.s_id"/></li>
	   			<li>学生姓名：<s:property value="#postCommenter.s_username"/></li>
	   			<li>学号：<s:property value="#postCommenter.s_no"/></li>
	   			<li>密码：<s:property value="#postCommenter.s_password"/></li>
	   			<li>学生Email：<s:property value="#postCommenter.s_Email"/></li>
	   			<li>等级：<s:property value="#postCommenter.s_rank"/></li>
	   			<li>标识：<s:property value="#postCommenter.sign"/></li>
	   			<li>学院：<s:property value="#postCommenter.s_major"/></li>
	   		</ul>
	   	</s:if>
	   	<s:else>
	   		<ul>
	   			<li>老师id：<s:property value="#postCommenter.t_id"/></li>
	   			<li>老师姓名：<s:property value="#postCommenter.t_username"/></li>
	   			<li>教师号：<s:property value="#postCommenter.t_no"/></li>
	   			<li>教师密码：<s:property value="#postCommenter.t_password"/></li>
	   			<li>教师Email：<s:property value="#postCommenter.t_Email"/></li>
	   			<li>教师简介：<s:property value="#postCommenter.t_introduce"/></li>
	   			<li>教师标识：<s:property value="#postCommenter.sign"/></li>
	   			<li>学院id：<s:property value="#postCommenter.t_major"/></li>
	   			<li>课程id：<s:property value="#postCommenter.course_id"/></li>
	   		</ul>
	   	</s:else>
    </s:iterator>
    </s:if>
    <hr>
	<p>发表评论</p>
	<s:form action="post_commentPost" method="post">
  		<s:hidden name="post_title" value=""></s:hidden>
  		<s:textarea name="post_content" style="width:500px;height:200px;overflow:hidden;font-size:20px;" value="请输入内容（0/300）" onfocus="javascript:if(this.value=='请输入内容（0/300）')this.value='';" onblur="javascript:if(this.value=='')this.value='请输入内容（0/300）';"></s:textarea>
		<s:hidden name="post_id" value="%{postContent.post_id}"></s:hidden>
		<s:hidden name="sender_id"   value="%{#session.sender_id}"></s:hidden>
  		<s:hidden name="sender_sign" value="%{#session.sender_sign}"></s:hidden>
  		<s:hidden name="like_num"    value="0"></s:hidden>
  		<s:hidden name="watch_num"   value="0"></s:hidden>
  		<s:hidden name="reply_id" value="0"></s:hidden>
  		<s:hidden name="reply_num"   value="0"></s:hidden>
  		<s:hidden name="major_id" value="%{postContent.major_id}"></s:hidden>
  		<s:submit value="发表评论"></s:submit>
  	</s:form>
  </body>
</html>
