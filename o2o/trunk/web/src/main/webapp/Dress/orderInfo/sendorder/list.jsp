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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/sendorder/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table b="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/sendorder/list">
								<img src="<%=request.getContextPath()%>/img/biao_03.gif" b="0" />
							</a>
						</td>
						<td class="chazhaofanshi1"> 订单号：</td>
						<td><input name="ddh" type="text" style="color:#494949;width:100px; height:15px;" value="${ddh }"/></td>
					<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/img/222.gif" b="0" /></a>
						</td>	
					</tr>
					
				</table>
			</form>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/sendorder/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td>订单号</td>
						<td>会员名称</td>
						<td>收货人</td>
						<td>物流费用</td>
						<td>保价费用</td>
						<td>优惠金额</td>
						<td>订单金额</td>
						<td>发货时间</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								${Info.order_id }
							</td>
							<td>
								${Info.huiyuan.name }
							</td>
								<td>
								${Info.receiveName }
							</td>
							<td>
							  ${Info.shippingPrice}
							</td>
							<td>
							  ${Info.protectPrice}
							</td>
							<td>
							  ${Info.discountPrice}
							</td>
							<td>
							  ${Info.orderPrice}
							</td>
							<td>
							  ${Info.sendtime}
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/sendorder/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
