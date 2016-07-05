
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

var areaBoxHeight=300;
	$(function(){
		var html=$(".initArea").html();
		$(".initArea").remove();
		$(window.document.body).append(html);
		$(".areaBox").css("position","absolute").css("z-index","10000");
		areaBoxHeight=$(".areaBox").height();
		$(".selectArea").click(function(){
			$(".areaBox").css("display","");
			$(".areaBox").css("left",$(this).offset().left+"px").css("top",$(this).offset().top+"px");
			$(".areaBox").css("height","1px");
			$(".areaBox").animate({"height":areaBoxHeight},1000);
		})
		$(".selectAreaColse").click(function(){
			$(".areaBox").animate({"height":0},900);
			window.setTimeout("hiddSelectAReaBox()",950);
		});
		$(".switchArea").click(function(){
			var id=$(this).attr("areaId");
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=ArearWidget&dataType=json&id="+id+"&action=switch&i="+Math.random(),
			  dataType: "json",
			  success: function(data){
			  		if(data.status==1){
			  			window.location.href=servicePath+"/index.html";
			  		}
			  }
			});
		});
	})
	
	function hiddSelectAReaBox(){
		$(".areaBox").css("display","none");
	}

	