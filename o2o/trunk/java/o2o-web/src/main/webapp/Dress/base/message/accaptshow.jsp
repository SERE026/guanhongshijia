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
   		sys_alert("部门不能为空位！");
   		document.getElementById("ognzName").focus();
   		return;
   	}
   	sAlert('<%=request.getContextPath()%>/Dress/img/loading.gif','<fmt:message key="sys.load" />');
   	document.form1.submit();
   	
}

KE.show({id : 'message',
			imageUploadJson:'<%=request.getContextPath()%>/Dress/js/plugins/file.jsp'
	});

function openOgnzDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/ognz/selection?fieldId=ognz&fieldName=ognzName&maxSelect=100");
}

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/dialog.js"></script>


<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >
	
	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();"><img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" /></a>
		</td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/accapt/list"><img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a>
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
			<strong><fmt:message key="sys.show" /></strong>
		</td>
	</tr>
	</thead>
  <tr>
      <td class="discription">信息标题:</td>
      <td>${info.title }</td>
      </tr>
  <tr>
  	  <td class="discription">发布人:</td>
  	  <td>
  	  	<c:if test="${info.type==0}">${info.message.user.user_name}</c:if>
								<c:if test="${info.type==1}">系统</c:if>
  	  	</td>
  </tr>
  <tr>
  	  <td class="discription">发送时间:</td>
  	  <td>
  	  	${info.time }
  	  	</td>
  </tr>
  <tr>
  	<td class="discription">消息内容:</td>
  	<td colspan=5><div style="width:800px;">${info.context }</div></td>
  </tr>
</table>
</form>
  </td>
</tr>
</table>
  </body>
</html>
