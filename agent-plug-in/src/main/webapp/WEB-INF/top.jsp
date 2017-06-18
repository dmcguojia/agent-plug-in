<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>银联商户服务系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="description" content="title"/>
	 <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="js/themes_backup/cupertino/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="js/themes_backup/icon.css"/>
	<link rel="stylesheet" type="text/css" href="css/base.css"/>
	<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css"/>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery.autocomplete.min.js"></script> 
	<script type="text/javascript" src="js/json2.js"></script> 
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/function.js"></script> 
	<script type="text/javascript" src="js/jquery.PrintArea.js"></script>
	<script type="text/javascript" src="js/jquery.maxlength.js"></script>
	<script type="text/javascript" type="text/javascript" src="<%=basePath%>js/jqueryAjaxExtend.js"></script>
	<script type="text/javascript">
	$().ready(function(){
	 	$.messager.defaults={ok:"确定",cancel:"取消"};
	 	$().maxlength();
	}); 
	
	</script>
  </head>
  

 	