
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

act=function(obj){
 	var options={};
		options.current=obj;
		options.width=obj.width();
		options.len=obj.find(".box").length;
		options.index=0;
		options.btnContext="";
 	var slideObj={
	init:function(obj){
		var btn = '<div class="hd_gunda_bottom btn" style=" overflow:hidden;width:1200px">';
		for(var i=0; i < options.len; i++) {
			btn += '<div class="hd_gunda_bottom_kuai"  style=" overflow:hidden; width:398px"><a href="#" class="zhu46">'+options.current.find(".box:eq("+i+")").attr("data")+'</a></div>';
		}
		btn += "</div>";
		options.btnContext=btn;
		obj.after(options.btnContext);
		this.css();
		this.event();
		slideObj.options=options;
	},
	css:function(){
		options.current.find(".btnBg").css("opacity",0.5);
		options.current.find(".slide").css("width",options.width * (options.len));
		options.current.find(".preNext").css("top",(options.current.height()-options.current.find(".preNext").height())/2+"px");
	}
	,
	event:function(){
		$(".hd_gunda_bottom.btn div").css("opacity",0.4).mouseover(function() {
			options.index = $(".hd_gunda_bottom.btn div").index(this);
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
		options.current.find(".slide").stop(true,false).animate({"left":nowLeft},300); //通过animate()调整ul元素滚动到计算出的position
		$(".hd_gunda_bottom.btn div").removeClass("on").eq(index).addClass("on"); //为当前的按钮切换到选中的效果
		$(".hd_gunda_bottom.btn div").stop(true,false).animate({"opacity":"1"},300).eq(index).stop(true,false).animate({"opacity":"1"},300); //为当前的按钮切换到选中的效果 
	}
	}
	slideObj.init(obj);
	
}