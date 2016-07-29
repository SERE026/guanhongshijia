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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/order/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table b="0" cellspacing="0" cellpadding="0" border="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/order/list">
								<img src="<%=request.getContextPath()%>/img/biao_03.gif" b="0" />
							</a>
						</td>
						<td class="chazhaofanshi1"> 下单人：</td>
						<td><input name="xdr" type="text" style="color:#494949;width:173px; height:15px;" value="${xdr }"/></td>
						<td class="chazhaofanshi1">订单状态：</td>
						<td>
						<select name="state" style="width:173px; height:23px;">
						 <c:if test="${ empty state}">
						 	 <option id="state" value="">请选择</option>
						  </c:if>
						  <option value="0"  <c:if test="${state=='0' }">	selected </c:if>>等待付款</option>
						  <option value="1" <c:if test="${state=='1' }">	selected </c:if>>已付款</option>
						  <option value="2" <c:if test="${state=='2' }">	selected </c:if>>已发货 </option>
						  <option value="3"  <c:if test="${state=='3' }">	selected </c:if>>交易完成</option>
						  <option value="4" <c:if test="${state=='4' }">	selected </c:if>>申请退款</option>
						  <option value="5" <c:if test="${state=='5' }">	selected </c:if>>申请退货 </option>
						   <option value="6"  <c:if test="${state=='6' }">	selected </c:if>>交易失败</option>
							<option value="7"  <c:if test="${state=='7' }">	selected </c:if>>已付定金</option>
							<option value="8"  <c:if test="${state=='8' }">	selected </c:if>>代理商确认付款</option>
						</select>
						</td>
						<td class="chazhaofanshi1"> 配送方式：</td>
						<td>
							<select name="wlfs" style="width:173px; height:23px;" >
								<c:if test="${ empty wlfs}">
									<option id="fkzt1" value="">请选择</option>
								</c:if>
						 			<option value="0" <c:if test="${wlfs=='0' }">selected</c:if>>上门提货</option>
						  			<option value="1" <c:if test="${wlfs=='1' }">selected</c:if>>物流</option>
							</select>
						</td>
						<td class="chazhaofanshi1">按日期查询：</td>
						<td><input name="btime" type="text" id="btime" readonly onclick="WdatePicker()" class="bianji_3 date" style="font-size: 12px;" value="${btime }" />
						-<input name="etime" type="text" id="etime" readonly onclick="WdatePicker()" class="bianji_3 date" style="font-size: 12px;margin-left: 5px;" value="${etime }"/></td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/img/222.gif" b="0" /></a>
						</td>						
					</tr>
					<!-- 如果是管理员，加入订单所属区域的搜索和商家名称搜索 -->
					<c:if test="${role ==0}">
						<tr style="height: 35px;">
							<td></td>
							<td class="chazhaofanshi1">所在省：</td>
							<td>
								<select name="province" style="width:177px; height:23px;" >
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
							<td class="chazhaofanshi1">店家名称：</td>
							<td>
								<select name="dianjia" style="width:173px; height:23px;" >
									<option id="dianjiaSel" value="">请选择</option>
									<c:forEach var="dj" items="${dianjiaList}">
										<option value="${dj}" <c:if test="${dj==dianjia }">selected="true"</c:if>>${dj}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</c:if>
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/order/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td>订单号</td>
						<td>下单人(昵称)</td>
						<td>下单日期</td>
						<td>订单总额</td>
						<td>其中优惠金额</td>
						<td>其中积分抵扣金额</td>
						<td>其中支付金额</td>
						<!-- 如果是管理员，显示所属区域和商家名称 -->
						<c:if test="${role ==0}">
							<td>所在省</td>
							<td>所在市</td>
							<td>归属商家</td>
						</c:if>
						<td>订单状态</td>
						<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
										${Info.order_id}&nbsp;
							</td>
							<td>
										${Info.huiyuan.name}（${Info.huiyuan.nickname }）&nbsp;
							</td>
							<td>
										${Info.time}&nbsp;
							</td>
							<td>
							￥<fmt:formatNumber value="${Info.originalPrice}" pattern="0.00" type="number"/>
								&nbsp;
							</td>
							<td>
							￥<fmt:formatNumber value="${Info.discountPrice}" pattern="0.00" type="number"/>
							</td>
							<td>
							￥<fmt:formatNumber value="${Info.pointPrice}" pattern="0.00" type="number"/>
							</td>
							<td>
							￥<fmt:formatNumber value="${Info.originalPrice - Info.pointPrice }" pattern="0.00" type="number"/>
							</td>
							<!-- 如果是管理员，显示所属区域和商家名称 -->
							<c:if test="${role ==0}">
								<td>${Info.province.name}</td>
								<td>${Info.city.name}</td>
								<td>${Info.merchants.name}</td>
							</c:if>
							<td>
								<c:if test="${Info.state=='0'}">等待付款</c:if>
								<c:if test="${Info.state=='1'}">已付款</c:if>
								<c:if test="${Info.state=='2'}">已发货 </c:if>
								<c:if test="${Info.state=='3'}">交易完成</c:if>
								<c:if test="${Info.state=='4'}">申请退款</c:if>
								<c:if test="${Info.state=='5'}">申请退货 </c:if>
								<c:if test="${Info.state=='6'}">交易失败 </c:if>
								<c:if test="${Info.state=='7'}">已付定金 </c:if>
								<c:if test="${Info.state=='8'}">代理商确认付款 </c:if>
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/html/manage/order/${Info.order_id}/show" class="zhu2">
									订单信息</a>&nbsp;
							   <c:if test="${Info.state!='6'}">
								<a href="<%=request.getContextPath()%>/html/manage/order/${Info.order_id}/goupdate" class="zhu2">
									编辑</a>&nbsp;
									</c:if>

								<c:if test="${Info.state=='7'}">
									<a href="<%=request.getContextPath()%>/html/manage/order/${Info.order_id}/goupdatepay" class="zhu2">
										确认付款</a>&nbsp;
								</c:if>
								<c:if test="${Info.state=='8'}">
									<a href="<%=request.getContextPath()%>/html/manage/order/${Info.order_id}/godel" class="zhu2">
										确认已收款</a>&nbsp;
								</c:if>
									<a href="<%=request.getContextPath()%>/html/manage/order/${Info.order_id}/godel" class="zhu2">
									删除
									</a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/order/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
