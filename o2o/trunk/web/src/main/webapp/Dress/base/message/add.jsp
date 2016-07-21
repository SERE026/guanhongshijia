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

<script type="text/JavaScript">

function submit(){
    if(document.getElementById("title").value.length==0){
    	sys_alert("信息标题不能为空！");
    	document.getElementById("title").focus();
    	return;
    }
   	if(document.getElementById("ognz").value.length==0){
   		sys_alert("通知人不能为空位！");
   		document.getElementById("ognzName").focus();
   		return;
   	}
   	sAlert('<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/loading.gif','<fmt:message key="sys.load" />');
   	document.form1.submit();
   	
}

KE.show({id : 'message',
			imageUploadJson:'<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/plugins/file.jsp'
	});

function openOgnzDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/user/selection?fieldId=ognz&fieldName=ognzName&maxSelect=100");
}

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/dialog.js"></script>


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
       	<a href="javascript:submit();"><img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/submit_btn.gif" border="0" /></a>
       </td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();"><img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" /></a>
		</td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/message/list"><img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" /></a>
		</td>
	
		<td>&nbsp;</td>
	</tr>
</table>

</td>
</tr>

<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/message" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="user.login_id" value="${UserInfo.login_id }"/> 
  <table cellspacing="0" cellpadding="0" class="table3_da">
  	<thead>
	<tr>
		<td colspan="6">
			<strong><fmt:message key="sys.add" /></strong>
		</td>
	</tr>
	</thead>
  <tr>
      <td class="discription"><span style="color:#ff0000">*</span>信息标题:</td>
      <td><input type="text" id="title"  name="title" value="" /></td>
  	  <td class="discription">被通知人<span style="color:#ff0000">*</span>:</td>
  	  <td><input type="hidden"  id="ognz" name="ognz" value="" />
  	  <input type="text"  class="inputread" onclick="openOgnzDialog()" id="ognzName" value="" readonly/></td>
  </tr>
  <tr>
  	<td class="discription"><fmt:message key="sys.ps" />:</td>
  	<td colspan=5><textarea  id="message" name="message" style="height:400px;width:800px;"></textarea></td>
  </tr>
</table>
</form>
  </td>
</tr>
</table>
  </body>
</html>
