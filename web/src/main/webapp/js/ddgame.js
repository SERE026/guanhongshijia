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

var isGame=true;
$(function(){
	$(".start").click(function(){
		var l=new Login();
		l.checkLogin();
	})
	
	$(".btn img").mouseup(function(){
		$(this).attr("src","img/dian_da.jpg")
	}).mousedown(function(){
		$(this).attr("src","img/dian_zhong.jpg")
	})
})
Game=function(){
	
	btn=false;
	count=0;
	djs=5;
	var excessiveTime=null;
	var endTime=null;
	this.start=function(){
		excessiveTime=window.setInterval("excessive()",1000);
	}
	
	excessive=function(){
		if(djs<=0){
			$(".startText").html("开始，GO!");
			kaishi();
			window.clearInterval(excessiveTime);
		}
		$(".startText").html("准备时间："+djs+"S");
		djs--;
		
	}
	end=function(){
		isGame=true;
		$(".btn").unbind("click");
		window.clearInterval(endTime);
		btn=false;
		$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html?widget=gameWidget&action=updata&count="+count+"&data="+$(".pageX").attr("data"),
		  dataType: "json",
		  success: function(data){
		  	if(data.status==0){
		  		var left=($(window).width()-$(".gameBox").width())/2;
				var top=($(window).height()-$(".gameBox").height())/2;
				$(".gameBox").css("left",left);
				$(".gameBox").css("top",top);
				$(".gameBox").css("display","");
				$(".gameBox .text").html(data.pirce+"元优惠");
				$(".gameBox .colse").click(function(){
					$(".gameBox").css("display","none");
				});
		  	}else{
		  		
		  	}
		  }
		});
	}
	kaishi=function(){
		this.btn=true;
		$(".btn").click(function(){
			if(btn){
				count++;
				$(".startText").html("点击"+count+"次！");
			}
		})
		endTime=window.setInterval("end()",1000*5);
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
		  		if(isGame){
			  		new Game().start();
			  		isGame=false;
		  		}
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
			  		checkAct();
			  	}else{
			  		$(".loginBox .u_pmsg").html("登录失败，请检查用户名密码！");
			  	}
			  }
			});
		
	})
}