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
function submit(){
	if($("#form2").checkall()){
		document.form2.submit();
	}
	}
	$(function(){
	   $("#form2").validate();
	   <c:if test="${C_STATUS==1}">
		alert("启用成功");
	  </c:if>
	});
	function cz(){
		document.getElementById("czlist").submit();
	}
	
	
	
</script>
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr><td></td></tr>
	<tr>
		<td class="tab2_top">
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="jflist" name="jflist" action="<%=request.getContextPath()%>/html/manage/jfadd/list">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="javascript:location.reload();">
								<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" />
							</a>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
			 <div style="border:1px solid #c5c5c5;height:auto;width:440px;float:left">
				<form  id="form2" name="form2" action="<%=request.getContextPath()%>/html/manage/jfadd/ok" method="post">
		  
					<table cellspacing="0" cellpadding="0" style="border:1px solid #c5c5c5;height:100px;" width="100%" class="integral">
						<thead>
						<tr>
							<td colspan="6" style="background-color:#cbf1ff;height:30px;padding-left: 10px;">
								<strong>积分增加方案</strong>
							</td>
						</tr>
						</thead>
				      <c:forEach items="${info}" var="Info" varStatus='index'>
						 <tr>
						         <td><input name="id" type="hidden" value="${Info.jfadd_id}" /></td>
							    <td>${Info.jfadd_name}：</td>
							    <td><input name="zjjf" type="text" style="width:50px;"  class="noNull" msg="积分增加方案中有空,不能提交！" dataType="int" value="${Info.jfadd_zjjf}"   />订单金额的%</td>
						</tr>
						</c:forEach>
						<tr>
						<td colspan="3" align="center"><a href="javascript:submit()" class="zhu2">启用</a>&nbsp;</td>	
						</tr>
				 </table>
				 </form>
				 </div>
	

	<div style="border:1px solid #c5c5c5;height:autopx;width:400px;float:left;margin-left:20px;">
				<table cellspacing="0" cellpadding="0" style="border:1px solid #c5c5c5;height:100px;" width="100%">
				<thead>
				<tr>
					<td colspan="6" style="background-color:#cbf1ff;height:30px;">
						<strong>积分与现金兑换方案</strong>
					</td>
				</tr>
				</thead>
					<thead>
					<tr>
						<td>每1元等于多少积分</td>
						<td>操作</td>
					</tr>
					</thead>
						 <tr>
									<td>
									${Info.jffa_jfdk}积分&nbsp;
								</td>
								<td>
								<a href="<%=request.getContextPath()%>/html/manage/jffa/${Info.jffa_id}/disUpdate" class="zhu2">
									<fmt:message key="button.update" /></a>&nbsp;
							</td>
						</tr>
				</table>
				</div>
		</td>
	</tr>

	<tr><td></td></tr>
	
	
	<tr>
		<td>
		<form method="post" id="czlist" name="form1"  action="<%=request.getContextPath()%>/html/manage/jfadd/list">
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0" class="table4_da" style="float:left;">
				<thead>
				<tr>
					<td colspan="7">
						<strong>会员信息查看</strong>
					</td>
				</tr>
				</thead>
					<tr>
						<td class="chazhaofanshi1" style="text-align: right;padding-right: 10px;">积分查询：</td>
						<td><input name="jf" type="text" style="color:#494949" value="${jf }"/>
						——<input name="jfs" type="text" style="color:#494949" value="${jfs }"/>
						</td>
						<td class="chazhaofanshi1" style="width: 100px;text-align: right;padding-right: 10px;">会员名称：</td>
						<td>
								<input type="text" name="memberName" value="${memberName }" />
						</td>
						<td class="chazhaofanshi1" style="text-align: right;padding-right: 10px;">会员归属商家名称：</td>
						<td>
								<input type="text" name="shangjiaName" value="${shangjiaName }" />
						</td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/Dress/img/222.gif" border="0" /></a>
						</td>
					</tr>
				</table>
			</form>
		<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						
						<td>会员账号</td>	
						<td>会员名称</td>
						<td>会员归属</td>
						<td>会员积分</td>
						<td>最后登录时间</td>
						<td>操作</td>
					</tr>
					</thead>
					<c:forEach items="${DATA}" var="data" varStatus='index'>
						 <tr>
								
								<td>
								${data.name}&nbsp;
								</td>
								<td>
								${data.nickname}&nbsp;
								</td>
								<td>
								${data.shangJiaInfo.name}&nbsp;
								</td>
								<td>
								${data.jf}&nbsp;
								</td>
								<td>
								${data.enterData}&nbsp;	
								</td>
								<td>
								
									<a href="<%=request.getContextPath()%>/html/manage/jfadd/${data.huiYuan_id}/jfUpdate" class="zhu2">
									增加积分</a>&nbsp;
							</td>
						</tr>
						</c:forEach>
						<jsp:include page="/Dress/include/nofenye.jsp">
						<jsp:param name="url" value="/html/manage/daili/list" />
					</jsp:include>
				</table>
			</td>
	</tr>
</table>
