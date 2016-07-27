<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/taglib/fmt.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglib/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglib/fn.tld"%>
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

<fmt:setBundle basename="locale" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><fmt:message key="sys.name" /></title>
<link href="<%=request.getContextPath()%>/css/kua.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/human2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common-min.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/dialog.js"></script>

<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/js/jq-dateinput/ui.datepicker.css" title="win2k-cold-1" />
<style type="text/css">
	.error{color:#ff0000;}
</style>
</head>
<body>
