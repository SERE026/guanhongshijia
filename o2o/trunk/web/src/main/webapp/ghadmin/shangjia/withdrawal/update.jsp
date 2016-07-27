<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" pageEncoding="UTF-8"%>
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

<script type="text/javascript">

var falg = true;
function submit(){
	var isSub = $("#form1").checkall();
    if(falg&&isSub){
    	var data="phone="+$("#contactPhone").val();
    		data+="&id=${info.login_id }";
       	resultAjax("<%=request.getContextPath()%>/html/manage/withdrawal/ch/list",data,phoneYz,"json");
		 
		
	}
}
function phoneYz(data){
	if(data.status==0){
		 document.form1.submit();
		 falg = false;
	}else{
		alert("手机号码已经存在！");
	}
} 

function openRoleDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/role/selection?fieldId=role&fieldName=roleName&maxSelect=1&selectedIds="+document.getElementById("role").value);
}
$(function(){
	   $("#form1").validate();
	});
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/dialog.js"></script>


<form name="form1" id="form1" action="<%=request.getContextPath()%>/html/manage/withdrawal" method="post">
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="PUT" />
			<input type="hidden" name="id" value="${info.login_id }" /> 
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td class="tab2_tou">
						<a href="javascript:submit();" title="<fmt:message key="button.send"/>">
							<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/withdrawal/list" title="<fmt:message key="button.back"/>">
							<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" />
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
					<td colspan="4">
						<strong>编辑</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" >
								<span style="color: red;">*</span>商家名称：
							</td>
							<td>
								<input type="text" id="shangjiaName" name="shangjiaName" value="${info.shanfJiaInfo.name }" class="noNull" msg="商家名称不能为空!"/>
							</td>
							<td class="discription"><span style="color:#ff0000">*</span>商家类型：</td>
							<td>
							&nbsp;<input type="radio" name="sort" value="0" <c:if test="${info.shanfJiaInfo.sort==0 }">checked</c:if>/>连锁实体店
								&nbsp;<input type="radio" name="sort" value="1" <c:if test="${info.shanfJiaInfo.sort==1 }">checked</c:if>/>加盟店
							</td>
						</tr>
						
						
						<tr>
							<td class="discription" >
								<span style="color: red;">*</span>商家账户：
							</td>
							<td style="width: 150px;">
								${info.login_id }
							</td>
							<td class="discription" >
								<span style="color: red;">*</span>登录密码：
							</td>
							<td>
								<input type="password" id="passwd" name="passwd" />
							</td>
						</tr>
						
						
						<tr>
							<td class="discription" >
								<span style="color: red;">*</span>联系人：
							</td>
							<td>
								<input type="text" id="contactName" name="contactName" value="${info.shanfJiaInfo.contactName }" class="noNull" msg="联系人不能为空!"/>
							</td>
							<td class="discription" >
								<span style="color: red;">*</span>联系电话：
							</td>
							<td>
								<input type="text" id="contactPhone" name="contactPhone" value="${info.shanfJiaInfo.contactPhone }" dataType="mobile"   class="noNull" msg="联系电话不能为空!"/>
							</td>
						</tr>
						
						
						<tr>
							<td class="discription"><span style="color:#ff0000">*</span>商家类型：</td>
							<td colspan=3>
								<select name="type_id">
									<c:forEach items="${merchantTypeList}" var="type">
										<option value="${type.type_id }" <c:if test="${info.shanfJiaInfo.type.type_id==type.type_id }">selected</c:if>>${type.name }</option>
									</c:forEach>
									
								</select>
							</td>
						</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>