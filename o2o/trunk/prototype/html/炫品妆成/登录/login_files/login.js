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
	$("#accout").click(function(){
		if(	$("#accout").val()=="邮箱/手机号/用户名"){
			$("#accout").val("");
		}
		$("#accoutts").text("");
	});
	$("#password").click(function(){
		$("#passwordts").text();
	});
	$("#validinput").blur(function(){
			validcodeyz();
	})
	$("#password").blur(function(){
		if($("#password").val()==""){
			$("#passwordts").html("密码不能为空！");
		}
		//if($("#password").val().length<6||$("#password").val().length>12){
		//	$("#passwordts").html("密码为6-12位！");
		//	$("#passwordts").css("display","");
	//	}
	});
	$(".submit").click(function(){
		submitdl();
	})
	/**
	qq登录
	**/
	$(".qqLoginBtn").click(function(){
		qqLogin();
	});
});
function validationCode(){
	var vSpan = document.getElementById('validCode');
	var content ="<img src='"+servicePath+"/html/validCode?num="+Math.random()+
		"'  onclick='validationCode()' onclick='validationCode()' title='我要换一个验证码'/>";
	vSpan.innerHTML = content;
}

function accoutyz(){
	var accout=$("#accout").val();
	if(accout == ""){
		$("#accoutts").html("账户名不能为空！");
	}else if(accout.length<6||accout.length>15){
		$("#accoutts").html("账户长度为6-15");
	}
}


function validcodeyz(){
	var validinput=$("#validinput").val();
	if(validinput==""){
		$("#validts").html("验证码不能为空！");
	}else if(validinput.length<4){
		$("#validts").html("验证码格式不对！");
	}
}




function qqLogin(){
	window.location.href="https://graph.qq.com/oauth2.0/authorize?response_type=token&client_id=101058688&redirect_uri=http://www.c-1-tech.com/Dress/qqreturn.jsp&state=123456"
	//window.open("https://graph.qq.com/oauth2.0/authorize?response_type=token&client_id=100409917&redirect_uri=http://www.cyclebicycle.net/qqreturn.jsp&state=123456","",'modal=yes,width=620,height=520,resizable=yes,scrollbars=no,location=no,scrollbars=yes,toolbar=no,menubar=no');
	//window.open("https://graph.qq.com/oauth2.0/authorize?response_type=token&client_id=100397054&redirect_uri=&state=123456","",'modal=yes,width=620,height=520,resizable=yes,scrollbars=no,location=no,scrollbars=yes,toolbar=no,menubar=no')
}

function submitdl(){
		var validts=$("#validinput").val();
		var	password=$("#password").val();
		var	accout=$("#accout").val();
		$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html",
		  data: "widget=loginBar&accoutname="+accout+"&password="+password+"&validts="+validts+"&submittype=1",
		  dataType: "json",
		  success: function(data){
	  		if(data.status==0){
	  			var url =servicePath+"/"+ data.goUrl;
	  			window.location.href = url;
	  		}else if(data.status==1){
	  			var url = data.goUrl;
	  			window.location.href = url;
	  		}else if(data.status==2){
	  			$("#passwordts").html("密码错误！");
				$("#passwordts").css("display","");
	  		}else if(data.status==3){
	  			$("#validts").html("验证码错误！");
	  			$("#validts").css("display","");
	  			validationCode();
	  		}else if(data.status==4){
	  			$("#accoutts").html("帐户不存在！");
	  		}
		  }
		});	
}
