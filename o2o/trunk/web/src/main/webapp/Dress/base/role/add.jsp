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
function submit(){
    if($("#role_c_name").val() == ""){
    	sys_alert("<fmt:message key='alert.role_c_name'/>");
    	$("#role_c_name").focus();
    	return;
    }
    if($("#role_e_name").val() == ""){
    	sys_alert("<fmt:message key='alert.role_e_name'/>");
    	$("#role_e_name").focus();
    	return;
    }
    if(document.form1.controlsid.value == ""){
    	sys_alert("<fmt:message key='alert.controlsid'/>");
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
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" />
        </a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
			</a>
		</td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/role/list">
			<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" />
			</a>
		</td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
<tr><td></td></tr>
<tr>

<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/role" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="isSys" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
  	<thead>
	<tr>
		<td colspan="6">
			<strong><fmt:message key="role.add" /></strong>
		</td>
	</tr>
	</thead>
  <tr>
    <td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="role.cname" />：</td>
    <td><input type="text" id="role_c_name" name="role_c_name" value="" /></td>
  </tr>
  <tr>
  	 <td class="discription"><span style="color:#ff0000">*</span><fmt:message key="role.ename" />：</td>
  	  <td><input type="text" id="role_e_name" name="role_e_name" value="" /></td>
  </tr>
	
    <tr>
  	 <td class="discription"><span style="color:#ff0000">*</span><fmt:message key="role.cg" />：</td>
  	  <td >
  	  	<c:forEach var='ControlGroupInfo' items='${ControlGroupInfoList}'>
  	  	<input type="radio" name="controlsid" value="${ControlGroupInfo.id }"/>${ControlGroupInfo.groupName }
  	  	</c:forEach>
  	  </td>
  </tr>
    <tr>
    <td class="discription"><fmt:message key="sys.isJob" />：</td>
    <td>
	     <select name="is_job" style="width: 154px;">
	    	<option value="1" selected="selected"><fmt:message key="button.yes"/></option>
	    	<option value="0"><fmt:message key="button.no"/></option>
	  	</select>
    </td>
    </tr>
    <tr>
  	 <td class="discription"><fmt:message key="sys.index" />：</td>
  	  <td><input type="text" id="index_order" name="index_order" value="9999" /></td>
  </tr>
</table>
</form>
  </td>
</tr>
</table>
  </body>
</html>
