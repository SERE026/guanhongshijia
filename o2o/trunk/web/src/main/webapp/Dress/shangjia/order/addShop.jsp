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
		if($("#form1").checkall()){
	   	 document.form1.submit();
		}
	}
	$(function(){
		$("#form1").validate();
		$(".delIndex").click(function(){
			$(this).parent().parent().remove();
		})
	}) ;
	var servicePath="<%=request.getContextPath()%>";
	
</script>
<style>
<!--
.color{color:#fff}
-->
</style>

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
			<a href="javascript:submit();" title="<fmt:message key="button.send"/>">
				<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" />
			</a>
		</td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/goodsOrder/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/merchantOrder/addGoods/order" method="post">
<input type="hidden" name="_method" value="PUT"/>
<input type="hidden" name="status" value="0" />
<input type="hidden" name="merchant_order_id" value="${info.merchant_order_id }"/>

  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>排序</strong></td>
  </tr>
   <tr>
    <td class="discription" style="width: 150px;">页面模块名称:</td>
 	 <td>
 	 ${info.name }
 	 </td>
 </tr>
 <tr>
 	<td colspan=4>
 		<table cellspacing="0" cellpadding="0" class="table3_da">
 		<thead>
 			<tr>
 				<td><strong>商家编号</strong></td>
 				<td><strong>商家名称</strong></td>
 				<td><strong>商品城市</strong></td>
 				<td><strong>排序序号</strong></td>
 				<td><strong>操作</strong></td>
 			</tr>
 		</thead>
 		<tbody class="goodsBox">
 			<c:forEach items="${list}" var="good" varStatus="index">
 				<tr>
 					<td>${good.shangjia_id }</td>
 					<td>
 						${good.name }
 						<input type="hidden" value="${good.shangjia_id }" name="shangjia_id" />
 					</td>
 					<td>${good.city.name }</td>
 					<td><input type="text" name="index" value="${index.count }" /></td>
 					<td><a href="javascript:;" class="delIndex">删除</a></td>
 				</tr>
 			</c:forEach>
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