package com.qy.controller;

import com.qy.pojo.Users;
import com.qy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 轻语
 */


@Controller
public class UserCtrl {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public ModelAndView login(Users users,HttpSession session){

        ModelAndView mv = new ModelAndView();


        Subject currentUser = SecurityUtils.getSubject();
        String info=null;

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getPassword());
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                info="用户名出错";
            } catch (IncorrectCredentialsException ice) {
                info="密码错误";
            } catch (LockedAccountException lae) {
                info="账号锁定";
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                info="联系管理员";
            }
        }
        if(info==null){
            mv.setViewName("main");
        }else {
            mv.setViewName("login");
            mv.addObject("info",info);
        }
        return mv;
    }


    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout.do")
    public ModelAndView loginOut(HttpSession session){
        session.invalidate();

        return new ModelAndView("login");
    }
    @ResponseBody
    @RequestMapping("/getAllUser")
    public List<Users> getAllUser(){
        return userService.getAllUser();
    }

    /**角色详情
     *
     * @param userId 用户id
     * @return user-show1.jsp
     */
    @RequestMapping("/user-show1/{userId}")
    public ModelAndView user_show1(@PathVariable String userId){

        return new ModelAndView();
    }
}
