/*
 *
 * Copyright (c) 2009-2014 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
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
package cn.com.dyninfo.o2o.furniture.sys.service;



/**
 * Description：
 * 
 * 
 * 
 * @Author : abel.lin
 * @Date   : 2014年12月30日 下午2:52:09
 * @Version: 1.0.0-SNAPSHOT
 */
public interface SmsSender {
	public boolean sendSms(String to, String content);
    public boolean sendSmsWithTemplate(String to, String smsType, String[] params);
}
