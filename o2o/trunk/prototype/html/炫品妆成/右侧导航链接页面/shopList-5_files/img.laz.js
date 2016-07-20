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
	var h=$(window).height();
	$("img:not([adv])").each(function(){
			var mh=$(this).offset().top;
			if(mh>h){
				$(this).attr("src2",$(this).attr("src"));
				$(this).attr("src","");
			}
	})
	$(window).bind("scroll", function(){ 
		h=$(window).height()+$(window).scrollTop();
		$("img:not([adv])").each(function(){
			var mh=$(this).offset().top;
			if(mh<h&&$(this).attr("src2")){
				$(this).attr("src",$(this).attr("src2"));
			
			}
		})
	});
})