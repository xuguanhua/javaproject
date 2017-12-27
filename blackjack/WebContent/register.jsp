<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
	<style type="text/css">
	*{margin:0 auto;}
	body{
		background:url("images/background.jpg") no-repeat;
		background-size:100%;
	}
	.all{
		text-align:center;
		margin-top:10%;
		background-color:#fff;
		width: 30%;
		padding: 35px;
		border:3px #ccc solid;
	}
	</style>
	
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	
	<script type="text/javascript">
	
 	$(function(){
 		$(":input[name='ue']").change(function(){
 			
 			var ue = $(this).val();
 			ue = $.trim(ue);
 			
 			if(ue != ""){
 				var url = "registerCheck";
 				var args = {"ue":ue,"time":new Date()};
 				$.post(url,args,function(data){
 					$("#message").html(data);
 				});
 			}
 		});
		
		$(":input[name='pd2']").change(function(){
 			
 			var pd2 = $(this).val();
 			var pd1 = $(":input[name='pd1']").val();
 			pd2 = $.trim(pd2);
 			
 			if(pd2 != ""){
 				var url = "registerCheck";
 				var args = {"pd2":pd2,"pd1":pd1,"time":new Date()};
 				$.post(url,args,function(data){
 					$("#passwordMessage").html(data);
 				});
 			}
 		});
		
		
 	});


	</script>
	<script type="text/javascript">
 	function success(){
 		
 	}
 	</script>
</head>
<body>
	<div class="all">
	<h2>用户注册</h2><br>
		<form action="register" method="post" id="form" onclick="success()">
			<table>
				<tr>
					<td>输入用户名：</td>
					<td><input type="text"  placeholder="输入您的用户名" name="ue"></td>
					<td style="width:30%"><div id="message" ></div></td>
				</tr>
				<tr>
					<td>输入密	码：</td>
					<td><input type="password" placeholder="输入您的密码" name="pd1"></td>
				</tr>
				<tr>
					<td>再次输入密码：</td>
					<td><input type="password" placeholder="输入您的密码" name="pd2"></td>
					<td style="width:30%"><div id="passwordMessage" ></div></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="注册"></td>
				</tr>
			</table>
		</form>

		<a href="login.jsp">返回登录</a>
	</div>
</body>
</html>