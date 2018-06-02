<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s"   uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forumdetail.jsp' starting page</title>
    
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
          
        <s:textfield label="标题"  name="forum_title"  value="%{model.forum_title}"></s:textfield><br>
                 <s:textarea name="forum_content"  value="%{model.forum_content}" style="width:500px;height:200px;overflow:hidden;font-size:20px;"></s:textarea>
                 <hr width="400" align="left">
           <s:iterator var="list"   value="answerlist"  status="st">
           <s:property value="names2[#st.index]"/><br>
                <s:property value="#list.answer_content"/>
                <s:if test="#list.answerer_type==0">
                        【学生回答】<br>
                </s:if>
                <s:else>
                        【教师回答】<br>
                </s:else>
                <span class="haha">
           <s:property value="#list.answer_time.toString().substring(0,#list.answer_time.toString().lastIndexOf('.'))"/>
             </span>
                <a href="addAnswer_Like_id?answer_id=<s:property value="%{#list.answer_id}"/>&forum_id=<s:property value="%{model.forum_id}"/>">点赞</a>
                 <s:property value="#list.answer_like_num"/>
            <hr width="400" align="left">
           </s:iterator>
             <s:form action="add_Answer"  method="post">
                 
                 <s:textarea name="answer_content"  id="answer_content" style="width:500px;height:200px;overflow:hidden;font-size:20px;"></s:textarea>
                 
                 <s:hidden name="answerer_id"  value="%{#session.user.s_id}"></s:hidden>
               <s:hidden name="answerer_type"  value="%{#session.user.s_sign}"></s:hidden>
               <s:hidden name="forum_id"  value="%{model.forum_id}"></s:hidden>
              <s:submit value="回答"></s:submit>
           </s:form>    
           <script type="text/javascript">
              var answer_content=document.getElementById("answer_content");
                  answer_content.innerHTML=null;
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
