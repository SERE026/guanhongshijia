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


	
	$("#lotteryBtn").click(function(){
		new Login().checkLogin();
	})
		
})
	var rotateFunc = function(awards,angle,text){  //awards:奖项，angle:奖项对应的角度
		$('#lotteryBtn').stopRotate();
		$("#lotteryBtn").rotate({
			angle:0, 
			duration: 5000, 
			animateTo: angle+1440, //angle是图片上各奖项对应的角度，1440是我要让指针旋转4圈。所以最后的结束的角度就是这样子^^
			callback:function(){
				var left=($(window).width()-$(".gameBox").width())/2;
				var top=($(window).height()-$(".gameBox").height())/2;
				$(".gameBox").css("left",left);
				$(".gameBox").css("top",top);
				$(".gameBox").css("display","");
				$(".gameBox .text").html(text+"元优惠");
				$(".gameBox .colse").click(function(){
					$(".gameBox").css("display","none");
				});
				
			}
		}); 
	};
Game=function(){
	this.start=function(){
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html?widget=gameWidget&action=updata&data="+$(".pageX").attr("data"),
			  dataType: "json",
			  success: function(data){
			  	if(data.status==0){
			  		rotateFunc(data.des,data.angle,data.pirce);
			  	}else{
			  		
			  	}
			  }
			});
	}
}

Login=function(){
	this.checkLogin=function(){
		$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html?widget=gameWidget&action=checkLogin",
		  dataType: "json",
		  success: function(data){
		  	if(data.status==0){
		  		checkAct();
		  		
		  	}else{
		  		var left=($(window).width()-$(".loginBox").width())/2;
				var top=($(window).height()-$(".loginBox").height())/2;
				$(".loginBox").css("left",left);
				$(".loginBox").css("top",top);
				$(".loginBox").css("display","");
		  	}
		  }
		});
	}
	
	checkAct=function(){
		$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html?widget=gameWidget&action=checkAct&data="+$(".pageX").attr("data"),
		  dataType: "json",
		  success: function(data){
		  	if(data.status==0){
		  		new Game().start();
		  	}else{
		  		var left=($(window).width()-$(".tip").width())/2;
				var top=($(window).height()-$(".tip").height())/2;
				$(".tip").css("left",left);
				$(".tip").css("top",top);
				$(".tip").css("display","");
				$(".tip .colse").click(function(){
					$(".tip").css("display","none");
				});
		  		
		  		
		  	}
		  }
		});
	}
	
	
	$(".loginBox .close").unbind("click").click(function(){
		$(".loginBox").css("display","none");
	})
	$(".loginBox .u_n").unbind("click").keyup(function(){
		$(".loginBox .u_nmsg").css("display","none");
	})
	$(".loginBox .u_p").unbind("click").keyup(function(){
		$(".loginBox .u_pmsg").css("display","none");
	})
	
	$(".loginBox .ok").unbind("click").click(function(){
		if($(".loginBox .u_n").val().length<6){
			$(".loginBox .u_nmsg").html("用户名不正确！");
			$(".loginBox .u_nmsg").css("display","");
			return ;
		}
		if($(".loginBox .u_p").val().length<6){
			$(".loginBox .u_pmsg").html("密码不正确！");
			$(".loginBox .u_pmsg").css("display","");
			return ;
		}
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html?widget=bbsSendWidget&action=login",
			  data: "u_n="+$(".loginBox .u_n").val()+"&u_p="+$(".loginBox .u_p").val(),
			  dataType: "json",
			  success: function(data){
			  	if(data.status==0){
			  		$(".loginBox").remove();
			  		new Game().start();
			  	}else{
			  	     $(".loginBox .u_pmsg").css("display","");
			  		$(".loginBox .u_pmsg").html("登录失败，请检查用户名密码！");
			  	}
			  }
			});
		
	})
}