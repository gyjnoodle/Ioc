package com.gyj.ioc.controller;

import com.gyj.ioc.annotations.MyAutowired;
import com.gyj.ioc.service.UserService;

public class UserController {
    @MyAutowired
    private UserService userService;

    public static void main(String[] args) {
        //System.out.println(getUserService.findById(1));
    }
    public UserService getUserService() {
        return userService;
    }

}
