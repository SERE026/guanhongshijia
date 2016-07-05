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

package cn.com.dyninfo.o2o.furniture.web.framework.plugin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.goods.widget.IGoodsWidget;

@Component
public class PluginLoader implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		if(arg0 instanceof AbstractPlugin){
			AbstractPlugin plugin=(AbstractPlugin) arg0;
			if(plugin.plugins!=null){
				for(AbstractPlugin p:plugin.plugins){
					p.addPlugin(plugin);
					System.out.println("将"+plugin.getName()+"注入到"+p.getName());
				}
			}
		}
		if(arg0 instanceof IGoodsWidget){
			IGoodsWidget widget=(IGoodsWidget) arg0;
			if(widget.getList()!=null){
				for(IGoodsWidget w:widget.getList()){
					w.addWidget(widget);
				}
			}
		}
		
		return arg0;
	}

}
