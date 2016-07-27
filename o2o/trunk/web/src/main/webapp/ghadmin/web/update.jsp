<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" pageEncoding="UTF-8"%>
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
<c:if test="${not empty C_STATUS&&C_STATUS==1}">
alert("操作成功");
</c:if>
</script>


<Script Language="JavaScript" type="text/JavaScript" src="<%=request.getContextPath()%>/js/colorPicker.js"></Script>


<form name="form1" id="form1" action="<%=request.getContextPath()%>/html/manage/web" method="post">
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="PUT" />
			<input type="hidden" name="web_id" value="${info.web_id }" /> 
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
						<strong>编辑</strong>
					</td>
				</tr>
				</thead>
				<tr>
					<td class="discription" style="width: 150px;">平台名称：</td>
					<td >
						<input name="title" type="text" value="${info.title }"  style="width:300px;" />
					</td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">平台关键字：</td>
					<td ><input name="keyWord" type="text" value="${info.keyWord }" style="width:300px;"  /></td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">平台介绍：</td>
					<td ><input name="description" type="text" value="${info.description }" style="width:500px;" /></td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">网站整体背景色：</td>
					<td ><input name="bgColor" type="text" value="${info.bgColor }" style="width:500px;" /></td>
				</tr>
				<tr>
					<td class="discription" style="width: 150px;">网站背景图片：</td>
					<td >	
						<div id="iamgeBox">
							<c:if test="${not empty info.bgImage}">
								<input type="hidden" name="bgImage" value="${info.bgImage }" ><img src="<%=request.getContextPath()%>/upload/${info.bgImage }" width="100" height="100" >
							</c:if>
						</div>
						<div class="clear"></div>
						<c:if test="${not empty info.bgImage}">
							<a href="javascript:;" class="delBgImage" style="color:#ff0000">删除背景图</a>
						</c:if>
						<div class="clear"></div>
							<div style="width:200px;height:40px;">
								<script type="text/javascript" src="<%=request.getContextPath()%>/js/AC_OETags.js"></script>
						   		<script type="text/javascript" src="<%=request.getContextPath()%>/js/fileUpload.js"></script>
								<!-- 上传附件按钮 -->
								<script language="JavaScript" type="text/javascript">
									var imageCount=0;
									
									AC_FL_RunContent(
										"src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
										"width", "200",
											"height", "25",
											"style","margin-top:12px",
										"id", "fileUpload",
										"quality", "high",
										"bgcolor", "#ffffff",
										"name", "fileUpload",
										"wmode","transparent",
										"allowScriptAccess","sameDomain",
										"type", "application/x-shockwave-flash",
										"pluginspage", "http://www.adobe.com/go/getflashplayer",
										"flashVars","flexID=c&uploadURL=<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/file/upload.jsp&label=图 片 上 传&succeed=a_completeUpload"
									);
									/**
										上传产品照片
									**/
									function c_completeUpload(fileName, realName){
										var html='<input type="hidden" name="bgImage" value="'+fileName+'" ><img src="<%=request.getContextPath()%>/upload/'+fileName+'" width="100" height="100" >';
										$("#iamgeBox").html(html);
									}
									$(".delBgImage").click(function(){
										$("#iamgeBox").html("");
									})
								</script>
								</div>
					</td>
				</tr>
				<tr style="display:none">
				
							<td class="discription" style="width: 150px;">
								相册设置：
							</td>
							<td>
								<table style="width:auto;margin:5px;" id="yiczInfom" cellspacing="0" cellpadding="0" class="table3_da" >
							
										<tr>
											<td class="discription">缩略图尺寸:</td>
											<td>宽<input type="text" name="slt_w" value="${info.slt_w }"  dataType="int"/>px  高<input type="text" name="slt_h" value="${info.slt_h }" dataType="int"/>px</td>
										</tr>
										<tr>
											<td class="discription">商品详细页图片尺寸:</td>
											<td>宽<input type="text" name="goodXX_w" value="${info.goodXX_w }" dataType="int"/>px  高<input type="text" name="goodXX_h" value="${info.goodXX_h }" dataType="int"/>px</td>
										</tr>
										<tr>
											<td class="discription">商品相册图片尺寸:</td>
											<td>
											宽<input type="text" name="good_w" value="${info.good_w }" dataType="int" />px  高<input type="text" name="good_h" value="${info.good_h }" dataType="int"/>px
											</td>
										</tr>
										<tr>
											<td class="discription">开启水印:</td>
											
											<td><input type="radio" name="is_sy" value="1" <c:if test="${info.is_sy==1}">checked</c:if>/>是<input type="radio" name="is_sy" value="0" <c:if test="${info.is_sy==0}">checked</c:if>/>否</td>
										</tr>
										<tr>
											<td class="discription">水印文字:</td>
											
											<td><input type="text" name="sy_name" value="${info.sy_name }" /></td>
														</tr>
														<tr>
															<td class="discription">水印位置:</td>
															<td>
													<table style="width:auto;margin:5px;" id="yiczInfom" cellspacing="0" cellpadding="0" class="table3_da" >
														<tr>
															<td><input type="radio" name="sy_location" value="0" <c:if test="${info.sy_location==0}">checked</c:if>/>顶部居左</td>
															<td><input type="radio" name="sy_location" value="1" <c:if test="${info.sy_location==1}">checked</c:if>/>顶部居中</td>
															<td><input type="radio" name="sy_location" value="2" <c:if test="${info.sy_location==2}">checked</c:if>/>顶部居右</td>
														</tr>
														<tr>
															<td><input type="radio" name="sy_location" value="3" <c:if test="${info.sy_location==3}">checked</c:if>/>左部居中</td>
															<td><input type="radio" name="sy_location" value="4" <c:if test="${info.sy_location==4}">checked</c:if>/>图片中心</td>
															<td><input type="radio" name="sy_location" value="5" <c:if test="${info.sy_location==5}">checked</c:if>/>右部居中</td>
														</tr>
														<tr>
															<td><input type="radio" name="sy_location" value="6" <c:if test="${info.sy_location==6}">checked</c:if>/>底部居左</td>
															<td><input type="radio" name="sy_location" value="7" <c:if test="${info.sy_location==7}">checked</c:if>/>底部居中</td>
															<td><input type="radio" name="sy_location" value="8" <c:if test="${info.sy_location==8}">checked</c:if>/>底部居右</td>
														</tr>
														
											</table>
											</td>
										</tr>
										<tr>
											<td class="discription">文字颜色:</td>
											<td><input type="text" id="photo_markcolor" name="font_color" style="width:50px;background-color:${info.font_color }" value="${info.font_color }"  onclick="colorPicker(event)"/></td>
										</tr>
										<tr>
											<td class="discription">文字大小:</td>
											<td><input type="text" name="font_size" value="${info.font_size }" dataType="int"/>px</td>
										</tr>
							</table>
							</td>
						</tr>
						
						<tr style="display:none">
							<td class="discription" style="width: 150px;">
								评论设置：
							</td>
							<td>
								<table style="width:auto;margin:5px;" id="yiczInfom" cellspacing="0" cellpadding="0" class="table3_da" >
							
										<tr>
											<td class="discription">回复验证码:</td>
											<td><input type="radio" name="is_code" value="1" <c:if test="${info.is_code==1}">checked</c:if>/>开启
												<input type="radio" name="is_code" value="0" <c:if test="${info.is_code==0}">checked</c:if>/>关闭
											</td>
										</tr>
										<tr>
											<td class="discription">评论分页条数:</td>
											<td><input type="text" name="page_size" value="${info.page_size }" dataType="int"/></td>
										</tr>
										<tr>
											<td class="discription">匿名评论:</td>
											<td>
												<input type="radio" name="is_lmpl" value="1" <c:if test="${info.is_lmpl==1}">checked</c:if>/>允许
												<input type="radio" name="is_lmpl" value="0" <c:if test="${info.is_lmpl==0}">checked</c:if>/>不允许
											</td>
										</tr>
										<tr>
											<td class="discription">直接显示:</td>
											<td><input type="radio" name="is_display" value="1" <c:if test="${info.is_display==1}">checked</c:if>/>是
												<input type="radio" name="is_display" value="0" <c:if test="${info.is_display==0}">checked</c:if>/>否</td>
										</tr>
							</table>
							</td>
						</tr>
						
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>