package com.qy.service.impl;

import com.qy.mapper.UserMapper;
import com.qy.pojo.Users;
import com.qy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Users login(Users users) {
        return userMapper.selectOne(users);
    }
}
