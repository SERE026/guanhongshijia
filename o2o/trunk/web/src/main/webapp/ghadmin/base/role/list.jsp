<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	function delall(){
		if(confirm("请确认是否执行删除操作!"))
			document.getElementById("del").submit();
	}
	function delUrl(url){
		if(confirm("请确认是否执行删除操作!")){
			window.location=url;
		}
	}
	function cz(){
		 document.getElementById("czlist").submit();
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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/role/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/role/disAdd">
								<img src="<%=request.getContextPath()%>/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/role/list">
								<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
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
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/role/delall">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td>
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td><fmt:message key="role.cname" /></td>
						<td><fmt:message key="role.ename" /></td>
						<td><fmt:message key="sys.isJob" /></td>
						<td><fmt:message key="sys.isDefault" /></td>
						<td><fmt:message key="sys.control" /></td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${LIST}' varStatus='index'>
						<tr>
							<td>
								<c:if test="${Info.isSys==0}">
								<input id="list" name="list" type="checkbox" value="${Info.id}" />
								</c:if>
							</td>
							<td>${Info.role_c_name}</td>
							<td>${Info.role_e_name}</td>
							<td>
								<c:if test="${Info.is_job==1}"><fmt:message key="button.yes"/></c:if>
								<c:if test="${Info.is_job==0}"><fmt:message key="button.no"/></c:if>
							</td>
							<td>
								<c:if test="${Info.isSys==1}"><fmt:message key="button.yes"/></c:if>
								<c:if test="${Info.isSys==0}"><fmt:message key="button.no"/></c:if>
							</td>
							<td>
							<c:if test="${Info.isSys==0}">
								<a href="<%=request.getContextPath()%>/html/manage/role/${Info.id}/disUpdate"
									class="zhu2"><fmt:message key="button.update" /></a>&nbsp;
								<a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/role/del/${Info.id}');"
									class="zhu2"><fmt:message key="button.del" /></a>
							</c:if>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/role/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>