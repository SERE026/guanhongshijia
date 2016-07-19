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

<script src="<%=request.getContextPath()%>/kindeditor4/kindeditor.js" type="text/javascript"></script>
<script type="text/javascript">
	KindEditor.ready(function(K) {
		window.edit=K.create('textarea[name="context"]', {
			allowFileManager : true,
			items:["source","bold","textcolor","image","link","emoticons"],
			uploadJson:'<%=request.getContextPath()%>/kindeditor4/jsp/upload_json.jsp'
		})
	});
		function submit(){
			window.edit.sync();
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
        	<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/bbsPost/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/bbsPost/add" method="post">
<input type="hidden" name="_method" value="post" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>新增帖子</strong></td>
  </tr>
    <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>主题:</td>
  	  <td ><input name="title" id="title" class="noNull"  msg="主题不能空！"/></td>
  </tr>
  <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>帖子类型:</td>
  	  <td >
  	     <select name="flag" style="width:173px; height:23px;">
  	                <option value="">请选择</option>
					<option value="0">公告</option>
					<option value="1">网站活动</option>
					<option value="2">自由发帖</option>
				</select>
  	  </td>
  </tr>
 <tr>
 <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>内容:</td>
	<td>
		<textarea class="noNull" msg="内容不能空！" name="context" id="context" style="width:800px;height:600px;" ></textarea>
	</td>
 </tr>
 </table>
</form>
</td>
</tr>
</table>

