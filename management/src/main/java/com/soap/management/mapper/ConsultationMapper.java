package com.soap.management.mapper;

import java.util.List;
import java.util.Map;

public interface ConsultationMapper {
    //获取栏目列表
    public List<Map<String, Object>> getConsultation(Map<String, Object> reqMap);
    //添加栏目
    public void addConsultation(Map<String, Object> reqMap);
    //修改栏目
    public void updateConsultation(Map<String, Object> reqMap);
    //删除栏目
    public void delConsultation(Map<String, Object> reqMap);

    public Map<String,Object> qryConsultationById(Map<String,Object> reqMap);

}
