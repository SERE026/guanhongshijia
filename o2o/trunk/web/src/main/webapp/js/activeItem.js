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
	window.setInterval("updateTime()",1000);
	
	$(".add").click(function(){
		var num=parseInt($(".numBox").html());
		$(".numBox").html(++num);
	});
	$(".sub").click(function(){
		var num=parseInt($(".numBox").html());
		if(num>1)
		$(".numBox").html(--num);
	});
	$(".addCars").click(function(){
		addCars();
	})
	
})
function updateTime(){
	$(".acttime2").each(function(){
		var time=$(this).attr("time").split(":");
		var h=parseInt(time[0]);
		var m=parseInt(time[1]);
		var s=parseInt(time[2]);
		s--;
		if(s==0){
			s=59;
			m--;
			if(m==0){
				m=59;
				h--;
				if(h<0){
					m=0;
					s=0;
				}
			}
		}
		$(this).find("span:eq(0)").html((h>9?h:"0"+h));
		$(this).find("span:eq(1)").html((m>9?m:"0"+m));
		$(this).find("span:eq(2)").html((s>9?s:"0"+s));
		
		time=(h>9?h:"0"+h)+":"+(m>9?m:"0"+m)+":"+(s>9?s:"0"+s);
		$(this).attr("time",time);
	});
	
}




function addCars(){
	
	var _car={
		data:"",
		add:function(){
			var g_id=$(".addCars").attr("gid");//商品ID
			var a_id=$(".addCars").attr("aid");//商品ID
			var num=$(".numBox").html();//商品数量
			var isSubmit=true;
			var specData="&1=1";
			if(isSubmit){
				_car.data="widget=carsWidget&dataType=json&n=1&action=Actadd&a_id="+a_id+"&num="+num+"&g_id="+g_id+specData+"&i="+Math.random();
				
				_car.startAjax();
			}
		},
		startAjax:function(){
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: _car.data,
			  dataType: "json",
			  success: function(data){
			  		_car.resultAjax(data);
			  }
			});
		},
		resultAjax:function(data){
			if(data.status=="0"){
				window.location.href=servicePath+"/cars.html";
			}
		}
		
	}
	_car.add();
}