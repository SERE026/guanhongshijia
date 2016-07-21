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
   
    if($("#name").val() == ""){
    	sys_alert("<fmt:message key='alert.name'/>");
    	$("#name").focus();
    	return;
    }
    if($("#role").val() == ""){
    	sys_alert("<fmt:message key='alert.role'/>");
    	return;
    }
    if($("#ognz").val() == ""){
    	sys_alert("<fmt:message key='alert.ognz'/>");
    	return;
    }
    document.form1.submit();
}
function openOgnzDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/ognz/selection?fieldId=ognz&fieldName=ognzName&maxSelect=1&selectedIds="+document.getElementById("ognz").value);
}
function openRoleDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/role/selection?fieldId=role&fieldName=roleName&maxSelect=1&selectedIds="+document.getElementById("role").value);
}
</script>


<form name="form1" action="<%=request.getContextPath()%>/html/manage/user?ognzId=${ognzId }" method="post">
<input type="hidden" name="isDefault" value="0" />
<input type="hidden" name="id" value="${userInfo.login_id }" />
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			
			<input type="hidden" name="_method" value="PUT" />
			<input type="hidden" name="img" value="${userInfo.img}" id="user_img" />
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td class="tab2_tou">
						<a href="javascript:submit();" title="<fmt:message key="button.send"/>">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/submit_btn.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/user/list?ognzId=${ognzId }" title="<fmt:message key="button.back"/>">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" />
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong><fmt:message key="user.update" /></strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.login" />：</td>
					<td style="width: 30%;">${userInfo.login_id}<input name="login_id" type="hidden" value="${userInfo.login_id}"/></td>
					<td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.passwd"/>：</td>
					<td style="width: 30%;"><input id="passwd" name="passwd" type="password"  onblur="resett(this);"/></td>
				</tr>
				<tr>
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.name" />：</td>
					<td><input id="name" name="user_name" type="text" value="${userInfo.user_name }" onblur="resett(this);" /></td>
				
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.mobile" />：</td>
					<td><input id="mobile" name="mobile" value="${userInfo.mobile}" type="text" onblur="resett(this);"/></td>
					</tr>
				<tr>
					<td class="discription"><fmt:message key="user.offTel" />：</td>
					<td><input id="offTel" name="offTel" value="${userInfo.offTel}" type="text" onblur="resett(this);"/></td>
					<td class="discription"><fmt:message key="user.email" />：</td>
					<td><input id="email" name="email" type="text" value="${userInfo.email}" onblur="resett(this);"/></td>
					</tr>
				<tr>
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="sys.isUsed" />：</td>
					<td>
						<select name="isUsed"style="width: 154px;">
							<option value="1" <c:if test="${'1' == userInfo.isUsed}"> selected="selected"</c:if>>
								<fmt:message key="button.yes"/>
							</option>
							<option value="0" <c:if test="${'0' == userInfo.isUsed}"> selected="selected"</c:if>>
								<fmt:message key="button.no"/>
							</option>
						</select>
					</td>
				
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.role" />：</td>
					<td>
						<input type=hidden id="role" name=role value="${userInfo.roles[0].id }"/>
						<input type=text id="roleName" onclick="openRoleDialog()" name=roleName value="${userInfo.roles[0].role_c_name }"style="width: 154px;"  class="inputread " readonly/>
					</td>
				</tr>
				<tr>
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.ognz" />：</td>
					<td >
						<input type=hidden id="ognz" name=ognz value="${userInfo.ognzs[0].id }"/>
						<input type=text id="ognzName" onclick="openOgnzDialog()" name=ognzName value="${userInfo.ognzs[0].ognz_name }" style="width: 154px;" class="inputread " readonly/>
					</td>
				
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="sys.index" />:</td>
  	  	  			<td ><input type="text" id="index_order" name="index_order" value="${userInfo.index_order }" /></td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="sys.ps"/>：</td>
					<td colspan="3"><textarea style="width: 80%;height: 200px;" id="ps" name="ps" onblur="resett(this);">${userInfo.ps}</textarea></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>