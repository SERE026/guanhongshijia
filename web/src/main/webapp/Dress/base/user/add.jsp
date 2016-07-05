<%@ page language="java" pageEncoding="UTF-8"%>
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
    if($("#login_id1").val() == ""){
    	sys_alert("<fmt:message key='alert.loginid'/>");
    	$("#login_id1").focus();
    	return;
    }
    if($("#passwd").val() == ""){
    	sys_alert("<fmt:message key='alert.passwd'/>");
    	$("#passwd").focus();
    	return;
    }
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
function chaxun(){
    var id=document.getElementById("login_id1").value;
    $.ajax({
       	url: "<%=request.getContextPath()%>/html/manage/user/"+id+"/c",
       	type:"GET",
       	dataType:"text",
       	success:function(data){
       		if(data == "0"){
       			sys_alert("<fmt:message key='alert.loginid.exist'/>");
        		document.getElementById("login_id1").value = "";
        		return;
       		}
  		}
	});
}
function openOgnzDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/ognz/selection?fieldId=ognz&fieldName=ognzName&maxSelect=1");
}
function openRoleDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/role/selection?fieldId=role&fieldName=roleName&maxSelect=1");
}
</script>


<form name=form1 action="<%=request.getContextPath()%>/html/manage/user" method="post">
<input type="hidden" name="isDefault" value="0" />
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			
			<input type="hidden" name="_method" value="post" />
			<input type="hidden" name="img" value="${userInfo.img}" id="user_img" />
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td class="tab2_tou">
						<a href="javascript:submit();" title="<fmt:message key="button.send"/>">
							<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/user/list?ognzId=${ognzId }" title="<fmt:message key="button.back"/>">
							<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" />
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="4">
						<strong><fmt:message key="user.add" /></strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.login" />：</td>
					<td style="width: 30%;"><input id="login_id1" name="login_id" type="text" onblur="chaxun();resett(this);" /></td>
					<td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.passwd"/>：</td>
					<td style="width: 30%;"><input id="passwd" name="passwd" type="password"  onblur="resett(this);"/></td>
				</tr>
				<tr>
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.name" />：</td>
					<td><input id="name" name="user_name" type="text" onblur="resett(this);" /></td>
					<td class="discription"><fmt:message key="user.mobile" />：</td>
					<td><input id="mobile" name="mobile" type="text" onblur="resett(this);"/></td>
				</tr>
				<tr>	
					<td class="discription"><fmt:message key="user.offTel" />：</td>
					<td><input id="offTel" name="offTel" type="text" onblur="resett(this);"/></td>
					<td class="discription"><fmt:message key="user.email" />：</td>
					<td><input id="email" name="email" type="text" onblur="resett(this);"/></td>
				</tr>
				<tr>
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="sys.isUsed" />：</td>
					<td>
						<select name="isUsed">
							<option value="1">
								<fmt:message key="button.yes"/>
							</option>
							<option value="0">
								<fmt:message key="button.no"/>
							</option>
						</select>
					</td>
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.role" />：</td>
					<td>
						<input type=hidden id="role" name=role value=""/>
						<input type=text id="roleName" name=roleName value=""  class="inputread " onclick="openRoleDialog()" readonly/>
					</td>
				</tr>
				<tr>
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="user.ognz" />：</td>
					<td>
						<input type=hidden id="ognz" name=ognz value="${ognzInfo.id }"/>
						<input type=text id="ognzName" name=ognzName value="${ognzInfo.ognz_name }" class="inputread " onclick="openOgnzDialog()" readonly/>
					</td>
					<td class="discription"><span style="color:#ff0000">*</span><fmt:message key="sys.index" />:</td>
  	  	  			<td><input type="text" id="index_order" name="index_order" value="9999" /></td>
				</tr>
				<tr>
					<td class="discription"><fmt:message key="sys.ps"/>：</td>
					<td colspan="3"><textarea style="width: 80%;height: 200px;" id="ps" name="ps" onblur="resett(this);"></textarea></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>