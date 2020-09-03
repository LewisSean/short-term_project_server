package com.seu.film.controller;

import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User;
import com.seu.film.pojo.User_tab;
import com.seu.film.service.UserService;
import com.seu.film.service.User_tabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test1")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    User_tabService user_tabService;

    //http://localhost:8090/film/test1.html
    @RequestMapping("/login")      //只能响应post请求，get请求不可以
    @ResponseBody
    public ResultDTO<User> login(@RequestBody User user) throws Exception{
        System.out.println(user.toString());
        return userService.login(user);                                    //跳转到index页面
    }

    @RequestMapping("/findUserInfo")
    @ResponseBody
    public ResultDTO<User> findUserInfo(@RequestBody User user)throws Exception{
        System.out.println(user.toString());
        return userService.findUserInfo(user);
    }

    @RequestMapping("/addUserInfo")
    @ResponseBody
    public ResultDTO<User> addUserInfo(@RequestBody User user)throws Exception{
        System.out.println(user.toString());
        return userService.addUserInfo(user);
    }

    @RequestMapping("/modifyUserInfo")
    @ResponseBody
    public ResultDTO<User> modifyUserInfo(@RequestBody User user)throws Exception{
        System.out.println(user.toString());
        return userService.modifyUserInfo(user);
    }

    @RequestMapping("/findUser_tab")
    @ResponseBody
    public ResultDTO<User_tab> findUser_tab(@RequestBody User_tab user_tab)throws Exception{
        System.out.println(user_tab.toString());
        return user_tabService.findUser_tab(user_tab);
    }

    @RequestMapping("/modifyUser_tab")
    @ResponseBody
    public ResultDTO<User_tab> modifyUser_tab(@RequestBody User_tab user_tab)throws Exception{
        System.out.println(user_tab.toString());
        return user_tabService.modifyUser_tab(user_tab);
    }
}
