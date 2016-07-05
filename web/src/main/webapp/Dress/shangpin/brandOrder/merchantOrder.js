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

/*
	商品排序页面JS

*/


$(function(){
	$("#brandMerchants").click(function(){
		var width=$(window).width();
		var height=$(window).height();
		if(width>1000)
			width=1000;
		if(height>466)
			height=466;
		
		$.layer({
		    type : 2,
		    title : '选择商家',
		    iframe : {src : servicePath+'/html/manage/brandOrder/merchant/list'},
		    area : [width+'px' , height+'px']
		});
	});

})
colseLayr=function(){
	$(".xubox_layer").remove();
	$(".xubox_shade").remove();
}