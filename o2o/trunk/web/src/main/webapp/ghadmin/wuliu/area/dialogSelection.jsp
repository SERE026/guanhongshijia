<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
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

<link href="<%=request.getContextPath()%>/css/dialogSelection.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jsTree/jquery.jstree.js"></script>


<script language="javascript">
var ids = "";
var names = "";
$(function () {  
    $("#divForTree").bind("select_node.jstree", //绑定节点点击事件
    	function (e, data) {
    		//alert(data.rslt.obj.attr("id")+data.inst.get_text(data.rslt.obj));
    		ids = data.rslt.obj.attr("id");
    		names = data.inst.get_text(data.rslt.obj);
    }).jstree({//从这里开始初始化JSTree
    	"xml_data" : {
    		"data" : "<root><item id='0' state='closed'><content><name>区域</name></content></item></root>",//初始化根
    		"ajax" : {
    			"url" : "<%=request.getContextPath()%>/html/ibms/area/getOgnzList",//每次获得数据从这个链接
    			"data" : function (NODE) {//请求数据时带的参数列表，可通过getParameter获得
    				return { 
    					parent_id : $(NODE).attr("id") || 0,
    					i : Math.random()
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
//添加数据
function addValue(){
	if(ids != "0" &&ids != "" && document.getElementById("ids").value.indexOf(ids) == -1){
		var str = "<div id='"+ids+"_div' class='m_lie'>";
		str += "<a href='javascript:onSelected(\""+ids+"\",\""+names+"\")' class='zhu1'>";
		str += "&nbsp;&nbsp;"+names+"</a></div>";
		document.getElementById("selected").innerHTML += str;
		if(document.getElementById("ids").value == ""){
			document.getElementById("ids").value = ids;
			document.getElementById("names").value = names;
		}else{
			document.getElementById("ids").value += "," + ids;
			document.getElementById("names").value += "," + names;
		}
	}
	ids = "";
	names = "";
}
//删除数据
function deleteValue(){
	if(ids != "" && document.getElementById("ids").value.indexOf(ids) != -1){
		document.getElementById(ids+"_div").parentNode.removeChild(document.getElementById(ids+"_div"));
		document.getElementById("ids").value = document.getElementById("ids").value.replace(ids+",", "");
		document.getElementById("ids").value = document.getElementById("ids").value.replace(ids, "");
		document.getElementById("names").value = document.getElementById("names").value.replace(names+",", "");
		document.getElementById("names").value = document.getElementById("names").value.replace(names, "");
	}
	ids = "";
	names = "";
}
//选择数据
function onSelected(id, name){
	ids = id;
	names = name;
}
//保存数据
function saveValue(){
	<c:if test="${single == 'true'}">
	if(document.getElementById("ids").value.indexOf(",")!=-1){
		alert("只能选择一条数据");
		return;
	}
	</c:if>
	<c:if test="${not empty maxSelect}">
	if(document.getElementById("ids").value.split(",").length > ${maxSelect}){
		alert("最多只能选择${maxSelect}条数据");
		return;
	}
	</c:if>
	var obj = window.dialogArguments;
	if(obj){
		obj.document.getElementById("${fieldId}").value = document.getElementById("ids").value;
		if(obj.document.getElementById("${fieldName}").type == "text"){//input
			obj.document.getElementById("${fieldName}").value = document.getElementById("names").value;
		}else{//div
			obj.document.getElementById("${fieldName}").innerHTML = document.getElementById("names").value;
		}
		if(obj.majaxFn!=null){
			obj.majaxFn(document.getElementById("ids").value);
		}
	}else{
		window.opener.document.getElementById("${fieldId}").value = document.getElementById("ids").value;
		if(window.opener.document.getElementById("${fieldName}").type == "text"){//input
			window.opener.document.getElementById("${fieldName}").value = document.getElementById("names").value;
		}else{//div
			window.opener.document.getElementById("${fieldName}").innerHTML = document.getElementById("names").value;
		}
		if(window.opener.majaxFn!=null){
			window.opener.majaxFn(document.getElementById("ids").value);
		}
	}
	
	
	window.close();
}
</script>
</head>
<body>
<input type="hidden" id="ids" name="ids" value="${selectedIds }"/>
<input type="hidden" id="names" name="names" value="${selectedNames }"/>
<div class="container">
<div class="top"><fmt:message key="selection.ognz" /></div>
<div class="middle">
<div class="middle_1" id="divForTree"></div>
<div class="middle_2">
<div class="tu"><a href="javascript:addValue();"><img src="<%=request.getContextPath()%>/web/jsp/admin/img/asdf_06.gif" border="0" /></a></div>
<div class="tu"><a href="javascript:deleteValue();"><img src="<%=request.getContextPath()%>/web/jsp/admin/img/asdf_10.gif" border="0" /></a></div>
</div>
<div class="middle_3" id="selected">
<c:forEach var='Info' items='${selectedList}'>
<div id="${Info.id }_div" class="m_lie"><a href="javascript:onSelected('${Info.id }','${Info.name }')" class="zhu1">&nbsp;&nbsp;${Info.name }</a></div>
</c:forEach>
</div>

</div>
<div class="clear">&nbsp;</div>
<div class="bottom">
<div><a href="#" onclick="window.close();"><img src="<%=request.getContextPath()%>/web/jsp/admin/img/input1_09.gif" border="0" /></a></div>
<div><a href="#" onclick="saveValue();"><img src="<%=request.getContextPath()%>/web/jsp/admin/img/input1_07.gif" border="0" /></a></div>
</div>

</div>

</body>
</html>
