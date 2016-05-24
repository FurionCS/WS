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
	<title>查询页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Serach.css" rel="stylesheet" type="text/css" />
	<link href="css/config.css" rel="stylesheet" type="text/css" />	
  </head>
 <body>
 	<div id="serach">
		<form>
	    	<div class="inputdiv">
	            <label for="wxnum">微信号:</label>
	            <input value="" name="wxnum" id="wxnum"/><br />
	        </div>
	        <p id="tip"></p>
	        <a  id="submit" onclick="searchAgent()">查询</a>
	    </form>
	</div>
</body> 
<script src="js/jquery-1.9.1.js"type="text/javascript"></script>
<script>
function searchAgent(){
	var wxnum=$("#wxnum").val().trim();
	if(wxnum==""){ $("#tip").html("请填写账号");return;}
	else{$("#tip").html("");}
  	  $.ajax({
			   url: "AgentAction_getAgentByAgwxnum",
			   type: "POST",
			   data:{"agent.agwxnum":wxnum},
			   dataType: "json",
			   success: function (result) {
				   if(result.code==1){
					   alert("");
				   }else{
					   alert("账号密码错啦");
					   $("#tip").html("该微信号没有授权");
				   }
			      }
			 }); 
}
</script>
</html>
