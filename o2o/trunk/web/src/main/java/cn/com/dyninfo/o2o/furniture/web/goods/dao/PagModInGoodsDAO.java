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

package cn.com.dyninfo.o2o.furniture.web.goods.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.StringUtil;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.error.GoodsPriceError;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.PagModInGoods;
/**
 * 
 * @author Administrator
 *
 */
@Repository("pagModInGoodsDAO")
public class PagModInGoodsDAO extends BaseDAO{
	
	
     @Autowired
	public PagModInGoodsDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="PagModInGoods";
	}
     
     /**
      * 摇一摇获取商品
      * @param arearId
      * @return
      */
     public Object getRandGoods(String arearId){
    	 String sql="select    g.GOODS_ID  ";
			sql+=" from t_goods g ";
			sql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
			sql+=" left join T_PAGEMODULE_IN_GOODS pg on  pg.GOOD_ID=g.GOODS_ID ";
			sql+="  where  1=1 and g.SHELVES=0 ";
			if(arearId.length()>0){
				sql+=" and s.CITY_ID='"+arearId+"' ";
			}
			sql+=" and pg.PAGEMODULE_ID=57 ORDER BY RAND() limit 1";
			System.out.println(sql);
			Session session=this.getSession();
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			Goods goods=null;
			try{
				con=session.connection();
				st=con.createStatement();
				rs=st.executeQuery(sql);
				if(rs.first()){
					goods=this.getHibernateTemplate().load(Goods.class, rs.getInt(1));
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return goods;
     }
     
     /**
 	 * 
 	 * @param moduleId
 	 * @param arearId
 	 * @param flag
 	 * @param page
 	 * @param map 相关查询条件
 	 * @return
 	 */
 	public List<Goods> getSJGoods(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map,Integer shangjiaid){
 		List<Integer> list=null;
 		switch(flag){
 			case 100:{//最近浏览
 				list=getSJGoodsOrderBy(moduleId,arearId,flag,page,map,shangjiaid);
 				break;
 			}
 			case 101:{//最近浏览
 				list=getSJGoodsOrderBy(moduleId,arearId,flag,page,map,shangjiaid);
 				break;
 			}
 			
 			default:{
 				list=getGoodsOrderBy(moduleId,arearId,flag,page,map);
 			}
 		}
 		List<Goods> result=new ArrayList();
 		for(Integer id:list){
 			Goods info=getHibernateTemplate().load(Goods.class, id);
 			getGoodsPrice(info);
 			result.add(info);
 		}
 		page.setTotalCount(getGoodsCount(arearId,map));
 		return result;
 	}
 	

     public PagModInGoods getModeGods(String pageModule_id,String goods_id,AreaInfo area){
    	List<PagModInGoods> list= this.getHibernateTemplate().find(" from PagModInGoods as n where n.pageModule.pageModule_id="+pageModule_id+" and n.goods.goods_id="+goods_id+(area==null?" and n.city.id is null ":" and n.city.id ='"+area.getId()+"'"));
    	if(list.size()>0)
    		return list.get(0);
    	return null;
     }
     
     public List<Goods> getGoods(List list){
    	 List result=new ArrayList();
    	 for(Object obj:list){
    		 String id=(String) obj;
    		 if(id!=null&&!id.equals("")){
    		 result.add(this.getHibernateTemplate().load(Goods.class,   Integer.parseInt(id)));
    		 }
    	 }
    	 return result;
     }
    
     
    
	@Override
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		HashMap<String, Object> map=(HashMap<String, Object>) super.getListByPageWhere(where, page);
		return map;
	}
	/**
	 * 
	 * @param moduleId
	 * @param arearId
	 * @param flag
	 * @param page
	 * @param map 相关查询条件
	 * @return
	 */
	public List<Goods> getGoods(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map){
		List<Integer> list=null;
		switch(flag){
			case 100:{//最近浏览
				list=getShowGoodsOrderBy(moduleId,arearId,flag,page,map);
				break;
			}
			case 101:{//最近浏览
				list=getShowGoodsOrderBy(moduleId,arearId,flag,page,map);
				break;
			}
			case 102:{//只查询排序商品
 				list=getMemberGoodsOrderBy(moduleId,arearId,flag,page,map);
 				break;
 			}
			default:{
				list=getGoodsOrderBy(moduleId,arearId,flag,page,map);
			}
		}
		List<Goods> result=new ArrayList();
		for(Integer id:list){
			Goods info=getHibernateTemplate().load(Goods.class, id);
			getGoodsPrice(info);
			result.add(info);
		}
		if(flag==102){
			page.setTotalCount(getMemberGoodsCount(arearId,moduleId));
		}else{
			page.setTotalCount(getGoodsCount(arearId,map));
		}
		
		return result;
	}
	
	
	
	/**
	 * 销量统计
	 * @param moduleId
	 * @param arearId
	 * @param flag
	 * @param page
	 * @param map 相关查询条件
	 * @return
	 */
	public List<Goods> getGoodsSales(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map){
		List<Map> list=null;
		switch(flag){
			case 102:{//一周热销
				list=getShowGoodsOrderNumBy(moduleId,arearId,flag,page,map);
				break;
			}
			default:{
				list=new ArrayList();
			}
		}
		List<Goods> result=new ArrayList();
		for(Map m:list){
			Goods info=getHibernateTemplate().load(Goods.class, (Integer)m.get("id"));
			info.setNum((Integer)m.get("num"));
			getGoodsPrice(info);
			result.add(info);
		}
		page.setTotalCount(getGoodsCount(arearId,map));
		return result;
	}
	
	/**
	 * 根据区域获取商品数量
	 * @param arearId
	 * @return
	 */
	private int getGoodsCount(String arearId,Map<String ,String> map){
		int count=0;
		try{
			String sql=" select count(*) from t_goods g left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID "+(arearId!=null?"where s.CITY_ID='"+arearId+"' ":"");
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				count=rs.getInt(1);
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 根据区域获取会员尊享商品数量
	 * @param arearId
	 * @return
	 */
	private int getMemberGoodsCount(String arearId,int modelId){
		int count=0;
		try{
			String sql=" select count(*) from T_PAGEMODULE_IN_GOODS pg  where pg.PAGEMODULE_ID="+modelId+"  and "+(arearId!=null?" pg.CITY_ID='"+arearId+"' ":" pg.CITY_ID is null ");
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				count=rs.getInt(1);
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	
	/**
	 * 获取最近浏览商品排序
	 * @param moduleId 模块ID
	 * @param arearId  城市ID
	 * @param flag	   次排序方式 0销量排
	 * @param page	   分页
	 * @return
	 */
	private List<Integer> getShowGoodsOrderBy(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map){
		List<Integer> result=new ArrayList<Integer>();
		try{
			String orderBy=" a.TIME desc ";
			String sql=" select * from (select  distinct  g.GOODS_ID,g.NUM,  ";
			sql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex,sg.TIME from T_SHOW_GOOD sg  ";
			sql+=" left join t_goods g on g.GOODS_ID= sg.GOOD_ID ";
			sql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
			sql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+moduleId+" ";
			if(arearId!=null){
				sql+=" and pg.CITY_ID='"+arearId+"' ";
	 			}
	 		else 
	 			sql+=" and pg.CITY_ID is null ";
			sql+=")";
			sql+="  where 1=1 and g.SHELVES=0 ";
			if(arearId!=null)
				sql+=" and s.CITY_ID='"+arearId+"' ";
			if(map.get("clientID")!=null){//客户ID
				sql+=" and sg.CLINET_ID='"+map.get("clientID")+"' ";
			}
			sql+=" group by g.GOODS_ID";
			sql+=" ) a order by a.orderIndex asc,"+orderBy+"    LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				result.add(rs.getInt(1));
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获取会员尊享产品
	 * @param moduleId 模块ID
	 * @param arearId  城市ID
	 * @param flag	   次排序方式 0销量排
	 * @param page	   分页
	 * @return
	 */
	private List<Integer> getMemberGoodsOrderBy(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map){
		List<Integer> result=new ArrayList<Integer>();
		try{
			String orderBy=" a.NUM desc ";
			switch(flag){//设置排序方式
				case 0:orderBy=" a.NUM desc ";
			}
			String sql=" select * from (select  distinct  g.GOODS_ID,g.NUM,  ";
			sql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex from t_goods g ";
			sql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
			sql+=" left join T_GoodsSort st on st.GOODSSORT_ID=g.GOODSSORT_ID";
			sql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID ";
			
			if(arearId!=null){
				sql+=" and pg.CITY_ID='"+arearId+"' ";
	 			}
	 		else 
	 			sql+=" and pg.CITY_ID is null ";
			sql+=")";
			
			sql+="  where  1=1 and g.SHELVES=0 ";
			sql+="and pg.PAGEMODULE_ID="+moduleId+" ";
			if(arearId!=null)
				sql+=" and s.CITY_ID='"+arearId+"' ";
			if(map!=null&&map.get("goodSort_id")!=null){//商品类型
				sql+=" and g.GOODSSORT_ID="+map.get("goodSort_id");
			}
			if(map!=null&&map.get("sytime")!=null){//添加试用时间条件
				String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				if(map.get("sytime").equals("1")){
					sql+=" and g.btime<='"+time+"00:00:00'";
					sql+=" and g.etime>='"+time+"24:00:00'";
				}else if(map.get("sytime").equals("2")){
					sql+=" and g.btime>'"+time+"00:00:00'";
				}else if(map.get("sytime").equals("3")){
					sql+=" and g.etime<'"+time+"24:00:00'";
				}
			}
			if(map!=null&&map.get("goodssort")!=null){//添加试用时间条件
				sql+=" and st.NAME='"+map.get("goodssort")+"'";
			}
			sql+=" group by g.GOODS_ID";
			sql+=" ) a order by a.orderIndex asc,"+orderBy+"    LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
//			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				result.add(rs.getInt(1));
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 试用产品数量
	 * @param arearId
	 * @return
	 */
	public int getTrysortcout(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map){
		int count=0;
		try{
			String orderBy=" a.NUM desc ";
			switch(flag){//设置排序方式
				case 0:orderBy=" a.NUM desc ";
			}
			String sql=" select count(*) from (select  distinct  g.GOODS_ID,g.NUM,  ";
			sql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex from t_goods g ";
			sql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
			sql+=" left join T_GoodsSort st on st.GOODSSORT_ID=g.GOODSSORT_ID";
			sql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID ";
			
			if(arearId!=null){
				sql+=" and pg.CITY_ID='"+arearId+"' ";
	 			}
	 		else 
	 			sql+=" and pg.CITY_ID is null ";
			sql+=")";
			
			sql+="  where  1=1 and g.SHELVES=0 ";
			sql+="and pg.PAGEMODULE_ID="+moduleId+" ";
			if(arearId!=null)
				sql+=" and s.CITY_ID='"+arearId+"' ";
			if(map!=null&&map.get("goodSort_id")!=null){//商品类型
				sql+=" and g.GOODSSORT_ID="+map.get("goodSort_id");
			}
			if(map!=null&&map.get("sytime")!=null){//添加试用时间条件
				String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				if(map.get("sytime").equals("1")){
					sql+=" and g.btime<='"+time+"00:00:00'";
					sql+=" and g.etime>='"+time+"24:00:00'";
				}else if(map.get("sytime").equals("2")){
					sql+=" and g.btime>'"+time+"00:00:00'";
				}else if(map.get("sytime").equals("3")){
					sql+=" and g.etime<'"+time+"24:00:00'";
				}
			}
			if(map!=null&&map.get("goodssort")!=null){//添加试用时间条件
				sql+=" and st.NAME='"+map.get("goodssort")+"'";
			}
			sql+=" group by g.GOODS_ID";
			sql+=" ) a order by a.orderIndex asc,"+orderBy;
//			System.out.println(sql);
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				count=rs.getInt(1);
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 获取最近浏览商家商品排序
	 * @param moduleId 模块ID
	 * @param arearId  城市ID
	 * @param flag	   次排序方式 0销量排
	 * @param page	   分页
	 * @return
	 */
	private List<Integer> getSJGoodsOrderBy(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map,Integer shangjia){
		List<Integer> result=new ArrayList<Integer>();
		try{
			String orderBy=" a.TIME desc ";
			String sql=" select * from (select  distinct  g.GOODS_ID,g.NUM,  ";
			sql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex,sg.TIME from T_SHOW_GOOD sg  ";
			sql+=" left join t_goods g on g.GOODS_ID= sg.GOOD_ID ";
			sql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
			sql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+moduleId+" ";
			if(arearId!=null){
				sql+=" and pg.CITY_ID='"+arearId+"' ";
	 			}
	 		else 
	 			sql+=" and pg.CITY_ID is null ";
			sql+=")";
			sql+="  where 1=1 and g.SHELVES=0 ";
			sql+="  and s.SHANGJIA_ID="+shangjia;
			if(arearId!=null)
				sql+=" and s.CITY_ID='"+arearId+"' ";
			if(map.get("clientID")!=null){//客户ID
				sql+=" and sg.CLINET_ID='"+map.get("clientID")+"' ";
			}
			sql+=" group by g.GOODS_ID";
			sql+=" ) a order by a.orderIndex asc,"+orderBy+"    LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				result.add(rs.getInt(1));
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 获取商品排序
	 * @param moduleId 模块ID
	 * @param arearId  城市ID
	 * @param flag	   次排序方式 0销量排
	 * @param page	   分页
	 * @return
	 */
	private List<Integer> getGoodsOrderBy(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map){
		List<Integer> result=new ArrayList<Integer>();
		try{
			String orderBy=" a.NUM desc ";
			switch(flag){//设置排序方式
				case 0:orderBy=" a.NUM desc ";
			}
			String sql=" select * from (select  distinct  g.GOODS_ID,g.NUM,  ";
			sql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex from t_goods g ";
			sql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
			sql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+moduleId+" ";
			if(arearId!=null){
				sql+=" and pg.CITY_ID='"+arearId+"' ";
	 			}
	 		else 
	 			sql+=" and pg.CITY_ID is null ";
			sql+=")";
			
			sql+="  where  1=1 and g.SHELVES=0 and g.tryuse='0'";
			if(arearId!=null)
				sql+=" and s.CITY_ID='"+arearId+"' ";
			if(map!=null&&map.get("goodSort_id")!=null){//商品类型
				sql+=" and g.GOODSSORT_ID="+map.get("goodSort_id");
			}
			sql+=" group by g.GOODS_ID";
			sql+=" ) a order by a.orderIndex asc,"+orderBy+"    LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
//			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				result.add(rs.getInt(1));
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * 根据商品ID 获取商品当前的销售金额
	 * 如果商品处于活动中 就是商品的活动价格
	 * @param goodsId
	 * @return 活动ID
	 */
	public String getGoodsPrice(Goods good){
		String actId="";
		Session session=this.getSession();
		Double price=0.0;
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			int time=Context.getCurrentTime();
			String slq="select a.TYPE,a.VAL,a.ACTIVE_ID ";
				   slq+=" from t_active a ";
				   slq+=" left join T_ACTIVE_GOODS ag on a.ACTIVE_ID=ag.ACT_ID ";
				   slq+=" where 1=1 ";
				   slq+=" and a.btimel <"+time;//活动已经开始
				   slq+=" and a.etimel >"+time;//活动还未结束
				   slq+=" and a.FLAG=0 ";
				   slq+=" and ag.GOODS_ID="+good.getGoods_id();
		    ResultSet rs=st.executeQuery(slq);
		    while(rs.next()){
		    	String type=rs.getString(1);
		    	Double val=rs.getDouble(2);
		    	if(type.equals("1")){
		    		if(price>val){
		    			price=val;
		    			actId=""+rs.getInt(3);
		    		}
		    	}else if(type.equals("2")){
		    		if(price>good.getSalesMoney()*val/10){
		    			price=good.getSalesMoney()*val/10;
		    			actId=""+rs.getInt(3);
		    		}
		    	}
		    }
		    rs.close();
		    st.close();
		    con.close();
		    good.setActionMoney(price);
		    good.setActionId(actId);
		    this.releaseSession(session);
		}catch(Exception e){
			new GoodsPriceError().printStackTrace();
		}
		return actId;
	}
	
	/*
 	 * 
 	 * 
 	 * 
 	 * 
 	 * 
 	 * 
 	 * 新加代码分隔
 	 * 
 	 * 
 	 * 
 	 * 
 	 * 
 	 * 
 	 * 
 	 */
 	public int getGoodSortCount(String sortId,String arearId){
 		int count=0;
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			int time=Context.getCurrentTime();
 			String slq="select count(*) ";
 				   slq+=" from T_GOODS g ";
 				   slq+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
 				   slq+=" where 1=1 and g.SHELVES=0 ";
 				   if(arearId!=null)
 				   slq+=" and s.CITY_ID='"+arearId+"' ";
 				   slq+=" and g.GOODSSORT_ID ="+sortId;//活动已经开始
 		    ResultSet rs=st.executeQuery(slq);
 		    while(rs.next()){
 		    	count=rs.getInt(1);
 		    }
 		    rs.close();
 		    st.close();
 		    con.close();
 		    this.releaseSession(session);
 		}catch(Exception e){
 			
 		}
 		return count;
 	}
 	
 	public List<Map> getGoodBySlqCount(String goodSort, String sql,
			PageInfo page,String oderBy,String pageModule_id){
 		long t=new Date().getTime()/1000;
 		List list=new ArrayList();
 		String tmpTable="a"+Math.round(Math.random()*1000000);
 		
 		String selectSql=" select  g.GOODS_ID,";
 		selectSql+=" g.salesMoney as salesMoney ,g.BAZAARMONEY as bmoney ,";
 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
 		selectSql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex ,";
 		selectSql+=" g.NAME as GOOD_NAME ,";
 		selectSql+=" p.SALESNUM as SALESNUM ,";
 		selectSql+=" s.NAME as S_NAME ,s.SHANGJIA_ID as shopid";
 		selectSql+=" ,g.DEFAULT_IAMAGE as IAMGE ";
 		selectSql+=" from T_GOODS g  ";
 		selectSql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID   ";
		selectSql+=" left join T_PRODUCT p on p.GOODS_ID=g.GOODS_ID   ";
 		selectSql+=" left join T_ACTIVE_GOODS ag on ag.GOODS_ID=g.GOODS_ID   ";
 		selectSql+=" left join t_active a on (a.ACTIVE_ID=ag.ACT_ID and a.btimel<"+t+" and a.etimel>"+t+")   ";
 		selectSql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+pageModule_id+")   ";
 		selectSql+=" where 1=1  and g.SHELVES=0  and g.tryuse='0' and g.GOODSSORT_ID="+goodSort+sql+" group by g.GOODS_ID";
 		System.out.println(selectSql);
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
 			ResultSet rs=st.executeQuery(" select distinct * from "+tmpTable+"  order by orderIndex asc "+(oderBy!=null?", money "+oderBy:"")+"  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
// 			System.out.println("LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageNo()*page.getPageSize() );
 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
 			int count=rsmd.getColumnCount();
 			while(rs.next()){
	 			Map map=new HashMap();
 				for(int i=1;i<=count;i++){
 					map.put(rsmd.getColumnName(i), rs.getObject(i));
	 			}
 				list.add(map);
 			}
 			rs.close();
 			st.executeUpdate(" drop table "+tmpTable);
 			st.close();
 			con.close();
 			
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		return list;
 	}
 	/**
 	 * 根据查询条件获取商品数量
 	 * @param sortId
 	 * @param arearId
 	 * @param sql
 	 * @return
 	 */
 	public int getGoodBySlqCount(String sortId,  String sql) {
 		int count=0;
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			String slq="select count(*) ";
 				   slq+=" from T_GOODS g";
 				   slq+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
 				   slq+=" where 1=1 and g.SHELVES=0 and s.state=0 ";
 				   slq+=" and g.GOODSSORT_ID ="+sortId;//
 				   if(sql!=null){
 					  slq+=sql;
 				   }
// 				  System.out.println(slq);
 		    ResultSet rs=st.executeQuery(slq);
 		    while(rs.next()){
 		    	count=rs.getInt(1);
 		    }
 		    rs.close();
 		    st.close();
 		    con.close();
 		    this.releaseSession(session);
 		}catch(Exception e){
 			
 		}
 		return count;
 	}
 	/**
 	 * 根据商品类型和区域获取商品数量
 	 * @param sortId
 	 * @param t
 	 * @param arearId
 	 * @return
 	 */
 	public int getGoodSortCount(String sortId,int t,String arearId){
 		int count=0;
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			String slq="select sum(op.GOOD_NUM) ";
 				   slq+=" from T_ORDER o";
 				   slq+=" left T_ORDER_PRODUCT op on op.ORDER_ID=o.ORDER_ID";
 				   slq+=" left join T_PRODUCT p on p.PRODUCT_ID=op.PRODUCT_ID ";
 				   slq+=" left join T_GOODS g on g.GOODS_ID=p.GOODS_ID ";
 				   slq+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
 				   slq+=" where 1=1 and g.SHELVES=0 ";
 				   if(arearId!=null)
 					   slq+=" where s.CITY_ID='"+arearId+"' ";
 				   
 				   slq+=" and g.GOODSSORT_ID ="+sortId;//活动已经开始
 				   slq+=" and o.ipaytime >"+t;//开始时间
 				   slq+=" and o.ipaytime <"+t;//结束时间
 				   slq+=" group by g.GOODS_ID";
 		    ResultSet rs=st.executeQuery(slq);
 		    while(rs.next()){
 		    	count=rs.getInt(1);
 		    }
 		    rs.close();
 		    st.close();
 		    con.close();
 		    this.releaseSession(session);
 		}catch(Exception e){
 			
 		}
 		return count;
 	}
 	
 	/**
	 * 获取最近一周销量
	 * @param moduleId 模块ID
	 * @param arearId  城市ID
	 * @param flag	   次排序方式 0销量排
	 * @param page	   分页
	 * @return
	 */
	private List<Map> getShowGoodsOrderNumBy(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map){
		List<Map> result=new ArrayList<Map>();
		try{
			String sql=" select * from (select  distinct  g.GOODS_ID,sum(op.GOOD_NUM) as NUM,  ";
			sql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex,o.TIME ";
			sql+=" from T_ORDER o";
			sql+=" left join T_ORDER_PRODUCT op on op.ORDER_ID=o.ORDER_ID";
			sql+=" left join T_PRODUCT p on p.PRODUCT_ID=op.PRODUCT_ID ";
			sql+=" left join T_GOODS g on g.GOODS_ID=p.GOODS_ID ";
			sql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
			sql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+moduleId+" ";
			if(arearId!=null){
				sql+=" and pg.CITY_ID='"+arearId+"' ";
	 			}
	 		else 
	 			sql+=" and pg.CITY_ID is null ";
			sql+=")";
			sql+=" where 1=1 and g.SHELVES=0 ";
			if(arearId!=null)
				sql+=" and s.CITY_ID='"+arearId+"' ";
			sql+="  and o.state=3";
			if(map!=null&&map.get("goodSort_id")!=null){//商品类型
				sql+=" and g.GOODSSORT_ID="+map.get("goodSort_id");
			}
			if(map!=null&&map.get("t")!=null){
				sql+=" and o.ipaytime >"+map.get("t");//开始时间
				sql+=" and o.ipaytime <"+map.get("t");//结束时间
			}
			sql+=" ) a where a.GOODS_ID is not null group by a.GOODS_ID order by   a.orderIndex asc ,a.NUM desc   LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
//			System.out.println(sql);
			
			while(rs.next()){
				Map sales=new HashMap();
				sales.put("id", rs.getInt(1));
				sales.put("num", rs.getInt(2));
				result.add(sales);
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 根据sql 获取商家 活动
	 * @param sql
	 * @return
	 */
	public Map getActGood(Integer moduleId,String arearId,String sql,PageInfo page,String orderBy){
		Map result=new HashMap();
		int t=(int)(new Date().getTime()/1000);
		
		try{
			List<Map> list=new ArrayList();
	 		String tmpTable="a"+Math.round(Math.random()*1000000);
	 		String selectSql=" select  g.GOODS_ID as goodId,";
	 		selectSql+=" g.BAZAARMONEY as xmoney ,a.ETIMEL as etimel, ";
	 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
	 		selectSql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex,a.etimel as acttime, ";
	 		selectSql+=" g.NAME as goodName ,g.NUM as xiaoliang,a.FLAG as actFlag,";
	 		selectSql+=" g.DEFAULT_IAMAGE as image ,g.INDEXS as g_index ,a.ACTIVE_ID as actId , g.goodsDescription as description,a.TYPE as actType,s.NAME as shopname,s.SHANGJIA_ID as shopid";
	 		selectSql+=" from t_active  a ";
	 		selectSql+=" left join T_ACTIVE_GOODS ag on a.ACTIVE_ID=ag.ACT_ID   ";
	 		selectSql+=" left join T_GOODS  g on  ag.GOODS_ID=g.GOODS_ID   ";
	 		selectSql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
	 		selectSql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+moduleId+" ";
	 		
	 		if(arearId!=null){
	 			selectSql+=" and pg.CITY_ID='"+arearId+"' ";
	 			}
	 		else 
	 			selectSql+=" and pg.CITY_ID is null ";
	 		selectSql+=")";
	 		
	 		selectSql+=" where 1=1  and g.SHELVES=0   and a.btimel<"+t+" and a.etimel>"+t+" and  g.GOODS_ID is not null ";
	 		if(arearId!=null){
	 			selectSql+=" and s.CITY_ID='"+arearId+"' ";
	 		}
	 		
	 		if(sql!=null)
	 			selectSql+=sql;
	 		selectSql+=" group by g.GOODS_ID  ";
//	 		System.out.println(selectSql);
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			
 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
 		//	System.out.println(" create temporary table "+tmpTable +selectSql);
 	//		System.out.println("select distinct "+tmpTable+".*,count(*) as cnum,sum(c.LEVE) as lev from "+tmpTable+"  left join  T_COMMENT_INFO c on c.GINFO_ID=goodId group by goodId  order by orderIndex asc "+(orderBy==null?" ,acttime desc ":orderBy)+"   LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageNo()*page.getPageSize()+"  ");
 			ResultSet rs=st.executeQuery(" select distinct "+tmpTable+".*,count(*) as cnum,sum(c.LEVE) as lev from "+tmpTable+
 					"  left join  T_COMMENT_INFO c on c.GINFO_ID=goodId group by goodId  order by orderIndex asc "
 					+(orderBy==null?" ,acttime desc ":orderBy)+"   LIMIT "
 					+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize()+"  ");
 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
 			int count=rsmd.getColumnCount();
 			while(rs.next()){
	 			Map map=new HashMap();
 				for(int i=1;i<=count;i++){
 					map.put(rsmd.getColumnName(i), rs.getObject(i));
	 			}
 				int at=(Integer) map.get("acttime");
 				String time=getTime(at-t);
 				map.put("description2", map.get("description"));
 				String description=StringUtil.replaceImage((String)map.get("description"));
 				map.put("description", description);
 				
 				map.put("ctime", time);
 				list.add(map);
 			}
 			rs.close();
 			for(Map m:list){
 				int gid=(Integer)m.get("goodId");
 				rs=st.executeQuery("select count(*) from T_ORDER as o left join T_ORDER_PRODUCT  op " +
 						"on op.ORDER_ID=o.ORDER_ID   left join T_PRODUCT p " +
 						"on op.PRODUCT_ID=p.PRODUCT_ID where p.GOODS_ID="+gid);
 				if(rs.next()){
 					m.put("xiaoliang", rs.getInt(1));
 				}
 			}
 			
 			rs=st.executeQuery("select count(*) from "+tmpTable);
 			if(rs.next())
 				page.setTotalCount(rs.getInt(1));
 			rs.close();
 			result.put("num", page.getTotalCount());
 			result.put("data", list);
 			result.put("page", page);
 			st.executeUpdate(" drop table "+tmpTable);
 			st.close();
 			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 根据sql 获取商家 活动
	 * @param sql
	 * @return
	 */
	public Map getActGood(Integer moduleId,String arearId,String sortId,PageInfo page){
		Map result=new HashMap();
		int t=(int)(new Date().getTime()/1000);
//		System.out.println(t);
		try{
			List<Map> list=new ArrayList();
	 		String tmpTable="a"+Math.round(Math.random()*1000000);
	 		String selectSql=" select  g.GOODS_ID as goodId,";
	 		selectSql+=" g.BAZAARMONEY as xmoney ,";
	 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
	 		selectSql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex,a.etimel as acttime, ";
	 		selectSql+=" g.NAME as goodName ,g.NUM as xiaoliang,a.FLAG as actFlag,";
	 		selectSql+=" g.DEFAULT_IAMAGE as image ,g.INDEXS as g_index ,a.ACTIVE_ID as actId , g.goodsDescription as description,a.TYPE as actType";
	 		selectSql+=" from t_active  a";
	 		selectSql+=" left join T_ACTIVE_GOODS ag on a.ACTIVE_ID=ag.ACT_ID   ";
	 		selectSql+=" left join T_GOODS  g on  ag.GOODS_ID=g.GOODS_ID   ";
	 		selectSql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
	 		selectSql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+moduleId+" ";
	 		
	 		if(arearId!=null){
	 			selectSql+=" and pg.CITY_ID='"+arearId+"' ";
	 			}
	 		else 
	 			selectSql+=" and pg.CITY_ID is null ";
	 		selectSql+=")";
	 		
	 		selectSql+=" where 1=1  and g.SHELVES=0   and a.btimel<"+t+" and a.etimel>"+t+" and  g.GOODS_ID is not null ";
	 		if(arearId!=null){
	 			selectSql+=" and s.CITY_ID='"+arearId+"' ";
	 			}
	 		selectSql+=" and g.GOODSSORT_ID="+sortId;
	 		selectSql+=" group by g.GOODS_ID";
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
 			ResultSet rs=st.executeQuery(" select distinct "+tmpTable+".*,count(*) as cnum,sum(c.LEVE) as lev from "+tmpTable+
 					"  left join  T_COMMENT_INFO c on c.GINFO_ID=goodId group by goodId " +
 					" order by orderIndex asc    LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
 			int count=rsmd.getColumnCount();
 			while(rs.next()){
	 			Map map=new HashMap();
 				for(int i=1;i<=count;i++){
 					map.put(rsmd.getColumnName(i), rs.getObject(i));
	 			}
 				int at=(Integer) map.get("acttime");
 				String time=getTime(at-t);
 				map.put("description2", map.get("description"));
 				String description=StringUtil.replaceImage((String)map.get("description"));
 				map.put("description", description);
 				
 				map.put("ctime", time);
 				list.add(map);
 			}
 			rs.close();
 			for(Map m:list){
 				int gid=(Integer)m.get("goodId");
 				rs=st.executeQuery("select count(*) from T_ORDER as o left join T_ORDER_PRODUCT  op on op.ORDER_ID=o.ORDER_ID   left join T_PRODUCT p on op.PRODUCT_ID=p.PRODUCT_ID where p.GOODS_ID="+gid);
 				if(rs.next()){
 					m.put("xiaoliang", rs.getInt(1));
 				}
 			}
 			
 			rs=st.executeQuery("select count(*) from "+tmpTable);
 			if(rs.next())
 				page.setTotalCount(rs.getInt(1));
 			rs.close();
 			result.put("num", page.getTotalCount());
 			result.put("data", list);
 			result.put("page", page);
 			st.executeUpdate(" drop table "+tmpTable);
 			st.close();
 			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 *	获取会员购买过的商品
	 * @param sql
	 * @return
	 */
	public Map getBuyGood(Integer moduleId,String arearId,String goodId,PageInfo page){
		Map result=new HashMap();
		int t=(int)(new Date().getTime()/1000);
		try{
			List<Map> list=new ArrayList();
	 		String tmpTable="a"+Math.round(Math.random()*1000000);
	 		String selectSql=" select  g.GOODS_ID as goodId, ";
	 		selectSql+=" g.BAZAARMONEY as xmoney ,";
	 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
	 		selectSql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex, ";
	 		selectSql+=" g.NAME as goodName ,g.NUM as xiaoliang,";
	 		selectSql+=" g.DEFAULT_IAMAGE as image ,g.INDEXS as g_index ,a.ACTIVE_ID as actId , g.goodsDescription as description,a.TYPE as actType";
	 		selectSql+=" from T_GOODS  g ";
	 		selectSql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
	 		selectSql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+moduleId+" ";
	 		
	 		if(arearId!=null){
	 			selectSql+=" and pg.CITY_ID='"+arearId+"' ";
	 			}
	 		else 
	 			selectSql+=" and pg.CITY_ID is null ";
	 		selectSql+=")";
	 		
	 		selectSql+=" left join T_PRODUCT  p on  p.GOODS_ID=g.GOODS_ID   ";
	 		selectSql+=" left join T_ORDER_PRODUCT  op on  op.PRODUCT_ID=p.PRODUCT_ID   ";
	 		selectSql+=" left join T_ORDER  o on  o.ORDER_ID=op.ORDER_ID   ";
	 		selectSql+=" left join T_ACTIVE_GOODS ag on ag.GOODS_ID=g.GOODS_ID   ";
	 		selectSql+=" left join t_active a on (a.ACTIVE_ID=ag.ACT_ID and a.btimel<"+t+" and a.etimel>"+t+")   ";
	 		selectSql+=" left join T_ORDER  ho on  ho.HUIYUAN_ID=o.HUIYUAN_ID   ";
	 		selectSql+=" left join T_ORDER_PRODUCT  hop on  hop.ORDER_ID=ho.ORDER_ID   ";
	 		selectSql+=" left join T_PRODUCT  hp on  hp.PRODUCT_ID=hop.PRODUCT_ID   ";
	 		selectSql+=" where 1=1 and g.SHELVES=0    and  g.GOODS_ID is not null and hp.GOODS_ID="+goodId+" and g.GOODS_ID!="+goodId;
	 		if(arearId!=null){
	 			selectSql+=" and s.CITY_ID='"+arearId+"' ";
	 			}
	 		selectSql+=" group by g.GOODS_ID";
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
 			ResultSet rs=st.executeQuery(" select distinct "+tmpTable+".*,count(*) as cnum,sum(c.LEVE) as lev from "+tmpTable+"  left join  T_COMMENT_INFO c on c.GINFO_ID=goodId group by goodId  order by orderIndex asc    LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
 			int count=rsmd.getColumnCount();
 			while(rs.next()){
	 			Map map=new HashMap();
 				for(int i=1;i<=count;i++){
 					map.put(rsmd.getColumnName(i), rs.getObject(i));
	 			}
 				list.add(map);
 			}
 			rs.close();
 			for(Map m:list){
 				int gid=(Integer)m.get("goodId");
 				rs=st.executeQuery("select count(*) from T_ORDER as o left join T_ORDER_PRODUCT  op on op.ORDER_ID=o.ORDER_ID   left join T_PRODUCT p on op.PRODUCT_ID=p.PRODUCT_ID where p.GOODS_ID="+gid);
 				if(rs.next()){
 					m.put("xiaoliang", rs.getInt(1));
 				}
 			}
 			
 			rs=st.executeQuery("select count(*) from "+tmpTable);
 			if(rs.next())
 				page.setTotalCount(rs.getInt(1));
 			rs.close();
 			result.put("num", page.getTotalCount());
 			result.put("data", list);
 			result.put("page", page);
 			st.executeUpdate(" drop table "+tmpTable);
 			st.close();
 			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	private String getTime(int t){
		int h=t/3600;
		int m=t%3600/60;
		int s=t%3600%60;
		String time=""+(h>9?h:"0"+h)+":"+(m>9?m:"0"+m)+":"+(s>9?s:"0"+s);
		return time;
	}
	
	
	
	/**
	 * 根据sql 获取产品信息
	 * @param sql
	 * @param page
	 * @param oderBy
	 * @param pageModule_id
	 * @return
	 */
	public List<Map> getGoodBySlq(String sql,
			PageInfo page,String oderBy,String pageModule_id){
 		long t=new Date().getTime()/1000;
 		List list=new ArrayList();
 		String tmpTable="a"+Math.round(Math.random()*1000000);
 		
 		String selectSql=" select  g.GOODS_ID,";
 		
 		selectSql+=" g.salesMoney as salesMoney ,g.BAZAARMONEY as bmoney ,";
 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
 		selectSql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex ,";
 		selectSql+=" g.NAME as GOOD_NAME ,";
 		selectSql+=" s.NAME as S_NAME ,";
 		selectSql+=" g.DEFAULT_IAMAGE as IAMGE ,";
 		selectSql+=" g.SYS_TIME as sys_time ,";
 		selectSql+=" g.NUM as num,s.SHANGJIA_ID as shopid ";
 		selectSql+=" from T_GOODS g  ";
 		selectSql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID   ";
 		selectSql+=" left join T_ACTIVE_GOODS ag on ag.GOODS_ID=g.GOODS_ID   ";
 		selectSql+=" left join t_active a on (a.ACTIVE_ID=ag.ACT_ID and a.btimel<"+t+" and a.etimel>"+t+")   ";
 		selectSql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+pageModule_id+")   ";
 		selectSql+=" where 1=1  and g.SHELVES=0   ";
 		if(sql!=null)
 			selectSql+=sql;
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
// 			System.out.println(selectSql);
 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
 			String serchType="";
 			if(oderBy!=null&&oderBy.length()==1){
 				 if(oderBy.equals("0")){
 					serchType+=" ,salesMoney desc";
 				 }else if(oderBy.equals("1")){
 					serchType+=" ,num desc";
 				 }else if(oderBy.equals("2")){
 					serchType+=" ,num desc";
 				 }else if(oderBy.equals("3")){
 					serchType+=" ,sys_time desc";
 				 }
 				oderBy=null;
 			}
// 			System.out.println(" select distinct * from "+tmpTable+"  order by orderIndex asc "+serchType+(oderBy!=null?", money "+oderBy:"")+"  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageNo()*page.getPageSize()+"  ");
 			String sqlO = " select distinct * from "+tmpTable+
 					"  order by orderIndex asc "+serchType+(oderBy!=null?", money "
 			+oderBy:"")+"  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize()+ " ";
 			System.out.println(sqlO);
 			ResultSet rs=st.executeQuery(sqlO);
 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
 			int count=rsmd.getColumnCount();
 			while(rs.next()){
	 			Map map=new HashMap();
 				for(int i=1;i<=count;i++){
 					map.put(rsmd.getColumnName(i), rs.getObject(i));
	 			}
 				list.add(map);
 			}
 			rs.close();
 			st.executeUpdate(" drop table "+tmpTable);
 			st.close();
 			con.close();
 			
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		return list;
 	}
	/**
	 * 根据sql 获取产品数量
	 * @param sql
	 * @return
	 */
	public int getGoodBySlqCount(String sql) {
 		int count=0;
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			String slq="select count(*) ";
 				   slq+=" from T_GOODS g ";
 				   slq+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID ";
 				   slq+=" where 1=1 and g.SHELVES=0 ";
 				   if(sql!=null){
 					  slq+=sql;
 				   }
 				   System.out.println(slq);
 		    ResultSet rs=st.executeQuery(slq);
 		   
 		    while(rs.next()){
 		    	count=rs.getInt(1);
 		    }
 		    rs.close();
 		    st.close();
 		    con.close();
 		    this.releaseSession(session);
 		}catch(Exception e){
 			
 		}
 		return count;
 	}
	
	
	/**
	 * 根据sql 获取产品数量--主要是搜索里的价格区间限制
	 * @param sql
	 * @return
	 */
	public int getGoodByWhereCount(String sql,String moneysql) {
		int count=0;
 		long t=new Date().getTime()/1000;
 		List list=new ArrayList();
 		String tmpTable="a"+Math.round(Math.random()*1000000);
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			String selectSql=" select count(*) from (select  g.GOODS_ID,";
 	 		
 	 		selectSql+=" g.salesMoney as salesMoney ,g.BAZAARMONEY as bmoney ,";
 	 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
 	 		selectSql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex ,";
 	 		selectSql+=" g.NAME as GOOD_NAME ,";
 	 		selectSql+=" s.NAME as S_NAME ,";
 	 		selectSql+=" g.DEFAULT_IAMAGE as IAMGE ,";
 	 		selectSql+=" g.SYS_TIME as sys_time ,";
 	 		selectSql+=" g.NUM as num ";
 	 		selectSql+=" from T_GOODS g  ";
 	 		selectSql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID   ";
 	 		selectSql+=" left join T_ACTIVE_GOODS ag on ag.GOODS_ID=g.GOODS_ID   ";
 	 		selectSql+=" left join t_active a on (a.ACTIVE_ID=ag.ACT_ID and a.btimel<"+t+" and a.etimel>"+t+")   ";
 	 		selectSql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID=40"+")   ";
 	 		selectSql+=" where 1=1  and g.SHELVES=0   ";
 	 		if(sql!=null)
 	 			selectSql+=sql;
 	 		
 	 		selectSql+=" ) a where 1=1";
 	 		if(moneysql!=null)
 	 			selectSql+=moneysql;
 	 		//System.out.println("--------------"+selectSql);
 		    ResultSet rs=st.executeQuery(selectSql);
 		   
 		    while(rs.next()){
 		    	count=rs.getInt(1);
 		    }
 		    rs.close();
 		    st.close();
 		    con.close();
 		    this.releaseSession(session);
 		}catch(Exception e){
 			
 		}
 		return count;
 	}
	

	/**
	 * 根据sql 获取产品信息
	 * @param sql
	 * @param page
	 * @param oderBy
	 * @param pageModule_id
	 * @return
	 */
	public List<Map> getGoodBywhere(String sql,String moneysql,
			PageInfo page,String oderBy,String pageModule_id){
 		long t=new Date().getTime()/1000;
 		List list=new ArrayList();
 		String tmpTable="a"+Math.round(Math.random()*1000000);
 		
 		String selectSql=" select * from (select  g.GOODS_ID,";
 		
 		selectSql+=" g.salesMoney as salesMoney ,g.BAZAARMONEY as bmoney ,";
 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
 		selectSql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex ,";
 		selectSql+=" g.NAME as GOOD_NAME ,";
 		selectSql+=" s.NAME as S_NAME ,";
 		selectSql+=" g.DEFAULT_IAMAGE as IAMGE ,";
 		selectSql+=" g.SYS_TIME as sys_time ,";
 		selectSql+=" g.NUM as num ";
 		selectSql+=" from T_GOODS g  ";
 		selectSql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID   ";
 		selectSql+=" left join T_ACTIVE_GOODS ag on ag.GOODS_ID=g.GOODS_ID   ";
 		selectSql+=" left join t_active a on (a.ACTIVE_ID=ag.ACT_ID and a.btimel<"+t+" and a.etimel>"+t+")   ";
 		selectSql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+pageModule_id+")   ";
 		selectSql+=" where 1=1  and g.SHELVES=0   ";
 		if(sql!=null)
 			selectSql+=sql;
 		
 		selectSql+=" ) a where 1=1";
 		if(moneysql!=null)
 			selectSql+=moneysql;
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 		//	System.out.println(selectSql);
 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
 			String serchType="";
 			if(oderBy!=null&&oderBy.length()==1){
 				 if(oderBy.equals("0")){
 					serchType+=" ,salesMoney desc";
 				 }else if(oderBy.equals("1")){
 					serchType+=" ,num desc";
 				 }else if(oderBy.equals("2")){
 					serchType+=" ,num desc";
 				 }else if(oderBy.equals("3")){
 					serchType+=" ,sys_time desc";
 				 }
 				oderBy=null;
 			}
// 			System.out.println(" select distinct * from "+tmpTable+"  order by orderIndex asc "+serchType+(oderBy!=null?", money "+oderBy:"")+"  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageNo()*page.getPageSize()+"  ");
 			ResultSet rs=st.executeQuery(" select distinct * from "+tmpTable+"  order by orderIndex asc "+serchType+(oderBy!=null?", money "+oderBy:"")+"  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
 			int count=rsmd.getColumnCount();
 			while(rs.next()){
	 			Map map=new HashMap();
 				for(int i=1;i<=count;i++){
 					map.put(rsmd.getColumnName(i), rs.getObject(i));
	 			}
 				list.add(map);
 			}
 			rs.close();
 			st.executeUpdate(" drop table "+tmpTable);
 			st.close();
 			con.close();
 			
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		return list;
 	}
	
	
	
	public List<Map> getGoodBySlqCount(String goodSort, String sql,String moneysql,
			PageInfo page,String oderBy,String pageModule_id){
 		long t=new Date().getTime()/1000;
 		List list=new ArrayList();
 		String tmpTable="a"+Math.round(Math.random()*1000000);
 		
 		String selectSql=" select * from (select  g.GOODS_ID,";
 		selectSql+=" g.salesMoney as salesMoney ,g.BAZAARMONEY as bmoney ,";
 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
 		selectSql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex ,";
 		selectSql+=" g.NAME as GOOD_NAME ,";
 		selectSql+=" p.SALESNUM as SALESNUM ,";
 		selectSql+=" s.NAME as S_NAME ,s.SHANGJIA_ID as shopid";
 		selectSql+=" ,g.DEFAULT_IAMAGE as IAMGE ";
 		selectSql+=" from T_GOODS g  ";
 		selectSql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID   ";
		selectSql+=" left join T_PRODUCT p on p.GOODS_ID=g.GOODS_ID   ";
 		selectSql+=" left join T_ACTIVE_GOODS ag on ag.GOODS_ID=g.GOODS_ID   ";
 		selectSql+=" left join t_active a on (a.ACTIVE_ID=ag.ACT_ID and a.btimel<"+t+" and a.etimel>"+t+")   ";
 		selectSql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID="+pageModule_id+")   ";
 		selectSql+=" where 1=1  and g.SHELVES=0  and g.tryuse='0' and g.GOODSSORT_ID="+goodSort+sql+" group by g.GOODS_ID";
 		selectSql+=" ) a where 1=1";
 		if(moneysql!=null)
 			selectSql+=moneysql;
 		System.out.println(selectSql);
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
 			ResultSet rs=st.executeQuery(" select distinct * from "+tmpTable+"  order by orderIndex asc "+(oderBy!=null?", money "+oderBy:"")+"  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
// 			System.out.println("LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageNo()*page.getPageSize() );
 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
 			int count=rsmd.getColumnCount();
 			while(rs.next()){
	 			Map map=new HashMap();
 				for(int i=1;i<=count;i++){
 					map.put(rsmd.getColumnName(i), rs.getObject(i));
	 			}
 				list.add(map);
 			}
 			rs.close();
 			st.executeUpdate(" drop table "+tmpTable);
 			st.close();
 			con.close();
 			
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		return list;
 	}
 	/**
 	 * 根据查询条件获取商品数量
 	 * @param sortId
 	 * @param arearId
 	 * @param sql
 	 * @return
 	 */
 	public int getGoodBySlqCount(String sortId,String sql,String moneysql) {
 		int count=0;
 		long t=new Date().getTime()/1000;
 		List list=new ArrayList();
 		String tmpTable="a"+Math.round(Math.random()*1000000);
 		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			String selectSql=" select count(*) from (select  g.GOODS_ID,";
 	 		selectSql+=" g.salesMoney as salesMoney ,g.BAZAARMONEY as bmoney ,";
 	 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
 	 		selectSql+=" case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex ,";
 	 		selectSql+=" g.NAME as GOOD_NAME ,";
 	 		selectSql+=" p.SALESNUM as SALESNUM ,";
 	 		selectSql+=" s.NAME as S_NAME ,s.SHANGJIA_ID as shopid";
 	 		selectSql+=" ,g.DEFAULT_IAMAGE as IAMGE ";
 	 		selectSql+=" from T_GOODS g  ";
 	 		selectSql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID   ";
 			selectSql+=" left join T_PRODUCT p on p.GOODS_ID=g.GOODS_ID   ";
 	 		selectSql+=" left join T_ACTIVE_GOODS ag on ag.GOODS_ID=g.GOODS_ID   ";
 	 		selectSql+=" left join t_active a on (a.ACTIVE_ID=ag.ACT_ID and a.btimel<"+t+" and a.etimel>"+t+")   ";
 	 		selectSql+=" left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID and pg.PAGEMODULE_ID=35"+")   ";
 	 		selectSql+=" where 1=1  and g.SHELVES=0  and g.tryuse='0' and g.GOODSSORT_ID="+sortId+sql+" group by g.GOODS_ID";
 	 		selectSql+=" ) a where 1=1";
 	 		if(moneysql!=null)
 	 			selectSql+=moneysql;
 		    ResultSet rs=st.executeQuery(selectSql);
 		    while(rs.next()){
 		    	count=rs.getInt(1);
 		    }
 		    rs.close();
 		    st.close();
 		    con.close();
 		    this.releaseSession(session);
 		}catch(Exception e){
 			
 		}
 		return count;
 	}
}
