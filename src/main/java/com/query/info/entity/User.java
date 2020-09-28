package com.query.info.entity;

import java.io.Serializable;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 14:33
 */
public class User implements Serializable {

    private long id;

    private String username;

    private String password;

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
}
