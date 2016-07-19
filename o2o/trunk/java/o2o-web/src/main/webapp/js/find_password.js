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
	validationCode();
	$("#email").focus();
	$("#email").attr("class","zhaohui_kuai_right_shuru_bb");
	$("#emailyz02").css("display","");
	$("#validinput").blur(function(){
		validcodeyz();
	});
	$("#email").blur(function(){
		email();
	});
	$("#email").focus(function(){
		if(	$("#emailyz01").css("display")=="none"){
			$("#emailyz02").attr("class","wenzi_tisji14");
			$("#email").attr("class","zhaohui_kuai_right_shuru_bb");
			$("#emailyz02").html("您用来登陆的Email地址！");
			$("#emailyz02").css("display","");
			if($("#validyz01").css("display")=="none"){
				$("#validyz02").css("display","none");
				$("#validinput").attr("class","zhaohui_kuai_right_shuru2_aa");
			 }
		}
	});

	$("#validinput").focus(function(){
		if(	$("#validyz01").css("display")=="none"){
			$("#validyz02").attr("class","wenzi_tisji14");
			$("#validinput").attr("class","zhaohui_kuai_right_shuru2_bb");
			$("#validyz02").css("display","");
			if($("#emailyz01").css("display")=="none"){
				$("#emailyz02").css("display","none");
				$("#email").attr("class","zhaohui_kuai_right_shuru_aa");
			}
		 }
	});
});
function validationCode(){
	var vSpan = document.getElementById('validCode');
	var content ="<img src='"+servicePath+"/html/manage/main/validCode?num="+Math.random()+
		"'  onclick='validationCode()' onclick='validationCode()' title='我要换一个验证码!'/>";
	vSpan.innerHTML = content;
};

function email(){
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	var temp = $("#email").val();
	if(temp == ""){
		$("#email").attr("class","zhaohui_kuai_right_shuru_aa");
		$("#emailyz02").css("display","none");
		$("#emailyz01").css("display","none");
		$("#emailyes").css("display","none");
		return;
	}else if(!myreg.test(temp)){
		$("#email").attr("class","zhaohui_kuai_right_shuru_cc");
		$("#emailyz02").attr("class","wenzi_tisji");
		$("#emailyz02").html("请输入有效的邮箱地址！");
		$("#emailyz02").css("display","");
		$("#emailyz01").css("display","");
		$("#emailyes").css("display","none");
		return;
	}else{
		$.ajax({
			type: 'POST',
			url: servicePath+"/widget.html",
			data: "widget=loginBar&temp="+temp,
			dataType: "html",
			success: function(data){
				if(data=="1"){
				  	$("#emailyes").css("display","");
					$("#emailyz02").css("display","none");
					$("#emailyz01").css("display","none");
					$("#email").attr("class","zhaohui_kuai_right_shuru_aa");
				 }else{
				  	$("#email").attr("class","zhaohui_kuai_right_shuru_cc");
					$("#emailyz02").attr("class","wenzi_tisji");
					$("#emailyz02").html("您输入的邮箱不存在！");
					$("#emailyz02").css("display","");
					$("#emailyz01").css("display","");
					$("#emailyes").css("display","none");
				}
			}
		});	
	}
}

function validcodeyz(){
 	var validinput=$("#validinput").val();
			if(validinput==""){
			 	$("#validinput").attr("class","zhaohui_kuai_right_shuru2_aa");
			 		$("#validyz02").css("display","none");
					$("#validyz01").css("display","none");
					 $("#validyes").css("display","none");
				return;
			}else if(validinput.length!=4){
				$("#validinput").attr("class","zhaohui_kuai_right_shuru2_cc");
			 	$("#validyz02").attr("class","wenzi_tisji");
			 	$("#validyz02").html("验证码格式不对！");
				$("#validyz02").css("display","");
				$("#validyz01").css("display","");
				$("#validyes").css("display","none");
			}else{
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=loginBar&validinput="+validinput,
			  dataType: "html",
			  success: function(data){
			  		if(data=="0"){
			  			 $("#validyes").css("display","");
						 $("#validyz02").css("display","none");
						 $("#validyz01").css("display","none");
						 $("#validinput").attr("class","zhaohui_kuai_right_shuru2_aa");
			  		}else{
			  				$("#validinput").attr("class","zhaohui_kuai_right_shuru2_cc");
						 	$("#validyz02").attr("class","wenzi_tisji");
						 	$("#validyz02").html("验证码输入不对！");
							$("#validyz02").css("display","");
							$("#validyz01").css("display","");
							$("#validyes").css("display","none");
			  		}
			  }
			});	
			}
}

function find(){
	var adress=$("#email").val();
	var validinput=$("#validinput").val();
	$.ajax({
		type: 'POST',
		url: servicePath+"/widget.html",
		data: "widget=loginBar&temp="+adress,
		dataType: "html",
		success: function(data){
			if(data=="1"){
				$("#emailyes").css("display","");
				$("#emailyz02").css("display","none");
				$("#emailyz01").css("display","none");
				$("#email").attr("class","zhaohui_kuai_right_shuru_aa");
				$.ajax({
						type: 'POST',
						url: servicePath+"/widget.html",
						data: "widget=loginBar&validinput="+validinput,
						dataType: "html",
						success: function(data){
							if(data=="0"){
									$("#validyes").css("display","");
									$("#validyz02").css("display","none");
									$("#validyz01").css("display","none");
									$("#validinput").attr("class","zhaohui_kuai_right_shuru2_aa");
									$.ajax({
										type: 'POST',
										url: servicePath+"/widget.html",
										data: "widget=loginBar&adress="+adress,
										dataType: "html",
										success: function(data){
											window.location.href="find_password_sucess.html?eamil="+adress;
										}	
									});	
													
								}else{
									$("#validinput").attr("class","zhaohui_kuai_right_shuru2_cc");
									$("#validyz02").attr("class","wenzi_tisji");
									$("#validyz02").html("验证码输入不对！");
									$("#validyz02").css("display","");
									$("#validyz01").css("display","");
									$("#validyes").css("display","none");
								}
							}
					});	
				}else{
				    $("#email").attr("class","zhaohui_kuai_right_shuru_cc");
				    $("#emailyz02").attr("class","wenzi_tisji");
					$("#emailyz02").html("您输入的邮箱不存在！");
					$("#emailyz02").css("display","");
					$("#emailyz01").css("display","");
					$("#emailyes").css("display","none");
				}
		 }
	});	
}


