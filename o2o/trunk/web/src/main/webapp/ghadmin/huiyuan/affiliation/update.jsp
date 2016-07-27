<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/taglib/fmt.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglib/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglib/fn.tld"%>
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

<fmt:setBundle basename="locale" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><fmt:message key="sys.name" /></title>
<link href="<%=request.getContextPath()%>/css/kua.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/human2.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/layer/lib.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<style type="text/css">
	.error{color:#ff0000;}
</style>
</head>
<body>
<script type="text/javascript">
var servicePath="<%=request.getContextPath()%>";
function submit(){
      	if( $("form1").checkall())
		 	document.form1.submit();
}
$(function(){
   
   $("form1").validate();
});

</script>
<body>
<script src="<%=request.getContextPath()%>/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/huiyuan/affiliation/merchantOrder.js"></script>
<form name="form1" id="form1" action="<%=request.getContextPath()%>/html/manage/affiliation/update" method="post">
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="PUT" />
			<input type="hidden" id="huiYuan_id" name="huiYuan_id" value="${info.huiYuan_id }" /> 
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
						<a href="<%=request.getContextPath()%>/html/manage/affiliation/huiyuan" title="<fmt:message key="button.back"/>">
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
						<strong>归属管理</strong>
					</td>
				</tr>
				</thead>
				<tr class="sangj">
					<td style="width: 20%;" class="discription">用户账号：</td>
					<td>
						${info.name}&nbsp;
					</td>
					<td style="width: 20%;" class="discription"><span style="color: #ff0000">*</span>
					分配商家：</td>
					<td>
						<input type="hidden" name="huiyuanId" id="huiyuanId" value="${info.huiYuan_id}" />
						<input type="text" name="shangName" id="shangName" msg="请选择分配商家。" class="noNull" mappendBy="shangId" value="${info.shangJiaInfo.name}"/>
	                	<input type="hidden" name="shangId" id="shangId" value="${info.shangJiaInfo.shangjia_id}" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
<div id="boxpro" class="position" style="display:none;width:350px;position:absolute;z-index:300;height:600px;overflow-y:auto;overflow-x:hidden;background-color:#ffffff;padding:5px;border:#cccccc solid 2px;">
   		
   </div>
</body>
