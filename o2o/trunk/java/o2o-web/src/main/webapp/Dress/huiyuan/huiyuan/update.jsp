<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Dress/include/top.jsp"%>
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
    if( $("form1").checkall()){
    	if($("[password]").val().length>0&&$("[password]").val().length<6){
    		alert("密码长度不能小于六位数！");
    		return ;
    	}
    	
		document.form1.submit();
	}
}
$(function(){
 $("form1").validate();
		address("provinceId","cityId","countyId","<%=request.getContextPath()%>/html/manage/area/json/selection");
	})
</script>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/dialog.js"></script>
<form name="form1" action="<%=request.getContextPath()%>/html/manage/huiyuan/update" method="post">
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="PUT" />
			<input type="hidden" name="huiYuan_id" value="${info.huiYuan_id }" /> 
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
						<a href="<%=request.getContextPath()%>/html/manage/huiyuan/list" title="<fmt:message key="button.back"/>">
							<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" />
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
						<strong>编辑</strong>
					</td>
				</tr>
				</thead>
				<tr class="sangj">
				<td  class="discription">
				 <span style="color: red;">*</span>用户昵称：
				 </td>
					<td >
						<input type="text" name="userName" value="${info.userName}" class="noNull" msg="用户昵称不能为空！"/>
					</td>
				   <td class="discription">用户账号：</td>
					<td>
						${info.name}&nbsp;
					</td>
				</tr>
				<tr>
					<td  class="discription">重置密码：</td>
					<td>
						<input type="text" password name="password" value=""/>
					</td>	
				
				<td  class="discription">注册时间：</td>
					<td>
						${info.loginData}&nbsp;
					</td>	
			</tr>
				<tr class="sangj">
				<td  class="discription">上次登录时间：</td>
					<td>
						${info.enterData}&nbsp;
					</td>	
				<td  class="discription">登录次数：</td>
					<td>
						${info.count}&nbsp;
					</td>
			</tr>
				<tr class="sangj">	
				<td  class="discription">会员等级：</td>
				<td>
					${info.rank}&nbsp;
				</td>
				  <td class="discription" >
								<span style="color: red;">*</span>联系人地址：
							</td>
							<td colspan="3">
								<select name="province.id" id="provinceId" dataval="${info.province.name}">
									<option value="">--请选择--</option>
								</select>
								省
								<select  name="city.id" id="cityId" dataval="${info.city.name}">
									<option value="">--请选择--</option>
								</select>
								市
								<select name="region.id" id="countyId" dataval="${info.region.name}">
									<option value="">--请选择--</option>
								</select>
								区
							</td>
				</tr>
				<tr class="sangj">
				 <td  class="discription">
					     <span style="color: red;">*</span>街道地址：</td>
					<td>
                       <input type="text" name="address" id="address" msg="请输入详细地址。" class="noNull" value="${info.address}"/>
					</td>
				   <td  class="discription">生日：</td>
					<td>
						<input type="text" name="birthday" value="${info.birthday}" dataType="date" class="date"/>
					</td>
			</tr>
				<tr class="sangj">
					<td class="discription">固定电话：</td>
					<td>
						<input type="text" name="shouTel" value="${info.tel}" dataType ="tel_num"/>&nbsp;格式：区号-电话号码-分机号
					</td>
				
				<td  class="discription">邮编：</td>
					<td>
						<input type="text" name="postcode" value="${info.postcode}"/>
					</td>
				</tr>
				<tr class="sangj">
					<td  class="discription">手机：</td>
					<td colspan=3>
						<input type="text" name="phone" value="${info.phone}" dataType="mobile"/>
					</td>
					</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>