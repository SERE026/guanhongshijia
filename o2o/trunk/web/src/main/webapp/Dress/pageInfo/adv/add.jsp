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

<script type="text/javascript">
	function submit(){
		if($("#form1").checkall()){
		document.form1.submit();
	}
	
	
}
$(function(){
	$("#form1").validate();
	 $("#area_name").click(function(){
		openDialogSel("<%=request.getContextPath()%>/html/manage/area/selection?fieldId=adv_Id&fieldName=area_name&maxSelect=1");
	});
});
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
			<a href="<%=request.getContextPath()%>/html/manage/adv/list">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form  name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/adv" method="post">
<input type="hidden" name="_method" value="post" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4" ><strong>新增广告</strong></td>
  </tr>
    <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>广告名称:</td>
  	  <td ><input name="adv_name" id="adv_name"  class="noNull" msg="广告名称不能为空！"/></td>
  </tr>
    <tr>
    <td class="discription" style="width: 150px;" ><span style="color:#ff0000">*</span>广告位置:</td>
									<td>
							<select name="advwz.advwz_id" class="noNull" msg="广告位置不能为空！" style="width:154px; height:23px;" >
									 <option id="fkzt1" value="">请选择</option>
									 <c:forEach var='Info' items='${advinfo }' varStatus='index'>
						  <option value="${Info.advwz_id }" >${Info.advwz_title }</option>
						  </c:forEach>
						</select>
									</td>
									</tr>
     <tr>
     <!-- <td class="discription"  style="width: 150px;">是否开户:</td> -->
  	 <!-- <td ><input name="adv_use" id="adv_use" value="1" type="radio" checked="checked"/>开启<input name="adv_use" id="adv_use" type="radio" value="0"/>关闭</td>-->
  </tr>
  
  <tr>
     <td class="discription"  style="width: 150px;">城市:</td>
  	  <td >
  	  		<input name="area_name" id="area_name"  type="text" value="" readonly />
  	  		<input name="area_id" id="adv_Id" type="hidden" value=""/>
  	  </td>
  </tr>
  
     <tr>
     <td class="discription"  style="width: 150px;"><span style="color:#ff0000">*</span>起始时间:</td>
  	  <td ><input type="text" id="adv_starttime" name="adv_starttime"   readonly onclick="WdatePicker()" class="bianji_3 date noNull" msg="开始时间不能为空！" style="font-size: 12px;width: 169px;"/></td>
  </tr>
  <tr>
     <td class="discription"  style="width: 150px;"><span style="color:#ff0000">*</span>终止时间:</td>
  	  <td ><input type="text" id="adv_endtime" name="adv_endtime"   readonly onclick="WdatePicker()" class="bianji_3 date noNull" msg="终止时间不能为空！" style="font-size: 12px; width: 169px;"/></td>
  </tr>
    <tr>
     <td class="discription"  style="width: 150px;">广告链接:</td>
  	  <td ><input name="adv_link" id="adv_link" dataType="url"/></td>
  </tr>
    <tr>
     <td class="discription"  style="width: 150px;">广告背景色:</td>
  	  <td ><input name="adv_bgColor" id="adv_bgColor" value="" /></td>
  </tr>
  
    <tr>
     <td class="discription"  style="width: 150px;">上传广告文件:</td>
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
					str += "<input type='hidden' name='adv_flie' value='"+fileName+"'/>";
					str += "<img src=\"<%=request.getContextPath()%>/upload/adv/"+fileName+"\" height=150 width=150 />";
					str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
					str += fileName+"<span style='color:#ff0000'>删除</span>";
					str += "</a>&nbsp;&nbsp;</div>";
					document.getElementById("imgUrl").innerHTML=str;
		
			
		}
		</script>
		<div  id="imgUrl">
		
		</div>
  	 </td>
  </tr>
  <tr>
     <td class="discription"  style="width: 150px;">单位名称:</td>
  	  <td ><input name="adv_unit" id="adv_unit"/></td>
  </tr>
    <tr>
     <td class="discription"  style="width: 150px;">联系方式:</td>
  	  <td ><input name="adv_linktype" id="adv_linktype"/></td>
  </tr>
    <tr>
     <td class="discription"  style="width: 150px;">联系人:</td>
  	  <td ><input name="adv_linkman" id="adv_linkman"/></td>
  </tr>
   <tr>
  <td class="discription" ><span style="color:#ff0000">*</span>排序:</td>
  	<td>
  		<input  name="orderIndex" type="text" dataType="int"  value="${ info.orderIndex }"/>
  	</td>
  	</tr>
 </table>
</form>
</td>
</tr>
</table>
