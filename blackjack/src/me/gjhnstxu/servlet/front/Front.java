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
	static boolean flag = true;//�ж��ǲ��ǵ�һ�δ洢��Ҽ�¼
	
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
     		//��ȡ������ҵ�������Ϣ
     		players = frontService.queryInformation(players);
     		
     		if(num >= 4){
             	//��ȡ��ҵĵ����ͻ�ʤ��id(�±�λ�ü�һ)
             	ArrayList<Integer> pointsList1 = frontService.oAllPointOfPlayer();
             	pointOfMax = pointsList1.get(pointsList1.size() - 1);
             	ArrayList<Integer> pointsList2 = new ArrayList<>();
             	
             	//ѭ������û�а������һ��ֵ����û�а���������ֵ
             	for(int i = 0;i < pointsList1.size()-1;i ++){
             		pointsList2.add(i, pointsList1.get(i)+1);
             	}
             	
             	//�����pointsList��ֻ����û�����ֵ����ҵ�ID����
             	ArrayList<String> names = frontService.oNamesByIds(pointsList2);
             	
             	for(Player player:players){
             		result += "<p color='red' style=''>���" + player.getUsername() + "���ܵĵ����ǣ�" + player.getPointsum() + "</p>";
             	}
     			result += "<font color='blue'>��Ϸ����ǣ�</font>";
     			int i = 0;
     			for(String n:names){
     				i = names.indexOf(n);
     				result += "<font>���"+ names.get(i) + "��ʤ���ܵ����ǣ�" + pointOfMax+ "</font>";
     			}
     			if(flag){
     	  			//����ҵ���Ϸ�����¼
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
         	//���״̬
         	String status = dao.queryStatus(id.toString());
         	FrontService frontService = new FrontService();
         	num ++;
    		//��������������������ݿ�
    		frontService.storage(num);
    		session.setAttribute("flag",f); 
//    		System.out.println("flag��ֵ�ǣ�" + session.getAttribute("flag"));
    		response.sendRedirect("index.jsp");
     	}

		

//		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
}
