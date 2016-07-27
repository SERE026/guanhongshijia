<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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
	<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/human2.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/jquery-1.4.2.min.js"></script>
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

<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/dialog.js"></script>




<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/coupon/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/coupon/disAdd">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/coupon/list">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
							</a>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/coupon/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td style="width:30px;">
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td>优惠卷名</td>
						<td>开始时间</td>
						<td>结束时间</td>
						<td>类型</td>
						<td>抵扣金额</td>
						<td>折扣率</td>
						<td>最大抵扣金额</td>
						<td>满多少可用</td>
						<td>是否可以和其他优惠券同时使用</td>
						<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${coupomList}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${Info.id}" />
							</td>

							<td>
									${Info.name}&nbsp;
							</td>
							<td>
									${Info.beginTime}&nbsp;
							</td>
							<td>
									${Info.endTime}&nbsp;
							</td>
							<td>
									<c:if test="${Info.type==1}">
										满减&nbsp;
									</c:if>
									<c:if test="${Info.type==2}">
										折扣&nbsp;
									</c:if>
							</td>
							<td>
									${Info.reduceValue}&nbsp;
							</td>
							<td>
									${Info.discountValue}&nbsp;
							</td>
							<td>
									${Info.maxAmouont}&nbsp;
							</td>
							<td>
									${Info.constraintValue}&nbsp;
							</td>
							<td>
									<c:if test="${Info.sameUse==0}">
										否&nbsp;
									</c:if>
									<c:if test="${Info.sameUse==1}">
										是&nbsp;
									</c:if>
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/html/manage/coupon/${Info.id}/disUpdate" class="zhu2">
									编辑</a>&nbsp;
								<a href="<%=request.getContextPath()%>/html/manage/coupon/${Info.id }/del" class="zhu2">
									删除
								</a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="<%=Constants.PAGE_JSP%>">
						<jsp:param name="url" value="/html/manage/coupon/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>