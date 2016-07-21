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

<form id="userInfo" action="" method="post">
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
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/user/list?ognzId=${ognzId }" title="<fmt:message key="button.back" />">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" />
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong><fmt:message key="user.show" /></strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td style="width: 10%;" class="discription"><fmt:message key="user.login" />：</td>
					<td style="width: 23%;">${userInfo.login_id}&nbsp;</td>
					<td style="width: 10%;" class="discription"><fmt:message key="user.name" />：</td>
					<td style="width: 23%;">${userInfo.user_name }&nbsp;</td>
					<td style="width: 10%;" class="discription"><fmt:message key="user.mobile" />：</td>
					<td>${userInfo.mobile}&nbsp;</td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="user.offTel" />：</td>
					<td>${userInfo.offTel}&nbsp;</td>
					<td class="discription"><fmt:message key="user.email" />：</td>
					<td>${userInfo.email}&nbsp;</td>
					<td class="discription"><fmt:message key="sys.isUsed" />：</td>
					<td>
						<c:if test="${'1' == userInfo.isUsed}"><fmt:message key="button.yes"/></c:if>
						<c:if test="${'0' == userInfo.isUsed}"><fmt:message key="button.no"/></c:if>
					</td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="sys.isDefault" />：</td>
					<td>
						<c:if test="${'1' == userInfo.isDefault}"><fmt:message key="button.yes"/></c:if>
						<c:if test="${'0' == userInfo.isDefault}"><fmt:message key="button.no"/></c:if>
					</td>
					<td class="discription"><fmt:message key="user.role" />：</td>
					<td>
						${userInfo.roles[0].role_c_name}&nbsp;
					</td>
					<td class="discription"><fmt:message key="user.ognz" />：</td>
					<td>
						${userInfo.ognzs[0].ognz_name}&nbsp;
					</td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="sys.index" />：</td>
					<td colspan="5">${userInfo.index_order }</td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="sys.ps"/>：</td>
					<td colspan="5"><textarea style="width: 700px;height: 200px;" id="ps" name="ps" readonly>${userInfo.ps}</textarea>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>