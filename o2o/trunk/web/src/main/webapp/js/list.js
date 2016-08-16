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
			//window.location.href=servicePath+"/GoodList-"+$(this).attr("att")+".html";
		}
	})

})
page=function(obj,box,widget){
	address("provinceId","cityId","countyId",servicePath+"/widget.html?widget=ArearWidget&action=getArea&dataType=json");
	var _page={
		currentObj:null,
		pageNo:1,
		pageSize:28,
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
			_page.pageSize=28;
			_page.pageUrl=servicePath+"/widget.html?widget="+widget;
			_page.total=0;
			_page.totalPage=_page.total/_page.pageSize;
			if(_page.totalPage*_page.pageSize<_page.total){
				_page.totalPage++;
			}
			_page.creatHtml();
			_page.sepecEvent();
			_page.addressEvent();
			_page.createPostData();
			
		},
		createPostData:function(){
			var data="";
			if($(".select.brand").length>0){
				data+="&brand="+$(".select.brand").attr("data");
			}
			$(".select.parameter").each(function(){
				data+="&parameter="+$(this).attr("item")+":"+$(this).find(".sp_xiaokxuan").text();
			});
			//if($(".select.priceRange").length>0){
				//data+="&priceRange="+$(".select.priceRange").find(".sp_xiaokxuan").text();
			//}
			
			if($("#price1").val()!=""){
				data+="&price1="+$("#price1").val();
			}
			if($("#price2").val()!=""){
				data+="&price2="+$("#price2").val();
			}
			var order=$(".orderBy.select").attr("data");
			if(order=="price"){
				data+="&orderName=price";
				data+="&by="+$(".orderBy.select").attr("by");
			}
			data+="&goodSort="+$(".select.goodSort").attr("goodSortID");
			if($("#countyId").val().length>0){
				data+="&countyId="+$("#countyId").val();
			}
			if($("#cityId").val().length>0){
				data+="&cityId="+$("#cityId").val();
			}
			if($("#provinceId").val().length>0){
				data+="&provinceId="+$("#provinceId").val();
			}
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
		sepecEvent:function(){
			$(".specHidBtn").click(function(){
				_page.specHeight=$(".specBox").height();
				$(".specBox").animate({"height":"0"},800);
				$(".specShowBtn").css("display","");
				$(this).css("display","none");
				window.setTimeout("sepecHidden()",900);
			});
			$(".specShowBtn").click(function(){
				$(".specBox").css("display","");
				$(".specHidBtn").css("display","");
				$(".specBox").animate({"height":_page.specHeight},1000);
				$(this).css("display","none");
			});
			$(".parameterVal").click(function(){
				if($(".select.parameter"+$(this).parent().attr("parameteritem")).length==0){
					var html='<div  item="'+$(this).parent().attr("parameteritem")+'" class="sp_shaixuan_yixuan_bb select parameter parameter'+$(this).parent().attr("parameteritem")+'">';
						html+='<div class="sp_xiaokxuan">'+$(this).find("a").text()+'</div>';
						html+='<div class="sp_xiaokxuan_guan delSelect" ><a href="javascript:;" ><img src="'+servicePath+'/img/sp_xiaoguan.gif" border="0" /></a></div>';
						html+='</div>';
					$(".selectBox").append(html);
				}else{
					$(".select.parameter"+$(this).parent().attr("parameteritem")).find(".sp_xiaokxuan").html($(this).find("a").text());
				}
				_page.createPostData();
				_page.specDel();
			});
			$(".brand").click(function(){
				if($(".select.brand").length==0){
					var html='<div  data="'+$(this).attr("dava")+'" class="sp_shaixuan_yixuan_bb select brand">';
						html+='<div class="sp_xiaokxuan">'+$(this).find("a").text()+'</div>';
						html+='<div class="sp_xiaokxuan_guan delSelect" ><a href="javascript:;" ><img src="'+servicePath+'/img/sp_xiaoguan.gif" border="0" /></a></div>';
						html+='</div>';
					$(".selectBox").append(html);
				}else{
					$(".select.brand").attr("data",$(this).attr("dava"));
					$(".select.brand").find(".sp_xiaokxuan").html($(this).find("a").text());
				}
				_page.createPostData();
				_page.specDel();
			})
			
			$("#pricesubmit").click(function(){
					var price1=$("#price1").val();
					var price2=$("#price2").val();
					if(price1==""&&price2==""){
						alert("价格区间不能全为空！");
					}else if (isNaN(price1)&&isNaN(price2)){
						alert("请在价格区间中输入数字！");
					}
					_page.createPostData();
				})
			$(".priceRange").click(function(){
				if($(".select.priceRange").length==0){
					var html='<div   class="sp_shaixuan_yixuan_bb select priceRange">';
						html+='<div class="sp_xiaokxuan">'+$(this).find("a").text()+'</div>';
						html+='<div class="sp_xiaokxuan_guan delSelect" ><a href="javascript:;" ><img src="'+servicePath+'/img/sp_xiaoguan.gif" border="0" /></a></div>';
						html+='</div>';
					$(".selectBox").append(html);
				}else{
					$(".select.priceRange").find(".sp_xiaokxuan").html($(this).find("a").text());
				}
				_page.createPostData();
				_page.specDel();
			})
			$(".orderBy").click(function(){
				var data=$(this).attr("data");
				if(data=="default"){
					$(".orderBy.select").removeClass("select");
					$(this).addClass("select");
					$(this).find("a").attr("class","zhu15")
				}else if("price"){
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
		specDel:function(){
			$(".delSelect").unbind("click").click(function(){
					$(this).parent().remove();
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
			_html+='<div class="fenye_go gotoUrlBtn"><a CLASS="mainBack" href="javascript:;">GO</a></div>';
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
			$(".goodBox").mouseover(function(){
				$(".xsp_kuai_dian").addClass("xsp_kuai").removeClass("xsp_kuai_dian");
				$(this).addClass("xsp_kuai_dian").removeClass("xsp_kuai");
			}).mouseout(function(){
				$(this).addClass("xsp_kuai").removeClass("xsp_kuai_dian");
			})
		}
	}
	_page.init(obj,box,widget);
	
}


function sepecHidden(){
	$(".specBox").css("display","none");
}


