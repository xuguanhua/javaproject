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
public class RegisterCheck extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		
		//获取参数
		String userName = request.getParameter("ue");
		String password1 = request.getParameter("pd1");
		String password2 = request.getParameter("pd2");

		FrontService service = new FrontService();
		ArrayList<String> allNames = service.allNames();
		String result = null;
		String password = null;

			if(userName != null && password1 == null){
				if(allNames.contains(userName)){
					result = "<font color='red'>该用户名已使用</font>";
				}else{
					result = "<font color='blue'>该用户名可使用</font>";
				}
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(result);
			}
			
			if(password1 != null && password2 != null){
				if(password1.equals(password2)){
					password = "<font color='blue'>两个密码相同</font>";
				}else{
					password = "<font color='red'>两个密码不同</font>";
				}
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(password);
			}
	}

	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
}

