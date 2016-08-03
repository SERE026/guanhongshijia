<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" pageEncoding="UTF-8"%>
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
	var i=1;
	
	// 查看商品标签
	$(function() {
		$(".bq").click(function() {
			alert($(this).attr("data"));
		});
	
	});

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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/goods/list">
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<c:if test="${not empty merchants}">
							<td class="tab2_tou">
								<a href="<%=request.getContextPath()%>/html/manage/goods/disAdd">
									<img src="<%=request.getContextPath()%>/img/biao_07.gif" border="0" />
								</a>
							</td>
							<td class="tab2_tou">
								<a href="javascript:delall();">
									<img src="<%=request.getContextPath()%>/img/biao_09.gif" border="0" />
								</a>
							</td>
						</c:if>
						<!-- 如果是代理商登录，显示添加操作 -->
						<c:if test="${role==2}">
							<td class="tab2_tou">
								<a href="<%=request.getContextPath()%>/html/manage/goods/disAdd">
									<img src="<%=request.getContextPath()%>/img/biao_07.gif" border="0" />
								</a>
							</td>
							<td class="tab2_tou">
								<a href="javascript:delall();">
									<img src="<%=request.getContextPath()%>/img/biao_09.gif" border="0" />
								</a>
							</td>
						</c:if>
						
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/goods/list">
								<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">商品编号：</td>
						<td><input  name="code" type="text" style="color:#494949" value="${code }"/></td>
						<td class="chazhaofanshi1">商品名称：</td>
						<td><input  name="name" type="text" style="color:#494949" value="${name }"/></td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/img/222.gif" border="0" /></a>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/goods/delall">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td style="width:30px;"><input name="" type="checkbox" value="" onclick="xz();" /></td>
							
							<td width="340">
								商品名称
							</td>
							<td>商品描述</td>
							<td width="70">
								商品编号
							</td>
							<td width="70">
								商品排序
							</td>
							<td>
								分类
							</td>
							<td>
								销售价格
							</td>
							<td>
								上架
							</td>
							<td width="125">
								上架时间
							</td>
							<%--<td>--%>
								<%--类型--%>
							<%--</td>--%>
							<td width="120">
								商品标签
							</td>
							<c:if test="${ empty merchants}">
								<td>
									商家名称
								</td>
								<td>
									商家编号
								</td>
							</c:if>
							<td>
									是否试用
								</td>
							<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						 <tr>
							    <td><input id="list" name="list" type="checkbox" value="${Info.goods_id}" /></td>
							  
							<td>
								${Info.name}
							</td>
							 <td>${Info.shortDesc}</td>
								 <td>
								${Info.code}
							</td>
							 <td>
								${Info.indexs}
							</td>
							<td>
								${Info.goodsSort.name}
							</td>
							<td>
								${Info.salesMoney}
							</td>
							<td>
								<c:if test="${Info.shelves==0}">是</c:if>
								<c:if test="${Info.shelves==1}">否</c:if>
							</td>
							<td>
								<c:if test="${Info.shelves==0}">
									${Info.sj_time}
								</c:if>
							</td>
							<%--<td>--%>
								<%--${Info.goodsType.name}--%>
							<%--</td>--%>
							<td>
								<!-- 加载标签名称，当标签长度大于0时才显示，否则不显示 -->
								<c:forEach var="bq" items="${bqNameList}" varStatus="index2">
									<c:if test="${index.index==index2.index}">
										<c:if test="${fn:length(bq)>0}">
											<a href="#" style="color:blue" class="bq" data="${bq}">查看标签</a>
										</c:if>
									</c:if>
								</c:forEach>
							</td>
							
							<c:if test="${ empty merchants}">
								<td>
									${Info.merchants.name}
								</td>
								<td>
									${Info.merchants.shangjia_id}
								</td>
							</c:if>
								<td>
								<c:if test="${Info.tryuse==0}">否</c:if>
								<c:if test="${Info.tryuse==1}">是</c:if>
								</td>
								<td>
									<a href="<%=request.getContextPath()%>/html/manage/goods/${Info.goods_id}/show" class="zhu2">
										<fmt:message key="button.show" /></a>&nbsp;
								
								<!-- 代理商编辑、删除 -->
								<c:if test="${role==2}">
									<a href="<%=request.getContextPath()%>/html/manage/goods/${Info.goods_id}/${Info.merchants.shangjia_id}/disUpdate?pageNo=${PAGE_INFO.pageNo }" class="zhu2">
										<fmt:message key="button.update" /></a>&nbsp;
									<a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/goods/${Info.goods_id}/del')" class="zhu2">
										<fmt:message key="button.del" /></a>
								</c:if>
								<!-- 商家查看、编辑删除 -->
								<c:if test="${not empty merchants}">
									<a href="<%=request.getContextPath()%>/html/manage/goods/${Info.goods_id}/${Info.merchants.shangjia_id}/disUpdate?pageNo=${PAGE_INFO.pageNo }" class="zhu2">
										<fmt:message key="button.update" /></a>&nbsp;
										<a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/goods/${Info.goods_id}/del')" class="zhu2">
										<fmt:message key="button.del" /></a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/goods/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</html>