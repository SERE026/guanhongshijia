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
	var url = window.location.search.substr(1).split("&")[0];
	url = url.substring (url.length-1,url.length);
	$.ajax({
		type: 'POST',
		url: servicePath+"/widget.html",
		data: "widget=personal&url="+url,
		dataType: "html",
			 success: function(data){
		}
	});	
});