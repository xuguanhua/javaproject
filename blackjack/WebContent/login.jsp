<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript">

</script>
<style>
*{
	margin:0 auto;
}
	body{
		background:url("images/background.jpg") no-repeat;
		background-size:100%;
	}
	.div1{
		text-align:center;
		margin-top:10%;		
		border:3px #ccc solid;
		padding: 40px;
		width: 30%;
		background-color: #fff;
	}
</style>

	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	
	<script type="text/javascript">
	
	//ajax
 	$(function(){
 		$(":input[name='username']").change(function(){
 			
 			var ue = $(this).val();
 			ue = $.trim(ue);
 			
 			if(ue != ""){
 				var url = "loginCheck";
 				var args = {"username":ue,"time":new Date()};
 				$.post(url,args,function(data){
 					$("#message").html(data);
 				});
 			}
 		});
		
		$(":input[name='password']").change(function(){
 			
 			var pd2 = $(this).val();
 			pd2 = $.trim(pd2);

 			if(pd2 != ""){
 				var url = "loginCheck";
 				var args = {"password":pd2,"time":new Date()};
 				$.post(url,args,function(data){
 					$("#passwordmessage").html(data);
 				});
 			}
 		});
		
		
 	});


	</script>
</head>
<body>
	<div class="div1">
		<h2>进入房间</h2><br>
		<form action="login" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" placeholder="输入您的用户名"></td>
				<td style="width:30%;">
					<p id="message"></p>
				</td>
			</tr>
			<tr>
				<td>密     码：</td>
				<td><input type="password" name="password" placeholder="输入您的密码"></td>
				<td>
					<p id="passwordmessage"></p>
				</td>
			</tr>
			<tr>
				<td>房间号：</td>
				<td><input type="password" name="room" placeholder="默认房间号" disabled></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="进入"></td>
			</tr>
		</table>
		</form>
		<a href="register.jsp">没有账户，点击注册</a>
	</div>
</body>
</html>