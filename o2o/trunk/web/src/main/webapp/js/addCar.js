
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

// 直接购买
function carSevent(){
	$(".addCars").click(function(){
	
		// 取商品ID
		var data=$(this).attr("dataValue");
		var _car={
		data:"",
		// 添加数据
		add:function(){
			var product_id = data;
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
				//_car.startAjax();
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
			  			//alert("已登录，开始提交");
			  			$.ajax({
			  			type: 'POST',
						  url: servicePath+"/widget.html",
			 			 data: _car.data,
						  dataType: "json",
			 			 success: function(data){
			  					//alert("已返回，在这里处理");
			  					if(data.status==1){
			  					var form = $('<form  action="confirmorder.html" method="POST" name="form" id="form1" ></form>');	
								var emelent=$('<input type="hidden" name="carInfo" value="'+data.dataId+":"+data.specVal+":"+data.dataType+":"+data.actInfo+':1" />');
								form.append(emelent);
								$(window.document.body).append(form);
								$("#form1").submit();
							}
						 }
						});
			  		} else {
			  			//alert("未登录，转到登录页面！");
			  			window.location.href=servicePath+"/login.html";
			  		}
			  }
			});
		}
	}
	_car.add();	
	});
}

