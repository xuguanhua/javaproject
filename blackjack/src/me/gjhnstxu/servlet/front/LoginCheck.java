package me.gjhnstxu.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.gjhnstxu.service.front.FrontService;

public class LoginCheck extends HttpServlet {
	String pd = null;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取请求的参数
		String username = request.getParameter("username");//获取玩家的名字
		String password = request.getParameter("password");//获取玩家的登录密码
		String result = null;
		String passwordmessage = null;
		
		System.out.println("玩家输入的用户名为：" + username + "，密码为： " + password);
		//创建service对象
		FrontService service = new FrontService();
		if(username != null && password == null){
			if(service.ouserName(username)){//表示没有该玩家
				result = "<font color='red'>该玩家不存在</font>";
			}else{
				pd = service.oPassword(username);
				result = "<font color='green'>该玩家可登录</font>";
			}
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(result);
		}

		if(username == null && password != null){
			if(password.equals(pd)){
				passwordmessage = "<font color='green'>该密码正确</font>";
				pd = null;
			}else{
				passwordmessage = "<font color='red'>该密码错误</font>";
			}
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(passwordmessage);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
	
}
