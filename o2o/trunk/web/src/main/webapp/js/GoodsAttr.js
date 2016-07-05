
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

$(function () {
	inititem();
	$(".attTextBtn").click(function () {
		var content =$(this).html();
		if($(this).find(".sssss").length==0){
				$(this).parent().find(".attTextBtn.sp_xinghao").html($(this).parent().find(".sp_xinghao_zheng").html());//选中框样式
				$(this).parent().find(".attTextBtn.sp_xinghao").removeClass("sp_xinghao").addClass("sp_xingha2");//去掉可点击的状态
				$(this).removeClass("sp_xingha2");
				$(this).addClass("sp_xinghao");
				var html='<div class="sp_xinghao_left  sssss"><img src="'+servicePath+'/img/changkuan_10.gif" /></div>';
					html+='<div class="sp_xinghao_zheng">'+content+'</div>';
					html+='<div class="sp_xinghao_right"><img src="'+servicePath+'/img/changkuan_13.gif" /></div>';
				$(this).html(html);
				updateMoney();
		}
	});
	$(".attImageBtn").click(function () {
		$(this).parent().find(".attImageBtn.spdetail_right_gr_kk_right_d").removeClass("spdetail_right_gr_kk_right_d").addClass("spdetail_right_gr_kk_right_d2");
		$(this).removeClass("spdetail_right_gr_kk_right_d2");
		$(this).addClass("spdetail_right_gr_kk_right_d");
		updateMoney();
	});
	updateMoney();
});
function updateMoney() {
	var dataValue = parseFloat($(".goodsMoney").attr("dataValue"));
	$(".goodsAttr").each(function () {
		var dataType = $(this).attr("dataType");
		if (dataType == "Image") {
			var data_value = $(this).find(".attImageBtn.spdetail_right_gr_kk_right_d").attr("data-value");
			if (data_value) {
				dataValue += parseFloat(data_value.split(":")[0]);
			}
		} else {
			if (dataType == "Text") {
				var data_value = $(this).find(".attTextBtn.sp_xinghao").attr("data-value");
				if (data_value) {
					dataValue += parseFloat(data_value.split(":")[0]);
				}
			}
		}
	});
	$(".salesMoney").html(dataValue.toFixed(2));
}

function inititem(){
	$(".index1").parent().find(".attTextBtn.sp_xinghao").html($(".sp_xinghao_zheng").html());
	$(".index1").parent().find(".attTextBtn.sp_xinghao").removeClass("sp_xinghao").addClass("sp_xingha2");
	$(".index1").removeClass("sp_xingha2");
	$(".index1").addClass("sp_xinghao");
	//
	$(".index1").each(function(){
		var content = $(this).html();
		var html='<div class="sp_xinghao_left  sssss"><img src="'+servicePath+'/img/changkuan_10.gif" /></div>';
		html+='<div class="sp_xinghao_zheng">'+content+'</div>';
		html+='<div class="sp_xinghao_right"><img src="'+servicePath+'/img/changkuan_13.gif" /></div>';
		$(this).html(html);
	
	});
	updateMoney();
}