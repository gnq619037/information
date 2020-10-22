package com.query.info.dao;

import com.query.info.dto.UserDto;
import com.query.info.entity.Permission;
import com.query.info.entity.Role;
import com.query.info.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 14:43
 */
@Mapper
public interface UserMapper {

    /**
     * 新增
     * @param user
     * @return
     */
    @Insert("insert into t_user (username, password, role_code) values (#{username, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, #{roleCode, jdbcType=VARCHAR})")
    public long insertUser(User user);

    /**
     * 修改
     * @param user
     * @return
     */
    @Update("update t_user set password = #{password, jdbcType=VARCHAR}")
    public long updateUser(User user);

    @Delete("delete from t_user where id = #{id}")
    public int deleteUserById(long id);

    /**
     * 查询
     * @return
     */
    @Select("select id, username, password, role_code as roleCode from t_user where username = #{username, jdbcType=VARCHAR}")
    public User getUserByName(String username);

    @Select("select id, username, password, role_code as roleCode from t_user where id = #{id}")
    public User getUserById(long id);

//    @Select("select r.id, r.role_code, r.role_desc from t_user_role ur inner join t_role r on ur.role_id = r.id where ur.user_id = #{id}")
//    public List<Role> queryUserRoles(User user);

    @Select("select r.id, r.role_code, r.role_desc from t_user_role ur inner join t_role r on ur.role_id = r.id where ur.user_id = #{id}")
    public Role selectRoleByUser(User user);

    @Select("select p.id, p.per_code as perCode, p.per_desc as perDesc from t_role_permission rp " +
            "inner join t_permission p on rp.per_code = p.per_code where rp.role_code = #{roleCode}")
    public List<Permission> queryPermissionByRole(Role role);
//    /**
//     * 查找某个用户对应的操作权限
//     * @param user
//     * @return
//     */
//    @Select("select p.id, p.per_code as perCode, p.per_desc as perDesc from t_user_permission up " +
//            "inner join t_permission p on up.permission_id = p.id where up.user_id = #{id} ")
//    public List<Permission> queryUserPermissions(User user);

//    @Insert("insert into t_user_permission (user_id, permission_id) values (#{userId}, #{permissionId})")
//    public int insertUserPermission(long userId, long permissionId);

    @Insert("insert into t_user_role (user_id, role_id) values (#{userId}, #{roleId})")
    public int insertUserRole(long userId, long roleId);

    public List<User> queryUsers(UserDto userDto);
}
