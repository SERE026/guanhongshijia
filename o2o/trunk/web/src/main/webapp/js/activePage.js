
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
		pageSize:32,
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
			_page.pageSize=32;
			_page.pageUrl=servicePath+"/widget.html?widget="+widget;
			_page.total=0;
			_page.totalPage=_page.total/_page.pageSize;
			if(_page.totalPage*_page.pageSize<_page.total){
				_page.totalPage++;
			}
			
			_page.event();
			_page.createPostData();
		},
		event:function(){
			
		},
		createPostData:function(){
			var data="";
			_page.data=data;
			_page.getDataTotal();
		},
		getDataTotal:function(){
			$.ajax({
				  type: 'POST',
				  url: _page.pageUrl,
				  data: "action=acttotal&dataType=json&result=NUM&pageSize="+_page.pageSize+_page.data+"&actId="+$("[actId]").attr("actId"),
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
					_html+='<div class="fenye_shu "><a href="javascript:;" class="zhu19 pageBtn">'+i+'</a></div>';
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
			/*
			
			
<!--正常效果-->


















			
			
			
			
			
			
			
			*/
			
			$.ajax({
			  type: 'POST',
			  url: _page.pageUrl,
			  data: "action=actdata&pageNo="+_page.goPage+"&result=data&pageSize="+_page.pageSize+"&dataType=json"+_page.data+"&actId="+$("[actId]").attr("actId"),
			  dataType: "json",
			  success: function(data){
			  		var html="";
			  		for(var i=0;i<data.length;i++){
			  			html+='<div class="hdindex_left_kuai">';
			  			html+='<div class="hdindex_left_kuai_tu"><a href="'+servicePath+'/active-'+data[i].actId+'-'+data[i].goodId+'.html"><img src="'+servicePath+'/upload/goods/'+data[i].image+'" width="100%" height="100%" border="0" /></a></div>';
			  			html+='<div class="hdindex_left_kuai_zi">';
			  			html+='<span class="STYLE1">'+(parseFloat(data[i].money)/parseFloat(data[i].xmoney)*10).toFixed(1)+'折/ </span>';
			  			html+='<a href="#" class="zhu8">'+data[i].goodName+'</a></div>';
			  			html+='<div class="hdindex_left_dajia">';
			  			html+='<div class="hdindex_left_dajia_le">';
			  			html+='<span class="STYLE2">¥</span><span class="STYLE3">'+data[i].money+'</span>&nbsp;&nbsp;<span class="STYLE4">¥'+data[i].xmoney+'</span>';
			  			html+='</div><div class="hdindex_left_dajia_ri"><a href="'+servicePath+'/active-'+data[i].actId+'-'+data[i].goodId+'.html" class="zhu33">去看看</a></div></div>';
			  			html+='<div class="hdindex_xianshi">';
			  			html+='<div class="hdindex_xianshi_time acttime2" time='+data[i].ctime+'>';
			  			var t=data[i].ctime.split(":");
			  			html+='<span class="STYLE21">'+t[0]+'</span>时<span class="STYLE21">'+t[1]+'</span>分<span class="STYLE21">'+t[2]+'</span>秒</div>';
			  			html+='<div class="hdindex_xianshi_yigou"><span class="STYLE28">'+data[i].xiaoliang+'</span>人已购买</div>';
			  			html+='</div></div>';
			  		}
			  		_page.htmlBox.html(html);
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
	
	window.setInterval("updateTime()",1000);
}

function updateTime(){
	$(".acttime2").each(function(){
		var time=$(this).attr("time").split(":");
		var h=parseInt(time[0]);
		var m=parseInt(time[1]);
		var s=parseInt(time[2]);
		s--;
		if(s==0){
			s=59;
			m--;
			if(m==0){
				m=59;
				h--;
				if(h<0){
					m=0;
					s=0;
				}
			}
		}
		$(this).find("span:eq(0)").html((h>9?h:"0"+h));
		$(this).find("span:eq(1)").html((m>9?m:"0"+m));
		$(this).find("span:eq(2)").html((s>9?s:"0"+s));
		
		time=(h>9?h:"0"+h)+":"+(m>9?m:"0"+m)+":"+(s>9?s:"0"+s);
		$(this).attr("time",time);
	});
	$(".acttime").each(function(){
		var time=$(this).html().split(":");
		var h=parseInt(time[0]);
		var m=parseInt(time[1]);
		var s=parseInt(time[2]);
		s--;
		if(s==0){
			s=59;
			m--;
			if(m==0){
				m=59;
				h--;
				if(h<0){
					m=0;
					s=0;
				}
			}
		}
		time=(h>9?h:"0"+h)+":"+(m>9?m:"0"+m)+":"+(s>9?s:"0"+s);
		$(this).html(time);
	});
}

