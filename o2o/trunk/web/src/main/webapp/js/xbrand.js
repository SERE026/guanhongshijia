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

xbrand=function(path){
	var page={
		servicePath:"",
		pageNo:1,
		init:function(path){
			
			page.servicePath=path;
			page.ajaxGoods();
			
		},
		event:function(){
			$(".hhk_r_k").unbind(".mouseover").unbind(".mouseout").mouseover(function(){
				$(this).attr("class","hhk_r_k_dian");
			}).mouseout(function(){
				$(this).attr("class","hhk_r_k");
			});
			$(".addBrand").unbind("click").click(function(){
				page.ajaxGoods();
			});
		},
		ajaxGoods:function(){
			$.ajax({
			  type: 'POST',
			  url: page.servicePath+"/widget.html",
			  data: "widget=xbrand&dataType=json&pageSize=11&pageNo="+page.pageNo+"&i="+Math.random(),
			  dataType: "json",
			  success: function(data){
			  		page.pageNo++;
			  		
			  		for(var i=0;i<data.data.length;i++){
			  			var html='<div class="sc_l_kuai">';
			  			html+='<a href="shop-'+data.data[i].sid+'.html"><img src="'+page.servicePath+'/upload/'+data.data[i].iamge+'" width="100%" height="100%" border="0" /></a>';
			  			html+='</div>';
			  			$(".addBrand").before(html);
			  		}
			  		page.event();
			  		if(data.page.totalpage<page.pageNo){
			  			$(".addBrand").css("display","none");
			  		}
			  }
			});
		}
	};
	$(function(){
		page.init(path);
	});
	
};