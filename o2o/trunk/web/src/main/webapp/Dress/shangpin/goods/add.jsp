<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %><%--
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

﻿<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/top.jsp" %>
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
	
	// 判断图片是否上传
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


</script>
<script src="<%=request.getContextPath()%>/js/layer/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/shangpin/goods/goods.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/shangpin/goods/ajaxfileupload.js"></script>

<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/shangpin/goods/goods.css" rel="stylesheet" type="text/css" />

<form name=form1 id="form1" action="<%=request.getContextPath()%>/html/manage/goods" method="post">
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
							<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/goods/list" title="<fmt:message key="button.back"/>">
							<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" />
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
								<span style="color: red;">*</span>平台商品分类：
							</td>
							<td style="width: 350px;">
								
								<input id="goodSortId"  class="noNull" msg="请选择商品分类"  url="<%=request.getContextPath()%>/html/manage/goods/goodType/list" prt="id" name="goodsSort.goodsSort_id" value="" type="hidden" />
								<input  id="goodSortName"  value="" type="text" />
							</td>
							
							<td rowspan="9">
								<div  id="imgUrl">
									<div class="goodsImage ImageSelect">
									
										未上传图片
									</div>
								</div>
								<div class="ImageMinBox">
									
								</div>
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
									"flashVars","flexID=a&uploadURL=<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/file/uploadgoods.jsp&label=图 片 上 传&succeed=a_completeUpload"
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
								<%--<span style="color: red;">*</span>平台商品类型：--%>
							<%--</td>--%>
							<%--<td>--%>
								<%--<select name="goodsType.goodsType_id" url="<%=request.getContextPath()%>/html/manage/goods/goodSpec/list" prt="id"  class="noNull goodsType">--%>
									<%--<option value="">请选择</option>--%>
									<%--<c:forEach items="${goodsType}" var="type">--%>
										<%--<option value="${type.goodsType_id }">${type.name }</option>--%>
									<%--</c:forEach>--%>
								<%--</select>--%>
							<%--</td>--%>
						<%--</tr>--%>
						<tr >
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>商品品牌：
							</td>
							<td>
								<select name="brand.brand_id"   class="brand">
									<%--<option value="">请选择</option>--%>
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
							<input type="text" name="name" dataType="noNull"/>
							<input type="hidden" name="defaultImage" id="defaultImage" value=""/>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								商品标签：
							</td>
							<td >
								<input type="hidden" id="biaoqianList" name="biaoqianList" value="">
								
								<c:forEach var="biaoqian" items="${biaoqianList}">
									<input type="checkbox" class="biaoqian" biaoqianID="${biaoqian.pageModule_id}">${biaoqian.name}<br>
								</c:forEach>
								
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_2">左一<br>
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_3">左二<br>
								
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_4">右一<br>
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_5">右二<br>
								<input type="checkbox" class="biaoqian" biaoqianID="android_adv_6">右三<br>
								
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
										<option value="${sort.goodsSort_id }">|-${sort.levStr }${sort.name }</option>
										<c:forEach items="${sort.children}" var="ch">
											<option value="${ch.goodsSort_id }">|-${ch.levStr }${ch.name }</option>
											<c:forEach items="${ch.children}" var="c">
												<option value="${c.goodsSort_id }">|-${c.levStr }${c.name }</option>
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
							<input type="text" name="code"/>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								是否上架销售：
							</td>
							<td>
							<input type="radio" name="shelves" checked="checked" value="0"/>是
							<input type="radio" name="shelves"  value="1"/>否
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								商品排序：
							</td>
							<td>
							<input type="text" name="indexs"  value="1"/>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								是否申请会员换：
							</td>
							<td>
							<input type="radio" name="ishg" checked="checked" value="0"/>是
							<input type="radio" name="ishg"  value="1"/>否
							</td>
						</tr>
						<!-- <tr>
							<td class="discription" style="width: 150px;">
								标签：
							</td>
							<td>
							<input type="checkbox" name="biaoqian" value="0"/>最新商品
							<input type="checkbox" name="biaoqian" value="1"/>促销
							<input type="checkbox" name="biaoqian" value="2"/>精品推荐
							<input type="checkbox" name="biaoqian" value="3"/>热销产品
							</td>
						</tr>
						 -->
						<tr>
							<td class="discription" style="width: 150px;">
								产品详细：
							</td>
							<td colspan="3">
							<textarea id="goodsDescription" name="goodsDescription"   style="height:250px;width:820px;" ></textarea>
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								产品实拍：
							</td>
							<td colspan="3">
							<textarea id="goodsParameter" name="goodsParameter"   style="height:250px;width:820px;" ></textarea>
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
							<strong>配送方式</strong>
						</td>
						
					</tr>
					</thead>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>配送方式：
							</td>
							<td>
								<input type="radio" name="delivery_x" value="1" checked/>快递配置
								<input type="radio" name="delivery_x" value="0"/>指定配送费
							</td>
						</tr>
						<tr class="setdeliveryFlag1">
							<td class="discription" style="width: 150px;">
								快递方式：
							</td>
							<td>
								<input type="radio" name="deliveryFlag" value="2" checked/>默认
								<input type="radio" name="deliveryFlag" value="3" style="display:none" msg="指定快递"/>
							</td>
						</tr>
						<tr class="setdeliveryFlag2" style="display:none">
							<td class="discription" style="width: 150px;">
								指定费用：
							</td>
							<td>
								<input type="radio" name="deliveryFlag" value="0" />包邮
								<input type="radio" name="deliveryFlag" value="1" />指定费用
								<div class="deliveryMoney">费用：<input type="text" name="deliveryMoney" value="0" dataType="float"/></div>
							</td>
						</tr>
						<tr class="setdlyIds" style="display:none">
							<td class="discription" style="width: 150px;">
								指定快递：
							</td>
							<td>
								<div style="border:#667685 solid 1px;width:230px;margin-left:5px;margin-top:5px;float:left;">
									<a style="margin-left:5px;" class="DlytypeNum">1</a>
									<input type="hidden" name="dlyIds" id="dlytypeId"  msg="配送方式不能为空！"/>
									<input type="text" id="dlytypeName"  mappendBy="dlytypeId" url="<%=request.getContextPath()%>/html/manage/goods/delivery/list"/>
									<a href="javascript:;" style="color:#ff0000" class="delDlytype" >删除</a>
								</div>
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
							<td class="discription" style="width: 150px;" id="sfsy">
								是否试用：
							</td>
							<td>
								<input type="radio" name="tryuse" class="tryuse"   value="1"/>是
								<input type="radio" name="tryuse" class="tryuse"  checked value="0"/>否
							</td>
							</tr>
								<tr >
							<td class="discription" style="width: 150px;">
								试用份数：
							</td>
							<td>
								<input type="text" name="tryno"  value="0" dataType="float"/>
							</td>
							</tr>
												<tr class="sangj" >
												<td style="width: 20%;" class="discription">开始日期：</td>
												<td>
													<input id="btime" name="btime" type="text"  value="" />
												</td>
											</tr>
											<tr class="sangj" >
												<td style="width: 20%;" class="discription">结束日期：</td>
												<td>
													<input id="etime" name="etime" type="text"  value="" />
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
									"src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/swf/fileUpload",
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
									"flashVars","flexID=y&uploadURL=<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/file/uploadhead.jsp&label=图 片 上 传&succeed=y_completeUpload"
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
									<option>0-50</option>
									<option>50-99</option>
									<option>100-149</option>
									<option>150-200</option>
									<option>200-299</option>
									<option>300-499</option>
									<option>500-699</option>
									<option>700-899</option>
									<option>900-1200</option>
									<option>1200-1500</option>
								</select>
								<!-- <input type="text" class="noNull" msg="请输入价格区间！" name="begin_price" dataType="float" style="widget:50px;" value="0"/>&nbsp;-&nbsp;
								<input type="text" class="noNull" msg="请输入价格区间！"  name="end_price" dataType="float"  style="widget:50px;" value="0"/> -->
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>市场价格：
							</td>
							<td>
							<input type="text" name="bazaarMoney" dataType="float" class="noNull" msg="请输入市场价格！" />
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>销售价格：
							</td>
							<td>
							<input type="text" name="salesMoney" dataType="float"  class="noNull" msg="请输入销售价格！"/>
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>成本价格：
							</td>
							<td>
							<input type="text" name="costsMoney" dataType="float"  class="noNull" msg="请输入成本价格！"/>
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>库存数量：
							</td>
							<td>
								<input type="text" name="inventory" dataType="float"   class="noNull" msg="请输入库存数量！"/>
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 150px;">
								<span style="color: red;">*</span>商品重量：
							</td>
							<td>
								<input type="text" name="weight" dataType="float"  class="noNull" msg="请输入商品重量！"/>g（克）
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
										
									</tbody>
								</table>
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

