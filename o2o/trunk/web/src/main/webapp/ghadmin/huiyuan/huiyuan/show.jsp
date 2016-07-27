<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/top.jsp"%>
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

<body>
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
							<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/huiyuan/list" title="<fmt:message key="button.back" />">
							<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" />
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
						<strong>会员信息</strong>
					</td>
				</tr>
				</thead>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">用户账号：</td>
					<td>
						${info.name}&nbsp;
					</td>
					<td style="width: 20%;" class="discription">用户昵称：</td>
					<td>
						${info.userName}&nbsp;
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">email：</td>
					<td>
						${info.email}&nbsp;
					</td>				
					<td style="width: 20%;" class="discription">固定电话：</td>
					<td>
						${info.tel}&nbsp;
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">手机：</td>
					<td>
						${info.phone}&nbsp;
					</td>				
					<td style="width: 20%;" class="discription">会员等级：</td>
					<td>
						${info.rank}&nbsp;
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">注册时间：</td>
					<td>
						${info.loginData}&nbsp;
					</td>				
					<td style="width: 20%;" class="discription">上次登录时间：</td>
					<td>
						${info.enterData}&nbsp;
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">邮编：</td>
					<td>
						${info.postcode}&nbsp;
					</td>				
					<td style="width: 20%;" class="discription">登录次数：</td>
					<td>
						${info.count}&nbsp;
					</td>
				</tr>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">生日：</td>
					<td>
						${info.birthday}&nbsp;
					</td>
					<td style="width: 20%;" class="discription">地址：</td>
					<td>
						${info.province.name}${info.city.name}${info.region.name}${info.address}&nbsp;
					</td>			
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>