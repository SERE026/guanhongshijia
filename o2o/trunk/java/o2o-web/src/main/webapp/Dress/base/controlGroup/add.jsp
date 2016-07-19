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

<script type="text/JavaScript">
	function allclick(obj){
		if(obj.checked){
			var objs=document.getElementsByName("checkbox");
			for(var i=0;i<objs.length;i++){
				if(objs[i].id.indexOf("c")==0&&objs[i].id.substring(1,objs[i].id.length)==obj.id.substring(1,obj.id.length))
					objs[i].checked=true;
			}
		}else{
			var objs=document.getElementsByTagName("input");
			for(var i=0;i<objs.length;i++)
				if(objs[i].id.indexOf("c")==0&&objs[i].id.substring(1,objs[i].id.length)==obj.id.substring(1,obj.id.length))
					objs[i].checked="";
		}
	}
	function allunclick(obj){
		if(obj.checked){
			document.getElementById("p"+obj.id.substring(1,obj.id.length)).checked = "true";
		}else{
			var flag = false;
			var objs=document.getElementsByTagName("input");
			for(var i=0;i<objs.length;i++){
				if(objs[i].id.indexOf("c")==0&&objs[i].id.substring(1,objs[i].id.length)==obj.id.substring(1,obj.id.length)){
					if(objs[i].checked){
						flag = true;
						break;
					}
				}
			}
			if(!flag)
				document.getElementById("p"+obj.id.substring(1,obj.id.length)).checked = "";
		}
	}
	function showChoose(obj){
		var _div = document.getElementById(obj.name.substring(0, obj.name.length-11)+"_div");
		_div.children[1].value = "";
		_div.children[2].value = "";
		var value = obj.options[obj.selectedIndex].value;
		if(value == "1"){
			_div.style.display = "block";
		}else{
			_div.style.display = "none";
		}
	}
	function openDialog(id){
		openDialogSel("<%=request.getContextPath()%>/html/manage/ognz/selection?fieldId="+id+"_acceeObj&fieldName="+id+"_div1&selectedIds="+document.getElementById(id+'_acceeObj').value);
	}
	function submit(){
	    if($("#groupName").val() == ""){
	    	sys_alert("<fmt:message key='alert.groupName'/>");
	    	$("#groupName").focus();
	    	return;
	    }
	    document.form1.submit();
	}
</script>
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
			<a href="<%=request.getContextPath()%>/html/manage/controlGroup/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/controlGroup" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="isDefault" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong><fmt:message key="cg.add" /></strong></td>
  </tr>
  <tr>
    <td  style="border-right:#c5c5c5 solid 1px;background-color:#e2eaed;"><span style="color:#ff0000">*</span><fmt:message key="cg.name" />:</td>
    <td><input type="text" id="groupName" name="groupName" value="" /></td>
  </tr>
  <tr>
  	 <td  style="border-right:#c5c5c5 solid 1px;background-color:#e2eaed;"><span style="color:#ff0000">*</span><fmt:message key="cg.res" />:</td>
  	  <td>
  	  	${reslist}
  	  </td>
  </tr>
    <tr>
    <td  style="border-right:#c5c5c5 solid 1px;background-color:#e2eaed;">
    	<fmt:message key="sys.ps" />:
    </td>
    <td ><textarea name="ps" style="width:95%;height:200px;"></textarea></td>
  </tr>
</table>
</form>
  </td>
</tr>
</table>
<%@ include file="/Dress/include/buttom.jsp" %>
