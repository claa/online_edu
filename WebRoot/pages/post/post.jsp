<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../../js/wangEditor.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../../css/bootstrap.min.css" ></link>
<script type="text/javascript">
           window.onload = function(){
            // 生成编辑器
            var editor = new wangEditor('#div1','#div2');
            editor.create();
            document.getElementById('btn').addEventListener('click',function(){
            	var input = document.getElementById('true_con');
            	input.value= editor.txt.html();
            	var title = document.getElementById('title');
            	var true_tit = document.getElementById('true_tit');
            	var t = title.value;
            	true_tit.value = t;
            },false);
           }
</script>
<style type="text/css">
        .toolbar {
            border: 1px solid #ccc;
            height:25px;
            width:650px;
            
        }
        .text {
            border: 1px solid #ccc;
            height:120px;
            width:650px;
            
        }
</style> 
   <jsp:include page="../login/part1.jsp"/>
    标题:<input type="text" name="title" id="title" style="width:300px;height:20px;margin-bottom:20px;" >
    
    <div id="div1" class="toolbar"></div>
    <div style="padding: 5px 0; color: #ccc ;margin-bottom:20px;"></div>
    <div id="div2" class="text"> <!--可使用 min-height 实现编辑区域自动增加高度-->
    </div>
    <form action="insert" method="post">
    <input type="text" name="post_title" style="display:none;" id="true_tit">
    <input type="text" name="post_content" style="display:none;" id="true_con">
    <input type="submit" value="发表" id="btn" class="btn-success btn-sm">
    </form>
    <jsp:include page="../login/part2.jsp"/>
</body>
</html>