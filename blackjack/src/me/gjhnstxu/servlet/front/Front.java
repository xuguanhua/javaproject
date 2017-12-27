package me.gjhnstxu.servlet.front;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.gjhnstxu.bean.Player;
import me.gjhnstxu.dao.DBAccess;
import me.gjhnstxu.service.front.FrontService;

public class Front extends HttpServlet {

	static int num = 0;
	static int f = 1;
	static boolean flag = true;//判断是不是第一次存储玩家记录
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String pageFlag = null;
		pageFlag = request.getParameter("pageFlag");
		Object id = request.getSession().getAttribute("id");
		ArrayList<Player> players = new ArrayList<Player>();
		int pointOfMax = 0;
		
		for(int i = 0;i < 4;i++){
			Player player = new Player();
			players.add(player);
		}
		
     	String result = "";
     	
     	if(pageFlag != null){
     		FrontService frontService = new FrontService();
     		//获取所有玩家的所有信息
     		players = frontService.queryInformation(players);
     		
     		if(num >= 4){
             	//获取玩家的点数和获胜人id(下标位置加一)
             	ArrayList<Integer> pointsList1 = frontService.oAllPointOfPlayer();
             	pointOfMax = pointsList1.get(pointsList1.size() - 1);
             	ArrayList<Integer> pointsList2 = new ArrayList<>();
             	
             	//循环遍历没有包括最后一个值，即没有包括最大的总值
             	for(int i = 0;i < pointsList1.size()-1;i ++){
             		pointsList2.add(i, pointsList1.get(i)+1);
             	}
             	
             	//下面的pointsList是只包含没有最大值的玩家的ID集合
             	ArrayList<String> names = frontService.oNamesByIds(pointsList2);
             	
             	for(Player player:players){
             		result += "<p color='red' style=''>玩家" + player.getUsername() + "的总的点数是：" + player.getPointsum() + "</p>";
             	}
     			result += "<font color='blue'>游戏结果是：</font>";
     			int i = 0;
     			for(String n:names){
     				i = names.indexOf(n);
     				result += "<font>玩家"+ names.get(i) + "获胜，总点数是：" + pointOfMax+ "</font>";
     			}
     			if(flag){
     	  			//将玩家的游戏结果记录
         			frontService.sRecords(players, pointOfMax);
         			flag = false;
     			}
     			
//     			System.out.println(result);
     			response.setContentType("text/html");
     			response.setCharacterEncoding("UTF-8");
     			response.getWriter().print(result);
     		}
     	}else{
         	Player player = new Player();
         	DBAccess dao = new DBAccess();
         	player = dao.queryCard(id.toString(),player);
         	//玩家状态
         	String status = dao.queryStatus(id.toString());
         	FrontService frontService = new FrontService();
         	num ++;
    		//将结束玩家数量存入数据库
    		frontService.storage(num);
    		session.setAttribute("flag",f); 
//    		System.out.println("flag的值是：" + session.getAttribute("flag"));
    		response.sendRedirect("index.jsp");
     	}

		

//		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
}
