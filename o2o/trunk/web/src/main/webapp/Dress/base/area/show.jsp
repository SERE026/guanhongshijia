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
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" /></a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/area/list" title="<fmt:message key="button.back" />">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" /></a>
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
						<strong>区域管理查看</strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td class="discription">区域名：</td>
					<td >${ognzInfo.name }&nbsp;</td>
					<td style="width: 150px;" class="discription">上级区域：</td>
					<td>${ognzInfo.parent.name }&nbsp;</td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="sys.ps"/>：</td>
					<td colspan="3">
						<textarea name="ps" style="width: 95%; height: 200px;" readonly>${info.ps}&nbsp;</textarea>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
