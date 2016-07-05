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

address=function(provinceId,cityId,countyId,url){
	var addCtl={
		init:function(provinceId,cityId,countyId,url){
			this.provinceId=provinceId;
			this.cityId=cityId;
			this.countyId=countyId;
			this.url=url;
			addCtl.event();
			
		},
		provinceId:"",
		cityId:"",
		countyId:"",
		url:"",
		event:function(){
			$("#"+provinceId).change(function(){
				addCtl.cityAjax(addCtl.url,"parentId="+$("#"+provinceId).val()+"&i="+Math.random(),"json");
			});
			$("#"+cityId).change(function(){
				addCtl.countyAjax(addCtl.url,"parentId="+$("#"+cityId).val()+"&i="+Math.random(),"json");
			});
			addCtl.provinceAjax(addCtl.url,"parentId=&i="+Math.random(),"json");
		},
		provinceAjax:function(url,data,type){
			$.ajax({
			  type: 'POST',
			  url: url,
			  data: data,
			  dataType: type,
			  success: function(data){
			  		addCtl.provinceResult(data);
			  },
			  error:function(XMLHttpRequest, textStatus, errorThrown){
			  	alert("服务器内部错误!"+textStatus);
			  }
			})
		},
		provinceResult:function(data){
			$("#"+provinceId).empty();
			for(var i=0;i<data.length;i++){
				$("#"+provinceId).append("<option value='"+data[i].id+"' "+($("#"+provinceId).attr("dataVal")==data[i].id?"selected":"")+">"+data[i].name+"</option>");
			}
			addCtl.cityAjax(addCtl.url,"parentId="+$("#"+provinceId).val()+"&i="+Math.random(),"json");
		},
		cityAjax:function(url,data,type){
			$.ajax({
			  type: 'POST',
			  url: url,
			  data: data,
			  dataType: type,
			  success: function(data){
			  		addCtl.cityResult(data);
			  },
			  error:function(XMLHttpRequest, textStatus, errorThrown){
			  	alert("服务器内部错误!"+textStatus);
			  }
			})
		},
		cityResult:function(data){
			$("#"+cityId).empty();
			for(var i=0;i<data.length;i++){
				$("#"+cityId).append("<option value='"+data[i].id+"' "+($("#"+cityId).attr("dataVal")==data[i].id?"selected":"")+">"+data[i].name+"</option>");
			}
			addCtl.countyAjax(addCtl.url,"parentId="+$("#"+cityId).val()+"&i="+Math.random(),"json");
		},
		countyAjax:function(url,data,type){
			$.ajax({
			  type: 'POST',
			  url: url,
			  data: data,
			  dataType: type,
			  success: function(data){
			  		addCtl.countyResult(data);
			  },
			  error:function(XMLHttpRequest, textStatus, errorThrown){
			  	alert("服务器内部错误!"+textStatus);
			  }
			})
		},
		countyResult:function(data){
			$("#"+countyId).empty();
			for(var i=0;i<data.length;i++){
				$("#"+countyId).append("<option value='"+data[i].id+"' "+($("#"+countyId).attr("dataVal")==data[i].id?"selected":"")+">"+data[i].name+"</option>");
			}
		}
	}
	addCtl.init(provinceId,cityId,countyId,url);
}