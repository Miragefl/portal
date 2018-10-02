package com.soap.management.service;

import com.soap.exception.BizFailException;
import com.soap.management.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.soap.constant.Const.RET_FAIL;

/**
 * @Author fenglei
 * @Date 2018/10/2
 * @Version 1.0
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void login(String userName, String password) throws BizFailException {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userName",userName);
        params.put("password",password);
        Map<String,Object> user = userMapper.qryUser(params);
        if (null == user) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }
    }
}
