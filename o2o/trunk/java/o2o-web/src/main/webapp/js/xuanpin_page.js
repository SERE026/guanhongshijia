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

xuanGoods=function(path,pageSize,modelId,goodsBox,objClass,objhClass,boxClass,miaoClass,toClass,goClass,moneyClass,more){
	var page={
		servicePath:"",
		pageNo:1,
		pageSize:2,
		more:"",
		objClass:"",
		objhClass:"",
		boxClass:"",
		miaoClass:"",
		toClass:"",
		moneyClass:"",
		modelId:"",
		goodsBox:"",//图片样式
		goClass:"",//文字样式
		init:function(path,pageSize,modelId,goodsBox,objClass,objhClass,boxClass,miaoClass,toClass,goClass,moneyClass,more){
			page.servicePath=path;
			page.pageSize=pageSize;
			page.more=more;
			page.objClass=objClass;
			page.objhClass=objhClass;
			page.boxClass=boxClass;
			page.miaoClass=miaoClass;
			page.toClass=toClass;
			page.moneyClass=moneyClass;
			page.modelId=modelId;
			page.goodsBox=goodsBox;
			page.goClass=goClass;
			page.ajaxGoods();
			page.event();
		},
		event:function(){
			$("."+page.objClass).unbind(".mouseover").unbind(".mouseout").mouseover(function(){
				$(this).attr("class",page.objhClass);
			}).mouseout(function(){
				$(this).attr("class",page.objClass);
			});
			$(page.more).unbind("click").click(function(){
				page.ajaxGoods();
			});
		},
		ajaxGoods:function(){
			$.ajax({
			  type: 'POST',
			  url: page.servicePath+"/widget.html",
			  data: "widget=xuangoodsWidget&id="+page.modelId+"&dataType=json&pageSize="+page.pageSize+"&pageNo="+page.pageNo+"&i="+Math.random(),
			  dataType: "json",
			  error: function(XMLHttpRequest, textStatus, errorThrown) {
                //  alert(XMLHttpRequest.status);
                  //alert(XMLHttpRequest.readyState);
                  //alert(textStatus);
              },
			  success: function(data){
			  		page.pageNo++;
			  		if(data.page.totalpage<page.pageNo){
			  			$(page.more).css("display","none");
			  		}
			  		for(var i=0;i<data.data.length;i++){
			  			var html='<div class="'+page.objClass+'">';
			  			html+='<div class="'+page.boxClass+'"><a href="item-'+data.data[i].goods_id+'.html"><img src="'+page.servicePath+'/upload/goods/'+data.data[i].defaultImage+'" width="100%" height="100%" border="0" /></a></div>';
			  			html+='<div class="'+page.miaoClass+'">';
			  			// 如果商品打折，显示打几折，否则不显示
			  			if(data.data[i].discount < 10) {
			  				html+='<span class="STYLE1">'+data.data[i].discount+'折 </span>';
			  			}	
			  			html+='<a href="#" class="zhu8">'+data.data[i].name+'</a></div>';
			  			html+='<div class="'+page.toClass+'"><div class="'+page.moneyClass+'">';
			  			// 如果商品售价小于原价，显示为删除线样式，否则显示为会员价
			  			if (data.data[i].salesMoney < data.data[i].bazaarMoney) {
							html+='<span class="STYLE2">¥</span><span class="STYLE3">'+data.data[i].salesMoney.toFixed(1)+'</span>&nbsp;&nbsp;<span class="STYLE4">¥'+data.data[i].bazaarMoney.toFixed(1)+'</span>';			  			
			  			} else {
			  				html+='<span class="STYLE2">¥</span><span class="STYLE3">'+data.data[i].salesMoney.toFixed(1)+'</span>&nbsp;&nbsp;<span>会员价</span>';
			  			}
			  			
			  			html+='</div><div class="'+page.goClass+'"><a href="item-'+data.data[i].goods_id+'.html"><img src="'+page.servicePath+'/img/an1.gif" border="0" /></a></div>';
			  			html+='</div></div>';
			  			$(page.goodsBox).append(html);
			  		}
			  		page.event();
			  }
			});
		}
	};
	$(function(){
		page.init(path,pageSize,modelId,goodsBox,objClass,objhClass,boxClass,miaoClass,toClass,goClass,moneyClass,more);
	});
	
};