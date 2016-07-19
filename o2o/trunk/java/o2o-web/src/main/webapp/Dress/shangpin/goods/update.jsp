<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/Dress/include/top.jsp" %>
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

<style type="text/css">

 select{ text-align:left;min-width:150px;};

</style>
<script src="<%=request.getContextPath()%>/kindeditor4/kindeditor.js" type="text/javascript"></script>
<script type="text/javascript">
	KindEditor.ready(function(K) {
		window.edit=K.create('textarea[id="goodsDescription"]', {
			allowFileManager : true,
			uploadJson:'<%=request.getContextPath()%>/kindeditor4/jsp/upload_json.jsp'
		})
		window.edit2=K.create('textarea[id="goodsParameter"]', {
			allowFileManager : true,
			uploadJson:'<%=request.getContextPath()%>/kindeditor4/jsp/upload_json.jsp'
		})
	});

var falg = true;	
function submit(){

if($('input[name="tryuse"]:checked').val()=='1'){
		var etime = $("#etime").val();
		var btime = $("#btime").val();
		if(etime==""||btime==""){
			alert("请输入试用时间！");
			falg = false;
			return ;
		}
	}
	
	// 保存标签参数，用逗号分开
	$("#biaoqianList").val("");
	var bq = ",";
	$(".biaoqian").each(function() {
		if ($(this).attr("checked") == true) {
			bq += $(this).attr("biaoqianID") + ",";
		}
	});
	$("#biaoqianList").val(bq);


	if($("#defaultImage").length==0){
		alert("请上传商品形象照片！");
		return ;
	}
	window.edit.sync();
	window.edit2.sync();
	var isSub = $("#form1").checkall();
		if(falg&&isSub){
		 document.form1.submit();
		 falg = false;
		}
   
}
$(function(){
   $("#form1").validate();
});
var servicePath="<%=request.getContextPath()%>";
$(function(){
	$("#goodSortName").click(function(){
		openDialogSel("<%=request.getContextPath()%>/html/manage/goodsSort/selection?fieldId=goodSortId&fieldName=goodSortName&maxSelect=1");
	});
})


// 设置标签选中状态
$(function(){
	var bqxxx = $("#bq").val();
	var bqArray = bqxxx.split(",");
	$(".biaoqian").each(function() {
		for (i=0; i<bqArray.length; i++) {
			if($(this).attr("biaoqianID")==bqArray[i]) {
				$(this).attr("checked", "checked");
			}
		}
	});
	
});


</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/shangpin/goods/goods.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/shangpin/goods/ajaxfileupload.js"></script>

<link href="<%=request.getContextPath()%>/Dress/shangpin/goods/goods.css" rel="stylesheet" type="text/css" />

<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/goods" method="post">
<input type="hidden" name="_method" value="put" />
<% String pageNo = request.getParameter("pageNo"); %>
<input type="hidden" name="pageNo" value="<%=pageNo %>" />
<input type="hidden" name="goods_id" value="${info.goods_id }" />
<input type="hidden" name="shangjia_id" value="${info.merchants.shangjia_id }" />
<input type="hidden" name="product.product_id" value="${info.product.product_id }" />

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
						<a href="<%=request.getContextPath()%>/html/manage/goods/list" title="<fmt:message key="button.back"/>">
							<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" />
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td class="tab">
			<div box="base">基本信息</div>
			<div box="spce">商品属性</div>
			<div box="attr">商品参数</div>
			<div box="price">商品价格</div>
			<div box="delivery">配送方式</div>
			<div box="tryuse">产品试用</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="base Box">
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong>商品基本信息</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>商品分类：
							</td>
							<td style="width: 350px;">
								
								<input id="goodSortId" class="noNull" msg="请选择商品分类" url="<%=request.getContextPath()%>/html/manage/goods/goodType/list" prt="id" name="goodsSort.goodsSort_id" value="${info.goodsSort.goodsSort_id }" type="hidden" />
								<input  id="goodSortName"  value="${info.goodsSort.name }" type="text" />
							</td>
							
							<td rowspan="9">
								<div  id="imgUrl">
									<div class="goodsImage ImageSelect">
									
										未上传图片
									</div>
								</div>
								<div class="ImageMinBox">
									
								</div>
								<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/AC_OETags.js"></script>
						   		<script type="text/javascript" src="<%=request.getContextPath()%>/Dress/js/fileUpload.js"></script>
								<!-- 上传附件按钮 -->
								<script language="JavaScript" type="text/javascript">
								var imageCount=0;
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
									"flashVars","flexID=a&uploadURL=<%=request.getContextPath()%>/Dress/file/uploadgoods.jsp&label=图 片 上 传&succeed=a_completeUpload"
								);
								/**
									上传产品照片
								**/
								function a_completeUpload(fileName, realName){
									if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
									 ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
											addGoodsImage(fileName, realName);
									}else{
										alert("请上传图片。");
									}
								}
								<c:forEach items="${fn:split(info.images,';')}" var="image">
									addGoodsImage("${image}", "");
								</c:forEach>
								setGoodsImageDefault("${info.defaultImage}");
								
								</script>
								
							</td>
						</tr>
						
						<!-- 如果是代理商登录，显示归属商家列表 -->
						<c:if test="${role==2}">
							<tr >
								<td class="discription" style="width: 150px;">
									<span style="color: red;">*</span>归属商家：
								</td>
								<td>
									<select name="shangjia_sel" class="noNull">
										<option value="">请选择</option>
										<c:forEach var = "sj" items="${shangjiaList}">
											<option value="${sj.shangjia_id }">${sj.name }</option>
										</c:forEach>
									</select>
								</td>
							</tr>
						</c:if>
						
						<%--<tr >--%>
							<%--<td class="discription" style="width: 150px;">--%>
								<%--<span style="color: red;">*</span>商品类型：--%>
							<%--</td>--%>
							<%--<td>--%>
								<%--<select name="goodsType.goodsType_id" url="<%=request.getContextPath()%>/html/manage/goods/goodSpec/list" prt="id"  class="noNull goodsType" msg="商品类型">--%>
									<%--<option value="">请选择</option>--%>
									<%--<c:forEach items="${goodsType}" var="type">--%>
										<%--<option value="${type.goodsType_id }"  <c:if test="${info.goodsType.goodsType_id==type.goodsType_id }">selected</c:if>>${type.name }</option>--%>
									<%--</c:forEach>--%>
								<%--</select>--%>
							<%--</td>--%>
						<%--</tr>--%>
						<tr style="<c:if test="${empty info.goodsType.brandList }">display:none</c:if>">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>商品品牌${info.brand.brand_id }：
							</td>
							<td>
								<select name="brand.brand_id"   class=" brand">
									<%--<c:forEach items="${info.goodsType.brandList}" var="brand">--%>
										<%--<option value="${brand.brand_id }" <c:if test="${info.brand.brand_id==brand.brand_id }">selected</c:if>>${brand.name }</option>--%>
									<%--</c:forEach>--%>
									<c:forEach items="${BrandList}" var="b">
										<option value="${b.brand_id }" <c:if test="${info.brand.brand_id==b.brand_id }">selected</c:if>>${b.name }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>商品名称：
							</td>
							<td >
							<input type="text" name="name" dataType="noNull" value="${info.name }"/>
							<input type="hidden" name="defaultImage" id="defaultImage" value="${info.defaultImage }"/>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								商品标签：
							</td>
							<td >
								<input type="hidden" id="bq" value="${info.biaoqian}">
								<input type="hidden" id="biaoqianList" name="biaoqianList" value="">
								<c:forEach var="biaoqian" items="${biaoqianList}">
									<input type="checkbox" class="biaoqian" biaoqianID="${biaoqian.pageModule_id}">${biaoqian.name}<br>
								</c:forEach>
								
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_2">面部护肤<br>
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_3">彩妆香水<br>
								
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_4">品牌馆<br>
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_5">折扣馆<br>
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_6">内衣馆<br>
								
							</td>
						</tr>
						
						<tr>
							<td class="discription" style="width: 150px;">
								自定义商品分类：
							</td>
							<td>
								<select name="customSortId">
									<option value="">请选择</option>
									<c:forEach items="${customSort}" var="sort">
										<option value="${sort.goodsSort_id }" <c:if test="${info.customSort.goodsSort_id==sort.goodsSort_id }">selected</c:if>>|-${sort.levStr }${sort.name }</option>
										<c:forEach items="${sort.children}" var="ch">
											<option value="${ch.goodsSort_id }" <c:if test="${info.customSort.goodsSort_id==ch.goodsSort_id }">selected</c:if>>|-${ch.levStr }${ch.name }</option>
											<c:forEach items="${ch.children}" var="c">
												<option value="${c.goodsSort_id }" <c:if test="${info.customSort.goodsSort_id==c.goodsSort_id }">selected</c:if>>|-${c.levStr }${c.name }</option>
											</c:forEach>
										</c:forEach>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								商品编号：
							</td>
							<td>
							<input type="text" name="code" value="${info.code }"/>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								是否上架销售：
							</td>
							<td>
							<input type="radio" name="shelves" checked="checked" value="0" <c:if test="${info.shelves==0 }">checked</c:if>/>是
							<input type="radio" name="shelves"  value="1" <c:if test="${info.shelves==1 }">checked</c:if>/>否
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								商品排序：
							</td>
							<td>
							<input type="text" name="indexs"  value="${info.indexs }"/>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								是否申请会员换：
							</td>
							<td>
							<input type="radio" name="ishg" checked="checked" value="0" <c:if test="${info.ishg==0 }">checked</c:if>/>是
							<input type="radio" name="ishg"  value="1" <c:if test="${info.ishg==1 }">checked</c:if>/>否
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								产品详细：
							</td>
							<td colspan="3">
							<textarea id="goodsDescription" name="goodsDescription"   style="height:250px;width:820px;" >${info.goodsDescription }</textarea>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								产品实拍：
							</td>
							<td colspan="3">
							<textarea id="goodsParameter" name="goodsParameter"   style="height:250px;width:820px;" >${info.goodsParameter }</textarea>
							</td>
						</tr>
						
			</table>
			</div>
			<div class="spce Box" style="display:none">
				<table cellspacing="0" cellpadding="0" class="table3_da">
					<thead>
					<tr>
						<td colspan="6">
							<strong>商品属性</strong>
						</td>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${info.goodsType.specList}" var="spec" varStatus="specIndex">
					
						<tr>
							<td class="discription" >${spec.spec_name }</td>
							<td>
								<c:if test="${spec.flag==0}">
									<select name='specValue'>
										<c:forEach items="${fn:split(spec.valStr,',')}" var="val">
											<option <c:if test="${val==fn:parseSpecValue(info,specIndex.count-1) }">selected</c:if>>${val }</option>
										</c:forEach>
									</select>
								</c:if>
								<c:if test="${spec.flag==1}">
									<input type='text' name='specValue' value='${fn:parseSpecValue(info,specIndex.count-1) }'>
								</c:if>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="attr Box" style="display:none">
				<table cellspacing="0" cellpadding="0" class="table3_da">
					<thead>
					<tr>
						<td colspan="6">
							<strong>商品参数</strong>
						</td>
					</tr>
					</thead>
					<tr>
						<td>
							<table cellspacing="0" cellpadding="0" class="table3_da">
								<thead>
								<tr>
									<td><strong>参数名称</strong></td>
									<td><strong>显示类型</strong></td>
									<td><strong>参数值</strong></td>
									<td><a href="javascript:;" class="font addAttr">添加参数</a></td>
								</tr>
								</thead>
								<tbody id="attrBox">
									<c:forEach items="${info.specList}" var="spec" varStatus="specIndex">
										<c:if test="${spec.status==0}">
										<tr>
											<td>
												<input type='hidden' name='attrNameId' value='${spec.goods_spec_id }' />
												<input type='text' name='attrName' value='${spec.name }' />
											</td>
											<td><select name='attrType' class='attrType'><option value='0' <c:if test="${spec.type==0 }">selected</c:if>>文字</option><option value='1' <c:if test="${spec.type==1 }">selected</c:if>>图片</option></select></td>
											<td item='${specIndex.count-1 }'>
												<div class='attrVal'>
													<c:forEach items="${spec.valList}" var="val">
														<c:if test="${val.status==0}">
															<div class='AttrValBox'>
																<input type="hidden" name="attrValId${specIndex.count-1 }" value="${val.spec_val_id }">
																<input type='text' name='attrVal${specIndex.count-1 }' value='${val.val }' />
																<div class='AttrValBoxImage'>
																	<input type='hidden' name='attrVal${specIndex.count-1 }img' value='${val.img }' />
																	<img src='<%=request.getContextPath() %>/upload/${val.img }' title='点击删除' height='30'>
																</div>
																<a href='javascript:;' class='addImage'>选择上传图片</a>
																<a href='javascript:;' class='delattrVal'>删除</a>
															</div>
														</c:if>
													</c:forEach>
												</div>
												<a href='javascript:;' class='addAttrVal'>添加参数值</a>
											</td>
											<td><a href='javascript:;' class='delAttr'>删除参数</a></td>
										</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</td>
					</tr>
				</table>
			</div>
			
			<div class="tryuse Box" style="display:none">
				<table cellspacing="0" cellpadding="0" class="table3_da">
					<thead>
					<tr>
						<td colspan="6">
							<strong>产品试用</strong>
						</td>
						
					</tr>
					</thead>
						<tr >
							<td class="discription" style="width: 150px;">
								是否试用：
							</td>
							<td>
								<input type="radio" name="tryuse" class="tryuse"   <c:if test="${info.tryuse=='1' }">checked</c:if> value="1"/>是
								<input type="radio" name="tryuse" class="tryuse"  <c:if test="${info.tryuse=='0' }">checked</c:if>  value="0"/>否
							</td>
							</tr>
								<tr >
							<td class="discription" style="width: 150px;">
								试用份数：
							</td>
							<td>
								<input type="text" name="tryno" dataType="float"  value="${info.tryno }"/>
							</td>
							</tr>
												<tr class="sangj" >
												<td style="width: 20%;" class="discription">开始日期：</td>
												<td>
													<input id="btime" name="btime" type="text"  value="${info.btime }" />
												</td>
											</tr>
											<tr class="sangj" >
												<td style="width: 20%;" class="discription">结束日期：</td>
												<td>
													<input id="etime" name="etime" type="text"  value="${info.etime }" />
												</td>
											</tr>
						<tr>
						<td style="width: 20%;" class="discription">上传试用封面图片：</td>			
					<td rowspan="9">
								<div  id="mfimgUrl">
									<div class="mfgoodsImage mfImageSelect">
									
										未上传图片
									</div>
								</div>
								<div class="mfImageMinBox">
									
								</div>
								<!-- 上传附件按钮 -->
								<script language="JavaScript" type="text/javascript">
								var mfimageCount=0;
								AC_FL_RunContent(
									"src", "<%=request.getContextPath()%>/Dress/swf/fileUpload",
									"width", "100",
									"height", "30",
									"id", "fileUploadx",
									"quality", "high",
									"bgcolor", "#ffffff",
									"name", "fileUploadx",
									"wmode","transparent",
									"allowScriptAccess","sameDomain",
									"type", "application/x-shockwave-flash",
									"pluginspage", "http://www.adobe.com/go/getflashplayer",
									"flashVars","flexID=y&uploadURL=<%=request.getContextPath()%>/Dress/file/uploadhead.jsp&label=图 片 上 传&succeed=y_completeUpload"
								);
								/**
									上传产品照片
								**/
								function y_completeUpload(fileName, realName){
									if(fileName.indexOf(".jpg")>0||fileName.indexOf(".gif")>0||fileName.indexOf(".bmp")>0||fileName.indexOf(".png")>0
									 ||fileName.indexOf(".JPG")>0||fileName.indexOf(".GIF")>0){
											mfaddGoodsImage(fileName, realName);
									}else{
										alert("请上传图片。");
									}
								}
								<c:if test="${not empty info.mfimages}">
								<c:forEach items="${fn:split(info.mfimages,';')}" var="image">
									mfaddGoodsImage("${image}", "");
								</c:forEach>
								</c:if>
								</script>
								
							</td>
						</tr>
						
				</table>
			</div>
			<div class="price Box" style="display:none">
				<table cellspacing="0" cellpadding="0" class="table3_da">
					<thead>
					<tr>
						<td colspan="6">
							<strong>商品价格</strong>
						</td>
						
					</tr>
					</thead>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>价格区间：
							</td>
							<td>
								<select name="priceqj">
									<option <c:if test="${info.priceRange=='0-50' }">selected</c:if>>0-50</option>
									<option <c:if test="${info.priceRange=='50-99' }">selected</c:if> >50-99</option>
									<option <c:if test="${info.priceRange=='100-149' }">selected</c:if>>100-149</option>
									<option <c:if test="${info.priceRange=='150-200' }">selected</c:if>>150-200</option>
									<option <c:if test="${info.priceRange=='200-299' }">selected</c:if>>200-299</option>
									<option <c:if test="${info.priceRange=='300-499' }">selected</c:if>>300-499</option>
									<option <c:if test="${info.priceRange=='500-699' }">selected</c:if>>500-699</option>
									<option <c:if test="${info.priceRange=='700-899' }">selected</c:if>>700-899</option>
									<option <c:if test="${info.priceRange=='900-1200' }">selected</c:if>>900-1200</option>
									<option <c:if test="${info.priceRange=='1200-1500' }">selected</c:if>>1200-1500</option>
								</select>
								<!-- <input type="text" value="${fn:split(info.priceRange,'-')[0] }" class="noNull" msg="请输入价格区间！" name="begin_price" dataType="float" style="widget:50px;"/>&nbsp;-&nbsp;
								<input type="text" value="${fn:split(info.priceRange,'-')[1] }"  class="noNull" msg="请输入价格区间！"  name="end_price" dataType="float"  style="widget:50px;"/>
								 -->
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>市场价格：
							</td>
							<td>
							<input type="text" name="bazaarMoney" value="${info.bazaarMoney }" dataType="float" class="noNull" msg="请输入市场价格！" />
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>销售价格：
							</td>
							<td>
							<input type="text" name="salesMoney" value="${info.salesMoney }" dataType="float" class="noNull" msg="请输入销售价格！"/>
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>成本价格：
							</td>
							<td>
							<input type="text" name="costsMoney" value="${info.costsMoney }" dataType="float" class="noNull" msg="请输入成本价格！"/>
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>库存：
							</td>
							<td>
								<input type="text" name="inventory" value="${info.inventory }" dataType="float" class="noNull" msg="请输入库存数量！"/>
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>重量：
							</td>
							<td>
								<input type="text" name="weight" value="${info.weight }" dataType="float" class="noNull" msg="请输入商品重量！"/>g（克）
							</td>
						</tr>
						<tr  class="moneyFlag1" >
							<td class="discription" style="width: 150px;">
								根据参数增加价格：<br/>标题后面有<span style="color:#ff0000">+</span>表示在基础价格上增加。
							</td>
							<td>
								市场价：<input type="text" value="" class="Temp" dataType="float"/>
								销售价：<input type="text" value="" class="Temp" dataType="float"/>
								成本价：<input type="text" value="" class="Temp" dataType="float"/>
								库&nbsp;&nbsp;存：  <input type="text" value="" class="Temp" dataType="float"/>
								重&nbsp;&nbsp;量：  <input type="text" value="" class="Temp" dataType="float"/>
								<a href="javascript:;" style="color:#ff0000">批量设置</a>
								<a href="javascript:;" style="color:#ff0000" class="pullAttr">拉取参数</a>
								<table cellspacing="0" cellpadding="0" class="table3_da">
									<thead>
									<tr class="montyTitle">
										<td><strong>参数类型</strong></td>
										<td><strong>参数值</strong></td>
										<td><strong>市场价<span style="color:#ff0000;font-size:18px;">+</span></strong></td>
										<td><strong>销售价<span style="color:#ff0000;font-size:18px;">+</span></strong></td>
										<td><strong>成本价<span style="color:#ff0000;font-size:18px;">+</span></strong></td>
										<td><strong>库存</strong></td>
										<td><strong>重量<span style="color:#ff0000;font-size:18px;">+</span></strong></td>
									</tr>
									</thead>
									<tbody id="attrMoneyBox">
											<c:forEach items="${info.specList}" var="spec" varStatus="specIndex">
												
												<c:set var="count">${0}</c:set>
												
													<c:forEach items="${spec.valList}" var="val" varStatus="valIndex">
														<c:if test="${val.status==0}">
																<c:set var="count">${count+1}</c:set>
															<tr class='attrMoneyTr'>
																<c:if test="${count==1}">
																	<td rowspan="${spec.count }">${spec.name }</td>
																</c:if>
																<td>${val.val }</td>
																<td><input type='text' name='bazaarMoneyTag${specIndex.count-1 }:${valIndex.count-1 }'  value='${val.bazaar }' dataType='float' /></td>
																<td><input type='text' name='salesMoneyTag${specIndex.count-1 }:${valIndex.count-1 }'  value='${val.sales }' dataType='float' /></td>
																<td><input type='text' name='costsMoneyTag${specIndex.count-1 }:${valIndex.count-1 }'  value='${val.cost }' dataType='float' /></td>
																<td><input type='text' name='inventoryTag${specIndex.count-1 }:${valIndex.count-1 }'  value='${val.weight }' dataType='float' /></td>
																<td><input type='text' name='weightTag${specIndex.count-1 }:${valIndex.count-1 }'  value='${val.inventory }' dataType='float' /></td>
															</tr>
														</c:if>
													</c:forEach>
											</c:forEach>
									</tbody>
								</table>
							</td>
					</tr>
				</table>
			</div>
			<div class="delivery Box" style="display:none">
				<table cellspacing="0" cellpadding="0" class="table3_da">
					<thead>
					<tr>
						<td colspan="6">
							<strong>商品价格</strong>
						</td>
						
					</tr>
					</thead>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>配送方式：
							</td>
							<td>
								<input type="radio" name="delivery_x" value="1" <c:if test="${info.delivery.delivery==1 }">checked</c:if>/>快递配置
								<input type="radio" name="delivery_x" value="0" <c:if test="${info.delivery.delivery==0 }">checked</c:if>/>指定配送费
							</td>
						</tr>
						<tr class="setdeliveryFlag1" <c:if test="${info.delivery.delivery==0 }">style="display:none"</c:if>>
							<td class="discription" style="width: 150px;">
								快递方式：
							</td>
							<td>
								<input type="radio" name="deliveryFlag" value="2" <c:if test="${info.delivery.deliveryFlag==2 }">checked</c:if>/>默认
								<input type="radio" name="deliveryFlag" value="3" style="display:none" <c:if test="${info.delivery.deliveryFlag==3 }" >checked</c:if>/>指定快递
							</td>
						</tr>
						<tr class="setdeliveryFlag2" <c:if test="${info.delivery.delivery==1 }">style="display:none"</c:if>>
							<td class="discription" style="width: 150px;">
								指定费用：
							</td>
							<td>
								<input type="radio" name="deliveryFlag" value="0"  <c:if test="${info.delivery.deliveryFlag==0 }">checked</c:if>/>包邮
								<input type="radio" name="deliveryFlag" value="1"  <c:if test="${info.delivery.deliveryFlag==1 }">checked</c:if>/>指定费用
								<div class="deliveryMoney" <c:if test="${info.delivery.deliveryFlag!=1 }"> style="display:none" </c:if>>费用：<input type="text" name="deliveryMoney" value="${info.delivery.deliveryMoney }" dataType="float"/></div>
							</td>
						</tr>
						<tr class="setdlyIds" <c:if test="${info.delivery.deliveryFlag!=3 }">style="display:none"</c:if>>
							<td class="discription" style="width: 150px;">
								指定快递：
							</td>
							<td>
								<c:forEach items="${info.delivery.dlyList}" var="dly" >
									<div style="border:#667685 solid 1px;width:230px;margin-left:5px;margin-top:5px;float:left;">
										<a style="margin-left:5px;" class="DlytypeNum"></a>
										<input type="hidden" value="${dly.dlytype_id }" name="dlyIds" id="dlytypeId"  msg="配送方式不能为空！"/>
										<input type="text" value="${dly.dlyname }" id="dlytypeName"  mappendBy="dlytypeId" url="<%=request.getContextPath()%>/html/manage/goods/delivery/list"/>
										<a href="javascript:;" style="color:#ff0000" class="delDlytype" >删除</a>
									</div>
								</c:forEach>
								<div style="width:200px;margin-left:5px;margin-top:5px;float:left;">
									<a href="javascript:;" style="color:#ff0000" class="addDlytype">添加</a>
								</div>
								
								<div  class="DlytypeTempl" style="border:#667685 solid 1px;width:200px;margin-left:5px;margin-top:5px;float:left;display:none">
									<a style="margin-left:5px;">$num$</a>
									<input type="hidden" name="dlyIds" id="dlytypeId"  msg="配送方式不能为空！"/>
									<input type="text" id="dlytypeName"  mappendBy="dlytypeId" url="<%=request.getContextPath()%>/html/manage/goods/delivery/list"/>
									<a href="javascript:;" style="color:#ff0000"  class="delDlytype" >删除</a>
								</div>
							
							</td>
						</tr>
						
				</table>
			</div>
		</td>
	</tr>
</table>

<div style="display:none" id="costmerBrand">
	<c:forEach items="${BrandList}" var="b">
		<a brandId="${b.brand_id }">${b.name }</a>
	</c:forEach>
</div>
<script type="text/javascript">
	$(function(){
		$("#btime").datepicker();
		$("#etime").datepicker();
	});
</script>
</form>
</body>
<link href="<%=request.getContextPath()%>/web/jsp/js/jqueryUI/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/js/jqueryUI/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/js/jqueryUI/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/js/jqueryUI/jquery.ui.datepicker-zh-CN.js"></script>
</html>