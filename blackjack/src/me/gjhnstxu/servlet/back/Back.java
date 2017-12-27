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
		//���ñ���
		request.setCharacterEncoding("utf-8");
		//��ȡ��������Ĳ���
		String id = request.getParameter("id");//��ȡ�û�id
		String param = request.getParameter("param");//��ȡ����
		System.out.println("���������id�ǣ�" + id);
		System.out.println("���������param�ǣ�" + param);
		System.out.println(id);
		
//		Player[] players = new Player[4];

		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		//�������ݿ�
		BackService service = new BackService();
		

		//��һ�ȡ�������֡��Ƶ����������ڷ����
		service.queryInformation(players);
		
		//��һ�η��ƵĲ���
		if(flag){
			//������ݱ�
			service.empty("getcard");
			//��ȡ�����е���
			GetCard cards = new GetCard();
			String[] pokers = cards.newPoker();
			cardslist = cards.shuffleCard(pokers);
			ArrayList<Player> s = service.insertFrist(cardslist,players);
			//��ȡ��һ����ҵ�id
			String fristPlayerOfid = s.get(0).getId();
			System.out.println("id��"+s.get(0).getId());
			//���÷���
			service.sIsHoster(fristPlayerOfid);
			//��ʾ���ǵ�һ��
			flag = false;
		}
		
		System.out.println("������е����ǣ�" + cardslist);
		for(int i = 0;i < 4;i++){
			System.out.println("���" + players.get(i).getUsername() + "�����ǣ�" + players.get(i).getCard() + ",��ʱ��ĵ����ǣ�" + players.get(i).getPointsum());
		}
		
		//����Ҳ���
		if(param != null){
			service.giveCard(id, param, players, cardslist, index);
			index++;
		}

		
//		//�����ҵ���
//		Player player = service.queryCard(id, players.get(Integer.valueOf(id) - 1));
//		System.out.println(player.getUsername() + "��ҵ�����" + player.getCard() );
		
		service.inPointNum(players);//�����Ѿ����Ƶ���������ݿ�
		service.obtainStatus(player1, id);

		//�������ݿ��е���
		service.queryInformation(players);
		Player player = service.queryCard(id, players.get(0));
		System.out.println(player.getUsername() + "��ҵ��Ƶ�������" + player.getPointsum() );
		response.sendRedirect("index.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
}
