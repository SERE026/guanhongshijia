<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/top.jsp"%>
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
		if(confirm("请确认是否执行发放操作!"))
			document.getElementById("del").submit();
	}
	function radioPanduan(){
		if(document.getElementById("shoudong").checked) {
			document.getElementById("table1").style.display="table";
		}else {
			document.getElementById("table1").style.display="none";
		}
	}
	function cz(){
		document.getElementById("czlist").submit();
	}
	function exportt(){
		document.getElementById("czlist").action="<%=request.getContextPath()%>/html/ibms/huiYuan/export";
		 document.getElementById("czlist").submit();
	}
</script>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dialog.js"></script>



<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/coupon/grantCouponByWhere">
				<input type="hidden" name="couponId" id="couponId" value=${couponId} />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0" class="table4_da">

					<tr>
						<td>
							<input type="radio" name="aaa" onclick="radioPanduan()" value="0"/>所有会员

						</td>
						<td>
							<input type="submit" onclick="cz()" value="发放">
						</td>
					</tr>
					<tr>
						<td>
							<input type="radio" name="aaa" onclick="radioPanduan()" value="1"/>最近
							<input type="text" name="days"/>天消费满<input type="text" name="money"/>
						</td>
						<td>
							<input type="submit" onclick="cz()" value="发放">
						</td>
					</tr>
					<tr>
						<td>
							<input type="radio" name="aaa" onclick="radioPanduan()" value="2" name="isDefault" />最近
							<input type="text" name="day"/>天注册
						</td>
						<td>
							<input type="submit" onclick="cz()" value="发放">
						</td>
					</tr>
					<tr>
						<td>
							<input type="radio" name="aaa" id="shoudong" value="3" onclick="radioPanduan()"/>手动发放
						</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/coupon/grantCouponAll?couponId=${couponId}">
				<input type="hidden" name="_method" value="delete"/>
				<table cellspacing="0" cellpadding="0" class="table4_da" style="display: none" id="table1">
					<thead>
					<tr>
						<c:if test="${info.is_user==0}"><td style="width:30px;"><input name="" type="checkbox" value="" onclick="xz();" /></td></c:if>
						<td>账号</td>
						<td>昵称</td>
						<td>会员登录次数</td>
						<td>上次登录时间</td>
						<td>账号注册时间</td>
						<c:if test="${info.is_user==0}">
							<td>操作</td>
						</c:if>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<c:if test="${info.is_user==0}">
								<td>
									<input id="list" name="list" type="checkbox" value="${Info.huiYuan_id}" />
								</td>
							</c:if>
							<td>${Info.name}&nbsp;</td>
							<td>${Info.userName}&nbsp;</td>
							<!--
							<td>${Info.rank}&nbsp;</td>
							-->
								<%--<td>${Info.shangJiaInfo.name}&nbsp;</td>--%>
							<td>${Info.count}&nbsp;</td>
							<td>${Info.enterData}&nbsp;</td>
							<td>${Info.loginData}&nbsp;</td>
							<c:if test="${info.is_user==0}">
								<td>
									<a href="<%=request.getContextPath()%>/html/manage/coupon/${Info.huiYuan_id}/grantCouponByID?couponId=${couponId}" class="zhu2">
										发放</a>
								</td>
							</c:if>
						</tr>
					</c:forEach>
					<tr>
						<td class="tab2_tou">

								<input type="button" value="发放" onclick="delall()">

						</td>
					</tr>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/huiyuan/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>