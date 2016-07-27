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

<script type="text/JavaScript">
function openDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/res/selection?fieldId=parent1&fieldName=parent1Name&maxSelect=1");
}

function submit(){
    if($("#res_name").val() == ""){
    	sys_alert("<fmt:message key='alert.res_name'/>");
    	$("#res_name").focus();
    	return;
    }
    document.form1.submit();
}
</script>


<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
<td class="tab2_top" ></td>
</tr>
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
			<a href="javascript:history.go(-1);">
			<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>

<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/res" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="is_default" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
  	<thead>
	<tr>
		<td colspan="6">
			<strong><fmt:message key="res.add" /></strong>
		</td>
	</tr>
	</thead>
     <tr>
        <td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="res.name" />:</td>
        <td><input type="text" id="res_name" name="res_name" value="" /></td>
  	    <td class="discription"><fmt:message key="res.url" />:</td>
  	    <td>
		  <input type="text" id="data_c_name" name="url" value="" />
  	    </td>
  	    <td class="discription"><fmt:message key="res.img" />:</td>
  	    <td>
		   <input type="text" id="data_c_name" name="img_url" value="" />
  	    </td>
      </tr>
      <tr>
          <td class="discription"><fmt:message key="res.modelName" />:</td>
  	      <td>
		     <input type="text" id="data_c_name" name="module_name" value="" />
  	      </td>
          <td class="discription"><fmt:message key="res.menu" />:</td>
	      <td>
		     <select name="is_menu" id="select" style="width: 154px;">
		    	<option value="1" selected="selected"><fmt:message key="res.menu1"/></option>
		    	<option value="0"><fmt:message key="res.menu2"/></option>
		  	</select>
	      </td>
	      <td class="discription"><fmt:message key="sys.index" />:</td>
  	  	  <td><input type="text" id="index_order" name="index_order" value="9999" /></td>
    </tr>
    <tr>
	    <td class="discription">
	    	适用角色:
	    </td>
	    <td colspan=3>
	    	<!-- 
	    		设计师 Designer
 *	客服 CustomerService
 *	业务员 Salesman
 *	跟单员 Merchandiser
 *	质检 QualityInspection
 *	配送 Distribution
 *	财务 Financial
 *	部门主管 DepartmentHead
	    	
	    	 -->
	    	<select name="role" style="width: 154px;">
	    		<option value="">所有人</option>
	    		<option value="Designer">设计师</option>
	    		<option value="CustomerService">客服</option>
	    		<option value="Salesman">业务员</option>
	    		<option value="Merchandiser">跟单员</option>
	    		<option value="QualityInspection">质检</option>
	    		<option value="Distribution">配送</option>
	    		<option value="Financial">财务</option>
	    		<option value="DepartmentHead">部门主管</option>
	    	</select>
	    </td>
	    </tr>
    <tr>
	    <td class="discription">
	    	<fmt:message key="res.parent" />:
	    </td>
	    <td>
	    	<input type=hidden id="parent1" name=parent1 value=""/>
			<input type=text id="parent1Name" name=parent1Name value="" onclick="openDialog()"  style="width: 154px;" class="inputread " readonly/>
	    </td>
	    <td class="discription">
	    	操作:
	    </td>
	    <td colspan=3>
	    	<input type="checkbox" name="childList" value="list::查看"/>列表&nbsp;&nbsp;
	    	<input type="checkbox" name="childList" value="disAdd::添加"/>添加&nbsp;&nbsp;
	    	<input type="checkbox" name="childList" value="disUpdate::编辑"/>编辑&nbsp;&nbsp;
	    	<input type="checkbox" name="childList" value="del::删除"/>删除&nbsp;&nbsp;
	    	<input type="checkbox" name="childList" value="show::查看详细"/>查看详细
	    </td>
    </tr>
    <tr>
	    <td class="discription">
	    	<fmt:message key="res.ps" />:
	    </td>
	    <td colspan="5"><textarea name="ps" style="width:95%;height:200px;"></textarea></td>
  </tr>
</table>
</form>
  </td>
</tr>
</table>
  </body>
</html>
