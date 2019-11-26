package com.qy.controller;

import com.qy.pojo.Users;
import com.qy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView login(Users users){
        Users loginUsers = userService.login(users);
        ModelAndView mv = new ModelAndView("main");
        if(loginUsers != null){
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
}
