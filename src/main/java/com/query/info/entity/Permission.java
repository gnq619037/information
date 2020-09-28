package com.query.info.entity;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 16:02
 */
public class Permission {
    private Long id;
    private String perCode;
    private String perDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }

    public String getPerDesc() {
        return perDesc;
    }

    public void setPerDesc(String perDesc) {
        this.perDesc = perDesc;
    }
}
