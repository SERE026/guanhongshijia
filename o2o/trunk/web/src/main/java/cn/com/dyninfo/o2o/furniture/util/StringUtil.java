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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	// 国标码和区位码转换常量

	static final int GB_SP_DIFF = 160;

	// 存放国标一级汉字不同读音的起始区位码

	static final int[] secPosValueList = {

	1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787,

	3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027, 4086,

	4390, 4558, 4684, 4925, 5249, 5600 };

	// 存放国标一级汉字不同读音的起始区位码对应读音

	static final char[] firstLetter = {

	'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j',

	'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',

	't', 'w', 'x', 'y', 'z' };

	// 获取一个字符串的拼音码

	public static String getFirstLetter(String oriStr) {

		String str = oriStr.toLowerCase();

		StringBuffer buffer = new StringBuffer();

		char ch;

		char[] temp;

		for (int i = 0; i < str.length(); i++) { // 依次处理str中每个字符

			ch = str.charAt(i);

			temp = new char[] { ch };

			byte[] uniCode = new String(temp).getBytes();
			if (uniCode[0] < 128 && uniCode[0] > 0) { // 非汉字

				buffer.append(temp);

			} else {

				buffer.append(convert(uniCode));

			}

		}

		return buffer.toString();

	}

	/**
	 * 获取一个汉字的拼音首字母。
	 * 
	 * GB码两个字节分别减去160，转换成10进制码组合就可以得到区位码
	 * 
	 * 例如汉字“你”的GB码是0xC4/0xE3，分别减去0xA0（160）就是0x24/0x43
	 * 
	 * 0x24转成10进制就是36，0x43是67，那么它的区位码就是3667，在对照表中读音为‘n’
	 * 
	 */

	static char convert(byte[] bytes) {

		char result = '-';

		int secPosValue = 0;

		int i;

		for (i = 0; i < bytes.length; i++) {

			bytes[i] -= GB_SP_DIFF;

		}

		secPosValue = bytes[0] * 100 + bytes[1];

		for (i = 0; i < 23; i++) {

			if (secPosValue >= secPosValueList[i]
					&& secPosValue < secPosValueList[i + 1]) {

				result = firstLetter[i];

				break;

			}

		}
		if (result == '-')
			result = 't';
		return result;

	}

	public static void main(String[] args) {

		System.out.println(StringUtil.getFirstLetter("I love u"));

		System.out.println(StringUtil.getFirstLetter("我爱北京天安门"));

		System.out.println(StringUtil.getFirstLetter("I love 北京天安门"));
	}

	public static String printObject(Object obj)  {
		 // 当前类反射方法组   
        Method[] methodGroup = obj.getClass().getMethods();   
        // 保存内容   
        StringBuffer content = new StringBuffer("[");   
        // 保存属性的getter方法组   
        List<Method> getMethodGroup = new Vector<Method>();   
           
        try {   
            // 遍历反射方法组并提取属性的getter方法   
            for (Method method : methodGroup) {   
                // 过滤与属性无关的get方法   
                if (method.getName().startsWith("get")   
                    && !method.getName().equals("getClass")) {   
                    // 保存属性的getter方法   
                    getMethodGroup.add(method);   
                }   
            }   
            // 处理仅包含属性的getter方法   
            for (int i = 0; i < getMethodGroup.size(); i++) {
            	
                // 执行get方法并拼接获取到的返回值(如果底层方法返回类型为 void，则该调用返回 null)   
            	content.append(getMethodGroup.get(i).getName());
            	content.append("=");
                content.append(getMethodGroup.get(i).invoke(obj)
                    + ((i < getMethodGroup.size() - 1) ? ",\u0020" : "]"));   
            }   
        } catch (IllegalAccessException ex) {   
            System.err.println("异常信息：参数错误，对象定义无法访问，无法反射性地创建一个实例！\r\n" + ex.getMessage());   
        } catch (IllegalArgumentException ex) {   
            System.err.println("异常信息：参数错误，向方法传递了一个不合法或不正确的参数！\r\n" + ex.getMessage());   
        } catch (InvocationTargetException ex) {   
            System.err.println("异常信息：参数错误，由调用方法或构造方法所抛出异常的经过检查的异常！\r\n" + ex.getMessage());   
        }   
        // 返回结果   
        return content.toString();   

	}
	
	/**
	 * 将字符串数组转换为以,分隔的字符串
	 * @param strs
	 * @return
	 */
	public static String getString(String[] strs){
		String str = "";
		if(strs != null){
			for(int i=0;i<strs.length;i++){
				str += strs[i];
				if(i+1<strs.length)
					str += ",";
			}
		}
			
		return str;
	}

	
	/**
	 * 生成指定位数的随机码
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length){
		Random random = new Random();
	    String randChar = "1234567890";
	    String temp="" ;
	    for(int i=0;i<length;i++)
	    {
	       temp =temp+randChar.charAt(random.nextInt(10));
	    }
		return temp;
	}
	
	public static String replaceImage(String context){
		String regEx_img="<[img]|[IMG]([^\\>]*)>";
		Pattern p_style = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);      
		Matcher m_style = p_style.matcher(context);      
		return m_style.replaceAll(""); // 过滤style标签  
	}
	
	public static String getImage(String context){
		String regImg="<[img]|[IMG](^\\>)>";
		Pattern p=Pattern.compile(regImg);
		Matcher m = p.matcher(context);
		if(m.find()){
			String img=m.group();
			img=img.substring(img.indexOf("src")+4);
			img=img.substring(0,img.indexOf("\""));
			return img;
		}
		return null;
	}
	
}
