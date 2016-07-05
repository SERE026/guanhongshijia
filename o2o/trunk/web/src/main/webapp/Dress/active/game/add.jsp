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



<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/game" method="post">
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
						<a href="<%=request.getContextPath()%>/html/manage/game/list" title="<fmt:message key="button.back"/>">
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
						<strong>添加游戏</strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>游戏名称：
					</td>
					<td>
						<input type="text" id="name" name="name" class="noNull" msg="游戏名称不能为空！"
						/>
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>挂件名称：
					</td>
					<td>
						<input type="text"  name="plugin" class="noNull" msg="挂件名称不能为空！"/>
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						游戏参数设置地址：
					</td>
					<td>
						<input type="text"  name="paramUrl"  value="" class="noNull" msg="游戏参数设置地址不能为空！"/>
					</td>
				</tr>
				
				<tr>
					<td class="discription" style="width: 150px;">
						备注：
					</td>
					<td>
						<textarea id="context" style="width:800px;height:500px;" name="ps" ></textarea>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>