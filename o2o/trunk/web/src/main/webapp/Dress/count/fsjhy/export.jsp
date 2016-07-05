<%@ page language="java" contentType="application/x-download; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Dress/include/top.jsp"%>
<%@page import="java.net.URLEncoder" %>
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

<%response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("会员流水.xls", "UTF-8")); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
</head>
<body>
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td>
				<table cellspacing="0" cellpadding="0" class="table4_da">
				<thead>
					<tr>
						<td>
							会员名称
						</td>
						<td>
							订单号
						</td>
						<td>
						    订单完成时间
						</td>
						<td>
						    归属店铺
						</td>
						<td>
						    消费金额
						</td>
					</tr>
				</thead>
				<c:forEach var='Info' items='${LIST}' varStatus='index'>
					<tr>
						<td>
							${Info.name}&nbsp;
						</td>
						<td>
							${Info.order}&nbsp;
						</td>
						<td>
							${Info.time}&nbsp;
						</td>
						<td>
							${Info.sname}&nbsp;
						</td>
						<td>
							￥${Info.money}&nbsp;
						</td>
					</tr>
				</c:forEach>
			</table>
				</td>
	</tr>
	
</table>

</body>
</html>