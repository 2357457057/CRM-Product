package com.qy.service;

import com.qy.pojo.Users;

import java.util.List;

public interface UserService {

    Users login(Users users);



    List<Users> getAllUser();




    /**角色详情
     *
     * @param userId 用户id
     * @return user-show1.jsp
     */

    void user_show1(String userId);
}
