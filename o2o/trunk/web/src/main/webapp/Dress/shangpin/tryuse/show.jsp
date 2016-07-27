<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title><fmt:message key="cg.title" /></title>
<link href="<%=request.getContextPath()%>/css/human2.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/dialog.js"></script>
<script type="text/JavaScript">
	
	function submit(){
	    document.form1.submit();
	}
</script>
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dialog.js"></script>



<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >
	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
   <td class="tab2_tou">
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/tryuseapply/list">
			<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" /></a></td>
<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/tryuseapply" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="status" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>查看试用详细</strong></td>
  </tr>
    <tr>
     <td class="discription" style="width: 150px;">申请会员:</td>
  	 <td >${info.huiyuan.name }</td>
  	 <td class="discription" style="width: 150px;">试用产品:</td>
  	 <td >${info.goods.name }</td>
    </tr>
      <tr>
     <td class="discription" style="width: 150px;">申请时间:</td>
  	 <td >${info.applyDate}</td>
  	 <td class="discription" style="width: 150px;">收件人姓名:</td>
  	 <td >${info.receiveName }</td>
    </tr>
      <tr>
     <td class="discription" style="width: 150px;">收件人电话:</td>
  	 <td >${info.receiveTel }</td>
  	 <td class="discription" style="width: 150px;">收件人手机:</td>
  	 <td >${info.receivePhone }</td>
    </tr>
      <tr>
     <td class="discription" style="width: 150px;">收件人地址:</td>
  	 <td >${info.province.name }-${info.city.name }-${info.county.name }-${info.address }</td>
  	 <td class="discription" style="width: 150px;">邮编:</td>
  	 <td >${info.code }</td>
    </tr>
     <tr>
     <td class="discription" style="width: 150px;">email:</td>
  	 <td >${info.email }</td>
  	    <td class="discription" style="width: 150px;">审核状态:</td>
  	 <td >
	<c:if test="${info.applytype=='0'}">审核未通过</c:if>
	<c:if test="${info.applytype=='1'}">审核通过</c:if>
</td>
    </tr>
     <tr>
     <td class="discription" style="width: 150px;">申请理由:</td>
  	 <td colspan="3">${info.reason }</td>
    </tr>
</table>
</form>
</td>
</tr>
</table>
  </body>
</html>
