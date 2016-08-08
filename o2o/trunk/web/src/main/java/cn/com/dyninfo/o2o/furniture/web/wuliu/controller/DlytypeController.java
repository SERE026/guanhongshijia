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

package cn.com.dyninfo.o2o.furniture.web.wuliu.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Dlytype;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Psarea;
import cn.com.dyninfo.o2o.furniture.web.wuliu.service.DlytypeService;
import cn.com.dyninfo.o2o.furniture.web.wuliu.service.PsareaService;
import cn.com.dyninfo.o2o.furniture.web.wuliu.service.WlcompanyService;

/**
 * 配送方式 
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/dlytype")
public class DlytypeController extends BaseController{

	   @Resource
	   private DlytypeService dlytypeService;
	   
	   @Resource
	   private WlcompanyService wlcompanyService;
	   

		@Resource
		private AreaService areaService;
		
		  @Resource
		   private PsareaService psareaService;
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=dlytypeService;
			 this.business="wuliu";
			 this.table="dlytype";
		 }
	   
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
	    	 StringBuffer where=new StringBuffer();
	    	 String psfsmc=request.getParameter("psfsmc");
	    	 String sfqy=request.getParameter("sfqy");
	    	 if(psfsmc!=""&&psfsmc!=null){
	    		 where.append("and n.dlyname like'%").append(psfsmc).append("%'");
	    	 }
	    	 if(sfqy!=""&&sfqy!=null){
	    		 where.append("and n.stats=' ").append(sfqy).append("'");
	    	 }
	    	 ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
	 		if(merchants!=null && merchants.getShangjia_id() != Constants.DEFAULT_SHANGJIA_ID){
	 			where.append(" and n.merchants.shangjia_id = '").append(merchants.getShangjia_id()).append("'");
	 		}
	    	 where.append("and n.stat='0'");
	    	 ModelAndView mva= super.list(request, where);
	    	 mva.addObject("psfsmc", psfsmc);
	    	 mva.addObject("sfqy", sfqy);
	           return mva;
	     }
	    
	     /**
	 	 * 添加跳转
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping(value="/toAdd")
	 	public ModelAndView toAdd(HttpServletRequest request){
	 		ModelAndView mav=new ModelAndView();
	 		mav.addObject("company", wlcompanyService.getListByWhere(new StringBuffer("and 2=2")));
	 		mav.setViewName("/wuliu/dlytype/add");
	 		return mav;
	 	}
	     
	     /**
			 * 添加
			 * 
			 * @param request
			 * @param info
			 * @return
			 */
	      @RequestMapping(method=RequestMethod.POST)
	      public ModelAndView add(HttpServletRequest request,Dlytype info){
	    	    ModelAndView mav=new ModelAndView();
	    	    List<Psarea> psarealist=new ArrayList();
	    	    ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		 		if(merchants!=null){
		 			info.setMerchants(merchants);
		 		}
	    	    dlytypeService.addObj(info);
	    	    String areaid=request.getParameter("areaid");
	    	    String areaname=request.getParameter("areaname");
	    	    String hdfksum=request.getParameter("hdfksum");
	    	    String xcfrsum=request.getParameter("xcfrsum");
	    	    String scfrsum=request.getParameter("scfrsum");
				if(areaid!=""&&areaname!=""){	    	    
	    	    String areaname1[] =  areaname.split("%");
	    	    String areaid1[] =  areaid.split("%");
	       	    String xcfrsum1[] =  xcfrsum.split("%");
	       	    String scfrsum1[] =  scfrsum.split("%");
	       	    String hdfksum1[] =  hdfksum.split("%");
	       List<Dlytype> list= (List<Dlytype>) dlytypeService.getListByWhere(new StringBuffer(" order by dlytype_id desc"));
	       Dlytype dlytype= list.get(0);
	       for(int i=0;i<scfrsum1.length;i++){
	    		 	Psarea paarea=new Psarea();
		    	    paarea.setAreaname(areaname1[i]);
		    	    paarea.setAreaid(areaid1[i]);
		    	    paarea.setMrscfr(Double.parseDouble(scfrsum1[i]));
		    	    paarea.setMrxzfr(Double.parseDouble(xcfrsum1[i]));
		    	    paarea.setPaytype(hdfksum1[i]);
		    	    paarea.setDlytype(dlytype);
		    	    psarealist.add(paarea);
	    	 }
	    	    
	    	    info.setPsarea(psarealist);
				}
	    	    dlytypeService.updateObj(info);
	    		mav.setViewName("redirect:/html/manage/dlytype/list");
	    		return mav;
	      }
	  	/**
	  	 * 修改跳转
	  	 * @param id
	  	 * @param request
	  	 * @return
	  	 */
	  	@RequestMapping(value="/{id}/toUpdate")
	  	public ModelAndView toUpdate(@PathVariable String id,HttpServletRequest request){
	  		ModelAndView mav=new ModelAndView();
	  		mav.addObject("company", wlcompanyService.getListByWhere(new StringBuffer("and 2=2")));
	  		Dlytype	dlytype=(Dlytype) dlytypeService.getObjById(id);
	  		mav.addObject("size",dlytype.getPsarea().size());
	  		mav.addObject("info",dlytypeService.getObjById(id));
	 		mav.setViewName("/wuliu/dlytype/update");
	  		return mav;
	  	}
	      
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,Dlytype info){
			  ModelAndView mav=new ModelAndView();
			  ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		 		if(merchants!=null){
		 			info.setMerchants(merchants);
		 		}
			  	String areaid=request.getParameter("areaid");
	    	    String areaname=request.getParameter("areaname");
	    	    String hdfksum=request.getParameter("hdfksum");
	    	    String xcfrsum=request.getParameter("xcfrsum");
	    	    String scfrsum=request.getParameter("scfrsum");
	    	    String delidsum=request.getParameter("delidsum");
	    	    	    
	    	    String areaname1[] =  areaname.split("%");
	    	    String areaid1[] =  areaid.split("%");
	       	    String xcfrsum1[] =  xcfrsum.split("%");
	       	    String scfrsum1[] =  scfrsum.split("%");
	       	    String hdfksum1[] =  hdfksum.split("%");
	       	    String delidsum1[] =  delidsum.split("%");
	       	 if(delidsum!=""){
	       	    for(int y=0;y<delidsum1.length;y++){
	       	    	psareaService.delObjById(delidsum1[y]);
	       	    }
	       	 }
	       	if(areaid!=""&&areaname!=""&&xcfrsum!=""&&scfrsum!=""){	
	       		List<Psarea> psarealist  =	 (List<Psarea>) psareaService.getListByWhere(new StringBuffer("and n.dlytype.dlytype_id='").append(info.getDlytype_id()).append("'"));
	       		int number=psarealist.size();
	       for(int i=0;i<areaname1.length;i++){
	    	   if(i>=number){
	    		   Psarea paarea1=new Psarea();
	    		   paarea1.setAreaname(areaname1[i]);
	    		   paarea1.setAreaid(areaid1[i]);
	    		   paarea1.setMrscfr(Double.parseDouble(scfrsum1[i]));
	    		   paarea1.setMrxzfr(Double.parseDouble(xcfrsum1[i]));
	    		   paarea1.setPaytype(hdfksum1[i]);
	    		   paarea1.setDlytype(info);
	    		   psarealist.add(paarea1);
		    	    
	    	   }else{
	    		 	Psarea paarea=psarealist.get(i);
		    	    paarea.setAreaname(areaname1[i]);
		    	    paarea.setAreaid(areaid1[i]);
		    	    paarea.setMrscfr(Double.parseDouble(scfrsum1[i]));
		    	    paarea.setMrxzfr(Double.parseDouble(xcfrsum1[i]));
		    	    paarea.setPaytype(hdfksum1[i]);
		    	    psareaService.updateObj(paarea);
		    	    psarealist.add(paarea);
		    	    
	    	 }
	       }
	    	    info.setPsarea(psarealist);
	    	    }
	       
	       		if(info.getFirstmoney()==null){
	       			info.setFirstmoney(0.0);
	       		}
	       		if(info.getAddwtmoney()==null){
	       			info.setAddwtmoney(0.0);
	       		}
	       		if(info.getFirstwt()==null){
	       			info.setFirstwt(0.0);
	       		}
	       		if(info.getAddwt()==null){
	       			info.setAddwt(0.0);
	       		}
	       		if(info.getBjfl()==null){
	       			info.setBjfl(0.0);
	       		}
	       		if(info.getLowest()==null){
	       			info.setLowest(0.0);
	       		}
	    	    dlytypeService.updateObj(info);
	    		mav.setViewName("redirect:/html/manage/dlytype/list");
				return mav;
		  }
		  
		  
			@RequestMapping(value="/areaselect")
			public ModelAndView areaselect(HttpServletRequest request, HttpServletResponse response){
				String regionid=request.getParameter("regionid");
		    StringBuffer where=new StringBuffer();
		    JSONObject job=new JSONObject();
		    if(regionid.equals("0")){
		    	where.append(" and n.parent is null");
		    }else{
		    	where.append("  and n.parent.id='").append(regionid).append("'");
		    }
		    		 List<AreaInfo> ars=(List<AreaInfo>) areaService.getListByWhere(where);
		
		    int i=0;
		    for(AreaInfo v:ars){
		     try {
		      JSONObject job1=new JSONObject();
		      job1.put("id", v.getId());
		      job1.put("name", v.getName());
		      job.put("city"+i, job1);
		      job1.put("childnum", v.getChildren().size());
		      i++;
		     } catch (Exception e) {
		      e.printStackTrace();
		     }
		    }
		    try {
		     response.setCharacterEncoding("UTF-8");
		     response.setContentType("json/text");
		     Writer writer;
		     writer=response.getWriter();
		     writer.write(job.toString());
		     writer.flush();
		     writer.close();
		    } catch (IOException e) {
		     e.printStackTrace();
		    }
		    return null;
		  }

			@RequestMapping(value="/{id}/areaselect")
			public ModelAndView areaselect1(@PathVariable String id,HttpServletRequest request, HttpServletResponse response){
			String regionid=request.getParameter("regionid");
		    StringBuffer where=new StringBuffer();
		    JSONObject job=new JSONObject();
		    if(regionid.equals("0")){
		    	where.append(" and n.parent is null");
		    }else{
		    	where.append("  and n.parent.id='").append(regionid).append("'");
		    }
		    		 List<AreaInfo> ars=(List<AreaInfo>) areaService.getListByWhere(where);
		
		    int i=0;
		    for(AreaInfo v:ars){
		     try {
		      JSONObject job1=new JSONObject();
		      job1.put("id", v.getId());
		      job1.put("name", v.getName());
		      job.put("city"+i, job1);
		      job1.put("childnum", v.getChildren().size());
		      i++;
		     } catch (Exception e) {
		      e.printStackTrace();
		     }
		    }
		    try {
		     response.setCharacterEncoding("UTF-8");
		     response.setContentType("json/text");
		     Writer writer;
		     writer=response.getWriter();
		     writer.write(job.toString());
		     writer.flush();
		     writer.close();
		    } catch (IOException e) {
		     e.printStackTrace();
		    }
		    return null;
		  }
			/**
			 * 假删除 
			 * @param id
			 * @param request
			 * @return
			 */
			@RequestMapping(value="/{id}/todel")
			public ModelAndView todel(@PathVariable String id,HttpServletRequest request){
				ModelAndView mav=new ModelAndView();
				Dlytype dlytype=(Dlytype) dlytypeService.getObjById(id);
				dlytype.setStat("1");
				dlytypeService.updateObj(dlytype);
				mav.setViewName("redirect:/html/manage/dlytype/list");
				return mav;
			}
			
			/**
			 * 启用
			 * @param id
			 * @param request
			 * @return
			 */
			@RequestMapping(value="/{id}/toqy")
			public ModelAndView toqy(@PathVariable String id,HttpServletRequest request){
				ModelAndView mav=new ModelAndView();
				Dlytype dlytype=(Dlytype) dlytypeService.getObjById(id);
				String stats=dlytype.getStats();
				if(stats.equals("0")){
					dlytype.setStats("1");
				}else{
					dlytype.setStats("0");
				}
				dlytypeService.updateObj(dlytype);
				mav.setViewName("redirect:/html/manage/dlytype/list");
				return mav;
			}
}
