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
/*$(function(){
		address("provinceId","cityId","countyId","<%=request.getContextPath()%>/html/manage/area/json/selection");
		$("#provinceId").change(function(){
			map.centerAndZoom($("#provinceId option:selected").text(),8); 
		});
		$("#cityId").change(function(){
			map.centerAndZoom($("#cityId option:selected").text(),15); 
		});
		$("#countyId").change(function(){
			map.centerAndZoom($("#countyId option:selected").text(),16); 
		});
	})*/
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
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" /></a></td>
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
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/order" method="post">
<input type="hidden" name="_method" value="put" />
<input type="hidden" name="order_id" value="${ info.order_id }"/>
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>修改订单信息</strong></td>
  </tr>
               <tr>
					<td colspan="6" style="text-align: center;height: 34px;font-size: 15px;">
						<strong>订单金额:</strong>
					</td>
				</tr>
    <tr class="sangj">
     <td style="width: 20%;" class="discription" >订单编号：</td>
  	  <td >${ info.order_id }</td>
  	    <td style="width: 20%;" class="discription" >订单状态：</td>
  	  <td >

						 <c:if test="${info.state=='0' }">	等待付款 </c:if>
						 <c:if test="${info.state=='1' }">	已付款 </c:if>
						 <c:if test="${info.state=='2' }">	已发货  </c:if>
						 <c:if test="${info.state=='3' }">	交易完成 </c:if>
						 <c:if test="${info.state=='4' }">	申请退款 </c:if>
						 <c:if test="${info.state=='5' }">	申请退货 </c:if>
						 <c:if test="${info.state=='6' }">	交易失败 </c:if>
		  				 <c:if test="${info.state=='7' }">	确认付款 </c:if>
		  				 <c:if test="${info.state=='8' }">	确认已收款 </c:if>

  	  
  	  </td>
  </tr>
  <tr class="sangj">
					<td style="width: 20%;" class="discription">商品总额：</td>
					<td >
					￥${info.orderPrice}
					</td>
					<td class="discription" style="width: 150px;">
								<span style="color: red;"></span>优惠价格：
							</td>
							<td>
								￥${info.discountPrice }
							<%--<input type="text" name="discountPrice" id="discountPrice" value="${info.discountPrice }"/>--%>
				            </td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: center;height: 34px;font-size: 15px;">
						<strong>支付备注，代理商填写，用于线下支付填写付款人、付款帐号等:</strong>
					</td>
				</tr>
	<%--			<tr class="sangj">
					<td style="width: 20%;" class="discription">收货人姓名：</td>
					<td >
					  	  <input type="text" name="receiveName" id="receiveName" value="${info.receiveName }" class="noNull" msg="收货人姓名不能为空！"/>
					</td>
					<td style="width: 20%;" class="discription">收货人电话：</td>
					<td >
					<input type="text"  name="receiveTel" id="receiveTel" value="${info.receiveTel }" />
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">收货人手机：</td>
					<td >
						<input type="text"  name="receivePhone" id="receivePhone" value="${info.receivePhone }" class="noNull" msg="收货人手机不能为空！"/>
					</td>
					<td style="width: 20%;" class="discription">收货人邮政编码：</td>
					<td >
					<input type="text" name="code"  id="code" value="${info.code }" class="noNull" msg="邮政编码不能为空！"/>
					</td>
				</tr>
				<tr class="sangj">
				 <td class="discription">
								<span style="color: red;">*</span>联系人地址：
							</td>
							<td colspan=4>
								<div style="float:left;width:200px;">
								<select name="province.id" id="provinceId" dataVal="${info.province.id }">
									<option value="">--请选择--</option>
								</select>
								省
								</div>
								<div style="float:left;margin-left:10px;width:200px;">
								<select  name="city.id" id="cityId" dataVal="${info.city.id }">
									<option value="">--请选择--</option>
								</select>
								市
								</div>
								<div style="float:left;margin-left:10px;width:200px;">
								<select name="county.id" id="countyId" dataVal="${info.county.id }">
									<option value="">--请选择--</option>
								</select>
								县
								</div>
							</td>
				</tr>--%>
				<tr>
				<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>支付备注：
							</td>
							<td colspan=3>
							<input type="text" name="payDesc" id="payDesc" value="" style="width: 500px;" class="noNull" msg="支付备注不能为空！"/>
				            </td>
				</tr>
 </table>
</form>
</td>
</tr>
</table>

