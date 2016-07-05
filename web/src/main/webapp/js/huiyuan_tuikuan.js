
/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *  
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty 
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and 
 * confidential information, ideas and expressions.    No part of this 
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior 
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */

/******************************************************************
* 页面就绪
******************************************************************/
$(function() {

	// 点击提交申请
	$("#apply").click(function() {
		alert("申请成功！请等待处理！");
		$("#form1").submit();
	});
	
	// 查看退款详情
	$(".ps").click(function() {
		alert($(this).attr("ps"));
	});
	
	/**********************************************************************
	* 商家点击同意退款
	**********************************************************************/
	$(".agree").click(function() {
		var box = $(this).parent().find(".money");
		var path = $(this).parent().find(".path").val();
		if (box.val() == "") {
			alert("请输入退款金额！");
			box.focus();
			return;
		}
		var orderMoney = $(this).attr("orderMoney");
		var agreeMoney = box.val();
		orderMoney = Math.round(orderMoney * Math.pow(10, 2)) / Math.pow(10, 2);
		agreeMoney = Math.round(agreeMoney * Math.pow(10, 2)) / Math.pow(10, 2);
		
		if (! agreeMoney > 0 || agreeMoney > orderMoney) {
			alert("退款金额不正确，请重输！");
			box.focus();
			box.val(orderMoney);
			return;
		}
		if (orderMoney != agreeMoney) {
			if (confirm("同意退款金额与订单金额不符，需要平台审核，确认交给平台审核吗？")) {
				window.location.href = path + "/html/manage/refundorder/" + $(this).attr("dataId") + "/" + agreeMoney + "/goupdate";
			}
		} else {
			if (confirm("同意退款的金额将立即返还至买家账户，确定继续吗？")) {
				window.location.href = path + "/html/manage/refundorder/" + $(this).attr("dataId") + "/" + agreeMoney + "/goupdate";
			}
		}
	});
	
	/**********************************************************************
	* 平台管理人员点击同意退款
	**********************************************************************/
	$(".agree2").click(function() {
		var box = $(this).parent().parent().find(".money2");
		var path = $(this).parent().find(".path").val();
		if (box.val() == "") {
			alert("请输入退款金额！");
			box.focus();
			return;
		}
		var orderMoney = $(this).attr("orderMoney");
		var agreeMoney = box.val();
		orderMoney = Math.round(orderMoney * Math.pow(10, 2)) / Math.pow(10, 2);
		agreeMoney = Math.round(agreeMoney * Math.pow(10, 2)) / Math.pow(10, 2);
		if (! agreeMoney > 0 || agreeMoney > orderMoney) {
			alert("退款金额不正确，请重输！");
			box.focus();
			box.val(orderMoney);
			return;
		}
		if (confirm("同意退款的金额将立即返还至买家账户，确定继续吗？")) {
			alert("管理人员处理退款！");
			var url = path + "/html/manage/refundorder/" + $(this).attr("dataId") + "/" + agreeMoney + "/goupdate2";
			alert(url);
			window.location.href = path + "/html/manage/refundorder/" + $(this).attr("dataId") + "/" + agreeMoney + "/goupdate2";
		}
	});
	

});
