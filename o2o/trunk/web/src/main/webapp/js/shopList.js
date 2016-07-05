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
	$(".sortBox").click(function(){
		if($(this).attr("class").indexOf("select")>0){
			$(".sortBox.select").find("img").eq(0).attr("src",servicePath+"/img/sp_list_14.gif");
			$(".sortBox.select").next(".splist_kv").css("display","none");
			$(".sortBox.select").removeClass("select")
		}else{
			$(".sortBox.select").find("img").eq(0).attr("src",servicePath+"/img/sp_list_14.gif");
			$(".sortBox.select").next(".splist_kv").css("display","none");
			$(".sortBox.select").removeClass("select")
			$(this).addClass("select").find("img").eq(0).attr("src",servicePath+"/img/sp_list_07.gif");
			$(this).next(".splist_kv").css("display","");
		}
	})

})


page=function(obj,box,widget){
	address("provinceId","cityId","countyId",servicePath+"/widget.html?widget=ArearWidget&action=getArea&dataType=json");
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
			_page.addressEvent();
			_page.createPostData();
			
		},
		createPostData:function(){
			var data="";
			if($("#countyId").val().length>0){
				data+="&countyId="+$("#countyId").val();
			}
			if($("#cityId").val().length>0){
				data+="&cityId="+$("#cityId").val();
			}
			if($("#provinceId").val().length>0){
				data+="&provinceId="+$("#provinceId").val();
			}
			data+="&sortId="+$(".sortId").attr("data");
			
			_page.data=data;
			_page.getDataTotal();
		},
		addressEvent:function(){
		
			$("#provinceId").change(function(){
				_page.createPostData();
			});
			$("#cityId").change(function(){
				_page.createPostData();
			});
			$("#countyId").change(function(){
				_page.createPostData();
			});
		},
		getDataTotal:function(){
			$.ajax({
				  type: 'POST',
				  url: _page.pageUrl,
				  data: "action=dataTotal&dataType=json"+_page.data,
				  dataType: "json",
				  success: function(data){
				  		_page.total=data.total;
				  		_page.totalPage=_page.total/_page.pageSize;
				  		if(_page.total%_page.pageSize/_page.pageSize<0.5&&_page.totalPage>0){
				  			_page.totalPage=Math.round(_page.totalPage)+1;
				  		}else{
				  			_page.totalPage=Math.round(_page.totalPage);
				  		}
				  		
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
			_page.event();
		},
		event:function(){
			$(".priv").unbind("click").click(function(){
				if(_page.pageNo>1){
					_page.goPage=_page.pageNo-1;
					_page.goTo();
				}
			})
			$(".next").unbind("click").click(function(){
				if(_page.pageNo<_page.totalPage){
					_page.goPage=_page.pageNo+1;
					_page.goTo();
				}
			})
			$(".pageBtn").unbind("click").click(function(){
					_page.goPage=parseInt($(this).html());
					_page.goTo();
			})
			$(".gotoUrlBtn").unbind("click").click(function(){
				var page=$(".gotoUrl input").val();
				var p=/^[0-9]+$/;
				if(!p.test(page)){
					$(this).css("border","#dddddd solid 1px");
				}else{
					if(parseInt(page)>=1&&parseInt(page)<_page.totalPage){
						_page.goPage=parseInt(page);
						_page.goTo();
					}
				}
			});
			
		},
		goTo:function(){
			
			$.ajax({
			  type: 'POST',
			  url: _page.pageUrl,
			  data: "action=data&pageNo="+_page.goPage+"&pageSize="+_page.pageSize+"&dataType=html"+_page.data,
			  dataType: "html",
			  success: function(data){
			  		_page.htmlBox.html(data);
			  		_page.pageNo=_page.goPage;
			  		_page.creatHtml();
			  		_page.goodEvent();
			  }
			});
		},
		goodEvent:function(){
			$(".shop").mouseover(function(){
				$(".sjxsp_kuai_dian").addClass("sjxsp_kuai").removeClass("sjxsp_kuai_dian");
				$(this).addClass("sjxsp_kuai_dian").removeClass("sjxsp_kuai");
			}).mouseout(function(){
				$(this).addClass("sjxsp_kuai").removeClass("sjxsp_kuai_dian");
			})
		}
	}
	_page.init(obj,box,widget);
	
}


function sepecHidden(){
	$(".specBox").css("display","none");
}


