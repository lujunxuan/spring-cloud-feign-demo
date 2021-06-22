package com.tunyar.shopk.user.controller;

import com.tunyar.shopk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getusername")
    public String getUserName(Integer id){
        return "用户：".concat(String.valueOf(id)).concat("的名字是猿氏凯");
    }

    @GetMapping("/feign/saveuser")
    public void saveUser(){
        userService.save();
    }
}