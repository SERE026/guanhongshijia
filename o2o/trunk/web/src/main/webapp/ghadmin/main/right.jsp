<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/taglib.jsp" %>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link href="<%=request.getContextPath()%>/css/human2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/FusionChart/FusionCharts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dialog.js"></script>
<script type="text/javascript">
		$(function(){
			resultAjax("<%=request.getContextPath()%>/html/manage/main/order","1=1",result,"txt");
		})
		function result(data){
				DrawChart("divBarChart", "MSLine.swf", "600", "400", data);
		}
	    //画图(以指定 xml格式文件为数据源)  
        function DrawChart(divId,flashFileName,width,height,xmlUrl) {
            var myChartId = new Date().getTime();
            var myChart = new FusionCharts("<%=request.getContextPath()%>/js/FusionChart/" + flashFileName, myChartId, width, height);
            //myChart.setDataURL("data.xml"); //获取xml格式数据源
            //myChart.setDataURL(xmlUrl); //获取xml格式数据源
            myChart.setDataXML(xmlUrl);
            myChart.addParam("wmode", "Opaque");
            myChart.render(divId);
        }
</script>
<table width="97%" border="0" cellspacing="0" cellpadding="3" height="95%">
<tr>
  <td style="width:50%">
  <table cellspacing="0" cellpadding="0" class="table3_da" style="margin-top:0px">
		<thead>
		<tr>
			<td colspan="2">
				<strong>信息</strong>
			</td>
		</tr>
		</thead>
  		<tr>
  			<td  class="discription">未付款订单数量</td>
  			<td>${num1 }</td>
  		</tr>
  		<tr>
  			<td  class="discription">待发货订单数量</td>
  			<td>${num2 }</td>
  		</tr>
  		<tr>
  			<td class="discription">申请退款订单数量</td>
  			<td>${num3 }</td>
  		</tr>
  		<tr>
  			<td class="discription">申请退货订单数量</td>
  			<td>${num4 }</td>
  		</tr>
  		<tr>
  			<td class="discription">归属会员数量</td>
  			<td>${num5 }</td>
  		</tr>
  	</table>
  </td>
   <td  style="width:50%" id="divBarChart">
  		
   </td>
  </tr>
  <tr>
  	<td colspan=2>
  		 <table cellspacing="0" cellpadding="0" class="table3_da">
			<thead>
			<tr>
				<td colspan="20">
					<strong>最近20个订单</strong>
				</td>
			</tr>
			</thead>
			<tr>
				<td>会员名称</td>
				<td>订单号</td>
				<td>订单金额</td>
				<td>下单时间</td>
			</tr>
			<c:forEach items="${data}" var="info">
				<tr>
				<td>${info.huiyuan.userName }</td>
				<td>${info.order_id}</td>
				<td>${info.orderPrice }</td>
				<td>${info.time}</td>
			</tr>
			</c:forEach>
		</table>
  	</td>
  </tr>
  
</table>

</body>
</html>