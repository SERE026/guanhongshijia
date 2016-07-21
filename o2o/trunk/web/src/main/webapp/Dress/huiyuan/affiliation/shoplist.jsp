<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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

<script src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/address.js"></script>
<script type="text/javascript">
	$(function(){
		
		/** 保存选择的商家ID **/
		$(".select").click(function(){
			// 得到存储的会员ID
			var huiyuanId = $("#huiyuanId").val();
			var sjID = $(this).val();
			var sjName = $(this).attr("merchantsName");
			if (confirm("确认选择商家为：" + sjName + "？")) {
				var path = "<%=request.getContextPath() %>/html/manage/affiliation/" + window.parent.document.getElementById("huiYuan_id").value + "/disUpdate?sjID=" + sjID;
				window.parent.location.href = path;
			}
		});
	
		/** 提交选择 **/
		$(".saveGoos").click(function(){
			//var ids=$("#selectId").val();
			//$(".select:checked").each(function(){
				//var id=this.value;
				//var merchantsId=$(this).attr("merchantsId");
				//var merchantsName=$(this).attr("merchantsName");
				//ids+=",|"+id+"|";
			//})
			//$("#saveId").val(ids);
			//$("#save").submit(); 
			//window.parent.close();
		})
		
		$(".selectAll").change(function(){
			window.parent.document.getElementById("shangName").value=$(this).attr("merchantsName");
			window.parent.document.getElementById("shangId").value=$(this).attr("merchantsId");
			window.close();
		})
		address("provinceId","cityId","countyId","<%=request.getContextPath()%>/html/manage/area/json/selection");
	})
	
</script>
<form method="post" id="save" name="savePost" action="<%=request.getContextPath()%>/html/manage/affiliation/update">
	<input type="hidden" name="saveId" id="saveId" value="" />
	<input type="hidden" name="_method"  value="put" />
	<input type="hidden" name="merchant_order_id"  value="${merchant_order_id}" />
	<input type="hidden" name="huiyuanId" id="huiyuanId" value="${huiyuan.huiYuan_id }" />
</form>

<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/affiliation/merchant/list">

<table cellspacing="2" cellpadding="0" class="tab2" style="width: 96%;margin: 0 auto;">
	<tr>
		<td class="tab2_top">
			
		</td>
	</tr>
	<tr>
		<td>
			
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<input type="hidden" name="pageModule_id" id="merchant_order_id" value="${merchant_order_id }" />
				<input type="hidden" name="selectId" id="selectId" value="${selectId }" />
				
				
				<table cellspacing="0" cellpadding="0">
					
					<tr>
						<td >
							商家编号：<input  name="code" type="text" style="color:#494949" value="${code }"/>
						</td>
						<td colspan="2">
							&nbsp;商家名称：<input  name="name" type="text" style="color:#494949" value="${name }"/>
						</td>
					</tr>
					
					<tr>
						<td colspan="3" style="min-width: 582px;line-height: 36px;">
							归属地区：
							<select name="provinceId" id="provinceId" dataval="${provinceId}" style="margin-left: -6px;">
								<option value="">--请选择--</option>
							</select>
							省
							<select  name="cityId" id="cityId" dataval="${cityId}">
								<option value="">--请选择--</option>
							</select>
							市
							<select style="display:none" name="region.id" id="countyId" dataval="${countyId}">
								<option value="">--请选择--</option>
							</select>
						</td>

					</tr>
				</table>
			<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/222.gif" border="0" /></a>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td>选择</td>
							<td>
								商家编号
							</td>
							<td>
								商家名称
							</td>
							<td>
								分类
							</td>
							<td>
								城市
							</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						 <tr>
							    <td>
							    	<c:set var="xxx">|${Info.shangjia_id }|</c:set>
							    	<input name="select" class="select" type="radio" 
							    		merchantsName="${Info.name}" merchantsId="${Info.shangjia_id}" 
							    			value="${Info.shangjia_id}" 
							    	/>
							    </td>
							<td>
								${Info.shangjia_id}
							</td>
							<td>
								${Info.name}
							</td>
							<td>
								${Info.type.name}
							</td>
							<td>
								${Info.city.name}
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="<%=Constants.PAGE_JSP%>">
						<jsp:param name="url" value="/html/manage/goods/list" />
					</jsp:include>
				</table>
		</td>
	</tr>
</table>
</form>
</html>