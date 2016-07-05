<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		if(confirm("请确认是否执行禁用操作!")){
			window.location=url;
		}
	}
	function cz(){
		document.getElementById("czlist").submit();
	}
</script>



<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/user/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="ognzId" value="${ognzId }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/user/disAdd?ognzId=${ognzId }">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/user/list?ognzId=${ognzId }">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1"><fmt:message key="user.search.username" />：</td>
						<td><input name="username" type="text" style="color:#494949" value="${username }"/></td>
						<td class="chazhaofanshi1"><fmt:message key="user.search.login" />：</td>
						<td><input name="login" type="text" style="color:#494949" value="${login }"/></td>
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
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/user/delall?ognzId=${ognzId }">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td  class="checkboxTd"><input name="" type="checkbox" value="" onclick="xz();"/></td>
						<td><fmt:message key="user.login" /></td>
						<td><fmt:message key="user.name" /></td>
						<td><fmt:message key="user.offTel" /></td>
						<td><fmt:message key="user.mobile" /></td>
						<td><fmt:message key="user.email" /></td>
						<td><fmt:message key="sys.isUsed" /></td>
						<td><fmt:message key="sys.control" /></td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${LIST}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${Info.login_id}"/>
							</td>
							<td>${Info.login_id}&nbsp;</td>
							<td>${Info.user_name}&nbsp;</td>
							<td>${Info.offTel}&nbsp;</td>
							<td>${Info.mobile}&nbsp;</td>
							<td>${Info.email}&nbsp;</td>
							<td>
								<c:if test="${Info.isUsed==1}"><fmt:message key="button.yes"/></c:if>
								<c:if test="${Info.isUsed==0}"><fmt:message key="button.no"/></c:if>
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/html/manage/user/${Info.login_id}/show?ognzId=${ognzId }" class="zhu2">
									<fmt:message key="button.show" /></a>&nbsp;
								<a href="<%=request.getContextPath()%>/html/manage/user/${Info.login_id}/disUpdate?ognzId=${ognzId }" class="zhu2">
									<fmt:message key="button.update" /></a>&nbsp;
									<c:if test="${Info.isUsed==1}">
								<a href="<%=request.getContextPath()%>/html/manage/user/del/${Info.login_id}?ognzId=${ognzId }" class="zhu2">
									禁用</a>
									</c:if>
									<c:if test="${Info.isUsed==0}">
									<a href="<%=request.getContextPath()%>/html/manage/user/start/${Info.login_id}?ognzId=${ognzId }" class="zhu2">
									启用</a>
									</c:if>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/user/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>