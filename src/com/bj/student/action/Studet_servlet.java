package com.bj.student.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bj.student.page.Student_page;
import com.bj.student.service.Student_service;
import com.bj.student.service.Student_serviceImpl;




@SuppressWarnings("serial")
public class Studet_servlet extends HttpServlet{

	Student_service service=new Student_serviceImpl();
	
	protected void service(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, IOException{
		
		
		try {
			System.out.println(1);
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String method=request.getParameter("method");
			String pageIndex=request.getParameter("pageIndex");
			System.out.println(request.getRequestURL());
			if("query".equals(method) ||pageIndex!=null){
				
				this.query(request,response,pageIndex);
				
				
			}else if("editpage".equals(method)){
				
				this.editpage(request,response);
				
			}else if("edit".equals(method)){
				
				this.edit(request,response);
				
			}else if("addPage".equals(method)){
				
				this.addPage(request,response);
				
			}else if("add".equals(method)){
				
				this.add(request,response);
			}else if("delete".equals(method)){
				
				this.delete(request,response);
			}
			
			
			
		
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
			int id=Integer.parseInt(request.getParameter("id")) ;
			service.delete(id);
			try {
				response.sendRedirect(request.getContextPath()+"/student.do?method=query");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
		
		try {
			int sex=Integer.parseInt(request.getParameter("sex"));
					
			String name=request.getParameter("nameadd");
			System.out.println("name"+name);
			int age =Integer.parseInt(request.getParameter("ageadd"));
			service.add(sex,name,age);
			response.sendRedirect(request.getContextPath()+"/student.do?method=query");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addPage(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.getRequestDispatcher("/jsp/student/student_add.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		int sex=Integer.parseInt(request.getParameter("sex"));
		String name=request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		service.update(id,sex,name,age);
		try {
			response.sendRedirect(request.getContextPath()+"/student.do?method=query");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void editpage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�����޸�ҳ�棡");
		int student_id=Integer.parseInt(request.getParameter("id"));
		System.out.println("student_id:"+student_id);
		Map<String,Object> map=service.QueryForMap(student_id);
		System.out.println("��ѯһ���ɹ���map"+map.size());
		request.setAttribute("map", map);
		try {
			request.getRequestDispatcher("/jsp/student/student_edit.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void query(HttpServletRequest request, HttpServletResponse response,String pageIndex1) {
			Student_page page=new Student_page();
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			System.out.println("name:"+name);
			System.out.println("sex:"+sex);
			System.out.println("pageIndex1:"+pageIndex1);
			if(name!=null && !"".equals(name)){
				page.setName(name);
			}
			if(sex!=null && !"".equals(sex)){
				page.setSex(Integer.parseInt(sex));
			}
			page.setCount(service.getStudentCount(page));
			page.setPageCount(3);
			int setPageIndex=1;
			
			if(pageIndex1!=null && !"".equals(pageIndex1)){
				setPageIndex=	Integer.parseInt(pageIndex1);
				
			}
			
			page.setPageIndex(setPageIndex);
			int pageIndex=(page.getPageIndex()-1)*page.getPageCount();
		
			int pages=page.getCount()/page.getPageCount();
			if(page.getCount()%page.getPageCount()!=0){
				pages=page.getCount()/page.getPageCount()+1;
			}
			System.out.println("������"+page.getStartIndex()+"ҳ��"+page.getPageCount());
			page.setPages(pages);
			
			
			page.setStartIndex(pageIndex);
		
			
		// 1.ͨ��service��ȡ����
			List<Map<String,Object>> list=service.queryByStudent(page);
			System.out.println("list"+list);
				// 2.���������ݵ�list ���뵽request��������Ҳ��list
				request.setAttribute("list", list);
				request.setAttribute("page", page);
				// 3.���Ƴ���ת��jspҳ��
				try {
					request.getRequestDispatcher("/jsp/student/student_list.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
}
