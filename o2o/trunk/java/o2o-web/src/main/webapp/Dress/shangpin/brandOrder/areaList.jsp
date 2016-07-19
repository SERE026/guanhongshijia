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
	$(function(){
		address("provinceId","cityId","countyId","<%=request.getContextPath()%>/html/manage/area/json/selection");
	})
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
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath()%>/html/manage/brandOrder/list" method="post">
<input type="hidden" name="status" value="0" />

  <table cellspacing="0" cellpadding="0" class="table3_da">
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>品牌排序</strong></td>
  </tr>
   <tr>
    <td class="discription" style="width: 150px;">选择排序城市:</td>
 	 <td>
 	 	
 	 	<select id="provinceId" name="provinceId"></select>
 	 	<select id="cityId"  name="cityId"></select>
 	 	<select id="countyId" style="display:none"></select>
 	 	<a href="javascript:document.form1.submit();">对选择的城市品牌模块排序</a>
 	 	<a href="<%=request.getContextPath()%>/html/manage/brandOrder/list">对全国品牌排序</a>
 	 </td>
 </tr>
 
</table>

</form>
  </td>
</tr>
</table>
</body>
</html>