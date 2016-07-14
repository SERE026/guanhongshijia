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
$(function(){
	$("#form1").validate();
})
function cz(){
		 document.getElementById("czlist").submit();
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
</script>
<style>
	.table4_da tr td{height:32px!important;}
</style>

<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/bbsPost/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table b="0" cellspacing="0" cellpadding="0">
					<tr>
					 <td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/bbsPost/disAdd">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/bbsPost/list">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" b="0" />
							</a>
						</td>
						<td class="chazhaofanshi1"> 主题：</td>
						<td><input name="title" type="text" style="color:#494949;width:100px; height:15px;" value="${title }"/></td>
						<td></td>
						<td class="chazhaofanshi1">按日期查询：</td>
						<td><input name="btime" type="text" id="btime" readonly onclick="WdatePicker()" class="bianji_3 date" style="font-size: 12px" value="${btime }" />
						-<input name="htime" type="text" id="htime" readonly onclick="WdatePicker()" class="bianji_3 date" style="font-size: 12px;margin-left: 5px;" value="${htime }"/></td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/Dress/img/222.gif" b="0" /></a>
						</td>						
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/bbsPost/del/all">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td  style="width:30px;">
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td>发帖人</td>
						<td>类型</td>
						<td>主题</td>
						<td>内容</td>
						<td>发帖时间</td>
						<td>回复数量</td>
						<td>查看数量</td>
						<td>最后回复时间</td>
						<td>最后回复人</td>
						<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${Info.id}" />
							</td>
							<td>
									${Info.user.name}
							</td>
							<td>
									<c:if test="${Info.flag==0}">网站公告</c:if>
									<c:if test="${Info.flag==1}">网站活动</c:if>
									<c:if test="${Info.flag==2}">自由发帖</c:if>
							</td>
							<td>
									${Info.title}
							</td>
							<td>
								<div style="max-width:300px;max-height:100px;overflow:hidden;">${Info.context}</div>

							</td>
							<td>
								    ${Info.time}
							</td>
							<td>
							        ${Info.hnum}
							</td>
							<td>
							         ${Info.snum}
							</td>
							<td>
								      ${Info.htime}
							</td>
							<td>
							          ${Info.hname.name}
							</td>
							<td>
							   <c:if test="${Info.status==0}">
							   <a href="<%=request.getContextPath()%>/html/manage/bbsPost/${Info.id}/disUpdate" class="zhu2">
									编辑</a>&nbsp;
								<a href="<%=request.getContextPath()%>/html/manage/bbsPost/${Info.id}/audit" class="zhu2">
									审核</a>&nbsp;
								 </c:if>
								<c:if test="${Info.top==0}">
								<a href="<%=request.getContextPath()%>/html/manage/bbsPost/${Info.id}/${Info.top}/first" class="zhu2">
									置顶</a>&nbsp;
									</c:if>
								<c:if test="${Info.top==1}">
								<a href="<%=request.getContextPath()%>/html/manage/bbsPost/${Info.id}/${Info.top}/first" class="zhu2">
									取消置顶</a>&nbsp;
								</c:if>
									<a href="<%=request.getContextPath()%>/html/manage/bbsPost/${Info.id}/del" class="zhu2">
									删除
									</a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/bbsPost/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
