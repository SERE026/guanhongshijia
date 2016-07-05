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

$(function (){
	$("#newpw").focus();
	$("#newpw02").css("display","");
	url = window.location.search.substr(1).split("&")[0];
	uuid = url.substring (5,url.length);
	$("#newpw").focus(function (){
			$("#newpwts02").css("display","");
			$("#newpwts01").css("display","");
			$("#newpwts03").css("display","none");
			$("#newpwts04").css("display","none");
			$("#newpwyes").css("display","none");
});
$("#newpw").blur(function (){
	newpwjc();
});
		
$("#aginpw").blur(function (){
	aginpwjc();
});

$("#newpw").focus(function(){
			if(	$("#newpw01").css("display")=="none"){
				$("#newpw02").attr("class","wenzi_tisji14");
				 $("#newpw").attr("class","zhaohui_kuai_right_shuru_bb");
				 $("#newpw02").html("6-12个字符，建议使用字母加数字的组合！");
				 $("#newpw02").css("display","");
					  if($("#aginpw01").css("display")=="none"){
						 $("#aginpw02").css("display","none");
						 $("#aginpw").attr("class","zhaohui_kuai_right_shuru_aa");
					   }
				 }
});
			
$("#aginpw").focus(function(){
			if(	$("#aginpw01").css("display")=="none"){
				 $("#aginpw02").attr("class","wenzi_tisji14");
				 $("#aginpw").attr("class","zhaohui_kuai_right_shuru_bb");
				 $("#aginpw02").html("再次输入密码！");
				 $("#aginpw02").css("display","");
				  if($("#newpw01").css("display")=="none"){
					 $("#newpw02").css("display","none");
					 $("#newpw").attr("class","zhaohui_kuai_right_shuru_aa");
				   }
				 }
			});
		
});

function submitpw(){
			var newpassword=$("#newpw").val();
			if(newpwjc()&&aginpwjc()){
				$.ajax({
				  type: 'POST',
				  url: servicePath+"/widget.html",
				  data: "widget=loginBar&newpassword="+newpassword+"&uuid="+uuid,
				  dataType: "html",
				  success: function(data){
				  if(data=="1"){
				 	 alert("修改密码成功！");
					 window.location.href="login.html";
				  }else if(data=="0"){
				  	 if(confirm("你的修改密码链接已经过期！是否重新发送修改链接?")){
				  	 	window.location.href="find_password.html";
				  	 }else{
				  	 	window.location.href="index.html";
				  	 }
				  }
				  }
				});	
			}

}
function newpwjc(){
		var newpassword=$("#newpw").val();
			if(newpassword==""){
					$("#newpw").attr("class","zhaohui_kuai_right_shuru_aa");
					$("#newpw02").css("display","none");
					$("#newpw01").css("display","none");
					$("#newpwyes").css("display","none");
					return false;
			}else if(newpassword.length<6||newpassword.length>15){
				$("#newpw").attr("class","zhaohui_kuai_right_shuru_cc");
			 	$("#newpw02").attr("class","wenzi_tisji");
			 	$("#newpw02").html("密码长度为6-15位！");
				$("#newpw02").css("display","");
				$("#newpw01").css("display","");
				$("#newpwyes").css("display","none");
				return false;
			}else{
					$("#newpwyes").css("display","");
					$("#newpw02").css("display","none");
					$("#newpw01").css("display","none");
					$("#newpw").attr("class","zhaohui_kuai_right_shuru_aa");
					return true;
				}	
}
function aginpwjc(){
			var firstpw=$("#newpw").val();
			var aginpw=$("#aginpw").val();
				if(aginpw==""){
					$("#aginpw").attr("class","zhaohui_kuai_right_shuru_aa");
					$("#aginpw02").css("display","none");
					$("#aginpw01").css("display","none");
					$("#aginpwyes").css("display","none");
					return false;
				}else if(firstpw!=aginpw){
					$("#aginpw").attr("class","zhaohui_kuai_right_shuru_cc");
				 	$("#aginpw02").attr("class","wenzi_tisji");
				 	$("#aginpw02").html(" 二次输入密码不相同！");
					$("#aginpw02").css("display","");
					$("#aginpw01").css("display","");
					$("#aginpwyes").css("display","none");
					return false;
				}else{
					$("#aginpwyes").css("display","");
					$("#aginpw02").css("display","none");
					$("#aginpw01").css("display","none");
					$("#aginpw").attr("class","zhaohui_kuai_right_shuru_aa");
						return true;
					}
}