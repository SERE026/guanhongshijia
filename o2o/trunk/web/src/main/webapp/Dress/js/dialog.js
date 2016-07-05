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

/**
 * 对话框js
 * 
 */
//打开对话框
function showDialog(url,id){
	var win_returnValue = showModalDialog(url,window,'dialogHeight:450px;dialogWidth:600px;toolbar:no;' +
			'menubar:no;scrollbars:no;resizable:yes;location:no;status:no;');//对话框窗口返回值
	var obj = document.getElementById(id);//操作DOM对象
	if(win_returnValue && obj)
		insertObj(win_returnValue,obj);
}
//使用返回值做操作
function insertObj(win_returnValue,obj){
	//返回值形式如：{id:'402881fb2e4131e4012e413331d40001',name:'改变'}
	var value = win_returnValue.id;
	var text = win_returnValue.name;
	var option = new Option(text,value);
	obj.options[(obj.options.length)] = option;
	obj.selectedIndex = obj.options.length - 1;
}

//打开对话框
function openDialogSel(url){
	var Browser = {
		'isIE' : (navigator.userAgent.indexOf('MSIE') >= 0) && (navigator.userAgent.indexOf('Opera') < 0),
		'isFirefox' : navigator.userAgent.indexOf('Firefox') >= 0,
		'isOpera' : navigator.userAgent.indexOf('Opera') >= 0
	};
	if(Browser.isIE){
		var win_returnValue = showModalDialog(url,self,'dialogHeight:600px;dialogWidth:820px;toolbar:no;menubar:no;scrollbars:no;resizable:yes;location:no;status:no;');
		return win_returnValue;
	}else if(!Browser.isIE){
		var win = window.open(url,'newWindow','modal=yes,width=820,height=600,resizable=yes,scrollbars=yes,location=no,scrollbars=no,toolbar=no,menubar=no');
		return win;
	}
}
function window_1047(url){
	return window.open(url,'','modal=yes,width=1047,height=600,resizable=yes,scrollbars=yes,location=no,scrollbars=yes,toolbar=no,menubar=no');
}
function openwindow(url){
	window.open(url,'','modal=yes,width=820,height=600,resizable=yes,scrollbars=no,location=no,scrollbars=no,toolbar=no,menubar=no');
}
