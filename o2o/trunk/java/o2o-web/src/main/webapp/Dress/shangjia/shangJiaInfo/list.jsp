<%@ page language="java" pageEncoding="UTF-8"%>
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
	function ok(url){
		if(confirm("请确认是否启用该方案?")){
			window.location=url;
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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/shangJiaInfo/list">
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/shangJiaInfo/disAdd">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/shangJiaInfo/list">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">商家名称：</td>
						<td><input  name="name" type="text" style="color:#494949" value="${name }"/></td>
						<td class="chazhaofanshi1">商家账户 ：</td>
						<td><input  name="login_id" type="text" style="color:#494949" value="${login_id }"/></td>
						<td class="chazhaofanshi1">联系人：</td>
						<td><input  name="contactName" type="text" style="color:#494949" value="${contactName }"/></td>
						<td class="chazhaofanshi1">联系电话 ：</td>
						<td><input  name="contactPhone" type="text" style="color:#494949" value="${contactPhone }"/></td>
						
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/Dress/img/222.gif" border="0" /></a>
						</td>
					</tr>
					<!-- 另起一行，用来显示地区查询 -->
					<tr style="width: 35px;">
						<td></td>
						<td></td>
						<td></td>
						<td class="chazhaofanshi1">所在省：</td>
						<td>
							<select name="province" style="width:173px; height:23px;" >
								<option id="provinceSel" value="">请选择</option>
								<c:forEach var="p" items="${provinceList}">
									<option value="${p}" <c:if test="${p==province }">selected="true"</c:if>>${p}</option>
								</c:forEach>
							</select>
						</td>
						<td class="chazhaofanshi1">所在市：</td>
						<td>
							<select name="city" style="width:173px; height:23px;" >
								<option id="citySel" value="">请选择</option>
								<c:forEach var="c" items="${cityList}">
									<option value="${c}" <c:if test="${c==city }">selected="true"</c:if>>${c}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
	
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/shangJiaInfo/delall">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td style="width:30px;"><input name="" type="checkbox" value="" onclick="xz();" /></td>
							<td>商家名称</td>
							<td>商家账户</td>
							<td>商家金额</td>
							<td>联系人</td>
							<td>联系电话</td>
							<td>所在省</td>
							<td>所在市</td>
							<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						 <tr>
							    <td><input id="list" name="list" type="checkbox" value="${Info.login_id}" /></td>
							    <td class="td_a">${Info.shanfJiaInfo.name}</td>
								<td class="td_a">${Info.login_id}</td>
								<td class="td_a">${Info.shanfJiaInfo.money}</td>
								<td class="td_a">${Info.shanfJiaInfo.contactName}</td>
								<td class="td_a">${Info.shanfJiaInfo.contactPhone}</td>
								<td class="td_a">${Info.shanfJiaInfo.province.name}</td>
								<td class="td_a">${Info.shanfJiaInfo.city.name}</td>
								<td>
								<a href="<%=request.getContextPath()%>/html/manage/shangJiaInfo/${Info.login_id}/show" class="zhu2">
									<fmt:message key="button.show" /></a>&nbsp;
								<a href="<%=request.getContextPath()%>/html/manage/shangJiaInfo/${Info.login_id}/disUpdate" class="zhu2">
									<fmt:message key="button.update" /></a>&nbsp;
									<a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/shangJiaInfo/${Info.login_id}/del')" class="zhu2">
									<fmt:message key="button.del" /></a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/shangJiaInfo/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</html>