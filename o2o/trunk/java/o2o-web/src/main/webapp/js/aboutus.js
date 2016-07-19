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
	$("#company").css("color","#f0125b");
	$("#company").css("background-color","#e0e0e0");
});
function connectus(){
	$("#connection").css("color","#f0125b");
	$("#connection").css("background-color","#e0e0e0");
	$("#company").css("color","");
	$("#company").css("background-color","");
	$(".mt07_zi").html("联系我们");
	$(".about_top").html("联系方式");
	$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=aboutusContent&page=conectus",
			  dataType: "html",
			  success: function(data){
			  $(".about_top_tuwen").html(data)
				}
			});	
	
	
}