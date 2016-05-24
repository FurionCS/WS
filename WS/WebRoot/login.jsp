<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<title>总代登录</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/login.css" rel="stylesheet" type="text/css" />
	<link href="css/config.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  <div id="LoginBody">
<h2 id="title">总代登录</h2>
<form>
<div id="formbody">
	<div class="inputdiv">
      <label for="wxnum">微信号</label>
  	  <input name="wxnum" type="text" id="wxnum" class="input" placeholder="请填写您的微信号"/><br >   </div>
     <div class="inputdiv">
      <label for="password">密码</label>
   	   <input name="password" type="password" id="password"  class="input" placeholder="请填写您的密码"/> 	  
 </div>
  <p id="tip"></p>
<a href="javascript:void(0)"  id="submit" onclick="login()">登录</a>
</div>
</form>
<p id="changepassword"><a href="ChangePassword.jsp">修改密码-></a></p>
</div>
</body>
<script src="js/jquery-1.9.1.js"type="text/javascript"></script>
<script>

function login(){
	var wxnum=$("#wxnum").val().trim();
	if(wxnum==""){ $("#tip").html("请填写账号");return;}
	else{$("#tip").html("");}
	var password=$("#password").val().trim();
	if(password==""){ $("#tip").html("请填写密码");return;}
	else{$("#tip").html("");}
  	  $.ajax({
			   url: "AgentAction_login",
			   type: "POST",
			   data:{"agent.agwxnum":wxnum,"agent.agpassword":password},
			   dataType: "json",
			   success: function (result) {
				   if(result.code==1){
					   location.href="Achievement.jsp";
				   }else{
					   alert("账号密码错啦");
					   $("#tip").html("账号或密码不正确");
				   }
			      },
			   error:function(XMLHttpRequest, textStatus, errorThrown) {
				   alert(XMLHttpRequest.status);
				   alert(XMLHttpRequest.readyState);
				   alert(textStatus);
			   }
			 }); 
}
</script>
</html>
