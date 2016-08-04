
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

page=function(obj,box){
	var _page={
		currentObj:null,
		pageNo:1,
		pageSize:5,
		pageUrl:"",
		total:0,
		totalPage:0,
		htmlBox:null,
		goPage:1,
		init:function(obj,box){//初始化
			_page.currentObj=obj;
			_page.htmlBox=box;
			_page.pageNo=parseInt(obj.attr("pageNo"));
			_page.pageSize=parseInt(obj.attr("pageSize"));
			_page.pageUrl=obj.attr("pageUrl");
			_page.total=parseInt(obj.attr("total"));
			_page.totalPage=_page.total/_page.pageSize;
			if(_page.totalPage*_page.pageSize<_page.total){
				_page.totalPage++;
			}
			if(_page.total%_page.pageSize/_page.pageSize<0.5&&_page.totalPage>0){
	  			_page.totalPage=Math.round(_page.totalPage)+1;
	  		}else{
	  			_page.totalPage=Math.round(_page.totalPage);
	  		}
			_page.creatHtml();
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
				if(_page.pageNo==i){
					_html+='<div class="fenye_shu">'+i+'</div>';
				}else{
					_html+='<div class="fenye_shu"><a href="javascript:;" class="zhu19 PageBtn">'+i+'</a></div>';
					
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
			})
		},
		goTo:function(){
			
			$.ajax({
			  type: 'POST',
			  url: _page.pageUrl,
			  data: "pageNo="+_page.goPage+"&dataType=html",
			  dataType: "html",
			  success: function(data){
			  		htmlBox.html(data);
			  		_page.pageNo=goPage;
			  		_page.creatHtml();
			  }
			});
		}
	}
	_page.init(obj,box);
}