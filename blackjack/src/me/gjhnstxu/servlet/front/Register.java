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
		
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		
		//获取参数
		String username = request.getParameter("ue");
		String password1 = request.getParameter("pd1");
		String password2 = request.getParameter("pd2");
		
		//判断数据库中是否有该玩家，如没有则进行注册
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
