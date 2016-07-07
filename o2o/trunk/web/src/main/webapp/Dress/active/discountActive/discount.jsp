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
<script src="<%=request.getContextPath()%>/Dress/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/Dress/js/ajax.js"></script>
<style type="text/css">
	.error{color:#ff0000;}
</style>
</head>
<body>

<script type="text/JavaScript">
	var tb_pathToImage = "<%=request.getContextPath()%>/Dress/img/loadingAnimation.gif";
	var i=1;
	function submit(){
		if($("#form1").checkall()){
	   	 document.form1.submit();
		}
	}
	$(function(){
		$("#post").validate();
	}) ;
	var servicePath="<%=request.getContextPath()%>";
	
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
		$("[name='list']:checked").each(function(){
				$(this).parent().parent().remove();
		}); 
	}
	</script>
<script src="<%=request.getContextPath()%>/Dress/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/active/discountActive/active.js"></script>

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
			
				<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_09.gif" b="0" />
							</a>
						</td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/discountActive/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/discountActive/add/${info.active_id}/Goods" method="post">
<input type="hidden" name="_method" value="PUT"/>
<input type="hidden" name="status" value="0" />
<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
<input type="hidden" name="active_id" value="${info.active_id }"/>

  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>添加打折商品</strong></td>
  </tr>
 <tr>
 	<td colspan=4>
 		<table cellspacing="0" cellpadding="0" class="table4_da">
 		<thead>
 			<tr>
 				<td>
					<input name="" type="checkbox" value="" onclick="xz();" />
				</td>
 				<td><strong style="color:#fff">商品名称</strong></td>
 				<td><strong style="color:#fff">商品分类</strong></td>
 				<td><strong style="color:#fff">原销售价</strong></td>
 				<td><strong style="color:#fff">活动价</strong></td>
 				<td><strong style="color:#fff">折扣</strong></td>
 				<td>
 					<a href="javascript:;" class="addGoods" style="font-size:14px;color:red;"  title="添加商品">添加商品</a>
 				</td>
 			</tr>
 		</thead>
 		<tbody class="goodsBox">
 			<c:forEach items="${DATA}" var="good">
 				<tr>
 				<td><input id="list" name="list" type="checkbox" value="" /></td>
 					<td>
 						${good.name }
 						<input type="hidden" value="${good.goods_id }" name="goods_id" id="goods${good.goods_id }"/>
 					</td>
 					<td>${good.goodsSort.name}</td>
 					<td>${good.salesMoney}(元)</td>
 					<td>
 						<c:if test="${info.type==1}">
 							${good.salesMoney-info.val}
 						</c:if>
 						<c:if test="${info.type==2}">
 							${good.salesMoney*(10-info.val)/10}
 						</c:if>
 						(元)
 					
 					</td>
 					<td>
 						<c:if test="${info.type==1}">
 							
 							<fmt:formatNumber value="${info.val}" type="currency" pattern="#.0"/>
 							元
 						</c:if>
 						<c:if test="${info.type==2}">
 							<fmt:formatNumber value="${info.val}" type="currency" pattern="#.0"/>
 						</c:if>
 						折
 					</td>
 					<td>
 						<a class="delLinke" href="javascript:;" data="&actId=${info.active_id }&goodId=${good.goods_id }" delUrl="<%=request.getContextPath() %>/html/manage/discountActive/del/Goods">删除</a>
 					</td>
 				</tr>
 			</c:forEach>
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