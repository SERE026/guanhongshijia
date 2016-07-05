
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
	$(window).resize(function () {
		$(".ind_meu_fuaa").css("left", $(".meu_shangpin:eq(0)").offset().left);
		$(".ind_meu_fuaa").css("top", $(".meu_shangpin:eq(0)").offset().top + $(".meu_shangpin:eq(0)").height());
	});
	$(".ind_meu_fuaa").css("left", $(".meu_shangpin:eq(0)").offset().left);
	$(".ind_meu_fuaa").css("top", $(".meu_shangpin:eq(0)").offset().top + $(".meu_shangpin:eq(0)").height());
	$(".ind_meu_fuaa").css("display", "");
	$(".ind_meu_fuaa").css("display", "");
	$("#brand_t").css("display","none");
	
	$("[name=selected]").css("background-image", "url(img/x1420bg_02.gif)");
});

