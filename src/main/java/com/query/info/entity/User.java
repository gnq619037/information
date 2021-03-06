package com.query.info.entity;

import java.io.Serializable;

/**
 * @author guonanqing
 * @version 1.0
 * @desc 用户
 * @date 2020/9/28 14:33
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1411278068759389405L;
    private long id;

    private String username;

    private String password;

    private String roleCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
