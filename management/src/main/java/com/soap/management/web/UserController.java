package com.soap.management.web;

import com.soap.exception.BizFailException;
import com.soap.management.service.UserService;
import com.soap.management.util.Helper;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
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

    @RequestMapping(value="/getUserList")
    @ResponseBody
    public JSONObject getUserList(@RequestParam(value = "userName", required = false) String userName) throws BizFailException{
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("userName",userName);
        try {
            result = userService.getUserList(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFailJson(e);
        }
        return Helper.getSuccJSON(result);
    }

    @RequestMapping(value="/qryUserById")
    @ResponseBody
    public  JSONObject qryUserById(@RequestParam(value = "userId") String userId) throws BizFailException{
        /* List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();*/
        Map<String, Object> result = new HashMap<String,Object>();
        try {
            logger.info("11111111111111+====="+userId);
            result = userService.qryUserById(userId);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFailJson(e);
        }
        return Helper.getSuccJSON(result);
    }
    @RequestMapping(value = "/addUser")
    @ResponseBody
    public String addUser(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "password", required = false) String password, @RequestParam(value = "userPhone", required = false) String userPhone,@RequestParam(value = "sex", required = false) String sex,@RequestParam(value = "age", required = false) String age) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("userName",userName);
        reqMap.put("password",password);
        reqMap.put("userPhone",userPhone);
        reqMap.put("sex",sex);
        reqMap.put("age",age);
        try {
            logger.info("11111111111111+====="+reqMap);
            result = userService.addUser(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }
    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public String updateUser(@RequestParam(value = "userId", required = false) String userId,@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "password", required = false) String password, @RequestParam(value = "userPhone", required = false) String userPhone,@RequestParam(value = "sex", required = false) String sex,@RequestParam(value = "age", required = false) String age) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("userId",userId);
        reqMap.put("userName",userName);
        reqMap.put("password",password);
        reqMap.put("userPhone",userPhone);
        reqMap.put("sex",sex);
        reqMap.put("age",age);
        try {
            result = userService.updateUser(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }
    @RequestMapping(value = "/delUser")
    @ResponseBody
    public String addUser(@RequestParam(value = "userId", required = false) String userId) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("userId",userId);
        try {
            result = userService.delUser(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }
}
