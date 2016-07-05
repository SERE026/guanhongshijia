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
	添加商品
*/


$(function(){
	$(".addGoods").click(function(){
		$.layer({
		    type : 2,
		    title : '选择商品',
		    iframe : {src : servicePath+'/html/manage/aadv/goods/list?aadv_id='+$("[aadv_id]").val()},
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
		$(this).parent().parent().css({"text-decoration":"line-through","color":"#ff0000"});
		//$(this).parent().parent().remove();
	})
	
	$("[selectGoods]").click(function(){
		if(this.checked){
			$(".deleteType").attr("checked","true")
			$(".deleteType").parent().parent().css({"text-decoration":"line-through","color":"#ff0000"});
			$(".deleteType").next().remove();
		}else{
			$(".deleteType").removeAttr("checked")
			$(".deleteType").parent().parent().css({"text-decoration":"","color":""});
			$(".deleteType").each(function(){
			var html='<input type="hidden"   value="'+$(this).val()+'" name="goods_id"  id="goods'+$(this).val()+'"/>';
			$(this).parent().append(html);
			});
		}
	});
	IndexEvent();

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
function addGoos(id,name,sortName,money){
		if($("#goods"+id).length==0){
			var html="<tr>";
				html+='<td><input type="checkbox" class="deleteType" value="'+id+'" /><input type="hidden"   value="'+id+'" name="goods_id"  id="goods'+id+'"/></td>';
				html+='<td>'+name+'</td>';
				html+="<td>"+sortName+"</td>";
				html+='<td><input type="text" name="orderIndex" value="'+($("input[name='goods_id']").length+1)+'" /></td>';
				html+="<td>"+money+"</td>";
				//html+='<td><a href="javascript:;" class="delIndex">删除</a></td>';
			$(".goodsBox").append(html);
			IndexEvent();
		}
}

IndexEvent=function(){

	$(".deleteType").unbind("click").click(function(){
			if($(this).attr("checked")==true){
				$(this).parent().parent().css({"text-decoration":"line-through","color":"#ff0000"});
				$("#goods"+$(this).val()).remove();
			}else{
				$(this).parent().parent().css({"text-decoration":"","color":""});
				var html='<input type="hidden"   value="'+$(this).val()+'" name="goods_id"  id="goods'+$(this).val()+'"/>';
				$(this).parent().append(html);
			}
	});
	
	$(".delIndex").unbind("click").click(function(){
		$(this).parent().parent().remove();
	});
	
	$(".goodsInput").unbind("click").click(function(){
		$(".goodsSelect").removeClass("goodsSelect");
		$(this).addClass("goodsSelect");
		$.layer({
		    type : 2,
		    title : '选择商品',
		    iframe : {src : servicePath+'/html/manage/goodsOrder/goods/list?aadv_id='+$("[aadv_id]").val()},
		    area : ['750px' , '466px'],
		    offset : ['100px','']
		});

	});
	
	
}