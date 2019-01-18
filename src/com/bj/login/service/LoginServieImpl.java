package com.bj.login.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bj.dao.Dao;
import com.bj.dao.DaoImpl;

public class LoginServieImpl implements LoginServle{

	Dao dao=new DaoImpl();

	@Override
	public Map<String, Object> queryByUser(String name) {
	
		try {
			String sql="select username,password FROM user where username='"+name+"'";
		return	dao.executeQueryForMap(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	

}
