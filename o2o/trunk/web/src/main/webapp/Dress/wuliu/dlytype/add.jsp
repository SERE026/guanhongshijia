<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<style type="text/css"> 
body{
	margin:0px;
	font-family:Arial,"宋体",Verdana,sans-serif;
	font-size:12px;
	overflow-y:auto;
}
html,body {padding: 0;margin: 0; overflow-x:hidden; overflow-y:auto;}
dl,dd{margin:0px}
ul{
	list-style-type:none;
	margin:0px;
	padding:0px;
	
}
</style>

<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/kua.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/human2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/common-min.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/dialog.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/DlyTypeInput.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/Eop.Dialog.Remote.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/eop.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/jquery.checktree.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/style/SelectTree.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/style/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/jq-dateinput/ui.datepicker.css" title="win2k-cold-1" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/input.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/grid.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/validate.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/dialog.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/jquery.treeview.css" rel="stylesheet" type="text/css" />

<style type="text/css">
	.error{color:#ff0000;}
</style>
</head>
<body>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/css/checktree.css" />
<style> 
.division {
	line-height: 150%;
	margin: 10px;
	padding: 5px;
	white-space: normal;
}
deliveryArea.ol  {
list-style-type:decimal;
}
deliveryArea.ul, deliveryArea.ol {
margin:0;
padding:0;
}
 
li.division {
background:none repeat scroll 0 0 #FFFFFF;
border-color:#CCCCCC #BEC6CE #BEC6CE #CCCCCC;
border-style:solid;
border-width:1px 2px 2px 1px;
line-height:150%;
margin:10px;
padding:5px;
white-space:normal;
}
 
.lnk {
color:#000099;
cursor:pointer;
text-decoration:underline;
}
.checktree{
	height:350px;
	overflow-y:auto;
}
 
</style>

<script type="text/javascript">
	function submit(){
		if($("#form1").checkall()){
		$("input[name=codecheck]").each(function(i,check){
			if(returned==0){
			if(i>0){
				if($(this).attr("checked")){
					hdfk=hdfk+"1%";
					}else{
					hdfk=hdfk+"0%";
				}
			}
			}
		});
		$("input[name=oneprice]").each(function(i,check){
				if(returned==0){
			if(i>0){
			 if($(this).val()==''){
			 	alert("支持的配送地区中的首重费用有空，请仔细检查后提交！");
			 	$(this).focus();
			 	scfr="";
			 	returned=1;
			 }
			scfr=scfr+$(this).val()+"%";
			}
		}
		});
			$("input[name=towprice]").each(function(i,check){
				if(returned==0){
			if(i>0){
			 if($(this).val()==''){
				alert("支持的配送地区中的续重费用有空，请仔细检查后提交！");
				$(this).focus();
				xcfr="";
			 	returned=1; 
			 }
			xcfr=xcfr+$(this).val()+"%";
			}
			}
		});
		if(returned==0){
		$("#areaid").val(areaid);
		$("#areaname").val(areaname);
		$("#hdfksum").val(hdfk);
		$("#scfrsum").val(scfr);
		$("#xcfrsum").val(xcfr);
		document.form1.submit();
		}
	}
}
$(function(){
areaname="";
areaid="";
hdfk="";
scfr="";
xcfr="";
returned=0;
areagroupname="0";
areagroupid="0";
	$("#form1").validate();
	$("#wlbj").change(function(){
		if(this.checked){
			$("#bjsz").css("display","");
			$("#lowest").val("");
			$("#bjfl").val("");
		}else{
			$("#bjsz").css("display","none");
			
		}
	
	});

		$("#qymrfr").change(function(){
		if(this.checked){
			$("#mrfr").css("display","");
				$("#mrscfr").val("");
			$("#mrxzfr").val("");
		}else{
			$("#mrfr").css("display","none");
		}
	
	});
	
	$("#tysz").click(function(){
		
		$(".tyszdx").css("display","");
		$(".zddq").css("display","none");
			$("#mrscfr").val("");
			$("#mrxzfr").val("");
			$("#qymrfr").attr("checked","")
			$("#mrfr").css("display","none");
			
			$(".division ").each(function(i,checked1){
			if(i>0){
			this.remove();
			}
			});
		
		
	});
	$("#zddq").click(function(){
	
		$(".tyszdx").css("display","none");
		$(".zddq").css("display","");
		$("#addwtmoney").val("");
		$("#firstmoney").val("");
		$("#zchdfkps").attr("checked","");
		
	});
	DlyTypeInput.init();
		
})
</script>
<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2">
	<tr><td></td></tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
					<a href="<%=request.getContextPath()%>/html/manage/dlytype/list">
			<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/dlytype" method="post">
<input type="hidden" name="_method" value="post" />
<input type="hidden" name="areaname" id="areaname" value=""/>
<input type="hidden" name="areaid" id="areaid" value=""/>
<input type="hidden" name="scfrsum" id="scfrsum" value=""/>
<input type="hidden" name="xcfrsum" id="xcfrsum" value=""/>
<input type="hidden" name="hdfksum" id="hdfksum" value=""/>
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4"><strong>新增配送方式</strong></td>
  </tr>
    <tr>
     <td class="discription" style="width: 150px;"><span style="color:#ff0000">*</span>配送方式名称:</td>
  	  <td ><input name="dlyname" id="dlyname" class="noNull" msg="配送方式名称不能为空！"/></td>
  	 
  </tr>
  <tr>
   <td class="discription" style="width: 150px;">选择默认物流公司:</td>
  	  <td >
  	  <select name="wlcompany.wlcompany_id" style="width:154px; height:23px;">
  	    	<c:forEach items="${company }" var="info">
						  <option value="${info.wlcompany_id }">${info.name }</option>
						</c:forEach>
						</select>
  	  </td>
  	  </tr>
      <tr>
     <td class="discription" style="width: 150px;">重量设置:</td>
  	  <td >
  	  <div>
  	  首重重量<input type="text" name="firstwt" style="width: 50px;"/>克&nbsp;&nbsp;&nbsp;&nbsp;
  	   续重单位<input type="text" name="addwt" style="width: 50px;"/>克
  	   </div>
  	   	  <input type="checkbox" id="wlbj" name="valuation" value="1"  style="display:none"/>
  	  </td>
  	  </tr>
  	  
  	  <tr id="bjsz" style="display:none">
     <td class="discription" style="width: 150px;">保价设置:</td>
     <td>  
     费率<input type="text" name="bjfl" id="bjfl" style="width: 50px;"/>%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      最低保价费<input type="text" name="lowest" id="lowest" style="width: 50px;"/>
     </td>
     </tr>
      <tr>
     <td class="discription" style="width: 150px;">地区费用类型:</td>
  	  <td >
  	 <input type="radio" name="valuetype" value="0" id="tysz" checked/>统一设置  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="radio" name="valuetype" value="1" id="zddq"/>指定配送地区和费用
  	  </td>
  	  </tr>
  	  <tr class="tyszdx">
     <td class="discription" style="width: 150px;">配送费用:</td>
  	  <td >
  	  <div>
  	 首重费用<input type="text" name="firstmoney" id="firstmoney" style="width: 50px;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      续重费用<input type="text" name="addwtmoney"  id="addwtmoney" style="width: 50px;"/>
      </div>
        	  <input type="checkbox" id="zchdfkps" name="paytype" value="1"  style="display:none" />
  	  </td>
  	  </tr>
  	 
  	  
  	  
  	  
  	  
  	  
  	  <tr class="zddq"  style="display:none">
  	       <td class="discription" style="width: 150px;">支持的配送地区:</td>
  	  <td>
  	  <input type="checkbox" id="qymrfr" name="mrfr" value="1" checked/>启用默认费用    (注意：未启用默认费用时，不在指定配送地区的顾客不能使用本配送方式下订单)
  	 
  	 <div style="" id="mrfr">
 
首重费用 <input type="text"   name="mrscfr" id="mrscfr" style="width: 30px;"   value="0.0"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
续重费用 <input type="text"   name="mrxzfr"  id="mrxzfr" style="width: 30px;" value="0.0" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 
</div>
  	 
  	 
  	  <div class="deliveryArea">
  	  <ol style="list-style: decimal outside none;">
			
			   
				<li style="line-height: 30px;display:none" class="division" id="lieach">
	 				
					<div class="deliverycity" >
	                     <span class="delCfgBtn" style="float: right;"><img border="none" title="删除" alt="删除" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/liu2.jpg" ></span>
	                  	 配送地区 <input type="text"  disabled="true"  readonly="true" name="areaGroupName" style="width: 300px;" dataType="string" required="true"/>
	                     <input type="hidden"  disabled="true" id="areaGroupId" name="areaGroupId" ><img border="none" class="editAreaImg" title="编辑地区" alt="编辑地区" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/liu1.jpg" class="regionSelect"/>
	                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                     <label style="display:none"><input type="hidden" disabled="true" name="has_cod" value="0"/><input type="checkbox" disabled="true" value="1" name="codecheck" id="codecheck" />支持货到付款</label>
	                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                </div>
	                
					<div class="deliveryexpbox" style="line-height: 30px;">			
						
<div style="" class="deliveryexp">
 
首重费用 <input type="text"   name="oneprice" style="width: 30px;" disabled="true" dataType="float" required="true" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
续重费用 <input type="text"   name="towprice" style="width: 30px;" disabled="true" dataType="float" required="true" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 
</div>
				</li>
				</ol> 
							
    </div>
			<input type="button" id="addCfgBtn" class="sysbtn" value="为指定的地区设置运费" />(注意：要在省以下的地区打上钩才能有效的选择此地区)

    </td>
  	  </tr>
  	  
  	  
  	  
  	  
  	  
  	  
  	  
  	   <tr>
     <td class="discription" style="width: 150px;">排序:</td>
  	  <td >
  	 	<input type="text" name="count" style="width: 50px;" value="9999"/>
  	  </td>
  	  </tr>
  	   <tr style="display:none">
     <td class="discription" style="width: 150px;">状态:</td>
  	  <td >
  	 <input type="radio" name="stats" value="0" checked/>启用  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="radio" name="stats" value="1"/>关闭
  	  </td>
  	  </tr>
  	  	  <tr>
  	  	     <td class="discription" style="width: 150px;">详细介绍:</td>
  	  	     <td><textarea rows="10" cols="100" name="detailed" >${info.detailed }</textarea></td>
  	  	  </tr>
 </table>
</form>
</td>
</tr>
</table>
<div id="area_selected">
<ul class="checktree" style="margin-left: 15px;">
</ul>
<div class="footContent" >
<div style="width: 200px; height: 40px; margin: 0pt auto;"
	class="mainFoot">
<table style="margin: 0pt auto; width: auto;">
	<tbody>
		<tr>
			<td><b class="save">
			<button class="submitBtn">保存</button>
			</b></td>
		</tr>
	</tbody>
</table>
</div>
</div> 
</div>
