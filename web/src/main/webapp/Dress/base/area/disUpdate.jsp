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
    if($("#ognz_name").val() == ""){
    	sys_alert("区域名不能为空！");
    	$("#ognz_name").focus();
    	return;
    }
    document.form1.submit();
}
function openDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/area/selection?fieldId=parent1&fieldName=parent1Name&maxSelect=1&selectedIds="+document.getElementById("parent1").value);
}
</script>




<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">

		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td class="tab2_tou">
						<a href="javascript:submit();">
							<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/area/list?parent_id=${parent_id }">
							<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" />
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
			<form name="form1" id="post" action="<%=request.getContextPath()%>/html/manage/area?parent_id=${parent_id }" method="post">
				<input type="hidden" name="_method" value="put" />
				<input type="hidden" name="id" value="${info.id }" />
				<table cellspacing="0" cellpadding="0" class="table3_da">
					<thead>
					<tr>
						<td colspan="4">
							<strong>区域管理编辑</strong>
						</td>
					</tr>
					</thead>
					<tr>
						<td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span>地区名：</td>
						<td style="width: 30%;"><input type="text" id="ognz_name" name="name" value="${info.name }" /></td>
					</tr>
					<tr>
						<td style="width: 20%;" class="discription">上级地区：</td>
						<td>
							<input type=hidden id="parent1" name="parent.id" value="${info.parent.id }"/>
							<input type=text id="parent1Name" onclick="openDialog()" name=parent1Name value="${info.parent.name }" style="width:180px;background-position:right" readOnly  class="inputread"/>
						</td>
					</tr>
					<tr>
						<td style="width: 20%;" class="discription">是否为默认地区：</td>
						<td>
							<input type="radio" value="0" name="isDefault" <c:if test="${Info.isDefault==0}">checked</c:if>/>否&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" value="1" name="isDefault" <c:if test="${Info.isDefault==1}">checked</c:if>/>是
						</td>
					</tr>
					<tr>
						<td class="discription">
							<fmt:message key="sys.ps"/>：
						</td>
						<td colspan="3">
							<textarea name="ps" style="width: 95%; height: 200px;">${info.ps}</textarea>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>
