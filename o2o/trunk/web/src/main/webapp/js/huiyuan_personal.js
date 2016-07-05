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

var phone_V=true;
var email_V=true;
var qq_V=true;

$(function(){
		$("#zlwf").css("color","#f0125b");
		$("#zlwf").css("background-color","#e0e0e0");
		address("provinceId","cityId","countyId",servicePath+"/html/adress/json/selection");
		$("#msginput").click(function (){
			if($("#msginput").val()	== "输入短信验证码"){
				$("#msginput").val("");
			}
		});
		
		$("#phonenumber").blur(function(){
				phoneone();
		});
		$("#editemail").blur(function(){
				emailnone();
		});
		$("#qq").blur(function(){
				validateqq();
		});
});

function submit(){
	if(phone_V&&email_V&&qq_V){
	 	cout=0;
		var telnumber= $("#phonenumber").val();
		if(telnumber==""){
			 $("#telts").html("手机号码不能为空！");
			$("#telts").css("display","");
			cout++;
		}else if(!telnumber.match(/^1[3|4|5|8][0-9]\d{4,8}$/)){
			$("#telts").html("输入正确的手机号码！");
			$("#telts").css("display","");
			cout++;
		}else{
			$("#telts").css("display","none");
		}
		
		
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		var temp = $("#editemail").val();
		if(temp == ""){
			$("#emailts").html("邮箱不能为空！");
			$("#emailts").css("display","");
			cout++;
		}else if(!myreg.test(temp)){
		 	$("#emailts").html("邮箱格式不对！");
			$("#emailts").css("display","");
			cout++;
		 }else{
		 	$("#emailts").css("display","none");
		 }
		 
		 if(!validateIdCard()){
		 	cout++;
		 }
		if(cout==0){
			document.form1.submit();
			//window.location.href="huiyuan_personal.html";
		}
	}else{
		
	}
}
function editsj(){
	$("#oldsjxg").remove();
	$("#oldsj").css("display","none");
	$("#editsj").css("display","");
	$("#yzdivsj").remove();

}

function edityx(){
	$("#oldyxxg").remove();
	$("#oldyx").css("display","none");
	$("#edityx").css("display","");
	$("#yzdivyx").remove();

}

function goemailyz(){
	var eladress=$("#editemail").val();
	$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=personal&eladress="+eladress,
			  dataType: "html",
			  success: function(data){
			  	 alert("验证的邮件已经发到您的邮箱：("+eladress+")请注意查收！");
			  }
	});	

}

function gophone(){
	var phonenumber=$("#phonenumber").val();
	$("#msgcode").css("display","");
	$("#yzdivsj").remove();
	$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html",
		  data: "widget=personal&phone="+phonenumber,
		  dataType: "html",
		  success: function(data){
		  if(data=='0'){
		  	 alert("短信发送过于频繁！");
		  }else if(data=='1'){
		  	 alert("短信验证码已发出，请注意查收！");
		  }else{
		   	 alert("验证失败！")
		  }
		  }
	});	
}
function submitcode() {
	var msgcode = $("#msginput").val();
	$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html",
		  data: "widget=personal&msgcode="+msgcode,
		  dataType: "html",
		  success: function(data){
		  		window.location.href="huiyuan_personal.html";
		  }
	});	
}

function validateIdCard(){
		var strIDno = $("#idcardno").val();
		if(idCardLength>0){
	 		var idCardLength = strIDno.length;
	 	 	if(!/^\d{17}(\d|x)$/i.test(strIDno)&&!/^\d{15}$/i.test(strIDno)){
	 	 		$("#idcardts").html("身份证号码无效！");
				$("#idcardts").css("display","");
				return false;
	 	 	}else{
	 	 		$("#idcardts").css("display","none");
	 	 		return true;
	 	 	}
 	 	}else{
 	 		 return true;
 	 	}
}
function validateqq(){
	var qq = $("#qq").val();
	$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html",
		  data: "widget=personal&qq="+qq,
		  dataType: "html",
		  success: function(data){
			if(data=="1"){
				$(".qqmsg").html("qq已经存在！");
				$(".qqmsg").css("display","");
				qq_V=false;
				return false;
			}else{
				$(".qqmsg").css("display","none");
				qq_V=true;
				return true;
			}
		}
	});	
}
function phoneone(){
	var phoneno = $("#phonenumber").val();
	$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=personal&phoneno="+phoneno,
			  dataType: "html",
			  success: function(data){
				if(data=="1"){
					$("#telts").html("电话已经存在！");
					$("#telts").css("display","");
					phone_V=false;
					return false;
				}else{
					phone_V=true;
					$("#telts").css("display","none");
					return true;
				}
			}
	});	
}

function emailnone(){
	var mailno = $("#editemail").val();
	$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=personal&mailno="+mailno,
			  dataType: "html",
			  success: function(data){
			  	if(data=="1"){
					$("#emailts").html("邮箱已经存在！");
					$("#emailts").css("display","");
					email_V=false;
					return false;
				}else{
					$("#emailts").css("display","none");
					email_V=true;
					return true;
				}
			 }
	});	
}