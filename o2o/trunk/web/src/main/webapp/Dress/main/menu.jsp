<%@ page language="java"  pageEncoding="UTF-8"%>
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

<script type="text/javascript">
<!--
ServicePath="<%=request.getContextPath() %>";
$(function(){
	$(".menuUrlpxy").click(function(){
		/*$(".left_liebiao").css("display","none");
		var m_div=document.createElement("div");
		m_div.className="ifram_div";
		m_div.style.marginLeft="8px";
		m_div.innerHTML="<iframe id=right name=right src=\"<%=request.getContextPath() %>/html/ibms/"+$(this).attr("rel")+"\" frameBorder=0 width=\"100%\" height=\"100%\" scrolling=\"no\" onload=\"messagefn();IntervalNo=null;dyniframesize('right');\"></iframe>";
		document.body.appendChild(m_div);
		$(".xiang").html(this.innerHTML);*/
		window.parent.show($(this).attr("id"),$(this).attr("title"),$(this).attr("rel"));
		
	});
})


//-->
</script>
<div class="left_liebiao">
<c:forEach items="${menu.children}" var="info">
<c:if test="${info.is_menu==1 }">
<div class="leikuai12">
<div class="left_leibiao_kuai">
<div class="left_leibiao_kuai11" style="padding-top:5px;"><img src="<%=request.getContextPath() %>/web/jsp/admin/img/${info.img_url }" /></div>
<div class="left_leibiao_kuai22"><a style="cursor:pointer" rel="<%=request.getContextPath() %>/html/ibms/${info.url }" id='${info.id }' title='${info.res_name }' class="zhu2 menuUrlpxy">${info.res_name }</a></div>
</div>
</div>
</c:if>
</c:forEach>
</div>

