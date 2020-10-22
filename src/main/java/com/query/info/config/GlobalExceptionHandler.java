package com.query.info.config;

import com.query.info.common.InfoResponse;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/10/15 17:45
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理运行时异常
     * @return
     */
    //jdk中自带的日志api
//    private Logger log=Logger.getLogger(GlobalExceptionHandler.class.getName());
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public InfoResponse<String> doHandleRuntimeException(RuntimeException e){
        /**
         * 封装异常信息
         */
        //e.printStackTrace();
//        log.info(e.getMessage());
        return new InfoResponse<String>().message(e.getMessage());
    }
    @ExceptionHandler(ShiroException.class)
    @ResponseBody
    public InfoResponse<String> doHandleShiroException(ShiroException e){
        InfoResponse result=new InfoResponse();
        result.setCode(1);
        if(e instanceof IncorrectCredentialsException){
            result.setMessage("密码不正确");
        } else if(e instanceof UnknownAccountException){
            result.setMessage("此账户不存在");
        } else if(e instanceof LockedAccountException){
            result.setMessage("账户已被禁用");
        } else if(e instanceof AuthorizationException) {
            result.setCode(3);
            result.setMessage("无对应操作权限");
        }
        return result;
    }
}
