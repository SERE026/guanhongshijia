<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/taglib.jsp"%>
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
	<link href="<%=request.getContextPath()%>/css/human2.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
</head>
<body>
<script src="<%=request.getContextPath()%>/ghadmin/client/js/vendor-bundle.js?v=1.5.0"></script>
<script type="text/javascript">

	/*var i=1;

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
	}*/

	function inRoom(e){
		var roomName=$.trim($(this).parents("tr").find("td").eq(1).text());
//		alert(roomName);
		<%--Cookies.set("roomName", roomName);--%>
		<%--alert("<%=request.getContextPath()%>/ghadmin/client/index.html");--%>
		<%--window.location.href="<%=request.getContextPath()%>/ghadmin/client/index.html";--%>
//		alert(22);
	}

</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/dialog.js"></script>




<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
		</td>
	</tr>
	<tr>
	<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/kefu/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
<%--				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/coupon/disAdd">
								<img src="<%=request.getContextPath()%>/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/coupon/list">
								<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
							</a>
						</td>
					</tr>
				</table>--%>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
<%--			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/coupon/delall">--%>
<%--				<input type="hidden" name="_method" value="delete" />--%>
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
<%--						<td style="width:30px;">
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>--%>
						<td>id</td>
						<td>房间号</td>
						<td>商品编号</td>
						<td>是否上线</td>
						<td>上线时间</td>
						<td>下线时间</td>
						<td>操作</td>
					</tr>
					</thead>

					<c:forEach var='Info' items='${kefuList}' varStatus='index'>
						<tr>
<%--							<td>
								<input id="list" name="list" type="checkbox" value="${Info.id}" />
							</td>--%>

							<td>
									${Info.id}&nbsp;
							</td>
							<td roomId="${Info.roomId}">
									${Info.roomId}&nbsp;
							</td>
							<td>
									${Info.goodsId}&nbsp;
							</td>

							<td>
								<c:if test="${Info.status==0}">
									下线&nbsp;
								</c:if>
								<c:if test="${Info.status==1}">
									上线&nbsp;
								</c:if>
							</td>



							<td>
									${Info.inTime}&nbsp;
							</td>
							<td>
									${Info.outTime}&nbsp;
							</td>
							<td>
								<c:if test="${Info.status==0}">
									<a href="<%=request.getContextPath()%>/html/manage/kefu/update/${Info.id }?status=1" class="zhu2">
										上线</a>&nbsp;
								</c:if>
								<c:if test="${Info.status==1}">
									<a href="<%=request.getContextPath()%>/html/manage/kefu/update/${Info.id }?status=0" class="zhu2">
										下线</a>&nbsp;
								</c:if>
				<%--				<a href="<%=request.getContextPath()%>/html/manage/kefu/${Info.roomId }/disUpdate?goodsId=${Info.goodsId}" class="zhu2">
									进入视频
								</a>--%>
								<a href="<%=request.getContextPath()%>/ghadmin/client/index.html?roomName=${Info.roomId}&status=${Info.status}" class="zhu2">
									进入视频
								</a>

							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/kefu/list" />
					</jsp:include>
				</table>
		<%--	</form>--%>
		</td>
	</tr>
</table>
</body>
</html>