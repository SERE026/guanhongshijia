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
function submit(){
      	if( $("form1").checkall())
		 	document.form1.submit();
}
$(function(){
   
   $("form1").validate();
});

function delUrl(url){
		if(confirm("请确认是否执行删除操作!")){
			window.location=url;
		}
	}
</script>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/dialog.js"></script>
<form name="form1" action="<%=request.getContextPath()%>/html/manage/comment/update" method="post">
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="PUT" />
			<input type="hidden" name="comment_id" value="${info.comment_id }" /> 
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
						<a href="<%=request.getContextPath()%>/html/manage/comment/list" title="<fmt:message key="button.back"/>">
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
						<strong>回复</strong>
					</td>
				</tr>
				</thead>
				<tr class="sangj">
				<td style="width: 10%;" class="discription">评论人：</td>
					<td>
						${info.info.userName}&nbsp;
					</td>
				</tr>
				<tr class="sangj">
				<td style="width: 10%;" class="discription">评论内容：</td>
					<td>
						${info.saycontent}&nbsp;
					</td>	
				</tr>
					<tr class="sangj">
				<td style="width: 10%;" class="discription">晒单商品：</td>
					<td>
						${info.ginfo.name}&nbsp;
					</td>
				</tr>
					<tr class="sangj">
				<td style="width: 10%;" class="discription">晒单内容：</td>
					<td>
								<c:forEach items="${fn:split(info.imageSrc,';')}" var="img">
									<img src="<%=request.getContextPath()%>/upload/issue/${img }" width="50px" height="50px"/>
								</c:forEach>
					</td>	
				</tr>
				
			</table>
		</td>
	</tr>
	<tr>
		<td>
		<table cellspacing="0" cellpadding="0" class="table4_da" style="margin-top: 10px;">
			<thead>
					<tr>
						<td>评论人</td>
						<td>评论内容</td>
						<td>操作</td>
					</tr>
					</thead>
				<c:forEach items="${info.say}" var="say">
					<tr class="sangj">
						<td>
							${say.info.name }
						</td>
						<td>
							${say.content }
						</td>
							<td>
							  <a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/comment/${info.comment_id}/${say.say_id}/delsay')" class="zhu2">
								     删除</a>
							</td>
					</tr>
				</c:forEach>
			</table>
		</td>
	</tr>
</table>
</form>
</body>