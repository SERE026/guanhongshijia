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
	index;
});
index=function(path){
	var page={
		servicePath:"",
		pageNo:2,
		init:function(path){
			
			page.servicePath=path;
			page.event();
		},
		event:function(){
			$(".index_left_kuai").unbind(".mouseover").unbind(".mouseout").mouseover(function(){
				$(this).attr("class","index_left_kuai_dian");
			}).mouseout(function(){
				$(this).attr("class","index_left_kuai");
			});
			$(".addGoods").unbind("click").click(function(){
				page.ajaxGoods();
			});
		},
		ajaxGoods:function(){
			$.ajax({
			  type: 'POST',
			  url: page.servicePath+"/widget.html",
			  data: "widget=good_group&dataType=json&pageSize=12&pageNo="+page.pageNo+"&i="+Math.random(),
			  dataType: "json",
			  error: function(XMLHttpRequest, textStatus, errorThrown) {
                 // alert(XMLHttpRequest.status);
                //  alert(XMLHttpRequest.readyState);
                 // alert(textStatus);
              },
			  success: function(data){
			  		page.pageNo++;
			  		if(data.page.totalpage<page.pageNo){
			  			$(".addGoods").css("display","none");
			  		}
			  		for(var i=0;i<data.data.length;i++){
			  			var html='<div class="index_left_kuai">';
			  			html+='<div class="index_left_kuai_tu"><a href="item-'+data.data[i].goods_id+'.html"><img src="'+page.servicePath+'/upload/goods/'+data.data[i].defaultImage+'" width="100%" height="100%" border="0" /></a></div>';
			  			html+='<div class="index_left_kuai_zi">';
			  			// 如果商品打折，显示打几折，否则不显示
			  			if(data.data[i].discount < 10) {
			  				html+='<span class="STYLE1">'+data.data[i].discount+'折 </span>';
			  			}	
			  			html+='<a href="#" class="zhu8">'+data.data[i].name+'</a></div>';
			  			html+='<div class="index_left_dajia"><div class="index_left_dajia_le">';
			  			// 如果商品售价小于原价，显示为删除线样式，否则显示为会员价
			  			if (data.data[i].salesMoney < data.data[i].bazaarMoney) {
							html+='<span class="STYLE2">¥</span><span class="STYLE3">'+data.data[i].salesMoney.toFixed(1)+'</span>&nbsp;&nbsp;<span class="STYLE4">¥'+data.data[i].bazaarMoney.toFixed(1)+'</span>';			  			
			  			} else {
			  				html+='<span class="STYLE2">¥</span><span class="STYLE3">'+data.data[i].salesMoney.toFixed(1)+'</span>&nbsp;&nbsp;<span>会员价</span>';
			  			}
			  			
			  			html+='</div><div class="index_left_dajia_ri"><a href="item-'+data.data[i].goods_id+'.html"><img src="'+page.servicePath+'/img/an1.gif" border="0" /></a></div>';
			  			html+='</div></div>';
			  			$(".goodsBox").append(html);
			  		}
			  		page.event();
			  }
			});
		}
	};
	$(function(){
		page.init(path);
	});
	
};