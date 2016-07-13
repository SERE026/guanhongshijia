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
	$(function (){
		$("#time").datepicker();
	});
</script>





<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">

		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/log/list">
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/log/list">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td>
						<table >
								<tr>
									<td>
										<fmt:message key="log.user" />:
									</td>
									<td>
										<input type="text" name="name" value="${name }"/>
									</td>
									<td>
										<fmt:message key="log.time" />:
									</td>
									<td>
										<input type="text" id="time" name="time" value="${time }" readonly/>
									</td>
									<td>
										<a href="javascript:document.form1.submit();"><img src="<%=request.getContextPath()%>/Dress/img/222.gif" border="0" /></a>
									</td>
								</tr>
								
							</table>
						</td>
					</tr>
					
					
				</table>
			</form>
		</td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/log/del/all">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td style="width:30px;"><input name="" type="checkbox" value="" onclick="xz();" /></td>
						<td><fmt:message key="log.user" /></td>
						<td><fmt:message key="log.time" /></td>
						<td><fmt:message key="log.ip" /></td>
						<td><fmt:message key="log.info" /></td>
						<td><fmt:message key="sys.control" /></td>
					</tr>
					</thead>
					<c:forEach var='info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${info.id}" />
							</td>
							<td>${info.user.email}&nbsp;</td>
							<td>${info.time}&nbsp;</td>
							<td>${info.ip}&nbsp;</td>
							<td>${info.info}&nbsp;</td>
							<td>
								<a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/log/del/${info.id}');"
									class="zhu2"><fmt:message key="button.del" /></a>&nbsp;
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/log/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/jqueryUI/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/jqueryUI/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/jqueryUI/jquery.ui.datepicker-zh-CN.js"></script>

</body>
</html>