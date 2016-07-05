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

<input type="hidden" name="gameTYpe" value="diandian" />
			<input type="hidden" name="game_param_id" value="${game_param_id }" />
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong>点点点游戏参数设置</strong>
					</td>
				</tr>
				</thead>
				<tr>
					<table cellspacing="0" cellpadding="0" class="table3_da">
						<thead>
							手机端设置
						</thead>
						<tr>
							<td >每点击一次获得金额</td><td ><input type="text" value="${zp_param12 }" name="zp_param12" dataType="float" class="noNull" msg="每点击一次获得金额不能为空！"/></td>
							<td >最多可获得金额</td><td ><input type="text" value="${zp_param13 }" name="zp_param13" dataType="float" class="noNull" msg="最多可获得金额不能为空！"/></td>
						</tr>
				</tr>
				<tr>
					<table cellspacing="0" cellpadding="0" class="table3_da">
						<thead>
							web端设置
						</thead>
							<tr>
								<td >点击次数</td>
								<td >0 - <input type="text" value="${zp_param1 }" name="zp_param1" dataType="int" class="noNull" msg="次数不能为空！" style="width:50px;"/>
								</td><td>	   - <input type="text" value="${zp_param2 }" name="zp_param2" dataType="int" class="noNull" msg="次数不能为空！" style="width:50px;"/>
								</td><td>	   - <input type="text" value="${zp_param3 }" name="zp_param3" dataType="int" class="noNull" msg="次数不能为空！" style="width:50px;"/>
								</td><td>	   - <input type="text" value="${zp_param4 }" name="zp_param4" dataType="int" class="noNull" msg="次数不能为空！" style="width:50px;"/>
								</td><td>	   - <input type="text" value="${zp_param5 }" name="zp_param5" dataType="int" class="noNull" msg="次数不能为空！" style="width:50px;"/>
								</td><td>	   - 以上
								</td>
							</tr>
							<tr>
								<td >奖金设置</td>
								
								<td >
										<input type="text" value="${zp_param6 }" name="zp_param6" dataType="float" class="noNull" msg="奖金不能为空！"/>
								
								</td>
								<td >
										<input type="text" value="${zp_param7 }" name="zp_param7" dataType="float" class="noNull" msg="奖金不能为空！"/>
								
								</td>
								<td >
										<input type="text" value="${zp_param8 }" name="zp_param8" dataType="float" class="noNull" msg="奖金不能为空！"/>
								
								</td>
								<td >
										<input type="text" value="${zp_param9 }" name="zp_param9" dataType="float" class="noNull" msg="奖金不能为空！"/>
								
								</td>
								<td >
										<input type="text" value="${zp_param10 }" name="zp_param10" dataType="float" class="noNull" msg="奖金不能为空！"/>
								
								</td>
								<td >
										<input type="text" value="${zp_param11 }" name="zp_param11" dataType="float" class="noNull" msg="奖金不能为空！"/>
								
								</td>
							</tr>
							<tr>
					</table>
				</tr>
			</table>
		