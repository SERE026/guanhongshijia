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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/daili/list">
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/daili/disAdd">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/daili/list">
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
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/daili/delall">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td><input name="" type="checkbox" value="" onclick="xz();" /></td>
							<td>
								商家名称
							</td>
							<td>
								商家账户
							</td>
							<td>
								联系人
							</td>
							<td>
								联系电话
							</td>
							<td>
							   代理区域
							</td>
							
							<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						 <tr>
							    <td style="width:30px;"><input id="list" name="list" type="checkbox" value="${Info.login_id}" /></td>
							   <td class="td_a">
									${Info.user_name}
								</td>
								<td class="td_a">
									${Info.login_id}
								</td>
								<td class="td_a">
									${Info.ps}
								</td>
								<td class="td_a">
									${Info.mobile}
								</td>
								<td class="td_a">
								    ${Info.areaname }
								</td>
								<td>
								<a href="<%=request.getContextPath()%>/html/manage/daili/${Info.login_id}/disUpdate" class="zhu2">
									<fmt:message key="button.update" /></a>&nbsp;
									<a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/daili/${Info.login_id}/del')" class="zhu2">
									<fmt:message key="button.del" /></a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/daili/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</html>