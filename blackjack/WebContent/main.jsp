<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>黑杰克21点————官网</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="font-awesome-4.6.3\css\font-awesome.min.css">
	<style type="text/css">
		*{
			margin:0;padding:0;
		}
		.top{
			height: 60px;
			width: 100%;
			/*background-color: red;*/
		}

		.footer{
			height: 100px;
			text-align: center;
			line-height: 22px;
			background-color: #000;
			color: #fff;
			font-family: "微软雅黑";
		}
		#mycarousel img{
			width: 1100px;
			height: 300px;
		}

		/*QQ弹窗隐藏*/
		#customer_service{
			display: none;
		}

		/*支付宝弹窗隐藏*/
		#alipay{
			display: none;
		}
	</style>
	
</head>
<script type="text/javascript">
	function exam(){
		alert("对不起，暂时不支持查看详情，若真的必要查看，请联系客服");
	}

</script>
<body onload="goPage(1,20);">
	<div class="top">

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-responsive-collapse">
				<span class="sr-only">Toggle Navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="##" class=" navbar-brand">黑杰克二十一点</a>
		</div>
		<div class="collapse navbar-collapse navbar-responsive-collapse">
			<ul class="nav navbar-nav">
				<li><a href="#introduction">游戏介绍</a></li>
				<li><a href="#raiders">攻略</a></li>
				<li><a href="##" onclick="service();">联系我们</a></li>
				<li><a href="##" onclick="alipay();">支持一下</a></li>
				<li class="dropdown"><a href="##" class="dropdown-toggle" data-toggle="dropdown">个人中心 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="javascript:;"  onclick="">查看修改个人资料</a></li>
					<li><a href="login.jsp">退出</a></li>
				</ul>
				</li>
				<li><a href="getCard?id=<%=session.getAttribute("id")%>" >进入游戏</a></li>
			</ul>
		</div>
	</div>


	</div>
	<!-- top end-->

	<!-- middle start -->
	<div class="middle">
			<!-- 轮播图 -->
	<div id="carousel-container" class="carousel slide lunbo" data-ride="carousel" data-interval="3000">
	<!-- 图片容器 -->
	<div class="carousel-inner" id="mycarousel">
		<div class="item active">
			<a href="##"><img src="images/lb1.jpg" alt="" class="center-block"></a>
		</div>
		<div class="item">
			<a href="##"><img src="images/lb2.png" alt="" class="center-block"></a>
		</div>
		<div class="item">
			<a href="##"><img src="images/lb3.png" alt="" class="center-block"></a>
		</div>

		<div class="item">
			<a href="##"><img src="images/lb4.png" alt="" class="center-block"></a>
		</div>
		<div class="item">
			<a href="##"><img src="images/lb5.png" alt="" class="center-block"></a>
		</div>
		<div class="item">
			<a href="##"><img src="images/lb6.png" alt="" class="center-block"></a>
		</div>
		<div class="item">
			<a href="##"><img src="images/lb7.jpg" alt="" class="center-block"></a>
		</div>
	</div>
	<!-- 圆点指示符 -->
	<ol class="carousel-indicators">
		<li class="active" data-target="#carousel-container" data-slide-to="0"></li>
		<li data-target="#carousel-container" data-slide-to="1"></li>
		<li data-target="#carousel-container" data-slide-to="2"></li>
		<li data-toggle="#carousel-container" data-slide-to="3"></li>
		<li data-toggle="#carousel-container" data-slide-to="4"></li>
		<li data-target="#carousel-container" data-slide-to="5"></li>
	</ol>
	<!-- 设置左右的按钮 -->
	<a class="left carousel-control" href="#carousel-container" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left"></span>
	</a>
	<a  class="right carousel-control" href="#carousel-container" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right"></span>
	</a>
	</div>
	</div>

	<div class="information">
	<div class="container">
		<div class="row">
			<div class="col-md-8">

				<!-- 游戏介绍 -->
				<a name="introduction"></a>
				<div class="introduction">
					<hr>
					<h2>游戏介绍</h2>
					<hr>
					<p>
						 二十一点是世界上最受欢迎的扑克牌游戏之一，关于它的起源，比较多的说法是源于法国，参加者尽量使手中牌的总点数达到21点，或是接近21点，但不能超过，再和庄家比较总点数的大小以定输赢。
					</p>
					<p>
					1.原理：	
					</p>
					<p>手中所有的牌点数之和不超过21点，谁更接近21点，就赢得游戏。</p>
					<p>2.点数计算：</p>
					<p>2到10的牌所代表的点数即为其牌面的数目；J、Q、K视为10点；A有两种算法，11或1，A计为11时是软牌（如：A、6点数和为软17），A计为1时是硬牌（如：A、6、Q总点数为硬17）。</p>
					<p>3.要牌（hit）：</p>
					<p>首次分牌分给玩家2张牌，只要手牌点数不超过21点，玩家可以任意选择是否要牌，当点数超过21点，则玩家爆牌，不能再继续要牌,并且本轮游戏结束。</p>
					<p>4.比较大小：</p>
					<p>（1）玩家点数超过21点（爆牌），则本轮游戏自动出局。</p>
					<p>（2）当所有玩家都选择不要牌时，正式开启比牌。</p>
					<p>（3）玩家点数最大者本轮获胜（爆牌玩家除外）。</p>
					<p>5.重开游戏：</p>
					<p>当本轮游戏结束后，当四人都选择“重新游戏”时，开启新一轮游戏。</p>
					<p>6.退出游戏：。</p>
					<p>当玩家选择“结束游戏”后，退回游戏大厅界面，并可选择是否重新开始游戏</p>			
				</div>
				
				<!-- 攻略 -->
				<a name="raiders"></a>
				<div class="raiders">
					<hr>
					<h2>攻略</h2>
					<hr>
					<p>
						高低算牌术：
					</p>
					<p>
						在游戏过程中，我们把每一张出现的2，3，4，5，6都算+1点，7，8，9算0点，10，j，q，k，a算-1点，将各点相加，结果越大，就表示前面出现过的小牌越多。反过来，如果结果是个负数，就表示前面出过的大牌比小牌多。
					</p>
				</div>
			</div>
			<div class="col-md-4">
				<h2>玩家游戏记录</h2>
<!-- 				<ul id="college">
				 	<li>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp<input type="button" name="exam" value="查看详情" onclick="exam()"></li>
					<li>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp<input type="button" name="exam" value="查看详情" onclick="exam()"></li>
					<li>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp<input type="button" name="exam" value="查看详情" onclick="exam()"></li>
					<li>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp<input type="button" name="exam" value="查看详情" onclick="exam()"></li>
					<li>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp<input type="button" name="exam" value="查看详情" onclick="exam()"></li>
					<li>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp<input type="button" name="exam" value="查看详情" onclick="exam()"></li>
					<li><a href="college.php">点击查看更多&gt&gt</a></li>
				</ul> -->
				<table id="idData">        
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
          			<tr><td>2017-12-16 12:11:12 获胜 &nbsp&nbsp&nbsp&nbsp</td><td><input type="button" name="exam" value="查看详情" onclick="exam()"></td></tr>
   				</table>
			    <table width="60%" align="right">
			        <tr><td><div id="barcon" name="barcon"></div></td></tr>
			    </table>
			</div>
		</div>
	</div>
	</div>
	<div id="toTop">
		<a href="#top" ><i class="fa fa-hand-o-up fa-3x return" ></i></a>
	</div>

	<div class="footer">
		
		<p>本网络游戏适合年满16周岁(含)以上的用户使用；为了您的健康，请合理控制游戏时间。<br>		
			抵制不良游戏，拒绝盗版游戏。注意自我保护，谨防受骗上当。适度游戏益脑，沉迷游戏伤身。合理安排时间，享受健康生活。<br>
			版权所有，保留一切权利！© 2017 Jobs's Service<br>
			by 徐莞华 && 戴敬峰 && 胡马安 && 陈越臣 && 陈博荣
		</p>
	
	</div>

	<!-- QQ弹窗 -->
	<div id="customer_service">
		<!-- <img src="images/QQ.jpg" style="height: 100%;width: 100%"> -->
		<div style="width: 490px;height: 400px;background-image: url('images/QQ.jpg');background-repeat: no-repeat;background-size:cover;">
			
		</div>
	</div>

	<!-- 支付宝弹窗 -->
	<div id="alipay">
		<!-- <img src="images/QQ.jpg" style="height: 100%;width: 100%"> -->
		<div style="width: 490px;height: 400px;background-image: url('images/alipay.jpg');background-repeat: no-repeat;background-size:cover;">
			
		</div>
	</div>


	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/snowflake.js"></script>
	<script type="text/javascript" src="layer/layer/layer.js"></script>
	<script type="text/javascript">
		//回到顶部手指显示
		$(function(){
			var timer = null;
			var pageheight = document.documentElement.clientHeight;  //获取可视区域的高度
			window.onscroll=function(){
				var backtop = document.body.srollTop;
				if (backtop>=80) {
					$("#return").show();
				}else{
					$("#return").hide();
				}
			}
		});

		//弹窗页面,QQ
		function service(){
			layer.open({
				type:1,			
				title:"扫一扫QQ添加客服",		//弹窗标题
				area:["490px","450px"],
				content:$("#customer_service")    //捕捉元素
			});
		}

		//弹窗页面，支付宝
		function alipay(){
			layer.open({
				type:1,			
				title:"扫一扫支付宝支持1元",		//弹窗标题
				area:["490px","450px"],
				content:$("#alipay")    //捕捉元素
			});
		}
	</script>
	<script type="text/javascript">
	/**
	 * 分页函数
	 * pno--页数
	 * psize--每页显示记录数
	 * 分页部分是从真实数据行开始，因而存在加减某个常数，以确定真正的记录数
	 * 纯js分页实质是数据行全部加载，通过是否显示属性完成分页功能
	 **/
	function goPage(pno,psize){
	    var itable = document.getElementById("idData");
	    var num = itable.rows.length;//表格所有行数(所有记录数)
	    var totalPage = 0;//总页数
	    var pageSize = psize;//每页显示行数
	    //总共分几页 
	    if(num/pageSize > parseInt(num/pageSize)){   
	            totalPage=parseInt(num/pageSize)+1;   
	       }else{   
	           totalPage=parseInt(num/pageSize);   
	       }   
	    var currentPage = pno;//当前页数
	    var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  31 
	       var endRow = currentPage * pageSize;//结束显示的行   40
	       endRow = (endRow > num)? num : endRow;    40
	       console.log(endRow);
	       //遍历显示数据实现分页
	    for(var i=1;i<(num+1);i++){    
	        var irow = itable.rows[i-1];
	        if(i>=startRow && i<=endRow){
	            irow.style.display = "block";    
	        }else{
	            irow.style.display = "none";
	        }
	    }
	    var pageEnd = document.getElementById("pageEnd");
	    var tempStr = "共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
	    if(currentPage>1){
	        tempStr += "<a href=\"##\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
	        tempStr += "<a href=\"##\" onClick=\"goPage("+(currentPage-1)+","+psize+")\"><上一页</a>"
	    }else{
	        tempStr += "首页";
	        tempStr += "<上一页";    
	    }

	    if(currentPage<totalPage){
	        tempStr += "<a href=\"##\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页></a>";
	        tempStr += "<a href=\"##\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
	    }else{
	        tempStr += "下一页>";
	        tempStr += "尾页";    
	    }

	    document.getElementById("barcon").innerHTML = tempStr;
	    
	    return false;
	}
	</script>
</body>
</html>