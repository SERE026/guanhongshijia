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
$(function(){
	$("#form1").validate();
})
function cz(){
		 document.getElementById("czlist").submit();
	}
</script>


<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/volume/order">
				<input type="hidden" name="type" value="${type }" />
				<input type="hidden" name="pageNo" id="pageNo" value="${PAGE_INFO.pageNo}" />
				<table b="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="tab2_tou">
							<a href="<%=request.getContextPath()%>/html/manage/volume/list">
								<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" b="0" />
							</a>
						</td>
						<td></td>
						<td class="chazhaofanshi1">请选择年份：</td>
									<td>
							<select name="year" style="width:100px; height:23px;" >
						  <option value="${year-8 }">${year-8 }年</option>
						  <option value="${year-7 }" >${year-7 }年</option>
						  <option value="${year-6 }" >${year-6 }年</option>
						  <option value="${year-5 }" >${year-5 }年</option>
						  <option value="${year-4 }" >${year-4 }年</option>
						  <option value="${year-3 }" >${year-3 }年</option>
						  <option value="${year-2 }" >${year-2 }年</option>
						  <option value="${year-1 }" >${year-1 }年</option>
						  <option value="${year}" selected>${year }年</option>
						</select>
									</td>
									<td class="chazhaofanshi1">请选择月份：</td>
									<td>
							<select name="month" style="width:100px; height:23px;" >
						  <option value="01" <c:if test="${month==1 }">selected</c:if>>1月份</option>
						  <option value="02" <c:if test="${month==2 }">selected</c:if>> 2月份</option>
						  <option value="03" <c:if test="${month==3 }">selected</c:if>>3月份</option>
						  <option value="04" <c:if test="${month==4 }">selected</c:if>>4月份</option>
						  <option value="05" <c:if test="${month==5 }">selected</c:if>>5月份</option>
						  <option value="06" <c:if test="${month==6 }">selected</c:if>>6月份</option>
						  <option value="07" <c:if test="${month==7 }">selected</c:if>>7月份</option>
						  <option value="08" <c:if test="${month==8 }">selected</c:if>>8月份</option>
						  <option value="09" <c:if test="${month==9 }">selected</c:if>>9月份</option>
						  <option value="10" <c:if test="${month==10 }">selected</c:if>>10月份</option>
						  <option value="11" <c:if test="${month==11 }">selected</c:if>>11月份</option>
						  <option value="12" <c:if test="${month==12 }">selected</c:if>>12月份</option>
						</select>
									</td>
						
						<td class="tab2_tou">
							<a href="javascript:cz();"><img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/222.gif" b="0" /></a>
						</td>						
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
</table>
