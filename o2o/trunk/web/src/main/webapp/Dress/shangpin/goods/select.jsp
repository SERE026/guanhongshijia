<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/taglib.jsp" %>
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

<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>

<script type="text/javascript">
	var i=1;

	function allChoose(){
		$("[name='list']").attr("checked",'true');
	}
	
	function allCancel(){
		$("[name='list']").removeAttr("checked");
	}
	function xz(){
	
		if(i==1){
			allChoose();
			i=0;
		}else{
			allCancel();
			i=1;
		}
	}
	function delall(){
		if(confirm("请确认是否执行删除操作!"))
			document.getElementById("del").submit();
	}
	function delUrl(url){
		if(confirm("请确认是否执行删除操作!")){
			window.location=url;
		}
	}
	function cz(){
		resultAjax("<%=request.getContextPath() %>/html/manage/goods/goodsJsonPage/list","shanJia="+$("#shanJia").val(),goodsResult,"json");
	}
	
    function refresh (){
    	resultAjax("<%=request.getContextPath() %>/html/manage/goods/goodsJsonPage/list","",goodsResult,"json");
    }
    function goodsResult(data){
		var strHTML="";
		for(var i=0;i<data[0].data.length;i++){
			 strHTML += "<tr>";  
			 strHTML+="<td>"+'<input id="list" name="list" type="checkbox" value="'+data[0].data[i].id+'" />'+"</td>"
             strHTML += "<td>"+data[0].data[i].name+"</td>";   
             strHTML += "<td>"+data[0].data[i].shangJia+"</td>";   
             strHTML += "</tr>";   
		}
		$("#Data").empty();
		if(data[0].pageSize=="0"){
		alert("dd");
			$("#Data").html("<div align='center'>没有数据</div>");
			return;
		}
	
		$("#Data").html(strHTML);
		$(".pageNo").val(data[0].pageNo);
		$(".pageSize").html(data[0].pageSize);
	}
    function saveGoods(){
    	var valID="";
		var valName="";
		$("input[type='checkbox'][name='list']").each(function(i){
					if(this.checked){
						valID+=$(this).val()+",";
						valName+=$(this).parent().parent().find("td:eq(1)").text().trim()+",";
					}
		  });
		valID=valID.replace(/,$/g,"");//id
		alert(valID);
		valName=valName.replace(/,$/g,"");//id
		$("#goodsID").val(valID);
		$("#goodsOpen").val(valName);
		 
		tb_remove();
    }
    
    function tb_remove() {
    	  $("#TB_imageOff").unbind("click");
    	 $("#TB_closeWindowButton").unbind("click");
    	 $("#TB_window").fadeOut("fast",function(){$('#TB_window,#TB_overlay,#TB_HideSelect').trigger("unload").unbind().remove();});
    	 $("#TB_load").remove();
    	 if (typeof document.body.style.maxHeight == "undefined") {//if IE 6
    	  $("body","html").css({height: "auto", width: "auto"});
    	  $("html").css("overflow","");
    	 }
    	 document.onkeydown = "";
    	 document.onkeyup = "";
    	    //window.location.reload();
    	    return false;
    }
    
    function goPage(){
    	resultAjax("<%=request.getContextPath() %>/html/manage/goods/goodsJsonPage/list","pageNo="+$(".pageNo").val(),goodsResult,"json");
    }
    var pageNo=1;
    function goPageNext(){
    	pageNo=pageNo+1;
    	var pageSize=parseInt($(".pageSize").text());
    	if(pageNo>pageSize){
    		alert("已经是最后一页！");
    		goPage();
    		return;
    	}
    	resultAjax("<%=request.getContextPath() %>/html/manage/goods/goodsJsonPage/list","pageNo="+pageNo,goodsResult,"json");
    }
    function goPagePrevious(){
    	var pageSize=parseInt($(".pageSize").text());
    	if(pageNo==1){
    		alert("已经没有上一条！");
    		goPage();
    		return;
    	}
    	pageNo=pageNo-1;
    	resultAjax("<%=request.getContextPath() %>/html/manage/goods/goodsJsonPage/list","pageNo="+pageNo,goodsResult,"json");
    }
</script>




<table cellspacing="2" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
		</td>
	</tr>
	<tr>
		<td>
			<form method="post" id="czlist" name="form1" action="<%=request.getContextPath()%>/html/manage/goods/select/list">
				<input type="hidden" name="pageNo" id="pageNo" value=${PAGE_INFO.pageNo } />
				<table cellspacing="0" cellpadding="0">
					<tr>
					   <td class="tab2_tou">
							<a href="javascript:saveGoods();">
        						<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" /></a>
        				</td>
						<td class="tab2_tou">
							<a href="javascript:refresh();">
								<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" />
							</a>
						</td>
						<td class="chazhaofanshi1">商家：</td>
						<td><input type="text" value="" style="color:#494949" name="shanJia" id="shanJia"/></td>
						<td class="tab2_tou">
							<a href="javascript:cz();"><img border="0" src="<%=request.getContextPath()%>/img/222.gif"></a>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<form method="post" id="del" action="<%=request.getContextPath()%>/html/manage/goods/all/del">
				<input type="hidden" name="_method" value="delete" />
				<table cellspacing="0" cellpadding="0" class="table4_da">
					<thead>
					<tr>
						<td>
							<input name="" type="checkbox" value="" onclick="xz();" />
						</td>
						<td>商品</td>
						<td>商家</td>
					</tr>
					</thead>
					<tbody id="Data">
						<c:forEach var='Info' items='${DATA}' varStatus='index'>
						<tr>
							<td>
								<input id="list" name="list" type="checkbox" value="${Info.goods_id}" />
							</td>
							<td>
	                          ${Info.name}
							</td>
							<td>
	                          ${Info.shangJiaInfo.name}
							</td>
						</tr>
					</c:forEach>
					</tbody>
					
				</table>
				<div class="fenye" style="margin-left: 100px;margin-right: auto;">
					<div class="fenye_shang" id="Previous"><a href="javascript:goPagePrevious();"><img src="<%=request.getContextPath()%>/img/homeaa_19.gif"></a></div>
					<div class="fenye_shugai"><input type="text" class="fegai_xie pageNo" name=""></div>
					<div class="fenye_shugai22">/<span class="pageSize"></span>&nbsp;&nbsp;<a class="goClass" href="javascript:goPage();">跳转</a></div>
					<div class="fenye_xia"><a href="javascript:goPageNext();"><img border="0" src="<%=request.getContextPath()%>/img/homeaa_26.gif"></a></div>
			</div>
			</form>
		</td>
	</tr>
</table>
<script type="text/javascript">
$(function(){

	  refresh ();
   
})
</script>