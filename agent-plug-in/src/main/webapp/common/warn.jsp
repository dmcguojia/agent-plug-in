<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>警告</title>
<link rel="stylesheet" href="../login/css/Default.css" /> 
 <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" /> 
<style>
.message {
    background: #f3f8fc url(../login/images/skin/information.png) 8px 50% no-repeat;
    border: 1px solid #b2d1ff;
    color: #006dba;
    margin: 0px 0 0px 0;
    padding: 2px 2px 2px 30px
}
</style>
<script>
var initTimeOut = 4;//unit:second
function init() {
	if (top.location.href != this.location.href) {
		top.location.href = this.location.href;
	}

	time_sec.innerHTML = initTimeOut;

	setTimeout("countDown();", 1000); //设置每一秒调用一次倒计时函数
}

function countDown() {
	initTimeOut--;
	var time_sec = document.getElementById("time_sec");
	time_sec.innerHTML = initTimeOut;
	if (initTimeOut <= 0) {
		window.location = "<%=basePath%>pages/querymenuAction.action";
	}else{
		setTimeout("countDown();", 1000);
	}	
}
</script>
</head>
<body onload="init()">


<form >
<table width="100%" height="100%">
	<tr>
		<td align="center" valign="middle">
		<table	style=" height:283px; width:620px; background:url(../login/images/loginbg_merchant.jpg) no-repeat 0px 0px;">
			<tr>
				<td>
				<div style="height:213px; width:620px;"></div>
				<div style="height:70px; width:620px;margin:0px auto 0px auto;">
				<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:8px;">
					<tr>
                        <td align="center"></td>
						<td><img alt="warn" style="position:relative;top:13px;right-margin:15px" src="../pictuer/warn.jpg"><span style="font-size:14px;position:relative;top:10px;color:red">警告:此次请求的参数中包含非法的字符,系统将终止本次访问,<span id="time_sec" style="color:black"></span>秒后返回主页面.</span></td>
					</tr>

					<tr> 
						<td height="23" colspan="8" valign="top" id="loginMessage">
						
						</td> 
					</tr>
				</table>
				</div>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
