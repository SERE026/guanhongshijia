<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	function submit(){
		if($("#form1").checkall()){
		document.form1.submit();
	}
}
$(function(){
	$("#form1").validate();
})
</script>
<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2">
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
					<a href="<%=request.getContextPath()%>/html/manage/yqlj/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>

<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/yqlj" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="id" value=""/>
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>新增友情链接</strong></td>
  </tr>
    <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>友情链接名称:</td>
  	  <td ><input name="yqlj_name" id="yqlj_name" class="noNull" msg="友情链接名称不能为空！"/></td>
  </tr>
  <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>友情链接地址:</td>
  	  <td ><input name="yqlj_dress" id="yqlj_dress" dataType="url" class="noNull" msg="友情链接地址不能为空！"/></td>
  </tr>
  <tr>
     <td class="discription" style="width: 150px;">排序:</td>
  	  <td ><input name="yqlj_count" id="yqlj_count" dataType="int"/></td>
  </tr>
 <tr>
 <td class="discription" style="width: 150px;">上传图片:</td>
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
			"flashVars","flexID=a&uploadURL=<%=request.getContextPath()%>/Dress/file/uploadyqlj.jsp&label=图 片 上 传&succeed=a_completeUpload"
		);
		
		function a_completeUpload(fileName, realName){
			if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
			 ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
					var str="";
					str += "<div id='"+fileName+"' style='display: inline;'>";
					str += "<input type='hidden' name='yqlj_img' value='"+fileName+"'/>&nbsp;";
					str += "<img src=\"<%=request.getContextPath()%>/upload/yqlj/"+fileName+"\" height=150 width=150 />";
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
 </table>
</form>
</td>
</tr>
</table>
