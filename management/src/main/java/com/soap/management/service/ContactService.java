package com.soap.management.service;

import com.soap.exception.BizFailException;
import com.soap.management.mapper.ContactMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author mabiao
 * @Date 2018/10/03
 * @Version 1.0
 **/
@Service
public class ContactService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ContactMapper contactMapper;

    public Map<String, Object> getContactById(String contactId) throws BizFailException {

        Map<String, Object> contact = contactMapper.getContactById(contactId);

        return contact;
    }
    public List<Map<String, Object>> getContact(Map<String,Object> reqMap) throws BizFailException {
        logger.info("reqMap++++++++"+reqMap);
        List<Map<String, Object>> contacts = contactMapper.getContact(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        return contacts;
    }
}
