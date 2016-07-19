

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

al=function(){
	alert('sss');
}

resultAjax1=function(url,data,m_fun,type){
	$.ajax({
	  type: 'POST',
	  url: url,
	  data: data,
	  dataType: type,
	  success: function(data){
	  		m_fun(data);
	  },
	  error:function(XMLHttpRequest, textStatus, errorThrown){
	  }
	});
}

resultAjax=function(url,data,m_fun,type){
	$.ajax({
	  type: 'POST',
	  url: url,
	  data: data,
	  dataType: type,
	  success: function(data){
	  		m_fun(data);
	  },
	  error:function(XMLHttpRequest, textStatus, errorThrown){
	  	alert("数据出错！");
	  }
	});
}

m_ajax=function(url,data){
	$.ajax({
	  type: 'POST',
	  url: url,
	  data: data,
	  timeout:10000,
	  dataType: "html",
	  success: function(data){
	  	if(data=="1"){
	  		alert("操作成功!");
	  		loadData(null);
	  	}else if(data=="0"){
	  		alert("操作失败!");
	  	}
	  },
	  error:function(){
	  }
	});
}

m_ajax_data=function(url,data,dataType){
	$.ajax({
	  type: 'POST',
	  url: url,
	  data: {},
	  dataType: "json",
	  timeout:10000,
	  success: function(data){
	  	parsetData(data[0].data);
	  	setPageTable(data[0].page);
	  },
	   error:function(XMLHttpRequest, textStatus, errorThrown){
	  }
	});
}


function setPageTable(page){
				var m_tr=document.getElementById("mpage_tr");
		    	var mtrStr='<div style="width:600px;height:22px;margin:auto;padding-left:180px">';
		    	mtrStr+='<div style="float:left;">';
		    	mtrStr+='<div style="float:left;">';
		    	if(page.totalpage>0){
		    		mtrStr+='<a href="javascript:goPageTo(\''+(page.pageNo-1)+'\')">';
					mtrStr+='<img src="'+projectName+'/web/jsp/admin/img/tab2_fenye_25.gif" border="0" /></a>';
		    	}
		    	mtrStr+='</div><div style="float:left"><ul>';
		    	var s=page.pageNo-2;
		    	if(page.totalpage==page.pageNo){
					s=page.pageNo-4;
		    	}
		    	if(page.totalpage-1==page.pageNo){
					s=page.pageNo-3;
		    	}
		    	var e=page.totalpage;
		    	var pageNo=page.pageNo;
				var t=0;
				var mtrStr1="";
				for(var i=0;i<page.totalpage+5&&t<5;i++)
				{
					
					var si=parseInt(s+i);
					if(si>0&&si<=parseInt(page.totalpage)){
						t++;
						if(si==pageNo){
							mtrStr1="<li>"+si+"</li>";
						}else{
							mtrStr1="<li><a href=\"javascript:goPageTo('"+si+"');\" class=\"zhu3\">"+si+"</a></li>";
						}
						mtrStr+=mtrStr1;
					}
				}
				
				mtrStr+='</ul></div>';
				if(page.totalpage>0){
					mtrStr+='<div style="float:left;margin-left:10px">';
					mtrStr+='<a href="javascript:goPageTo(\''+(page.pageNo+1)+'\')">';
					mtrStr+='<img src="'+projectName+'/web/jsp/admin/img/tab2_fenye_31.gif" border="0" /></a></div>';
					mtrStr+='<div style="float:left;margin-left:10px;width:100px;margin-top:1px;"><a href="javascript:jump();">转到</a>';
					mtrStr+='<input style="width:50px;height:12px;" type="text" id="ys" value="'+page.pageNo+'">页</div>';
					mtrStr+='<div style="float:left;margin-left:10px;margin-top:5px; width:150px">';
					mtrStr+='共'+page.totalpage+'页&nbsp;';
					mtrStr+=page.totalcount+'条数据</div>';
				}else{
					mtrStr+="占无数据";
				}
				mtrStr+='</div></td></tr>';
				m_tr.cells[0].innerHTML=mtrStr;
				
	}
	
var currentindex = -1;
var size = 0;
function movethis(up) {
        currentindex = currentindex + (up ? -1 : 1);
        if (currentindex == size) {
            currentindex = 0;
        }
        else if (currentindex < 0) {
            currentindex = size-1 ;
        }
        $("#boxpro div").removeClass("linePro");
        $("#boxpro div").css("background-color","");
        $($("#boxpro div")[currentindex]).addClass("linePro");
        $($("#boxpro div")[currentindex]).css("background-color","#939393");
        // var name = $($("#boxpro div")[currentindex]).text();
       //     name = name.substring(3,name.indexOf("|"))
      //  $(window.curObj).val(name);
    }
 function allkeyup(e){
    if (e.keyCode == 38) {
                movethis(true);
            }
            else if (e.keyCode == 40) {
                movethis(false);
            }
            else if (e.keyCode == 13) {
           		if(currentindex!=-1){
	                $("#boxpro").hide();
	                $(".linePro").trigger("click");
                }
            }
    }
