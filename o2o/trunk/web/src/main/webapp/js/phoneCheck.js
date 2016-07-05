
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

	$("#phone").blur(function(){
		phoneyz();
	});
	
	$("#phone").focus(function(){
		$(".phoneErr").hide();
		$(".codeErr").hide();
	});
	
	$("#btnOk").click(function(){
		checkCode();
	})
	
	$("#codeValue").focus(function(){
		$(".codeErr").hide();
	});
	
	
	$("#btnSend").click(function () {
		var phoneCode=$("#phone").val();
		var regPartton=/1[3-8]+\d{9}/;
		
		if (!regPartton.test(phoneCode)) {
			$(".phoneErr").html("请输入正确的手机号！");
			$(".phoneErr").show();
			return ;
			
		}
		sendCode();
	});
	
	
	$("#codeValue").focus(function() {
			var v = $(this).val();
				$(this).val("");
		});
		
		
	$("#codeValue").blur(function() {
		var v = $(this).val();
		if (v == "") {
		} else {
			checkCode();
		}
	});
	
});

/**
* 发送短信验证码
*/
function sendCode() {
	var phone = $("#phone").val();
	$.ajax({
			 type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=loginBar&action=sendCode&phone=" + phone,
			  dataType: "html",
			  success: function(data){
			  		if(data=="1"){
			  			$("#btnSend").val("重新发送");
			  		}else{
			  			alert("3分钟内请勿重复发送！请稍后再试");
			  		}
			  }
	});	
}



/**
* 检查核对短信验证码
*/
function checkCode() {
	var phone = $("#phone").val();
	var codeValue = $("#codeValue").val();
	$.ajax({
			 type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=loginBar&action=checkCode&phone=" + phone + "&regCode=" + codeValue,
			  dataType: "html",
			  success: function(data){
			  		if(data=="1"){
			  			ok();
			  		}else{
			  			$(".codeErr").html("验证失败！");
			  			$(".codeErr").show();
			  			phoneOK = false;
			  		}
			  }
	});	
}




/******************************************************************************
* 手机号码验证
******************************************************************************/
function phoneyz(){
	var phone = $("#phone").val();
	if(phone==""){
		$(".phoneErr").html("手机号码不能为空！");
		$(".phoneErr").show();
		pass=false;
	} else {
		var regPartton=/1[3-8]+\d{9}/;
		if (! regPartton.test(phone) || phone.length!=11) {
			$(".phoneErr").html("手机号码格式不正确！");
			$(".phoneErr").show();
			$("#send").css("display", "none");
		} else {
			// 检查手机号码是否已经存在
			$.ajax({
			 		type: 'POST',
					 url: servicePath+"/widget.html",
					 data: "widget=loginBar&phone=" + phone,
					 dataType: "html",
					 success: function(data){
			  			if(data=="0"){
			  				$(".phoneErr").html("号码已存在，请重输");
			  				$(".phoneErr").show();
					  	}else{
					  		$("#phonets").css("display","");
							$("#send").css("display", "");
					  	}
				  }
			});	
		
		}	
	}
}


function ok() {
	var phone = $("#phone").val();
	window.location.href=servicePath + "/phoneCheck.html?action=ok&phone=" + phone;
}
