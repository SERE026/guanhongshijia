<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/taglib/fmt.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglib/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglib/fn.tld"%>
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

<fmt:setBundle basename="resource.locale" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><fmt:message key="sys.name" /></title>
<link href="<%=request.getContextPath()%>/Dress/css/kua.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Dress/css/human2.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/Dress/js/layer/lib.js"></script>
<script src="<%=request.getContextPath()%>/Dress/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/Dress/js/ajax.js"></script>
<style type="text/css">
	.error{color:#ff0000;}
</style>
</head>
<body>
<script type="text/javascript">
	var servicePath="<%=request.getContextPath()%>";
	function submit(){
		if($("#form1").checkall()){
		document.form1.submit();
	}
}
$(function(){
	$("#form1").validate();
})
</script>
<script src="<%=request.getContextPath()%>/Dress/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/shangpin/brand/merchantOrder.js"></script>
<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >
	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/brand/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>

<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/brand" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="status" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>添加</strong></td>
  </tr>
  
 <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>品牌:</td>
  	 <td ><input name="name" id="name"/></td>
  </tr>
 
 <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>Logo:</td>
  	 <td >
  	 	<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/AC_OETags.js"></script>
   		<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/fileUpload.js"></script>
		<!-- 上传附件按钮 -->
		<script language="JavaScript" type="text/javascript">
		function removeFiles(fileName){
			document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
		}
		AC_FL_RunContent(
			"src", "<%=request.getContextPath()%>/Dress/swf/fileUpload",
			"width", "100",
			"height", "30",
			"id", "fileUpload",
			"quality", "high",
			"bgcolor", "#ffffff",
			"name", "fileUpload",
			"wmode","transparent",
			"allowScriptAccess","sameDomain",
			"type", "application/x-shockwave-flash",
			"pluginspage", "http://www.adobe.com/go/getflashplayer",
			"flashVars","flexID=a&uploadURL=<%=request.getContextPath()%>/Dress/file/upload.jsp&label=图 片 上 传&succeed=a_completeUpload"
		);
		
		function a_completeUpload(fileName, realName){
			if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
			 ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
					var str="";
					str += "<div id='"+fileName+"' style='display: inline;'>";
					str += "<input type='hidden' name='logo' value='"+fileName+"'/>&nbsp;";
					str += "<img src=\"<%=request.getContextPath()%>/upload/"+fileName+"\" height=60 width=120 />";
					str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
					str += "删除";
					str += "</a>&nbsp;&nbsp;</div>";
					document.getElementById("imgUrl").innerHTML=str;
			}else{
				alert("请上传图片。");
			}
		}
		</script>
		<div  id="imgUrl">
		
		</div>
  	 </td>
  </tr>
  <c:if test="${empty merchants}">
  <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>是否热销:</td>
  	 <td >
  	 
  	 	<input type="radio" name="isr" value="0" />否
  	 	<input type="radio" name="isr" value="1" checked/>是
  	 </td>
  </tr>
  </c:if>
   <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>排序:</td>
  	 <td ><input name="index" id="index" value="999" dataType="int" class="noNull" msg="排序不能为空！"/></td>
  </tr>
  
</table>
</form>
</td>
</tr>
</table>
  </body>
</html>
