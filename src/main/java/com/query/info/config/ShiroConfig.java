package com.query.info.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 15:52
 */
@Configuration
public class ShiroConfig {

    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher() {
        CredentialMatcher matcher = new CredentialMatcher();
        return new CredentialMatcher();
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(3);
        return hashedCredentialsMatcher;
    }

    @Bean
    public InfoShiroRealm infoShiroRealm(){
        InfoShiroRealm infoShiroRealm = new InfoShiroRealm();
        infoShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return infoShiroRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        List<Realm> realmList = new ArrayList<>();
        realmList.add(infoShiroRealm());
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealms(realmList);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/information/page","infoFormAuthenticationFilter");
//        List<ShiroUrl> shiroUrls = shiroUrlMapper.queryAllShiroUrl();
//        logger.info("*************加载scxFormAuthenticationFilter*************");
//        shiroUrls.stream().forEach(e -> {
//            if(ConstantParam.SCX_AUTH_FILTER.equals(e.getFilterType())){
//                filterChainDefinitionMap.put(e.getUrl(), e.getFilterType());
//            }
//        });
//        logger.info("*************加载anon*************");
//        shiroUrls.stream().forEach(e -> {
//            if(ConstantParam.ANON.equals(e.getFilterType())){
//                filterChainDefinitionMap.put(e.getUrl(), e.getFilterType());
//            }
//        });
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("infoFormAuthenticationFilter", shiroFormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean("infoFormAuthenticationFilter")
    public InfoFormAuthenticationFilter shiroFormAuthenticationFilter() {
        return new InfoFormAuthenticationFilter();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
