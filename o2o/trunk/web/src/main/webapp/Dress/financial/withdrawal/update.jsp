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



$(function(){
	   $("#form1").validate();
	});
</script>



<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/withdrawalAudit" method="post">
<table cellspacing="0" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="put" />
			<input type="hidden" name="id" value="${info.id }" />
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
						<a href="<%=request.getContextPath()%>/html/manage/withdrawalaudit/list" title="<fmt:message key="button.back"/>">
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
						<strong>申请提现处理</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" style="width: 150px;">
								开户行名称：
							</td>
							<td>
								${info.bankName }
							</td>
						</tr>
						<tr>
							<td class="discription">银行卡号：</td>
							<td>
							     ${info.bankNo }
							</td>
						</tr>
                        <tr>
							<td class="discription">开户名称：</td>
                            <td>
                                ${info.userName }<br/>
                                (商家信息：${info.merchants.name}- ${info.merchants.user.user_name}- ${info.merchants.user.mobile})
                            </td>
						</tr>
						<tr>
                            <td class="discription">提现金额：</td>
                            <td>
                                 ${info.money }<br/>
                                 (商家当前账户余额:${info.merchants.money}元)
                            </td>
                        </tr>
                        <tr>
                            <td class="discription"><span style="color:#ff0000">*</span>交易流水号：</td>
                            <td>
                                <input type="text" name="no" value="" class="noNull" msg="提现金额不能为空!" />
                            </td>
                        </tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>