package com.bj.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @desc �������Ӽ���
 * @author sundaniu
 *time 2018-8-13
 */

public interface  Dao {

	/**
     * ����sql��ѯ�б�����(��ѯһ��)����֧��Ԥ����ķ�ʽ
     * @param sql
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Map<String, Object> executeQueryForMap(String sql) throws ClassNotFoundException, SQLException;
	/**
	 * ����sql��ѯ�б�����(��ѯһ��)��֧��Ԥ����ķ�ʽ
	 * @param sql
	 * @param types
	 * @param ObjectValues
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Map<String, Object> executeQueryForMap(String sql , int[] types,Object[] values) throws ClassNotFoundException, SQLException ;
    
	  /**
     * ����sql��ѯ�б�����(��ѯ����)����֧��Ԥ����ķ�ʽ
     * @param sql
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<Map<String, Object>> executeQueryForList(String sql) throws ClassNotFoundException, SQLException;
	/**
	 * ����sql��ѯ�б�����(��ѯ����)��֧��Ԥ����ķ�ʽ
	 * @param sql
	 * @param types
	 * @param ObjectValues
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Map<String, Object>> executeQueryForList(String sql , int[] types,Object[] values) throws ClassNotFoundException, SQLException ;
    
	

    /**
     * ִ�� ����ɾ���ġ��ȵĲ�������֧��Ԥ����ķ�ʽ
     * @param sql
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	public int executeUpdate(String sql) throws ClassNotFoundException, SQLException ;
	/**
	 * Ԥ����sql������   ֧��insert �� update  �� delete  ���
	 * @param sql
	 * @param types
	 * @param ObjectValues
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	public int executeUpdate(String sql , int[] types,Object[] values) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException ;
	
	/**
	 * Ԥ����sql������   ֧��  select ���
	 * @param sql
	 * @param types
	 * @param ObjectValues
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int executeQueryForInt(String sql ) throws ClassNotFoundException, SQLException ;
	/**
	 * Ԥ����sql������   ֧��  select ���
	 * @param sql
	 * @param types
	 * @param ObjectValues
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int executeQueryForInt(String sql , int[] types,Object[] values) throws ClassNotFoundException, SQLException ;
	
	
}