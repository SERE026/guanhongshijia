<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>QQ登录</title>
<script src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js" type="text/javascript"></script>

<script type="text/javascript">

$(function(){

	var vhash=window.location.hash;
	if(vhash.indexOf("=")>0){
		window.access_token=vhash.substring(vhash.indexOf("=")+1);
		window.access_token=window.access_token.substring(0,window.access_token.indexOf("expires_in")-1);
		var mscript=window.document.createElement("script");
		mscript.src="https://graph.qq.com/oauth2.0/me?access_token="+window.access_token;
		mscript.type="text/javascript";
		
		
		window.document.body.appendChild(mscript);
		
	}
	//resultAjax("https://graph.qq.com/oauth2.0/me?access_token="+window.access_token,"",qqresult,"text")
})


function callback(datas){
	window.location.href="<%=request.getContextPath()%>/qqLogin.html?openid="+datas.openid+"&access_token="+window.access_token
}

</script>
</head>

<body>



</body>
</html>

