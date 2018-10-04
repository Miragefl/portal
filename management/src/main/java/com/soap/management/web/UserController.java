package com.soap.management.web;

import com.soap.exception.BizFailException;
import com.soap.management.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>用户相关</p>
 *
 * @Author fenglei
 * @Date 2018/10/2
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    private static final String page_login = "login";
    private static final String page_management = "index";


    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @return
     * @throws BizFailException
     */
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "password", required = false) String password, HttpSession session, Model model) {
        try {
            if (!StringUtils.isBlank(userName) && !StringUtils.isBlank(password) && session.getAttribute("manage_session_user_info") == null) {
                Map<String, Object> user = userService.login(userName, password);
                session.setAttribute("manage_session_user_info", user);
            }
            if (session.getAttribute("manage_session_user_info") != null) {
                model.addAttribute("user",session.getAttribute("manage_session_user_info"));
                System.out.println("=================="+session.getAttribute("manage_session_user_info"));
                return page_management;
            }

            return page_login;
        } catch (Exception e) {
            return page_login;
        }
    }

    @RequestMapping(value = "/logout")
    public String logout( HttpSession session) {
        if (session.getAttribute("manage_session_user_info") != null) {
            session.removeAttribute("manage_session_user_info");
        }
        return page_login;
    }

}
