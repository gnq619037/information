package com.query.info.service.impl;

import com.query.info.common.InfoResponse;
import com.query.info.common.OnLineUser;
import com.query.info.dao.UserMapper;
import com.query.info.entity.User;
import com.query.info.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 15:18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //加盐次数
    private static int saltNum = 3;

    @Override
    public InfoResponse<User> registerUser(User user) {
        String md5Password = new Md5Hash(user.getPassword(), user.getUsername(), saltNum).toString();
        user.setPassword(md5Password);
        long i = userMapper.insertUser(user);
        return new InfoResponse<User>().code(0).result(user);
    }

    @Override
    public InfoResponse<OnLineUser> loginUser(User user) {
        OnLineUser onLineUser = new OnLineUser();
        onLineUser.setUsername(user.getUsername());
        User userData = userMapper.getUserByName(user.getUsername());
        onLineUser.setId(userData.getId());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userData.getUsername(), user.getPassword());
        subject.login(usernamePasswordToken);
        Session session = subject.getSession();
        session.setAttribute("user", userData);
        onLineUser.setToken(session.getId().toString());
        return new InfoResponse<OnLineUser>().code(0).result(onLineUser);
    }

    @Override
    public InfoResponse<Boolean> logout() {
        SecurityUtils.getSubject().logout();
        return new InfoResponse<Boolean>().code(0).message("用户退出").result(true);
    }

//    @Override
//    public InfoResponse<String> assignPermission(long userId, long permissionId) {
//        int i = userMapper.insertUserPermission(userId, permissionId);
//        return new InfoResponse<String>().code(i==1 ? 0 : 1).message("");
//    }

    @Override
    public InfoResponse<String> assignRole(long userId, long roleId) {
        int i = userMapper.insertUserRole(userId, roleId);
        return new InfoResponse<String>().code(i==1 ? 0 : 1).message("");
    }
}
