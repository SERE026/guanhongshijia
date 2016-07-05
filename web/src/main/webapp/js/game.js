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
	$(".addCars").click(function(){
		var go=$(this).attr("go");
		$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html?widget=carsWidget&action=gameadd&data="+$(".pageX").attr("data"),
		  dataType: "json",
		  success: function(data){
		  	if(data.status==0){
		  		if(go=="true"){
		  			window.location.href=servicePath+"/cars.html";
		  		}else{
		  		$(".gameBox").css("display","none");
		  		}
		  	}else{
		  		$(".gameBox").css("display","none");
		  		}
		  }
		});
	})
})