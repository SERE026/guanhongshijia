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
	var money=parseFloat($("input[name='money']").val());
	if(falg&&isSub&&money>=100){
	   var data="name="+$("input[name='userName']").val();
	       data+="&money="+$("input[name='money']").val();
	   resultAjax("<%=request.getContextPath()%>/html/manage/withdrawal/ch/list",data,submitYz,"json");
	}
}

function submitYz(data){
    if(data.status==0){
        document.form1.submit();
        falg = false;
    }else{
        alert("很抱歉，申请未能提交失败！失败原因：信息填写错误或者还有未处理的申请。");
    }
}


$(function(){
	   $("#form1").validate();
	});
</script>



<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/withdrawal" method="post">
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
						<a href="<%=request.getContextPath()%>/html/manage/withdrawal/list" title="<fmt:message key="button.back"/>">
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
						<strong>申请提现</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>开户行名称：
							</td>
							<td>
								&nbsp;<input type="text"  name="bankName" class="noNull" msg="开户行名称不能为空!"/>
							</td>
						</tr>
						<tr>
							<td class="discription"><span style="color:#ff0000">*</span>银行卡号：</td>
							<td>
								&nbsp;<input type="text" name="bankNo" value="" dataType="int" class="noNull" msg="银行卡号不能为空!"/>
							</td>
						</tr>
                        <tr>
							<td class="discription"><span style="color:#ff0000">*</span>开户名称：</td>
                            <td>
                                &nbsp;<input type="text" name="userName" value=""  class="noNull" msg="开户名称不能为空!"/>(开户名称必须和商家联系人名称保持一致)
                            </td>
						</tr>
						<tr>
                            <td class="discription"><span style="color:#ff0000">*</span>提现金额：</td>
                            <td>
                                &nbsp;<input type="text" name="money" value="" dataType="float" class="noNull" msg="提现金额不能为空!"/>(当前账号金额：${info.money }元，最低提现金额100元。)
                            </td>
                        </tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>