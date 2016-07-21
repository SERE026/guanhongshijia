<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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

<script src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/android/aadv/aadv.js"></script>
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
<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2">
	<tr><td></td></tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/amenu/list">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>

<tr>
	<tr><td></td></tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/amenu" method="post">
<input type="hidden" name="_method" value="put" />
<input type="hidden" name="amenu_id" value="${info.amenu_id }"/>
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>修改广告</strong></td>
  </tr>
    <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>广告名称:</td>
  	  <td ><input name="amenu_name" id="name" class="noNull" msg="位置名称不能为空！" value="${ info.amenu_name }"/></td>
  </tr>
<tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>广告位置:</td>
  			<td>
							<select name="amenuwz.menuwz_id" class="noNull" msg="广告位置不能为空！" style="width:173px; height:23px;" >
									 <c:forEach var='Info' items='${amenuwz }' varStatus='index'>
						 				 <option value="${Info.menuwz_id }" <c:if test="${info.amenuwz.menuwz_id==Info.menuwz_id  }">selected</c:if>>${Info.menuwz_title }</option>
						  			</c:forEach>
						</select>
									</td>
  </tr>
<tr>
     <td class="discription"  style="width: 150px;">上传图片:</td>
  	<td >
  	 	<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/AC_OETags.js"></script>
   		<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/fileUpload.js"></script>
		<!-- 上传附件按钮 -->
		<script language="JavaScript" type="text/javascript">
		function removeFiles(fileName){
			document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
		}
		AC_FL_RunContent(
			"src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
			"width", "100",
				"height", "25",
				"style","margin-top:6px",
			"id", "fileUpload",
			"quality", "high",
			"bgcolor", "#ffffff",
			"name", "fileUpload",
			"wmode","transparent",
			"allowScriptAccess","sameDomain",
			"type", "application/x-shockwave-flash",
			"pluginspage", "http://www.adobe.com/go/getflashplayer",
			"flashVars","flexID=a&uploadURL=<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/file/uploadadv.jsp&label=文 件 上 传&succeed=a_completeUpload"
		);
		function a_showTotalProgress(a,b,c){
          document.getElementById("imgUrl").innerHTML="<img src='<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/loading.gif' />";
        }
		function a_completeUpload(fileName, realName){
			
					var str="";
					str += "<div id='"+fileName+"' style='display: inline;'>";
					str += "<input type='hidden' name='img' value='"+fileName+"'/>&nbsp;";
					str += "<img src=\"<%=request.getContextPath()%>/upload/adv/"+fileName+"\" height=150 width=150 />";
					str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
					str += fileName+"<span style='color:#ff0000'>删除</span>";
					str += "</a>&nbsp;&nbsp;</div>";
					document.getElementById("imgUrl").innerHTML=str;
		
			
		}
		</script>
			<div  id="imgUrl">
					<div id='${info.img}' style='display: inline;'>
					<input type='hidden' name='img' value='${info.img }'/>&nbsp;
					<img src="<%=request.getContextPath()%>/upload/adv/${info.img }" height=105 width=200 />
					${info.img}<a href='#' onclick='removeFiles("${info.img }")'>
					删除
					</a>&nbsp;&nbsp;</div>
			</div>
  	 </td>
  </tr>
  
  
    
 
 
 </table>
</form>
</td>
</tr>
</table>

