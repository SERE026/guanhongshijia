
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

$(function(){
	$("#shangName").click(function(){
		// 取得保存的会员ID
		var huiyuanId = $("#huiyuanId").val();
		$.layer({
		    type : 2,
		    title : '选择商家',
		    iframe : {src : servicePath+'/html/manage/affiliation/merchant/list?merchant_order_id='+$("input[name='merchant_order_id']").val() +"'" + "&huiyuanId=" + huiyuanId},
		    area : ['1000px' , '466px'],
		    offset : ['100px',''],
		    
		});
	});

})
