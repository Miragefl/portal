package com.soap.management.mapper;

import java.util.List;
import java.util.Map;

public interface ContactMapper {
    public Map<String, Object> getContactById(String contactId);

    public List<Map<String, Object>> getContact(Map<String, Object> reqMap);
}
