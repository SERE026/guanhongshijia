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

var brandPage=1;

function hiddFd(){
	$("#youce_fudong").css("display","none");
  }
  function hiddFds(){
	$(".youce_fudong22").css("display","none");
  }
  function addBrandAjax(){
  	$(".moreBrand").unbind("click").click(function(){
  		brandPage++;
  		 $.ajax({
			 	 type: 'POST',
			  	 url: servicePath+"/widget.html",
			 	 data: "widget=goodsSortBrand&dataType=json&action=brand&pageNo="+brandPage,
			 	 dataType: "json",
			     error: function(XMLHttpRequest, textStatus, errorThrown) {
	                alert(XMLHttpRequest.responseText);
	              },
			  	  success: function(data){
			   		for(var i=0;i<data.data.length;i++){
				      var html='<div class="youce_tu">';
					      html+='<a href="GoodBrand-'+data.data[i].brand_id+'.html">';
					      html+='<img src="upload/'+data.data[i].logo+'" width="100%" height="100%" border="0" />';
					      html+='</a></div>';
					      if($(".youce_tu.morDiv").length>0){
					      	 $(".youce_tu.morDiv").before(html);
					      }else{
					      	 $("#youce_fudong.morDiv").append(html);
					      }
				     
				      }
			    	}
			  });
  	})
  }
  
$(function(){

     $("#brand_a").mouseenter(function(){
     	brandPage=1
     	$(this).removeClass("x1418_kuai");
        $(this).addClass("x1418_kuai_dian");
	    $("#youce_fudong").empty();
	    clearTimeout(time);
	    $("#youce_fudong").css("top",$(this).offset().top+"px");
	    $("#youce_fudong").css("left",($(".meu").width()-$(".meu_da").width())/2+$("#brand_a").width()+20+"px");
	    $("#youce_fudong").css("display","");
	    $(".youce_fudong22").css("display","none");
	         $.ajax({
			 	 type: 'POST',
			  	 url: servicePath+"/widget.html",
			 	 data: "widget=goodsSortBrand&dataType=json&action=brand&pageNo="+brandPage,
			 	 dataType: "json",
			     error: function(XMLHttpRequest, textStatus, errorThrown) {
	                alert(XMLHttpRequest.responseText);
	              },
			  	  success: function(data){
			   		for(var i=0;i<data.data.length;i++){
				      var html='<div class="youce_tu">';
					      html+='<a href="GoodBrand-'+data.data[i].brand_id+'.html">';
					      html+='<img src="upload/'+data.data[i].logo+'" width="100%" height="100%" border="0" />';
					      html+='</a></div>';
					      $("#youce_fudong").append(html);
				      }
				      if(data.data.length==23){
				    	  $("#youce_fudong").append('<div class="youce_tu morDiv"><a href="javascript:;" style="color:#666666" class="moreBrand">更多品牌>></a></a></div>');
			    	  		addBrandAjax();
			    	  }else{
			    	  	$(".youce_tu.morDiv").remove();
			    	  }
			    	}
			  });
      });
  		var  time;
         $("#brand_a").mouseleave(function(){
	        $(this).removeClass("x1418_kuai_dian");
        	$(this).addClass("x1418_kuai");
	         time=setTimeout(hiddFd,100);
         });
         $("#youce_fudong").mouseenter(function(){
                  clearTimeout(time);
             });
         $("#youce_fudong").mouseleave(function(){
          	 time=setTimeout(hiddFd,100);
          });
        $(".sort").mouseenter(function(){
       		$(this).removeClass("x1418_kuai");
        	$(this).addClass("x1418_kuai_dian");
        	$(".youce_fudong").css("display","none");
	        $(".youce_kda").empty();
	        clearTimeout(time);
	         $(".youce_fudong22").css("top",$(this).offset().top+"px");
	        $(".youce_fudong22").css("left",($(".meu").width()-$(".meu_da").width())/2+$(this).width()+20+"px");
	        $(".youce_fudong22").css("display","");
	        $("#youce_fudong").css("display","none");
	        var id=$(this).attr("d_id");
        $.ajax({
			  type: 'POST',
			  url: servicePath+"/widget.html",
			  data: "widget=goodsSortBrand&dataType=json&action=sort&id="+id,
			  dataType: "json",
			  error: function(XMLHttpRequest, textStatus, errorThrown) {
	                alert(XMLHttpRequest.responseText);
	              },
			   success: function(data){
			    var o=0;
			    for(var i=0;i<data.data.length;i++){
			      	var html='<div class="youce_kda_top" >'+data.data[i].sortName+'</div>';
			       		html+='<div class="youce_k_xiaot">';
			       		
			       		if(data.data[i].one){
					        for(var k=0;k<data.data[i].one.length;k++){
					          		html+='<a href="GoodList-'+data.data[i].one[k].sort_id+'.html" class="zhu56">'+data.data[i].one[k].sname+'</a>&nbsp;';
					         }
				         }
			         	html+='</div><div class="youce_fencxian">&nbsp;</div>';
			         	html+='<div class="youce_k_xiaot">';
			         	if(data.data[i].two){
					         for(var j=0;j<data.data[i].two.length;j++){
						      		html+='<a href="GoodList-'+data.data[i].two[j].goods_id+'.html?brandId='+data.data[i].two[j].brand_id+'">'+data.data[i].two[j].name+'</a>&nbsp;';
						     }
					     }
				      	html+='</div>';
				      
				    
				     if(o!=0){
				     	o=0;
				     }else{
				     	o=1;
				     	 $(".youce_kda").append("<div m_good_sort_box></div>");
				     }
				     $(".youce_kda [m_good_sort_box]").last().append("<div class='youce_fudong22_kuai'>"+html+"</div>");
		         }
			    }
		  });
      });
       $(".sort").mouseleave(function(){
	        $(this).removeClass("x1418_kuai_dian");
        	$(this).addClass("x1418_kuai");
	          time=setTimeout(hiddFds,200);
       });
       
       $(".youce_fudong22").mouseenter(function(){
                  clearTimeout(time);
        });
             
         $(".youce_fudong22").mouseleave(function(){
          	 time=setTimeout(hiddFds,200);
          });
});
