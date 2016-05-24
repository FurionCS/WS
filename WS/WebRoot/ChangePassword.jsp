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
	<title>密码修改</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/changePassword.css" rel="stylesheet" type="text/css" />
	<link href="css/config.css" rel="stylesheet" type="text/css" />

  </head>
  <body>
<div id="LoginBody">
<h2 id="title">密码修改</h2>
<form>
	<div id="formbody">
	<div class="inputdiv">
      <label for="wxnum">微信号</label>
  	  <input name="wxnum" type="text" id="wxnum" class="input" placeholder="请填写您微信号"/><br >   </div>
	<div class="inputdiv">
      <label for="oldpassword">旧密码</label>
  	  <input name="oldpassword" type="password" id="oldpassword" class="input" placeholder="请填写您的旧密码"/><br >   </div>
     <div class="inputdiv">
      <label for="newpassword">新密码</label>
   	   <input name="newpassword" type="password" id="newpassword"  class="input" placeholder="请填写您的新密码"/>
 </div>
 <p id="tip"></p>
<a href="javascript:void(0)" id="submit" onclick="change()">修改</a>
</div>
</form>
<p id="returnlogin"><a href="login.jsp"><-登录</a></p>

</div>
<script src="js/jquery-1.9.1.js"type="text/javascript"></script>
<script>
function change(){
	var wxnum=$("#wxnum").val().trim();
	if(wxnum==""){ $("#tip").html("请填写账号");return;}
	var oldpassword=$("#oldpassword").val().trim();
	if(oldpassword==""){ $("#tip").html("请填写账号");return;}
	else{$("#tip").html("");}
	var newpassword=$("#newpassword").val().trim();
	if(newpassword==""){ $("#tip").html("请填写密码");return;}
	else{$("#tip").html("");}
  	  $.ajax({
			   url: "AgentAction_change",
			   type: "POST",
			   data:{"agent.agwxnum":wxnum,"agent.agpassword":oldpassword,"newpassword":newpassword},
			   dataType: "json",
			   success: function (result) {
				   if(result.code==1){
					   $("#tip").html("修改成功,3秒后跳到登录页面");
					   setTimeout(function(){location.href="login.jsp"},3000);
				   }else if(result.code==0){
					   $("#tip").html("修改失败");
				   }else{
					   $("#tip").html("原账号或密码不正确");
				   }
			    }
			 }); 
}
</script>
</body>
  
</html>
