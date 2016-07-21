<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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
   $("#zffs").change(function(){
   		if($(this).val()==0){
   			$(".sm:eq(0) span").html("支付宝合作伙伴id:");
   			$(".sm:eq(0) input").attr("msg","支付宝合作伙伴id不能为空！");
   			
   			$(".sm:eq(1) span").html("支付宝安全校验码:");
   			$(".sm:eq(1) input").attr("msg","支付宝安全校验码不能为空！");
   			
   			$(".sm:eq(2) span").html("卖家支付宝帐户:");
   			$(".sm:eq(2) input").attr("msg","卖家支付宝帐户不能为空！");
   			
   			$(".jianchen").remove();
   		}
   		if($(this).val()==1){
   			$(".sm:eq(0) span").html("商户名称:");
   			$(".sm:eq(0) input").attr("msg","商户名称不能为空！");
   			
   			$(".sm:eq(1) span").html("商户代码:");
   			$(".sm:eq(1) input").attr("msg","商户代码不能为空！");
   			
   			$(".sm:eq(2) span").html("商城密匙:");
   			$(".sm:eq(2) input").attr("msg","商城密匙不能为空！");
   			var html="<tr class='jianchen'>";
   				html+='<td class="discription"><span style="color: red;">商户简称：</span></td>';
   				html+='<td><input type="text" id="jianChen" name="jianChen" class="noNull" msg="商户简称不能为空！"/></td>';
   				html+="</tr>";
   			$(".zfsm").before(html);
   		}
   })
});
</script>



<form id="form1" name=form1 action="<%=request.getContextPath()%>/html/manage/zffs" method="post">
<table cellspacing="0" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="post" />
			<input type="hidden" name="status" value="0" />
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td class="tab2_tou">
						<a href="javascript:submit();" title="<fmt:message key="button.send"/>">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/submit_btn.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/zffs/list" title="<fmt:message key="button.back"/>">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" />
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
					<td colspan="4">
						<strong>添加支付方式</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" style="width: 150px;">
								<span>支付方式：</span>
							</td>
							<td>
								 <select id="zffs" name="type" class="noNull" msg="支付方式不能为空！" style="width: 154px;">
								 	<option value="">请选择要添加的支付方式</option>
								 	<option value="0">支付宝即时到帐接口</option>
								 	<option value="1">网银支付接口</option>
								 </select>
							</td>
						</tr>
						<tr>
							<td class="discription">
								<span>支付方式名称：</span>
							</td>
							<td>
								 <input type="text" id="name" name="name" class="noNull"   msg="支付方式名称不能为空！"/>
							</td>
						</tr>
							<tr>
							<td class="discription">
								<span>支付挂件：</span>
							</td>
							<td>
								 <input type="text" id="widget_name" name="widget_name" class="noNull"   msg="支付挂件不能为空！"/>
							</td>
						</tr>
						
						 <tr class="sm">
							<td class="discription">
								<span>支付宝合作伙伴id：</span>
							</td>
							<td>
								 <input type="text" id="zfb_id" name="zfb_id" class="noNull"  msg="支付宝合作伙伴id不能为空！"/>
							</td>
						</tr>
						
						<tr  class="sm">
							<td class="discription">
								<span>支付宝安全校验码：</span>
							</td>
							<td>
								 <input type="text" id="zfb_code" name="zfb_code" class="noNull" msg="支付宝安全校验码不能为空！"/>
							</td>
						</tr>
						<tr  class="sm">
							<td class="discription">
								<span>卖家支付宝帐户：</span>
							</td>
							<td>
								 <input type="text" id="zfb_zhanghao" name="zfb_zhanghao" class="noNull" msg="卖家支付宝帐户不能为空！"/>
							</td>
						</tr>
						
						<tr class="zfsm">
							<td class="discription">
								<span>*</span>支付说明：
							</td>
							<td>
								<input type="text" id="ps" name="ps" class="noNull" msg="支付说明不能为空！"/>
							</td>
						</tr>
						
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>