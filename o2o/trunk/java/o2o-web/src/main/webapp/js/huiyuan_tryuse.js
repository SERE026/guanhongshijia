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
	$("#tryuse").css("color","#f0125b");
	$("#tryuse").css("background-color","#e0e0e0");
	$("#todel111").unbind(".click").click(function(){
		var data="&id="+$(this).attr("data");
		toDel(data);
	});
	});
	
	function toDel(data){
	$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html",
		  data: "widget=huiyuanTryuse&action=del"+data,
		  dataType: "html",
		  success: function(data){
		  	if(data=="1"){
		  		alert("删除成功！");
		  		window.location.reload();
		  	}
		  }
	});	
}