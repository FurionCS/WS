<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>组织树型图</title>
       <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/Tree.css" type="text/css">
<link rel="stylesheet" href="css/zTreeStyle.css" type="text/css">
  </head>
  
  <body>
  	<h2>我的组织树型图</h2>
  	<ul id="treeDemo" class="ztree"></ul>
  	<script src="js/jquery-1.9.1.js"type="text/javascript"></script>
  	<script src="js/jquery.ztree.core.js"></script>
  	<script>
  	var setting = {
  			data: {
  				simpleData: {
  					enable: true
  				}
  			}
  			,async: {
  				enable: true,
  				url:"AgentAction_getAgentTreeData",
  				autoParam:["id", "name","level"],
  				dataFilter: filter
  			}
  		};
  		function filter(treeId, parentNode, childNodes) {
  			if (!childNodes) return null;
  			for (var i=0, l=childNodes.length; i<l; i++) {
  				childNodes[i].name = childNodes[i].name.replace('','');
  			}
  			return childNodes;
  		}
  		var zNodes =[
  			{ id:-2, pId:-1, name:"本人",isParent:true,iconOpen:"img/diy/1_open.png", iconClose:"img/diy/1_close.png"}	
  		];
  		$(document).ready(function(){
  			$.fn.zTree.init($("#treeDemo"), setting,zNodes);
  		});
  	</script>
  </body>
</html>
