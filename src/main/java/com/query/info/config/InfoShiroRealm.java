package com.query.info.config;

import com.query.info.dao.UserMapper;
import com.query.info.entity.Permission;
import com.query.info.entity.Role;
import com.query.info.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 15:55
 */
public class InfoShiroRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(InfoShiroRealm.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("【InfoShiroRealm-doGetAuthorizationInfo】");
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = userMapper.getUserByName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Role role = userMapper.selectRoleByUser(user);
        if(role != null) {
            Set<String> roleCodes = new HashSet<>();
            roleCodes.add(role.getRoleCode());
            simpleAuthorizationInfo.setRoles(roleCodes);
            List<Permission> permissions = userMapper.queryPermissionByRole(role);
            Set<String> permissionCodes = new HashSet<>(permissions.size());
            for(Permission permission : permissions) {
                permissionCodes.add(permission.getPerCode());
            }
            simpleAuthorizationInfo.setStringPermissions(permissionCodes);
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("【InfoShiroRealm-doGetAuthenticationInfo】");
        UsernamePasswordToken token = null;
        if(authenticationToken instanceof UsernamePasswordToken){
            token = (UsernamePasswordToken) authenticationToken;
        }else{
            return null;
        }
        String loginFlag = token.getUsername();
        User user = userMapper.getUserByName(loginFlag);
        if(user  == null) {
            return null;
        } else {
            //加盐
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(loginFlag,
                    user.getPassword().toString(), getName());
            simpleAuthenticationInfo.setCredentialsSalt(credentialsSalt);
            return simpleAuthenticationInfo;
        }
    }
}
