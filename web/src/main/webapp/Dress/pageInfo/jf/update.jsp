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
<body>
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
			<a href="<%=request.getContextPath()%>/html/manage/jfadd/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>

<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/jfadd" method="post">
<input type="hidden" name="_method" value="put" />
<input type="hidden" name="jffa_id" value="${ info.jffa_id }"/>
 <table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong>编辑方案</strong>
					</td>
				</tr>
				</thead>
						<tr class="sangj">					
							<td style="width: 20%;" class="discription">每1元等于多少积分：</td>
							<td>
								<input name="jffa_jfdk" type="text" dataType="float" value="${info.jffa_jfdk }" class="noNull isfloat" msg="每1元等于多少积分不能为空！"/>积分
							</td>
							
						</tr>
			</table>
</form>
</td>
</tr>
</table>

  </body>
