package com.soap.site.web;

import com.soap.site.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author fenglei
 * @Date 2018/10/13
 * @Version 1.0
 **/
@Controller
@RequestMapping("/contact")
public class ContactController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ContactService contactService;

    @RequestMapping("/record")
    @ResponseBody
    public String record(@RequestParam(value = "username") String username, @RequestParam(value = "email") String email, @RequestParam(value = "content") String content) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        params.put("email", email);
        params.put("content", content);
        logger.info("username:{},email:{},content:{}",username,email,content);
        contactService.insert(params);
        return params.toString();
    }

}
