
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
	$(".applyFor a").click(function () {
		$(".nvrenjie_da").show();
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
function showXieyi(){
	$.layer({
	 type : 2,
	 title : '雅堂用户招商协议',
	 iframe : {src : servicePath+'/xieyi.html'},
	 area : ['750px' , '466px'],
	 offset : ['100px','']
	 });
	/*var str="<div class='protocol-con'><h4>雅堂用户招商协议</h4><p> 本协议是您与雅堂网站（简称'本站'，网址：www.guanhongshijia.com）所有者（以下简称为'雅堂'）之间就雅堂网站服务等相关事宜所订立的契约，请您仔细阅读本注册协议，您点击'同意并继续'按钮后，本协议即构成对双方有约束力的法律文件。</p><h5> 第1条 本站服务条款的确认和接纳</h5><p><strong>1.1</strong>本站的各项电子服务的所有权和运作权归雅堂所有。用户同意所有注册协议条款并完成注册程序，才能成为本站的正式用户。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。</p><p><strong>1.2</strong>用户点击同意本协议的，即视为用户确认自己具有享受本站服务、下单购物等相应的权利能力和行为能力，能够独立承担法律责任。</p><p><strong>1.3</strong>如果您在18周岁以下，您只能在父母或监护人的监护参与下才能使用本站。</p><p><strong>1.4</strong>雅堂保留在中华人民共和国大陆地区法施行之法律允许的范围内独自决定拒绝服务、关闭用户账户、清除或编辑内容或取消订单的权利。</p><h5> 第2条 本站服务</h5><p><strong>2.1</strong>雅堂通过互联网依法为用户提供互联网信息等服务，用户在完全同意本协议及本站规定的情况下，方有权使用本站的相关服务。</p><p><strong>2.2</strong>用户必须自行准备如下设备和承担如下开支：（1）上网设备，包括并不限于电脑或者其他上网终端、调制解调器及其他必备的上网装置；（2）上网开支，包括并不限于网络接入费、上网设备租用费、手机流量费等。</p><h5> 第3条 用户信息</h5><p><strong>3.1</strong>用户应自行诚信向本站提供注册资料，用户同意其提供的注册资料真实、准确、完整、合法有效，用户注册资料如有变动的，应及时更新其注册资料。如果用户提供的注册资料不合法、不真实、不准确、不详尽的，用户需承担因此引起的相应责任及后果，并且雅堂保留终止用户使用雅堂各项服务的权利。</p><p><strong>3.2</strong>用户在本站进行浏览、下单购物等活动时，涉及用户真实姓名/名称、通信地址、联系电话、电子邮箱等隐私信息的，本站将予以严格保密，除非得到用户的授权或法律另有规定，本站不会向外界披露用户隐私信息。</p><p><strong>3.3</strong>用户注册成功后，将产生用户名和密码等账户信息，您可以根据本站规定改变您的密码。用户应谨慎合理的保存、使用其用户名和密码。用户若发现任何非法使用用户账号或存在安全漏洞的情况，请立即通知本站并向公安机关报案。</p><p><strong>3.4</strong><strong>用户同意，雅堂拥有通过邮件、短信电话等形式，向在本站注册、购物用户、收货人发送订单信息、促销活动等告知信息的权利。</strong></p><p><strong>3.5</strong><strong>用户不得将在本站注册获得的账户借给他人使用，否则用户应承担由此产生的全部责任，并与实际使用人承担连带责任。</strong></p><p><strong>3.6</strong><strong>用户同意，雅堂有权使用用户的注册信息、用户名、密码等信息，登录进入用户的注册账户，进行证据保全，包括但不限于公证、见证等。</strong></p><h5> 第4条 用户依法言行义务</h5><p> 本协议依据国家相关法律法规规章制定，用户同意严格遵守以下义务：</p><p><strong>（1）</strong>不得传输或发表：煽动抗拒、破坏宪法和法律、行政法规实施的言论，煽动颠覆国家政权，推翻社会主义制度的言论，煽动分裂国家、破坏国家统一的的言论，煽动民族仇恨、民族歧视、破坏民族团结的言论；</p><p><strong>（2）</strong>从中国大陆向境外传输资料信息时必须符合中国有关法规；</p><p><strong>（3）</strong>不得利用本站从事洗钱、窃取商业秘密、窃取个人信息等违法犯罪活动； </p><p><strong>（4）</strong>不得干扰本站的正常运转，不得侵入本站及国家计算机信息系统；</p><p><strong>（5）</strong>不得传输或发表任何违法犯罪的、骚扰性的、中伤他人的、辱骂性的、恐吓性的、伤害性的、庸俗的，淫秽的、不文明的等信息资料；</p><p><strong>（6）</strong>不得传输或发表损害国家社会公共利益和涉及国家安全的信息资料或言论；</p><p><strong>（7）</strong>不得教唆他人从事本条所禁止的行为；</p></div>"
	layer.open({
		type: 1,
		title:'雅堂用户招商协议',
		skin: 'layui-layer-rim', //加上边框
		area: ['750px', '466px'], //宽高
		content: str
	});*/
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