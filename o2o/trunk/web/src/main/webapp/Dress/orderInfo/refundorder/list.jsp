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

<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/huiyuan_tuikuan.js"></script>
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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/refundorder/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table b="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/refundorder/list">
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
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/refundorder/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td width="30">
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td width="95">订单号</td>
						<td width="55">订单金额</td>
						<td width="80">会员名称</td>
						<td width="140">申请时间</td>
						<!-- 如果不是商家，显示该退款归属的商家和申请退款的金额 -->
						<c:if test="${user.is_user!='1'}">
							<td width="110">归属商家</td>
							<td width="100">申请退款金额</td>
						</c:if>
						<td width="155">退款原因(点击查看详情)</td>
						<td width="80">处理状态</td>
						<td>操作</td>
						
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="" />
							</td>
							<td>${Info.order.order_id }</td>
							<td>${Info.order.orderPrice }</td>
							<td>${Info.order.huiyuan.name }</td>
							<td>${Info.date }</td>
							<!-- 如果不是商家，显示该退款归属的商家和申请退款的金额 -->
							<c:if test="${user.is_user!='1'}">
								<td width="100">${Info.order.merchants.name}</td>
								<td width="100">
									<c:if test="${Info.state==2}"><font color="gray">${Info.refundmoney}</font></c:if>
									<c:if test="${Info.state!=2}">
										<input type="text" value="${Info.refundmoney}" class="money2">
									</c:if>
								</td>
							</c:if>
							<td>
								<c:if test="${Info.reasonType==0}">
									<a href="#" class="ps" ps="${Info.ps}" style="color:blue;">产品质量无问题，快递损坏</a>
								</c:if>
								<c:if test="${Info.reasonType==1}">
									<a href="#" class="ps" ps="${Info.ps}" style="color:blue;">产品质量问题</a>
								</c:if>
								<c:if test="${Info.reasonType==2}">
									<a href="#" class="ps" ps="${Info.ps}" style="color:blue;">其它问题</a>
								</c:if>
							</td>
							
							<td>
								<c:if test="${Info.state==0}"><font color="red">用户申请退款</font></c:if>
								<c:if test="${Info.state==1}"><font color="orange">等待平台审核</font></c:if>
								<c:if test="${Info.state==2}"><font color="gray">退款已处理</font></c:if>
							</td>
							
							<td>
								<!-- 如果是商家，让商家可以直接输入金额来处理退款 -->
								<c:if test="${user.is_user=='1'}">
									<!-- 如果是退款申请状态 -->
									<c:if test="${Info.state==0}">
										<span>输入退款金额：</span>
										<input type="hidden" value="<%=request.getContextPath() %>" class="path">
										<input type="text" value="${Info.order.orderPrice }" class="money">
										<input type="button" value="同意退款" class="agree" orderMoney="${Info.order.orderPrice }" dataId="${Info.refundorder_id }">
									</c:if>
								</c:if>
								<!-- 如果是其它管理人员，提供同意申请的按钮，并且可以改变申请金额 -->
								<c:if test="${user.is_user!='1'}">
									<!-- 如果是退款申请状态 -->
									<c:if test="${Info.state==0 || Info.state==1}">
										<input type="hidden" value="<%=request.getContextPath() %>" class="path">
										<input type="button" value="同意退款" class="agree2" orderMoney="${Info.order.orderPrice }" dataId="${Info.refundorder_id }">
									</c:if>
								</c:if>
							</td>
							
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/refundorder/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
