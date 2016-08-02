
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

    //默认选中并算总价
    var che = $(".carSelect").attr("checked");
    if(che === true){
    	carStat();
    }
    
	// 直接购买
	$(".addBuy").click(function(){
		addBuy();
		return;
	});
	// 添加到购物车
	$(".addCars").click(function(){
		addCars();
	});
	carEvent();
});

/*********************************************************
* 调整购买数量
*********************************************************/
$(function() {
	var buySpan = $("#buyNum");
	var kucunNumber = $("#kucunNum").text();// 取库存数量
	$("#jia").mousedown(function() {
		var buyNumber = parseInt(buySpan.text());
		if (buyNumber < kucunNumber) {
			buyNumber += 1;
			buySpan.text(buyNumber);
		}
	});
	$("#jian").mousedown(function() {
		var buyNumber = parseInt(buySpan.text());
		if (buyNumber > 1) {
			buyNumber -= 1;
			buySpan.text(buyNumber);
		}
	});
});


function carEvent(){
	$(".carSelectAll").click(function(){
		if(this.checked){
			$(".carSelect").attr("checked",true);
		}else{
			$(".carSelect").attr("checked",false);
		}
		$(".carSelectAll").attr("checked",this.checked);
		carStat();
	});
	$(".carSelect").click(function(){
		carStat();
	});
	$(".subNum").click(function(){
		var num=parseInt($(this).next().html());
		if(num>1)
			num--;
		$(this).next().html(num);
		var price=parseFloat($(this).parent().parent().parent().find("td:eq(4) span").html());
		$(this).parent().parent().parent().find("td:eq(6) span").html((price*num).toFixed(2));
		carStat();
		
	})
	$(".addNum").click(function(){
		var num=parseInt($(this).prev().html());
		var inventory=parseInt($(this).attr("attint"));
		if(num<inventory){
			num++;
			$(this).prev().html(num);
			var price=parseFloat($(this).parent().parent().parent().find("td:eq(4) span").html());
			$(this).parent().parent().parent().find("td:eq(6) span").html((price*num).toFixed(2));
			carStat();
		}else{
			alert("对不起！您选择的数据已超出了库存！");
		}
	})
	$(".delCar").click(function(){
		var data="";
		$(".carSelect:checked").each(function(){
			data+="&carInfo="+$(this).attr("dataId")+":"+$(this).attr("specVal")+":"+$(this).attr("dataType")+":"+$(this).attr("actInfo");
		});
		new delCars(data);
	});
	$(".delCarItem").click(function(){
		var data="";
		data+="&carInfo="+$(this).attr("dataId")+":"+$(this).attr("specVal")+":"+$(this).attr("dataType")+":"+$(this).attr("actInfo");
		new delCars(data);
	})
	$(".addFavorites").click(function(){
		var data="";
		data+="&carInfo="+$(this).attr("dataId")+":"+$(this).attr("specVal")+":"+$(this).attr("dataType")+":"+$(this).attr("actInfo")+":"+$(this).attr("g_id");
		new addFavorites(data);
	})
	$(".addFavoritesAll").click(function(){
		var data="";
		$(".carSelect:checked").each(function(){
			data+="&carInfo="+$(this).attr("dataId")+":"+$(this).attr("specVal")+":"+$(this).attr("dataType")+":"+$(this).attr("actInfo")+":"+$(this).attr("g_id");
		});
		new addFavorites(data);
	})
	$(".confirm").click(function(){
		if($(".carSelect:checked").length>0){
			new carConfirm();
		}
	})
}


function carConfirm(){
	_Confirm={
		checkLogin:function(){
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=checkLogin&dataType=json&forword=cars.html",
			  dataType: "json",
			  success: function(data){
			  		_Confirm.checkData(data);
			  }
			});
		},
		checkData:function(data){
			if(data.status==0){
				var form = $('<form  action="confirmorder.html" method="POST" name="form" id="form1" ></form>');	
				$(".carSelect:checked").each(function(){
					var emelent=$('<input type="hidden" name="carInfo" value="'+""+$(this).attr("dataId")+":"+$(this).attr("specVal")+":"+$(this).attr("dataType")+":"+$(this).attr("actInfo")+":"+$(this).parent().parent().find("td .g1_jiajian_shu").html()+'" />');
					form.append(emelent);
				});
				$(window.document.body).append(form);
				if($(".carSelect:checked").length>0){
					$("#form1").submit();
				}
			}else{
				window.location.href=servicePath+"/login.html";
			}
		}
	}
	_Confirm.checkLogin();
	
}

function carStat(){
	$(".selectGoodNum").html($(".carSelect:checked").length);
	var money=0.0;
	$(".carSelect:checked").each(function(){
		money+=parseFloat($(this).parent().parent().find("td:eq(6) span").html());
	})
	var re=/\d{1,3}(?=(\d{3})+$)/g;
	money=money.toFixed(2)
	var n1=money.replace(/^(\d+)((\.\d+)?)$/,function(s,s1,s2){return s1.replace(re,"$&,")+s2;});
	$(".selectGoodMoney").html("¥"+n1);
	
}
//添加到收藏夹
function addFavorites(data){
	var _car={
		data:"",
		add:function(data){
			_car.data="widget=carsWidget&dataType=json&action=addFavorites"+data;
			_car.startAjax();
		},
		startAjax:function(){
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: _car.data,
			  dataType: "json",
			  success: function(data){
			  		_car.resultAjax(data);
			  }
			});
		},
		resultAjax:function(data){
			if(data.status=="0"){
				window.location.href=servicePath+"/cars.html";
			}else{
				window.location.href=servicePath+"/"+data.toPage;
			}
		}
		
	}
	_car.add(data);
}
//删除
function delCars(data){
	var _car={
		data:"",
		del:function(data){
			_car.data="widget=carsWidget&dataType=json&action=del"+data;
			_car.startAjax();
		},
		startAjax:function(){
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: _car.data,
			  dataType: "json",
			  success: function(data){
			  		_car.resultAjax(data);
			  }
			});
		},
		resultAjax:function(data){
			if(data.status=="0"){
				window.location.href=servicePath+"/cars.html";
			}
		}
		
	}
	_car.del(data);
}

// 添加到购物车
function addCars(){
	var _car={
		data:"",
		add:function(){
			var product_id = $(".addCars").attr("dataValue");
			var isSubmit=true;
			var specData="&1=1";
			$(".goodsAttr").each(function(){
				var dataType=$(this).attr("dataType");
				var dataVlaue="";
				if(dataType=="Image"){
					var data_value=$(this).find(".attImageBtn.spdetail_right_gr_kk_right_d").attr("data-value");
					if(data_value){
						dataVlaue=data_value.split(":")[2];
					}
				}else if(dataType=="Text"){
					var data_value=$(this).find(".attTextBtn.sp_xinghao").attr("data-value");
					if(data_value){
						dataVlaue=data_value.split(":")[2];
					}
				}
				if(dataVlaue==""){
					isSubmit=false;
					$(this).css("border","#e0e0e0 solid 1px");
				}else{
					specData+="&spec="+dataVlaue;
				}
			})
			if(isSubmit){
				_car.data="widget=carsWidget&dataType=json&n=1&action=add&g_id="+product_id+specData+"&i="+Math.random();
				_car.startAjax();
			}
			
		},
		startAjax:function(){
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: _car.data,
			  dataType: "json",
			  success: function(data){
			  		_car.resultAjax(data);
			  }
			});
		},
		resultAjax:function(data){
			if(data.status=="0"){
				window.location.href=servicePath+"/cars.html";
			}
		}
		
	}
	_car.add();
}



// 直接购买
function addBuy(){
	var buyNumber = $("#buyNum").text();// 取购买数量
	var _car={
		data:"",
		add:function(){
			var product_id = $(".addBuy").attr("dataValue");
			var isSubmit=true;
			var specData="&1=1";
			$(".goodsAttr").each(function(){
				var dataType=$(this).attr("dataType");
				var dataVlaue="";
				if(dataType=="Image"){
					var data_value=$(this).find(".attImageBtn.spdetail_right_gr_kk_right_d").attr("data-value");
					if(data_value){
						dataVlaue=data_value.split(":")[2];
					}
				}else if(dataType=="Text"){
					var data_value=$(this).find(".attTextBtn.sp_xinghao").attr("data-value");
					if(data_value){
						dataVlaue=data_value.split(":")[2];
					}
				}
				if(dataVlaue==""){
					isSubmit=false;
					$(this).css("border","#e0e0e0 solid 1px");
				}else{
					specData+="&spec="+dataVlaue;
				}
			})
			if(isSubmit){
				_car.data="widget=carsWidget&dataType=json&n=1&action=Buyadd&g_id="+product_id+specData+"&i="+Math.random();
				_car.checkLogin();
			}
			
		},
		
		// 检查是否登录
		checkLogin:function(){
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=checkLogin&dataType=json&forword=cars.html",
			  dataType: "json",
			  // AJAX返回时在这里处理（data.status==0 表示已登录）
			  success: function(data){
			  		if(data.status==0){
			  			//alert("（详情页面）已登录，开始提交");
			  			$.ajax({
			  			type: 'POST',
						  url: servicePath+"/widget.html",
			 			 data: _car.data,
						  dataType: "json",
			 			 success: function(data){
			  					//alert("（详情页面）已返回，在这里处理");
			  					if(data.status==1){
			  						var form = $('<form  action="confirmorder.html" method="POST" name="form" id="form1" ></form>');	
									var emelent=$('<input type="hidden" name="carInfo" value="'+data.dataId+":"+data.specVal+":"+data.dataType+":"+data.actInfo+":" + buyNumber + '" />');
									form.append(emelent);
									$(window.document.body).append(form);
									$("#form1").submit();
								}
							 }
						});
			  		} else {
			  			//alert("（详情页面）未登录，转到登录页面！");
			  			window.location.href=servicePath+"/login.html";
			  		}
			  }
			});
		
		
		
		
		}
		
	}
	_car.add();
}
