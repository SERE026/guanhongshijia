<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
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




<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
<td class="tab2_top" ></td>
</tr>
<tr>
<td style="border:none; vertical-align:top">
<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/res/list">
<input type="hidden" name="type" value="${type }" />
<input type="hidden" name="pageNo" id="pageNo" value="${PAGE_INFO.pageNo }"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
        <td class="tab2_tou"><a href="<%=request.getContextPath() %>/html/manage/res/disAdd">
        	<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_07.gif" border="0" /></a></td>
		<td class="tab2_tou"><a href="javascript:delall();">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_09.gif" border="0" /></a></td>
		<td class="tab2_tou" style=" border-right:#c5c5c5 solid 1px">
			<a href="<%=request.getContextPath() %>/html/manage/res/list">
				<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
			</a>
		</td>
		<td>
			<table>
				<tr>
					<td>资源名称</td>
					<td><input type="text" name="name" value="${name }" /></td>
					<td>
						<a href="javascript:cz();">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/222.gif" border="0" />
						</a>
					</td>
				</tr>
			</table>
		</td>

<td>&nbsp;</td>
</tr>
</table>
</form>
</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">
</td>
</tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">
<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/res/delall">
<input type="hidden" name="_method" value="delete" />
<table cellspacing="0" cellpadding="0" class="table4_da">
	<thead>
	  	<tr>
		<td>
			<input name="" type="checkbox" value="" onclick="xz();"/></td>
		<td>
			<fmt:message key="res.name" />
		</td>
		<td><fmt:message key="res.parent" /></td>
		<td>
			<fmt:message key="res.url" />
		</td>
		<td>
			<fmt:message key="res.menu" />
		</td>
		<td>
			<fmt:message key="res.def" />
		</td>
		<td>
			<fmt:message key="sys.control" />
		</td>
		</tr>
	</thead>
<c:forEach var='Info' items='${LIST}' varStatus='index'>
	<tr>
		<td style="border-right:#c5c5c5 solid 1px;height:25px;">
		<c:if test="${Info.is_default==0}"><input id="list" name="list" type="checkbox"
				value="${Info.id}" /></c:if>
		</td>
		<td>
			${Info.res_name}&nbsp;
		</td>
		<td>${Info.parent.res_name }</td>
		<td>
			${Info.url}&nbsp;
		</td>
		<td>
			<c:if test="${Info.is_menu==1}"><fmt:message key="res.menu1"/></c:if>
			<c:if test="${Info.is_menu!=1}"><fmt:message key="res.menu2"/></c:if>
		</td>
		<td>
			<c:if test="${Info.is_default==1}"><fmt:message key="button.yes"/></c:if>
			<c:if test="${Info.is_default==0}"><fmt:message key="button.no"/></c:if>
		</td>

		<td>
			<c:if test="${Info.is_default==0}">
			<a href="<%=request.getContextPath()%>/html/manage/res/disUpdate/${Info.id}" class="zhu2">
				<fmt:message key="button.update" /></a>&nbsp;
			<a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/res/del/${Info.id}');" class="zhu2">
				<fmt:message key="button.del" /></a>
			</c:if>
		</td>
	</tr>


</c:forEach>

	 <jsp:include page="<%=Constants.PAGE_JSP%>">
	 	<jsp:param name="url" value="/html/manage/res/list" />
	</jsp:include>
  </table>
  </form>
  </td>
</tr>

</table>

</body>

</html>