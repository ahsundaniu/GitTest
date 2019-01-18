package com.bj.shopping.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingAction  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println(1);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 String parameter = request.getParameter("query");
		
		 queryList(request, response);
	}

	
	public  void queryList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		String number = request.getParameter("number");
		String amount = request.getParameter("amount");
		String repertory = request.getParameter("repertory");
		String balance = request.getParameter("balance");
		
		List<String> list=new ArrayList<String>();
		list.add(number);
		list.add(amount);
		list.add(repertory);
		list.add(balance);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/jsp/voucher/voucherCenterQuery.jsp").forward(request, response);
	}

}