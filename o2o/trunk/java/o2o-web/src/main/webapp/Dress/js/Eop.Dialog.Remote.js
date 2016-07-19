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

var Eop=Eop||{};
Eop.Dialog={
	init:function(opations){
	 	 EopDlg.dialog(opations);
	},
	open:function(url){
 		url=app_path + url;
 		setDlgUrl(url);
 		EopDlg.dialog({closed:false});
	},
	close:function(){
		EopDlg.dialog({closed:true});
	}
	
};