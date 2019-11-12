package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.User;

import com.jk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference(version = "1.0")
    private UserService userService;

    @RequestMapping("queryUserList")
    @ResponseBody
    public List<User> queryUserList(){

        return userService.queryUser();
    }

}
