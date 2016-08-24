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

var sub=false;
var pass=true;
var passTwo=true;
var phoneOK = false; // 手机是否验证，未验证不允许注册
var v=true;


$(function(){
		validationCode();
		$("#submit").click(function () {
			gosumbit();
		});
		$("#phone").blur(function(){
			phoneyz();
		});
		$("#password1").blur(function(){
			psw1yz();
		});
		$("#password2").blur(function(){
			psw2yz();
		});
		$("#validinput").click(function(){
			$("#validts").css("display","none");
		});
		
		$("#btnOk").click(function(){
			checkCode();
		})
		
		$("#accout").click(function(){
			$("#accoutts").css("display","none");
		});
		
		$("#password1").click(function(){
			$("#psw1ts").css("display","none");
		});
		
		$("#password2").click(function(){
			$("#psw2ts").val("");
			$("#psw2ts").css("display","none");
		});
		
		addEvent();
		
		$("#btnSend2").click(function() {
			sendCode();
		});
		
		$("#codeValue").focus(function() {
			var v = $(this).val();
			$(this).val("");
		});
		
		$("#phone").focus(function() {
			$("#phonets").css("display","none");
			//$("#send").css("display", "none");
		});
		
		$("#codeValue").blur(function() {
			var v = $(this).val();
			if (v == "") {
				$(this).val("输入验证码");
			} else {
				checkCode();
			}
		});
		
});

//查看用户协议
function showXieyi(){
	/*$("div").load('regist.html')
	alert(xieyi.html)*/
	$.layer({
	   	type : 2,
	    	title : '观红世家用户协议',
	    	iframe : {src : servicePath+'/xieyi.html'},
	    	area : ['750px' , '466px'],
	    	offset : ['100px','']
	});
}

function addEvent(){
	$("#btnSend").unbind("click").click(function() {
		if($("#phone").val() == ''){
			alert("请填写手机号");
			return;
		}
			var title = $(this).attr("value");
			if (title == "发送验证码") {
				$(this).attr("value", "发送中...");
				sendCode();
			}
		});
}


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
			  			//$("#btnSend").css("display", "none");
			  			$("#codeBox").css("display", "");
			  			$("#codeBox").unbind("click")
			  			$("#codeValue").val("输入验证码");
			  			$("#btnSend2").val("重发");
			  		}else{
			  			alert("3分钟内请勿重复发送！请稍后再试");
			  			$("#btnSend").val("发送验证码");
			  			$("#btnSend2").val("重发");
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
			  			$("#send").html("手机验证成功");
			  			$("#codeBox").css("display", "none");
			  			phoneOK = true;
			  		}else{
			  			$("#codeValue").val("验证失败！");
			  			phoneOK = false;
			  		}
			  }
	});	
}





function validationCode(){
	var vSpan = document.getElementById('validCode');
	var content ="<img src='"+servicePath+"/html/manage/main/validCode?num="+Math.random()+
		"'  onclick='validationCode()'  title='我要换一个验证码'/>";
	vSpan.innerHTML = content;
}

function validcodeyz(){
	var validinput=$("#validinput").val();
	if(validinput==""){
		$("#validts").html("验证码不能为空！");
		$("#validts").css("display","");
		v=false;
	}else if(validinput.length<4){
		$("#validts").html("验证码格式不对！");
		$("#validts").css("display","");
		v=false;
	}else{
		v=true;
	}
}

function accoutyz(){
	var accout=$("#accout").val();
	var phone = $("#phone").val();
	var email = $("#email").val();
	var type="";

	if(accout==""){
			$("#accoutts").html("账户名不能为空！");
			$("#accoutts").css("display","");
	}else{
		if(accout.match(/^1[3|4|5|8][0-9]\d{4,8}$/)){
				type="0";
		}else if(accout.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)){
				type="1";
		}else {
			if(accout.length<6||accout.length>15){
				$("#accoutts").html("账户长度为6-15");
				$("#accoutts").css("display","");
				return;
			}else{
				type="2";
			}
		}
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=loginBar&accout="+accout,
			  dataType: "html",
			  success: function(data){
			  		if(data=="1"){
			  			psw1yz();
						psw2yz();
						if(!sub&&pass&&passTwo&&v){
							sub=true;
							var accout=$("#accout").val();
							var password=$("#password2").val();
							$.ajax({
								type: 'POST',
								url: servicePath+"/widget.html",
								data: "widget=loginBar&email="+email+"&name="+accout+"&password=" +password + "&phone=" + phone + "&validinput="+$("#validinput").val()+"&p="+$(".m").val()+"&type="+type,
								dataType: "html",
								success: function(data){
						 			if(data=="0"){
						 				window.location.href="login.html";
						 			}else if(data=="1"){
						 				$("#validts").html("验证码错误！");
										$("#validts").css("display","");
										validationCode();
										sub=false;
						 			}
					  			}
							});	
						}
			  		}else{
			  			$("#accoutts").html("账户名已经存在！");
			  			$("#accoutts").css("display","");
			  		}
			  			
			  }
			});	
		}
}

function psw2yz(){
	var password1=$("#password1").val();
	var password2=$("#password2").val();
	if(password2==""){
		$("#psw2ts").html("密码不能为空！");
		$("#psw2ts").css("display","");
		pass=false;
		passTwo=false;
	}else if(password1!=password2){
		$("#psw2ts").html("两次输入密码不一致！");
		$("#psw2ts").css("display","");
		pass=false;
		passTwo=false;
	}else{
		pass=true;
		passTwo=true;
	}
}

function psw1yz(){
	var password1=$("#password1").val();
	if(password1==""){
		$("#psw1ts").html("密码不能为空！");
		$("#psw1ts").css("display","");
		pass=false;
	}
	else if(password1.length<6||password1.length>12){
		$("#psw1ts").html("密码不能小于6位，大于12位!");
		$("#psw1ts").css("display","");
		pass=false;
	}
	else{
		pass=true;
	}
}



/******************************************************************************
* 手机号码验证
******************************************************************************/
function phoneyz(){
	var phone = $("#phone").val();
	if(phone==""){
		$("#phonets").html("手机号码不能为空！");
		$("#phonets").css("display","");
		pass=false;
	} else {
		var regPartton=/1[3-8]+\d{9}/;
		if (! regPartton.test(phone) || phone.length!=11) {
			$("#phonets").html("手机号码格式不正确！");
			$("#phonets").css("display","");
		} else {
		//if($("#codeBox").css("display")=="none"){
			//$("#phonets").html('<input type="button" id="btnSend" value="发送验证码">');
		//}
		addEvent();
			// 检查手机号码是否已经存在
			$.ajax({
			 		type: 'POST',
					 url: servicePath+"/widget.html",
					 data: "widget=loginBar&phone=" + phone,
					 dataType: "html",
					 success: function(data){
			  			if(data=="0"){
			  				$("#phone").val("号码已存在，请重输");
			  				//$("#send").css("display", "none");
					  	}else{
							$("#send").css("display", "");
					  	}
				  }
			});	
		}
	}
}

 
function gosumbit(){
	validcodeyz();
	if (phoneOK == false) {
		alert("手机号码尚未验证！");
		return;
	}
	accoutyz();
}