
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

slide=function(obj,isBtn){
 	var options={};
		options.current=obj;
		options.width=obj.width();
		options.len=obj.find("ul li").length;
		options.index=0;
		options.isBtn=isBtn;
		options.btnContext="";
 	var slideObj={
	init:function(obj,isBtn){
		var btn = "<div class='btnBg'></div><div class='btn'>";
		for(var i=0; i < options.len; i++) {
			btn += "<span>&nbsp;</span>";
		}
		btn += "</div>"+(options.isBtn?"<div class='preNext pre'></div><div class='preNext next'></div>":"");
		options.btnContext=btn;
		obj.append(options.btnContext);
		this.css();
		this.event();
		slideObj.options=options;
	},
	css:function(){
		options.current.find(".btnBg").css("opacity",0.5);
		options.current.find("ul").css("width",options.width * (options.len));
		options.current.find(".preNext").css("top",(options.current.height()-options.current.find(".preNext").height())/2+"px");
	}
	,
	event:function(){
		options.current.find(".btn span").css("opacity",0.4).mouseover(function() {
			options.index = options.current.find(".btn span").index(this);
			slideObj.showPics(options.index);
			}).eq(0).trigger("mouseover"); 
		
		options.current.find(".preNext").css("opacity",0.2).hover(
			function() {
				$(this).stop(true,false).animate({"opacity":"0.5"},300);
			},
			function() {
				$(this).stop(true,false).animate({"opacity":"0.2"},300);
		}); 
		//上一页按钮
		options.current.find(".pre").click(function() {
			options.index -= 1;
			if(options.index == -1) {options.index = options.len - 1;}
			showPics(options.index);
		}); 
		//下一页按钮
		options.current.find(".next").click(function() {
			options.index += 1;
			if(options.index == len) {options.index = 0;}
			showPics(options.index);
		}); 
		options.current.hover(
			function() {
				clearInterval(options.picTimer);
			},
			function() {
				options.picTimer = setInterval(function() {
					slideObj.showPics(options.index);
					options.index++;
				if(options.index == options.len) {options.index = 0;}
				},4000); //此4000代表自动播放的间隔，单位：毫秒
			}).trigger("mouseleave"); 
	},
	showPics:function (index) { //普通切换 //显示图片函数，根据接收的index值显示相应的内容
		var nowLeft = -index*options.width; //根据index值计算ul元素的left值
		options.current.find("ul").stop(true,false).animate({"left":nowLeft},300); //通过animate()调整ul元素滚动到计算出的position
		options.current.find(".btn span").removeClass("on").eq(index).addClass("on"); //为当前的按钮切换到选中的效果
		options.current.find(".btn span").stop(true,false).animate({"opacity":0.4},300).eq(index).stop(true,false).animate({"opacity":1},300); //为当前的按钮切换到选中的效果 
	}
	}
	slideObj.init(obj,isBtn);
	
}