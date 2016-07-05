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
	$(".addSpec").click(function(){
		var html="<tr>";
		html+='<td ><input type="text" name="specName" value="" class="noNull" msg="属性名称不能为空！"/></td>';
  		html+='<td >';
  		html+='<select name="specFlag">';
    	html+='<option value="0" selected>选择项</option>';
    	html+='<option value="1">输入项</option>';
    	html+='</select>';		
    	html+='</td>';
    	html+='<td ><input type="text" name="specVal" value="" />&nbsp;多值以,分隔</td>';	
    	html+='<td ><a href="javascript:;" class="delSpec" style="color:#ff0000">删除</a></td>';	
    	html+='</tr>';
    	
    
		
		$("#specBox").append(html);
		delSpec();
	})
	
	$("input:radio:[name='linkBrank']").click(function(){
		if(this.value==1){
			$("#brandTr").css("display","");
		}else{
			$("#brandTr").css("display","none");
		}
	})
	
	$("input:radio:[name='ownSpec']").click(function(){
		if(this.value==1){
			$("#specTr").css("display","");
		}else{
			$("#specTr").css("display","none");
		}
	})
})

function delSpec(){
	$(".delSpec").unbind("click").click(function(){
		$(this).parent().parent().remove();
	});
}