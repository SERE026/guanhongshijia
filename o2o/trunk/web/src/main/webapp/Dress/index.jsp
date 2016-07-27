<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/taglib.jsp" %>
<%--
  ~ Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
  ~ All rights reserved.
  ~
  ~ This file contains valuable properties of  SHENZHEN Eternal Dynasty
  ~ Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
  ~ confidential information, ideas and expressions.    No part of this
  ~ file may be reproduced or distributed in any form or by  any  means,
  ~ or stored in a data base or a retrieval system,  without  the prior
  ~ written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
  ~
  --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><fmt:message key="sys.welcome" /> <fmt:message
		key="sys.name" /></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css" />
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script language="javascript">
function validationCode(){
	var vSpan = document.getElementById('validCode');
	var content ="<img src='<%=request.getContextPath()%>/html/manage/main/validCode?num="+Math.random()+
		"' title='<fmt:message key="login.changeValidCode"/>' onclick='validationCode()' style='cursor:hand;'/>";
	vSpan.innerHTML = content;
}

var lnqbb=window.navigator.userAgent;
var isOk=false;
if(lnqbb.indexOf("IE")>0){
		isOk=true;
}


function go(){
	if($("#j_username").val()==""){
		$("#j_usernamet").html("<fmt:message key='login.user'/>");
		$("#j_username").focus();
		return;
	}
	if($("#j_password").val()==""){
		$("#j_passwordt").html("<fmt:message key='login.pswr'/>");
		$("#j_password").focus();
		return;
	}
	document.form1.submit();
}


	
function resett(){

	var j_usernamet=$("#j_usernamet").innerHTML;
	var j_passwordt=$("#j_passwordt").innerHTML;
	var j_usernamep="j"+$("#j_username").val();
	var j_passwordp="j"+$("#j_password").val();

	if(j_usernamet!=""){
 		$("#j_usernamet").html("");
	}
 
	if(j_passwordt!=""){
 		$("#j_passwordt").html("");
 	}

	if(j_usernamep.indexOf(" ")>0||j_usernamep.indexOf("'")>0||
  	j_usernamep.indexOf("<")>0||j_usernamep.indexOf(">")>0
 	 ){
  		$("#j_usernamet").html("<fmt:message key='login.str'/>");
 	 	$("#j_username").focus();
 	 	return;
 	}
  
	if(j_passwordp.indexOf(" ")>0||j_passwordp.indexOf("'")>0||
  	 j_passwordp.indexOf("<")>0||j_passwordp.indexOf(">")>0){
  	 	$("#j_passwordt").html("<fmt:message key='login.str'/>");
  	 	$("#j_password").focus();
  	 	return;
  	 }
}


</script>
</head>
<link href="<%=request.getContextPath() %>/img/llloo.ico" rel="SHORTCUT ICON" />
<body>
	<form name="form1" action="<c:url value='/j_spring_security_check'/>" method="post">
		<div class="conter1">&nbsp;</div>
<div class="conter">

<div class="logo">
<div class="logo1"><img src="<%=request.getContextPath() %>/img/xitongming.gif" /></div>
<div class="logo2"><fmt:message key="sys.version" /></div>
</div>
<div class="zhong_kuai"><img src="<%=request.getContextPath() %>/img/bg_07_01.gif" /></div>
<div class="zhong">
<div class="zhong_xiao">
<table width="100%" border="0" cellspacing="" cellpadding="5">
  <tr>
    <td width="20%"><img src="<%=request.getContextPath() %>/img/xin_10.gif" /></td>
    <td width="51%">
	<div class="shuru"><input name="j_username" type="text" class="shuru_put" id="j_username"
						onkeyup="resett();" /></div>
	</td>
    <td width="29%">
	<div id="j_usernamet" class="login_input"></div>
	</td>
  </tr>
    <tr>
    <td><img src="<%=request.getContextPath() %>/img/xin_14.gif" /></td>
    <td>
	<div class="shuru"><input name="j_password" type="password" class="shuru_put" id="j_password"
						onkeyup="resett();" /></div>
	</td>
    <td>
	<div id="j_passwordt" class="login_input"></div>
	</td>
  </tr>
    <tr>
    <td><img src="<%=request.getContextPath() %>/img/xin_18.gif" /></td>
    <td>
	<div class="shuru2">
	<input name="j_valid" type="text" class="shuru_put2" onkeyup="resett();" onkeydown="if(event.keyCode==13) go();"/>
	</div>
	<div class="shuru2_left" style="padding-top:10px;"><span id="validCode"></span></div>
	</td>
    <td>
	<div id="j_passwordt" class="login_input"></div>
	</td>
  </tr>
  <tr>
  	<td colspan=3><div style="color:#FF0000; clear:both; padding-top:10px">
				<c:if test="${not empty param.login_error}"><fmt:message key='login.error${param.login_error }'/></c:if>
			</div></td>
  </tr>
</table>
</div>
</div>
<div class="zhong_kuai2"><img src="<%=request.getContextPath() %>/img/bg_07_03.gif" /></div>

<div class="clear"></div>
<div class="zhong_an">
<div class="zhong_an3"><a href="<%=request.getContextPath()%>/" target="_blank"><img src="<%=request.getContextPath() %>/img/logo_a.gif" /></a></div>
<div class="zhong_an1"><a href="javascript:;" onclick="document.form1.reset();"><img src="<%=request.getContextPath() %>/img/xin_21.gif" border="0" /></a></div>
<div class="zhong_an2"><a href="javascript:;" onclick="go();"><img src="<%=request.getContextPath() %>/img/xin_23.gif" border="0" /></a></div>
</div>
<div class="clear"></div>
</div>
<div class="conter2">&nbsp;</div>


</form>
</body>
<script language="javascript">
//框架判断
if(top != this){
	top.location = '<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/index.jsp';
}
validationCode();
</script>
</html>
