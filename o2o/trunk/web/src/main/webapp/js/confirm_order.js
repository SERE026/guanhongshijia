
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
	
    $(".chooseAddress").click(function(){
    	showToAdd();
    })
	function showToAdd(){
		$(".toAddress").html($("input[name='receiveId']:checked").attr("data_value"));
	}
	$(".shop").each(function(){
		new shop($(this));
	
	});
	$(".saveAddress").click(function(){
		new addSite();
		
	});
	$(".memj").blur(function(){
		if($(".memj").val().length>0){
				$.ajax({
					  type: 'POST',
					  url: servicePath+"/widget.html",
					  data: "widget=confirmOrder&action=checkPoint&dataType=json&point="+$(".memj").val(),
					  dataType: "json",
					   cache:false,
					  success: function(data){
					  		if(data.status==1){
					  			$(".jfbg").css("display","");
					  			$(".syjf").html("你当前拥有"+data.m_j+"个积分");
					  			$(".memj").focus();
					  		}else{
					  			$(".jfbg").css("display","none");
					  		}
					  }
				});
			}
	});
	$(".toAddress").html($("input[name='receiveId']:checked").attr("data_value"));
	address("provinceId","cityId","countyId",servicePath+"/widget.html?widget=confirmOrder&action=getArea&dataType=json");
	$(".create").click(function(){
		new createOrder();
	})
	
	
})  
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
				  data: "widget=confirmOrder&action=addAddress&dataType=html"+postData,
				  dataType: "html",
				  success: function(data){
				  		$(".selectaddress").after(data);
				  		$(".shop").each(function(){
							new shop($(this));
						});
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

function createOrder(){
	var _order={
		point:false,
		valid:function(){//检查订单元素
			var valid=true;
			$(".shop").each(function(){
				if($(this).attr("dly")=="no"){
					valid=false;
					_order.tip("你选择的地区有商品不能到达！");
				}
			});
			if(!valid){
				return valid;
			}
				
				if($("input[name='dlyType']:checked").length==0){
					_order.tip("请选择配送方式！");
					valid=false;
					return valid;
				}
				if($("input[name='playType']:checked").length==0){
					_order.tip("请选择支付方式！");
					valid=false;
					return valid;
				}
				if($("input[name='dlyType']:checked").val()=="1"){
					if($("input[name='receiveId']:checked").length==0){
						valid=false;
						_order.tip("请添加收货地址！");
						return valid;
					}
					if($("input[name='receiveDate']:checked").length==0){
						_order.tip("请选择收货时间！");
						valid=false;
						return valid;
					}
				}
				
			return valid;
		},
		tip:function(data){
			$(".g2_biaobot_zi").html(data);
		},
		getPoint:function(){
			_order.point=true;
			if($(".memj").val().length>0){
				$.ajax({
					  type: 'POST',
					  url: servicePath+"/widget.html",
					  data: "widget=confirmOrder&action=checkPoint&dataType=json&point="+$(".memj").val(),
					  dataType: "json",
					  cache:false,
					  success: function(data){
					  		if(data.status==1){
					  			$(".jfbg").css("display","");
					  			$(".syjf").html("你当前拥有"+data.m_j+"个积分");
					  			$(".memj").focus();
					  			_order.point=false;
					  		}else{
					  			$(".jfbg").css("display","none");
					  			_order.point=true;
					  		}
					  }
				});
			}
			if(_order.point){
				_order.create();
			}
		},
		create:function(){
			if(_order.valid()){
				var postData="&receiveId="+$("input[name='receiveId']:checked").val();
					postData+="&dlyType="+$("input[name='dlyType']:checked").val();
					if($("input[name='account']:checked").length>0)
						postData+="&account="+$("input[name='account']:checked").val();
						
					postData+="&playType="+$("input[name='playType']:checked").val();
					
					
					postData+="&receiveDate="+$("input[name='receiveDate']:checked").val();
					postData+="&o_i="+Math.random();
					postData+="&p="+$(".memj").val();
					
					
					
				$(".shop").each(function(){
					var shop=$(this).attr("s_id");
					if($("input[name='dlyType']:checked").val()=="1"){
						if($(this).find(".y_").attr("status")=="yes"){
							shop+="="+$(this).find(".y_").val();
						}
					}
					$("."+$(this).attr("mappend")).each(function(){
						shop+="="+$(this).attr("g_id");
					});
					
					postData+="&shop="+shop;
					
				})
				$(".makes").css("display","");
				$.ajax({
				  type: 'POST',
				  url: servicePath+"/widget.html",
				  data: "widget=confirmOrder&action=create&dataType=json"+postData,
				  dataType: "json",
				  cache:false,
				  success: function(data){
				  		if(data.create){
				  			var zffs=$("input[name='playType']:checked").val();
				  			var account=$("input[name='account']:checked").val();
				  			if($("input[name='account']:checked")==0){
				  				account="1";
				  			}
				  			
				  			window.location.href=servicePath+"/orderplay-"+data.tradeNo+".html?zffs="+zffs+"&account="+account;
				  		}else{
				  			_order.tip("订单创建失败！可能购买的商品库存数量不足！");
				  			$(".makes").css("display","none");
				  		}
				  }
				});
			}
		}
	}
	_order.getPoint();
}

function shop(obj){
	var _shop={
		shop:null,
		init:function(obj){//初始化
			$("input:[name='dlyType']").click(function(){
				if(this.value=="1"){
					$(".deliveryL").html("快递");
					_shop.distribution();
				}else if(this.value=="0"){
					$(".deliveryL").html("我要自己提货");
					$("."+_shop.shop.attr("distribution")).find(".y_").empty();
					$("."+_shop.shop.attr("distribution")).find(".y_").html("<option>上门提货</option>");
					_shop.shop.find(".y_m").html("0.00");
					$("."+_shop.shop.attr("distribution")).find(".y_money").html("0.00");
					_shop.shop.attr("dly","yes");
					$(".toAddress").html("");
					var money=0.0;
					_shop.shop.find(".s_money").each(function(){
						money+=parseFloat($(this).html());
					});
					_shop.shop.find(".z_m").html(money.toFixed(2));
					
					money=0;
					$(".z_m").each(function(){
						money+=parseFloat($(this).html());
					});
					$(".orderMoney").html("应付总额：¥"+money.toFixed(2));
				}
			});
			_shop.shop=obj;
			$(".y_").change(function(){
				_shop.distributionMoney();
			});
			$("input[name='receiveId']").click(function(){
			
				$(".toAddress").html($(this).attr("data_value"));
				_shop.distribution();
			})
			_shop.distribution();
			var s_money=0.0;
			_shop.shop.find(".g_money").each(function(){
				s_money+=parseFloat($(this).html());
			});
			
			_shop.shop.find(".s_money").html(s_money);
			
			_shop.shop.find(".y_").change(function(){
				_shop.distributionMoney();
			});
			
		},
		getPoin:function(){//检查积分 memj
			
		},
		tatol:function(){//算费用
			window.loadi = layer.load(0);
			$(document.body).append("<div zzhao style='width:100%;height:100%;z-index:99999;position:fixed;left:0;top:0;'></div>");
			
			var postData="&area_id="+$("input[name='receiveId']:checked").val();
			$("."+_shop.shop.attr("mappend")).each(function(){
				postData+="&s_d="+$(this).attr("g_id");
			});
			if(_shop.shop.find(".y_").attr("status")=="yes"){
				postData+="&dly_id="+_shop.shop.find(".y_").val();
			}
			postData+="&o_i="+Math.random();
			$.ajax({
				  type: 'POST',
				  url: servicePath+"/html/confirm/getShopPrice",
				  data: "widget=confirmOrder&action=getShopPrice&dataType=json"+postData,
				  dataType: "json",
				   cache:false,
				  success: function(data){
				  		var dlyprice=0.0;
				  		_shop.shop.find(".s_money").html((data.goodPrice-data.actPrice).toFixed(2));
				  		if($("input[name='dlyType']:checked").val()=="1"){//需要费用
					  		if($("."+_shop.shop.attr("distribution")).find(".y_").attr("status")=="no"){
					  			_shop.shop.find(".y_m").html("--");
					  		}else{
					  			dlyprice=parseFloat(data.dlyprice);
					  			_shop.shop.find(".y_m").html(dlyprice.toFixed(2));
					  			
					  		}
				  		}
				  		if($("input[name='dlyType']:checked").val()=="0"){
				  			dlyprice=0.0;
				  		}
				  		_shop.shop.find(".z_m").html((data.goodPrice-data.actPrice+dlyprice).toFixed(2));
				  		var orderMoney=0.0;
				  		$(".z_m").each(function(){
				  			orderMoney+=parseFloat($(this).html());
				  		});
				  		
				  		$(".orderMoney").html("应付总额：¥"+orderMoney.toFixed(2));
				  	layer.close(window.loadi);
				  		$("[zzhao]").remove();
				  }
			});
		},
		distribution:function(){//配送方式
			if($("input[name='dlyType']:checked").val()=="1"){//需要配送方式
				var postData="&area_id="+$("input[name='receiveId']:checked").val();
				$("."+_shop.shop.attr("mappend")).each(function(){
					postData+="&s_d="+$(this).attr("g_id");
				});
				postData+="&o_i="+Math.round(Math.random()*1000);
				$.ajax({
					  type: 'POST',
					  url: servicePath+"/html/confirm/distribution",
					  data: "widget=confirmOrder&action=distribution&dataType=json"+postData,
					  dataType: "json",
					  cache:false,
					  success: function(data){
					  		$("."+_shop.shop.attr("distribution")).find(".y_").empty();
					  		if(data.status=="0"){
					  			for(var i=0;i<data.data.length;i++){
					  				_shop.shop.find(".y_").append("<option value='"+data.data[i].dlytype_id+"'>"+data.data[i].dlyname+"</option>");
					  			}
					  			_shop.shop.find(".y_").attr("status","yes");
					  			_shop.distributionMoney();
					  			_shop.shop.attr("dly","yes");
					  			
					  		}else if(data.status=="1"){//不支持配送地区
					  			_shop.shop.find(".y_").html("<option>选择地区不支持配送</option>");
					  			_shop.shop.find(".y_").attr("status","no");
					  			_shop.shop.find(".y_m").html("---");
					  			_shop.shop.find(".y_money").html("---");
					  			_shop.shop.attr("dly","no");
					  		}else if(data.status=="2"){//包邮
					  			_shop.shop.find(".y_").html("<option>包邮</option>");
					  			_shop.shop.find(".y_").attr("status","no");
					  			_shop.shop.find(".y_money").html("0");
					  			_shop.shop.find(".y_m").html("0.00");
					  			_shop.shop.attr("dly","yes");
					  			
					  		}else if(data.status=="3"){//直接给配送费
					  			_shop.shop.find(".y_").html("<option>配送费</option>");
					  			_shop.shop.find(".y_").attr("status","no");
					  			_shop.shop.find(".y_money").html(pasrFloat(data.money).toFixed(2));
					  			_shop.shop.find(".y_m").html(pasrFloat(data.money).toFixed(2));
					  			_shop.shop.attr("dly","yes");
					  		}
					  		_shop.tatol();
					  }
				});
			}else{
				$("."+_shop.shop.attr("distribution")).find(".y_").empty();
				$("."+_shop.shop.attr("distribution")).find(".y_").html("<option>上门提货</option>");
				_shop.shop.find(".y_m").html("0.00");
				$("."+_shop.shop.attr("distribution")).find(".y_money").html("0.00");
				_shop.shop.attr("dly","yes");
				
				var money=0.0;
				$(".g_money").each(function(){
					money+=parseFloat($(this).html());
				});
				
				$(".orderMoney").html("应付总额：¥"+money.toFixed(2));
			}
			
		},
		distributionMoney:function(){
			var postData="&area_id="+$("input[name='receiveId']:checked").val();
				postData+="&dly_id="+_shop.shop.find(".y_").val();
			$("."+_shop.shop.attr("mappend")).each(function(){
				postData+="&s_d="+$(this).attr("g_id");
			});
			postData+="&o_i="+Math.random();
			$.ajax({
				  type: 'POST',
				  url: servicePath+"/widget.html",
				  data: "widget=confirmOrder&action=distributionMeony&dataType=json"+postData,
				  dataType: "json",
				   cache:false,
				  success: function(data){
				  		if($("input[name='dlyType']:checked").val()=="1"){//需要费用
				  			_shop.shop.find(".y_money").html(data.money);
				  		}
				  		
				  }
			});
		}
	}
	_shop.init(obj);
}