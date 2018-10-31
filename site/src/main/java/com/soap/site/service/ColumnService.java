package com.soap.site.service;

import com.soap.site.mapper.ColumnMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author fenglei
 * @Date 2018/10/5
 * @Version 1.0
 **/
@Service
public class ColumnService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String COLUMN_CACHE_NAME = "column";

    @Autowired
    private ColumnMapper columnMapper;

    @Cacheable(value =COLUMN_CACHE_NAME, key = "column")
    public List<Map<String, Object>> qryColumns(Map<String, Object> params) {
        List<Map<String, Object>> list = qry(null);
        for (int i=0;i<list.size();i++) {
            Map<String, Object> parentCol = list.get(i);
            List<Map<String, Object>> childColumn = qry(parentCol);
            parentCol.put("childColumn",childColumn);
        }
        return list;
    }

    /**
     * 查询栏目
     * @param params
     * @return
     */
    public List<Map<String, Object>> qry(Map<String, Object> params) {
        return columnMapper.qryColumns(params);
    }

}
