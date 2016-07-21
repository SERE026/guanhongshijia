<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ include file="/Dress/include/taglib.jsp"%>
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
  </head>
  <body>
  	
<div class="shaidan pageBox" >
<div class="shaidan">
<c:forEach var='comment' items='${DATA}' varStatus='index'>
<div class="shaidan_kuai">
<div class="shaidan_kuai_leaa">
<div class="shaidan_kuai_leaa_xiao">
<a href="#"><img src="<%=request.getContextPath()%>/upload/${comment.info.txImage}" width="100%" height="100%" border="0" /></a>
</div>
<div class="shaidan_kuai_leaa_zi"><a href="#" class="zhu1">${comment.info.nickname}</a></div>
</div>
<div class="shaidan_kuai_lebb"><img src="<%=request.getContextPath()%>/img/spdet_34.gif" /></div>
<div class="shaidan_kuai_lecc">
<div class="shaidan_xing">
<div class="shaidan_xing_zi">评分：</div>
<div class="shaidan_xing_tu">
<c:set var="leve" value="${comment.leve }" scope="request"/>

<%Double leve = (Double)request.getAttribute("leve"); 
if(leve !=null){
for(int i=0;i<leve;i++){%>
<img src="<%=request.getContextPath()%>/img/xing_cai.jpg" />
<%}} %>
</div>
</div>

<div class="shaidan_xian">&nbsp;</div>
<div class="shaidan_jvti">
<c:set var="imgs" value="${fn:split(comment.imageSrc,';') }"/>
<c:forEach var="image" items="${imgs}" varStatus='image_index'>
<div class="shaidan_jvti_kuai"><a href="javascript:;"><img src="<%=request.getContextPath()%>/upload/issue/${image}" border="0" width="100%" height="100%"/></a>
</div>
</c:forEach>
</div>


</div>
</div>

</c:forEach>
</div>
  </body>
</html>
