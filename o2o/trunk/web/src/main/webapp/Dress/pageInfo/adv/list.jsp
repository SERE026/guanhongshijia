
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
$(function(){
	 $("#area_name").click(function(){
		openDialogSel("<%=request.getContextPath()%>/html/manage/area/selection?fieldId=adv_Id&fieldName=area_name&maxSelect=1");
	});
});
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/dialog.js"></script>




<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/adv/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
							<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/adv/goAdd">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/adv/list">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">广告名称：</td>
						<td><input class="title" name="title" id="title" type="text" style="color:#494949" value="${title }"/></td>
					     <td class="chazhaofanshi1">城市:</td>
					  	  <td >
					  	  		<input name="area_name" id="area_name"  type="text" value="${area_name }" readonly />
					  	  		<input name="area_id" id="adv_Id" type="hidden" value="${area_id}"/>
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
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/adv/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td style="width:30px;">
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td>广告名称</td>
						<td>单位名称</td>
						<td>广告所属广告位</td>
						<td>城市</td>
						<td>开始时间</td>
						<td>终止时间</td>
						<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${Info.adv_id}" />
							</td>
							<td>
								${Info.adv_name}&nbsp;
							</td>
							<td>
								${Info.adv_unit}&nbsp;
							</td>
							<td>
	                          ${Info.advwz.advwz_title}&nbsp;
							</td>
							<td>
	                          ${Info.area.name}&nbsp;
							</td>
							<td>
	                          ${Info.adv_starttime}&nbsp;
							</td>
								<td>
	                          ${Info.adv_endtime}&nbsp;
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/html/manage/adv/${Info.adv_id}/goEdit" class="zhu2">
									编辑</a>&nbsp;
									<a href="<%=request.getContextPath()%>/html/manage/adv/${Info.adv_id }/del" class="zhu2">
									删除
									</a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/adv/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>