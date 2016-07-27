

/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *  
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty 
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and 
 * confidential information, ideas and expressions.    No part of this 
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior 
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */

function updateArre(){
		resultAjax($("#goodSortId").attr("url"),$("#goodSortId").attr("prt")+"="+$("#goodSortId").val(),AjaxGoodsType,"json");
	};
	
$(function(){
	inputKey($("#dlytypeName"),$("#dlytypeName").attr("url"),"dlyname","dlytype_id");
	
	$(".goodsType").change(function(){
		resultAjax($(this).attr("url"),$(this).attr("prt")+"="+$(this).val(),AjaxGoodsSpec,"json");
	});
	$(".tab div").click(function(){
		$(".Box").css("display","none");
		$("."+$(this).attr("box")).css("display","");
		$(".tab .select").removeClass("select");
		$(this).addClass("select");
		
	});
	$(".addAttr").click(function(){
		var html="<tr>";
			html+="<td><input type='text' name='attrName' value='' /></td>";
			html+="<td><select name='attrType' class='attrType'><option value='0'>文字</option><option value='1'>图片</option></select></td>";
			html+="<td item='"+$("#attrBox tr").length+"'><div class='attrVal'></div><a href='javascript:;' class='addAttrVal'>添加参数值</a></td>";
			html+="<td><a href='javascript:;' class='delAttr'>删除参数</a></td>";
			html+="</tr>";
		$("#attrBox").append(html);
		attrEvent();
	})
	$(".pullAttr").click(function(){
		$("#attrMoneyBox").empty();
		for(var i=0;i<$("#attrBox tr").length;i++){
			var sel=$("#attrBox tr:eq("+i+")");
			var html="<tr>";
				html+="<td rowspan='"+sel.find("td:eq(2) input:text").length+"'>"+$("#attrBox tr:eq("+i+")").find("td:eq(0) input:[name='attrName']").val()+"</td>";
			var item=0;
			var selItem=sel.find("td:eq(2)").attr("item");
			sel.find("td:eq(2) input:text").each(function(){
				if(html=="")
					html+="<tr class='attrMoneyTr'>";
				html+="<td>"+$(this).val()+"<input type='hidden' name='tag' value='"+$(this).val()+"' /></td>";
				html+="<td><input type='text' name='bazaarMoneyTag"+selItem+":"+item+"'  value='' dataType='float' class='money' /></td>";
				html+="<td><input type='text' name='salesMoneyTag"+selItem+":"+item+"'  value='' dataType='float' class='money' /></td>";
				html+="<td><input type='text' name='costsMoneyTag"+selItem+":"+item+"'  value='' dataType='float' class='money' /></td>";
				html+="<td><input type='text' name='inventoryTag"+selItem+":"+item+"'  value='' dataType='float' class='money' /></td>";
				html+="<td><input type='text' name='weightTag"+selItem+":"+item+"'  value='' dataType='float' class='money' /></td>";
				html+="</tr>";
				$("#attrMoneyBox").append(html);
				html="";
				item++;
			});
		}
	})
	
		attrEvent();
		addImageEvent();
		DialogEvent();
		DeliveryEvent();
		DlytypeEventAfter();
		
	$(".goodsSort").unbind("click").click(function(){
		$.layer({
		    type : 2,
		    title : '选择商品分类',
		    iframe : {src : servicePath+'/html/manage/goodsSort/selection'},
		    area : ['750px' , '466px'],
		    offset : ['100px','']
		});

	});
});



function DeliveryEvent(){
	$("input[name='delivery']").click(function(){
		
		if(this.value=="1"){
			$(".setdeliveryFlag2").css("display","none");
			$(".setdeliveryFlag1").css("display","");
			$("input[name='deliveryFlag'][value='2']").attr("checked",true);
			$(".setdlyIds").css("display","none");
		}else{
			$(".setdeliveryFlag1").css("display","none");
			$(".setdeliveryFlag2").css("display","");
			$("input[name='deliveryFlag'][value='0']").attr("checked",true);
			$(".deliveryMoney").css("display","none");
		}
	})
	$("input[name='deliveryFlag']").click(function(){
		
		if(this.value=="2"){
			$(".setdlyIds").css("display","none");
		}else if(this.value=="3"){
			$(".setdlyIds").css("display","");
		}else if(this.value=="0"){
			$(".deliveryMoney").css("display","none");
		}else if(this.value=="1"){
			$(".deliveryMoney").css("display","");
		}
	})
	//配送方式添加按钮事件
	$(".addDlytype").click(function(){
		var Dlytype=$(".DlytypeTempl").clone();
		Dlytype.css("display","");
		Dlytype.removeClass("DlytypeTempl");
		Dlytype.find("a").eq(0).addClass("DlytypeNum").html("");
		Dlytype.insertBefore($(this).parent());
		DlytypeEventAfter();
	})
}
function DlytypeEventAfter(){
	
	var num=1000;
	$(".setdlyIds .DlytypeNum").each(function(){
		$(this).html(num-999);
		$(this).parent().find("input").eq(0).attr("id","dlytypeId"+num);
		$(this).parent().find("input").eq(1).attr("id","dlytypeName"+num).attr("mappendBy","dlytypeId"+num);
		inputKey($(this).parent().find("input").eq(1),$(this).parent().find("input").eq(1).attr("url"),"dlyname","dlytype_id");
		num++;
	});
	$(".delDlytype").unbind("click").click(function(){
		$(this).parent().remove();
		DlytypeEventAfter();
	})
}

function AttrFunction(){
	for(var i=$("#attrBox tr").length-1;i>=0;i--){
				$(".montyTitle td:eq(0)").before("<td class='newTd'><strong>"+$("#attrBox tr:eq("+i+")").find("td:eq(0) input:eq(0)").val()+"</strong></td>");
	}

	var data="";
	var item=1;
	for(var i=0;i<$("#attrBox tr").length;i++){
		var sel=$("#attrBox tr:eq("+i+")");
			var tag="{";
			tag+="\"tags\":[";
			var row=0;
			sel.find("td:eq(2) input").each(function(){
				tag+="{\"name\":\""+$(this).val()+"\",\"tag\":\""+i+":"+row+"\",\"tagType\":\""+sel.find(".attrType").val()+"\"},";
				row++;
			});
			if(tag.substring(tag.length-1)==",")
				tag=tag.substring(0,tag.length-1);
			tag+="]";
			data+=tag
			if(i<$("#attrBox tr").length-1){
				data+=",\"children\":"
				item++;
			}else{
				tag+="}";
			}
			
	}
	for(var i=0;i<item;i++)
		data+="}";
	var obj = eval('(' + data + ')');
	alert(data);
	eachAttr(new Array(),obj);
}

//迭代 参数 添加参数信息
function eachAttr(item,data){
	for(var i=0;i<data.tags.length;i++){
		var items=new Array();
		for(var x=0;x<item.length;x++){
			items.push(item[x]);
		}
		items.push(data.tags[i]);
		if(data.children){
			eachAttr(items,data.children);
		}else{
			var html="<tr>";
			for(var x=0;x<items.length;x++){
				if(items[x].tagType=="0"){
					html+="<td>"+items[x].name+"</td>";
				}
			}
			html+="<td><input type='text' name='bazaarMoneyTag'  value='' dataType='float' /></td>";
			html+="<td><input type='text' name='salesMoneyTag'  value='' dataType='float' /></td>";
			html+="<td><input type='text' name='costsMoneyTag'  value='' dataType='float' /></td>";
			html+="<td><input type='text' name='inventoryTag'  value='' dataType='float' /></td>";
			html+="<td><input type='text' name='weightTag'  value='' dataType='float' /></td>";
			html+="</tr>";
			$("#attrMoneyBox").append(html);
		}
	}
}



function AjaxGoodsType(data){
	$(".goodsType").val(data.typeId);
	$(".brand").empty();
	if(data.linkBrank==1){
		$(".brand").parent().parent().css("display","");
		$(".brand").append("<option value=''>  请选择  </option>")
		for(var i=0;i<data.brandList.length;i++){
			$(".brand").append("<option value="+data.brandList[i].brand_id+">"+data.brandList[i].name+"</option>")
		}
		$("#costmerBrand a").each(function(){
			
			$(".brand").append("<option value="+$(this).attr("brandId")+">"+$(this).text()+"</option>")
			
		});
		
	}else{
		$(".brand").parent().parent().css("display","none");
	}
	//添加商品类型附带的属性
	$(".spce.Box tbody").empty();
	if(data.spces.length>0){
		for(var i=0;i<data.spces.length;i++){
			var html="<tr>";
				html+='<td class="discription" >'+data.spces[i].spec_name+'</td>';
				html+="<td>";
				var spec=data.spces[i].valStr;
				var flag=data.spces[i].flag;
				if(flag==0){
					html+="<select name='specValue'>";
					var specs=spec.split(",");
					for(var s=0;s<specs.length;s++){
						html+="<option>"+specs[s]+"</option>";
					}
					html+="</select>";
				}
				if(flag==1){
					html+="<input type='text' name='specValue' value=''>";
				}
				html+="</td>";
			$(".spce.Box tbody").append(html);
		}
	}
};

AjaxGoodsSpec=function(data){
	$(".brand").empty();
	if(data.linkBrank==1){
		$(".brand").parent().parent().css("display","");
		$(".brand").append("<option value=''>  请选择  </option>")
		for(var i=0;i<data.brandList.length;i++){
			$(".brand").append("<option value="+data.brandList[i].brand_id+">"+data.brandList[i].name+"</option>")
		}
		$("#costmerBrand a").each(function(){
			
			$(".brand").append("<option value="+$(this).attr("brandId")+">"+$(this).text()+"</option>");
			
		});
	}else{
		$(".brand").parent().parent().css("display","none");
	}
	//添加商品类型附带的属性
	$(".spce.Box tbody").empty();
	if(data.spces.length>0){
		for(var i=0;i<data.spces.length;i++){
			var html="<tr>";
				html+='<td class="discription" >'+data.spces[i].spec_name+'</td>';
				html+="<td>";
				var spec=data.spces[i].valStr;
				var flag=data.spces[i].flag;
				if(flag==0){
					html+="<select name='specValue'>";
					var specs=spec.split(",");
					for(var s=0;s<specs.length;s++){
						html+="<option>"+specs[s]+"</option>";
					}
					html+="</select>";
				}
				if(flag==1){
					html+="<input type='text' name='specValue' value=''>";
				}
				html+="</td>";
			$(".spce.Box tbody").append(html);
		}
	}
};


function attrEvent(){
	$(".delAttr").unbind("click").click(function(){
		$(this).parent().parent().remove();
	});
	$(".attrType").unbind("change").change(function(){
		//$(this).parent().parent().find(".attrVal").empty();
	})
	$(".addAttrVal").unbind("click").click(function(){
		var flag=$(this).parent().parent().find("select").val();
		
		
		var html="<div class='AttrValBox'>";
			html+="<input type='text' name='attrVal"+$(this).parent().attr("item")+"' value='' />";
			html+="<div class='AttrValBoxImage'><input type='hidden' name='attrVal"+$(this).parent().attr("item")+"img' value='' /></div><a href='javascript:;' class='addImage'>选择上传图片</a>";
			html+="<a href='javascript:;' class='delattrVal'>删除</a></div>";
			$(this).parent().find(".attrVal").append(html);
		/*
		if(flag==0){
			var html="<div class='AttrValBox'>";
			html+="<input type='text' name='attrVal"+$(this).parent().attr("item")+"' value='' />";
			html+="</div>";
			$(this).parent().find(".attrVal").append(html);
		}else if(flag==1){
			if($(this).parent().find(".AttrValBox").length==0){
				var html="<div class='AttrValBox'>";
				html+="<div><a href='javascript:;' class='addImage'>选择上传图片</a></div>";
				html+="</div>";
				$(this).parent().find(".attrVal").append(html);
			}
		}*/
		addImageEvent();
	});
	$(".delAttrVal").unbind("click").click(function(){
		var item=0;
		$(this).parent().remove();
		$("#attrBox tr").each(function(){
			$(this).find("td:eq(2)").attr("item",item);
			$(this).find("td:eq(2) input").attr("name","attrVal"+item);
			item++;
		});
	});
}

function addImageEvent(){
	$(".delattrVal").unbind("click").click(function(){
		$(this).parent().remove();
	});
	$(".addImage").unbind("click").click(function(){
		$("a").removeClass("upimg");
		$(this).addClass("upimg");
		uploadDialog();
	});
}

function uploadDialog(){

	if($(".dialogBG").length==0){
		var width=$(window.document).width();
		var height=$(window.document).height();
		$(document.body).append('<div class="dialogBG" style="display:none;width:'+width+'px;height:'+height+'px;"></div>');
		if($(".ImageBox").length==0){
			var imageBoxWidth=300;
			var imageBoxHieght=100;
			var html='<div class="ImageBox" style="left:'+(width-imageBoxWidth)/2+'px;top:'+(height-imageBoxHieght)/2+'px;width:'+imageBoxWidth+'px;height:'+imageBoxHieght+'px;">';
				html+='<div class="ImageTitle">图片上传</div>';
				html+='<div class="ImageBody"><div class="addFileBtn">选择图片<input id="fileupload" type="file" name="fileupload"  data-url="'+servicePath+"/ghadmin/shangpin/goods/upload.jsp"+'"  class="fileInput" /></div><div class="fileName"></div> </div>';
				html+='<div class="ImageButton"><ul><li><a href="javascript:;" class="imageBoxUpload">开始上传</a></li><li><a href="javascript:;" class="imageBoxColse">关闭</a></li></ul></div>';
				html+='</div>';
			$(document.body).append(html);
		}
	}
	
	$(".dialogBG").css("display","");
	$(".ImageBox").css("display","");
	DialogEvent();
}

function DialogEvent(){
	$("#fileupload").unbind("change").change(function(){
		var fileName=this.value;
		fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
		$(".fileName").html(fileName);
	})
	$(".imageBoxUpload").unbind("click").click(function(){
		$(".ImageButton").css("display","none");
		$(".ImageBody .addFileBtn").css("display","none");
		$(".ImageBody").append("<div style='margin:auto;' class='currentUploadFile'><img src='"+servicePath+"/shangpin/goods/loading.gif' /><br/>上传中，请稍后...</div>");
		ajaxFileUpload();
	})
	$(".imageBoxColse").unbind("click").click(function(){
		$(".dialogBG").css("display","none");
		$(".ImageBox").css("display","none");
		$(".fileInput").val("");
		$(".fileName").html("");
		$(".currentUploadFile").remove();
		$(".addFileBtn").css("display","");
		$(".ImageButton li:eq(0)").css("display","");
		
		
	})
	$(".continue").unbind("click").click(function(){
		$(".addFileBtn").css("display","");
		$(".fileInput").val("");
		$(".fileName").html("");
		$(".currentUploadFile").remove();
		$(".ImageButton li:eq(0) a").attr("class","imageBoxUpload");
		$(".ImageButton li:eq(0) a").html("开始上传");
		DialogEvent();
	});
}


function fileUpload(){
	$('#fileupload').fileupload({
    	done: function (e, data) {
        $.each(data.result, function (index, file) {
            $('<p/>').text(file.name + ' uploaded').appendTo($("body"));
        });
    }
});
}


function ajaxFileUpload()
    {
    	$("ImageBody img").ajaxStart(function(){
         	
       });
        $.ajaxFileUpload
        (
            {
                url:servicePath+"/ghadmin/shangpin/goods/upload.jsp",//用于文件上传的服务器端请求地址
                secureuri:false,//一般设置为false
                fileElementId:'fileupload',//文件上传空间的id属性  <input type="file" id="file" name="file" />
                dataType: 'text',//返回值类型 一般设置为json
                success: function (data, status)  //服务器成功响应处理函数
                {
                	var item=$(".upimg").parent().parent().parent().attr("item");
                	$(".currentUploadFile").html("文件上传成功！");
                	$(".ImageButton").css("display","");
                	//$(".ImageButton li:eq(0) a").attr("class","continue");
                	//$(".ImageButton li:eq(0) a").html("重新上传");
                	$(".upimg").parent().find(".AttrValBoxImage").html("<input type='hidden' name='attrVal"+item+"img' value='"+data+"' /><img src='"+servicePath+"/upload/"+data+"' title='点击删除' height='30'>");
               		DialogEvent();
                },
                error: function (data, status, e)//服务器响应失败处理函数
                {
                    alert(e);
                }
            }
        )
        
        return false;

    }


	function addGoodsImage(fileName, realName){
		$(".ImageSelect").removeClass("ImageSelect");
		$("#imgUrl").append("<div id='goodsImage"+imageCount+"' class=\"goodsImage ImageSelect\" ><input type='hidden' name='goodsImage' value='"+fileName+"'/><img src=\""+servicePath+"/upload/goods/"+fileName+"\" /></div>");
		$(".ImageMinBox").append("<div id='minImage_p"+imageCount+"' maxImageId='goodsImage"+imageCount+"' imageUrl='"+fileName+"' class='minImage_p'><img class='minImage' src='"+servicePath+"/upload/goods/"+fileName+"'/><div class='minImageClose'></div></div>");
		$("#defaultImage").val(fileName);
		GoodsImageEvent();
		imageCount++;
	}
	
	function mfaddGoodsImage(fileName, realName){
		$(".mfImageSelect").css("display","none");
		$(".mfImageSelect").removeClass("mfImageSelect");
		$("#mfimgUrl").append("<div id='mfgoodsImage"+mfimageCount+"' class=\"mfgoodsImage mfImageSelect\" ><input type='hidden' name='mfimages' value='"+fileName+"'/><img src=\""+servicePath+"/upload/head/"+fileName+"\" /></div>");
		$(".mfImageMinBox").append("<div id='mfminImage_p"+mfimageCount+"' mfmaxImageId='mfgoodsImage"+mfimageCount+"' mfimageUrl='"+fileName+"' class='minImage_p'><img class='mfminImage' src='"+servicePath+"/upload/head/"+fileName+"'/><div class='mfminImageClose'></div></div>");
		$(".mfImageSelect").css("display","block");
		GoodsImageEvent();
		mfimageCount++;
	}
	
	function GoodsImageEvent(){
		$(".minImage_p").unbind("click").click(function(){
			$(".ImageSelect").removeClass("ImageSelect")
			$("#"+$(this).attr("maxImageId")).addClass("ImageSelect");
			$("#defaultImage").val($(this).attr("imageUrl"));
		})
		$(".minImageClose").unbind("click").click(function(){
			var updateClass=$("#"+$(this).parent().attr("maxImageId")).attr("class").indexOf("ImageSelect")>=0;
			$("#"+$(this).parent().attr("maxImageId")).remove();
			if(updateClass)$(".goodsImage:last").addClass("ImageSelect");
			$(this).parent().remove();
			$("#defaultImage").val($(".goodsImage:last").attr("imageUrl"));
			
		});
		$(".mfminImage_p").unbind("click").click(function(){
			$(".mfImageSelect").css("display","display");
			$(".mfImageSelect").removeClass("mfImageSelect")
			$("#"+$(this).attr("mfmaxImageId")).addClass("mfImageSelect");
			$(".mfImageSelect").css("display","block");
		})
		$(".mfminImageClose").unbind("click").click(function(){
			var updateClass=$("#"+$(this).parent().attr("mfmaxImageId")).attr("class").indexOf("mfImageSelect")>=0;
			$("#"+$(this).parent().attr("mfmaxImageId")).remove();
			if(updateClass)$(".mfgoodsImage:last").addClass("mfImageSelect");
			$(this).parent().remove();
		});
	}
	
	function setGoodsImageDefault(fileName){
		var item=1;
		$(".minImage_p").each(function(){
			if($(this).attr("imageUrl")==fileName){
				$(".ImageSelect").removeClass("ImageSelect");
				$(".goodsImage:eq("+item+")").addClass("ImageSelect");
				
			}
			item++;
		});
	}
	