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

<script type="text/JavaScript">
    function submit(){
        document.form1.submit();
    }
</script>


<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
    <tr>
        <td class="tab2_top" >

        </td>
    </tr>
    <td style="border:none; vertical-align:top">

        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td class="tab2_tou"><a href="javascript:submit();">
                    <img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" />
                </a></td>
                <td class="tab2_tou" >
                    <a href="javascript:location.reload();">
                        <img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
                    </a>
                </td>
                <td class="tab2_tou" >
                    <a href="<%=request.getContextPath()%>/html/manage/coupon/list">
                        <img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" />
                    </a>
                </td>

                <td>&nbsp;</td>
            </tr>
        </table>

    </td>
    </tr>
    <tr><td></td></tr>
    <tr>

        <td style="border:#c5c5c5 solid 1px; vertical-align:top">

            <form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/coupon" method="post">
                <input type="hidden" name="_method" value="post" />
                <input type="hidden" name="isSys" value="0" />
                <table cellspacing="0" cellpadding="0" class="table3_da">
                    <thead>
                    <tr>
                        <td colspan="6"> <strong>添加优惠卷</strong> </td>
                    </tr>
                    </thead>
                    <tr>
                        <td style="width: 20%;" class="discription">优惠卷名：</td>
                        <td><input type="text" value="" id="name" name="name"/></td>
                    </tr>
                    <tr>
                        <td class="discription">开始时间：</td>
                        <td><input type="text" name="BEGIN_TIME" id="BEGIN_TIME"/></td>
                    </tr>
                    <tr>
                        <td class="discription">结束时间：</td>
                        <td><input type="text" name="END_TIME" id="END_TIME"/></td>
                    </tr>
                   <%-- <tr>
                        <td class="discription">444444444444444444444：</td>
                        <td>
                            <select name="is_job" style="width: 154px;">
                                <option value="1" selected="selected">否</option>
                                <option value="0">是</option>
                            </select>
                        </td>
                    </tr>--%>
                    <tr>
                        <td class="discription">类型：</td>
                        <td><input type="text" name="type" id="type"/></td>
                    </tr>
                    <tr>
                        <td class="discription">抵扣金额：</td>
                        <td><input type="text" name="reduceValue" id="reduceValue"/></td>
                    </tr>
                    <tr>
                        <td class="discription">折扣率：</td>
                        <td><input type="text" name="discountValue" id="discountValue"/></td>
                    </tr>
                    <tr>
                        <td class="discription">最大抵扣金额：</td>
                        <td><input type="text" name="maxAmouont" id="maxAmouont"/></td>
                    </tr>
                    <tr>
                        <td class="discription">满多少可用：</td>
                        <td><input type="text" name="constraintValue" id="constraintValue"/></td>
                    </tr>
                    <tr>
                        <td class="discription">是否可以和其他优惠券同时使用：</td>
                        <td><input type="text" name="sameUse" id="sameUse"/></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
