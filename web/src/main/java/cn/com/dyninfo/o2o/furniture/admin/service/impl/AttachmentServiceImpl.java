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
package cn.com.dyninfo.o2o.furniture.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import cn.com.dyninfo.o2o.furniture.admin.service.AttachmentService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.admin.dao.AttachmentDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.AttachmentInfo;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

/**
 * @author jettang
 * Mar 28, 2011
 */
@Scope("prototype")
@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService {
	
	@Resource
	private AttachmentDAO attachmentDAO;

	
	public void deleteByDocID(String docID) {
		attachmentDAO.deleteByDocID(docID);
	}

	
	public void deleteByFileName(String fileName) {
		attachmentDAO.deleteByFileName(fileName);
	}

	
	public List getListByDocID(String docID) {
		return attachmentDAO.getObjsByDocID(docID);
	}

	
	public Object addObj(Object obj) {
		return attachmentDAO.addObj(obj);
	}

	
	public String del(List<Object> objList) {
		String result="";
		try{
			for(Object obj:objList){
				attachmentDAO.delObj(obj);
			}
			result="0";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	public String delObj(Object obj) {
		attachmentDAO.delObj(obj);
		return "0";
	}

	
	public String delObjById(String id) {
		attachmentDAO.delObjById(id);
		return "0";
	}

	
	public int getCountByWhere(StringBuffer where) {
		return attachmentDAO.getCountByWhere(where);
	}

	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		return attachmentDAO.getListByPageWhere(where, page);
	}

	
	public List<?> getListByWhere(StringBuffer where) {
		return attachmentDAO.getListByWhere(where);
	}

	
	public Object getNextObj(Object obj) {
		return attachmentDAO.getNextObj(obj);
	}

	
	public Object getObjById(String id) {
		return attachmentDAO.getObjById(id);
	}

	
	public Object getPreviousObj(Object obj) {
		return attachmentDAO.getPreviousObj(obj);
	}

	
	public String updateObj(Object obj) {
		AttachmentInfo attach = (AttachmentInfo)obj;
		attachmentDAO.updateObj(attach);
		return attach.getId();
	}
	
	/**
	 * 根据文件名得到附件
	 */
	
	public AttachmentInfo getAttachByFileName(String fileName) {
		List list = attachmentDAO.getListByWhere(new StringBuffer(" and attachment.fileName = '").append(fileName).append("' "));
		if(list != null && list.size() == 1){
			return (AttachmentInfo)list.get(0);
		}
		return null;
	}
	
	/**
	 * 将制定文档ID的附件更新
	 * @param docID 原文档ID
	 * @param docID_ 更新文档ID
	 */
	
	public void updateDocIDByDocID(String docID, String docID_) {
		List<AttachmentInfo> list = this.getListByDocID(docID);
		for(AttachmentInfo a : list){
			a.setDocID(docID_);
			this.updateObj(a);
		}
	}

	public void delObjStatus(Object obj) {
		// TODO Auto-generated method stub
		
	}

	public void delObjStatusById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void delStatus(List<Object> objList) {
		// TODO Auto-generated method stub
		
	}

}
