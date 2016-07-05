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

<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >
	
	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">



</td>
</tr>
<tr height="5">
    <td colspan="6" style="width:34px; height:5px; border:none">&nbsp;</td>
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
      <td class="discription"><span style="color:#ff0000">*</span>信息标题:</td>
      <td>${info.title }</td>
      </tr>
  <tr>
  	  <td class="discription">被通知人<span style="color:#ff0000">*</span>:</td>
  	  <td>
  	  	<c:forEach items="${info.accaptList}" var="accapt">
								${accapt.user.user_name }、  	  	
					  	  	</c:forEach>
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
  	<td colspan=5><div style="width:800px;">${info.message }</div></td>
  </tr>
</table>
</form>
  </td>
</tr>
</table>
  </body>
</html>
