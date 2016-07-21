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
<script type="text/javascript">
	var servicePath="<%=request.getContextPath()%>";
	function submit(){
		if($("#form1").checkall()){
		document.form1.submit();
	}
}
$(function(){
	$("#form1").validate();
})
</script>
<script src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/shangpin/brandOrder/merchantOrder.js"></script>
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
        	<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/brandOrder/list">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/brandOrder" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="status" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>添加</strong></td>
  </tr>
  
 <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>选择品牌:</td>
  	 <td >
  	 	<select name="brand.brand_id">
  	 		<c:forEach items="${brandList}" var="brand">
  	 			<option value="${brand.brand_id }">${brand.name }</option>
  	 		</c:forEach>
  	 	</select>
  	 
  	 </td>
  </tr>
  <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>品牌商家:</td>
  	 <td >
  	 		<input type="text" name="brandMerchants.name"  value="" id="brandMerchants"  class="noNull" msg="品牌商家不能为空！"/>
  	 		<input type="hidden" name="brandMerchants.shangjia_id" id="brandMerchantsId" value=""  class="noNull" msg="品牌商家不能为空！"/>
  	 </td>
  </tr>
   <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>排序:</td>
  	 <td ><input name="indexs" id="indexs" value="1" dataType="int" class="noNull" msg="排序不能为空！"/></td>
  </tr>
  
</table>
</form>
</td>
</tr>
</table>
  </body>
</html>
