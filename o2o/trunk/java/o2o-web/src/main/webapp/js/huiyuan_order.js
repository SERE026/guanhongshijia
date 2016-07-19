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
	$("#wddd").css("color","#f0125b");
	$("#wddd").css("background-color","#e0e0e0");
	$("#selectall01").unbind(".click").click(function(){
		if($("#selectall01").attr("checked")==true){
			$("input[name=checkboxs]").attr("checked",true);
		}else{
			$("input[name=checkboxs]").attr("checked","");
		}
	});
	
	$(".goHuanyuan").unbind(".click").click(function(){
		var data="&order="+$(this).attr("data");
		toHuanyuan(data);
	});
	
	$(".goPlay").click(function(){
		var data="&order="+$(this).attr("data");
		toPlay(data);
	})
	$(".allPlay").unbind("click").click(function(){
		var data="";
		$(".orderList:checked").each(function(){
			if($(this).attr("p")=="0"){
				data+="&order="+$(this).attr("i");
			}
		});
		if(data.length>0)
			toPlay(data);
		})
		
});

function toPlay(data){
	$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html",
		  data: "widget=memberPlay&dataType=json"+data,
		  dataType: "json",
		  success: function(data){
		  		if(data.play==0){
		  			window.location.href=servicePath+"/orderPlay_select.html?tradeNo="+data.tradeNo;
		  			//window.location.href=servicePath+"/
		  		}
		  }
	});	
}
function toHuanyuan(data){
	$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html",
		  data: "widget=memberPlay&dataType1=json"+data,
		  dataType: "html",
		  success: function(data){
		  	if(data=="1"){
		  		alert("还原成功！");
		  		window.location.reload();
		  	}
		  }
	});	
}

function selectall(){
if($("#selectall01").attr("checked")==true){
	$("input[name=checkboxs]").attr("checked","");
	}else{
		$("input[name=checkboxs]").attr("checked",true);
	}
};


function allsure(){
	var sum=0;
	var cout=0;
	var allid="";
	$("input[name=checkboxs]").each(function (i,info){
		if($(this).attr("checked")==true){
			if($(this).parents("div").children(".iii").val()=="1111"){
				 allid+= $(this).parents("div").children(".orderid01").val()+"/";
				 sum++;
			}
			cout++;
		}	
	});
	
	// 如果订单个数为空，直接返回
	if (cout == 0) {
		alert("没有订单！");
		return;
	}
	
	if(cout!=sum){
		alert("您选择的订单中，有不能收货的定单，请检查后重新操作！");
	}else{
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=orderDetail&allid="+allid,
			  dataType: "html",
			  success: function(data){
			  		alert("操作成功！");
			  		window.location.href="huiyuan_order.html";
			  }
			});	
		}
}

function toallpay(){
	var sum=0;
	var cout=0;
	var allorderid="";
	$("input[name=checkboxs]").each(function (i,info){
		if($(this).attr("checked")==true){
			if($(this).parents("div").children(".iii").val()=="2222"){
				 allorderid+= $(this).parents("div").children(".orderid01").val()+"/";
				 sum++;
			}
			cout++;
		}
	});
	if(cout!=sum){
		alert("您选择的订单中，有不能合并付款的定单，请检查后重新操作！");
	}else{
		$.ajax({
			type: 'POST',
			url: servicePath+"/widget.html",
			ata: "widget=allorderPay&allorderid="+allorderid,
			dataType: "html",
			success: function(data){
			 	window.location.href="orderplay.html"
			}
		});	
	}
}
	
	
	function topaybyid(orderid){
	
	$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=allorderPay&orderid="+orderid,
			  dataType: "html",
			  success: function(data){
			  window.location.href="orderplay.html"
				  }
			});	
	}