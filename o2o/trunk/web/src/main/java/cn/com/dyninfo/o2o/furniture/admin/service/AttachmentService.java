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

/**
 * 
 */
package cn.com.dyninfo.o2o.furniture.admin.service;

import java.util.List;

import cn.com.dyninfo.o2o.furniture.admin.model.AttachmentInfo;

/**
 * 附件类
 * @author jettang
 * Mar 28, 2011
 */
public interface AttachmentService extends IBaseService {
	
	/**
	 * 根据文档ID得到文档全部附件
	 * @param docID
	 * @return
	 */
	public List getListByDocID(String docID);
	
	/**
	 * 根据文档ID删除附件
	 * @param docID
	 */
	public void deleteByDocID(String docID);
	
	/**
	 * 根据文件存储名得到附件对象
	 * @param fileName
	 * @return
	 */
	public AttachmentInfo getAttachByFileName(String fileName);
	/**
	 * 根据文件存储名删除附件
	 * @param fileName
	 */
	public void deleteByFileName(String fileName);
	
	/**
	 * 将制定文档ID的附件更新
	 * @param docID 原文档ID
	 * @param docID_ 更新文档ID
	 */
	public void updateDocIDByDocID(String docID, String docID_);
}
