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

package cn.com.dyninfo.o2o.furniture.admin.service;

public interface SendMessageService extends IBaseService {

	/**
	 * 添加发送信息
	 * @param flag 发送类型 0短信 1邮件 
	 * @param msg 发送内容
	 * @param revcName 接收人如果是短信 则为手机号码 如果是邮件 则为邮箱地址
	 * @param revcInfo  接收人信息，对接收人的描述
	 * @param title 消息主题
	 */
	public void addData(String flag,String msg,String revcName,String revcInfo,String title);
	
	/**
	 * 更新发送信息状态
	 * @param id
	 */
	public void updateMsgStatus(int id);
	/**
	 * 发送消息
	 */
	public void sendMessage();
}
