
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

$(function () {
	
	// 折叠|展开全部商品
	$(".showGoodSort").click(function () {
		if ($(".GoodSort").css("display") == "block") {
			$(".meu_shangpin").removeClass("meu_shangpin222");
			$(".GoodSort").css("display", "none");
		} else {
			$(".meu_shangpin").addClass("meu_shangpin222");	
			$(".GoodSort").css("display", "");
		}
	});
	
	// 折叠|展开全部商家
	$(".showSJSort").click(function () {
		if ($(".SJSort").css("display") == "block") {
			$(".SJSort").css("display", "none");
		} else {
			$(".SJSort").css("display", "");
		}
	});
	
	// 输入框键盘事件，按下回车时调用搜索
	$("#search").keyup(function (event) {
		if (event.which == 13) {
			$(".search").trigger("click");
		}
	});
	
	// 搜索按钮
	$(".search").click(function () {
		var html = "<form id=\"searchFrom\" action=\"" + servicePath + "/goodSearch.html\" method=\"post\">";
		html += "<input type=\"hidden\" name=\"key\" value=\"" + $("#search").val() + "\">";
		html += "</form>";
		
		if($("#search").val().length>0){
			$(window.document.body).append(html);
			$("#searchFrom").submit();
		}
	});
	
	// 全部商家分类展开收缩
	$(".meu_shanjia").unbind("click").click(function(){
		
		if($(".ind_meu_fubb").css("display")=="none"){
			$(".meu_shanjia").addClass("meu_shanjia222");
		}else{
			$(".meu_shanjia").removeClass("meu_shanjia222");
		}
		// 展开菜单
		$("#menu01").slideToggle(100).css("display","");
	});
	
	 $(".meu_14222").unbind("click").click(function(){
                var  mappend =$(this).attr("mappend");  
                $("."+mappend).slideToggle(100).css("display","");
                if($(this).attr("name")=="selected"){
                        $(this).css("background-image","url(img/x1420bg_01.gif)");
                        $(this).attr("name","");
                }else{
                    $(this).attr("name","selected");
                    $(this).css("background-image","url(img/x1420bg_02.gif)");
                }
     });
     
     $("[search]").focus(function(){
     	if($(this).val()=="请输入宝贝名称"){
     		$(this).val("");
     	}
     }).blur(function(){
     	if($(this).val()==""){
     		$(this).val("请输入宝贝名称");
     	}
     })
});

