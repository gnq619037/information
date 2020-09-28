package com.query.info.service;

import com.query.info.common.InfoResponse;
import com.query.info.common.OnLineUser;
import com.query.info.entity.User;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 14:56
 */
public interface UserService {
    /**
     * 注册
     * @param user
     * @return
     */
    public InfoResponse<User> registerUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public InfoResponse<OnLineUser> loginUser(User user);

    /**
     * 登出
     * @return
     */
    public InfoResponse<Boolean> logout();

    /**
     * 分配权限
     */
//    public InfoResponse<String> assignPermission(long userId, long permissionId);

    /**
     * 分配角色
     * @param userId
     * @param roleId
     * @return
     */
    public InfoResponse<String> assignRole(long userId, long roleId);
}
