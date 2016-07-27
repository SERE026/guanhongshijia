<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/top.jsp" %>
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
							<img src="<%=request.getContextPath()%>/web/jsp/admin/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/jffa/list" title="<fmt:message key="button.back" />">
							<img src="<%=request.getContextPath()%>/web/jsp/admin/img/return_btn.gif" border="0" />
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
						<strong>方案查看</strong>
					</td>
				</tr>
				</thead>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">方案名称：</td>
					<td colspan=3>
						${info.name }&nbsp;
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">创建人：</td>
					<td>
						${info.creator.user_name }&nbsp;
					</td>
					<td style="width: 20%;" class="discription">创建时间：</td>
					<td>
						${info.createTime }&nbsp;
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">每消费1元累积积分数：</td>
					<td>
						${info.xfjf }&nbsp;
					</td>
					<td style="width: 20%;" class="discription">每1积分抵扣金额：</td>
					<td>
						${info.jfdk }元&nbsp;
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>