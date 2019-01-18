package com.bj.student.service;

import java.util.List;
import java.util.Map;

import com.bj.student.page.Student_page;

public interface Student_service {

	/**
	 * ��ѯstudent����������
	 * @param page 
	 */
	public int getStudentCount(Student_page page);
	/**
	 * ��ѯStudent��
	 * @param sex 
	 * @param name 
	 * 
	 */
	public List<Map<String,Object>> queryByStudent(Student_page page);
	/**
	 * ��ѯһ��
	 */
	public Map<String,Object> QueryForMap(int student_id);
	/**
	 * ����Student
	 */
	public void update(int id, int sex, String name, int age);
	/**
	 * ���Student
	 */
	public void add( int sex, String name, int age);
	/**
	 * ɾ��
	 */
	public void delete(int id);
		
		
		
	
}
