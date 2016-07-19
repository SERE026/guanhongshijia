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

//**************************************************************
// jQZoom allows you to realize a small magnifier window,close
// to the image or images on your web page easily.
//
// jqZoom version 1.0
// Author Doc. Ing. Renzi Marco(www.mind-projects.it)
// Released on Dec 05 2007
// i'm searching for a job,pick me up!!!
// mail: renzi.mrc@gmail.com
//**************************************************************

(function($){

		$.fn.jqueryzoom = function(options){

		var settings = {
				xzoom: 300,		//zoomed width default width
				yzoom: 300,		//zoomed div default width
				offset: 10,		//zoomed div default offset
				position: "right"  //zoomed div default position,offset position is to the right of the image
			};

			if(options) {
				$.extend(settings, options);
			}

		$(this).hover(function(){
				if($(".maxBox img.jqzoom").parent().find(".jqZoomPup").length==0){
					$(".maxBox img.jqzoom").parent().append("<div class='jqZoomPup'>&nbsp;</div>");
				}
			    var imageLeft = $(".maxBox").offset().left;
			    var imageRight = $(".maxBox").offset().right;
			    var imageTop =  $(".maxBox").offset().top;
			    var imageWidth = $(".maxBox").width();
			    var imageHeight = $(".maxBox").height();
	
			    //var bigimage = $(this).attr("alt");
			    
			    ////////////////////////////////////////////////////////////////////////////
			    var bigimage = $(".maxBox img.jqzoom").attr("src");
			    ////////////////////////////////////////////////////////////////////////////
				bigimage=bigimage.substring(0,bigimage.lastIndexOf("."))+"max"+bigimage.substring(bigimage.lastIndexOf("."));

			    if($("div.zoomdiv").get().length == 0){
			   		 $(this).after("<div style='width:320px;z-index:100;position:absolute;height:320px;overflow:hidden;border:#cccccc solid 1px;'><div class='zoomdiv'><div style='width:620px;height:620px;'><img class='bigimg' src='"+bigimage+"' width='100%' height='100%'/></div></div></div>");
			    }
	
			    leftpos = imageLeft + imageWidth + 100;
			    $("div.zoomdiv").parent().css({ top: imageTop,left: leftpos });
				
				
				var scalex=3;
				$("div.jqZoomPup").width((settings.xzoom)/scalex );
	    		$("div.jqZoomPup").height((settings.yzoom)/scalex);
	    		
	    		
	            $("div.jqZoomPup").css('visibility','show');
	            $("div.jqZoomPup").show();
			    $("div.zoomdiv").parent().show();


					$(document.body).mousemove(function(e){

				    var bigwidth = $(".maxBox").width();

				    var bigheight = $(".maxBox").height();

				    var scaley ='x';

				    var scalex= 'y';


				    if(isNaN(scalex)|isNaN(scaley)){
				   	 	var scalex = 2 ;
				    	var scaley = 2;
				    }
					mouse = new MouseEvent(e);
                    scrolly = mouse.y - imageTop - ($("div.zoomdiv").height()*1/scaley)/2 ;
				    scrollx =    mouse.x - imageLeft - ($("div.zoomdiv").width()*1/scalex)/2 ;
				    
				    $("div.jqZoomPup").css({ top: mouse.y-50,left:  mouse.x-50 });
				    if(mouse.y-50<$(".maxBox").offset().top){
				    	 $("div.jqZoomPup").css("top",$(".maxBox").offset().top);
				    }
				    
				    if(mouse.x-50<$(".maxBox").offset().left){
				    	$("div.jqZoomPup").css("left",$(".maxBox").offset().left);
				    }
				    if($("div.jqZoomPup").offset().left>($(".maxBox").offset().left+bigwidth-100)){
				    	$("div.jqZoomPup").css("left",$(".maxBox").offset().left+bigwidth-100);
				    }
				    
				    if($("div.jqZoomPup").offset().top>($(".maxBox").offset().top+bigheight-100)){
				    	$("div.jqZoomPup").css("top",$(".maxBox").offset().top+bigheight-100);
				    }
				    
					if(scrolly*2<320&&scrolly>0)
						$("div.zoomdiv").css("margin-top",-scrolly*2);
						
					if(scrollx*2<320&&scrollx>0)
						$("div.zoomdiv").css("margin-left",-scrollx*2);
					

				    });
		    },function(){
		 		$(document.body).unbind("mousemove");
		    	$(".lenszoom").remove();
		  		$("div.zoomdiv").parent().remove();
		  		$("div.jqZoomPup").remove();
		    });

		}

})(jQuery);

function MouseEvent(e) {
this.x = e.pageX
this.y = e.pageY
}


