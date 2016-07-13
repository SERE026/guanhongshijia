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
	function update(){
		$(".selectCheckInput").each(function(){
			if(!$(this).attr("checked")){
				$(this).parent().parent().find("input:text").remove();
				$(this).parent().parent().find("span").remove();
			}
		})
		
		if($("#updateOrder").checkall()){
			document.getElementById("updateOrder").submit();
		}
	}
	$(function(){
		$("#updateOrder").validate()
		
		updateShowIndex();
		$("input:checkbox").change(function(){
			updateShowIndex();
		});
	})
	function updateShowIndex(){
		$(".selectCheckInput").each(function(){
			if($(this).attr("checked")){
				$(this).parent().parent().find("input:text").css("display","");
				$(this).parent().parent().find(".val").css("display","none");
			}else{
				$(this).parent().parent().find("input:text").css("display","none");
				$(this).parent().parent().find(".error").css("display","none");
				$(this).parent().parent().find(".val").css("display","");
			}
		})
	}
	
	
	
	
</script>



<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/shangJiaLeague/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="ognzId" value="${ognzId }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
					   <td class="tab2_tou">
				       		<a href="javascript:update();"><img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" /></a>
				       </td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/shangJiaLeague/list">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">店铺名称：</td>
						<td><input name="name" type="text" style="color:#494949" value="${name }"/></td>
						<td class="chazhaofanshi1">排序方式：</td>
						<td>
								<select name="order">
									<option value="1" <c:if test="${order==1 }">selected</c:if>>推荐排序</option>
									<option value="2" <c:if test="${order==2 }">selected</c:if>>列表排序</option>
								</select>
						</td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/Dress/img/222.gif" border="0" /></a>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<form method="post" id="updateOrder" action="<%=request.getContextPath()%>/html/manage/shangJiaLeague/setOderIndex">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td><input name="" type="checkbox" value="" onclick="xz();"  class="selectCheck" /></td>
						<td>店铺名称</td>
						<td>联系人姓名</td>
						<td>联系人电话</td>
						<td>联系地址</td>
						<td>推荐排序</td>
						<td>列表排序</td>
					</tr>
					</thead>
					<c:forEach var='info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${info.shangjia_id}"  class="selectCheckInput" />
							</td>
							<td>${info.name}&nbsp;</td>
							<td>${info.contactName}&nbsp;</td>
							<td>${info.contactPhone}&nbsp;</td>
							<td>${info.province.name}-${info.city.name}-${info.county.name}${info.address }&nbsp;</td>
							<td>
								<input type="text" name="${info.shangjia_id }recommendedIndex" value="${info.recommendedIndex }" dataType="int" style="width:80px;"  /><span class="val">${info.recommendedIndex }</span>
							</td>
							<td>
								<input type="text" name="${info.shangjia_id }orderIndex" value="${info.orderIndex }" dataType="int" style="width:80px;" /><span class="val">${info.orderIndex }</span>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/shangJiaLeague/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>