package com.query.info.common;

import java.io.Serializable;

/**
 * @author guonanqing
 * @version 1.0
 * @desc 用户session实体
 * @date 2020/9/28 16:17
 */
public class OnLineUser implements Serializable {

    private Long id;
    private String token;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
