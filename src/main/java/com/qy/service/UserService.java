package com.qy.service;

import com.qy.pojo.Users;

import java.util.List;

public interface UserService {

    Users login(Users users);



    List<Users> getAllUser();
}
