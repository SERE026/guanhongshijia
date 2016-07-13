
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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/dlytype/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
							<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/dlytype/toAdd">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/dlytype/list">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">配送方式名称：</td>
						<td><input name="psfsmc" type="text" style="color:#494949" value="${psfsmc }"/></td>
						<td class="chazhaofanshi1">是否启用：</td>
						<td>
						<select name="sfqy" style="width:100px; height:23px;" >
						  	<option value="">请选择</option>
						  	<option value="0" <c:if test="${sfqy=='0' }">selected</c:if>>启用</option>
						    <option value="1" <c:if test="${sfqy=='1' }">selected</c:if>>没用启用</option>
						    </select>
						</td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/Dress/img/222.gif" border="0" /></a>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/dlytype/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td class="checkboxTd">
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td>配送方式名称</td>
						<td>是否启用</td>
						<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td style="width:30px;">
								<input id="list" name="list" type="checkbox" value="${Info.dlytype_id}" />
							</td>
							<td>
								${Info.dlyname}&nbsp;
							</td>
									<td>
								<c:if test="${Info.stats=='0'}">已启用</c:if>
								<c:if test="${Info.stats=='1'}">没有启用</c:if>
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/html/manage/dlytype/${Info.dlytype_id}/toUpdate" class="zhu2">
									编辑</a>&nbsp;
									<c:if test="${Info.stats=='1'}">
									<a href="<%=request.getContextPath()%>/html/manage/dlytype/${Info.dlytype_id }/toqy" class="zhu2">
									启用
									</a>&nbsp;
									</c:if>
										<c:if test="${Info.stats=='0'}">
									<a href="<%=request.getContextPath()%>/html/manage/dlytype/${Info.dlytype_id }/toqy" class="zhu2">
									禁用
									</a>&nbsp;
									</c:if>
									<a href="<%=request.getContextPath()%>/html/manage/dlytype/${Info.dlytype_id }/todel" class="zhu2">
									删除
									</a>
									
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/dlytype/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>