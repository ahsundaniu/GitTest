package com.bj.student.page;


public class Student_page {
	
	private int pageCount;//每页条数
	private int pageIndex;//页码
	private int count;//总条数
	private int pages;//总页数
	private String name;
	private int sex;
	private int StartIndex;
	
	public Student_page(int pageCount, int pageIndex, int count, int pages, String name, int sex, int startIndex) {
		super();
		this.pageCount = pageCount;
		this.pageIndex = pageIndex;
		this.count = count;
		this.pages = pages;
		this.name = name;
		this.sex = sex;
		StartIndex = startIndex;
	}


	public  Student_page(){
		
	}
	
	

	public int getPageCount() {
		return pageCount;
	}







	public int getStartIndex() {
		return StartIndex;
	}


	public void setStartIndex(int startIndex) {
		StartIndex = startIndex;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}













	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}







	public int getSex() {
		return sex;
	}







	public void setSex(int sex) {
		this.sex = sex;
	}







	public int getPages() {
		return pages;
	}







	public int getPageIndex() {
		return pageIndex;
	}



	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public void setPages(int pages) {
		this.pages = pages;
	}

	
	
	
	
	
	
}
