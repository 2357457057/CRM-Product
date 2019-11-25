package com.qy.mapper;


import com.qy.pojo.Users;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author 轻语
 */
@Component
public interface UserMapper extends Mapper<Users> {
//    /**
//     * 用户登录
//     * @return User
//     */
//    User login(User user);
}
