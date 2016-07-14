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

<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/kindeditor.js"></script>

<script type="text/javascript">
	$(function(){
		$(".ke-toolbar-outer").parent("td").css("")
	})
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
	});
KE.show({id : 'context',
			imageUploadJson:'<%=request.getContextPath()%>/Dress/js/plugins/file.jsp'
	});
</script>



<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/discountActive" method="post">
<table cellspacing="0" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="post" />
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
						<a href="<%=request.getContextPath()%>/html/manage/discountActive/list" title="<fmt:message key="button.back"/>">
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
						<strong>添加商品打折活动</strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>活动主题：
					</td>
					<td>
						<input type="text" id="name" name="name" class="noNull" msg="活动主题不能为空！"
						/>
					</td>
				</tr>
				 <tr style="display:none">
     <td class="discription" >活动图片:</td>
  	  <td >
  	  	<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/AC_OETags.js"></script>
   		<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/fileUpload.js"></script>
		<!-- 上传附件按钮 -->
		<script language="JavaScript" type="text/javascript">
		function removeFiles(fileName){
			document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
		}
		AC_FL_RunContent(
			"src", "<%=request.getContextPath()%>/Dress/swf/fileUpload",
			"width", "100",
			"height", "30",
			"id", "fileUpload",
			"quality", "high",
			"bgcolor", "#ffffff",
			"name", "fileUpload",
			"wmode","transparent",
			"allowScriptAccess","sameDomain",
			"type", "application/x-shockwave-flash",
			"pluginspage", "http://www.adobe.com/go/getflashplayer",
			"flashVars","flexID=a&uploadURL=<%=request.getContextPath()%>/upload/upload.jsp&label=图 片 上 传&succeed=a_completeUpload"
		);
		
		function a_completeUpload(fileName, realName){
			if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
			 ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
					var str="";
					str += "<div id='"+fileName+"' style='display: inline;'>";
					str += "<input type='hidden' name='imagesrc' value='"+fileName+"'/>";
					str += "<img src=\"<%=request.getContextPath()%>/upload/"+fileName+"\" height=120 width=240 />";
					str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
					str += "删除";
					str += "</a>&nbsp;&nbsp;</div>";
					document.getElementById("imgUrl").innerHTML=str;
			}else{
				alert("请上传图片。");
			}
		}
		</script>
		<div  id="imgUrl">
			
		</div>
  	  </td>
  </tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>促销方式：
					</td>
					<td>
						<input type="radio" name="type" value="1" checked />减少金额
						<input type="radio" name="type" value="2" />订单折扣
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>促销值：
					</td>
					<td>
						<input type="text"  name="val" dataType="float" class="noNull" msg="促销值不能为空！"
						/>（如果促销方式为减少金额方式，促销值则为减少的金额；如果促销方式为订单折扣，促销值为折扣值。）
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>开始日期：
					</td>
					<td>
						<input type="text"  name="bdate" class="noNull date" msg="活动开始日期不能为空！"/>
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>结束日期：
					</td>
					<td>
						<input type="text" name="edate"  class="noNull date" msg="活动结束日期不能为空！"/>
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						开始时间：
					</td>
					<td>
						<input type="text"  name="btime"  value=""/>（格式：00:00:00，示例：早上5点开始：05:00:00）
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						结束时间：
					</td>
					<td>
						<input type="text" name="etime" value=""/>（格式：00:00:00，示例：下午5点结束：17:00:00）
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>内容：
					</td>
					<td>
						<textarea id="context" style="width:800px;height:500px;" name="ps" ></textarea>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>