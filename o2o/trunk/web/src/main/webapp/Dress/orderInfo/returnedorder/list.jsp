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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/returnedorder/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table b="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/returnedorder/list">
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
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/returnedorder/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td>
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td>订单号</td>
						<td>订单金额</td>
						<td>物流编号</td>
						<td>物流公司</td>
						<td>会员名称</td>
						<td>订单状态</td>
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
							${Info.dlyCode }
							</td>
							<td>
							${Info.wlcompany.name }
							</td>
							<td>
								${Info.huiyuan.name }
							</td>
							<td>
								<c:if test="${Info.is_return=='0'}">无状态</c:if>
								<c:if test="${Info.is_return=='1'}">申请退货中</c:if>
								<c:if test="${Info.is_return=='2'}">已退货 </c:if>
							</td>
							<td>
							<c:if test="${Info.is_return=='1'}">
								<a href="<%=request.getContextPath()%>/html/manage/returnedorder/${Info.order_id }/goupdate" class="zhu2">
									同意退货</a>&nbsp;
							</c:if>
							<c:if test="${Info.is_return=='2'}">
                                    已退货
                             </c:if>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/returnedorder/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
