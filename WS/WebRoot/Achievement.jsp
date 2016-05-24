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
	<title>业绩列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Achievement.css" rel="stylesheet" type="text/css" />
	<link href="css/config.css" rel="stylesheet" type="text/css" />
	

  </head>
  
 <body>
<div id="achievement">
	<h1 id="title">我的业绩</h1>
    <div id="achbody">
    </div>
    
    <div id="achTeambody">
    </div>
    <div id="contact">
    	<p>若有疑问请联系微信：cs950211 或者直接致电：15381432412</p>
    </div>
</div>
<script src="js/jquery-1.9.1.js"type="text/javascript"></script>
<script>
getAchievement();
function getAchievement(){
  	  $.ajax({
			   url: "AchievementAction_getAchievementByAgent",
			   type: "POST",
			   dataType: "json",
			   success: function (result) {
				   var achievement=result.achievement;
				   var achievementTeam=result.achievementTeam;
				   if(result.code==1){
					 var html="";
					 html+="<p><b>您的微信号：</b><span>"+achievement.agwxnum+"</span></p>";
					 html+="<p><b>您本月的团队业绩：</b><span>"+achievement.money+"</span></p>";
					 html+="<p><b>您本月的团队奖金：</b><span>"+achievement.team+"</span></p>";
					 html+="<p><b>您本月的个人奖金：</b><span>"+achievement.personmoney+"</span></p>";
					 $("#achbody").html(html);
					 var html2="<p><b>您的下属总代业绩：</b></p>";
					 if(achievementTeam.length>0){
						 for(var i=0;i<achievementTeam.length;i++){
							 html2+="<p><b>"+achievementTeam[i].agname+"</b><b>团队业绩：</b><span>"+achievementTeam[i].team+"</span></p>";
						 }
					 }else{
						 html2="<p>您还没有下属总代业绩</p>";
					 }
					$("#achTeambody").html(html2);
					 
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
</body>
</html>
