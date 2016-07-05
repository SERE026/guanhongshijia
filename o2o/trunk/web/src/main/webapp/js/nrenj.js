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
		$("#adddata").unbind("click").click(function(){
			$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=shopList&action=nvrenjie&pageNo="+pageNo+"&pageSize=10",
			  dataType: "html",
			  success: function(data){
			 		pageNo++;
					$("#adddata").before(data);
			 }
		});
	});
});

