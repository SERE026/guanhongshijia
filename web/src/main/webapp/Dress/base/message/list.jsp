<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	var i=1;

	function allChoose(){
		$("[name='list']").attr("checked",'true');
	}
	
	function allCancel(){
		$("[name='list']").removeAttr("checked");
	}
	function xz(){
	
		if(i==1){
			allChoose();
			i=0;
		}else{
			allCancel();
			i=1;
		}
	}
	function delall(){
		if(confirm("请确认是否执行删除操作!"))
			document.getElementById("del").submit();
	}
	function delUrl(url){
		if(confirm("请确认是否执行删除操作!")){
			window.location=url;
		}
	}
	function cz(){
		 document.getElementById("czlist").submit();
	}
</script>


<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
		
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/message/list">
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/message/disAdd">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_07.gif"border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/message/list">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
						</tr>
					
					
				</table>
			</form>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/message/delall">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td>消息标题</td>
						<td>发布人</td>
						<td>接收人</td>
						<td><br /></td>
					</tr>
					</thead>
					<c:forEach var='info' items='${DATA}' varStatus='index'>
						<tr>
							<td>${info.title}&nbsp;</td>
							<td>${info.user.user_name}&nbsp;</td>
							<td><c:forEach items="${info.accaptList}" var="accapt">
								<span style="<c:if test="${accapt.status==0 }">color:#000000</c:if><c:if test="${accapt.status==1 }">color:#ff0000</c:if>">
								${accapt.user.user_name }、  	  
								</span>	
					  	  	</c:forEach>&nbsp;</td>
							<td>
								<a href="<%=request.getContextPath()%>/html/manage/message/${info.id}/show"
									class="zhu2"><fmt:message key="button.show" /></a>&nbsp;
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/customer/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>
</html>