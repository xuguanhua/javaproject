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
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ����Ĳ���
		String username = request.getParameter("username");//��ȡ��ҵ�����
		String password = request.getParameter("password");//��ȡ��ҵĵ�¼����
		String result = null;
		String passwordmessage = null;
		
		System.out.println("���������û���Ϊ��" + username + "������Ϊ�� " + password);
		//����service����
		FrontService service = new FrontService();
		if(username != null && password == null){
			if(service.ouserName(username)){//��ʾû�и����
				result = "<font color='red'>����Ҳ�����</font>";
			}else{
				pd = service.oPassword(username);
				result = "<font color='green'>����ҿɵ�¼</font>";
			}
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(result);
		}

		if(username == null && password != null){
			if(password.equals(pd)){
				passwordmessage = "<font color='green'>��������ȷ</font>";
				pd = null;
			}else{
				passwordmessage = "<font color='red'>���������</font>";
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
