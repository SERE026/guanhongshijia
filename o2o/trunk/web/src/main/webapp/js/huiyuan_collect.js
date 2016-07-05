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
	$("#wdsc").css("color","#f0125b");
	$("#wdsc").css("background-color","#e0e0e0");
	$("#selectall01").unbind(".click").click(function(){
		if($("#selectall01").attr("checked")==true){
			$("input[name=checkboxs]").attr("checked",true);
		}else{
			$("input[name=checkboxs]").attr("checked","");
		};
	});
});
	
function toshangjia(){
	//new page($(".page"),$(".pageBox"),"collect","1");
	$("#scbb").css("color","#3465cb");
	$("#scsj").css("color","#f0125b");
	$(".gr_sct01").remove();
}	

function active(){
	//new page($(".page"),$(".pageBox"),"collect","2");
}

function shelve(){
	//new page($(".page"),$(".pageBox"),"collect","3");
}

function selectall(){
	if($("#selectall01").attr("checked")==true){
		$("input[name=checkboxs]").attr("checked","");
	}else{
		$("input[name=checkboxs]").attr("checked",true);
	}
};

function del(id){
  	$.ajax({
		type: 'POST',
		url: servicePath+"/widget.html",
		data: "widget=collect&favoritid="+id,
		dataType: "html",
		success: function(data){
			alert("删除成功！");
			window.location.href="huiyuan_collect.html";
		}
	});	
};
function delall(){
	var strid="";
	$("[name=checkboxs]").each(function(i,s){
		if(i>0){
			if($(this).attr("checked")==true){
				strid=strid+$(this).val()+"/";
			}
		}
	});
	$.ajax({
		type: 'POST',
		url: servicePath+"/widget.html",
		data: "widget=collect&strid="+strid,
		dataType: "html",
		success: function(data){
			  alert("删除成功！");
			  window.location.href="huiyuan_collect.html";
		}
	});
	
};