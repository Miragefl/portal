package com.soap.management.mapper;

import java.util.List;
import java.util.Map;

public interface ColumnMapper {
    //获取栏目列表
    public List<Map<String, Object>> getColumns();
    //添加栏目
    public void addColumn(Map<String,Object> reqMap);
    //修改栏目
    public void updateCoulum(Map<String,Object> reqMap);
    //删除栏目
    public void delCoulum(Map<String,Object> reqMap);
    //修改栏目状态
    public void updateShow(Map<String,Object> reqMap);

}
