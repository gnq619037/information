package com.query.info.service.impl;

import com.query.info.common.InfoResponse;
import com.query.info.common.OnLineUser;
import com.query.info.dao.UserMapper;
import com.query.info.dto.InformationDto;
import com.query.info.dto.UserDto;
import com.query.info.entity.Information;
import com.query.info.entity.User;
import com.query.info.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
        //注册的为普通用户
        user.setRoleCode("user");
        long i = userMapper.insertUser(user);
        return new InfoResponse<User>().code(0).result(user);
    }

    @Override
    public InfoResponse<OnLineUser> loginUser(User user) {
        OnLineUser onLineUser = new OnLineUser();
        onLineUser.setUsername(user.getUsername());
        User userData = userMapper.getUserByName(user.getUsername());
        if(userData == null) {
            return new InfoResponse<OnLineUser>().code(1).result(null).message("账号不存在");
        }
        onLineUser.setId(userData.getId());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userData.getUsername(), user.getPassword());
        subject.login(usernamePasswordToken);
        Session session = subject.getSession();
        session.setAttribute("user", onLineUser);
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

    @Override
    public InfoResponse<List<User>> listUsers(UserDto userDto) {
        List<User> users = userMapper.queryUsers(userDto);
        return new InfoResponse<List<User>>().code(0).result(users);
    }

    @Override
    public InfoResponse<String> deleteUser(User user) {
//        Subject subject = SecurityUtils.getSubject();
//        OnLineUser onLineUser = (OnLineUser) subject.getSession().getAttribute("user");
        User userDate = userMapper.getUserById(user.getId());
        if(userDate != null && "admin".equals(userDate.getRoleCode())) {
            return new InfoResponse<String>().code(1).message("不能删除管理员");
        }
        int i = userMapper.deleteUserById(user.getId());
        return new InfoResponse<String>().code(i == 1 ? 0 : 1).message("");
    }
}
