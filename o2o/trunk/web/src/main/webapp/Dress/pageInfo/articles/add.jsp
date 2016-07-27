<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/top.jsp" %>

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

<script src="<%=request.getContextPath()%>/kindeditor4/kindeditor.js" type="text/javascript"></script>
<script type="text/javascript">
	KindEditor.ready(function(K) {
		window.edit=K.create('textarea[name="artices_content"]', {
			allowFileManager : true,
			items:["source","bold","textcolor","image","link","emoticons"],
			uploadJson:'${applicationPath}/kindeditor4/jsp/upload_json.jsp'
		})
	});
	
function submit(){
	//if($("#form1").checkall()){
		//document.form1.submit();
	//}
	if ($("#artices_name").val() == "") {
		alert("请输入文章标题！");
		return;
	}
	document.form1.submit();
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
        	<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/articles/list">
			<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/articles" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="id" value=""/>
<input type="hidden" name="name" value=""/>
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>新增文章</strong></td>
  </tr>
    <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>文章标题:</td>
  	  <td ><input name="artices_name" id="artices_name" class="noNull"  msg="文章标题不能空！" style="width: 300px;"/></td>
  </tr>
 <tr>
 <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>文章内容:</td>
	<td>
		<textarea class="noNull" msg="文章内容不能空！" name="artices_content" id="artices_content" style="width:800px;height:600px;" ></textarea>
	</td>
 </tr>
 </table>
</form>
</td>
</tr>
</table>

