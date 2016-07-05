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
	$("#adressgl").css("color","#f0125b");
	$("#adressgl").css("background-color","#e0e0e0");
	address("provinceId","cityId","countyId",servicePath+"/html/adress/json/selection");
	$("#code").blur(function(){
		if(this.value==""){
			$("#codets").css("display","");
		}
	});
	$("#code").focus(function(){
		$("#codets").css("display","none");
	});	
	
	$("#address").blur(function(){
		if(this.value==""){
			$("#addressts").css("display","");
		}
	});
	$("#address").focus(function(){
		$("#addressts").css("display","none");
	});
	$("#receiveName").blur(function(){
		if(this.value==""){
			$("#receiveNamets").css("display","");
		}
	});
		$("#receiveName").focus(function(){
			$("#receiveNamets").css("display","none");
	});
});

function gosubmit(){
	var RegCellPhone = /^1[0-9]{10}$/;
	var province=($("#provinceId").val()=="");
	var city=($("#cityId").val()=="");
	var county=($("#countyId").val()=="");
	if(province||city||county){
		$("#adresssts").css("display","");
	}else if($("#code").val()==""){
		$("#codets").css("display","");
	}else if ($("#address").val()==""){
		$("#addressts").css("display","");
	}else if($("#receiveName").val()==""){
		$("#receiveNamets").css("display","");
	}else if($("#receivePhone").val()!=""&!RegCellPhone.test($("#receivePhone").val())){
		$("#phonets").css("display","");
	}else{
		document.form1.submit();
		alert("保存成功！");
		window.location.href="huiyuan_adress.html";
	}
}

function deleteadress(adressMemberid){
	$.ajax({
		type: 'POST',
		url: servicePath+"/widget.html",
		data: "widget=adress&adressMemberid="+adressMemberid,
		dataType: "html",
		success: function(data){
			 alert("删除成功！");
			 window.location.href="huiyuan_adress.html";
		}
	});	
}

function modifyAdress(adresModifyid){
	
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=adress&adresModifyid="+adresModifyid,
			  dataType: "html",
			  success: function(data){	
			  }
			});	
}

function godefault(defaultId){
	$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=adress&defaultId="+defaultId,
			  dataType: "html",
			  success: function(data){	
			 	 alert("设置成功！");
			 	 window.location.href="huiyuan_adress.html";
			  }
			});	
}
