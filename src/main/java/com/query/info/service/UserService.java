package com.query.info.service;

import com.query.info.common.InfoResponse;
import com.query.info.common.OnLineUser;
import com.query.info.dto.InformationDto;
import com.query.info.dto.UserDto;
import com.query.info.entity.User;

import java.util.List;

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
     * 分配角色
     * @param userId
     * @param roleId
     * @return
     */
    public InfoResponse<String> assignRole(long userId, long roleId);


    public InfoResponse<List<User>> listUsers(UserDto userDto);

    public InfoResponse<String> deleteUser(User user);
}
