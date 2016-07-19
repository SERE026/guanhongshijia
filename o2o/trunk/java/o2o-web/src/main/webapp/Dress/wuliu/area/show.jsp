<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Dress/include/taglib.jsp"%>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title><fmt:message key="cg.title" /></title>
<link href="<%=request.getContextPath()%>/Dress/css/human2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/jquery-1.4.2.min.js"></script>
</head>
<body>
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
<body>
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
						<a href="<%=request.getContextPath()%>/html/manage/area/list" title="<fmt:message key="button.back" />">
							<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
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
					<td style="width: 20%;" class="discription">区域名：</td>
					<td style="width: 30%;">${ognzInfo.name }&nbsp;</td>
					<td style="width: 20%;" class="discription">上级区域：</td>
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
