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

package cn.com.dyninfo.o2o.furniture.admin.service.impl;

import cn.com.dyninfo.o2o.furniture.admin.dao.AgentGradeDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.AgentGrade;
import cn.com.dyninfo.o2o.furniture.admin.service.AgentGradeService;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dyninfo on 2016/7/6.
 */
@Service("agentGradeService")
public class AgentGradeServiceImpl implements AgentGradeService {

    @Resource
    private AgentGradeDAO agentGradeDAO;

    @Override
    public List<AgentGrade> getListByWhere(StringBuffer where) {
        return agentGradeDAO.getListByWhere(where);
    }

    @Override
    public HashMap<String, AgentGrade> getListByPageWhere(StringBuffer where, PageInfo page) {
        return agentGradeDAO.getListByPageWhere(where, page);
    }

    @Override
    public Object getNextObj(Object obj) {
        return null;
    }

    @Override
    public Object getPreviousObj(Object obj) {
        return null;
    }

    @Override
    public int getCountByWhere(StringBuffer where) {
        return agentGradeDAO.getCountByWhere(where);
    }

    @Override
    public Object getObjById(String id) {
        return agentGradeDAO.getObjById(id);
    }

    @Override
    public Object addObj(Object obj) {
        return agentGradeDAO.addObj(obj);
    }

    @Override
    public String updateObj(Object obj) {
        String result="";
        try{
            AgentGrade agentGrade=(AgentGrade)obj;
            agentGradeDAO.updateObj(agentGrade);
            result=agentGrade.getName();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String delObj(Object obj) {
        agentGradeDAO.delObj(obj);
        return "0";
    }

    @Override
    public String delObjById(String id) {
        agentGradeDAO.delObjById(id);
        return "0";
    }

    @Override
    public String del(List<Object> objList) {
        String result="";
        try{
            for(Object obj:objList){
                agentGradeDAO.delObj(obj);
            }
            result="0";
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delObjStatus(Object obj) {

    }

    @Override
    public void delObjStatusById(String id) {

    }

    @Override
    public void delStatus(List<Object> objList) {

    }
}
