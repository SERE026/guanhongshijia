<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/Dress/include/taglib.jsp" %>
<%--
  ~ Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
  ~ All rights reserved.
  ~
  ~ This file contains valuable properties of  SHENZHEN Eternal Dynasty
  ~ Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
  ~ confidential information, ideas and expressions.    No part of this
  ~ file may be reproduced or distributed in any form or by  any  means,
  ~ or stored in a data base or a retrieval system,  without  the prior
  ~ written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
  ~
  --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>panel</title>
<style type="text/css"  >
html, body { 
	width : 100%;
	height : 100%;
	padding : 0; 
	margin : 0; 
	overflow : auto;
}
.jcTab { width:100%; height:100%;overflow : auto;}
</style>
<link href="<%=request.getContextPath()%>/web/jsp/admin/css/kua.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/web/jsp/admin/css/tabPanel/core.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/web/jsp/admin/css/tabPanel/TabPanel.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/admin/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/admin/js/tabPanel/Fader.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/admin/js/tabPanel/TabPanel.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/admin/js/tabPanel/Math.uuid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/admin/js/ajax.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/admin/js/ifram.js"></script>
<script type="text/javascript"  >
var ServicePath="<%=request.getContextPath()%>";
var tabpanel;  
var jcTabs = [];
var _height=document.documentElement.clientHeight;
window._height=_height-60;
for(var i = 0; i < 8; i++) {
  jcTabs.push('<div id="'+(i+1)+'" class="jcTab"></div>');
}
$(document).ready(function(){  
    tabpanel = new TabPanel({
        renderTo:'tab',  
        //border:'none',  
        active : 0,
        width:'99%',
        height:_height,
        //maxLength : 10,  
        items : [
           {id:'index',title:'主页',html:"<iframe name='index_fram' id='index_fram' src='<%=request.getContextPath()%>/html/ibms/main/right' frameBorder=0 width=\"100%\" height=\"100%\" scrolling=\"no\" onload=\"dyniframesize('index_fram');messagefn();\"/>",closable: true,autoResizable:true}
            /* {id:'toolbarPlugin2',title:'Tab2',html:jcTabs[1],closable: true},  
            {id:'toolbarPlugin3',title:'Tab3',html:jcTabs[2],closable: true},  
            {id:'toolbarPlugin4',title:'Tab4',html:jcTabs[3],closable: true},  
            {id:'toolbarPlugin5',title:'Tab5',html:jcTabs[4],closable: true},  
            {id:'toolbarPlugin6',title:'Tab6',html:jcTabs[5],closable: true},  
            {id:'toolbarPlugin7',title:'Tab7',html:jcTabs[6],closable: true},  
            {id:'toolbarPlugin8',title:'Tab8',html:jcTabs[7],closable: true}  */
        ]
    });  
}); 


function show(id,title,url){
	
	var result=tabpanel.getTabPosision(id);
	if(id==result){
		if(IntervalNo!=null){
			window.clearInterval(IntervalNo);
			IntervalNo=null;
		}
		tabpanel.addTab({id:id,title:title,html:"<iframe name='"+id+"_fram' id='"+id+"_fram' src=\""+url+"\" frameBorder=0 width=\"100%\" height=\"100%\" scrolling=\"auto\" onload=\"dyniframesize('"+id+"_fram');messagefn();\"/>",closable:true,disabled:false});
		
		//var mf=document.getElementById(id+"_fram");
		//mf.contentWindow.document.write("<div style='text-align:center;'>数据加载中，请稍后...</div>");
	}else{
		tabpanel.show(tabpanel.getTabPosision(id),null);
		//$("#loadData").css("display","none");
	}
	
}


	
	var i=0;
	function forAccaptFn(){
		resultAjax('<%=request.getContextPath()%>/html/ibms/accapt/search',"ids=",result,"json")
	}
	
	function result(data){
		var message="";
		if(data[0].accaptList.length>0){
			$(".mailImg").attr("src","<%=request.getContextPath()%>/web/jsp/admin/img/dd.gif");
			if(i!=data[0].accaptList.length){
				i=data[0].accaptList.length;
				for(var j=0;j<i;j++){
					message+="<div  style='width:99%;margin-top:10px;border: 1px solid #D4D4D4;'><div style='text-align:center;mergin-top:5px;font-size:14px'>"+data[0].accaptList[j].title+"</div>"
					message+="<div style='font-size:14px;margin-top:10px'>"+data[0].accaptList[j].context+"</div>"
					message+="<div style='width:100%;margin-top:10px'><a style='float:left' id="+data[0].accaptList[j].id+j+" href=\"javascript:updatestatus('id="+data[0].accaptList[j].id+"&login_id=${UserInfo.login_id}&user_assi=${UserInfo.passwd}','"+data[0].accaptList[j].id+j+"')\" class='zhidao' >马上处理</a><a style='float:right' href=\"javascript:closeDiv('"+data[0].accaptList[j].id+j+"')\">稍后处理</a></div>"
					message+="</div>";
				}
				if(window.external.CB_CustomFunctionWithParams==null){
					showMessage(message,"有新的消息");
				}else{
					window.external.CB_CustomFunctionWithParams(message,"有新的消息" );
				}
			}
		}else{
			$(".mailImg").attr("src","<%=request.getContextPath()%>/web/jsp/admin/img/dd2.gif");
		}
		
	}

$(function(){
	window.setInterval("forAccaptFn()",15000);
	$(".mailImg").click(function(){
	//	show("message","收件箱","<%=request.getContextPath() %>/html/ibms/accapt/list");
	});
	
	$("#colse").click(function(){
		$("#showMessage").css("display","none");
		$("#MessageBG").css("display","none");
	});
})

function showMessage(message,title){
	
	$("#showMessage #messageTitle").html(title);
	$("#showMessage #messageContent").html(message);
	$("#showMessage").css("left",($(window).width()-$("#showMessage").width())/2);
	$("#showMessage").css("top",($(window).height()-$("#showMessage").height())/2);
	$("#showMessage").css("display","");
	$("#MessageBG").css("display","");
}

</script>
</head>
<body>

<div class="right">
<div class="left_top">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="35px">
  <tr>
    <td style="width:21px;"><img src="<%=request.getContextPath() %>/web/jsp/admin/img/left_20.gif" /></td>
    <td style="height:35px; background-image:url(<%=request.getContextPath() %>/web/jsp/admin/img/left_bg1.gif); background-repeat:repeat-x;">
	<div class="bukuai">
<div class="left_top2">
<div class="lt_tu"></div>
<div class="lt_wenzi"></div>
<div class="lt_wenzi2">

<c:if test="${not empty menu}">
&nbsp;&nbsp;-&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/html/ibms/main/menu/${menu.id }" class="zhu1">${menu.res_name }</a>&nbsp;&nbsp;-&nbsp;&nbsp;<span class="xiang">模块功能列表</span>
</c:if>
</div>
</div>


<div class="left_top5"><a href="javascript:void(0)"><img class="mailImg" src="<%=request.getContextPath()%>/web/jsp/admin/img/dd2.gif" border="0" /></a></div>
<div class="left_top4"><span class="ypsj"></span>好：${UserInfo.user_name }</div>
</div>
    
    </td>
    
    <td style="width:21px;"><img src="<%=request.getContextPath()%>/web/jsp/admin/img/left_22.gif" /></td>
</table>
</div>




<script>
function fnypsj(){
	today=new Date();
	var h=today.getHours();
	if(h>=0&&h<8){
		$(".ypsj").html("凌晨");
	}else if(h>=8&&h<9){
		$(".ypsj").html("早上");
	}else if(h>=9&&h<12){
		$(".ypsj").html("上午");
	}else if(h>=12&&h<14){
		$(".ypsj").html("中午");
	}else if(h>=14&&h<19){
		$(".ypsj").html("下午");
	}else if(h>=19&&h<21){
		$(".ypsj").html("晚上");
	}else if(h>=22&&h<24){
		$(".ypsj").html("凌晨");
	}
	}
	fnypsj();
	setInterval(fnypsj,180000);
</script>

  <div id="tab" style="margin-left:5px;"></div>
    <div id="loadData" style="width:100%;height:100%;top:100px;z-index:99;position:absolute;display:none">
  	<div style='text-align:center;'>数据加载中，请稍后...</div>
  </div>
  <div id="showMessage" style="overflow;hidden;display:none;width:510px;height:430px;position:absolute;z-index:999;border: 1px solid #0000FF;background-color: #ffffFF; ">
  		<div id="colse" style="position:absolute;top:0;right:5px;color:#ff0000;height:30px;line-height:30px;cursor:pointer">X</div>
  		<div id="messageTitle" style="background-color: #00CCFF;widht:500px;height:30px;line-height:30px;text-align:center;padding-left:5px;"></div>
  		<div id="messageContent" style="overflow-x:hidden;widht:500px;height:400px;overflow-y:scroll" ></div>
  </div>
  <div id="MessageBG" style="display:none;width:100%;height:100%;position:absolute;z-index:998;background-color: #c3c3c3;left:0;top:0;filter:progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75) ">
  </div>
  </body>
  <script>
		function updatestatus(data,id){
		 $("#showMessage").css("display","none");
		 $("#MessageBG").css("display","none");
			resultAjax("<%=request.getContextPath()%>/html/ibms/accapt/update","id"+id+,"订单管理","redirect:/html/ibms/order/list");
			$("#"+id).attr("rel","click");
		}
		function resultFn(data){
			$("a[rel='click']").parent().parent().remove();
		}
		function closeDiv(id){
			$("#showMessage").css("display","none");
		    $("#MessageBG").css("display","none");
			$("#"+id).parent().parent().remove();
		}
	</script>
</html>
