<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>魔学院-登陆</title>
<style type="text/css">
	body{
		background-image:url("images/20140612194606_ajTXS.jpeg");
	}
#div1{
	width:450px;
	height:400px;
	background-color: 	#FFFFFF ;
	border-radius:10px 10px 10px 10px;
	border:1px solid;
	margin: 120px auto ;
	border-color: #F0F0F0;s
	
}	

*{
	margin:0;
	padding: 0;
	font-size: 16px;
	font-family: "微软雅黑";

}

div{
	display:block;
	border: 1px;
}

#div2{
	background-color: 	#F0F0F0;
	width: 450px; 
	height: 60px; 
	font-family:'微软雅黑';
	border-radius:10px 10px 5px 5px;
	text-align: center;
	line-height: 55px;
	font-size: 18px;
	color: #FF3366;
}
ul li{
list-style: none;
}

#li1{
   	 margin:0px 110px;
		

}

#div3{
	margin-top:50px;

}
#div4{
	margin-top:15px;
	width: 230px;
	height:20px;
}





#div5{
	margin-top:50px;
	width: 250px;
	height: 40px;
	background-color:  #FF3366;
	color: #FFFFFF;
	text-align: center;
	line-height: 40px;
	font-size: 16px;
	border-style: none;
	
}



#span{
	text-align:center;
	font-size: 10px;
	font-family:"微软雅黑";
		width: 230px;
	height:20px;
		
	}


</style >
<script type="text/javascript">

	


function checkPassword(){
	var password=document.getElementById("password").value;
	var pass=document.getElementById("span");
	if(password.length==0){
		pass.innerHTML="请输入密码".fontcolor("red");
		return false;
	}
	
	return true;
}
function checkName(){
	var username=document.getElementById("username").value;
	var name=document.getElementById("span");
	if(username.length==0){
		
		name.innerHTML="请输入账号".fontcolor("red");
		return false;
	}
	
	return true;
	
}


//**
function loginAction(){
	//定义xmlhttpRequest对象	
	
	var name=checkName();
	var pass=checkPassword();
	var password=document.getElementById("password").value;
	var username=document.getElementById("username").value;
	if(name==true &&pass==true){

		console.info("创建XMLHttpRequest对象");
		var xmlhttp;
		if(window.XMLHttpRequest){
			console.info("window.XMLHttpRequset");
			//针对FireFox,Mozillar,Opera,Safari,IE7,IE8  
			xmlhttp=new XMLHttpRequest();
			
		}else{
			console.info("window.ActiveXObject");
			//针对ie 5 ie6
			//两个可以用于创建XMLHttpRequest对象的控件名称，保存在一个js数组中
		 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		
		
		
		xmlhttp.onreadystatechange=function(){
			
			
			console.info("2");
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				console.info(xmlhttp.responseText)
				var jieguo=xmlhttp.responseText;
				if(jieguo=="登陆成功" ){
					window.location.href="<%=request.getContextPath()%>/student.do?method=query";
					
				}else{
					alert(jieguo);
				}
			}
			
			
		}

		
		//设置连接信息（请求方式，请求的url，true表示异步方式交互）

		xmlhttp.open("post","<%=request.getContextPath()%>/login.do?method=query&username="+username+"&"+"password="+password,true);
		//发送数据，开始和服务器进行交互
		xmlhttp.send();
		
		
		
		
		
		
		
	}else{
		false;
	}
	
	
	
	
}
//
</script>
</head>

<body >
	<div id="div1">
		<div id="div2" >密码登陆</div>
		<ul id="ul1">
			<li style="display: block;" id="li1">
				<div id="div3"><input onblur="checkName()" type="text" name="username" id="username" placeholder="账号" style="width: 250px; height: 35px"  /></div>
				<div id="div4"><input  onblur="checkPassword()" type="password" name="password" id="password" placeholder="密码" style="width: 250px;  height: 35px"/></div>
				<input type="submit" id="div5" value="登陆" onclick="loginAction()"></br>
			
				<div id="div4"><span id="span" ></span></div>

			</li>
			
		</ul>
	</div>

</body>
</html>