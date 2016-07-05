<%@ page language="java" pageEncoding="UTF-8"%>
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

<input type="hidden" name="gameTYpe" value="rotary" />
			<input type="hidden" name="game_param_id" value="${game_param_id }" />
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong>大转盘游戏参数设置</strong>
					</td>
				</tr>
				</thead>
				<tr>
					<table cellspacing="0" cellpadding="0" class="table3_da">
						<thead>
						<tr>
							<td ><strong>参数项目</strong></td>
							<td ><strong>参数项值</strong></td>
							<td ><strong>参数项概率</strong></td>
						</tr>
						</thead>
							<tr>
								<td >一等奖</td>
								<td ><input type="text" value="${zp_param1 }" name="zp_param1" dataType="float" class="noNull" msg="参数值不能为空！"/></td>
								<td ><input type="text" value="${zp_param2 }" name="zp_param2" dataType="float" class="noNull" msg="中奖概率不能为空！"/></td>
							</tr>
							<tr>
								<td >二等奖</td>
								<td ><input type="text" value="${zp_param3 }" name="zp_param3" dataType="float" class="noNull" msg="参数值不能为空！"/></td>
							
								<td ><input type="text" value="${zp_param4 }" name="zp_param4" dataType="float" class="noNull" msg="中奖概率不能为空！"/></td>
							</tr>
							<tr>
								<td >三等奖</td>
								<td ><input type="text" value="${zp_param5 }" name="zp_param5" dataType="float" class="noNull" msg="参数值不能为空！"/></td>
								<td ><input type="text" value="${zp_param6 }" name="zp_param6" dataType="float" class="noNull" msg="中奖概率不能为空！"/></td>
							</tr>
							<tr>
								<td >四等奖</td>
								<td ><input type="text" value="${zp_param7 }" name="zp_param7" dataType="float" class="noNull" msg="参数值不能为空！"/></td>
								<td ><input type="text" value="${zp_param8 }" name="zp_param8" dataType="float" class="noNull" msg="中奖概率不能为空！"/></td>
							</tr>
							<tr>
								<td >五等奖</td>
								<td ><input type="text" value="${zp_param9 }" name="zp_param9" dataType="float" class="noNull" msg="参数值不能为空！"/></td>
								<td ><input type="text" value="${zp_param10 }" name="zp_param10" dataType="float" class="noNull" msg="中奖概率不能为空！"/></td>
							</tr>
							<tr>
								<td >六等奖</td>
								<td ><input type="text" value="${zp_param11 }" name="zp_param11" dataType="float" class="noNull" msg="参数值不能为空！"/></td>
								<td ><input type="text" value="${zp_param12 }" name="zp_param12" dataType="float" class="noNull" msg="中奖概率不能为空！"/></td>
							</tr>
							<tr>
					</table>
				</tr>
			</table>
		