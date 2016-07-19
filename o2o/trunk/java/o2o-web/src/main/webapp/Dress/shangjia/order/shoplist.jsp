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

<script src="<%=request.getContextPath()%>/Dress/js/address.js"></script>
<script type="text/javascript">
	$(function(){
		$(".saveGoos").click(function(){
			var ids=$("#selectId").val();
			
			$(".select:checked").each(function(){
				
				var id=this.value;
				var merchantsId=$(this).attr("merchantsId");
				var merchantsName=$(this).attr("merchantsName");
				ids+=",|"+id+"|";
			})
			$("#saveId").val(ids);
			$("#save").submit();
		})
		$(".selectAll").change(function(){
			if(this.checked){
				$(".select:checkbox").attr("checked",true);
			}else{
				$(".select:checkbox").attr("checked",false);
			}
		})
		address("provinceId","cityId","countyId","<%=request.getContextPath()%>/html/manage/area/json/selection");
	})
	
</script>
<form method="post" id="save" name="savePost" action="<%=request.getContextPath()%>/html/manage/merchantOrder/save/order">
	<input type="hidden" name="saveId" id="saveId" value="${selectId }" />
	<input type="hidden" name="_method"  value="put" />
	<input type="hidden" name="merchant_order_id"  value="${merchant_order_id}" />
</form>

<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/merchantOrder/merchant/list">


<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			
		</td>
	</tr>
	<tr>
		<td>
			
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<input type="hidden" name="pageModule_id" id="merchant_order_id" value=${merchant_order_id } />
				<input type="hidden" name="selectId" id="selectId" value="${selectId }" />
				
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="javascript:;" class="saveGoos">
								<img src="<%=request.getContextPath()%>/Dress/img/dfdf.gif" border="0" />
							</a>
						</td>
						<td >商家名称：</td>
						<td><input  name="name" type="text" style="color:#494949" value="${name }"/></td>
						<!-- <td  style="text-align:right;">归属地区：</td>
						<td>
							<select name="province.id" id="provinceId" dataval="${provinceId}">
									<option value="">--请选择--</option>
								</select>
								省
								<select  name="city.id" id="cityId" dataval="${cityId}">
									<option value="">--请选择--</option>
								</select>
								市
								<select style="display:none" name="region.id" id="countyId" dataval="${countyId}">
									<option value="">--请选择--</option>
								</select>
						</td> -->
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/Dress/img/222.gif" border="0" /></a>
						</td>
					</tr>
				</table>
			
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td><input  class="selectAll" type="checkbox"  /></td>
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
							    <input name="select" class="select" type="checkbox" 
							    	merchantsName="${Info.name}" merchantsId="${Info.shangjia_id}" 
							    	 value="${Info.shangjia_id}" 
							    	<c:if test="${fn:contains(selectId,xxx) }">checked</c:if> /></td>
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
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/goods/list" />
					</jsp:include>
				</table>
		</td>
	</tr>
</table>
</form>
</html>