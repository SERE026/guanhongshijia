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

function submittx(){
var txImage=$("[name=head_img]").val();
	if(txImage==undefined){
		alert("您还没有上传头像！请上传头像！");
	}else{
		$.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=personal&txImage="+txImage,
			  dataType: "html",
			  success: function(data){
			 	 alert("保存成功！");
			 	 window.location.href="huiyuan_personal.html";
			  }
		});	
	}
}	