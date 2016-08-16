<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/top.jsp" %>
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
		if($("#form1").checkall()){
		document.form1.submit();
	}
}
$(function(){
	$("#form1").validate();
	<c:if test="${not empty merchants}">
//		$(".parent").click(function(){
//			openDialogSel("<%=request.getContextPath()%>/html/manage/goodsSort/selection?fieldId=ids&fieldName=names&maxSelect=1");
//			
//		})
	</c:if>
	
})
</script>


<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >
	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/goodsSort/list?parent=${parent.goodsSort_id }">
			<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/goodsSort" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="status" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>添加</strong></td>
  </tr>
  
    <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>商品分类:</td>
  	  <td ><input name="name" id="name"/></td>
  </tr>
  <tr>
     <td class="discription" >上级分类:</td>
  	  <td>
  	  	<input  id="names" class="parent" value="${parent.name }" readonly />
		  <input type="hidden" name="parentGoodsSort_id"  value="${parent.goodsSort_id }" id="ids" class="parent" />
  	  </td>
  </tr>
	  <tr>
		  <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>扩展名称:</td>
		  <td ><input name="extendname" id="extendname"/></td>
	  </tr>
	  <tr>
		  <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>英文名称:</td>
		  <td ><input name="engname" id="engname"/></td>
	  </tr>
	  <tr>
		  <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>英文备注:</td>
		  <td ><input name="engdesc" id="engdesc"/></td>
	  </tr>
	  <tr>
		  <td class="discription" >广告图片:</td>
		  <td >
			  <%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/AC_OETags.js"></script>
			  <script type="text/javascript" src="<%=request.getContextPath()%>/js/fileUpload.js"></script>
			  <!-- 上传附件按钮 -->
			  <script language="JavaScript" type="text/javascript">
				  function removeFiles(fileName){
					  document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
				  }
				  AC_FL_RunContent(
						  "src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
						  "width", "100",
						  "height", "25",
						  "style","margin-top:6px",
						  "id", "fileUpload2",
						  "quality", "high",
						  "bgcolor", "#ffffff",
						  "name", "fileUpload2",
						  "wmode","transparent",
						  "allowScriptAccess","sameDomain",
						  "type", "application/x-shockwave-flash",
						  "pluginspage", "http://www.adobe.com/go/getflashplayer",
						  "flashVars","flexID=g&uploadURL=<%=request.getContextPath()%>/upload/upload.jsp&label=图 片 上 传&succeed=g_completeUpload"
				  );

				  function g_completeUpload(fileName, realName){
					  if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
							  ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
						  var str="";
						  str += "<div id='"+fileName+"' style='display: inline;'>";
						  str += "<input type='hidden' name='advpic' value='"+fileName+"'/>";
						  str += "<img src=\"<%=request.getContextPath()%>/upload/goods/"+fileName+"\" height=120 width=240 />";
						  str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
						  str += "删除";
						  str += "</a>&nbsp;&nbsp;</div>";
						  document.getElementById("imgUrl3").innerHTML=str;
					  }else{
						  alert("请上传图片。");
					  }
				  }
			  </script>--%>
				  <script type="text/javascript" src="<%=request.getContextPath()%>/js/AC_OETags.js"></script>
				  <script type="text/javascript" src="<%=request.getContextPath()%>/js/fileUpload.js"></script>
				  <!-- 上传附件按钮 -->
				  <script language="JavaScript" type="text/javascript">
					  var imageCount=0;
					  function removeFiles(fileName){
						  document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
					  }
					  AC_FL_RunContent(
							  "src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
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
							  "flashVars","flexID=g&uploadURL=<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/file/uploadgoods.jsp&label=图 片 上 传&succeed=g_completeUpload"
					  );
					  /**
					   上传产品照片
					   **/
					  function g_completeUpload(fileName, realName){
						  if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
								  ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
							  var str="";
							  str += "<div id='"+fileName+"' style='display: inline;'>";
							  str += "<input type='hidden' name='advpic' value='"+fileName+"'/>";
							  str += "<img src=\"<%=request.getContextPath()%>/upload/goods/"+fileName+"\" height=120 width=240 />";
							  str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
							  str += "删除";
							  str += "</a>&nbsp;&nbsp;</div>";
							  document.getElementById("imgUrl3").innerHTML=str;
						  }else{
							  alert("请上传图片。");
						  }
					  }
				  </script>

			  <div  id="imgUrl3">

			  </div>
		  </td>
	  </tr>

	  <tr>
		  <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>广告图片链接:</td>
		  <td ><input name="advlink" id="advlink"/></td>
	  </tr>

	  <tr>
		  <td class="discription" >大图:</td>
		  <td >
			  <%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/AC_OETags.js"></script>
			  <script type="text/javascript" src="<%=request.getContextPath()%>/js/fileUpload.js"></script>
			  <!-- 上传附件按钮 -->
			  <script language="JavaScript" type="text/javascript">
				  function removeFiles(fileName){
					  document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
				  }
				  AC_FL_RunContent(
						  "src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
						  "width", "100",
						  "height", "25",
						  "style","margin-top:6px",
						  "id", "fileUpload1",
						  "quality", "high",
						  "bgcolor", "#ffffff",
						  "name", "fileUpload1",
						  "wmode","transparent",
						  "allowScriptAccess","sameDomain",
						  "type", "application/x-shockwave-flash",
						  "pluginspage", "http://www.adobe.com/go/getflashplayer",
						  "flashVars","flexID=b&uploadURL=<%=request.getContextPath()%>/upload/upload.jsp&label=图 片 上 传&succeed=b_completeUpload"
				  );

				  function b_completeUpload(fileName, realName){
					  if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
							  ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
						  var str="";
						  str += "<div id='"+fileName+"' style='display: inline;'>";
						  str += "<input type='hidden' name='largeimg' value='"+fileName+"'/>";
						  str += "<img src=\"<%=request.getContextPath()%>/upload/goods/"+fileName+"\" height=120 width=240 />";
						  str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
						  str += "删除";
						  str += "</a>&nbsp;&nbsp;</div>";
						  document.getElementById("imgUrl1").innerHTML=str;
					  }else{
						  alert("请上传图片。");
					  }
				  }
			  </script>--%>
				  <script type="text/javascript" src="<%=request.getContextPath()%>/js/AC_OETags.js"></script>
				  <script type="text/javascript" src="<%=request.getContextPath()%>/js/fileUpload.js"></script>
				  <!-- 上传附件按钮 -->
				  <script language="JavaScript" type="text/javascript">
					  var imageCount=0;
					  function removeFiles(fileName){
						  document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
					  }
					  AC_FL_RunContent(
							  "src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
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
							  "flashVars","flexID=b&uploadURL=<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/file/uploadgoods.jsp&label=图 片 上 传&succeed=b_completeUpload"
					  );
					  /**
					   上传产品照片
					   **/
					  function b_completeUpload(fileName, realName){
						  if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
								  ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
							  var str="";
							  str += "<div id='"+fileName+"' style='display: inline;'>";
							  str += "<input type='hidden' name='largeimg' value='"+fileName+"'/>";
							  str += "<img src=\"<%=request.getContextPath()%>/upload/goods/"+fileName+"\" height=120 width=240 />";
							  str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
							  str += "删除";
							  str += "</a>&nbsp;&nbsp;</div>";
							  document.getElementById("imgUrl1").innerHTML=str;
						  }else{
							  alert("请上传图片。");
						  }
					  }
				  </script>
			  <div  id="imgUrl1">

			  </div>
		  </td>
	  </tr>
	  <tr>
		  <td class="discription">是否直接显示子类：</td>
		  <td>
			  <select name="extendshow" style="width: 154px;">
				  <option value="0" selected="selected">否</option>
				  <option value="1">是</option>
			  </select>
		  </td>
	  </tr>
  <c:if test="${empty merchants}">
	  <tr>
	     <td class="discription" ><span style="color:#ff0000">*</span>类型:</td>
	  	  <td >
	  	  	<select name="type.goodsType_id" class="noNull" style="width: 154px;">
	  	  		<c:forEach items="${typeList}" var="type">
	  	  			<option value="${type.goodsType_id }">${type.name }</option>
	  	  		</c:forEach>
	  	  	</select>
	  	  </td>
	  </tr>
  </c:if>
  
  <tr>
     <td class="discription" >分类图片:</td>
  	  <td >
  	  	<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/AC_OETags.js"></script>
   		<script type="text/javascript" src="<%=request.getContextPath()%>/js/fileUpload.js"></script>
		<!-- 上传附件按钮 -->
		<script language="JavaScript" type="text/javascript">
		function removeFiles(fileName){
			document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
		}
		AC_FL_RunContent(
			"src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
			"width", "100",
				"height", "25",
				"style","margin-top:6px",
			"id", "fileUpload",
			"quality", "high",
			"bgcolor", "#ffffff",
			"name", "fileUpload",
			"wmode","transparent",
			"allowScriptAccess","sameDomain",
			"type", "application/x-shockwave-flash",
			"pluginspage", "http://www.adobe.com/go/getflashplayer",
			"flashVars","flexID=d&uploadURL=<%=request.getContextPath()%>/upload/upload.jsp&label=图 片 上 传&succeed=d_completeUpload"
		);
		
		function d_completeUpload(fileName, realName){
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
		</script>--%>
		  <script type="text/javascript" src="<%=request.getContextPath()%>/js/AC_OETags.js"></script>
		  <script type="text/javascript" src="<%=request.getContextPath()%>/js/fileUpload.js"></script>
		  <!-- 上传附件按钮 -->
		  <script language="JavaScript" type="text/javascript">
			  var imageCount=0;
			  function removeFiles(fileName){
				  document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
			  }
			  AC_FL_RunContent(
					  "src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
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
					  "flashVars","flexID=d&uploadURL=<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/file/uploadgoods.jsp&label=图 片 上 传&succeed=d_completeUpload"
			  );
			  /**
			   上传产品照片
			   **/
			  function d_completeUpload(fileName, realName){
				  if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
						  ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
					  var str="";
					  str += "<div id='"+fileName+"' style='display: inline;'>";
					  str += "<input type='hidden' name='imagesrc' value='"+fileName+"'/>";
					  str += "<img src=\"<%=request.getContextPath()%>/upload/goods/"+fileName+"\" height=120 width=240 />";
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
		  <td class="discription" >APP显示图片:</td>
		  <td >
			  <%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/AC_OETags.js"></script>
			  <script type="text/javascript" src="<%=request.getContextPath()%>/js/fileUpload.js"></script>
			  <!-- 上传附件按钮 -->
			  <script language="JavaScript" type="text/javascript">
				  function removeFiles(fileName){
					  document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
				  }
				  AC_FL_RunContent(
						  "src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
						  "width", "100",
						  "height", "25",
						  "style","margin-top:6px",
						  "id", "fileUpload1",
						  "quality", "high",
						  "bgcolor", "#ffffff",
						  "name", "fileUpload1",
						  "wmode","transparent",
						  "allowScriptAccess","sameDomain",
						  "type", "application/x-shockwave-flash",
						  "pluginspage", "http://www.adobe.com/go/getflashplayer",
						  "flashVars","flexID=c&uploadURL=<%=request.getContextPath()%>/upload/upload.jsp&label=图 片 上 传&succeed=c_completeUpload"
				  );

				  function c_completeUpload(fileName, realName){
					  if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
							  ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
						  var str="";
						  str += "<div id='"+fileName+"' style='display: inline;'>";
						  str += "<input type='hidden' name='appImg' value='"+fileName+"'/>";
						  str += "<img src=\"<%=request.getContextPath()%>/upload/goods/"+fileName+"\" height=120 width=240 />";
						  str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
						  str += "删除";
						  str += "</a>&nbsp;&nbsp;</div>";
						  document.getElementById("imgUrl2").innerHTML=str;
					  }else{
						  alert("请上传图片。");
					  }
				  }
			  </script>--%>
				  <script type="text/javascript" src="<%=request.getContextPath()%>/js/AC_OETags.js"></script>
				  <script type="text/javascript" src="<%=request.getContextPath()%>/js/fileUpload.js"></script>
				  <!-- 上传附件按钮 -->
				  <script language="JavaScript" type="text/javascript">
					  var imageCount=0;
					  function removeFiles(fileName){
						  document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
					  }
					  AC_FL_RunContent(
							  "src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
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
							  "flashVars","flexID=c&uploadURL=<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/file/uploadgoods.jsp&label=图 片 上 传&succeed=c_completeUpload"
					  );
					  /**
					   上传产品照片
					   **/
					  function c_completeUpload(fileName, realName){
						  if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
								  ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
							  var str="";
							  str += "<div id='"+fileName+"' style='display: inline;'>";
							  str += "<input type='hidden' name='appImg' value='"+fileName+"'/>";
							  str += "<img src=\"<%=request.getContextPath()%>/upload/goods/"+fileName+"\" height=120 width=240 />";
							  str += "<a href='#' onclick='removeFiles(\""+fileName+"\")'>";
							  str += "删除";
							  str += "</a>&nbsp;&nbsp;</div>";
							  document.getElementById("imgUrl2").innerHTML=str;
						  }else{
							  alert("请上传图片。");
						  }
					  }
				  </script>
			  <div  id="imgUrl2">

			  </div>
		  </td>
	  </tr>
    <tr>
     <td class="discription" ><span style="color:#ff0000">*</span>排序:</td>
  	  <td >
  	  	<input name="index" type="text" dataType="int" class="noNull" msg="排序" value="999" />
  	  </td>
  </tr>
  
</table>
</form>
</td>
</tr>
</table>
  </body>
</html>
