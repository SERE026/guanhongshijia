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
	$(".addFav").click(function(){
		var data="goodId="+$(this).parent().attr("g");
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html?widget=favorites&dataTyap=json&action=add",
			  data: data,
			  dataType: "json",
			  success: function(data){
			  		if(data.status==1){
			  			window.location.href=servicePath+"/"+data.toPage;
			  		}else{
			  			$(".gameBoxss").css("display","");
			  			$(".zhuanpan2").css("left", "25%");
			  			$(".zhuanpan2").css("top", "25%");
			  			$(".zhuanpan2").css("margin", "0 auto");
			     }
			  }
			});
	});
	$(".addMerchant").click(function(){
		var data="merchantId="+$(this).attr("m");
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html?widget=favorites&dataTyap=json&action=add_m",
			  data: data,
			  dataType: "json",
			  success: function(data){
			  		if(data.status==1){
			  			window.location.href=servicePath+"/"+data.toPage;
			  		}else{
						alert("收藏成功！")
			  			 $(".gameBoxs").css("display","");
			        }
			      }
			});
	});
	$(".gameBoxs a").click(function(){
	     $(".gameBoxs").css("display","none");
	});
	$(".gameBoxss a").click(function(){
	     $(".gameBoxss").css("display","none");
	   //  window.location.reload();
	});
});

function favorEvent(){
	$(".addFav").click(function(){
		var data="goodId="+$(this).attr("g_id");
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html?widget=favorites&dataTyap=json&action=add",
			  data: data,
			  dataType: "json",
			  success: function(data){
			  		if(data.status==1){
			  			window.location.href=servicePath+"/"+data.toPage;
			  		}else{
			  		    $(".gameBoxss").css("display","");
			  		  	$(".zhuanpan2").css("left", "25%");
			  			$(".zhuanpan2").css("top", "25%");
			  			$(".zhuanpan2").css("margin", "0 auto");
			  		  }
			  }
		});
	});
}

