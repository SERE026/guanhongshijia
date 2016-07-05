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

package cn.com.dyninfo.o2o.furniture.web.framework.facade.widget;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * ����Ҽ� ����
 * @author Administrator
 *
 */
public class WidgetXmlUtil {

	public static Map parsePage(String filePath){
		File f=new File(filePath);
		Map map=new HashMap();
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList pageList = doc.getElementsByTagName("page");
			for(int i=0;i<pageList.getLength();i++){
				Node page=pageList.item(i);
				String id=page.getAttributes().getNamedItem("id").getTextContent();
				Map widgetMap=parseWidget(page.getChildNodes());
				map.put(id, widgetMap);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	public static Map parseWidget(NodeList widgetList){
		Map map=new HashMap();
		try{
			for(int i=0;i<widgetList.getLength();i++){
				Node widget=widgetList.item(i);
				if(widget.getNodeName().equals("widget")){
					String id=widget.getAttributes().getNamedItem("id").getTextContent();
					Map attrMap=parseAttribute(widget.getChildNodes());
					map.put(id, attrMap);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	public static Map parseAttribute(NodeList abtList){
		Map map=new HashMap();
		try{
			for(int i=0;i<abtList.getLength();i++){
				Node abt=abtList.item(i);
				if(abt.getNodeType()==1){
					map.put(abt.getNodeName(), abt.getTextContent());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	public static void main(String args[]){
		WidgetXmlUtil.parsePage("F:\\SSSS.XML");
	}
}
