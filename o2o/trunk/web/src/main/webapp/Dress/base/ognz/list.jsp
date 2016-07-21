<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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
		if(confirm("请确认是否执行删除操作!")){
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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/ognz/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<input type="hidden" name="parent_id" value=${parent_id } />
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/ognz/disAdd?parent_id=${parent_id }">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_07.gif"border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/ognz/list?parent_id=${parent_id }">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1"><fmt:message key="ognz.name" />：</td>
						<td><input name="ognzname" type="text" style="color:#494949" value="${ognzname }"/></td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/222.gif" border="0" /></a>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/ognz/delall?parent_id=${parent_id }">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td><input name="" type="checkbox" value="" onclick="xz();" /></td>
						<td><fmt:message key="ognz.name" /></td>
						<td><fmt:message key="ognz.fname" /></td>
						<td><fmt:message key="sys.isUsed" /></td>
						<td><fmt:message key="ognz.isOgnz" /></td>
						<td><fmt:message key="sys.control" /></td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${LIST}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${Info.id}" />
							</td>
							<td>${Info.ognz_name}&nbsp;</td>
							<td>${Info.parent.ognz_name}&nbsp;</td>
							<td>
								<c:if test="${Info.isUsed==1}"><fmt:message key="button.yes"/></c:if>
								<c:if test="${Info.isUsed==0}"><fmt:message key="button.no"/></c:if>
							</td>
							<td>
								<c:if test="${Info.isognz==1}"><fmt:message key="button.yes"/></c:if>
								<c:if test="${Info.isognz==0}"><fmt:message key="button.no"/></c:if>
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/html/manage/ognz/${Info.id}/show?parent_id=${parent_id }"
									class="zhu2"><fmt:message key="button.show" /></a>&nbsp;
								<a href="<%=request.getContextPath()%>/html/manage/ognz/${Info.id}/disUpdate?parent_id=${parent_id }"
									class="zhu2"><fmt:message key="button.update" /></a>&nbsp;
								<a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/ognz/del/${Info.id}?parent_id=${parent_id }');"
									class="zhu2"><fmt:message key="button.del" /></a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="<%=Constants.PAGE_JSP%>">
						<jsp:param name="url" value="/html/manage/ognz/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>