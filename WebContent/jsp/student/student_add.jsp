<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="<%=request.getContextPath()%>/student.do?method=add" method="post"   >
     <table>
      
     <tr>
    
      <td>姓名</td>
      <td><input type="text" name="nameadd"  value=""  /></td>
     </tr>
      <tr>
      <td>性别</td>
      <td><input type="radio" name="sex" checked="checked" id="male" value="1">男
	<input type="radio" name="sex" id="female" value="2">女</td>
     </tr>
      <tr>
     <td>年龄</td>
      <td><input type="text" name="ageadd"   value="" /></td>
     </tr>
      <tr>
    
      <td><input type="submit"   value="提交" /></td>
     </tr>
     </table>
     
     
     </form>
</body>
</html>