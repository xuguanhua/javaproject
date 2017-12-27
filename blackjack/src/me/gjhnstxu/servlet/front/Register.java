package me.gjhnstxu.servlet.front;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.gjhnstxu.service.front.FrontService;

@SuppressWarnings("serial")
public class Register extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		
		//��ȡ����
		String username = request.getParameter("ue");
		String password1 = request.getParameter("pd1");
		String password2 = request.getParameter("pd2");
		
		//�ж����ݿ����Ƿ��и���ң���û�������ע��
		FrontService service = new FrontService();
//		System.out.println(service.ouserName(username));
		if(service.ouserName(username)){
			if(service.passwordIsSame(password1, password2)){
				service.registerPlayer(username, password1);
				
			}
		}
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	

	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
}
