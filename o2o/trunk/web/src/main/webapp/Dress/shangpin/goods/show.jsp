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

<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/shangpin/goods/goods.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/shangpin/goods/goods.js"></script>
<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou">
						<a href="<%=request.getContextPath()%>/html/manage/goods/list" title="<fmt:message key="button.back" />">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" />
						</a>
					</td>
					<td class="tab">
						<div box="base">基本信息</div>
						<div box="spce">商品属性</div>
						<div box="attr">商品参数</div>
						<div box="price">商品价格</div>
						<div box="delivery">配送方式</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td>
		<div class="base Box">
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="4">
						<strong>商品信息查看</strong>
					</td>
				</tr>
				</thead>
				<tr>
							<td class="discription" style="width: 150px;">
								平台商品分类：
							</td>
							<td style="width: 350px;">
								${info.goodsSort.name }
							</td>
							
							<td rowspan="6">
								<div id="imgUrl">
									<div class="goodsImage ImageSelect">
									
										未上传图片
									</div>
								</div>
									<div class="ImageMinBox">
										
									</div>
								
								<!-- 上传附件按钮 -->
								<script language="JavaScript" type="text/javascript">
									var imageCount =0;
									var servicePath ="<%=request.getContextPath()%>";
									<c:forEach items="${fn:split(info.images,';')}" var="image">
										addGoodsImage("${image}", "");
									</c:forEach>
									setGoodsImageDefault("${info.defaultImage}");
								</script>
							</td>
						</tr>
						<%--<tr >--%>
							<%--<td class="discription" style="width: 150px;">--%>
								<%--平台商品类型：--%>
							<%--</td>--%>
							<%--<td>--%>
								<%--${info.goodsType.name }--%>
							<%--</td>--%>
						<%--</tr>--%>
						<tr>
							<td class="discription" style="width: 150px;">
								商品名称：
							</td>
							<td >
							${info.name }
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								自定义商品分类：
							</td>
							<td>
								${info.customSort.name }
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								商品编号：
							</td>
							<td>
								${info.code }
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								是否上架销售：
							</td>
							<td>
							<c:if test="${info.shelves==0}">是</c:if>
							<c:if test="${info.shelves==1}">否</c:if>
							</td>
						</tr>
						
						<tr>
							<td class="discription" style="width: 150px;">
								商品排序：
							</td>
							<td>
							${info.indexs }
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								详细描述：
							</td>
							<td colspan="3">
							<div style="width:100%;height:500px;">
								${info.goodsDescription }
							</div>
							
							</td>
						</tr>
						<tr>
							<td class="discription" style="width: 150px;">
								产品实拍：
							</td>
							<td colspan="3">
							<div style="width:100%;height:500px;">
								${info.goodsParameter }
							</div>
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
								
									${fn:parseSpecValue(info,specIndex.count-1) }

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
									<td><strong>参数类型</strong></td>
									<td><strong>参数值</strong></td>
								</tr>
								</thead>
								<tbody id="attrBox">
									<c:forEach items="${info.specList}" var="spec" varStatus="specIndex">
										
										<c:if test="${spec.status==0}">
										<tr>
											<td>
												${spec.name }
											</td>
											<td><c:if test="${spec.type==0 }">文字</c:if><c:if test="${spec.type==1 }">图片</c:if></td>
											<td item='${specIndex.count-1 }'>
												<div class='attrVal'>	
													<c:forEach items="${spec.valList}" var="val">
													<c:if test="${val.status==0}">
														<div class='AttrValBox'>
															${val.val }
															<div class='AttrValBoxImage'>
																<img src='<%=request.getContextPath() %>/upload/${val.img }' title='点击删除' height='30'>
															</div>
														</div>
														</c:if>
													</c:forEach>
												</div>
											</td>
										</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
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
							<td class="discription" style="width: 200px;">
								<span style="color: red;">*</span>市场价格：
							</td>
							<td>
							${info.bazaarMoney }
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 200px;">
								销售价格：
							</td>
							<td>
							${info.salesMoney }
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 200px;">
								成本价格：
							</td>
							<td>
							${info.costsMoney }
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 200px;">
								库存：
							</td>
							<td>
								${info.inventory }
							</td>
						</tr>
						<tr class="moneyFlag0">
							<td class="discription" style="width: 200px;">
								重量：
							</td>
							<td>
								${info.weight }g（克）
							</td>
						</tr>
						<tr  class="moneyFlag1" >
							<td class="discription" style="width: 200px;">
								根据参数增加价格：<br/>标题后面有<span style="color:#ff0000">+</span>表示在基础价格上增加。
							</td>
							<td>
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
												
												<c:forEach items="${spec.valList}" var="val" varStatus="valIndex">
												<c:if test="${val.status==0}">
													<tr class='attrMoneyTr'>
														<td >${spec.name }</td>
														<td>${val.val }</td>
														<td>${val.bazaar }</td>
														<td>${val.sales }</td>
														<td>${val.cost }</td>
														<td>${val.weight }</td>
														<td>${val.inventory }</td>
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
								<input type="radio" name="deliveryFlag" value="3"  style="display:none" <c:if test="${info.delivery.deliveryFlag==3 }">checked</c:if>/>指定快递
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
</form>
</body>
</html>