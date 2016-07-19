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
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 表单数据 封装及 文件上传
 * @author Administrator
 *
 */
public class Upfile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * obj 需要封装的bean 只做简单处理 没处理 复选框模式数据
	 * 
	 * @param request
	 * @param obj
	 * @return
	 */
	public static Object resultvalue(HttpServletRequest request,Object obj){
		Map map=new HashMap();
		Field [] f=obj.getClass().getDeclaredFields();
		Enumeration  e=request.getParameterNames();
		while(e.hasMoreElements()){
			String fieldname=(String) e.nextElement();
			String fieldvalue=request.getParameter(fieldname);
			setobjfide(obj,fieldname,fieldvalue);
		}
		return obj;
	}
	/**
	 * 
	 * @param request
	 * @param filepath 文件路径
	 * @param obj 实体
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static Map upfile(HttpServletRequest request,String filepath,Object obj)
			throws ServletException, IOException {
		
	
		
		InputStream in=request.getInputStream();
		String filedir=request.getSession().getServletContext().getRealPath("/");
		Map <String,Object> map=new HashMap<String,Object>();
		int e=request.getContentLength();
		int s=0;
		int z=0;
		String context="";
		byte b[]=new byte[e];
		while(z>-1){
			z=in.read(b,s,e);
			s+=z;
		}
		context+=new String (b,"iso-8859-1");
		s=0;
		e=0;
		int weizhi=0;
		int bo=0;
		String str="";
		boolean bfile=false;
		String name="";
		while(bo>-1){
			s=context.indexOf("Content-Disposition");
			if(s>-1){
				weizhi+=s+19;
				context=context.substring(s+19,context.length());
				e=context.indexOf("\r\n");
				if(e>-1){
					str=context.substring(0,e);
					weizhi+=2;
					context=context.substring(e+2,context.length());
					s=str.indexOf("name=\"")+6;
					if(s>5){
						str=str.substring(s,str.length());
						e=str.indexOf("\"");
						name=str.substring(0,e);
						str=str.substring(e,str.length());
						if(str.indexOf("filename=\"")>0)bfile=true;else bfile=false;
						s=context.indexOf("\r\n\r\n")+4;
						if(s>1&&!bfile)
						{
							context=context.substring(s,context.length());
							e=context.indexOf("\r\n--")+2;
							if(e>=2){
								String fieldname=new String(name.getBytes("iso-8859-1"),"UTF-8");
								String fieldvalue=new String(context.substring(0, e-2).getBytes("iso-8859-1"),"UTF-8");
								if(map.get("fieldname")==null)
									map.put(fieldname, fieldvalue);
								else{
									map.put(fieldname, (String)map.get("fieldname")+":_:"+fieldvalue);
								}
								context=context.substring(e,context.length());
								weizhi=new String(b,"iso-8859-1").indexOf(context);
							}
						}
						if(bfile){
							String filename="";
							s=str.indexOf("filename=\"")+10;
							if(s<str.length()){
								str=str.substring(s,str.length());
								e=str.indexOf("\"");
								if(e>-1){
									str=str.substring(0,e);
									//s=str.lastIndexOf("\\");
									
									filename=str;
									s=context.indexOf("\r\n\r\n")+4;
									context=context.substring(s,context.length());
									weizhi=new String(b,"iso-8859-1").indexOf(context);
									e=context.indexOf("Content-Disposition:");
									if(e>-1)
										e=e-2;
									else
										e=context.length()-2;
									String context1=context.substring(0,e);
									weizhi=new String(b,"iso-8859-1").indexOf(context1);
									if(filename.lastIndexOf(".")>0){
										filename=new SimpleDateFormat("MMddhhmmssSS").format(new Date())+"_"+new Random().nextInt(1000)+filename.substring(filename.lastIndexOf("."), filename.length());
										String hicon=filedir+filepath+filename;
										String image=filedir+filepath+filename.replace(".", "max.");
										File file=new File(image);
										String fieldname=new String(name.getBytes("iso-8859-1"),"UTF-8");
										String fieldvalue=filepath+filename;
										if(map.get("fieldname")==null)
											map.put(fieldname, fieldvalue);
										else{
											map.put(fieldname, (String)map.get("fieldname")+":_:"+fieldvalue);
										}
										
										FileOutputStream out=new FileOutputStream(file);
										s=weizhi;
										e=weizhi+context1.length();
										out.write(b,s,e-s);
										out.flush();
										out.close();
										zoomOutImage(image,hicon);
									}
								}
							}
							
						}
					
					}
				}
			}else{
				bo=-1;
			}
		}
		Set<String> set=map.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			String fname=(String) it.next();
			setobjfide(obj,fname,(String)map.get(fname));
		}
		map.put("objinfo", obj);
		return map;
	}
	
	/** 
     * 对图片进行缩小 
     * @param srcPath 源图片路径（绝对路径） 
     * @param newPath 新图片路径（绝对路径） 
     * @param times 缩小倍数 
     * @return 保存是否成功 
     */
    public static boolean zoomOutImage(String srcPath,String newPath){ 
        BufferedImage bufferedImage = null; 
        try { 
            File of = new File(srcPath); 
            if(of.canRead()){ 
                bufferedImage =  ImageIO.read(of); 
            } 
        } catch (IOException e) { 
            //TODO: 打印日志 
            return false; 
        } 
        if(bufferedImage != null){ 
            bufferedImage = zoomOutImage(bufferedImage); 
            try { 
                //TODO: 这个保存路径需要配置下子好一点 
                ImageIO.write(bufferedImage, "JPG", new File(newPath)); //保存修改后的图像,全部保存为JPG格式 
            } catch (IOException e) { 
                // TODO 打印错误信息 
                return false; 
            } 
        } 
        return true; 
    } 
    /** 
     * 对图片进行缩小 
     * @param originalImage 原始图片 
     * @param times 缩小倍数 
     * @return 缩小后的Image 
     */
    public static BufferedImage  zoomOutImage(BufferedImage  originalImage){ 
        int width = 80; 
        int height = 80; 
        BufferedImage newImage = new BufferedImage(width,height,originalImage.getType()); 
        Graphics g = newImage.getGraphics(); 
        g.drawImage(originalImage, 0,0,width,height,null); 
        g.dispose(); 
        return newImage; 
    } 

/**
 *  基础数据封装 
 * @param obj 实体
 * @param fieldname 变量名称
 * @param fieldvalue 值
 */
private static void setobjfide(Object obj,String fieldname,String fieldvalue){
	Field [] f=obj.getClass().getDeclaredFields();
	for(int i=0;i<f.length;i++){
		if(f[i].getName().equals(fieldname)){
			try {
				Method m=obj.getClass().getMethod("set"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1), new Class []{f[i].getType()});
				if(f[i].getType().getName().equals("int"))
					m.invoke(obj, Integer.parseInt(fieldvalue));
				else if(f[i].getType().getName().equals("java.util.Date"))
					m.invoke(obj, new SimpleDateFormat("yyyy-MM-dd").parse(fieldvalue));
				else if(f[i].getType().getName().equals("java.lang.Double"))
					m.invoke(obj, Double.parseDouble(fieldvalue));
				else if(f[i].getType().getName().equals("java.lang.String"))
					m.invoke(obj, fieldvalue);
				else if(f[i].getType().getName().equals("char"))
					m.invoke(obj, fieldvalue);
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
}
}
