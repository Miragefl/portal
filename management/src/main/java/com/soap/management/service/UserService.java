package com.soap.management.service;

import com.soap.constant.Const;
import com.soap.exception.BizFailException;
import com.soap.management.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;
import java.util.HashMap;
import java.util.List;
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

    public Map<String,Object> login(String userName, String password) throws BizFailException {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userName",userName);
        params.put("password",password);
        Map<String,Object> user = userMapper.qryUser(params);
        if (null == user) {
            throw new BizFailException(Const.RET_FAIL,"用户不存在");
        }
        return user;
    }

    public List<Map<String, Object>> getUserList(Map<String,Object> reqMap) throws BizFailException {
        List<Map<String, Object>> userList = userMapper.getUserList(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        return userList;
    }
    public Map<String, Object> qryUserById(String userId) throws BizFailException {

        Map<String, Object> user = userMapper.qryUserById(userId);

        return user;
    }

    public Map<String, Object> addUser(Map<String,Object> reqMap) throws BizFailException {
        if(StringUtils.isBlank(String.valueOf(reqMap.get("userName")))){
            throw new BizFailException(RET_FAIL, "用户名称未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("password")))){
            throw new BizFailException(RET_FAIL, "密码未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("userPhone")))){
            throw new BizFailException(RET_FAIL, "手机号未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("sex")))){
            throw new BizFailException(RET_FAIL, "性别未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("age")))){
            throw new BizFailException(RET_FAIL, "年龄未传!");
        }
        //插入用户
        userMapper.addUser(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errCode","000000");
        map.put("errMsg","插入成功");
        return map;
    }


    public Map<String, Object> updateUser(Map<String,Object> reqMap) throws BizFailException {
        if(StringUtils.isBlank(String.valueOf(reqMap.get("userId")))){
            throw new BizFailException(RET_FAIL, "用户Id未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("userName")))){
            throw new BizFailException(RET_FAIL, "用户名称未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("password")))){
            throw new BizFailException(RET_FAIL, "密码未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("userPhone")))){
            throw new BizFailException(RET_FAIL, "手机号未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("sex")))){
            throw new BizFailException(RET_FAIL, "性别未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("age")))){
            throw new BizFailException(RET_FAIL, "年龄未传!");
        }
        //修改用户
        userMapper.updateUser(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errCode","000000");
        map.put("errMsg","修改成功");
        return map;
    }

    public Map<String, Object> delUser(Map<String,Object> reqMap) throws BizFailException {
        if(StringUtils.isBlank(String.valueOf(reqMap.get("userId")))){
            throw new BizFailException(RET_FAIL, "用户Id未传!");
        }
        //删除用户
        userMapper.delUser(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errCode","000000");
        map.put("errMsg","删除成功");
        return map;
    }
}
