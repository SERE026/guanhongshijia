
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

var imgItem = 0;
$(function () {
	$(".imgLeft").click(function () {
		var item = $(".img.select").index();
		if (item > 5) {
			$(".img.select").css("display", "none");
			$(".img.select").removeClass("select");
			$(".img:eq(" + (item - 2) + ")").addClass("select");
			$(".img:eq(" + (item - 6) + ")").css("display", "");
		}
	});
	$(".imgRite").click(function () {
		var item = $(".img.select").index();
		var length = $(".img").length;
		if (item < length) {
			$(".img.select").removeClass("select");
			$(".img:eq(" + (item) + ")").addClass("select");
			$(".img:eq(" + (item - 5) + ")").css("display", "none");
			$(".img:eq(" + (item) + ")").css("display", "");
		}
	});
	$(".pifeng img").click(function () {
		var item = $(this).index();
		var length = $(".pifeng img").length;
		$(".pifeng input").val(item);
		for (var b = 0; b < item; b++) {
			$(".pifeng img").eq(b).attr("src", servicePath + "/img/xing_cai.jpg");
		}
		for (var b = item; b < length; b++) {
			$(".pifeng img").eq(b).attr("src", servicePath + "/img/xing_hui.jpg");
		}
	});
});

