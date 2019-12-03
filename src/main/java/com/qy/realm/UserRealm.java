package com.qy.realm;

import com.qy.pojo.Users;
import com.qy.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken userPwdToken = (UsernamePasswordToken) token;
        Users user = new Users();
        user.setUsername(userPwdToken.getUsername());
//        user.setPassword(Arrays.toString(userPwdToken.getPassword()));
        System.out.println(user);
        Users login = userService.login(user);
        System.out.println(login);
        if(login==null){
            throw new UnknownAccountException();
        }
        ByteSource salt = ByteSource.Util.bytes(login.getUsername());

        return new SimpleAuthenticationInfo(login,login.getPassword(),salt,getName());
    }
}
