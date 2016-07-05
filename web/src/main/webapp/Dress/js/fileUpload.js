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

//文件上传处理组件
//和fileUpload.swf，upload.jsp同时使用
//支持多文件上传，显示上传进度等
//可自己根据需要在jsp页面中实现JS方法
//支持参数：
//uploadURL 上传处理jsp绝对路径
//uploadTYPE 上传类型
//userID 识别ID
//label 按钮文字
//flexID swf调用js方法的程序识别 默认为空字符串

//var _fileNameArray=new Array();
//var _realNameArray=new Array();
//var _fileSizeArray=new Array();

function _addUploadParameter(fileName,realName,fileSize){
	//根据需要实现
	//alert(fileName+","+realName+","+fileSize);
	//_fileNameArray.add(fileName);
	//_realNameArray.add(realName);
	//_fileSizeArray.add(fileSize);
	//_showFiles();
}

function _showFiles(){
	//根据需要实现
	//if(_realNameArray.length>0){
	//	for(var i=0;i<_realNameArray.length;i++){
	//		if(!document.getElementById(_fileNameArray[i]) && document.getElementById("fileList")){
	//			document.getElementById("fileList").innerHTML+="<div id='"+_fileNameArray[i]
	//				+"'>fileName="+_fileNameArray[i]+"  realName="+_realNameArray[i]+"   fileSize="+_fileSizeArray[i]+"</div>";
	//		}
	//	}
	//}
}

function _showProgress(fileName,numPerc){
	//根据需要实现
	//if(document.getElementById("progress")){
	//	document.getElementById("progress").innerHTML="fileName="+fileName+"numPerc="+numPerc;
	//}
}

function _removeFile(fileName){
	//根据需要实现
}

function _errorUpload(fileName, realName, errorText){
	//根据需要实现
	//alert(realName+"上传错误");
}

//function _completeUpload(fileName,realName){
	//根据需要实现
//}

function a_completeUpload(fileName, realName){
	var str = "";
	str += "<div id='"+fileName+"' style='display: inline;'>";
	str += "<a href='#' onclick='fileClick(\""+fileName+"\")'>"+realName+"</a>";
	str += "<input type=hidden name=files value='"+fileName+"'/>&nbsp;";
	str += "<img src='<%=request.getContextPath()%>/web/jsp/admin/img/kongzhi3.gif' style='cursor:hand;' onclick='removeFiles(\""+fileName+"\")'/>";
	str += "&nbsp;&nbsp;</div>";
	document.getElementById("files").innerHTML += str;
}

function removeFiles(fileName){
	document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
}

//function _showTotalProgress(fileSize){
	//根据需要实现
//}
