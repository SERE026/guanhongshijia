
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
	$("#suresubmit").click(function(){
		tosubmit();
	});
	$(".saveAddress").click(function(){
		new addSite();
	});
	
	$(".toAddress").html($("input[name='receiveId']:checked").attr("data_value"));
	address("provinceId","cityId","countyId",servicePath+"/widget.html?widget=tryuseApply&action=getArea&dataType=json");
	
})

function tosubmit(){
	var reason=$("#reason").val();
	if(reason==""){
		alert("申请理由不能为空！");
		return;
	}else if($('input:radio[name="receiveId"]:checked').val()==null){
			alert("您没有选择地址！");
			return;
	}
	
	if($("#yhxy").attr("checked")==true){
	var postData="&receiveId="+$("input[name='receiveId']:checked").val();
	postData+="&reason="+reason;
	postData+="&goodsid="+$("#goodsid").val();
	$.ajax({
				  type: 'POST',
				  url: servicePath+"/widget.html",
				  data: "widget=tryuseApply&action=create&dataType=json"+postData,
				  dataType: "json",
				  cache:false,
				  success: function(data){
					if(data=="1"){
			  			alert("申请成功！");
			  			window.location.href=servicePath+"/huiyuan_tryuse.html";
		  			}
				  		}
				});
	}else{
		alert("对不起，操作失败，请认阅读用户协议书！");
	}
}

function addSite(){
	var site={
		
		add:function(){
			if(site.validation()){
				var receiveName=$(".receiveName").val();
				var provinceId=$(".province").val();
				var cityId=$(".city").val();
				var countyId=$(".county").val();
				var address=$(".address").val();
				var code=$(".code").val();
				var receivePhone=$(".receivePhone").val();
				var receiveTel=$(".receiveTelW").val()+"-"+$(".receiveTelQ").val()+"-"+$(".receiveTel").val();
				var email=$(".receiveEmail").val();
				var receiveDate=$(".receiveDate:checked").val();
				var Isdefault="0";
				if($(".Isdefault:checked").length==1){
					Isdefault="1";
				}
				var RegCellPhone = /^1[0-9]{10}$/;
				var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
				if(receivePhone!=""&!RegCellPhone.test(receivePhone)){
					alert("手机号码输入有误,请重新输入！");
					$(".receivePhone").css("border","#ff6600 solid 1px");
					return;
				}
				if(email!=""&!myreg.test(email)){
					alert("Email地址输入有误,请重新输入！");
					$(".receiveEmail").css("border","#ff6600 solid 1px");
					return;
				}
				
				site.submit(receiveName,provinceId,cityId,countyId,address,code,receivePhone,receiveTel,email,Isdefault,receiveDate);
			}
		}
		,
		submit:function(receiveName,provinceId,cityId,countyId,address,code,receivePhone,receiveTel,email,Isdefault,receiveDate){
			var postData="";
				postData+="&receiveName="+receiveName;
				postData+="&provinceId="+provinceId;
				postData+="&cityId="+cityId;
				postData+="&countyId="+countyId;
				postData+="&address="+address;
				postData+="&code="+code;
				postData+="&receivePhone="+receivePhone;
				postData+="&receiveTel="+receiveTel;
				postData+="&email="+email;
				postData+="&Isdefault="+Isdefault;
				postData+="&receiveDate="+receiveDate;
				postData+="&o_i="+Math.random();
			$.ajax({
				  type: 'POST',
				  url: servicePath+"/widget.html",
				  data: "widget=tryuseApply&action=addAddress&dataType=html"+postData,
				  dataType: "html",
				  success: function(data){
				  		$(".selectaddress").after(data);
				  }
			});
			$(".receiveName").val("");
			$(".province").val("");
			$(".city").val("");
			$(".county").val("");
			$(".address").val("");
			$(".code").val("");
			$(".receivePhone").val("");
			$(".receiveTelW").val("")+"-"+$(".receiveTelQ").val("")+"-"+$(".receiveTel").val("");
            $(".receiveEmail").val("");		
		    $(".receiveDate:checked").val("");
		}
		,
		validation:function(){
			var isresult=true;
			if($(".receiveName").val().length==0){
				$(".receiveName").css("border","#ff6600 solid 1px");
				isresult=false;
			}
			if($(".province").val().length==0){
				$(".province").css("border","#ff6600 solid 1px");
				isresult=false;
			}
			if($(".city").val().length==0){
				$(".city").css("border","#ff6600 solid 1px");
				isresult=false;
			}
			if($(".county").val().length==0){
				$(".county").css("border","#ff6600 solid 1px");
				isresult=false;
			}
			if($(".address").val().length==0){
				$(".address").css("border","#ff6600 solid 1px");
				isresult=false;
			}
			if($(".code").val().length==0){
				$(".code").css("border","#ff6600 solid 1px");
				isresult=false;
			}
			
			if($(".receivePhone").val().length==0){
				$(".receivePhone").css("border","#ff6600 solid 1px");
				 //$(".receiveTel").css("border","#ff6600 solid 1px");
				isresult=false;
			}
			/*if($(".receiveEmail").val().length==0){
				$(".receiveEmail").css("border","#ff6600 solid 1px");
				isresult=false;
			}*/
			
			return isresult;
		}
	}
	site.add();
}