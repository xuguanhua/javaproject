package me.gjhnstxu.servlet.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.print.Printer;
import me.gjhnstxu.bean.GetCard;
import me.gjhnstxu.bean.Player;
import me.gjhnstxu.dao.DBAccess;
import me.gjhnstxu.service.back.BackService;
import me.gjhnstxu.service.front.FrontService;

public class Back extends HttpServlet{

	static boolean flag = true;
	static int index = 8;
	static ArrayList<Player> players = new ArrayList<Player>();
	static Player player1 = new Player();
	static Player player2 = new Player();
	static Player player3 = new Player();
	static Player player4 = new Player();
	static ArrayList<String> cardslist;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获取来自请求的参数
		String id = request.getParameter("id");//获取用户id
		String param = request.getParameter("param");//获取参数
		System.out.println("传输过来的id是：" + id);
		System.out.println("传输过来的param是：" + param);
		System.out.println(id);
		
//		Player[] players = new Player[4];

		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		//连接数据库
		BackService service = new BackService();
		

		//玩家获取现在名字、牌的总数和所在房间号
		service.queryInformation(players);
		
		//第一次发牌的操作
		if(flag){
			//清空数据表
			service.empty("getcard");
			//获取到所有的牌
			GetCard cards = new GetCard();
			String[] pokers = cards.newPoker();
			cardslist = cards.shuffleCard(pokers);
			ArrayList<Player> s = service.insertFrist(cardslist,players);
			//获取第一个玩家的id
			String fristPlayerOfid = s.get(0).getId();
			System.out.println("id是"+s.get(0).getId());
			//设置房主
			service.sIsHoster(fristPlayerOfid);
			//表示不是第一次
			flag = false;
		}
		
		System.out.println("输出所有的牌是：" + cardslist);
		for(int i = 0;i < 4;i++){
			System.out.println("玩家" + players.get(i).getUsername() + "的牌是：" + players.get(i).getCard() + ",这时候的点数是：" + players.get(i).getPointsum());
		}
		
		//给玩家操作
		if(param != null){
			service.giveCard(id, param, players, cardslist, index);
			index++;
		}

		
//		//检查玩家的牌
//		Player player = service.queryCard(id, players.get(Integer.valueOf(id) - 1));
//		System.out.println(player.getUsername() + "玩家的牌是" + player.getCard() );
		
		service.inPointNum(players);//这里已经把牌点数存进数据库
		service.obtainStatus(player1, id);

		//测试数据库中点数
		service.queryInformation(players);
		Player player = service.queryCard(id, players.get(0));
		System.out.println(player.getUsername() + "玩家的牌的总数是" + player.getPointsum() );
		response.sendRedirect("index.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
}
