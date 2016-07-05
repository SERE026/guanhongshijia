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

page=function(obj,box,widget){
	var _page={
		currentObj:null,
		pageNo:1,
		pageSize:30,
		pageUrl:"",
		total:0,
		totalPage:0,
		htmlBox:null,
		goPage:1,
		widget:"",
		specHeight:10,
		data:"",
		u_id:"",
		init:function(obj,box,widget){//初始化
			_page.currentObj=obj;
			_page.htmlBox=box;
			_page.widget=widget;
			_page.pageNo=1;
			_page.pageSize=30;
			_page.pageUrl=servicePath+"/widget.html?widget="+widget;
			_page.total=0;
			_page.totalPage=_page.total/_page.pageSize;
			if(_page.totalPage*_page.pageSize<_page.total){
				_page.totalPage++;
			}
			_page.creatHtml();
			_page.orderEvent();
			_page.createPostData();
			
		},
		createPostData:function(){
			var data="";
			if($(".select.orderBy").length>0){
				data+="&order="+$(".select.orderBy").attr("order")+"&by="+$(".select.orderBy").attr("by");
			}
			if($(".bbs_title").length>0){
				data+="&id="+$(".bbs_title").attr("data");
			}
			if(_page.u_id.length>0){
				data+="&u_d="+_page.u_id;
			}
			_page.data=data;
			_page.getDataTotal();
		},
		orderEvent:function(){
			$(".orderBy").click(function(){
				var order=$(this).attr("order");
				if(order=="default"){
					
					$(".orderBy.select").find("a").attr("class","zhu15")
					$(".orderBy.select").removeClass("select");
				}else {
					$(".orderBy.select").find("a").attr("class","zhu15")
					$(".orderBy.select").removeClass("select");
					$(this).addClass("select");
					var by=$(this).attr("by");
					if(by==""){
						$(this).attr("by","desc")
						$(this).find("a").attr("class","zhu16")
						
					}else if(by=="desc"){
						$(this).attr("by","asc")
						$(this).find("a").attr("class","zhu17")
					}else if(by=="asc"){
						$(this).attr("by","desc")
						$(this).find("a").attr("class","zhu16")
					}
				}
				_page.createPostData();
			});
			
		},
		getDataTotal:function(){
			$.ajax({
				  type: 'POST',
				  url: _page.pageUrl,
				  data: "action=total&dataType=json"+_page.data+"&i="+Math.random(),
				  dataType: "json",
				  success: function(data){
				  		_page.total=data.total;
				  		_page.totalPage=_page.total/_page.pageSize;
				  		if(_page.total%_page.pageSize/_page.pageSize<0.5&&_page.totalPage>0){
				  			_page.totalPage=Math.round(_page.totalPage)+1;
				  		}else{
				  			_page.totalPage=Math.round(_page.totalPage);
				  		}
				  		_page.goPage=1;
				  		_page.goTo();
				  }
				});
		},
		creatHtml:function(){
			var _html='<div class="fenye_shanxia priv"><a href="javascript:;" class="zhu19">上一页</a></div>';
			var page=_page.pageNo;
			if(page>2){
				page-=2;
			}else if(page>1){
				page-=1;
			}
			var endPage=page+5;;
			if(endPage>_page.totalPage){
				endPage=_page.totalPage;
			}
			
			for(var i=page;i<=endPage&&i<=_page.totalPage;i++){
				if(_page.pageNo!=i){
					_html+='<div class="fenye_shu"><a href="javascript:;" class="zhu19 pageBtn">'+i+'</a></div>';
				}else{
					_html+='<div class="fenye_shu">'+i+'</div>';
				}
			}
			if(endPage<_page.totalPage){
				_html+='<div class="fenye_diandian">...</div>';
			}
			_html+='<div class="fenye_shanxia next"><a href="javascript:;" class="zhu19">下一页</a></div>';
			_html+='<div class="fenye_yeshu">共'+_page.totalPage+'页</div>';
			_html+='<div class="fenye_qu">去第</div>';
			_html+='<div class="fenye_tiaok gotoUrl"><input name="" type="text" class="fenye_tiaok_shu"/></div>';
			_html+='<div class="fenye_qu">页</div>';
			_html+='<div class="fenye_go gotoUrlBtn"><a href="javascript:;"><img src="img/sp_list_31.gif" border="0" /></a></div>';
			_page.currentObj.html(_html);
		},
		goTo:function(){
			$.ajax({
			  type: 'POST',
			  url: _page.pageUrl,
			  data: "action=data&pageNo="+_page.goPage+"&pageSize="+_page.pageSize+"&dataType=html"+_page.data+"&i="+Math.random(),
			  dataType: "html",
			  success: function(data){
			  		_page.htmlBox.html(data);
			  		_page.pageNo=_page.goPage;
			  		_page.creatHtml();
			  		_page.afterEvent();
			  }
			});
		},
		afterEvent:function(){
			$(".font").click(function(){
				$("."+$(this).attr("mappend")).css("font-size",$(this).attr("size")+"px");
				
			})
			$(".showZ").click(function(){
				_page.u_id=$(".bbs_title").attr("u_id");
				_page.createPostData();
			})
		}
	}
	_page.init(obj,box,widget);
	
}
$(function(){
	checkLogin();
})

function checkLogin(){
	sendData();
	$(".login").click(function(){
		var left=($(window).width()-$(".loginBox").width())/2;
		var top=($(window).height()-$(".loginBox").height())/2;
		$(".loginBox").css("left",left);
		$(".loginBox").css("top",top);
		$(".loginBox").css("display","");
	})
	
	$(".loginBox .close").click(function(){
		$(".loginBox").css("display","none");
	})
	$(".loginBox .u_n").keyup(function(){
		$(".loginBox .u_nmsg").css("display","none");
	})
	$(".loginBox .u_p").keyup(function(){
		$(".loginBox .u_pmsg").css("display","none");
	})
	$(".sendTile").focus(function(){
		if($(this).val()=="请输入标题"){
			$(this).val("");
		}
		$(".sendTile").css("color","");
	}).blur(function(){
		if($(this).val()==""){
			$(this).val("请输入标题");
		}
	});
	$(".loginBox .ok").click(function(){
		if($(".loginBox .u_n").val().length<6){
			$(".loginBox .u_nmsg").html("用户名不正确！");
			$(".loginBox .u_nmsg").css("display","");
			return ;
		}
		if($(".loginBox .u_p").val().length<6){
			$(".loginBox .u_pmsg").html("密码不正确！");
			$(".loginBox .u_pmsg").css("display","");
			return ;
		}
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html?widget=bbsSendWidget&action=login"+"&i="+Math.random(),
			  data: "u_n="+$(".loginBox .u_n").val()+"&u_p="+$(".loginBox .u_p").val(),
			  dataType: "json",
			  success: function(data){
			  	if(data.status==0){
			  		addKe();
			  		$(".loginBox").remove();
			  	}else{
			  		$(".loginBox .u_pmsg").html("登录失败，请检查用户名密码！");
			  	}
			  }
			});
		
	})
}

function sendData(){
	
	$(".sendBtn").click(function(){
		if($(".sendTile").val()=="请输入标题"){
			$(".sendTile").css("color","#ff0000");
			return ;
		}
		window.edit.sync('context');
		var data="context="+$("#context").val();
		
		if($(".bbs_title").length>0){
			data+="&b_id="+$(".bbs_title").attr("data")+"&widget=bbsWidget&action=add";
		}else{
			if($(".sendTile").val().length==0){
				$(".sendTile").css("border","#ff0000 solid 1px;");
				return ;
			}else{
				data+="&title="+$(".sendTile").val()+"&widget=bbsWidget&action=sendadd";
			}
		}
		
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: data+"&i="+Math.random(),
			  dataType: "json",
			  success: function(data){
			  	if(data.status==0){
			  		$(".sendTile").val("");
			  		$("#context").val("");
			  		window.location.reload();
			  	}
			  }
			});
	});
	
}

function addKe(){
	var html='<div class="xuaya_huifu_kuang" >';
	html+='<textarea id="context" name="content" style="width:100%;height:150px;"></textarea>';
	html+='</div>';
	html+='<div class="xuanyan2_an2 sendBtn"><a href="javascript:;">';
	if($(".sendTile").length==0){
		html+='<img src="'+servicePath+'/img/luntan_25.gif" border="0" />';
	}else{
		html+='<img src="'+servicePath+'/img/fatie_an.gif" border="0" />';
	}
	html+='</a></div>';
	$(".sendBox").html(html);
/*	KE.init({id : 'context',
			items:["source","bold","textcolor","image","link","emoticons"],
			imageUploadJson:servicePath+'/kindeditor/plugins/file.jsp'
	});*/
		window.edit=KindEditor.create('textarea[name="content"]', {
			allowFileManager : true,
			items:["source","bold","textcolor","image","link","emoticons"],
			uploadJson:'kindeditor4/jsp/upload_json.jsp'
		})
	$(".xuaya_huifu_kuang").css("background-image","");
   /* KE.create('context');*/
    sendData();
	
}
