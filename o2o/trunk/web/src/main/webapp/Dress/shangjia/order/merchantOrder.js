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

/*
	商品排序页面JS

*/


$(function(){
	$(".addGoods").click(function(){
		$.layer({
		    type : 2,
		    title : '选择商家',
		    iframe : {src : servicePath+'/html/manage/merchantOrder/merchant/list?merchant_order_id='+$("input[name='merchant_order_id']").val()},
		    area : ['750px' , '466px'],
		    offset : ['100px','']
		});
	});
	$(".updateGoodsIndex").unbind("click").click(function(){
		var len=$(".goodsInput").length;
		for(var i=0;i<len;i++){
			$(".goodsInput").eq(i).parent().parent().find("td:eq(3) input").val(i+1);
		}
	})
	$(".delIndex").click(function(){
		resultAjax($(this).attr("delUrl"),"i="+Math.random(),delData,"json");
		$(this).addClass("select");
	})
	
	
})
function delData(data){
	if(data.status==0){
		$(".select.delIndex").parent().parent().remove();
	}
}
function colseLayr(){
	$(".xubox_layer").remove();
	$(".xubox_shade").remove();
	window.location.reload();
}
function addGoos(id,name,merchantsId,merchantsName){
		if($("#goods"+id).length==0){
			var html="<tr>";
				html+='<td>'+name;
				html+='<input type="hidden" value="'+id+'" name="goods_id" id="goods'+id+'"/></td>';
				html+="<td>"+merchantsId+"</td>";
				html+="<td>"+merchantsName+"</td>";
				html+='<td><input type="text" name="goods_index" value="'+($(".goodsInput").length+1)+'" /></td>';
				html+='<td><a href="javascript:;" class="delIndex">删除</a></td>';
			$(".goodsBox").append(html);
			IndexEvent();
		}
}

IndexEvent=function(){
	
	$(".delIndex").unbind("click").click(function(){
		$(this).parent().parent().remove();
	});
	
	$(".goodsInput").unbind("click").click(function(){
		$(".goodsSelect").removeClass("goodsSelect");
		$(this).addClass("goodsSelect");
		$.layer({
		    type : 2,
		    title : '选择商品',
		    iframe : {src : servicePath+'/html/manage/goodsOrder/goods/list'},
		    area : ['750px' , '466px'],
		    offset : ['100px','']
		});

	});
	
	
}