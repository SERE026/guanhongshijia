<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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

<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/kua.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/human2.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/DlyTypeInput.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/Eop.Dialog.Remote.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/eop.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/jquery.checktree.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/style/SelectTree.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/style/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/jq-dateinput/ui.datepicker.css" title="win2k-cold-1" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/input.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/grid.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/validate.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/dialog.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/jquery.treeview.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/checktree.css" />
<script type="text/javascript">
var falg = true;	
function submit(){
	var isSub = $("#form1").checkall();
	   if(returned==0){
		$("#areaid").val(areaid);
		$("#areaname").val(areaname);
		}
		if(falg&&isSub){
		 document.form1.submit();
		 falg = false;
		}
   
}
function openRoleDialog(){
	openDialogSel("<%=request.getContextPath()%>/html/manage/role/selection?fieldId=role&fieldName=roleName&maxSelect=1&selectedIds="+document.getElementById("role").value);
}
$(function(){
	areaname="";
	areaid="";
	returned=0;
	areagroupname="0";
	areagroupid="0";
   $("#form1").validate();
   DlyTypeInput.init();
   $(".areaGroupId").onChange(function(){
    var id=document.getElementById("areaGroupId").value;
      $.ajax({
       	url: "<%=request.getContextPath()%>/html/manage/user/"+id+"/address",
       	type:"GET",
       	dataType:"text",
       	success:function(data){
       		if(data == "0"){
       			alert("该地区已有代理商！");
        		document.getElementById("login_id").value = "";
        		return;
       		}
  		}
	});
     });
	});
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/dialog.js"></script>


<form name="form1" id="form1" action="<%=request.getContextPath()%>/html/manage/daili" method="post">
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="PUT" />
			<input type="hidden" name="id" value="${info.login_id }" /> 
			<input type="hidden" name="areaname" id="areaname" value=""/>
            <input type="hidden" name="areaid" id="areaid" value=""/>
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
						<a href="<%=request.getContextPath()%>/html/manage/daili/list" title="<fmt:message key="button.back"/>">
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
					<td colspan="4">
						<strong>编辑代理商</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" >
								<span style="color: red;">*</span>代理商名称：
							</td>
							<td>
								&nbsp;<input type="text" id="user_name" value="${info.user_name }" name="user_name" class="noNull" msg="代理商名称不能为空！"/>
							</td>
						</tr>
						<tr>
							<td class="discription"><span style="color:#ff0000">*</span>登录账户：</td>
							<td>
							${info.login_id }
							</td>
						</tr>
						<tr>
							<td class="discription" >
								<span style="color: red;">*</span>登录密码：
							</td>
							<td>
								<input type="password" id="passwd" name="passwd" value=""/>
							</td>
						</tr>
						
						
						
						<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>联系人：
							</td>
							<td>
								<input type="text" id="contactName" name="contactName" value="${info.ps }" class="noNull"   msg="联系人不能为空！"/>
							</td>
							
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>联系电话：
							</td>
						
							<td>
								<input type="text" id="mobile" name="mobile" value="${info.mobile }" dataType="mobile"  class="noNull"   msg="联系电话不能为空！" />
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>代理区域：
							</td>
						
							<td>
			                  	 <input type="text"  disabled="true"  readonly="true" name="areaGroupName" dataType="string" required="true" class="noNull"   msg="区域不能为空！"/>
			                     <input type="hidden"  disabled="true" id="areaGroupId" name="areaGroupId" />
			                     <img border="none" class="editAreaImg" title="编辑地区" alt="编辑地区" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/liu1.jpg" class="regionSelect"/>
							</td>
						</tr>
			</table>
		</td>
	</tr>
</table>
</form>
<div id="area_selected">
<ul class="checktree" style="margin-left: 15px;">
</ul>
<div class="footContent" >
<div style="width: 200px; height: 40px; margin: 0pt auto;"
	class="mainFoot">
<table style="margin: 0pt auto; width: auto;">
	<tbody>
		<tr>
			<td><b class="save">
			<button class="submitBtn">保存</button>
			</b></td>
		</tr>
	</tbody>
</table>
</div>
</div> 
</div>