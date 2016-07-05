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

function inputKey(name,url,key,val){
	var curSel={
		'url':'',
		'key':'',
		'val':'',
		'init':function(name,url,key,val){
				curSel.name=name;
				curSel.url=url;
				curSel.key=key;
				curSel.val=val;
				if($("#boxpro").length==0){
					var   div='<div id="boxpro" class="position" style="display:none;width:350px;position:absolute;z-index:300;height:600px;overflow-y:auto;overflow-x:hidden;background-color:#ffffff;padding:5px;border:#cccccc solid 2px;"></div>';
					$(window.document.body).append(div);
				}
				name.unbind("click").click(function(){
					curSel.click();
				}).unbind("keyup").keyup(function(){
					curSel.keyup();
				});
				
			},
		'name':'',
		'keyup':function(){
			$("#boxpro").empty();
			$("#boxpro").append("<img src='../img/loading.gif' /><br/>数据加载中...");
			$("#boxpro").css("top",curSel.name.offset().top+25);
			$("#boxpro").css("left",curSel.name.offset().left);
			$("#boxpro").css("display","");
			curSel.resultAjax(url,"name="+curSel.name.val()+"&i="+Math.random(),"json");
		},
		'click':function(){
			$("#boxpro").empty();
			$("#boxpro").append("<img src='../img/loading.gif' /><br/>数据加载中...");
			$("#boxpro").css("top",curSel.name.offset().top+25);
			$("#boxpro").css("left",curSel.name.offset().left);
			$("#boxpro").css("display","");
			curSel.resultAjax(url,"name="+curSel.name.val()+"&i="+Math.random(),"json");
		},
		'resultAjax':function(url,data,type){
			$.ajax({
			  type: 'POST',
			  url: url,
			  data: data,
			  dataType: type,
			  success: function(data){
			  		curSel.userResult(data);
			  },
			  error:function(XMLHttpRequest, textStatus, errorThrown){
			  	alert("服务器内部错误!"+textStatus);
			  }
			})
		},
		'userResult':function(data){
			$("#boxpro").empty();
			$("#boxpro").css("display","");
			for(var i=0;i<data.length;i++){
				var bg="";
				if(i%2>0)
					bg="background-color:#939393;";
				$("#boxpro").append("<div class='linePro' id='"+data[i][curSel.val]+"' style='width:350px;height:30px;line-height:30px;"+bg+"'>"+(i+1)+"|"+data[i][curSel.key]+"</div>");
			
			}
			curSel.addUserlisterentLinePro();
		},
		'addUserlisterentLinePro':function(){
			$(".linePro").click(function(){
				$("#boxpro").css("display","none");
				$("#"+curSel.name.attr("mappendBy")).val(this.id);
				var name=$(this).text();
				curSel.name.val(name.substring(name.indexOf("|")+1));
			});
			}
	}
	curSel.init(name,url,key,val);
}