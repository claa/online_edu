<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s"   uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forumType.jsp' starting page</title>
    
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
     
         <s:iterator var="list"  value="forumlist"   status="st">
         <s:property value="names[#st.index]"/><br>
              <a href="select_SForumById?forum_id=<s:property value="#list.forum_id"/>"> <s:property value="#list.forum_title"/></a>  <br>
               时间：<span  class="haha"   ><s:property value="#list.forum_time.toString().substring(0,#list.forum_time.toString().lastIndexOf('.'))"/></span>
                <s:property  value="#list.answer_num"/>回答 
                <s:property value="#list.watch_num"/>浏览<br>
               <hr width="400" align="left">
         </s:iterator>
         <s:if test="#session.sign==1">
           <a href="select_Forum?course_id=<s:property value="course_id"/>&sign=1">教师答疑区</a>
           
        
      </s:if>
        <s:else>
        <a href="select_Forum?course_id=<s:property value="course_id"/>&sign=1">教师答疑区</a>
           
         <a href="select_Forum?course_id=<s:property value="course_id"/>&sign=0">学生讨论区</a>
         <s:form action="add_SForum"  method="post">
                 <s:textfield label="标题"   value="" name="forum_title" maxlength="15"  onchange="this.value=this.value.substring(0, 15)"  onkeydown="this.value=this.value.substring(0, 15)" onkeyup="this.value=this.value.substring(0, 15)" placeholder="请一句话说明你的问题，以问号结尾"></s:textfield> 
                 <s:textarea name="forum_content"  value="" style="width:500px;height:200px;overflow:hidden;font-size:20px;"></s:textarea>
                 <s:hidden name="s_id"  value="%{#session.user.s_id}"></s:hidden> 
                 <s:hidden name="course_id"   value="%{model.course_id}"></s:hidden>
            <s:hidden name="sign"   value="%{#parameters.sign}"></s:hidden> 
         <%-- <s:property value="#parameters.sign"/>  --%>
              <s:submit value="发起问题"></s:submit>
           </s:form>
        </s:else>
      
          
              <script type="text/javascript">
            iter();
              
             function iter(){
                     var size=document.getElementsByClassName("haha");
                    for(var i=0;i<size.length;i++){
                         document.getElementsByClassName("haha")[i].innerHTML=   getDateDiff(document.getElementsByClassName("haha")[i].innerHTML);
                       }
                }
                function getDateTimeStamp (dateStr) {
                  return Date.parse(dateStr.replace(/-/gi,"/"));
                    }
              function getDateDiff (dateStr) {
					    var publishTime = getDateTimeStamp(dateStr)/1000,
					        d_seconds,
					        d_minutes,
					        d_hours,
					        d_days,
					        timeNow = parseInt(new Date().getTime()/1000),
					        d,
					
					        date = new Date(publishTime*1000),
					        Y = date.getFullYear(),
					        M = date.getMonth() + 1,
					        D = date.getDate(),
					        H = date.getHours(),
					        m = date.getMinutes(),
					        s = date.getSeconds();
					        //小于10的在前面补0
					        if (M < 10) {
					            M = '0' + M;
					        }
					        if (D < 10) {
					            D = '0' + D;
					        }
					        if (H < 10) {
					            H = '0' + H;
					        }
					        if (m < 10) {
					            m = '0' + m;
					        }
					        if (s < 10) {
					            s = '0' + s;
					        }
					
					    d = timeNow - publishTime;
					    d_days = parseInt(d/86400);
					    d_hours = parseInt(d/3600);
					    d_minutes = parseInt(d/60);
					    d_seconds = parseInt(d);
					
					    if(d_days > 0 && d_days < 3){
					        return d_days + '天前';
					    }else if(d_days <= 0 && d_hours > 0){
					        return d_hours + '小时前';
					    }else if(d_hours <= 0 && d_minutes > 0){
					        return d_minutes + '分钟前';
					    }else if (d_seconds < 60) {
					        if (d_seconds <= 0) {
					            return '刚刚发表';
					        }else {
					            return d_seconds + '秒前';
					        }
					    }else if (d_days >= 3 && d_days < 30){
					        return M + '-' + D + '&nbsp;' + H + ':' + m;
					    }else if (d_days >= 30) {
					        return Y + '-' + M + '-' + D + '&nbsp;' + H + ':' + m;
					          }
					    }    
              </script>
   


  </body>
</html>
