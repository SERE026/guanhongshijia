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
$(function(){
	$("#form1").validate();
})
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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/payment/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table b="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/payment/list">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" b="0" />
							</a>
						</td>
						<td class="chazhaofanshi1"> 订单号：</td>
						<td><input name="ddh" type="text" style="color:#494949;width:100px; height:15px;" value="${ddh }"/></td>
					<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/Dress/img/222.gif" b="0" /></a>
						</td>	
					</tr>
					
				</table>
			</form>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/payment/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td>
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td>订单号</td>
						<td>订单金额</td>
						<td>物流方式</td>
						<td>支付方式</td>
						<td>是否发货</td>
						<td>会员名称</td>
						<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="" />
							</td>
							<td>
								${Info.order_id }
							</td>
							<td>
							${Info.orderPrice }
							</td>
							<td>
								<c:if test="${Info.dly==1}">
									快递
									<c:if test="${Info.sendstate==1}">
										[物流公司：${Info.wlcompany.name }]
										[物流编号：${Info.dlyCode }]
									</c:if>
								</c:if>
								<c:if test="${Info.dly==0}">
									上门提货
								</c:if>
							</td>
							<td>
							${Info.playType.name}
							</td>
							<td>
							<c:if test="${Info.sendstate=='0' }">未发货</c:if>
							<c:if test="${Info.sendstate=='1' }">已发货</c:if>
							</td>
							<td>
								${Info.huiyuan.name }
							</td>
							<td>
								<c:if test="${Info.sendstate=='0' }">
									  <a href="<%=request.getContextPath()%>/html/manage/payment/${Info.order_id }/goupdate" class="zhu2">
										发货</a>&nbsp;
								</c:if>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/payment/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
