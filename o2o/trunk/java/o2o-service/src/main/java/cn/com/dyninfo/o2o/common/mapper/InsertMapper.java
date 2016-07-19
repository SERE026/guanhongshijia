/*
 *
 * Copyright (c) 2009-2011 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
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
package cn.com.dyninfo.o2o.common.mapper;


/**
 * Description：
 * 
 * 
 * 
 * @Author : Lucky Zhang
 * @Company: dyninfo.com.cn, Ltd.
 * @Date   : 2011-4-17 下午03:20:53
 * @Version: 1.0.0-SNAPSHOT
 */
public interface InsertMapper<T> {

    int insert(T domain);

    int insertSelective(T domain);
}
