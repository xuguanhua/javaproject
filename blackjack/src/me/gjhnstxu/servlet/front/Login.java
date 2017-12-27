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
		
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取请求的参数
		String username = request.getParameter("username");//获取玩家的名字
		String password = request.getParameter("password");//获取玩家的登录密码
		String room = request.getParameter("room");//获取玩家进入的房间号
		String result = null;

		
		System.out.println("玩家输入的用户名为：" + username + "，密码为： " + password);
		//创建service对象
		FrontService service = new FrontService();

		/**
		 * 在数据库中查询是否有该玩家
		 * 如果有该玩家，则跳转到index.jsp即玩家游戏的页面，否则跳转回登录的页面
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
