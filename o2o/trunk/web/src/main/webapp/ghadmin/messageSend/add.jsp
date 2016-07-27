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
		 document.form1.submit();
		 falg = false;
		}
   
}
$(function(){
	   $("#form1").validate();
	});
</script>



<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/messageSend" method="post">
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
							<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/messageSend/list" title="<fmt:message key="button.back"/>">
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
					<td colspan="6">
						<strong>添加消息推送</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>标题：
							</td>
							<td>
								&nbsp;<input type="text" id="title" name="title" dataType="noNull"/>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>内容：
							</td>
							<td>
								&nbsp;<textarea rows="10" cols="100" name="context" dataType="noNull"></textarea>
							</td>
						</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>