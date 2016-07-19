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

/**
 * @author jettang
 * May 22, 2010
 * 
 */
package cn.com.dyninfo.o2o.furniture.util;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * @author jettang
 * May 22, 2010
 */
public class MD5Encoder {

	/**
	 * 密码加密
	 * @param password 原密码字符
	 * @param salt 盐值
	 * @return
	 * @throws DataAccessException
	 */
	public static String encodePassword(String password, Object salt)
			throws DataAccessException {
		return new Md5PasswordEncoder().encodePassword(password, salt);
	}

	/**
	 * 判断密码是否正确
	 * @param encPass 已加密密码
	 * @param rawPass 原密码字符
	 * @param salt 盐值
	 * @return
	 * @throws DataAccessException
	 */
	public static boolean isPasswordValid(String encPass, String rawPass, Object salt)
			throws DataAccessException {
		return new Md5PasswordEncoder().isPasswordValid(encPass, rawPass, salt);
	}
	
	/**
	 * admin/ceb4f32325eda6142bd65215f4c0f371
	 * @param args
	 * s+s_h_uh
	 */
	public static void main(String[] args){
		MD5Encoder md5encoder=new MD5Encoder();
		System.out.println(md5encoder.encodePassword("123123","s+s_h_u"));
		System.out.println(md5encoder.isPasswordValid(md5encoder.encodePassword("123123","s+s_h_u"),"123123", "s+s_h_u"));
		System.exit(0);
	}
}
