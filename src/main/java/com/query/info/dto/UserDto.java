package com.query.info.dto;

import java.io.Serializable;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/10/13 16:26
 */
public class UserDto implements Serializable{

    private static final long serialVersionUID = -6696341133016109289L;
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
