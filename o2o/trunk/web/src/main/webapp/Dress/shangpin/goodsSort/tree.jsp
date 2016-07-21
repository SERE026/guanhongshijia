<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />

<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/tree/zTreeStyle.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/jquery-1.4.2.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/tree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/tree/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript">
<!--
	function onCheck(e, treeId, treeNode) {
			if(treeNode.lev<4){
			window.parent.document.getElementById("mainFrame").src="<%=request.getContextPath()%>/html/manage/goodsSort/list?parent="+treeNode.id;
			}
	}
	var setting = {
			async: {
				enable: true,
				url: getUrl,
				dataFilter: filter
			},
			callback: {
				onClick: onCheck
			}
		};
		
		function getUrl(treeId, treeNode) {
			var param = "parentId="+treeNode.id+"&flag=xy";
			return "<%=request.getContextPath()%>/html/manage/goodsSort/tree?" + param;
		}
		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
				childNodes[i].lev=parentNode.lev+1;
				if(childNodes[i].lev<4){
					childNodes[i].isParent=true;
					childNodes[i].nocheck=true;
				}else{
					childNodes[i].check=true;
				}
			}
			return childNodes;
		}
		function beforeClick(treeId, treeNode) {
			if (!treeNode.isParent) {
				return false;
			} else {
				return true;
			}
		}
		function beforeExpand(treeId, treeNode) {
			if (!treeNode.isAjaxing) {
				startTime = new Date();
				treeNode.times = 1;
				ajaxGetNodes(treeNode, "refresh");
				return true;
			} else {
				return false;
			}
		}
		var log, className = "dark";
		function beforeAsync(treeId, treeNode) {
			
			return true;
		}
		function onAsyncSuccess(event, treeId, treeNode, msg) {
			
		}
		
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}

		function refreshNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			type = e.data.type,
			silent = e.data.silent,
			nodes = zTree.getSelectedNodes();
			if (nodes.length == 0) {
			}
			for (var i=0, l=nodes.length; i<l; i++) {
				zTree.reAsyncChildNodes(nodes[i], type, silent);
				if (!silent) zTree.selectNode(nodes[i]);
			}
		}
		function ajaxGetNodes(treeNode, reloadType) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			if (reloadType == "refresh") {
				treeNode.icon = "<%=request.getContextPath()%>/web/jsp/admin/advPrice/img/loading.gif";
				zTree.updateNode(treeNode);
			}
			zTree.reAsyncChildNodes(treeNode, reloadType, true);
		}
	var zNodes =[
			{name:"选择商品分类", id:"", lev:1, isParent:true,nocheck:true}
		];
	$(function(){
		$.fn.zTree.init($("#treeDemo"), setting,zNodes);
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.setting.check.chkboxType = { "Y":"", "N":""};
	})
//-->
</script>

</head>
<body style="">

<div id="treeDemo" class="ztree" ></div>

</body>
</html>