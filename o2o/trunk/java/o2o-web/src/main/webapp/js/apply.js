
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
	$(".submit").click(function(){
		if(checkData()){
		submitData();}
	})
})
function submitData(){
	var data="";
	data+="&name="+$(".name").val();
	data+="&contactMan="+$(".contactMan").val();
	data+="&contactTel="+$(".contactTel").val();
	data+="&contactPhone="+$(".contactPhone").val();
	data+="&contactEmail="+$(".contactEmail").val();
	data+="&companyName="+$(".companyName").val();
	data+="&provinceId="+$("#provinceId").val();
	data+="&cityId="+$("#cityId").val();
	data+="&countyId="+$("#countyId").val();
	data+="&address="+$(".address").val();
	data+="&busType="+$(".busType:checked").val();
	data+="&mhType="+$(".mhType").val();
	$.ajax({
		  type: 'POST',
		  url: servicePath+"/widget.html?widget=applyWidget&action=saveApply&dataType=json",
		  data: data,
		  dataType: "json",
		  success: function(data){
			  	if(data.status==0){
			  		alert("提交成功！请耐心等待审核！");
			  		window.location.href=servicePath+"/index.html"
			  	}
		  }
		});
	
}
function checkData(){
	var check=true;
	if($(".name").val().length<3){
		$(".msg:eq(0)").css("display","");
		check=false;
	}
	if($(".contactMan").val().length==0){
		$(".msg:eq(1)").css("display","");
		check=false;
	}
	var tel_reg=/^[\d|\+|\_|\-]+$/;
	var phone_reg=/^[\d|-|\+]{3,20}$/;
	if(!tel_reg.test($(".contactTel").val())&&!phone_reg.test($(".contactPhone").val())){
		$(".msg:eq(2)").css("display","");
		$(".msg:eq(3)").css("display","");
		check=false;
	}
	 var emial_reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!emial_reg.test($(".contactEmail").val())){
		$(".msg:eq(4)").css("display","");
		check=false;
	}
	if($(".companyName").val().length==0){
		$(".msg:eq(5)").css("display","");
		check=false;
	}
	if($("#provinceId").val().length==0){
		$(".area").css("display","");
		check=false;
	}
	if($("#cityId").val().length==0){
		$(".area").css("display","");
		check=false;
	}
	if($("#countyId").val().length==0){
		$(".area").css("display","");
		check=false;
	}
	if($(".address").val().length==0){
		$(".msg:eq(6)").css("display","");
		check=false;
	}
	return check;
}