<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 
	1. 导入jQuery库
	2. 获取name="username" 的节点：username
	3. 为username添加change相应函数
	3.1 获取username的value属性值，去除前后空格且不为空，准备发送Ajax请求
	3.2 发送Ajax请求检验username是否可用
	3.3 在服务端直接返回一个html的片段
	3.4 在客户端浏览器把其直接添加到#message 的html中
 -->
 
 <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
 <script type="text/javascript">
 
 	$(function(){
 		$(":input[name='userName']").change(function(){
 			
 			var val = $(this).val();
 			val = $.trim(val);
 			
 			if(val != ""){
 				var url = "valiateUserName";
 				var args = {"userName":val,"time":new Date()};
 				$.post(url,args,function(data){
 					$("#message").html(data);
 				});
 			}
 		});
 	});
 	
 </script>
<body>

	<form action="" method="post">
		Username:<input type="text" name="userName">
		<br><br>
		<div id="message"></div>
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>