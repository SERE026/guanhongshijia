<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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
		showInput();
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
	
	function showInput(){
		$("input[name='list']").each(function(){
			if(this.checked){
				$(this).parent().parent().find("td:eq(3) span").css("display","none");
				$(this).parent().parent().find("td:eq(3) input").css("display","");
			}else{
				$(this).parent().parent().find("td:eq(3) span").css("display","");
				$(this).parent().parent().find("td:eq(3) input").css("display","none");
			}
		})
	}
	function saveIndex(){
		$("#del").attr("action","<%=request.getContextPath()%>/html/manage/brandOrder");
		$("#del input[name='_method']").attr("value","put");
		$("input[name='list']").each(function(){
			if(!this.checked){
				$(this).parent().parent().find("td:eq(3) input").attr("name","s");
			}
		})
		$("#del").submit();
	}
	
</script>




<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/brandOrder/list">
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/brandOrder/disAdd">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_07.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:saveIndex();">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/dfdf.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="javascript:delall();">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_09.gif" border="0" />
							</a>
						</td>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/brandOrder/list">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
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
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/brandOrder/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td><input type="checkbox" id="list" onclick="xz()"/></td>
						<td>品牌名称</td>
						<td>品牌商家名称</td>
						<td>排序</td>
						<td>操作</td>
					</tr>
					</thead>
					<c:forEach var='info' items='${DATA}' varStatus='index'>
						<tr>
							<td><input type="checkbox" name="list"  value="${info.brandOrderId }" onclick="showInput()"/></td>
							<td>
	                          	${info.brand.name}&nbsp;
							</td>
							<td>
	                          	${info.brandMerchants.name}&nbsp;
							</td>
							<td>
	                         <span> ${info.indexs}&nbsp;</span><input type="text" value="${info.indexs }" name="indexs" style="display:none" dataType="int">
							</td>
							<td>
									<a href="javascript:delUrl('<%=request.getContextPath()%>/html/manage/brandOrder/${info.brandOrderId}/del')" class="zhu2">
										删除</a>
							</td>
						</tr>
					</c:forEach>
					<jsp:include page="<%=Constants.PAGE_JSP%>">
						<jsp:param name="url" value="/html/manage/goodsOrder/list" />
					</jsp:include>
				</table>
			</form>
		</td>
	</tr>
</table>
