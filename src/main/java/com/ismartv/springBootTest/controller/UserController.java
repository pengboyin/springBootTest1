package com.ismartv.springBootTest.controller;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UserController {

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "loginPage", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(String username, String password){

        return "login";
    }
}
