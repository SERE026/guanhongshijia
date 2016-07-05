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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import android.content.Context;
/**
 * @Description 上下拉加载数据 请求数据
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 */
public abstract class PreferenceBeanHelper {

	private PreferencesUtils preferencesUtils;
	public void init(Context context){
		preferencesUtils=PreferencesUtils.getPreferencesUtilsInstance(context);
	}
	
	public void updatePrefer(String field,Object value) throws Exception{
		Field temp=this.getClass().getDeclaredField(field);
		FieldUtil.setValueToFiled(temp,this,value.toString());
		preferencesUtils.saveOne(this,temp);
	}
	
    public void updatePreferAll()throws Exception{
    	preferencesUtils.save(this);
    
	}
    
	public void loadFromPref() throws Exception{
		preferencesUtils.getObjectFromSp(this.getClass(),this);
	}
	
    public void clearPref()throws Exception{
    	preferencesUtils.clear(this);
    	Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (!Modifier.isFinal(field.getModifiers()))
				FieldUtil.setDefValueToFiled(field,this);
        }
    }
}
