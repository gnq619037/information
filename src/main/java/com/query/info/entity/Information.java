package com.query.info.entity;

import java.io.Serializable;

/**
 * @author guonanqing
 * @version 1.0
 * @desc 用户信息
 * @date 2020/9/28 14:33
 */
public class Information implements Serializable {
    private long id;

    private String costBatch;
    private String expertCode;
    private String expertName;
    private String sex;
    private String birthDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCostBatch() {
        return costBatch;
    }

    public void setCostBatch(String costBatch) {
        this.costBatch = costBatch;
    }

    public String getExpertCode() {
        return expertCode;
    }

    public void setExpertCode(String expertCode) {
        this.expertCode = expertCode;
    }
}
