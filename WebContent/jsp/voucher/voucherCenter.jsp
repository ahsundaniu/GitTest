<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>冲值QQ币</title>

<script type="text/javascript">
  
  function amountNumber(){
	var amount=document.getElementById("amount").value;
	console.info(amount+1);
	var amountSpan=document.getElementById("amountSpan");
	var zz=/^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$/;
	if(amount==""){
		console.info(amount+2);
		amountSpan.innerHTML="数额不能为空".fontcolor("red");
		return false;
	}else if(isNaN(x)||x.replace(/(^\s*)|(\s*$)/g,"")==""){
		amountSpan.innerHTML="请输入数字".fontcolor("red");
	}else{
		amountSpan.innerHTML="";
	}
	
	if (!zz.test(amount)){ 
		amountSpan.innerHTML="请输入合法数据".fontcolor("red");
		} 
	  return true;
  }
  
  
  </script>
</head>

<body>

<form action="<%=request.getContextPath()%>/shopping.do" method="post">
<table>
<tr>
	<td>请输入QQ号码:</td>
	<td><input name="number" ></td>
	<td><span id="numberSpan"></span></td>
</tr>

<tr>
	<td>请输入数额:</td>
	<td><input name="amount" id="amount" ></td>
	<td><span id="amountSpan"></span></td>
</tr>
<tr>
	<td>库存:</td>
	<td><input name="repertory" id="repertory" readonly="readonly" value="100"></td>
</tr>

<tr>
	<td>余额:</td>
	<td><input name="balance" id="balance" readonly="readonly" value="10"></td>
</tr>
<tr>
<td><input type="submit" value="提交订单"></td>


</tr>
</table>

</form>



</body>
</html>