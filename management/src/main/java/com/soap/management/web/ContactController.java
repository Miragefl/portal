package com.soap.management.web;

import com.soap.exception.BizFailException;
import com.soap.management.service.ContactService;
import com.soap.management.util.Helper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>栏目相关</p>
 *
 * @Author mabiao
 * @Date 2018/10/03
 * @Version 1.0
 **/
@Controller
@RequestMapping("/contact")
public class ContactController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ContactService contactService;

    /**
     * 获取邮件信息
     * @param
     * @return
     * @throws BizFailException
     */
    @RequestMapping(value="/getContactById")
    @ResponseBody
    public  JSONObject getColumns(@RequestParam(value = "contactId") String contactId) throws BizFailException{
       /* List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();*/
        Map<String, Object> result = new HashMap<String,Object>();
        try {
            logger.info("1111111111111111111111");
            result = contactService.getContactById(contactId);
            logger.info("22222222222222"+result);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFailJson(e);
        }
        return Helper.getSuccJSON(result);
    }
    /**
     * 获取邮件信息列表
     * @param
     * @return
     * @throws BizFailException
     */
    @RequestMapping(value="/getContact")
    @ResponseBody
    public JSONObject getContact(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "email", required = false) String email) throws BizFailException{
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("username",username);
        reqMap.put("email",email);
        try {
            result = contactService.getContact(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFailJson(e);
        }
        return Helper.getSuccJSON(result);
    }
}
