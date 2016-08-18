
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

var pageNo=1;
var taitou = "<div class='sjdt_kai03_righttou'><img src='${applicationPath}/img/sjdt_rtou.gif' /></div>";

/**********************************************************************
* 轮换控制器
**********************************************************************/
$(function() {
	// 1秒后开始轮换，每隔5秒钟轮换1次
	// 当检测到已经超页（即没有数据时），自动重置页码从头开始轮换
	/*var wait = setTimeout (function() {
		var change=setInterval(function() {
			//alert("第" + pageNo + "次轮换开始");
			$.ajax({
			type: 'POST',
			url: servicePath+"/widget.html",
			data: "widget=shopList&action=maptuijian&pageNo="+pageNo,
			dataType: "html",
			success: function(data){
				if (checkPageIndex() == true) {
				} else {
					$("#content").html(data);
				}
					nextpage();
			}
		});
		}, 10000);
	}, 1000);*/
	
	
	/***********************************************************************
	* 检查页标是否超出有效数据范围（通过返回的标志判断）
	**********************************************************************/

	nextpage();
	checkPageIndex();
});
	function checkPageIndex() {
		// 如果已经超页，将pageNo重置为1
		if ($("#pageFlag").html()=="1") {
			pageNo = 1;
			$("#pageFlag").html("0"); // 还原未超页状态
			return true;
		} else {
			pageNo++; // 递增页码
			return false;
		}
	}

function nextpage(){

		$("#pageup").unbind("click").click(function(){
			pageNo--;
			if(pageNo==0){
				pageNo=1;
			}
			$.ajax({
			type: 'POST',
			url: servicePath+"/widget.html",
			data: "widget=shopList&action=maptuijian&pageNo="+pageNo,
			dataType: "html",
			success: function(data){
					$("#content").html(data);
					nextpage();
			}
		});
	});
	
	$("#pagedown").unbind("click").click(function(){
		pageNo++;
		$.ajax({
			type: 'POST',
			url: servicePath+"/widget.html",
			data: "widget=shopList&action=maptuijian&pageNo="+pageNo,
			dataType: "html",
			success: function(data){
					$("#content").html(data);
					nextpage();
			}
		});
	});

}