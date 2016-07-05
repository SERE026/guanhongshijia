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

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class Logistics {
	
	/**
     * 快递查询接口方法
     * 
     * @param com
     *            ：快递公司代码，在http://www.kuaidi100.com/openapi网上的技术文档里可以查询到
     * @param nu
     *            ：快递单号，请勿带特殊符号，不支持中文（大小写不敏感）
     * @return 快递100返回的url，然后放入页面iframe标签的src即可
     * @see
     */
    public static String searchkuaiDiInfo(String com, String nu)
    {
    	
        String content = "";
        try
        {
        	
        	URL url = new URL("http://www.kuaidi100.com/applyurl?key=aafff22c02487e39&com=" + com+ "&nu=" + nu);
            URLConnection con = url.openConnection();
            con.setAllowUserInteraction(false);
            InputStream urlStream = url.openStream();
            byte b[] = new byte[10000];
            int numRead = urlStream.read(b);
            content = new String(b, 0, numRead);
            while (numRead != -1)
            {
                numRead = urlStream.read(b);
                if (numRead != -1)
                {
                    String newContent = new String(b, 0, numRead);
                    content += newContent;
                }
            }
            urlStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return content;
    }
    public static List getWuliu(String com, String nu)
    {
    	List result=new ArrayList();
        String content = "";
        try
        {
        	String newUlr="http://www.kuaidi100.com/query?id=1&type="+com+"&postid="+nu+"&valicode=&temp=0.676531599978329";
        	System.out.print("newUlr======="+newUlr);
        	URL url = new URL(newUlr);
            URLConnection con = url.openConnection();
            con.setAllowUserInteraction(false);
            InputStream urlStream = url.openStream();
            byte b[] = new byte[10000];
            int numRead = urlStream.read(b);
            content = new String(b, 0, numRead,"UTF-8");
           // System.out.println("----------------"+content);
            JSONObject person1 = JSONObject.fromObject(content.toString());
            JSONArray list= (JSONArray) person1.get("data");
            for(int i=0;i<list.size();i++){
            	Map map=new HashMap();
            	JSONObject j=(JSONObject) list.get(i);
            	map.put("time", j.getString("time"));
            	map.put("context", j.getString("context"));
            	result.add(map);
            }
            urlStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    
}
