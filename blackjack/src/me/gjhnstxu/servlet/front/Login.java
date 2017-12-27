package me.gjhnstxu.servlet.front;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.gjhnstxu.service.front.FrontService;

public class Login extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ����Ĳ���
		String username = request.getParameter("username");//��ȡ��ҵ�����
		String password = request.getParameter("password");//��ȡ��ҵĵ�¼����
		String room = request.getParameter("room");//��ȡ��ҽ���ķ����
		String result = null;

		
		System.out.println("���������û���Ϊ��" + username + "������Ϊ�� " + password);
		//����service����
		FrontService service = new FrontService();

		/**
		 * �����ݿ��в�ѯ�Ƿ��и����
		 * ����и���ң�����ת��index.jsp�������Ϸ��ҳ�棬������ת�ص�¼��ҳ��
		 */
		if(service.hasPlayer(username,password)){
			HttpSession session = request.getSession();
			
			String id = service.oid(username);
			session.setAttribute("id", id);
			session.setAttribute("username", username);
			request.getRequestDispatcher("main.jsp?id=" + id).forward(request, response);
//			request.getre
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
}
