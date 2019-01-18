package com.bj.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoImpl implements Dao{
	
	private String sDBDriver ="com.mysql.jdbc.Driver";
	private String sConnStr ="jdbc:mysql://112.74.190.69:3306/test?useUnicode=true&characterEncoding=utf-8";
	private String username="test";
	private String password="daniu";
	
	/**
     * 建立连接
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	public Connection getConnection()  {
		Connection con = null;
		try {
			System.out.println("加载驱动！");
			Class.forName(sDBDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到驱动程序类，加载驱动失败！");
			e.printStackTrace();
		}
		
		try {
			System.out.println("连接数据库！");
			 con=DriverManager.getConnection(sConnStr, username, password);
		} catch (SQLException e) {
			System.out.println("连接数据库失败!");
			e.printStackTrace();
		}
		
		
		return con;
		
		
	}
	
	/**
	 * 查询student列表数
	 * 
	 */
	public List<Map<String,Object>> executeQueryForList(String sql,int[] types,Object[] values){
		Connection connect = this.getConnection();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try {
			System.out.println("查询"+sql);
			PreparedStatement pst = connect.prepareStatement(sql);
			if(types!=null){
				for(int i=0;i<types.length;i++){
					switch (types[i]) {
					case Types.VARCHAR:
						pst.setString(i+1, String.valueOf(values[i]));
						break;

					case Types.INTEGER:
						pst.setInt(i+1,Integer.parseInt(String.valueOf(values[i])));
						break;
					}
					
				}
				
				
			}
			ResultSet rs = pst.executeQuery();
			 	list=this.rsToList(rs);
			this.releaseConnection(rs, pst, connect);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return null;
	}
	
	
	


	@Override
	public Map<String, Object> executeQueryForMap(String sql) throws ClassNotFoundException, SQLException {
			Connection connect = this.getConnection();
			PreparedStatement state = connect.prepareStatement(sql);
			System.out.println("查询一条！");
			ResultSet rs = state.executeQuery();
			
			List<Map<String,Object>> list=this.rsToList(rs);
			if(!list.isEmpty()){
				System.out.println("dao查询一条成功");
				
					return list.get(0);
					
			}
			this.releaseConnection(rs, state, connect);
			System.out.println("dao查询一条失败");
		return null;
	}

	@Override
	public List<Map<String, Object>> executeQueryForList(String sql) throws ClassNotFoundException, SQLException {
		System.out.println("查询多条:"+sql);
		Connection connect=this.getConnection();
		System.out.println("连接正常！");
		PreparedStatement stmt = connect.prepareStatement(sql);

		
		ResultSet rs = stmt.executeQuery();
		List<Map<String,Object>> list=this.rsToList(rs);
		this.releaseConnection(rs, stmt, connect);
		
		return list;
	}
	
	
	
	@Override
	public int executeUpdate(String sql) throws ClassNotFoundException, SQLException {
		 System.out.println("更新-------"+sql);
		 Connection conne = this.getConnection();
		  PreparedStatement stmt = conne.prepareStatement(sql);
		 int count=stmt.executeUpdate();
		 this.releaseConnection(stmt, conne);
		 System.out.println("更新成功----------");
		return count;
	}

	/**
	 * 支持预编译更新
	 * @throws SQLException 
	 * 
	 */
	public int executeUpdate(String sql,int[] types,Object[] values) throws SQLException{
		System.out.println("更新"+sql);
		Connection conn = this.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		
		
		int count = 0;
		try {
			
			if(types!=null){
				for (int i = 0; i < types.length; i++) {
					switch (types[i]) {
					case Types.VARCHAR:
						pst.setString(i+1, String.valueOf(values[i]));
						break;

					case Types.INTEGER:
						pst.setInt(i+1, Integer.parseInt(String.valueOf(values[i])));
						break;
					}
					
					
				}
				
				
			}
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.releaseConnection(pst, conn);
		
		return count;
	}
	
	
	
	
	/**
	 * 将ResultSet中的结果包装成list中装Map的结构
	 * @author 		李世明
	 * @time		2011-05-11
	 * @param		 rs
	 * @return
	 * @throws SQLException
	 */
	private List<Map<String, Object>> rsToList( ResultSet rs ) throws SQLException{
		List<Map<String, Object>> row = new ArrayList<Map<String, Object>>();
		 while (rs.next()) {
			 Map<String, Object> col = new HashMap<String, Object>();
			 for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				 //System.out.println(  rs.getMetaData().getColumnType(i)  );
				 switch( rs.getMetaData().getColumnType(i) ){
			 	 case Types.VARCHAR:
			 		col.put(rs.getMetaData().getColumnName(i), rs.getString(i));
			 		break;
			 	 case Types.INTEGER:
				 	col.put(rs.getMetaData().getColumnName(i), rs.getInt(i));
				 	break;	
			 	 case Types.BLOB:
			 		InputStream in = rs.getBinaryStream(i);

				 	col.put(rs.getMetaData().getColumnName(i), in );
				 	break;	
				 default:
					 col.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				 	break;	
				 }
				 
			 }
			row.add(col);
		}
		 return row;
	}
	
	
	
	
	
	

	@Override
	public int executeQueryForInt(String sql) throws ClassNotFoundException, SQLException {
		int count=0;
	
		Connection conn = this.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			count=rs.getInt("count");
			
		}
		
		System.out.println("查询条数:"+count);
		this.releaseConnection(rs, stmt, conn);
		return count;
	}
	@SuppressWarnings("unused")
	private void releaseConnection(Connection connect) throws SQLException{
	    try {
	        if (connect != null && !connect.isClosed()){
	        	connect.close();
	        }
	    } catch (SQLException se){
	        System.out.println("Close the connection encounter error!\n" + se.getMessage());
	        throw new SQLException("关闭连接异常！");
	    }
	}
	
	private void releaseConnection(Statement stmt, Connection connect) throws SQLException{
	    try {
	        if (stmt != null){
	        	stmt.close();
	        }
	        if (connect != null && !connect.isClosed()){
	        	connect.close();
	        }
	    } catch (SQLException se){
	        System.out.println("Close the connection encounter error!\n" + se.getMessage());
	        throw new SQLException("关闭连接异常！");
	    }
	}
	private void releaseConnection(PreparedStatement pst, Connection connect) throws SQLException{
	    try {
	        if (pst != null){
	            pst.close();
	        }
	        if (connect != null && !connect.isClosed()){
	        	connect.close();
	        }
	    } catch (SQLException se){
	        System.out.println("Close the connection encounter error!\n" + se.getMessage());
	        throw new SQLException("关闭连接异常！");
	    }
	}
	
	private void releaseConnection(ResultSet rs, Statement stmt, Connection connect) throws SQLException{
	    try {
	        if (rs != null){
	            rs.close();
	        }
	        if (stmt != null){
	        	stmt.close();
	        }
	        if (connect != null && !connect.isClosed()){
	        	connect.close();
	        }
	    } catch (SQLException se){
	        System.out.println("Close the connection encounter error!\n" + se.getMessage());
	        throw new SQLException("关闭连接异常！");
	    }
	}
	private void releaseConnection(ResultSet rs, PreparedStatement pst, Connection connect) throws SQLException{
	    try {
	        if (rs != null){
	            rs.close();
	        }
	        if (pst != null){
	            pst.close();
	        }
	        if (connect != null && !connect.isClosed()){
	        	connect.close();
	        }
	    } catch (SQLException se){
	        System.out.println("Close the connection encounter error!\n" + se.getMessage());
	        throw new SQLException("关闭连接异常！");
	    }
	}
	/**
	 * 查询一条支持预编译
	 */
	@Override
	public Map<String, Object> executeQueryForMap(String sql, int[] types, Object[] values)
			throws ClassNotFoundException, SQLException {
		System.out.println("查询一条:"+sql);
			Connection conn = this.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			if(types!=null){
				for (int i = 0; i < types.length; i++) {
					switch (types[i]) {
					case Types.VARCHAR:
						pst.setString(i+1, String.valueOf(values[i]));
						break;

					case Types.INTEGER:
						pst.setInt(i+1, Integer.parseInt(String.valueOf(values[i])));
						break;
					}
					
					
				}
			}
		
			ResultSet rs = pst.executeQuery();
			List<Map<String,Object>> list=this.rsToList(rs);
			if(!list.isEmpty()){
				
				return list.get(0);
					}
			
			this.releaseConnection(pst, conn);
		return null;
	}

	@Override
	public int executeQueryForInt(String sql, int[] types, Object[] values)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}

