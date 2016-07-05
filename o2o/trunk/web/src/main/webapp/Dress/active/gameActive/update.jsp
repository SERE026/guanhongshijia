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



<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/gameActive" method="post">
<input type="hidden" name="_method" value="put" />
<input type="hidden" name="active_id" value="${info.active_id }" />
<table cellspacing="0" cellpadding="0" class="tab2">
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
						<a href="<%=request.getContextPath()%>/html/manage/gameActive/list" title="<fmt:message key="button.back"/>">
							<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" />
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong>编辑游戏促销活动</strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>活动主题：
					</td>
					<td>
						<input type="text" id="name" name="name" value="${info.name }" class="noNull" msg="活动主题不能为空！"/>
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
					str += "<input type='hidden' name='imagesrc' value='"+fileName+"'/>&nbsp;";
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
			<div id='${info.img }' style='display: inline;'>
			<input type='hidden' name='imagesrc' value='${info.img }'/>&nbsp;
			<img src="<%=request.getContextPath()%>/upload/${info.img }" height=120 width=240 />
			<a href='#' onclick='removeFiles("${info.img }")'>
			删除
			</a>&nbsp;&nbsp;</div>
		</div>
  	  </td>
  </tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>活动游戏：
					</td>
					<td>
						<select name="game.game_id">
							<c:forEach items="${gameList}" var="game">
								<option value="${game.game_id }" <c:if test="${info.game.game_id==game.game_id }">selected</c:if>>${game.name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>开始日期：
					</td>
					<td>
						<input type="text"  name="bdate" value="${info.bdate }"  class="noNull date" msg="活动开始日期不能为空！"/>
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>结束日期：
					</td>
					<td>
						<input type="text" name="edate" value="${info.edate }"   class="noNull date" msg="活动结束日期不能为空！"/>
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						开始时间：
					</td>
					<td>
						<input type="text"  name="btime"  value="${info.btime }"/>（格式：00:00:00，示例：早上5点开始：05:00:00）
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						结束时间：
					</td>
					<td>
						<input type="text" name="etime"  value="${info.etime }"/>（格式：00:00:00，示例：下午5点结束：17:00:00）
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">
						<span style="color: red;">*</span>内容：
					</td>
					<td>
						<textarea id="context" style="width:800px;height:500px;" name="ps" >${info.ps }</textarea>
					</td>
				</tr>
			</table>
			<div class="gameParamBox">
				<jsp:include page="${info.game.paramUrl}"></jsp:include>
			</div>
		</td>
	</tr>
</table>
</form>
</body>
</html>