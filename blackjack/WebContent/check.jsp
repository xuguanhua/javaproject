<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>匹配中</title>
<script src="js/jquery.js"></script>
<script type="text/javascript">
	function test(){
		$.ajax({
			url:"front",
			dataType:"json",
			success:
				function(result){
				alert("您好");
				alert(result);
			},
			error:
				function(){
				alert("我不好");
			}
		})
	}
</script>
</head>
<body>
	    <input type="button" onclick="test()" value="点击">
</body>
</html>


