<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.bj.student.page.Student_page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/table.css"/>

</head>
<%
	//获取请求的上下文
	String context=request.getContextPath();
%>
<script type="text/javascript">
//当前第几页

function submitForm(actionUrl){
	var formElement=document.getElementById("stuForm");
	formElement.action=actionUrl;
	formElement.submit();
	
}
//上一页
var pageIndex=${page.pageIndex};
function previousPage(){
	if(pageIndex==1){
		
		alert("已经是第一页数据");
		return false;
	}else{

		submitForm("<%=context%>/student.do?pageIndex=${page.pageIndex-1}")
		return true;
	}

	
	
}

//下一页
var pages=${page.pages}
function nextPage(){
	if(pageIndex==pages){
		
		alert("已经是最后一页数据");
		return false;
	}else{

		submitForm("<%=context%>/student.do?pageIndex=${page.pageIndex+1}");
		return true;
		
	}
	
	
}

//首页
function firstPage(){
	if(pageIndex==1){
		alert("已经是第一页数据")
		return false;
	}else{
		submitForm("<%=context%>/student.do?pageIndex=1");
		return true;
	}
	

	
}

//尾页
function lastPage(){
	if(pageIndex==pages){
		alert("已经是最后一页");
		return false;
	}else{
		submitForm("<%=context%>/student.do?pageIndex=${page.pages}");
		return true;
	}
	
}


//删除确认
function confirmTest(student_id){
	if(confirm("是否删除")==true){
		submitForm("<%=request.getContextPath()%>/student.do?method=delete&id="+student_id+"");
		return true;
	}else{
		return false;
	}
	
	
}


</script>
<body>
	<form action="<%=request.getContextPath()%>/student.do?method=query" id="stuForm" method="post">
   姓名<input type="text"  name="name" style="width: 120px" value="${page.name}">
   	 <input type="submit" value="查询">
   	<select name="sex" sytle="width:80px">
   			<option value="">全部</option>
   			<option value="1">男</option>
   			<option value="2">女</option>
   	</select>
   </form>

	<c:choose>
		<c:when test="${not empty list }">

<table align="center" border="1"  bordercolor="green" id="customers" >


		

  <tr>
  <th>
   			<input type="checkbox" name="checkAll">
   		</th>
   <th>序号</th>
  <th>姓名</th>
  <th>年龄</th>
  <th>性别</th>
  
  <th>操作</th>
  </tr>
  		<c:forEach items="${list }" var="list" varStatus="cou">
        <tr>  
         <td><input type="checkbox" name="ids" value="${list.student_id }"></td> 
       <td>${cou.index+1+(page.pageIndex-1)*3}</td>
        <td>${list.name }</td>
        <td>${list.age }</td>
          <td>
          		<c:if test="${list.sex eq 1 }">男</c:if>
        	    <c:if test="${list.sex eq 2 }">女</c:if>
          
          
          </td>
        <td>
		              <a href="<%=request.getContextPath()%>/student.do?method=addPage" id="add">添加</a>
		 <a href="<%=request.getContextPath() %>/student.do?method=editpage&id=${list.student_id}" id="edit">修改</a>
		   <a onclick="confirmTest(${list.student_id})" id="delect">删除</a>
              </td>
        </tr>
  

			
  
  
  </c:forEach>
		
		
		
		
	



  </table>
 
 <br>
 	共${page.count}条记录共${page.pages}页&nbsp;&nbsp;当前第${page.pageIndex }页&nbsp;&nbsp;
 	<a href="#" onclick="firstPage()">首页</a>&nbsp;&nbsp;
 		<a href="#" onclick="previousPage();">上一页</a>&nbsp;&nbsp;
 	 <a href="#" onclick="nextPage();">下一页</a>&nbsp;&nbsp; 
		<a href="#" onclick="lastPage()">尾页</a>
			</c:when>

		<c:otherwise>
			<h1>没有数据</h1>
		
		</c:otherwise>


	</c:choose>
</body>
</html>