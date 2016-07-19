
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
	index = 0;
	$("#wdsd").css("color", "#f0125b");
	$("#wdsd").css("background-color", "#e0e0e0");
	$(".gr_rshai_xiaotu_ka").each(function (i, photos) {
		if (i == 0) {
			$(this).attr("class", "gr_rshai_xiaotu_ka_dian");
		}
	});
	$(".imageclass").unbind(".click").click(function () {
		$("#imgclick").attr("src", $(this).attr("src"));
		$(".gr_rshai_xiaotu_ka_dian").removeClass("gr_rshai_xiaotu_ka_dian").addClass("gr_rshai_xiaotu_ka");
		$(this).parents(".gr_rshai_xiaotu_ka").removeClass("gr_rshai_xiaotu_ka").addClass("gr_rshai_xiaotu_ka_dian");
	});
	$("#left1").unbind(".click").click(function () {
		if (index < $(".imageclass").length - 5) {
			$(".gr_rshai_xiaotu_ka_dian").removeClass("gr_rshai_xiaotu_ka_dian").addClass("gr_rshai_xiaotu_ka");
			$(".imageclass").eq(index).parents(".gr_rshai_xiaotu_ka").css("display", "none");
			$(".gr_rshai_xiaotu_ka_fen").eq(index).css("display", "none");
			$(".imageclass").eq(index + 5).parents(".gr_rshai_xiaotu_ka").css("display", "");
			index++;
			$(".imageclass").eq(index).parents(".gr_rshai_xiaotu_ka").removeClass("gr_rshai_xiaotu_ka").addClass("gr_rshai_xiaotu_ka_dian");
			$("#imgclick").attr("src", $(".imageclass").eq(index).attr("src"));
		} else {
		}
	});
	$("#right1").unbind(".click").click(function () {
		if (index > 0) {
			$(".gr_rshai_xiaotu_ka_dian").removeClass("gr_rshai_xiaotu_ka_dian").addClass("gr_rshai_xiaotu_ka");
			$(".imageclass").eq(index - 1).parents(".gr_rshai_xiaotu_ka").css("display", "");
			$(".gr_rshai_xiaotu_ka_fen").eq(index - 1).css("display", "");
			$(".gr_rshai_xiaotu_ka_fen").eq(index + 4).css("display", "none");
			$(".imageclass").eq(index + 4).parents(".gr_rshai_xiaotu_ka").css("display", "none");
			index--;
			$(".imageclass").eq(index + 4).parents(".gr_rshai_xiaotu_ka").removeClass("gr_rshai_xiaotu_ka").addClass("gr_rshai_xiaotu_ka_dian");
			$("#imgclick").attr("src", $(".imageclass").eq(index).attr("src"));
		} else {
		}
	});
});

