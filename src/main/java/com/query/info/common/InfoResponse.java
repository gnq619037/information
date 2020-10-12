package com.query.info.common;

import java.io.Serializable;

/**
 * @author guonanqing
 * @version 1.0
 * @desc 响应封装实体
 * @date 2020/9/28 14:57
 */
public class InfoResponse<T> implements Serializable {
    private int code;
    private String message;
    private T result;

    public InfoResponse(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public InfoResponse<T> code(int code){
        this.code = code;
        return this;
    }

    public InfoResponse<T> message(String message){
        this.message = message;
        return this;
    }

    public InfoResponse<T> result(T result){
        this.result = result;
        return this;
    }
}
