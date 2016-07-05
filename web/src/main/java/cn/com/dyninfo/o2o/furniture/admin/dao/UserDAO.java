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

package cn.com.dyninfo.o2o.furniture.admin.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.model.ControlGroupInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.GroupResRelation;
import cn.com.dyninfo.o2o.furniture.admin.model.OgnzInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.RoleInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;

@Repository("userDAO")
public class UserDAO extends HibernateDaoSupport implements IBaseDAO {
	@Autowired
	public UserDAO(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateObj(Object obj) {
		this.getHibernateTemplate().update(obj);
		
	}
	
	/**
	 * 根据角色和部门得到用户
	 * @param roleList
	 * @param ognzList
	 * @return
	 */
	public List<UserInfo> getList(List<RoleInfo> roleList, List<OgnzInfo> ognzList){
		StringBuffer sql=new StringBuffer();
		sql.append("select distinct userInfo.LOGIN_ID, userInfo.USER_NAME," +
				"userInfo.PASSWD, userInfo.ISUSED, userInfo.PS, userInfo.OFF_TEL," +
				"userInfo.MOBILE, userInfo.EMAIL, userInfo.IMG, userInfo.IS_DEFAULT, userInfo.INDEX_ORDER " +
				"from BASE_USER_INFO as userInfo, BASE_USER_ROLE ur, BASE_OGNZ_USER ou ");
		sql.append("where userInfo.LOGIN_ID = ur.USER_ID and userInfo.LOGIN_ID = ou.USER_ID ");
		if(roleList != null){
			sql.append(" and ur.ROLE_ID in (");
			for(RoleInfo role : roleList){
				sql.append("'"+role.getId()+"'");
				if(roleList.lastIndexOf(role) != roleList.size()-1)
					sql.append(",");
			}
			sql.append(")");
		}
		if(ognzList != null){
			sql.append(" and ou.OGNZ_ID in (");
			for(OgnzInfo ognz : ognzList){
				sql.append("'"+ognz.getId()+"'");
				if(ognzList.lastIndexOf(ognz) != ognzList.size()-1)
					sql.append(",");
			}
			sql.append(")");
		}
		sql.append(" order by userInfo.INDEX_ORDER asc");
		SQLQuery q = this.getSession().createSQLQuery(sql.toString());
		q.addEntity(UserInfo.class);
		return q.list();
	}
	
	/**
	 * 根据组织ID得到用户
	 * @param ognzId
	 * @return
	 */
	public List<UserInfo> getListByOgnzId(String ognzId, StringBuffer where){
		StringBuffer sql=new StringBuffer();
		sql.append("select distinct userInfo.* from BASE_USER_INFO as userInfo, BASE_OGNZ_USER ou ");
		sql.append("where userInfo.LOGIN_ID = ou.USER_ID ");
		if(ognzId != null){
			sql.append(" and ou.OGNZ_ID ='").append(ognzId).append("' ");
		}
		if(where!=null&&!where.toString().equals(""))
			sql.append(where);
		sql.append(" order by userInfo.INDEX_ORDER asc");
		SQLQuery q = this.getSession().createSQLQuery(sql.toString());
		q.addEntity(UserInfo.class);
		return q.list();
	}
		
	/**
	 * 根据组织ID得到用户
	 * @param ognzId
	 * @param page
	 * @return
	 */
	public HashMap<String,?> getPageListByOgnzId(String ognzId, StringBuffer where, PageInfo page){
		HashMap map=new HashMap();
		StringBuffer sql=new StringBuffer();
		sql.append("select distinct  userInfo.* from BASE_USER_INFO as userInfo, BASE_OGNZ_USER ou ");
		sql.append("where userInfo.LOGIN_ID = ou.USER_ID ");
		if(ognzId != null &&!ognzId.equals("")){
			sql.append(" and ou.OGNZ_ID ='").append(ognzId).append("' ");
		}
		if(where!=null&&!where.toString().equals(""))
			sql.append(where);
		sql.append(" order by userInfo.INDEX_ORDER asc");
		SQLQuery q = this.getSession().createSQLQuery(sql.toString());
		q.addEntity(UserInfo.class);
		page.setTotalCount(q.list().size());
		q.setFirstResult((page.getPageNo() - 1)
				* page.getPageSize());
		q.setMaxResults(page.getPageSize());
		List datas = q.list();
		map.put("PAGE_INFO", page);
		map.put("DATA", datas);
		return map;
	}
	
	
	public List<UserInfo> getListByWhere(StringBuffer where){
		StringBuffer hsql=new StringBuffer();
		hsql.append(" from UserInfo as userInfo where 1=1 ");
		if(where!=null&&!where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by userInfo.index_order asc");
		return this.getHibernateTemplate().find(hsql.toString());
	}
	/**
	 * 
	 * @param where
	 * @param page
	 * @return
	 */
	
	public HashMap<String,?> getListByPageWhere(StringBuffer where,PageInfo page){
		HashMap map=new HashMap();
		StringBuffer hsql=new StringBuffer();
		hsql.append(" from UserInfo as userInfo where 1=1 ");
		if(where!=null&&!where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by userInfo.index_order asc");
		Query query =this.getSession().createQuery(hsql.toString());
		page.setTotalCount(query.list().size());
		query.setFirstResult((page.getPageNo() - 1)
				* page.getPageSize());
		query.setMaxResults(page.getPageSize());
		List datas =query.list();
		map.put("PAGE_INFO", page);
		map.put("DATA", datas);
		return map;
	}
	/**
	 * 
	 * @param where
	 * @return
	 */
	
	public int getCountByWhere(StringBuffer where){
		StringBuffer hsql=new StringBuffer();
		hsql.append("select count(*) from UserInfo as userInfo where 1=1 ");
		if(where!=null&&!where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by userInfo.index_order asc");
		Query query =this.getSession().createQuery(hsql.toString());
		return ((Long) query.uniqueResult()).intValue();
	}
	/**
	 * 根据用户登陆ID得到用户
	 * @param loginId
	 * @return
	 */
	public UserInfo getUserByLoginId(String loginId){
		List<UserInfo> list=this.getListByWhere(new StringBuffer().append(" and userInfo.login_id='"+loginId+"'"));
		if(list.size()>0) return list.get(0);
		else return null;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	public UserInfo getObjById(String id){
		List<UserInfo> list=this.getListByWhere(new StringBuffer().append(" and userInfo.login_id='"+id+"'"));
		if(list.size()>0) return list.get(0);
		else return null;
	}

	public UserInfo addObj(Object obj){
		UserInfo userInfo=(UserInfo)obj;
		if(getObjById(userInfo.getLogin_id()) != null){//已存在登录名
			return null;
		}
		String login_id=(String)this.getHibernateTemplate().save(userInfo);
		userInfo.setLogin_id(login_id);
		return userInfo;
	}
	/**
	 * 
	 * @param userInfo
	 */
	
	public void delObj(Object obj){
		this.getHibernateTemplate().delete(obj);
	}
	/**
	 * 
	 * @param id
	 */
	
	public void delObjById(String id){
		UserInfo userInfo=this.getObjById(id);
		if(userInfo!=null) this.delObj(userInfo);
	}
	/**
	 * 登陆判断
	 * @param loginId 用户账户
	 * @param password 用户密码(已加密)
	 * @return
	 */
	public UserInfo login(String loginId,String password){
		List<UserInfo> list=this.getListByWhere(new StringBuffer().append(" and userInfo.login_id='"+loginId+
				"' and userInfo.passwd='"+password+"' and userInfo.isUsed='1' "));
		if(list!=null&&list.size()==1) return list.get(0);
		return null;
	}
	
	public List leftwhere(String where){
		Query query =this.getSession().createQuery("select n from UserInfo as n "+where);

		return query.list();
	}
	
	public Map search(PageInfo page,String where){
		Map map=new HashMap();
		String sql="select us.LOGIN_ID, us.USER_NAME, us.PASSWD,us.ISUSED," +
				"us.PS,OFF_TEL" +
				",us.MOBILE,us.EMAIL,us.IMG," +
				"us.IS_DEFAULT,us.INDEX_ORDER" +
				" from BASE_USER_INFO us where 1=1 ";
		sql=sql+where+" order by us.INDEX_ORDER asc";
		SQLQuery query=getSession().createSQLQuery(sql);
		page.setTotalCount(query.list().size());
		query.setFirstResult((page.getPageNo() - 1)
				* page.getPageSize());
		query.setMaxResults(page.getPageSize());
		map.put("PAGE_INFO", page);
		query.addEntity(UserInfo.class);
		List list=query.list();
		map.put("DATA", list);
		return map;
	}
	
	/**
	 * 根据ids串得到名称串，以,分隔
	 * @param ids
	 * @return
	 */
	public String getUserNamesByIds(String ids) {
		StringBuffer where = new StringBuffer();
		if(ids != null && ids.indexOf(",") == -1){
			where.append(" and userInfo.login_id = '").append(ids).append("' ");
		}else if(ids != null){
			ids = "'"+ ids + "'";
			ids = ids.replaceAll(",", "','");
			where.append(" and userInfo.login_id in (").append(ids).append(") ");
		}
		List<UserInfo> list = this.getListByWhere(where);
		String result = "";
		for(int i=0; i<list.size(); i++){
			UserInfo user = list.get(0);
			result += user.getUser_name();
			if(i+1 < list.size())
				result += ",";
		}
		return result;
	}
	
	/**
	 * 根据ids串得到人员集合
	 * @param ids
	 * @return
	 */
	public Set<UserInfo> getObjsByIds(String ids) {
		StringBuffer where = new StringBuffer();
		if(ids != null && ids.indexOf(",") == -1){
			where.append(" and userInfo.login_id = '").append(ids).append("' ");
		}else if(ids != null){
			ids = "'"+ ids + "'";
			ids = ids.replaceAll(",", "','");
			where.append(" and userInfo.login_id in (").append(ids).append(") ");
		}
		List<UserInfo> list = this.getListByWhere(where);
		Set<UserInfo> users = new HashSet<UserInfo>();
		users.addAll(list);
		return users;
	}
	
	/**
	 * 修改密码
	 * @param loginId 登录ID
	 * @param newpassword 已加密新密码
	 */
	public void changePassWord(String loginId, String newpassword) {
		UserInfo user = this.getObjById(loginId);
		user.setPasswd(newpassword);
		this.getHibernateTemplate().update(user);
	}
	
	public Object getUserResByres(String userId, String resId) {
		UserInfo user=this.getHibernateTemplate().load(UserInfo.class, userId);
		List<RoleInfo> roleList=user.getRoles();
		List<OgnzInfo> ognzeList=user.getOgnzs();
		Set<ControlGroupInfo> groupList=roleList.get(0).getGroups();
		Iterator<ControlGroupInfo>  it=groupList.iterator();
		String result="''";
		while(it.hasNext()){
			String id=it.next().getId();
			List<GroupResRelation> list=this.getHibernateTemplate().find(" from GroupResRelation as n where n.cgi.id='"+id+"' and n.res.id='"+resId+"'  ");
			if(list.size()>0){
				String type=list.get(0).getAccessType();
				if(type.equals("3")){
					result+=",'"+userId+"'";
				}else if(type.equals("2")){
					result+=",'"+userId+"'";
					List<UserInfo> userList=this.getHibernateTemplate().find(" from UserInfo as n  left join ognzs as o where o.id='"+ognzeList.get(0).getId()+"' ");
					for(UserInfo info:userList){
						result+=",'"+info.getId()+"'";
					}
				}else{
					return null;
				}
				
				return result;
			}
		}
		return null;
	}
	
	
	
	public Object getUserResByres(String resId) {
			String result="''";
			List<GroupResRelation> list=this.getHibernateTemplate().find(" from GroupResRelation as n where  n.res.id='"+resId+"'  ");
			for(GroupResRelation gr:list){
				Iterator<RoleInfo> it=gr.getCgi().getRoles().iterator();
				while(it.hasNext()){
					RoleInfo role=it.next();
					Iterator<UserInfo> ituser=role.getUser().iterator();
					while(ituser.hasNext()){
						String id=ituser.next().getLogin_id();
						if(result.indexOf(id)<0)
							result+=",'"+id+"' ";
					}
				}
				
			}
		
		return result;
	}
	
	public List getUserByRole(String roleID) {
		RoleInfo role=this.getHibernateTemplate().load(RoleInfo.class, roleID);
		Iterator it=role.getUser().iterator();
		List result=new ArrayList();
		while(it.hasNext()){
			result.add(it.next());
		}
		return result;
	}
}
