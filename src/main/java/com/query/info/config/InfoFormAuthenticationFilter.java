package com.query.info.config;

import com.alibaba.fastjson.JSONObject;
import com.query.info.common.InfoResponse;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author guonanqing
 * @date 2020/6/18 8:51
 * @version 1.0
 */
public class InfoFormAuthenticationFilter extends FormAuthenticationFilter {

    @Autowired
    private Environment environment;

    protected final Logger logger = LoggerFactory.getLogger(InfoFormAuthenticationFilter.class);

    public InfoFormAuthenticationFilter() {
        super();
    }

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        boolean allowed = super.isAccessAllowed(request, response, mappedValue);
        if(!allowed) {
            //跨域问题，前端一个接口会发送两个请求。一个OPTIONS请求，一个post/get请求，需要过滤OPTIONS
            if (((HttpServletRequest)request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }
        }
        return allowed;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        res.setStatus(401);
        PrintWriter writer = res.getWriter();
        InfoResponse<String> scxResponse = new InfoResponse<String>().code(401).message("请登录后再操作！").result(null);
        writer.write(JSONObject.toJSONString(scxResponse));
        writer.close();
        logger.debug("[-_-] [" + req.getRequestURI() + "] user unauthorized, please login");
        return false;
    }

}
