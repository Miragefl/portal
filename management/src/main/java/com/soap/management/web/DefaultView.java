package com.soap.management.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author fenglei
 * @Date 2018/10/2
 * @Version 1.0
 **/
@Controller
@RequestMapping("/")
public class DefaultView {

    @RequestMapping("/")
    public String index(){
        return "login";
    }
}
