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

function goodsImagebox(obj){
	var box={
		index:0,
		current:null,
		init:function(obj){
			box.current=obj;
			box.event();
		},
		event:function(){
			box.current.find(".left").click(function(){
				if(box.index<box.current.find(".imgMin").length-3){
					box.current.find(".imgMin").eq(box.index).css("display","none");
					box.current.find(".imgMin").eq(box.index+3).css("display","");
					box.index++;
					var maxImg=box.current.find(".imgMin").eq(box.index).find("img").attr("src");
					box.current.find(".maxBox img").attr("src",maxImg);
					box.current.find(".spdetail_left_xiaotu_k").removeClass("spdetail_left_xiaotu_k").addClass("spdetail_left_xiaotu_k2");
					box.current.find(".imgMin").eq(box.index).addClass("spdetail_left_xiaotu_k").removeClass("spdetail_left_xiaotu_k2");
				}
			});
			box.current.find(".right").click(function(){
				if(box.index>0){
					box.current.find(".imgMin").eq(box.index-1).css("display","");
					box.current.find(".imgMin").eq(box.index+2).css("display","none");
					box.index--;
					var maxImg=box.current.find(".imgMin").eq(box.index).find("img").attr("src").replace("min","");
					box.current.find(".maxBox img").attr("src",maxImg);
					box.current.find(".spdetail_left_xiaotu_k").removeClass("spdetail_left_xiaotu_k").addClass("spdetail_left_xiaotu_k2");
					box.current.find(".imgMin").eq(box.index).addClass("spdetail_left_xiaotu_k").removeClass("spdetail_left_xiaotu_k2");
					
				
				}
			});
			box.current.find(".imgMin").click(function(){
				box.current.find(".spdetail_left_xiaotu_k").removeClass("spdetail_left_xiaotu_k").addClass("spdetail_left_xiaotu_k2");
				$(this).addClass("spdetail_left_xiaotu_k").removeClass("spdetail_left_xiaotu_k2");
				var maxImg=$(this).find("img").attr("src").replace("min","");
					box.current.find(".maxBox img").attr("src",maxImg);
			});
		}
	}
	box.init(obj);
}
$(function(){
	new goodsImagebox($(".goodsImagebox"));
	$("div.maxBox").jqueryzoom();
});
