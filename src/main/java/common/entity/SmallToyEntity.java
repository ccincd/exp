/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package common.entity;

import common.base.PrintableBean;

import java.util.Date;

/**
 * @author chichen  Date: 16-4-11 Time: 上午10:35
 */
public class SmallToyEntity extends PrintableBean {

    /**
     * 自增id
     */
    private int id;

    /**
     * 玩具名称
     */
    private String name;

    /**
     * 供应商id
     */
    private int providerId;

    /**
     * 上次拜访时间
     */
    private Date lastVisitTime;

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

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }
}
