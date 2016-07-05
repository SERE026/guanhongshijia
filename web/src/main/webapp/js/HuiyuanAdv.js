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

$(function (){
	$("#left").click(function(){
		cout--;
		if(cout<1){
			alert("已经在最左边了！");
			cout++;
		}else{
			goleft(cout);
		}
	});
	
$("#right").click(function(){
	if($(".xiazhan_xiak").length<4){
		alert("已经到最右边了！");
	}else{
		cout++;
		goright(cout);
		}
	});
	
});

function  goleft(num){
	$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=huiyuanAdv&left="+num,
			  dataType: "html",
			  success: function(data){
			  	$(".xiazhan_kuai").html(data)
				}
			});	
}

function  goright(num){

$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=huiyuanAdv&right="+num,
			  dataType: "html",
			  success: function(data){
				$(".xiazhan_kuai").html(data)
				}
			});	

}