<%@ page language="java" pageEncoding="UTF-8"%>
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

<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/messageSend" method="post">
<input type="hidden" name="_method" value="put" />
<table cellspacing="0" cellpadding="0" class="tab2">
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/discountActive/list" title="<fmt:message key="button.back"/>">
							<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" />
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong>添加商品打折活动</strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>活动主题：
					</td>
					<td>
						${info.name }
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>促销方式：
					</td>
					<td>
						<c:if test="${info.type=='1' }">减少金额</c:if>
							<c:if test="${info.type=='2' }">订单折扣 </c:if>
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>促销值：
					</td>
					<td>
						${info.val }
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>开始日期：
					</td>
					<td>
						${info.bdate }
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>结束日期：
					</td>
					<td>
						${info.edate }
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						开始时间：
					</td>
					<td>
						${info.btime }
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						结束时间：
					</td>
					<td>
						${info.etime }
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>内容：
					</td>
					<td>
						<div style="width:800px;height:500px;" >${info.ps }</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>