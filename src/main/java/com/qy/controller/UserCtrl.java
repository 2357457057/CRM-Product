package com.qy.controller;

import com.qy.pojo.Users;
import com.qy.service.UserService;
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
        Users loginUsers = userService.login(users);
        ModelAndView mv = new ModelAndView("main");
        if(loginUsers != null){
            session.setAttribute("user",loginUsers);
            return mv;
        }
        mv.setViewName("login");
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
