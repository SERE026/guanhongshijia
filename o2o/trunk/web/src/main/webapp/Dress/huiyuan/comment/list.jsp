<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/top.jsp"%>
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
$(function(){
		$("#post").validate();
	}) ;
function submit(){
	if($("#form1").checkall()){
		$("#del").attr("action","<%=request.getContextPath()%>/html/manage/comment/indexs");
		document.getElementById("del").submit();
	}
}
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
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dialog.js"></script>



<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/comment/list">
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
						<a href="javascript:submit();" title="<fmt:message key="button.send"/>">
							<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" />
						</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/comment/list">
								<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">晒单人：</td>
						<td><input name="name" type="text" style="color:#494949" value="${name }"/></td>
						<td class="chazhaofanshi1">商品名称：</td>
						<td><input name="userName" type="text" style="color:#494949" value="${userName }"/></td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/img/222.gif" border="0" /></a>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<form method="post" id="del" name="form2" action="<%=request.getContextPath()%>/html/manage/comment/delall">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td style="width:30px;"><input name="" type="checkbox" value="" onclick="xz();" /></td>
						<td>晒单人 </td>
						<td>晒单商品</td>
						<td>晒单内容</td>
						<td>排序</td>
						<td>操作</td>
					</tr>
					</thead>
				    	<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input  name="id" type="hidden" value="${Info.comment_id}" />
								<input id="list" name="list" type="checkbox" value="${Info.comment_id}" />
							</td>
							<td>
							<c:if test="${empty Info.info.userName}">
							${Info.info.name}&nbsp;
	                        </c:if>		
	                        <c:if test="${not empty Info.info.userName}">
							${Info.info.userName}&nbsp;
	                        </c:if>				
							</td>
							<td>${Info.ginfo.name}&nbsp;</td>
							<td>
								<c:forEach items="${fn:split(Info.imageSrc,';')}" var="img">
									<img src="<%=request.getContextPath()%>/upload/issue/${img }" width="50px" height="50px"/>
								</c:forEach>
							</td>
								<td><input type="text" name="count" dataType="int" value="${Info.indexs}"/>&nbsp;</td>
							<td>
							  <a href="<%=request.getContextPath()%>/html/manage/comment/${Info.comment_id}/disUpdate" class="zhu2">
								     编辑</a>&nbsp;
							  <a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/comment/${Info.comment_id}/del')" class="zhu2">
								     删除</a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/admin-inc/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/comment/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
</body>