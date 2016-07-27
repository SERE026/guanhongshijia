<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/top.jsp" %>
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

<script type="text/javascript">
	function submit(){
		if($("#form1").checkall()){
		document.form1.submit();
	}
}
$(function(){
	$("#form1").validate();
})
</script>
<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2">
	<tr><td></td></tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
					<a href="<%=request.getContextPath()%>/html/manage/order/list">
			<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
		<td>
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong>订单信息</strong>
					</td>
				</tr>
				</thead>
				
				<tr>
					<td colspan="6" style="text-align: center;height: 34px;font-size: 15px;">
						<strong>订单商品信息:</strong>
					</td>
				</tr>
				<tr class="tdBg">
				  <td style="width:15%">商品名称</td>
				  <td style="width:15%">商品价格</td>
				  <td style="width:15%">购买数量</td>
				  <td style="width:15%">商品重量</td>
				  <td style="width:15%">活动优费</td>
				  <td style="width:25%">商品属性</td>
				</tr>
				<c:forEach var='Info' items='${info.orderProductList}' varStatus='index'>
				  <tr>
				  <td>${Info.product.name }</td>
				  <td>${Info.goodMoney }</td>
				  <td>${Info.num }</td>
				  <td>${Info.widget }(g)</td>
				  <td><c:if test="${not empty Info.act }">${Info.actMoney }(${Info.act.name })</c:if></td>
				  <td>${Info.goodSpec }</td>
				   </tr>
				</c:forEach>
					<tr>
					<td colspan="6" style="text-align: center;height: 34px;font-size: 15px;">
						<strong>订单金额:</strong>
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">原始金额：</td>
					<td colspan=2>
					￥${info.originalPrice }
					</td>
					<td style="width: 20%;" class="discription">商品金额：</td>
					<td colspan=2>
					￥${info.goodsPrice }
					</td>
					</tr>
					<tr class="sangj">
					<td style="width: 20%;" class="discription">配送费用：</td>
					<td colspan=2>
					￥${info.shippingPrice }
					</td>
					<td style="width: 20%;" class="discription">保价费用：</td>
					<td colspan=2>
					￥${info.protectPrice}
					</td>
					</tr>
					<tr class="sangj">
					<td style="width: 20%;" class="discription">优费金额：</td>
					<td colspan=2>
					￥${info.discountPrice}
					</td>
					<td style="width: 20%;" class="discription">订单金额：</td>
					<td colspan=2>
					￥${info.orderPrice }
					</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: center;height: 34px;font-size: 15px;">
						<strong>购买人信息:</strong>
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">用户名：</td>
					<td colspan=2>
					${info.huiyuan.name }
					</td>
					<td style="width: 20%;" class="discription">姓名：</td>
					<td colspan=2>
					${info.huiyuan.userName }
					</td>
					</tr>
					<tr>
						<td style="width: 20%;" class="discription">手机：</td>
					<td colspan=2>
					${info.huiyuan.phone }
					</td>
						<td style="width: 20%;" class="discription">邮箱：</td>
					<td colspan=2>
						${info.huiyuan.email }
					</td>
					</tr>
				<c:if test="${info.dly=='1'}">
				<tr>
					<td colspan="6" style="text-align: center;height: 34px;font-size: 15px;">
						<strong>收货人信息 :</strong>
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">姓名：</td>
					<td colspan=2>
						${info.receiveName }
					</td>
					<td style="width: 20%;" class="discription">电话：</td>
					<td colspan=2>
					${info.receiveTel }
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">手机：</td>
					<td colspan=2>
						${info.receivePhone }
					</td>
					<td style="width: 20%;" class="discription">邮政编码：</td>
					<td colspan=2>
					${info.code }
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">地址：</td>
					<td colspan=5>
						${info.province.name }${info.city.name }${info.county.name }${info.address }
					</td>
				</tr>
				
				</c:if>
				<tr>
					<td colspan="6" style="text-align: center;height: 34px;font-size: 15px;">
						<strong>其它信息 :</strong>
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">配送方式：</td>
					<td colspan=2>
							<c:if test="${info.dly=='0'}">上门提货</c:if>
							<c:if test="${info.dly=='1'}">物流</c:if>
					</td>
					<td style="width: 20%;" class="discription">支付方式：</td>
					<td colspan=2>
					   ${info.playType.name}
					</td>
				</tr>
</table>

