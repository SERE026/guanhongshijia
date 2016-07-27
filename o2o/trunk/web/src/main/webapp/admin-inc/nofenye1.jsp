<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.com.dyninfo.o2o.furniture.util.PageInfo"%>
<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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

<%
String url=request.getContextPath()+request.getParameter("url");
request.setAttribute("path",url); 
%>

<script language="javascript">

	function goPageTo(no){
	var ul="${path}";
		if(no<1)
			alert("已经是第一页！");
		else if(no>${PAGE_INFO.totalpage})
			alert("已经是最后一页！");
		else {
		
		if(document.getElementById("pageNo")!=null)
			document.getElementById("pageNo").name="pageNo";
		if(document.form1.action.length==0)
			$("form1").attr("action",ul);
			document.form1.action="${path}";
		document.form1.pageNo.value=no;
		
		document.form1.submit();
	}
	}
	function jump(){
		var no=document.getElementById("ys").value;
		if(no.length>0){
			if(no>${PAGE_INFO.totalpage}){
				alert("输入页码大于总页码");
			}else
			goPageTo(no);
		}else{
			alert("请输入页码!");
		}
	}
</script>

<%PageInfo info=(PageInfo)request.getAttribute("PAGE_INFO");
int nopage=info.getPageNo();
int tpage=info.getTotalpage();
if(tpage==0){
%>
<tr align="center">
	<td style="border-right:none;"></td>
	<td colspan="100" height="25">
		暂无相关数据
	</td>
</tr>
<%} %>
<tr style="background-image:url(<%=request.getContextPath()%>/img/biao_22.gif)">
	<td style="border-right:none;"></td>
	 <td colspan="100" style="text-align:center;border-left:none;" valign="middle" >
	 
	 <div style="width:600px;height:30px;margin:auto;padding-left:180px">
	
	<div style="float:left;margin-top:4px;">
	<%if(tpage>0){ %>
	<a href="javascript:goPageTo('${PAGE_INFO.pageNo-1 }')">
		<img src="<%=request.getContextPath()%>/img/tab2_fenye_25.gif" border="0" />
	</a>
	<%} %>
</div>
<div style="float:left;;margin-top:4px;">
<ul>

<%
int s=nopage-2;
if(tpage==nopage)
s=nopage-4;
if(tpage-1==nopage)
s=nopage-3;
int e=tpage;
int t=0;
for(int i=0;i<tpage+5&t<5;i++)
{
	if(s+i>0&&s+i<=tpage)
		{
		t++;
		if(s+i==nopage){
		%>
		<li><%=s+i %></li>
		<%
		}
		else{
		%>
		<li><a href="javascript:goPageTo('<%=s+i %>');" class="zhu3"><%=s+i %></a></li>
		<%
		}
	}
}

%>

</ul>
</div>

	<%if(tpage>0){ %>
<div style="float:left;margin-left:10px;margin-top:4px;">
<a href="javascript:goPageTo('${PAGE_INFO.pageNo+1 }')">
<img src="<%=request.getContextPath()%>/img/tab2_fenye_31.gif" border="0" /></a>
</div>
<div style="float:left;margin-left:10px;width:100px;margin-top:3px;"><a href="javascript:jump();">转到</a>
	<input style="width:50px;height:12px;margin-left:0px;" type="text" id="ys" value="${PAGE_INFO.pageNo}">页
</div>
<div style="float:left;margin-left:0px;margin-top:3px; width:150px;">
共${PAGE_INFO.totalpage }页&nbsp;${PAGE_INFO.totalCount }条数据
</div>
<%} %>


</div>
</td></tr>