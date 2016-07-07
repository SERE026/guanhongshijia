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
var falg = true;

function submit(){
	var isSub = $("#form1").checkall();
		if(falg&&isSub){
		 document.form1.submit();
		 falg = false;
		}
   
}

function phoneYz(data){
	if(data.status==0){
		submit();
	}else{
		alert("手机号码已经存在！");
	}
}
function chaxun(){
    var id=document.getElementById("login_id").value;
    $.ajax({
       	url: "<%=request.getContextPath()%>/html/manage/user/"+id+"/c",
       	type:"GET",
       	dataType:"text",
       	success:function(data){
       		if(data == "0"){
       			alert("账户已存在");
        		document.getElementById("login_id").value = "";
        		return;
       		}else{
       			submit();
       			//var data="phone="+$("#contactPhone").val();
       			//resultAjax("<%=request.getContextPath()%>/html/manage/shangJiaInfo/ch/list",data,phoneYz,"json");
       		}
  		}
	});
}
function openRoleDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/role/selection?fieldId=role&fieldName=roleName&maxSelect=1");
}

$(function(){
	   $("#form1").validate();
	});
</script>



<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/shangJiaInfo" method="post">
<table cellspacing="0" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="post" />
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td class="tab2_tou">
						<a href="javascript:chaxun();" title="<fmt:message key="button.send"/>">
							<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/shangJiaInfo/list" title="<fmt:message key="button.back"/>">
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
					<td colspan="6">
						<strong>添加商家</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>商家名称：
							</td>
							<td>
								&nbsp;<input type="text" id="shangjiaName" name="shangjiaName" class="noNull" msg="商家名称不能为空!"/>
							</td>
							<td class="discription"><span style="color:#ff0000">*</span>代理商级别：</td>
							<td>
								&nbsp;<select name="agent_grade_id">
								<c:forEach items="${agentGradeList}" var="agentGrade">
									<option value="${agentGrade.id }">${agentGrade.name }</option>
								</c:forEach>
							</select>
							</td>
						</tr>
						
						
						<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>商家账户：
							</td>
							<td>
								&nbsp;<input type="text" id="login_id" name="login_id" class="noNull" msg="商家账户不能为空!"/>
							</td>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>登录密码：
							</td>
							<td>
								&nbsp;<input type="password" id="passwd" name="passwd" class="noNull" msg="登录密码不能为空!"/>
							</td>
						</tr>
						
						
						<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>联系人：
							</td>
							<td>
								&nbsp;<input type="text" id="contactName" name="contactName" class="noNull" msg="联系人不能为空!"/>
							</td>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>联系电话：
							</td>
							
							<td>
								&nbsp;<input type="text" id="contactPhone" name="contactPhone" dataType="mobile"  class="noNull" msg="联系电话不能为空!"/>
							</td>
						</tr>
						
						
						<tr>
						<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>QQ：
							</td>
							<td>
								&nbsp;<input type="text" id="qq" name="qq" dataType="int"  class="noNull" msg="QQ不能为空!"/>
							</td>
							<td class="discription"><span style="color:#ff0000">*</span>商家分类：</td>
							<td colspan=3>
								&nbsp;<select name="type_id">
									<c:forEach items="${merchantTypeList}" var="type">
										<option value="${type.type_id }">${type.name }</option>
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