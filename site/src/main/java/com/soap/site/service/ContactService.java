package com.soap.site.service;

import com.soap.site.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author fenglei
 * @Date 2018/10/13
 * @Version 1.0
 **/
@Service
public class ContactService {

    @Autowired
    private ContactMapper contactMapper;

    public void insert(Map<String, Object> params) {
        int num = contactMapper.insert(params);
    }
}
