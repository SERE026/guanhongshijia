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

package cn.com.dyninfo.o2o.furniture.web.order.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Product;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.OrderProduct;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;

/**
 *  定单DAO
 * @author Administrator
 *
 */
@Repository("orderDao")
public class OrderDao extends BaseDAO{
	
	@Resource
	private HttpServletRequest request;
	
	/**
	 * 覆盖父类方法，加入登录用户判断，防止非法用户通过地址来访问
	 */
	@Override
	public List<?> getListByWhere(StringBuffer where) {
		// 取request
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		// 查询语句
		StringBuffer where1 = new StringBuffer();
		List<?> list = null;
		// 取会员信息
		HuiyuanInfo huiyuan=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
		// 取商家信息
		UserInfo info=(UserInfo) request.getSession().getAttribute("UserInfo");
		/** 如果是后台管理人员调用此方法获取订单列表，此时不能加会员登录的判断 **/
		if (info != null) {
			list = super.getListByWhere(where);
		} else {
			/** 否则，查询条件中加入会员ID条件 **/
			// 【已测试】如果不这样做，那么任何登录用户只要知道订单号（通过批量枚举，因为订单号格式是固定的），
			// 就可以通过地址栏访问订单详情，这样会造成用户隐私泄露，带来安全隐患
			where.append(" and n.huiyuan.huiYuan_id=" + huiyuan.getHuiYuan_id());
			list = super.getListByWhere(where);
		}
		return list;
	}
	
	@Autowired
	public OrderDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="Order";
	}
	
	public int getbaobeiCount(int id,String name){
		int count=0;
		try{
			String sql=" select count( a.ORDER_ID) ";
			sql+="from t_order a ";
			sql+=" left join  T_ORDER_PRODUCT b on a.ORDER_ID=b.ORDER_ID left join T_PRODUCT c on b.PRODUCT_ID=c.PRODUCT_ID ";
			sql+=" where a.HUIYUAN_ID="+id+" and c.name like '%"+name+"%' ";
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
			return count;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public List getbaobei(int id,String name,PageInfo page){//搜索宝贝
		List result=new ArrayList();
		int t=(int)(new Date().getTime()/1000);
		try{
		String sql=" select a.ORDER_ID,b.SHOW_STATS ,a.time ,c.name ";
		sql+="from t_order a ";
		sql+=" left join  T_ORDER_PRODUCT b on a.ORDER_ID=b.ORDER_ID left join T_PRODUCT c on b.PRODUCT_ID=c.PRODUCT_ID ";
		sql+=" where a.HUIYUAN_ID="+id+" and c.name like '%"+name+"%' ";
		sql+=" group by a.ORDER_ID order by a. time desc LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
		
		Session session=this.getSession();
		Connection con=session.connection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			Map map=new HashMap();
			map.put("order_id", rs.getString(1));
			result.add(map);
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
	 * 获取晒单数量
	 * @param id
	 * @return
	 */
	public int getOrderShowCount(int id){
		int count=0;
		try{
			String sql=" select count(a.ORDER_ID)  from t_order a ";
			sql+=" left join  T_ORDER_PRODUCT b on a.ORDER_ID=b.ORDER_ID ";
			sql+="where b.SHOW_STATS='1' and a.STATE=3 and a.HUIYUAN_ID="+id;
			sql+="  order by a. time desc ";
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
	
	public List getordershow(int id,PageInfo page){//晒单
		List result=new ArrayList();
		int t=(int)(new Date().getTime()/1000);
		try{
		String sql=" select a.ORDER_ID,b.SHOW_STATS ,a.time  from t_order a ";
		sql+=" left join  T_ORDER_PRODUCT b on a.ORDER_ID=b.ORDER_ID ";
		sql+="where b.SHOW_STATS='1' and a.STATE=3 and a.HUIYUAN_ID="+id;
		sql+=" group by a.ORDER_ID order by a. time desc LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
		Session session=this.getSession();
		Connection con=session.connection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			Map map=new HashMap();
			map.put("order_id", rs.getString(1));
			result.add(map);
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
	 * 
	 * @param where
	 * @param page
	 * @return
	 */
	public HashMap<String,?> getBySqlSjhy(StringBuffer where,PageInfo page){
		HashMap map=new HashMap();
		int count=0;
		Double allmoney=0.0;
		int ordernum=0;
		StringBuffer hsql=new StringBuffer();
		List list=new ArrayList();
		hsql.append("  t_order a ");
		hsql.append(" left join t_huiyuan_info b on a.HUIYUAN_ID=b.HUIYUAN_ID   ");
		hsql.append(" left join t_shangjia_info c on b.shang_id=c.SHANGJIA_ID   ");
		hsql.append(" left join base_user_info d on c.SHANGJIA_ID=d.login_id  where 1=1 "+where);
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from "+hsql);
			if(rs.next())
				count=rs.getInt(1);
			rs.close();
			page.setTotalCount(count);
			hsql.append(" LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
//			System.out.println("select b.NAME,a.order_id,a.endTime,c.NAME,a.ORDER_PRICE from"+hsql);
			rs=st.executeQuery("select b.NAME,a.order_id,a.endTime,c.NAME,a.ORDER_PRICE from"+hsql);
			while (rs.next()) {
				HashMap map1=new HashMap();
				map1.put("name", rs.getString(1)+"");
				map1.put("order", rs.getString(2)+"");
				map1.put("time", rs.getString(3)+"");
				map1.put("sname", rs.getString(4)+"");
				map1.put("money", rs.getString(5)+"");
			    list.add(map1);
			}
			rs.close();
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("PAGE_INFO", page);
		map.put("DATA",list);
		return map;
	}
	/**
	 * 
	 * @param where
	 * @param page
	 * @return
	 */
	public HashMap<String,?> getByPageWhere(StringBuffer where,PageInfo page,StringBuffer where2){
		HashMap map=new HashMap();
		int count=0;
		StringBuffer hsql=new StringBuffer();
		List list=new ArrayList();
		hsql.append("   T_SHANGJIA_INFO s");
		hsql.append(" left join  ");
		hsql.append(" (select MARCHANTS_ID as shopId,count(*) as total,sum(ORDER_PRICE) as money from T_ORDER a  where  a.STATE=3 "+where+" group by shopId) a");
		hsql.append(" on a.shopId =s.SHANGJIA_ID ");
		hsql.append(" left join ");
		hsql.append(" (select MARCHANTS_ID as shopId,count(*) as total2,sum(ORDER_PRICE) as money2 from T_ORDER a  where a.STATE=3 "+where+"   group by shopId) b ");
		hsql.append(" on a.shopId =b.shopId where 1=1 "+where2);
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from "+hsql);
			if(rs.next())
				count=rs.getInt(1);
			rs.close();
			page.setTotalCount(count);
			hsql.append(" LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
			rs=st.executeQuery("select s.SHANGJIA_ID,s.NAME,a.*,b.* from "+hsql);
			
			while (rs.next()) {
				HashMap map1=new HashMap();
				map1.put("shangjia_id",rs.getInt(1));
				map1.put("name",rs.getString(2));
			    map1.put("sum1",rs.getInt(4));
			    map1.put("money1",rs.getDouble(5));
			    map1.put("sum2",rs.getInt(7));
			    map1.put("money5",rs.getDouble(8));
			    list.add(map1);
			}
			rs.close();
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("PAGE_INFO", page);
		map.put("DATA",list);
		return map;
	}
	
	/**
	 * 
	 * @param where
	 * @param page
	 * @return
	 */
	public List getListByPage(StringBuffer where) {
		List datas=new ArrayList();
		try{
			StringBuffer hsql = new StringBuffer();
			hsql.append("from Order as n where 1=1 ");
			if (where != null && !where.toString().equals(""))
				hsql.append(where);
			Query query =this.getSession().createQuery(hsql.toString());
			datas=query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return datas;
	}
	
	
	public Trade getTrade(String tradeNo){
		return this.getHibernateTemplate().load(Trade.class, tradeNo);
	}
	public Double getTradeMoney(String tradeNo) {
		Double result=0.0;
		try{
			Session  session=this.getSessionFactory().getCurrentSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select sum(ORDER_PRICE) from T_ORDER where TRADENO='"+tradeNo+"' ");
			if(rs.next()){
				result=rs.getDouble(1);
			}
			rs.close();
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	
	/**
	 * 更新产品数量
	 * @param oder
	 */
	public void updateGoodsnum(Order oder){
		for(OrderProduct product:oder.getOrderProductList()){
			Product info=product.getProduct();
			Goods goods=info.getGood();
			goods.setNum(goods.getNum()+product.getNum());
			goods.setInventory(goods.getInventory()-product.getNum());
			this.getHibernateTemplate().update(goods);
		}
	}
	
	
	/**
	 * 会员消费纪录
	 * @param where
	 * @param page
	 * @return
	 */
	public HashMap<String,?> getBySqlhyxfjl(StringBuffer where,PageInfo page){
		HashMap map=new HashMap();
		int count=0;
		Double allmoney=0.0;
		int ordernum=0;
		StringBuffer hsql=new StringBuffer();
		List list=new ArrayList();
		hsql.append("  t_order a ");
		hsql.append(" left join t_huiyuan_info b on a.HUIYUAN_ID=b.HUIYUAN_ID   ");
		hsql.append(" left join t_shangjia_info c on a.MARCHANTS_ID=c.SHANGJIA_ID     ");
		hsql.append("where 1=1 "+where);
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from "+hsql);
			if(rs.next())
				count=rs.getInt(1);
			rs.close();
			page.setTotalCount(count);
			hsql.append(" LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
//			System.out.println("select b.NAME,a.order_id,a.endTime,c.NAME,a.ORDER_PRICE from"+hsql);
			rs=st.executeQuery("select b.NAME,a.order_id,a.endTime,c.NAME,a.ORDER_PRICE from"+hsql);
			while (rs.next()) {
				HashMap map1=new HashMap();
				map1.put("name", rs.getString(1));
				map1.put("order", rs.getString(2));
				map1.put("time", rs.getString(3));
				map1.put("sname", rs.getString(4));
				map1.put("money", rs.getString(5));
				map1.put("money", rs.getString(5));
				map1.put("tradeNo", rs.getString(5));
			    list.add(map1);
			}
			rs.close();
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("PAGE_INFO", page);
		map.put("DATA",list);
		return map;
	}
	
	public List<?> getorderlist(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from Order as n where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		return this.getHibernateTemplate().find(hsql.toString());
	}
}
