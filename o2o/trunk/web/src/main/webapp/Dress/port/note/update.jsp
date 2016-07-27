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
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
					<a href="<%=request.getContextPath()%>/html/manage/note/list">
			<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
    <tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/note" method="post">
<input type="hidden" name="_method" value="put" />
<input type="hidden" name="note_id" value="${ info.note_id }"/>
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>修改短信接口</strong></td>
  </tr>
    <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>短信帐号:</td>
  	  <td ><input name="accout" id="accout" value="${ info.accout }" class="noNull" msg="短信帐号不能为空！"/></td>
  </tr>
      <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>密码:</td>
  	  <td ><input name="password" id="password" value="${ info.password }" class="noNull" msg="密码不能为空！"/></td>
  </tr>
      <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>短信帐号:</td>
  	  <td ><input name="address" id="address" value="${ info.address }" class="noNull" msg="短信帐号不能为空！"/></td>
  </tr>
   <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>发送人:</td>
  	  <td ><input name="sendmen" id="sendmen" value="${ info.sendmen }" class="noNull" msg="发送人不能为空！"/></td>
  </tr>
 </table>
</form>
</td>
</tr>
</table>

