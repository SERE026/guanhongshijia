<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/taglib.jsp"%>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title><fmt:message key="ognz.title" /></title>
<link href="<%=request.getContextPath()%>/css/human2.css" rel="stylesheet" type="text/css" />
</head>


<frameset cols="240,*" frameborder="no" border="0" framespacing="0">
  <frame src="<%=request.getContextPath()%>/html/manage/ognz/tree" name="tree" scrolling="yes" noresize="noresize" id="tree"  />
  <frame src="<%=request.getContextPath()%>/html/manage/ognz/list" id="contentList" name="contentList"  />
</frameset>
<noframes>
<body>
<fmt:message key="frame.error"/>
</body>
</noframes>
</html>