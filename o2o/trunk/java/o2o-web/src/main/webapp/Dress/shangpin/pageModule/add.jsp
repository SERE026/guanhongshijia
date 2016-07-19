<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Dress/include/top.jsp" %>
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

<script type="text/JavaScript">
var tb_pathToImage = "<%=request.getContextPath()%>/Dress/img/loadingAnimation.gif";
	function submit(){
	    document.form1.submit();
	}
	

</script>

<script src="<%=request.getContextPath()%>/Dress/js/thickbox-compressed.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/Dress/js/style/thickbox.css" media="screen" rel="stylesheet" type="text/css" />
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/dialog.js"></script>



<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >
	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/pageModule/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/pageModule" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="status" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>添加</strong></td>
  </tr>
  
 <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>页面模块:</td>
  	 <td ><input name="name" id="name"/></td>
  </tr>
  
 <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>是否默认:</td>
  	 <td>
  	 	<input type='radio' name="isDefault"  checked="checked" value="0"/>默认 &nbsp;&nbsp;
  	 	<input type='radio' name="isDefault"    value="1"/>不默认
  	 </td>
  </tr>
</table>
</form>
</td>
</tr>
</table>