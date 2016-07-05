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

<script type="text/javascript">
	function submit(){
		if($("#form1").checkall()){
		document.form1.submit();
	}
}
$(function(){
   $("form1").validate();
	inputKey($("#name"),"<%=request.getContextPath()%>/html/manage/payment/selection","name","wlcompany_id");
});

</script>
<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2">
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
					<a href="<%=request.getContextPath()%>/html/manage/payment/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>

<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/payment/update" method="post">
<input type="hidden" name="_method" value="put" />
<input type="hidden" name="order_id" value="${ info.order_id }"/>
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>送货</strong></td>
  </tr>
    <tr class="sangj">
  	   <td style="width: 20%;" class="discription" >订单编号:</td>
  	  <td style="width: 30%;">${ info.order_id }</td>
  	  <td style="width: 20%;" class="discription" >
       <span style="color: red;">*</span> 物流编号:
     </td>
  	  <td  style="width: 30%;">
  	  <input name="dlyCode" id="dlyCode" value="${info.dlyCode }"  class="noNull" msg="物流编号不能为空！"/>
	</td>
  </tr>
  <tr>
  <td style="width: 20%;" class="discription" >
       <span style="color: red;">*</span> 物流公司:
     </td>
  	  <td  style="width: 30%;">
  	  <input type="text" name="name" id="name" msg="请选择物流公司。" class="noNull" mappendBy="wlcompanyId" value="${info.wlcompany.name}"/>
	   <input type="hidden" name="wlcompanyId" id="wlcompanyId" value="${info.wlcompany.wlcompany_id}"/>
	</td>
  </tr>
 </table>
</form>
</td>
</tr>
</table>
<div id="boxpro" class="position" style="display:none;width:350px;position:absolute;z-index:300;height:600px;overflow-y:auto;overflow-x:hidden;background-color:#ffffff;padding:5px;border:#cccccc solid 2px;">
   		
   </div>
