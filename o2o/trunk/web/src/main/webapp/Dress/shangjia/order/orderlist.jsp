<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/taglib/fmt.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglib/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglib/fn.tld"%>
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

<fmt:setBundle basename="locale" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><fmt:message key="sys.name" /></title>
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/kua.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/human2.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/layer/lib.js"></script>
<script src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/ajax.js"></script>
<style type="text/css">
	.error{color:#ff0000;}
</style>
</head>
<body>

<script type="text/JavaScript">
	var tb_pathToImage = "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/loadingAnimation.gif";
	function submit(){
		if($("#form1").checkall()){
	   	 document.form1.submit();
		}
	}
	
	$(function(){
		$("#post").validate();
	}) ;
	
	var servicePath="<%=request.getContextPath()%>";
	
</script>
<script src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/shangjia/order/merchantOrder.js"></script>
<style>
<!--
.color{color:#fff}
-->
</style>

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/merchantOrder/order" method="post">
	
	<input type="hidden" name="saveId" id="saveId" value="${selectId }" />
	<input type="hidden" name="_method"  value="put" />




<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >
		<!-- 弹出提示 -->
		<c:if test="${tip != null }">
			<script type="text/javascript">alert("${tip}");</script>
		</c:if>
	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
   		<td class="tab2_tou">
			<a href="javascript:submit();" title="<fmt:message key="button.send"/>">
				<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/submit_btn.gif" border="0" />
			</a>
		</td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/merchantOrder/list">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">


<input type="hidden" name="_method" value="PUT"/>
<input type="hidden" name="status" value="0" />
<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
<input type="hidden" name="merchant_order_id" value="${info.merchant_order_id }"/>


  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>排序</strong></td>
  </tr>
   <tr>
    <td class="discription" style="width: 150px;">页面模块名称:</td>
 	 <td>${info.name }</td>
 </tr>
 <tr>
 	<td colspan=4>
 		<table cellspacing="0" cellpadding="0" class="table4_da">
 		<thead>
 			<tr>
 				<td><strong>商家编号</strong></td>
 				<td><strong>商家名称</strong></td>
 				<td><strong>排序序号</strong></td>
 				<td>
 					<a href="javascript:;" class="addGoods color" title="添加商家">添加商家</a>
 				</td>
 			</tr>
 		</thead>
 		<tbody class="goodsBox">
 			<c:forEach items="${DATA}" var="info">
 				<tr >
 					<td>${info.merchant.shangjia_id }
 						<input type="hidden" value="${info.merchant.shangjia_id }" name="merchant_id" />
 					</td>
 					<td>${info.merchant.name }</td>
 					<td class="data" id="${info.merchant.shangjia_id }"><input type="text" name="index" value="${info.index }" dataType="int"/></td>
 					<td><a href="javascript:;" class="delIndex"  delUrl="<%=request.getContextPath() %>/html/manage/merchantOrder/del/order?merchant_order_id=${info.merchant_order_id}">删除</a></td>
 				</tr>
 			</c:forEach>
 			<jsp:include page="<%=Constants.PAGE_JSP%>">
				<jsp:param name="url" value="/html/manage/merchantOrder/list" />
			</jsp:include>
 		</tbody>
 		</table>
 		
 	</td>
 </tr>

</table>

</form>
  </td>
</tr>
</table>
</body>
</html>