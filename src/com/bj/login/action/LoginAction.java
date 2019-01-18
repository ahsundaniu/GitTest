package com.bj.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bj.login.service.LoginServieImpl;
import com.bj.login.service.LoginServle;


public class LoginAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,HttpServletResponse response){
		
		LoginServle service=new LoginServieImpl();
		String username =request.getParameter("username");
		String password=request.getParameter("password");
		response.setCharacterEncoding("UTF-8");
		loginAction(response, request,username,password);
	}
	
	public void loginAction(HttpServletResponse response,HttpServletRequest request, String username, String password){
		
		try {
			LoginServle service=new LoginServieImpl();
		
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			Map<String,Object> map = new HashMap<String,Object>(); 
			  map = service.queryByUser(username);
		
			  System.out.println("user----"+map);
		
			if(map == null || map.size() == 0){
				writer.print("账号错误,请重新输入");//
			}else{
				String name=null;
				String pass=null;
				
				name = (String) map.get("username");
				pass=(String) map.get("password");
				
				if(password.equals(pass) && username.equals(name)){
				
					writer.print("登陆成功");
					
					
				}else{
					writer.print("密码错误,请重新输入");
					
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	

}
