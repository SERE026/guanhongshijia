<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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

<script language="javascript">
function go(){
	if(document.form1.old_pass.value == ""){
		sys_alert('<fmt:message key="personal.oldpass"/><fmt:message key="sys.alert"/>');
		document.form1.old_pass.focus();
		return;
	}
	if(document.form1.new_pass.value == ""){
		sys_alert('<fmt:message key="personal.newpass"/><fmt:message key="sys.alert"/>');
		document.form1.new_pass.focus();
		return;
	}
	if(document.form1.new_pass1.value == ""){
		sys_alert('<fmt:message key="personal.newpass1"/><fmt:message key="sys.alert"/>');
		document.form1.new_pass1.focus();
		return;
	}
	if(document.form1.new_pass.value != document.form1.new_pass1.value){
		sys_alert('<fmt:message key="personal.newAlert"/>');
		return;
	}
	document.form1.submit();
}
<c:if test="${C_STATUS==0}">
	alert('旧密码不正确！');
</c:if>
<c:if test="${C_STATUS==1}">
	alert("操作成功！");
	window.location.href="<%=request.getContextPath() %>/html/manage/main/exit";
</c:if>
</script>
<%@ include file="/Dress/include/top.jsp" %>
<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >

	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
        <td class="tab2_tou"><a href="javascript:go();">
        	<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/submit_btn.gif" border="0" />
        	</a>
        </td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();"><img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
			</a>
		</td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">
<form name="form1" action="<%=request.getContextPath() %>/html/manage/personal/changePW" method="post">
  <table cellspacing="0" cellpadding="0" class="table4_da">
   <thead>
	<tr>
		<td colspan="2">
			<strong><fmt:message key="personal.changePW" /></strong>
		</td>
	</tr>
	</thead>
  	<tr>
	    <td style="width: 150px;text-align: right;padding-right: 10px;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="personal.oldpass" />:</td>
	    <td>
	    	<input type="password" name="old_pass" value="" />
	    </td>
    </tr>
    <tr>
	    <td style="width: 150px;text-align: right;padding-right: 10px;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="personal.newpass" />:</td>
	    <td>
	    	<input type="password" name="new_pass" value="" />
	    </td>
    </tr>
    <tr>
	    <td style="width: 150px;text-align: right;padding-right: 10px;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="personal.newpass1" />:</td>
	    <td>
	    	<input type="password" name="new_pass1" value="" />
	    </td>
    </tr>
</table>
</form>
</td>
</tr>
</table>
</body>
</html>
