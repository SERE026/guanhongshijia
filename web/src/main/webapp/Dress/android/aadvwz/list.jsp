
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
<script type="text/javascript">
var i=1;

	function allChoose(){
		$("[name='list']").attr("checked",'true');
	}
	
	function allCancel(){
		$("[name='list']").removeAttr("checked");
	}
	function xz(){
	
		if(i==1){
			allChoose();
			i=0;
		}else{
			allCancel();
			i=1;
		}
	}
function cz(){
		 document.getElementById("czlist").submit();
	}
	function delall(){
		if(confirm("请确认是否执行删除操作!"))
			document.getElementById("del").submit();
	}
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/dialog.js"></script>




<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/aadvwz/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
							<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/aadvwz/disAdd">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/aadvwz/list">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">位置名称：</td>
						<td><input class="title" name="title" id="title" type="text" style="color:#494949" value="${title }"/></td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/Dress/img/222.gif" border="0" /></a>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/aadvwz/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td style="width:30px;">
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td>编号</td>
						<td>位置名称</td>
						<td>广告类型</td>
						<td>宽度</td>
						<td>高度</td>
						<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${Info.aadvwz_id}" />
							</td>
							<td>
								${Info.aadvwz_id}&nbsp;
							</td>
							<td>
								${Info.advwz_title}&nbsp;
							</td>
							<td>
	                        <c:if test="${Info.advwz_type=='1'}">图片</c:if>
	                        <c:if test="${Info.advwz_type=='0'}">falsh</c:if>
	                        <c:if test="${Info.advwz_type=='2'}">幻灯片</c:if>
							</td>
							<td>
	                          ${Info.advwz_width}&nbsp;
							</td>
							<td>
	                          ${Info.advwz_height}&nbsp;
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/html/manage/aadvwz/${Info.aadvwz_id}/disUpdate" class="zhu2">
									编辑</a>&nbsp;
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/aadvwz/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>