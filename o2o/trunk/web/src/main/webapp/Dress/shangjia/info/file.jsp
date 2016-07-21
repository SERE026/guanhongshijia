<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
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

<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/shangpin/goods/ajaxfileupload.js"></script>
<style type="text/css">
.upfile{width:30px;margin-left:-60px;filter:progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=0,finishOpacity=0);opacity:0;}
</style>
<script type="text/javascript">
<!--
	$(function(){
		eventchange();
		closeFie();
	})
	
	function eventchange(){
		$("#fileupload").change(function(){
			var fileName=$(this).val();
			fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
			ajaxFileUpload(fileName);
			$(this).replaceWith('<input name="fileToUpload" type="file" id="inputFileID" class="upfile" />');
			eventchange();
		});
	}
	function submit(){
		if($("#form1").checkall()){
			$("#form1").submit();
		}
	}
	function upclp(){
		$(".uping").css("display","none");
    	$(".uping div:eq(1)").html("");
    	$(".upBtn").css("display","");
    	closeFie();
	}
	function closeFie(){
		$(".coleFile").unbind("click").click(function(){
			var f=$(this);
			$.ajax({
			  type: 'POST',
			  url: "<%=request.getContextPath()%>/html/manage/storeInfo/colseFile",
			  data: "fileName="+f.parent().find("div:eq(0)").text(),
			  dataType: "json",
			  success: function(data){
			  		if(data.status==0){
			  			f.parent().remove();
			  		}
			  }
			})
		})
	}
	function a_handlerBack(d){
		  var data = eval("("+d+")");
          if(data.status==0){
           		var html='<div style="width:300px;height:30px;">';
				html+='<div style="line-height:30px;width:250px;float:left;">'+data.fileName+'</div>';
				html+='<div style="line-height:30px;width:50px;float:left;" class="coleFile">删除</div>';
				html+='</div>';
           		$(".fileBox").append(html);
           }
           closeFie();
	}
	function a_showProgress(name,num){
		$(".uping").css("display","");
		$(".uping div:eq(0)").css("width",num);
		$(".uping div:eq(1)").html(num+"%");
	}
	
	function ajaxFileUpload(fileName)
    {
    	
    	$(".uping div:eq(1)").html("文件:"+fileName+"，上传中...");
    	$(".uping").css("display","");
    	$(".upBtn").css("display","none");
        $.ajaxFileUpload
        (
            {
                url:"<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/shangjia/info/upload.jsp",//用于文件上传的服务器端请求地址
                secureuri:false,//一般设置为false
                fileElementId:'fileupload',//文件上传空间的id属性  <input type="file" id="file" name="file" />
                dataType: 'json',//返回值类型 一般设置为json
                success: function (html, status)  //服务器成功响应处理函数
                {
                	var data = eval(html);
                	window.setTimeout("upclp()",1500);
                	$(".uping div:eq(1)").html("上传成功，稍后完成处理...");
                	if(data.status==0){
                		var html='<div style="width:300px;height:30px;">';
							html+='<div style="line-height:30px;width:250px;float:left;">'+data.fileName+'</div>';
							html+='<div style="line-height:30px;width:50px;float:left;" class="coleFile">删除</div>';
							html+='</div>';
                		$(".fileBox").append(html);
                	}else{
                		alert("添加失败！");
                	}
                	
                }
            }
        )
        
        return false;

    }
//-->
</script>

<form name=form1  id="form1" action="<%=request.getContextPath()%>/html/manage/storeInfo/disUpdate" method="post">
<input type="hidden" id="shangjia_id"   name="shangjia_id" value="${info.shangjia_id }"  />
<table cellspacing="0" cellpadding="0" class="tab2">
	<tr>
		<td class="tab2_top">
			<input type="hidden" name="_method" value="post" />
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td class="tab2_tou">
						<a href="javascript:location.reload();">
							<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/biao_03.gif" border="0" />
						</a>
					</td>
					<td class="tab2_tou" >
						<a href="javascript:window.history.go(-1);">
						<img src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/img/return_btn.gif" border="0" /></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0" cellpadding="0" class="table3_da">
				<thead>
				<tr>
					<td colspan="6">
						<strong>店铺模板文件管理</strong>
					</td>
				</tr>
				</thead>
				<tr>
						<tr>
							<td class="discription" style="width: 150px;">
								店铺文件：
							</td>
							<td colspan="5">
								<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/AC_OETags.js"></script>
						   		<script type="text/javascript" src="<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/js/fileUpload.js"></script>
								<!-- 上传附件按钮 -->
								<script language="JavaScript" type="text/javascript">
									var imageCount=0;
									function removeFiles(fileName){
										document.getElementById(fileName).parentNode.removeChild(document.getElementById(fileName));
									}
									AC_FL_RunContent(
										"src", "<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/upload/merchants/fileUpload",
										"width", "100",
										"height", "30",
										"id", "fileUpload",
										"quality", "high",
										"bgcolor", "#ffffff",
										"name", "fileUpload",
										"wmode","transparent",
										"allowScriptAccess","sameDomain",
										"type", "application/x-shockwave-flash",
										"pluginspage", "http://www.adobe.com/go/getflashplayer",
										"flashVars","flexID=a&userID=${UserInfo.login_id}&uploadURL=<%=request.getContextPath()%>/<%=Constants.ADMIN_ADDRESS%>/upload/merchants/upload.jsp&label=图 片 上 传&succeed=a_completeUpload"
									);
									
									/**
										上传产品照片
									**/
									function a_completeUpload(fileName, realName){
										
									}
								</script>
								<div style="width:400px;height:30px;margin-top:5px">
									<div class="uping" style="width:400px;display:none"  >
										<div style="float:left;width:100px;margin-top:10px;height:10px;background-color:#ff6600;font-size:8px;">
											
										</div>
										<div style="float:left;width:100px;height:30px;line-height:30px;">12%</div>
									</div>
								</div>
								<div class="fileBox">
									<c:forEach items="${data}" var="f">
										<div style="width:300px;height:30px;">
											<div style="line-height:30px;width:250px;float:left;">${f}</div>
											<div style="line-height:30px;width:50px;float:left;" class="coleFile">删除</div>
										</div>
									</c:forEach>
								</div>
							</td>
						</tr>
			</table>
		</td>
	</tr>
</table>
</form>
