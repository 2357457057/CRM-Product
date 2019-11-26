package com.qy.service.impl;

import com.qy.mapper.UserMapper;
import com.qy.pojo.Users;
import com.qy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Users login(Users users) {
        return userMapper.selectOne(users);
    }

    @Override
    public List<Users> getAllUser() {
        return userMapper.selectAll();
    }
}
