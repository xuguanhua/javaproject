<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<%@ page import="me.gjhnstxu.bean.Player" import="me.gjhnstxu.dao.DBAccess" import="java.util.ArrayList" import="me.gjhnstxu.service.front.FrontService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>黑杰克21点游戏</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/addCardBack.js"></script>
<script type="text/javascript">

		setInterval(function(){
			var url = "front";
			var args = {"pageFlag":1,"time":new Date()};
			$.post(url,args,function(data){
				var reset = "<input type='button' value='重新游戏' onclick='reset()'>";
				var over = "<input type='button' value='退出游戏' onclick='over()'>";
				var s = reset +  over;
				var r = data + "<br>" + s;
				$("#div4").html(r);
			});
		}, 2000);

		//游戏重新开始
		function reset(){
			
		}
		
		

		
</script>
<script type="text/javascript">

	//游戏结束
	function over(){
		
		alert("游戏退出！");
	}
</script>
</head>
<body id="body" onload="toOnload()">
	 
<marquee style="WIDTH: 100%;" scrollamount="5" direction="right" >
	欢迎玩家加入
</marquee>

	     <%
     	Object id = request.getSession().getAttribute("id");
	     
     	Player player = new Player();
     	DBAccess dao = new DBAccess();
     	player = dao.queryCard(id.toString(),player);
     	
     	int sum = dao.queryPointSum(id.toString());
     	String status = dao.queryStatus(id.toString());
     	
		ArrayList<String> cardlist = player.getCard();
		FrontService front = new FrontService();
		int[] cardIdList = front.change(cardlist);
	%>

		<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp总点数是:<%=sum%></p>
		<script type="text/javascript">
		
		//开始进入时加牌
			function toOnload(){
				var idOfNow = <%=session.getAttribute("id") %>
				var a = new Array(<%=cardIdList.length %>);
				<% for(int j=0;j<cardIdList.length;j++) {  %>  
				a[<%=j%>] =<%=cardIdList[j]%>;  
				<%}%>  
				adding(a);
				    var flag = <%=request.getSession().getAttribute("flag")%>
				    if(flag == 1){
				    	var xx ;
				    	xx = document.getElementById("div1");
				    	xx.style.display ="block";
				        
				    	var x;
				    	x =document.getElementById("div3");
				    	x.style.display = "none";
				    }
				    addCardBack();
			}
		
		//
			function toChange(){
				if(<%=status%> == "0"){
					location.href="front";
					alert("超过21点，您输了");
					return;
				}
				var a = new Array(<%=cardIdList.length %>);
				<% for(int j=0;j<cardIdList.length;j++) {  %>  
				a[<%=j%>] =<%=cardIdList[j]%>;  
				<%}%>  
				adding(a) ;//显示牌
				location.href="getCard?id=" + <%=session.getAttribute("id")%> + "&&param=1";
			}
		
		</script>
	<!-- 
		<input type="submit" id="button" onclick="toChange()" style="left: 350px" name="param" value="要牌">
		<button id="button"  style="width: 150px; left: 500px " onclick="end()" name="param" value="0">不要牌</button>
	 -->
	<div id="div_top"></div>
	<div id="div1" style="display: none;">
	游戏结束
		<div id="div4">
    	</div>
	</div>
	<div id="div_left" style="float:left;text-align:center;height:30%;width:8%;margin-left:24%"></div>
	<div id="div_right"></div>
	<div id="div2" style="height:20%">
		
	</div>
	<div id="div3"><button id="button1" class="button" onclick="toChange()">要牌</button>
	<button id="button2" class="button" style=" left: 55% " onclick="no()">不要</button>
    </div>
</body>

<!--  -->
<script type="text/javascript">
	var browser_height = $(window).height()
	console.log(browser_height);
	var browser_width = $(window).width();
	console.log(browser_width);
	var body = document.getElementById("body");
	body.style.height = browser_height + "px";
	window.onresize = function() {
		var browser_height = $(window).height();
		var body = document.getElementById("body");
		body.style.height = browser_height + "px";
	}
</script>
<!--  
<script type="text/javascript">

    setInterval("myInterval()",2000);//1000为1秒钟
    function myInterval()
    {
   -->
  
    	<!-- 
    		FrontService front1 = new FrontService();
    		int num = front1.oStorage();
    	
 	  var a =  num;
 	  alert(a);
         if(a==4){
         	$("#div4").css({"display":"block"});
         }
     }
 </script>
 -->
 
<script type="text/javascript">

function no() {
	location.href="front?id=" + <%=session.getAttribute("id")%>;
}
</script>
</html>