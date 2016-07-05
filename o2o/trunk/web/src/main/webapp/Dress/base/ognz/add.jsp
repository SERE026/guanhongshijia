<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    	sys_alert("<fmt:message key='alert.ognz_name'/>");
    	$("#ognz_name").focus();
    	return;
    }
    document.form1.submit();
}
function openDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/ognz/selection?fieldId=parent1&fieldName=parent1Name&maxSelect=1");
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
						<a href="<%=request.getContextPath()%>/html/manage/ognz/list?parent_id=${parent_id }">
							<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" />
						</a>
					</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
			<form name="form1" id="post" action="<%=request.getContextPath()%>/html/manage/ognz?parent_id=${parent_id }" method="post">
				<input type="hidden" name="_method" value="post" />
				<table cellspacing="0" cellpadding="0" class="table3_da">
					<thead>
					<tr>
						<td colspan="4">
							<strong><fmt:message key="ognz.add" /></strong>
						</td>
					</tr>
					</thead>
					<tr>
						<td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="ognz.name" />：</td>
						<td style="width: 30%;"><input type="text" id="ognz_name" name="ognz_name" value="" /></td>
						<td style="width: 20%;" class="discription"><fmt:message key="ognz.fname" />：</td>
						<td>
							<input type=hidden id="parent1" name=parent1 value="${ognz.id }"/>
							<input type=text id="parent1Name" onclick="openDialog()" name=parent1Name value="${ognz.ognz_name }" style="width:180px;background-position:right"  class="inputread" readOnly/>
						</td>
					</tr>
					<tr>
						<td class="discription">
							<fmt:message key="sys.isUsed" />：
						</td>
						<td>
							<select name="isUsed" id="select">
								<option value="1" selected="selected">
									<fmt:message key="button.yes"/>
								</option>
								<option value="0">
									<fmt:message key="button.no"/>
								</option>
							</select>
						</td>
						<td class="discription">
							<fmt:message key="ognz.isOgnz" />：
						</td>
						<td>
							<select name="isognz" id="select">
								<option value="1" selected="selected">
									<fmt:message key="button.yes"/>
								</option>
								<option value="0">
									<fmt:message key="button.no"/>
								</option>
							</select>
						</td>

					</tr>
					<tr>
						<td class="discription"><fmt:message key="sys.index" />:</td>
  	  					<td colspan="3"><input type="text" id="index_order" name="index_order" value="9999" /></td>
					</tr>
					<tr>
						<td class="discription">
							<fmt:message key="sys.ps"/>：
						</td>
						<td colspan="3">
							<textarea name="ps" style="width: 95%; height: 200px;"></textarea>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>
