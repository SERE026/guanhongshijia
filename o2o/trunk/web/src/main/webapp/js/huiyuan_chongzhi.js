
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

	// 改变菜单样式，设为选中
	$("#zhgl").css("color","#c81523");
	$("#zhgl").css("background-color","#e0e0e0");
	// 输入框得到焦点事件
	$("#money").focus(function() {
		if ($(this).val() == "请输入充值金额") {
			$(this).val("");
		}
	});
	// 输入框失去焦点事件（自动转换金额）
	$("#money").blur(function() {
		if ($(this).val() == "") {
			$(this).val("请输入充值金额");
		}
	});
	// 输入框值变事件
	$("#money").change(function() {
		var money = $(this).val();
		var moneyDouble = Math.round(money * Math.pow(10, 2)) / Math.pow(10, 2); 
		if (! moneyDouble > 0) {
			$(this).val("请输入充值金额");
		} else {
			$(this).val(moneyDouble);
		}
	});
	// 确认充值按钮
	$("#checkData").click(function() {
		checkData();
	});
});

/******************************************************************
* 验证数据
******************************************************************/
function checkData() {
	// 得到输入金额
	var money = $("#money").val();
	var moneyDouble = Math.round(money * Math.pow(10, 2)) / Math.pow(10, 2); 
	// 验证金额是否正确
	if (! moneyDouble > 0) {
		alert("请输入正确金额！");
		return;
	} else {
		if (confirm("立即充值 " + moneyDouble + " 元到您的账户？")) {
			var czType=$("input:radio:[name='czType']:checked").val();
			$("#form1").append("<input name='czType' value='"+czType+"' type='hidden'/>");
			form1.action = servicePath + "/zfbpay.html"; 
			form1.submit();
		}
	}
}
