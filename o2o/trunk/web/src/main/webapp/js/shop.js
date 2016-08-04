
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
		Object:"",
		init:function(obj,box,widget){//初始化
			_page.Object="GOOD";
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
			_page.createPostData();
			_page.sortEvent();
			
		},
		sortEvent:function(){
			$(".shop_sort").click(function(){
				$(".shop_sort.select").removeClass("select");
				$(this).addClass("select");
				_page.pageNo=1;
				_page.goPage=1;
				_page.createPostData();
			})
			$(".goodBtn").click(function(){
				_page.Object="ACTGOOD";
				_page.createPostData();
				$(".btnText").html("活动商品");
			});
			$(".btnAll").click(function(){
				_page.Object="GOOD";
				_page.createPostData();
				$(".btnText").html("全部商品");
			})
			$(".colseBtn").click(function(){
				$(this).parent().parent().css("visibility","hidden");
			});
		},
		createPostData:function(){
			var data="&Object="+_page.Object+"&spId="+_page.currentObj.attr("spId");
			if($(".shop_sort.select").length==1){
				data+="&SortId="+$(".shop_sort.select").attr("rt");
			}
			_page.data=data;
			_page.getDataTotal();
		},
		getDataTotal:function(){
			$.ajax({
				  type: 'POST',
				  url: _page.pageUrl,
				  data: "action=dataTotal&dataType=json&result=NUM"+_page.data,
				  dataType: "json",
				  success: function(data){
				  		_page.total=data.total;
				  		_page.totalPage=_page.total/_page.pageSize;
				  		if((_page.total%_page.pageSize/_page.pageSize)<0.5&&_page.total%_page.pageSize>0){
				  			_page.totalPage=Math.round(_page.totalPage)+1;
				  		}else{
				  			_page.totalPage=Math.round(_page.totalPage);
				  		}
				  		
				  		_page.goTo();
				  		_page.creatHtml();
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
					var txtx = $(this).html();
					_page.goPage=parseInt($(this).html());
					_page.goTo();
					// 完成分页数据载入后，将页面平滑滚动至刚好显示“全部商品”栏位的位置
					$("html, body").animate({scrollTop:578}, "fast"); 
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
			  data: "action=data&pageNo="+_page.goPage+"&result=data&pageSize="+_page.pageSize+"&dataType=json"+_page.data,
			  dataType: "json",
			  success: function(data){
			  		var html="";
			  		for(var i=0;i<data.length;i++){
			  			html+='<div class="right_box_aa">';
			  			html+='<div class="right_box_aa_img"><a href="'+servicePath+'/item-'+data[i].goodId+'.html"><img src="'+servicePath+'/upload/goods/'+data[i].image+'" border="0"  width="100%" height="100%"/></a></div>';
			  			html+='<div class="right_box_aa_tit"><a href="'+servicePath+'/item-'+data[i].goodId+'.html" class="zhu9">'+data[i].goodName+'</a></div>';
			  			html+='<div class="right_box_aa_price"><a href="'+servicePath+'/item-'+data[i].goodId+'.html" class="zhu37">¥'+parseFloat(data[i].money).toFixed(2)+' </a></div>';
			  			html+='<div class="right_box_aa_an">';
			  			html+='<div class="right_box_aa_an_ka"><a href="javascript:;" class="addCars" dataValue="'+data[i].goodId+'"><img src="'+servicePath+'/img/dianpu_35.gif" border="0" /></a></div>';
			  			html+='<div class="right_box_aa_an_kb"><a href="javascript:;" class="addFav" g_id="'+data[i].goodId+'"><img src="'+servicePath+'/img/dianpu_37.gif" border="0" /></a></div>';
			  			html+='</div></div>';
			  		}
			  		_page.htmlBox.html(html);
			  		_page.pageNo=_page.goPage;
			  		_page.creatHtml();
			  		_page.goodEvent();
			  		carSevent();
			  		favorEvent();
			  },
			  error:function(e){
			alert(e);
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
	carSevent();
	favorEvent();
}