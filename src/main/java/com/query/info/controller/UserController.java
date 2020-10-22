package com.query.info.controller;

import com.query.info.common.InfoResponse;
import com.query.info.common.OnLineUser;
import com.query.info.dto.UserDto;
import com.query.info.entity.User;
import com.query.info.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 16:10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public InfoResponse<OnLineUser> login(@RequestBody User user){
        return userService.loginUser(user);
    }

    @PostMapping("/register")
    public InfoResponse<User> register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("logout")
    public InfoResponse<Boolean> logout(){
        return userService.logout();
    }

//    @RequiresRoles("admin")
//    @PostMapping("/assignPermission")
//    public InfoResponse<String> assignPermission(@RequestParam("userId") long userId, @RequestParam("permissionId") long permissionId){
//        return userService.assignPermission(userId, permissionId);
//    }

    @RequiresRoles("admin")
    @PostMapping("/assignRole")
    public InfoResponse<String> assignRole(@RequestParam("userId") long userId, @RequestParam("roleId") long roleId){
        return userService.assignRole(userId, roleId);
    }

    @RequiresRoles("admin")
    @PostMapping("/list")
    public InfoResponse<List<User>> listUsers(@RequestBody UserDto userDto) {
        return userService.listUsers(userDto);
    }

    @RequiresRoles("admin")
    @PostMapping("/delete")
    public InfoResponse<String> deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }
}
