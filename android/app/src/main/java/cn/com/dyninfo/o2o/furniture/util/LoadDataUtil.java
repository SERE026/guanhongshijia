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

package cn.com.dyninfo.o2o.furniture.util;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Description 上下拉加载数据 请求数据
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 */
public abstract class LoadDataUtil{
    public static int longtimeout=9000;
    public static int smalltimeout=3000;
	private LoadDataAsync serverLoad=null;
	Map<String,Object> parameters=null;
	private int timeout=3000;
	private boolean isrefresh=true;
	public void loadOnlyDb(){
		loadOnlyDb(false,null);
	}
	public void loadOnlyDb(boolean refresh,Map<String,Object> param){
		if(serverLoad==null){
			serverLoad=new LoadDataAsync();
		}
		if(param!=null){
			parameters=param;
		}
		if(parameters==null){
			parameters=new HashMap<String,Object>();
	    }
	    isrefresh=refresh;
		loadMoreDB(parameters,isrefresh);
	}
	public void load(){
		load(null);
	}
	public void load(Map<String,Object> param){
		if(serverLoad==null){
		   serverLoad=new LoadDataAsync();
		}
		if(param!=null){
			parameters=param;
		}
		if(parameters==null){
			parameters=new HashMap<String,Object>();
		}
		isrefresh=false;
		serverLoad.setParams(parameters);
		serverLoad.execute();
	}
	public void refresh(){
		refresh(null);
	}
	public void refresh(Map<String,Object> param){
		    timeout=smalltimeout;
		    if(serverLoad==null){
			   serverLoad=new LoadDataAsync();
			}
		    if(param!=null){
				parameters=param;
			}else{
				parameters=new HashMap<String,Object>();
			}
		    isrefresh=true;
		    serverLoad.setParams(parameters);
			serverLoad.execute();
	}
	protected  abstract String runServerTask(Map<String,Object> parameters);
	protected void serverTaskFinally(Map<String,Object> params){
	 }
	/**
	 * @param json
	 * @param parameters
	 * @return true不再加载数据库 ,false从数据库加载
	 */
	protected  abstract boolean handleServerSuccess(JSONObject json,Map<String,Object> parameters);
	
	/**
	 * @param json
	 * @param parameters
	 * @param refresh 当前是否在执行刷新操作
	 * @return true表示数据库还有数据,false数据库没有数据
	 */
	protected  abstract boolean  loadMoreDB(Map<String,Object> parameters,boolean refresh);
	class LoadDataAsync extends AsyncHandle{
		 protected void netWorkFail(Map<String,Object> parameters){
			  if(!isrefresh){
			    if(!loadMoreDB(parameters,isrefresh)){
				   timeout=longtimeout;
			    }
			}
	    }
	    
		 protected void errorFinally(Map<String,Object> params){
			 serverTaskFinally(params);
		 }
		 
	    protected  void handleData(JSONObject json,Map<String,Object> parameters) throws JSONException{
	    	boolean notload=handleServerSuccess(json,parameters);
	    	if(!notload){
	    		if(!loadMoreDB(parameters,isrefresh)){
	    			timeout=longtimeout;
	    		}
	    	}
	    }
	    
	    protected  String runTask(Map<String,Object> parameters){
	    	return runServerTask(parameters);
	    } 	
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
