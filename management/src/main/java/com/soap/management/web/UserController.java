package com.soap.management.web;

import com.soap.exception.BizFailException;
import com.soap.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>用户相关</p>
 *
 * @Author fenglei
 * @Date 2018/10/2
 * @Version 1.0
 **/
@Controller("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     * @throws BizFailException
     */
    @RequestMapping(value="/login")
    public String login(@RequestParam("userName") String userName,@RequestParam("password") String password) throws BizFailException{
        userService.login(userName,password);


        return "";
    }

}
