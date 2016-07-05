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
							<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/shangJiaInfo/list" title="<fmt:message key="button.back" />">
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
						<strong>商家信息查看</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" style="width: 150px;">
								商家名称：
							</td>
							<td>
								&nbsp;${info.shanfJiaInfo.name }
							</td>
							<td class="discription" style="width: 150px;">
								商家账户：
							</td>
							<td >
								&nbsp;${info.login_id}
							</td>
						</tr>
						
						
						<tr>
							<td class="discription" style="width: 150px;">
								联系人：
							</td>
							<td>
								&nbsp;${info.shanfJiaInfo.contactName}
							</td>
							<td class="discription" style="width: 150px;">
								联系电话：
							</td>
							<td>
								&nbsp;${info.shanfJiaInfo.contactPhone}
							</td>
							</tr>
							<tr>
							
							<td class="discription" style="width: 150px;">
								商家类型：
							</td>
							<td colspan=3>
								${info.shanfJiaInfo.type.name}
							</td>
							
						</tr>
						
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>