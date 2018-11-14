package com.soap.management.mapper;

import java.util.List;
import java.util.Map;

public interface ColumnMapper {
    //获取栏目列表
    /*public List<Map<String, Object>> getColumns(String columnId);*/
    public Map<String, Object> getColumns(String columnId);
    //添加栏目
    public void addColumn(Map<String,Object> reqMap);
    //修改栏目
    public void updateColumn(Map<String,Object> reqMap);
    //删除栏目
    public void delColumn(Map<String,Object> reqMap);
    //修改栏目状态
    public void updateShow(Map<String,Object> reqMap);
    //获取栏目列表
    public List<Map<String, Object>> getRootColumns();
    //获取栏目列表
    public List<Map<String, Object>> getChildColumns(String id);

    public String getColumnCount(Map<String,Object> reqMap);

    public String getColumnId(Map<String,Object> reqMap);

    public void updateColumnLink(Map<String,Object> reqMap);
}
