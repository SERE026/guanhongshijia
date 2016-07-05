<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=AK4Z6oiZ4uGtRwpN9a1ksmS1"></script>

<script src="<%=request.getContextPath()%>/kindeditor4/kindeditor.js" type="text/javascript"></script>
<script type="text/javascript">
	KindEditor.ready(function(K) {
		window.edit=K.create('textarea[id="desc"]', {
			allowFileManager : true,
			uploadJson:'<%=request.getContextPath()%>/kindeditor4/jsp/upload_json.jsp'
		})
	});
	$(function(){
		address("provinceId","cityId","countyId","<%=request.getContextPath()%>/html/manage/area/json/selection");
		$("#provinceId").change(function(){
			map.centerAndZoom($("#provinceId option:selected").text(),8); 
		});
		$("#cityId").change(function(){
			map.centerAndZoom($("#cityId option:selected").text(),15); 
		});
		$("#countyId").change(function(){
			map.centerAndZoom($("#countyId option:selected").text(),16); 
		});
		
		$("#address").blur(function(){
			// 创建地址解析器实例
			var myGeo = new BMap.Geocoder();
			// 将地址解析结果显示在地图上,并调整地图视野
			myGeo.getPoint($("#address").val(), function(point){
			  if (point) {
			    map.centerAndZoom(point, 16);
		    	if(marker!=null){
					marker.remove();
				}
				$("#longitude").val(point.lng);
				$("#latitude").val(point.lat);
				marker=new BMap.Marker(point);
				map.addOverlay(marker);
				marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
			  }
			}, $("#cityId option:selected").text());
		});
		$("#form1").validate();
		
		var satas=${stats };
			if(satas=="1"){
				alert("提交成功！如果数据未更新，请退出后重新登录！");
			}
	
	})
	
	function submit(){
	
		// 找到所有的店招图片，组合成用逗号分隔的字符串
		var images = "";
		$(".delDz").each(function() {
			images += $(this).attr("imgName") + ",";
		});

		// 找到所有的女人街店招图片，组合成用逗号分隔的字符串
		var nrj_images = "";
		$(".nrj_delDz").each(function() {
			nrj_images += $(this).attr("imgName") + ",";
		});

		// 找到所有的外链，组合成用逗号分隔的字符串
		var urls = "";
		$(".dz_url").each(function() {
			urls = urls + $(this).val() + ",";
		});

		// 改变隐藏域的值，然后提交
		$("#dzList").val(images);
		$("#nrj_dzList").val(nrj_images);
		$("#urlList").val(urls);

		window.edit.sync();
		if($("#form1").checkall()){
			$("#form1").submit();
		}
		
	}
//-->
</script>

<form name=form1  id="form1" action="<%=request.getContextPath()%>/html/manage/storeInfo/disUpdate" method="post">
<input type="hidden" id="longitude"  name="longitude" value="${info.longitude }" msg="请在地图上标注你店铺的位置。" class="noNull"/>
<input type="hidden" id="latitude"   name="latitude" value="${info.latitude }" msg="请在地图上标注你店铺的位置。" class="noNull" />
<input type="hidden" id="shangjia_id"   name="shangjia_id" value="${info.shangjia_id }"  />
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
						<strong>店铺信息维护</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>店铺名称：
							</td>
							<td>
								<input type="text"  name="name" value="${info.name }"  msg="请输入你的店铺名称。" class="noNull"/>
							</td>
							<td rowSpan=8>
								<div style="width:500px;height:300px;">
									<div  style="width:300px;height:300px;margin:auto" id="iamgeBox">
										<c:if test="${not empty info.image}">
											<img src="<%=request.getContextPath()%>/upload/${info.image }" width=100% height=100% >
										</c:if>
									</div>
									<div style="display:none">
										<input type="hidden" id="iamge" name="iamge" value="${info.image }" class="noNull" msg="形象照片不能为空！"/>
									</div>
								</div>
								<div style="width:200px;height:40px;margin:auto">
								<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/AC_OETags.js"></script>
						   		<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/fileUpload.js"></script>
								<!-- 上传附件按钮 -->
								<script language="JavaScript" type="text/javascript">
									var imageCount=0;
									
									AC_FL_RunContent(
										"src", "<%=request.getContextPath()%>/Dress/upload/merchants/updxiang",
										"width", "200",
										"height", "40",
										"id", "fileUpload",
										"quality", "high",
										"bgcolor", "#ffffff",
										"name", "fileUpload",
										"wmode","transparent",
										"allowScriptAccess","sameDomain",
										"type", "application/x-shockwave-flash",
										"pluginspage", "http://www.adobe.com/go/getflashplayer",
										"flashVars","flexID=c&uploadURL=<%=request.getContextPath()%>/Dress/file/upload.jsp&label=图 片 上 传&succeed=a_completeUpload"
									);
									/**
										上传产品照片
									**/
									function c_completeUpload(fileName, realName){
										var html='<img src="<%=request.getContextPath()%>/upload/'+fileName+'" width=100% height=100% >';
										$("#iamge").val(fileName);
										$("#iamgeBox").html(html);
									}
								</script>
								</div>
							</td>
						</tr>
						
						
						<tr>	
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>联系人姓名：
							</td>
							<td>
								<input type="text"  name="contactName" value="${info.contactName }"  />
							</td>
						</tr>
						
						
						<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>联系人电话：
							</td>
							<td>
								<input type="text" id="contactPhone" dataType="mobile" name="contactPhone"  value="${info.contactPhone }" />
							</td>
						</tr>
						
						
						<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>联系人地址：
							</td>
							<td  >
								<div style="float:left;margin-left:10;width:180px;">
								<select name="province.id" id="provinceId" dataVal="${info.province.id }">
									<option value="">--请选择--</option>
									
								</select>
								省
								</div>
								<div style="float:left;margin-left:10px;width:180px;">
								<select  name="city.id" id="cityId" dataVal="${info.city.id }">
									<option value="">--请选择--</option>
									
								</select>
								市
								</div>
								<div style="float:left;margin-left:10px;width:180px;">
								<select name="county.id" id="countyId" dataVal="${info.county.id }">
									<option value="">--请选择--</option>
									
								</select>
								县
								</div>
							</td>
							
						</tr>
						<tr>	
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>联系人地址：
							</td>
							<td >
								<input type="text" id="address"  name="address"  value="${info.address }" />
							</td>
						</tr>
						<tr>	
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>店铺样式：
							</td>
							<td >
								<input type="radio" name="flag" value="0" <c:if test="${info.flag==0 }">checked</c:if>/>默认样式
								<input type="radio" name="flag" value="1" <c:if test="${info.flag==1 }">checked</c:if>/>使用自定样式
								<a href="<%=request.getContextPath()%>/html/manage/storeInfo/file">上传店铺模板</a>
							</td>
						</tr>
						<tr>	
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>店招(像素：1009 x 282)<br><span style="color:red;">点击图片即可删除</span>
							</td>
							<td >
								<div id="dipdz">
									<!-- 加载店招图片及外链地址 -->
									<input type="hidden" id = "dzList" name='dzList' value='提交时组合' />
									<input type="hidden" id = "urlList" name='urlList' value='提交时组合2' />
									<c:if test="${not empty imgList}">
										<c:forEach items="${imgList}" var="img" varStatus="index" >
											<!-- 做防空串处理 -->
											<c:if test="${fn:length(img)!=0}">
												<div style="width:300px;height:83px;">
													<img class="delDz" src="<%=request.getContextPath()%>/merchants/${merchants.shangjia_id}/${img }" imgName="${img }" width="100%" height="100%" >
													<c:forEach items="${urlList}" var="url" varStatus="index2" >
														<c:if test="${index.index==index2.index }">
															<div class="delUrl">链接地址：<input type="text" class="dz_url" value="${url }"></div>
														</c:if>
													</c:forEach>
												</div>
												<!-- 保留一定空白区域 -->
												<div class="space">&nbsp;</div>
											</c:if>
										</c:forEach>
									</c:if>
									
									<!--<c:if test="${not empty info.dzImage}">
										<c:forEach items="${fn:split(info.dzImage,',')}" var="img" varStatus="index">
											<div style="width:300px;height:83px;">
												<img class="delDz" src="<%=request.getContextPath()%>/merchants/${merchants.shangjia_id}/${img }" width="100%" height="100%" >
												<input type='hidden' name='dz' value='${img }' />
												
											</div>
											<div class="space">&nbsp;</div>
										</c:forEach>
									</c:if>--> 
								</div>
								
										<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/AC_OETags.js"></script>
								   		<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/fileUpload.js"></script>
										<!-- 上传附件按钮 -->
										<script language="JavaScript" type="text/javascript">
											function addDzEvent(){
												$(".delDz").unbind("click").click(function(){
													var img = $(this);
													var box = img.next(".delUrl");
													var space = img.parent().next(".space");
													img.parent().remove();
													space.remove();
												})
												
											}
											var imageCount=0;
											function removeFiles(fileName){
												document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
											}
											AC_FL_RunContent(
												"src", "<%=request.getContextPath()%>/Dress/upload/merchants/uploaddz",
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
												"flashVars","flexID=d&userID=${UserInfo.login_id}&uploadURL=<%=request.getContextPath()%>/Dress/upload/merchants/uploadx.jsp&label=图 片 上 传&succeed=a_completeUpload"
											);
											/**
												上传产品照片
											**/
											function d_completeUpload(fileName, realName){
												alert("上传店招图片成功！");
												var html='<div style="width:300px;height:83px;">'
												html += '<input type="hidden" name="dz" value="'+fileName+'" /><img class="delDz" src="<%=request.getContextPath()%>/merchants/${merchants.shangjia_id}/'+fileName+'" width="100%" height="100%" imgName=' + fileName + '>';
												html += '<div class="delUrl">链接地址：<input type="text" class="dz_url" value="http://您的外链地址"></div></div>';
												
												
												
												html += '<div class="space">&nbsp;</div>';
												if($("#dipdz .delDz").length<4){
													$("#dipdz").html($("#dipdz").html()+html);
													addDzEvent();
												}else{
													alert("自定义店招最多只能4个，请点击店招删除后再添加。");
												}
											}
											addDzEvent();
										</script>
								
							</td>
						</tr>
						
						<!-- 新增女人街图片上传 -->
						<tr>	
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>女人街图片上传(像素：480 x 190)<br><span style="color:red;">点击图片即可删除</span>
							</td>
							<td >
								<div id="nrj_dz">
									<!-- 加载女人街店招图片 -->
									<input type="hidden" id = "nrj_dzList" name='nrj_dzList' value='提交时组合' />
									<c:if test="${not empty nrj_imgList}">
										<c:forEach items="${nrj_imgList}" var="img" varStatus="index" >
											<!-- 做防空串处理 -->
											<c:if test="${fn:length(img)!=0}">
												<div style="width:300px;height:83px;">
													<img class="nrj_delDz" src="<%=request.getContextPath()%>/merchants/${merchants.shangjia_id}/${img }" imgName="${img }" width="100%" height="100%" >
												</div>
											</c:if>
										</c:forEach>
									</c:if>
								</div>
								
								<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/AC_OETags.js"></script>
								   		<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/fileUpload.js"></script>
										<!-- 上传附件按钮 -->
										<script language="JavaScript" type="text/javascript">
											function addNRJ_DzEvent(){
												$(".nrj_delDz").unbind("click").click(function(){
													var img = $(this);
													img.parent().remove();
												})
												
											}
											var imageCount=0;
											function removeFiles(fileName){
												document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
											}
											AC_FL_RunContent(
												"src", "<%=request.getContextPath()%>/Dress/upload/merchants/uploaddz",
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
												"flashVars","flexID=n&userID=${UserInfo.login_id}&uploadURL=<%=request.getContextPath()%>/Dress/upload/merchants/uploadx.jsp&label=图 片 上 传&succeed=b_completeUpload"
											);
											/**
												上传产品照片
											**/
											function n_completeUpload(fileName, realName){
												alert("上传女人街图片成功！");
												var html='<div style="width:300px;height:83px;">'
												html += '<input type="hidden" name="nrj_dz" value="'+fileName+'" /><img class="nrj_delDz" src="<%=request.getContextPath()%>/merchants/${merchants.shangjia_id}/'+fileName+'" width="100%" height="100%" imgName=' + fileName + '>';
												html += '</div>';
												
												if($("#nrj_dz .nrj_delDz").length<4){
													$("#nrj_dz").html($("#nrj_dz").html()+html);
													addNRJ_DzEvent();
												}else{
													alert("自定义女人街图片最多只能4个，请点击图片删除后再添加。");
												}
											}
											addNRJ_DzEvent();
										</script>
								
								
							</td>
						</tr>
						
						
						
						
						
						<tr>
							<td class="discription" style="width: 150px;">
								归属码：
							</td>
							<td  >
								${info.affiliation }
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								会员邀请地址：
							</td>
							<td >
								http://www.c-1-tech.com/Dress/register.html?p=${info.affiliation }
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								店铺介绍：
							</td>
							<td  colspan=2>
								<textarea name="intro" style="width:500px;height:100px;">${info.intro }</textarea>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								地图：
							</td>
							<td  colspan=2>
								<div id="map" style="width:800px;height:500px;"></div>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								关于我们：
							</td>
							<td  colspan=2>
								<textarea name="desc" id="desc" style="width:800px;height:500px;">${info.desc }</textarea>
							</td>
						</tr>
						<script type="text/javascript">
						var marker=null;
						// 百度地图API功能
						var map = new BMap.Map("map");            // 创建Map实例
						map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
						<c:if test="${info.longitude>0}">
							
							var point = new BMap.Point(${info.longitude}, ${info.latitude});    // 创建点坐标
							map.centerAndZoom("${info.county.name }",15); 
						 	var marker = new BMap.Marker(point);
						 	map.addOverlay(marker);
						    marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
						</c:if>
						<c:if test="${info.longitude==0}">
						
							map.centerAndZoom("成都",11);                     // 初始化地图,设置中心点坐标和地图级别。
						</c:if>
						map.enableScrollWheelZoom();                            //启用滚轮放大缩小
						function showInfo(e){//点击地图后添加标记
							$("#longitude").val(e.point.lng);
							$("#latitude").val(e.point.lat);
						 	var point = new BMap.Point(e.point.lng, e.point.lat);
						 	if(marker!=null){
						 		marker.remove();
						 	}
						 	marker = new BMap.Marker(point);
						 	map.addOverlay(marker);
						    marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
						    
						}
						map.addEventListener("click", showInfo);
						<c:if test="${not empty info.address }">
							// 创建地址解析器实例
							var myGeo = new BMap.Geocoder();
							// 将地址解析结果显示在地图上,并调整地图视野
							myGeo.getPoint("${info.address }", function(point){
							  if (point) {
							    map.centerAndZoom(point, 16);
						    	if(marker!=null){
									marker.remove();
								}
								$("#longitude").val(point.lng);
								$("#latitude").val(point.lat);
								marker=new BMap.Marker(point);
								map.addOverlay(marker);
								marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
							  }
							}, "${info.city.name }");
						</c:if>
						</script>
						
			</table>
		</td>
	</tr>
</table>
</form>
