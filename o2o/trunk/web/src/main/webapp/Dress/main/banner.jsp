<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/Dress/include/top.jsp" %>
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

<script type="text/javascript">

$(function(){
	/*
	$(".exit").click(function(){
		window.parent.location.href="<%=request.getContextPath()%>/html/ibms/main/exit";
	});
	
	$(".goIndex").click(function(){
		var rightWin=window.parent.document.getElementById("mainFrame").contentWindow;
		rightWin.show("index","首页","<%=request.getContextPath()%>/html/ibms/main/right");
	});
	
	$(".goHelp").click(function(){
		var rightWin=window.parent.document.getElementById("mainFrame").contentWindow;
		rightWin.show("help","帮助","<%=request.getContextPath()%>/web/jsp/admin/main/help.jsp");
	});
	*/
	

});
fnhelp=function(){
		openwindow("<%=request.getContextPath()%>/help.html");
	}

	
</script>


       
 <div class="top">
<div class="top_1"><img src="<%=request.getContextPath() %>/<%=Constants.ADMIN_ADDRESS%>/img/top_02.gif" /></div>
<div class="top_2"><a href="#"><img src="<%=request.getContextPath() %>/<%=Constants.ADMIN_ADDRESS%>/img/top_tit.gif" border="0" /></a></div>
<div class="top_wenzi">
 <script type="text/javascript">
 
today=new Date();
function initArray()
  {
      this.length=initArray.arguments.length
      for(var i=0;i<this.length;i++)
      this[i+1]=initArray.arguments[i]
  }
    var d=new initArray
 (
     "<fmt:message key="top.7" />",
     "<fmt:message key="top.1" />",
     "<fmt:message key="top.2" />",
     "<fmt:message key="top.3" />",
     "<fmt:message key="top.4" />",
     "<fmt:message key="top.5" />",
     "<fmt:message key="top.6" />"
  );
function  fn_sj(){
	today=new Date();
	var m_html=(""+"日期："+
	today.getFullYear()+"<fmt:message key="top.year" />"+
	(today.getMonth()+1)+"<fmt:message key="top.month" />"+
	today.getDate()+"<fmt:message key="top.date" />  "+
	
	today.getHours()+":"+today.getMinutes()+"分  "+
	"");
	m_html+=(""+d[today.getDay()+1]+"");
	$(".top_wenzi").html(m_html);
}

function update(){
	resultAjax('<%=request.getContextPath()%>/html/manage/main/update',"",c,"txt");
}

function c(){
}
window.onload=function(){
	fn_sj();
	setInterval(fn_sj,500);
	setInterval(update,1*60*1000);
}

	var i=0;
	function forAccaptFn(){
		resultAjax('<%=request.getContextPath()%>/html/ibms/accapt/search',"ids=",result,"json")
	}
	
	function result(data){
		var message="";
		if(data[0].accaptList.length>0){
			$(".mailImg").attr("src","<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/top_bg_02-07.gif");
			if(i!=data[0].accaptList.length){
				i=data[0].accaptList.length;
				for(var j=0;j<i;j++){
					message+="<div  style='width:99%;margin-top:10px;border: 1px solid #D4D4D4;'><div style='text-align:center;mergin-top:5px;font-size:14px'>"+data[0].accaptList[j].title+"</div>"
					message+="<div style='font-size:14px;margin-top:10px'>"+data[0].accaptList[j].context+"</div>"
					message+="<div style='width:100%;margin-top:10px'><a style='float:left' id="+data[0].accaptList[j].id+j+" href=\"javascript:window.parent.topFrame.updatestatus('id="+data[0].accaptList[j].id+"&login_id=${UserInfo.login_id}&user_assi=${UserInfo.passwd}','"+data[0].accaptList[j].id+j+"')\" class='zhidao' >马上处理</a><a style='float:right' href=\"javascript:window.parent.topFrame.closeDiv('"+data[0].accaptList[j].id+j+"')\">稍后处理</a></div>"
					message+="</div>";
				}
				if(window.external.CB_CustomFunctionWithParams==null){
					showMessage(message,"有新的消息");
				}else{
					window.external.CB_CustomFunctionWithParams(message,"有新的消息" );
				}
			}
		}else{
			$(".mailImg").attr("src","<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/top_bg_02.gif");
		}
		
	}

$(function(){
	//window.setInterval("forAccaptFn()",15000);
	$(".mailImg").click(function(){
	//	show("message","收件箱","<%=request.getContextPath() %>/html/ibms/accapt/list");
	});
	
	$("#colse").click(function(){
		$("#showMessage").css("display","none");
		$("#MessageBG").css("display","none");
	});
})

function showMessage(message,title){
	if($(window.parent.mainFrame.document.body).find("#showMessage").length==0)
		$(window.parent.mainFrame.document.body).append($("#mes").html());
	
	var height=$(window.parent.mainFrame.document.body).height();
	var wheight=$(window.parent.mainFrame).height();
	if(height<wheight){
		height=wheight;
	}
	
	$(window.parent.mainFrame.document.body).find("#showMessage #messageTitle").html(title);
	$(window.parent.mainFrame.document.body).find("#showMessage #messageContent").html(message);
	$(window.parent.mainFrame.document.body).find("#showMessage").css("left",($(window.parent.mainFrame.document.body).width()-$("#showMessage",window.parent.mainFrame.document.body).width())/2);
	$(window.parent.mainFrame.document.body).find("#showMessage").css("top",(height-$("#showMessage",window.parent.mainFrame.document.body).height())/2);
	$(window.parent.mainFrame.document.body).find("#showMessage").css("display","");
	$(window.parent.mainFrame.document.body).find("#MessageBG").css("display","");
	$(window.parent.mainFrame.document.body).find("#MessageBG").css("filter","progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100)");
	$(window.parent.mainFrame.document.body).find("#MessageBG").css("opacity","0.75");
	$(window.parent.mainFrame.document.body).find("#MessageBG").css("height",height+"px");
	addstener();
}

function addstener(){
	$(window.parent.mainFrame.document.body).find("#colse").click(function(){
		$(window.parent.mainFrame.document.body).find("#showMessage").css("display","none");
		$(window.parent.mainFrame.document.body).find("#MessageBG").css("display","none");
	});
}
function updatestatus(data,id){

	
 	$(window.parent.mainFrame.document.body).find("#showMessage").css("display","none");
 	$(window.parent.mainFrame.document.body).find("#MessageBG").css("display","none");
	resultAjax("<%=request.getContextPath()%>/html/ibms/accapt/update","id=4028819a418b799b01418c98502c0003","订单管理","redirect:/html/ibms/order/list");
	$(window.parent.mainFrame.document.body).find("#"+id).attr("rel","click");
}
function closeDiv (id){
	$("#"+id,window.parent.mainFrame.document.body).parent().parent().remove();
}

</script>
</div>
<div class="top_3"><a href="<%=request.getContextPath()%>/html/manage/main/exit" class="exit"><img src="<%=request.getContextPath() %>/<%=Constants.ADMIN_ADDRESS%>/img/top_07.gif" border="0" /></a></div>
<div class="top_3"><a href="<%=request.getContextPath()%>/html/manage/main/right" class="goIndex" target="mainFrame"><img src="<%=request.getContextPath() %>/<%=Constants.ADMIN_ADDRESS%>/img/top_04.gif" border="0" /></a></div>
<!-- 弃用 消息
<div class="top_3" style="line-height:50px;width:55px;height:57px;" ><a href="<%=request.getContextPath() %>/html/Manage/accapt/list" target="mainFrame" class="goIndex"><img src="<%=request.getContextPath() %>/<%=Constants.ADMIN_ADDRESS%>/img/top_bg_02.gif" border="0" width="100%" height="100%" class="mailImg" /></a></div>
 -->

<div class="top_3" style="line-height:50px;color:#ffffff;font-size:20px;width:100px;">${UserInfo.user_name }</div>
</div>
<div class="xian1">&nbsp;</div>

<div style="display:none" id="mes">
	 <div id="showMessage" style="overflow;hidden;display:none;width:510px;height:430px;position:absolute;z-index:999;border: 1px solid #0000FF;background-color: #ffffFF; ">
  		<div id="colse" style="position:absolute;top:0;right:5px;color:#ff0000;height:30px;line-height:30px;cursor:pointer">X</div>
  		<div id="messageTitle" style="background-color: #00CCFF;widht:500px;height:30px;line-height:30px;text-align:center;padding-left:5px;"></div>
  		<div id="messageContent" style="overflow-x:hidden;widht:500px;height:400px;overflow-y:scroll" ></div>
  </div>
  <div id="MessageBG" style="display:none;width:100%;height:100%;position:absolute;z-index:998;background-color: #c3c3c3;left:0;top:0;filter:progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75) ">
  
</div>
</body>
</html>