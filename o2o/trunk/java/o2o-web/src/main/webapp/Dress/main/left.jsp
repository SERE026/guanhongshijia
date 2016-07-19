<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<link href="<%=request.getContextPath()%>/Dress/css/kua.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Dress/css/jquery.treeview.css" rel="stylesheet" type="text/css" />
<SCRIPT type=text/javascript src="<%=request.getContextPath()%>/Dress/js/jquery.treeview.js"></SCRIPT>
<script type="text/javascript">
	var crrentMenu=null;
	$(function(){
		$('#navigation').treeview({
				persist: "location",
				collapsed: true,
				unique: true
			});
		$(".left").css("height",$(window).height());
		$(".left").css("overflow-y","auto");
		$(".left").css("overflow-x","hidden");
		$("#navigation a").click(function(){
			$(".select").removeClass("select");
			$(this).addClass("select");
		})
		
		$(".menu").click(function(){
			if($(this).hasClass("open")){
				$(this).addClass("left_leixingda").removeClass("left_leixingda22");
				//$("."+$(this).attr("mapped")).css("display","none");
				$(this).removeClass("open");
				$("."+$(this).attr("mapped")).slideToggle("slow").css("display","none");
				
			}else{
				$(this).addClass("left_leixingda22").removeClass("left_leixingda");
				//$("."+$(this).attr("mapped")).css("display","");
				$(this).addClass("open");
				$("."+$(this).attr("mapped")).slideToggle("slow").css("display","");
			}
		})
		
	})
</script>
<style type="text/css">
<!--
.collapsable a{color:#fff}
.expandable a{color:#fff}
a.select{color:#d61900}
-->
</style>

<div class="left">
<div class="r_top"><img src="<%=request.getContextPath()%>/Dress/img/right_03.gif" /></div>


<c:forEach items="${resinfolist}" var="resinfo" varStatus="index">

<div class="r_kuai">
<div mapped="zmun_${index.count }" <c:if test="${index.count==1 }"> class="left_leixingda22 open menu"</c:if><c:if test="${index.count!=1 }"> class="left_leixingda menu"</c:if>>
<a href="javascript:;" class="zhu5">&nbsp;&nbsp;&nbsp;&nbsp;${resinfo.res_name }</a>
</div>
</div>

<c:forEach items="${resinfo.children}" var="c" varStatus="cindex">
<div class="r_kuai zmun_${index.count }" <c:if test="${index.count!=1 }"> style="display:none"</c:if>>
<div class="left_leixingda33">
<a href="<%=request.getContextPath()%>/html/manage/${c.url} " target="mainFrame" class="zhu5">&nbsp;&nbsp;&nbsp;&nbsp;${c.res_name }</a>
</div>
</div>
</c:forEach>





</c:forEach>


</div>
</div>



</body>
</html>