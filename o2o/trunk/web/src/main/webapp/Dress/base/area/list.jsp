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
		var flags="0";
		$("[name='list']").each(function(){
			if($(this).attr("checked")){
			flags="1";
		  }
		});
		$("[name='list']").each(function(){
		
		  if(flags=="0"){
		  	alert("请选择删除项！");
		  	return false;
		  }
		  
		});
		if(flags=="1"){
			  	if(confirm("请确认是否执行删除操作!"))
				document.getElementById("del").submit();
		  }
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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/area/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<input type="hidden" name="parent_id" value=${parent_id } />
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/area/disAdd?parent_id=${parent_id }">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_07.gif"border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/area/list?parent_id=${parent_id }">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">区域名：</td>
						<td><input name="ognzname" type="text" style="color:#494949" value="${ognzname }"/></td>
						<td class="chazhaofanshi1">顶级区域名：</td>
						<td><input name="tname" type="text" style="color:#494949" value="${tname }"/></td>
						<td class="chazhaofanshi1">是否是默认区域：</td>
						<td>
							<select name="isDefault" style="width:154px; height:23px;">
							  <c:if test="${ empty isDefault}">
								  <option value="">请选择</option>
							  </c:if>
							  	  <option value="0"  <c:if test="${isDefault=='0' }">	selected </c:if>>不默认</option>
							  	  <option value="1"  <c:if test="${isDefault=='1' }">	selected </c:if>>默认</option>
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
	<tr>
		<td></td>
	</tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/area/delall?parent_id=${parent_id }">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td  class="checkboxTd" style="text-align:center; padding:0;"><input name="" type="checkbox" value="" onclick="xz();" /></td>
						<td>区域名</td>
						<td>上级区域</td>
						<td>是否是默认区域</td>
						<td><fmt:message key="sys.control" /></td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${LIST}' varStatus='index'>
						<tr>
							<td width="2%" style="text-align:center; padding:0;">
								<input id="list" name="list" type="checkbox" value="${Info.id}" />
							</td>
							<td>${Info.name}&nbsp;</td>
							<td><c:if test="${empty Info.parent.name}">顶级区域</c:if>${Info.parent.name}&nbsp;</td>
							<td>
								<c:if test="${Info.isDefault==1}">是</c:if>
								<c:if test="${Info.isDefault==0}">否</c:if>
							</td>
							<td>
								
								<a href="<%=request.getContextPath()%>/html/manage/area/${Info.id}/disUpdate?parent_id=${parent_id }"
									class="zhu2"><fmt:message key="button.update" /></a>&nbsp;&nbsp;
								<a onclick="return confirm('请确认是否执行删除操作!')" href="javascript:delUrl('<%=request.getContextPath()%>/html/area/del/${Info.id}?parent_id=${parent_id }');"
									class="zhu2"><fmt:message key="button.del" /></a>&nbsp;&nbsp;
								<a href="<%=request.getContextPath()%>/html/manage/area/${Info.id}/show?parent_id=${parent_id }"
									class="zhu2"><fmt:message key="button.show" /></a>&nbsp;
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/area/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>