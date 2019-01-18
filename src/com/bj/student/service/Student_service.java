package com.bj.student.service;

import java.util.List;
import java.util.Map;

import com.bj.student.page.Student_page;

public interface Student_service {

	/**
	 * 查询student多少条数据
	 * @param page 
	 */
	public int getStudentCount(Student_page page);
	/**
	 * 查询Student表
	 * @param sex 
	 * @param name 
	 * 
	 */
	public List<Map<String,Object>> queryByStudent(Student_page page);
	/**
	 * 查询一条
	 */
	public Map<String,Object> QueryForMap(int student_id);
	/**
	 * 更新Student
	 */
	public void update(int id, int sex, String name, int age);
	/**
	 * 添加Student
	 */
	public void add( int sex, String name, int age);
	/**
	 * 删除
	 */
	public void delete(int id);
		
		
		
	
}
