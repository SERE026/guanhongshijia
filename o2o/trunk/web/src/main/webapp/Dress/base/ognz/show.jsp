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
	function allclick(obj){
		if(obj.checked){
			var objs=document.getElementsByName("checkbox");
			for(var i=0;i<objs.length;i++){
				if(objs[i].id==obj.id)
					objs[i].checked=true;
			}
		}else{
			var objs=document.getElementsByTagName("input");
			for(var i=0;i<objs.length;i++)
				if(objs[i].id==obj.id)
					objs[i].checked="";
		}
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
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" /></a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/ognz/list?ognzId=${ognzId }" title="<fmt:message key="button.back" />">
							<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<input type="hidden" name="_method" value="put" />
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="4">
						<strong><fmt:message key="ognz.title" /></strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td style="width: 20%;" class="discription"><fmt:message key="ognz.name" />：</td>
					<td style="width: 30%;">${ognzInfo.ognz_name }&nbsp;</td>
					<td style="width: 20%;" class="discription"><fmt:message key="ognz.fname" />：</td>
					<td>${ognzInfo.parent.ognz_name }&nbsp;</td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="sys.isUsed" />：</td>
					<td>
						<c:if test="${ognzInfo.isUsed==1 }" ><fmt:message key="button.yes"/></c:if>
						<c:if test="${ognzInfo.isUsed==0 }" ><fmt:message key="button.no"/></c:if>&nbsp;
					</td>
					<td class="discription"><fmt:message key="ognz.isOgnz"/>：</td>  
					<td>
						<c:if test="${ognzInfo.isognz==1 }" ><fmt:message key="button.yes"/></c:if>
						<c:if test="${ognzInfo.isognz==0 }" ><fmt:message key="button.no"/></c:if>&nbsp;
					</td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="sys.index" />：</td>
					<td colspan="3">${ognzInfo.index_order }</td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="sys.ps"/>：</td>
					<td colspan="3">
						<textarea name="ps" style="width: 95%; height: 200px;" readonly>${ognzInfo.ps}</textarea>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
