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
	$("#xxzx").css("color","#f0125b");
	$("#xxzx").css("background-color","#e0e0e0");
});
function todelete(messageid){
  	$.ajax({
		type: 'POST',
		url: servicePath+"/widget.html",
		data: "widget=message&messageid="+messageid,
		dataType: "html",
		success: function(data){
			alert("删除成功！");
			window.location.href="huiyuan_message.html";
		}
	});	
}