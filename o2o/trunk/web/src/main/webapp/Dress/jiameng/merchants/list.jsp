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
	var i=1;
	function delall(){
		if(confirm("请确认是否执行删除操作!"))
			document.getElementById("del").submit();
	}
	function delUrl(url){
		if(confirm("请确认是否执行禁用操作!")){
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
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/merchantsApply/list">
				<input type="hidden" name="ognzId" value="${ognzId }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/merchantsApply/list">
								<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">店铺名称：</td>
						<td><input  name="name" type="text" style="color:#494949" value="${name }"/></td>
						<td class="chazhaofanshi1">店铺分类：</td>
						<td><input  name="type" type="text" style="color:#494949" value="${type }"/></td>
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
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/merchantsApply/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td style="width:30px;"><input name="" type="checkbox" value="" onclick="xz();"  class="selectCheck" /></td>
						<td>店铺名称</td>
						<td>店铺分类</td>
						<td>经营类型</td>
						<td>联系人</td>
						<td>联系电话</td>
						<td>手机号</td>
						<td>电子邮件</td>
						<td>公司名称</td>
						<td>地址</td>
						<td><fmt:message key="sys.control" /></td>
					</tr>
					</thead>
					<c:forEach var='info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${info.merchants_apply_id}"  class="selectCheckInput" />
							</td>
							<td>${info.name}&nbsp;</td>
							<td>${info.storeType.name}&nbsp;</td>
							<td>${info.busType.name}&nbsp;</td>
							<td>${info.contactMan}&nbsp;</td>
							<td>${info.contactTel}&nbsp;</td>
							<td>${info.contactPhone}&nbsp;</td>
							<td>${info.contactEmail}&nbsp;</td>
							<td>${info.companyName}&nbsp;</td>
							<td>${info.province.name}-${info.city.name}-${info.county.name}&nbsp;
							${info.address }&nbsp;</td>
							<td>
								<a href="<%=request.getContextPath()%>/html/manage/merchantsApply/${info.merchants_apply_id }/del" class="zhu2">
									删除
									</a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/user/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>