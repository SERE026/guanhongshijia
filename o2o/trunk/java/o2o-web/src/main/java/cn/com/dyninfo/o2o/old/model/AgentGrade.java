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

package cn.com.dyninfo.o2o.old.model;

import org.hibernate.annotations.AccessType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dyninfo on 2016/7/6.
 */
@Entity
@Table(name="T_AGENT_GRADE")
public class AgentGrade implements Serializable {

    private static final long serialVersionUID = 1940817520008594611L;

    @Id
    @AccessType(value = "property")
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @AccessType(value = "property")
    @Column(name="NAME", length = 50)
    private String name;//代理商级别名称

    @AccessType(value = "property")
    @Column(name="RATE")
    private int rate;//代理商佣金比率

    @AccessType(value = "property")
    @Column(name="DESCRIPTION")
    private String description;//备注

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRateCent() {
        return rate / 100d;
    }
}
