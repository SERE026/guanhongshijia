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
        	<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/aadvwz/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>

<tr>
	<tr><td></td></tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/aadvwz" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="id" value=""/>
<input type="hidden" name="name" value=""/>
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4" ><strong>新增广告位置</strong></td>
  </tr>
    <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>位置名称:</td>
  	  <td ><input name="advwz_title" id="advwz_title" class="noNull" msg="位置名称不能为空！"/></td>
  </tr>
    <tr>
    <td class="discription" style="width: 150px;" ><span style="color:#ff0000">*</span>广告类型:</td>
									<td>
							<select name="advwz_type" class="noNull" msg="广告类型不能为空！" style="width:173px; height:23px;" >
									 <option id="fkzt1" value="">请选择</option>
									 <option value="2" >幻灯片</option>
						  <option value="1" >图片</option>
						  <option value="0" >flash</option>
						</select>
									</td>
									</tr>
     <tr>
     <td class="discription"  style="width: 150px;"><span style="color:#ff0000">*</span>高度:</td>
  	  <td ><input name="advwz_height" id="advwz_height" dataType="int" value="10"  class="noNull" msg="高度不能为空！"/></td>
  </tr>
     <tr>
     <td class="discription"  style="width: 150px;"><span style="color:#ff0000">*</span>宽度:</td>
  	  <td ><input name="advwz_width" id="advwz_width" dataType="int" value="10"  class="noNull" msg="宽度不能为空！"/></td>
  </tr>

 </table>
</form>
</td>
</tr>
</table>

