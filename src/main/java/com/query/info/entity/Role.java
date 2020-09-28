package com.query.info.entity;

import java.io.Serializable;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 16:01
 */
public class Role implements Serializable {

    private Long id;

    private String roleCode;

    private String roleDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
