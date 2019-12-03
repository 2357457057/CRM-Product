package com.qy.service.impl;

import com.qy.mapper.*;
import com.qy.pojo.*;
import com.qy.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRowMapper userRowMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePerssionMapper rolePerssionMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Users login(Users users) {
        return userMapper.selectOne(users);
    }

    @Override
    public List<Users> getAllUser() {
        return userMapper.selectAll();
    }

    /**
     * 角色详情
     *
     * @param userId 用户id
     * @return user-show1.jsp
     */
    @Override
    public void user_show1(String userId) {
        UsersRole usersRole = new UsersRole();
        usersRole.setUserId(userId);
//        Example example = new Example();
//        userRowMapper.selectOneByExample();

        // 获取Role list
        List<Role> roleList=null;
        Users users = new Users();



        List<UsersRole> usersRoleList = userRowMapper.select(usersRole);


        for (UsersRole role : usersRoleList) {

            System.out.println(role);
            System.out.println("---------------------------------------------------------------------------------");
            String roleId = role.getRoleId();
            Role role_ = new Role();
            role_.setId(roleId);
                roleList = roleMapper.select(role_);

            for (Role role1 : roleList) {
                System.out.println(role1);
                System.out.println("---------------------------------------------------------------------------------");
                List<Permission> permissionList = null;
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(roleId);

                List<RolePermission> rolePermissionList = rolePerssionMapper.select(rolePermission);

                for (RolePermission rolePermission_ : rolePermissionList) {
                    System.out.println(rolePermission_);
                    System.out.println("---------------------------------------------------------------------------------");
                    String permissionId = rolePermission_.getPermissionId();
                    Permission permission = new Permission();
                    permission.setId(permissionId);
                    permissionList = permissionMapper.select(permission);
                }
                role1.setPermissions(permissionList);
            }
            System.out.println(roleList);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        }
            users.setRoles(roleList);


        System.out.println(users);

    }
}
