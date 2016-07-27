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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title><fmt:message key="ognz.title" /></title>
<link href="<%=request.getContextPath()%>/web/jsp/admin/css/human2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/admin/js/jquery-1.4.2.min.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/web/jsp/admin/js/dialog.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/js/jsTree/jquery.jstree.js"></script>
<script language="javascript">
$(function () {  
    $("#divForTree").bind("select_node.jstree", //绑定节点点击事件
    	function (e, data) {
    		window.parent.document.getElementById("contentList").src = "<%=request.getContextPath()%>/html/area/list?parent_id="+data.rslt.obj.attr("id");
    }).jstree({//从这里开始初始化JSTree
    	"xml_data" : {
    		"data" : "<root><item id='${ognzId}' state='closed'><content><name>${ognzName}</name></content></item></root>",//初始化根
    		"ajax" : {
    			"url" : "<%=request.getContextPath()%>/html/area/getOgnzList",//每次获得数据从这个链接
    			"data" : function (NODE) {//请求数据时带的参数列表，可通过getParameter获得
    				return { 
    					parent_id : $(NODE).attr("id") || 0,
    					i:Math.random()
    				};
    			}
    		},
    		"xsl" : "flat"
    	},
    	"ui" : {
    		"select_limit" : 1
    	},
    	"plugins" : [ "themes", "xml_data", "ui" ]
	});
});
</script>
</head>
<body>

<div id="divForTree"></div>

</body>
</html>