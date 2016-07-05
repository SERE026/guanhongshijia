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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * android 端上传图片测试
 * 
 * @author ceychen@foxmail.com
 */
public class UploadImage extends HttpServlet {

	private String uploadPath = "d:/status/upload/"; // 上传目录
	private String tempPath = "d:/status/upload/"; // 临时目录
	File tempFile;

	public void init() throws ServletException {
		File uploadFile = new File(uploadPath);
		if (!uploadFile.exists()) {
			uploadFile.mkdirs();
		}
		File tempPathFile = new File(tempPath);
		if (!tempPathFile.exists()) {
			tempPathFile.mkdirs();
		}
	}

	/**
	 * @author ceychen@foxmail.com
	 * @date 2014-6-15 14:26:09
	 * @update 2014-6-15 16:47:04
	 */
	public void  doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if (ServletFileUpload.isMultipartContent(request))
			try {
				System.out.println("图片开始上传");
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(4096); // 设置缓冲区大小
				factory.setRepository(tempFile);// 缓冲路径
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(10 * 1024 * 1024); // 最大 10M（每单中一件宝贝可以上传4张图片，1订单可以包含N件宝贝）
				List<FileItem> files = upload.parseRequest(request);// 得到所有文件
				System.out.println("包含参数数量：" + files.size());
				Iterator<FileItem> iterator = files.iterator();
				String fileName1 ="";
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					String fileName = item.getName();
					if (fileName != null) {
						// 文件名：客户端有处理，格式是：pic_时间戳.png，这里保存需要重新命名
						fileName = fileName;
						System.out.println("正在将图片保存到：" + uploadPath + fileName);
						fileName1=fileName;
						File save = new File(uploadPath, fileName);
						item.write(save);
					}
				}
				// TODO 这里操作保存到数据库并把图片地址返回给我
				out.print("{\"status\": 0,\"fileName\": \""+fileName1+"\"}");
			} catch (Exception e) {
				out.print("{\"status\": 0}");
				e.printStackTrace();
			}
		else
			out.print("{\"status\": 0}");
		out.flush();
		out.close();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("this method (get) is gone");
		out.flush();
		out.close();

		doPost(request, response);
	}

	private static final long serialVersionUID = 1L;

	public UploadImage() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
}
