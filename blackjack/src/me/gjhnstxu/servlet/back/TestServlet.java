package me.gjhnstxu.servlet.back;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<String> userNames = Arrays.asList("AAA","BBB","CCC");
		
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String result = null;
		if(userNames.contains(userName)){
			result = "<font color='red'>该用户名已使用</font>";
		}else{
			result = "<font color='blue'>该用户名可使用</font>";
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
