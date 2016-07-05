
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

// 百度地图API功能
var map = new BMap.Map("map");
map.centerAndZoom(cityName,11); 
map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件

$(function(){
	new shop();
	$(".m_name").click(function(){
		if($(this).val()=="请输入商家名称"){
			$(this).val("");
		}
	}).blur(function(){
		if($(this).val()==""){
			$(this).val("请输入商家名称");
		}
	});
})


shop=function(){
	var getShop={
		data:"",
		markerList:null,
		MsgList:null,
		init:function(){
			getShop.event();
			getShop.markerList=new Array();
			getShop.createData();
			getShop.MsgList=new Array();
		},
		createData:function(){
		    var data="";
		        data+="&cityName="+cityName;
		        if($("#provinceId").val().length>0){
			      data="&provinceId="+$("#provinceId").val();
			    }
			    if($("#cityId").val().length>0){
				    data+="&cityId="+$("#cityId").val();
				}
				if($("#countyId").val().length>0){
				    data+="&countyId="+$("#countyId").val();
				}
				getShop.data=data;
				getShop.get();
				
				
		},
		event:function(){
				$("#provinceId").change(function(){
					getShop.createData();
					
				});
				$("#cityId").change(function(){
					getShop.createData();
					map.centerAndZoom($("#cityId option:selected").text(),10); 
				});
				$("#countyId").change(function(){
					getShop.createData();
					map.centerAndZoom($("#countyId option:selected").text(),11); 
				});
				$(".btn").click(function(){
					getShop.createData()
				});
				$(".dbtn").click(function(){
					getShop.getByName()
				});
				
				
		},
		getByName:function(){
			var m_n=$("#m_name").val();
			if(m_n=="请输入商家名称"){
				m_n="";
			}
			
			$.ajax({
				  type: 'POST',
				  url: servicePath+"/widget.html?widget=merchantWidget&action=getMerchant&dataType=json",
				  data: "action=dataTotal&dataType=json&name="+m_n,
				  dataType: "json",
				  success: function(data){
					  	for(var j=0;j<getShop.markerList.length;j++){
					  		map.removeOverlay(getShop.markerList[j]);
					  	}
				  		for(var i=0;i<data.length;i++){
				  			var point = new BMap.Point(data[i].m_lo,data[i].m_la);
                            var marker = new BMap.Marker(point);
                            
                            getShop.MsgList.push(data[i].m_n+"  <br/><br/>地址："+data[i].m_a+"<br/><br/><a href='shop-"+data[i].m_id+".html'>进入店铺</a>");
                            marker.addEventListener("mouseover",  function(){
                                var msg="";
                                for(var i=0;i<getShop.markerList.length;i++){
                                 if(this==getShop.markerList[i]){
                                     msg=getShop.MsgList[i];
                                 }
                                }
                                //创建信息窗口
                                var infoWindow1 = new BMap.InfoWindow(msg);
                                this.openInfoWindow(infoWindow1,point);
                            
                            });
                            map.addOverlay(marker);
                            getShop.markerList.push(marker);
				  		}
				  		if(data.length==1){
				  			var point = new BMap.Point(data[0].m_lo,data[0].m_la);
				  			map.centerAndZoom(point,15); 
				  		}
				  }
				});
		},
		get:function(){
			$.ajax({
				  type: 'POST',
				  url: servicePath+"/widget.html?widget=merchantWidget&action=getMerchant&dataType=json",
				  data: "dataType=json"+getShop.data,
				  dataType: "json",
				  success: function(data){
				  		for(var j=0;j<getShop.markerList.length;j++){
					  		map.removeOverlay(getShop.markerList[j]);
					  	}
					  	getShop.markerList=new Array();
					  	getShop.MsgList=new Array();
				  		for(var i=0;i<data.length;i++){
				  			var point = new BMap.Point(data[i].m_lo,data[i].m_la);
				  			var marker = new BMap.Marker(point);
  							
							getShop.MsgList.push(data[i].m_n+"  <br/><br/>地址："+data[i].m_a+"<br/><br/><a href='shop-"+data[i].m_id+".html' style='color:red'>进入店铺</a>");
							marker.addEventListener("mouseover",  function(){
							    var msg="";
							    for(var i=0;i<getShop.markerList.length;i++){
							     if(this==getShop.markerList[i]){
							         msg=getShop.MsgList[i];
							     }
							    }
							    //创建信息窗口
							    var infoWindow1 = new BMap.InfoWindow(msg);
							    this.openInfoWindow(infoWindow1,point);
							
							});
				  		    map.addOverlay(marker);
                            getShop.markerList.push(marker);
				  		}
				  		
				  }
				});
		}
	}
	getShop.init();
}

function showMsg(a,point){
   
}