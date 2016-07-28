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

<script type="text/JavaScript">
function submit(){
    document.form1.submit();
}
</script>



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
        	<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
		<a href="<%=request.getContextPath()%>/html/manage/coupon/list">
			<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" />
		</a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/coupon" method="post">
<input type="hidden" name="_method" value="PUT"/>
<input type="hidden" name="id" value="${info.id }" />
<input type="hidden" name="isSys" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   <thead>
	<tr>
		<td colspan="6">
			<strong>编辑优惠券</strong>
		</td>
	</tr>
	</thead>
  <tr>
    <td style="width: 20%;" class="discription">优惠卷名:</td>
    <td>
    	<input type="text" id="name" name="name" value="${info.name }" /></td>
    </tr>
	  <tr>
		  <td style="width: 20%;" class="discription">开始时间:</td>
		  <td>
			  <input type="text" id="BEGIN_TIME" name="BEGIN_TIME" value="${info.beginTime }" /></td>
	  </tr>
	  <tr>
		  <td style="width: 20%;" class="discription">结束时间:</td>
		  <td>
			  <input type="text" id="END_TIME" name="END_TIME" value="${info.endTime }" /></td>
	  </tr>
	  <tr>
		  <td style="width: 20%;" class="discription">类型:</td>
		  <td>
			  <input type="text" id="type" name="type" value="${info.type }" /></td>
	  </tr>
	  <tr>
		  <td style="width: 20%;" class="discription">抵扣金额:</td>
		  <td>
			  <input type="text" id="reduceValue" name="reduceValue" value="${info.reduceValue }" /></td>
	  </tr>
	  <tr>
		  <td style="width: 20%;" class="discription">折扣率:</td>
		  <td>
			  <input type="text" id="discountValue" name="discountValue" value="${info.discountValue }" /></td>
	  </tr>
	  <tr>
		  <td style="width: 20%;" class="discription">最大抵扣金额:</td>
		  <td>
			  <input type="text" id="maxAmouont" name="maxAmouont" value="${info.maxAmouont }" /></td>
	  </tr>
	  <tr>
		  <td style="width: 20%;" class="discription">满多少可用:</td>
		  <td>
			  <input type="text" id="constraintValue" name="constraintValue" value="${info.constraintValue }" /></td>
	  </tr>
	  <tr>
		  <td style="width: 20%;" class="discription">是否可以和其他优惠券同时使用:</td>
		  <td>
			  <input type="text" id="sameUse" name="sameUse" value="${info.sameUse }" /></td>
	  </tr>
</table>
</form>
  </td>
</tr>
</table>
  </body>
</html>
