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

package cn.com.dyninfo.o2o.furniture.sys.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;
import org.springframework.stereotype.Service;




/*
 * 
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。
 * 注意，我例子中使用的是AntUrlPathMatcher这个path matcher来检查URL是否与资源定义匹配，
 * 事实上你还要用正则的方式来匹配，或者自己实现一个matcher。
 * 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 
 * 说明：对于方法的spring注入，只能在方法和成员变量里注入，
 * 如果一个类要进行实例化的时候，不能注入对象和操作对象，
 * 所以在构造函数里不能进行操作注入的数据。
 */
@Service
public class MyInvocationSecurityMetadataSourceService  implements
		FilterInvocationSecurityMetadataSource {
	
	
	private SessionFactory sessionFactory;
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	@Autowired
	public MyInvocationSecurityMetadataSourceService(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		loadResourceDefine();
	}

/*	   private void loadResourceDefine() {
	        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
	        ConfigAttribute ca = new SecurityConfig("ROLE_ADMIN");
	        atts.add(ca);
	        resourceMap.put("/index.jsp", atts);
	        resourceMap.put("/i.jsp", atts);
	    }*/
	
	@SuppressWarnings("unchecked")
	private void loadResourceDefine() {

		Session session = sessionFactory.openSession();

		List<String> query=session.createSQLQuery("select ROLE_E_NAME from BASE_ROLE_INFO ").list();
		
		
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();

		//List<PubAuthorities> auths =session.createQuery(arg0); //pubAuthoritiesResourcesDao.findAuthAll();
//		System.out.println(query.size());
		for (String auth : query) {
			ConfigAttribute ca = new SecurityConfig(auth);// "ROLE_ADMIN"
			// atts.add(ca);
			List<String> query1=session.createSQLQuery("SELECT URL FROM BASE_RES_INFO res, BASE_RESCONTROL_RELATION res_con," +
					"BASE_ROLE_CONTROL role_con,BASE_CONTROLGROUP_INFO con,BASE_ROLE_INFO role"+
					" where res.ID=res_con.RC_ID and res_con.GROUP_ID=con.ID " +
					"and con.ID=role_con.GROUP_ID and role.ID=role_con.ROLE_ID and role.ROLE_E_NAME='"+auth+"'").list();
			for (String res : query1) {
				String url = res;
				// 判断资源文件和权限的对应关系，如果已经存在，要进行增加
				if (resourceMap.containsKey(url)) {
					Collection<ConfigAttribute> value = resourceMap.get(url);
					value.add(ca);
					resourceMap.put(url, value);
					// "log.jsp","role_user,role_admin"
				} else {
					atts.add(ca);
					resourceMap.put(url, atts);
				}
				 resourceMap.put(url, atts);
			}
		}
	}

	// According to a URL, Find out permission configuration of this URL.
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// guess object is a URL.
		String url = ((FilterInvocation) object).getRequestUrl();
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (url!=null&&resURL!=null&&urlMatcher.pathMatchesUrl(url, resURL)) {
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}



}
