package com.soap.management.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public Map<String,Object> qryUser(Map<String,Object> params);

    public Map<String,Object> qryUserById(String userId);

    public List<Map<String, Object>> getUserList(Map<String, Object> reqMap);

    public void addUser(Map<String, Object> reqMap);

    public void updateUser(Map<String, Object> reqMap);

    public void delUser(Map<String, Object> reqMap);

}
