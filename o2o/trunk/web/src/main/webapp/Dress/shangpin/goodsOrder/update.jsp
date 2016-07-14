<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/taglib/fmt.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglib/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglib/fn.tld"%>
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

<fmt:setBundle basename="locale" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><fmt:message key="sys.name" /></title>
<link href="<%=request.getContextPath()%>/Dress/css/kua.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Dress/css/human2.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath()%>/Dress/js/layer/lib.js"></script>
<script src="<%=request.getContextPath()%>/Dress/js/ajax.js"></script>
<script src="<%=request.getContextPath()%>/Dress/js/jquery.validate.js"></script>
<style type="text/css">
	.error{color:#ff0000;}
</style>
</head>
<body>

<script type="text/JavaScript">
	var tb_pathToImage = "<%=request.getContextPath()%>/Dress/img/loadingAnimation.gif";
	function submit(){
		if($("#form1").checkall()){
	   	 document.form1.submit();
		}
	}
	$(function(){
		$("#post").validate();
	});
	
	var servicePath="<%=request.getContextPath()%>";
	
	// 本页面的商品删除
	function delGoods(goodsId){
		if (confirm("请确认是否执行删除操作!")) {
			$.ajax({
				type: "POST",
				url: servicePath + "/html/manage/goodsOrder/" + goodsId + "/del",
				data: "",
				dataType: "html",
				success: function(data) {
					if (! data.contains("1")) {
						alert("删除失败！");
					} else {
						window.location.reload();
					}
				}
			});	 
		}
	}
	
</script>
<script src="<%=request.getContextPath()%>/Dress/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/shangpin/goodsOrder/goodsOrder.js"></script>
<style>
<!--
.color{color:#fff}
-->
</style>

<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >
			
	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
   		<td class="tab2_tou">
			<a href="javascript:submit();" title="<fmt:message key="button.send"/>">
				<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" />
			</a>
		</td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/goodsOrder/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/goodsOrder" method="post">
<input type="hidden" name="_method" value="PUT"/>
<input type="hidden" name="status" value="0" />
<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
<input type="hidden" id = "pageModId" name="pageModule_id" value="${info.pageModule_id }"/>

  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>排序</strong></td>
  </tr>
   <tr>
    <td class="discription" style="width: 150px;">页面模块名称:</td>
 	 <td>
 	 	${info.name }
 	 </td>
 </tr>
 <tr>
 	<td colspan=4>
 		<table cellspacing="0" cellpadding="0" class="table4_da">
 		<thead>
 			<tr style="color:#fff">
 				<td><strong>商品名称</strong></td>
 				<td><strong>商家编号</strong></td>
 				<td><strong>商家名称</strong></td>
 				<td><strong>排序序号</strong></td>
 				<td>
 					<a href="javascript:;" class="addGoods color" title="添加商品">添加商品</a>
 				</td>
 			</tr>
 		</thead>
 		<tbody class="goodsBox">
 			<c:forEach items="${DATA}" var="info">
 				<tr>
 					<td>
 						${info.goods.name }
 						<input type="hidden" value="${info.goods.goods_id }" name="goods_id" id="goods${info.goods.goods_id }"/>
 					</td>
 					<td>${info.shangJiaInfo.shangjia_id }</td>
 					<td>${info.shangJiaInfo.name }</td>
 					<td><input type="text" name="goods_index" value="${info.indexs }" dataType="int"/></td>
 					<td>
 						<a href="javascript:delGoods('${info.pagModInGoods_id}');" class="zhu2">删除</a>
 					</td>
 					<%-- <td><a href="javascript:;" class="delIndex " delUrl="<%=request.getContextPath() %>/html/manage/goodsOrder/${info.pagModInGoods_id}/del">删除</a></td>--%>
 				</tr>
 			</c:forEach>
 			<jsp:include page="/Dress/include/nofenye1.jsp">
				<jsp:param name="url" value="/html/manage/goodsOrder/${pxid}/disUpdate" />
			</jsp:include>
 		</tbody>
 		</table>
 		
 	</td>
 </tr>

</table>

</form>
  </td>
</tr>
</table>
</body>
</html>