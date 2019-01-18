package com.bj.student.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import com.bj.dao.Dao;
import com.bj.dao.DaoImpl;
import com.bj.student.page.Student_page;

public class Student_serviceImpl implements Student_service{
	Dao dao=new DaoImpl();
	List<Map<String,Object>> list=null;
	Map<String,Object> map;
	@Override
	public int getStudentCount(Student_page page) {
		StringBuilder sub=new StringBuilder("select count(*) as count from student1 where 1=1 " );
		if(page.getName()!=null&& !"".equals(page.getName())){
			String name="%"+page.getName()+"%";
			sub.append(" and name like '"+name+"'  ");
		}
		if(page.getSex()!=0){
			sub.append(" and sex="+page.getSex()+" ");
		}

		int count=0;
		String sql=String.valueOf(sub);
		try {
			return count=dao.executeQueryForInt(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public List<Map<String, Object>> queryByStudent(Student_page page) {
	
			
			
			
			
			
			try {
				StringBuilder sub=new StringBuilder("select * from student1 where 1=1 ");
				
				if(page.getName()!=null&& !"".equals(page.getName())){
					String name="%"+page.getName()+"%";
					sub.append(" and name like '"+name+"'");
				}
				if(page.getSex()!=0){
					sub.append(" and sex="+page.getSex()+" ");
				}
				
				sub.append(" limit ?,?");
				String sql=String.valueOf(sub);
				int [] types=new int[2];
				types[0]=Types.INTEGER;
				types[1]=Types.INTEGER;
				
				Object[] values=new Object[2];
				values[0]=page.getStartIndex();
				values[1]=page.getPageCount();
				list= dao.executeQueryForList(sql,types,values);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
			return list;
		
		
	}

	@Override
	public Map<String, Object> QueryForMap(int student_id) {
		try {
			String sql="select * from student1 where student_id=?";
			int [] types=new int[1];
			types[0]=Types.INTEGER;
			Object[] values=new Object[1];
			values[0]=student_id;
			
			
			
			
			map=dao.executeQueryForMap(sql,types,values);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("≤È—Ø¥ÌŒÛ£°");
			e.printStackTrace();
			
		}
		
		
		return map;
		
	}

	@Override
	public void update(int id, int sex, String name, int age) {
		 String sql="update student1 set name=?, sex=?,age=? where student_id=? ";
		 int [] types=new int[4];
		 types[0]=Types.VARCHAR;
		 types[1]=Types.INTEGER;
		 types[2]=Types.INTEGER;
		 types[3]=Types.INTEGER;
		 
		 Object[] values=new Object[4];
		 values[0]=name;
		 values[1]=sex;
		 values[2]=age;
		 values[3]=id;
		 
		 
		 
		try {
			dao.executeUpdate(sql,types,values);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void add( int sex, String name, int age) {
		String sql="insert INTO student1(name,age,sex) values(?,?,?)";
		int[] types=new int[3];
		types[0]=Types.VARCHAR;
		types[1]=Types.INTEGER;
		types[2]=Types.INTEGER;
		
		Object[] values=new Object[3];
		values[0]=name;
		values[1]=age;
		values[2]=sex;
		
		try {
			dao.executeUpdate(sql,types,values);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from student1 where student_id=?";
		int[] types=new int[1];
		types[0]=Types.INTEGER;
		
		Object[] values=new Object[1];
		values[0]=id;
		
		
		try {
			dao.executeUpdate(sql,types,values);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	


}
