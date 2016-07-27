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

<style type="text/css">
<!--
.wbk{
width:200px;
height:30px;
overflow: hidden; 
white-space: nowrap;    
-o-text-overflow: ellipsis;    
text-overflow: ellipsis;  
 }
//-->
</style>
<script type="text/javascript">
	$(function(){
		$(".saveGoos").click(function(){
			var ids=$("#selectId").val();
			
			$(".select:checked").each(function(){
				
				var name=$(this).parent().find(".goodsName").html();
				var id=this.value;
				var merchantsId=$(this).parent().find(".merchantsId").html();
				var merchantsName=$(this).parent().find(".merchantsName").html();
			//	window.parent.addGoos(id,name,merchantsId,merchantsName);
			//	data+="&goods_id="+id+"&goods_index=99999";
				if(ids.indexOf(id)<0){
					ids+=",|"+id+"|";
				}
			})
			
			$("#saveId").val(ids);
			$("#save").submit();
			//resultAjax("<%=request.getContextPath()%>/html/manage/goodsOrder/addGoods/${pageModule_id}/disUpdate","selectId="+$("#selectId").val(),m_fun,type);
		})
		$(".selectAll").change(function(){
			if(this.checked){
				$(".select:checkbox").attr("checked",true);
			}else{
				$(".select:checkbox").attr("checked",false);
			}
		})
	})
	
</script>
<form method="post" id="save" name="savePost" action="<%=request.getContextPath()%>/html/manage/goodsOrder/save/${pageModule_id}/disUpdate">
	<input type="hidden" name="saveId" id="saveId" value="${selectId }" />
	<input type="hidden" name="_method"  value="put" />
</form>

<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/goodsOrder/goods/list">

<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			
		</td>
	</tr>
	<tr>
		<td>
			
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<input type="hidden" name="pageModule_id" id="pageModule_id" value=${pageModule_id } />
				<input type="hidden" name="selectId" id="selectId" value="${selectId }" />
				
				
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="javascript:;" class="saveGoos">
								<img src="<%=request.getContextPath()%>/img/dfdf.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">商品编号：</td>
						<td><input  name="code" type="text" style="color:#494949" value="${code }"/></td>
						<td class="chazhaofanshi1">商品名称：</td>
						<td><input  name="name" type="text" style="color:#494949" value="${name }"/></td>
						<td class="chazhaofanshi1">店铺名称：</td>
						<td><input  name="shopName" type="text" style="color:#494949" value="${shopName }"/></td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/img/222.gif" border="0" /></a>
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
						<td><input  class="selectAll" type="checkbox"  />商品编号</td>
							
							<td>
								商家编号
							</td>
							<td>
								商品名称
							</td>
							<td>
								商家名称
							</td>
							<td>
								分类
							</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						 <tr>
							    <td>
								    <c:set var="xxx">|${Info.goods_id }|</c:set>
								    <input name="select" class="select" type="checkbox" value="${Info.goods_id}" <c:if test="${fn:contains(selectId,Info.goods_id) }">checked</c:if> />
									<div class="merchantsName" style="display:none">
										${Info.merchants.name}
									</div>
									<div class="merchantsId" style="display:none">
										${Info.merchants.shangjia_id}
									</div>
									<div class="goodsName" style="display:none">
										${Info.name}
									</div>${Info.goods_id }
								</td>
							
							<td>
								${Info.merchants.shangjia_id}
							</td>
							<td>
								<div class="wbk">${Info.name}</div>
							</td>
							
							
							<td>
								<div class="wbk">${Info.merchants.name}</div>
								
							</td>
							<td>
								${Info.goodsSort.name}
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/goods/list" />
					</jsp:include>
				</table>
		</td>
	</tr>
</table>
</form>
</html>