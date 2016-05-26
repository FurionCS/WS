<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>授权书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/SerachResult.css">
	

  </head>
  
  <body>
  	<div id="powerdiv">
   		<img id="power" alt="代理授权书图片" src="img/power.png">
   		<b id="name"></b>
   		<b id="wxnum"></b>
   		<b id="type">个人</b>
   		<b id="level">总代</b>
   		<b id="startyear">2014</b>
   		<b id="startmonth">02</b>
   		<b id="startday">20</b>
   		<b id="endyear">2016</b>
   		<b id="endmonth">12</b>
   		<b id="endday">31</b>
    </div>
  </body>
</html>