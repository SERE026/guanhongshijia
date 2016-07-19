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

function addCars(productid){

	var _car={
				data:"",
				add:function(productid){
					var isSubmit=true;
					var specData="&1=1";
					if(isSubmit){
						_car.data="widget=carsWidget&dataType=json&n=1&action=Shopadd&g_id="+productid+"&i="+Math.random();
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
	_car.add(productid);
}