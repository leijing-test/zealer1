package com.zealer.controller;

import com.zealer.entity.Users;
import com.zealer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Users> getAll(){
        return userService.getAllUsers();
    }

    @RequestMapping("/new")
    public ModelAndView method(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new");
        modelAndView.addObject("num",100);
        return modelAndView;
    }

    //验证用户信息
    @RequestMapping("/validate")
    @ResponseBody
    public String validate(String uname,String pwd){
        boolean b = userService.validateUser(uname,pwd);
        userService.getAllUsers();
        if (b){
            return "登录成功";
        }else {
            return "登录失败";
        }
    }
}
