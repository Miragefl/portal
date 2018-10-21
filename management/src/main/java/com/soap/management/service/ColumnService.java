package com.soap.management.service;

import com.soap.exception.BizFailException;
import com.soap.management.mapper.ColumnMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.soap.constant.Const.RET_FAIL;

/**
 * @Author mabiao
 * @Date 2018/10/03
 * @Version 1.0
 **/
@Service
public class ColumnService {

    @Autowired
    private ColumnMapper columnMapper;

    public Map<String, Object> getColumns(String columnId) throws BizFailException {

        Map<String, Object> columns = columnMapper.getColumns(columnId);

        return columns;
    }

    public List<Map<String, Object>> getTreeNode() throws BizFailException {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> rootResult = columnMapper.getRootColumns();
        for (Map<String,Object> map : rootResult) {
            Map<String, Object> node = new HashMap<String, Object>();
            node.put("id", map.get("columnId"));
            node.put("text", map.get("columnName"));
            List<Map<String, Object>> childs = getChilddrens(String.valueOf(map.get("columnId")));
            node.put("children", childs);
            result.add(node);
        }

        return result;
    }

    public List<Map<String, Object>> getChilddrens(String rootId) {
        List<Map<String, Object>> childs = new ArrayList<Map<String, Object>>();
        List<Map<String,Object>> childrens =columnMapper.getChildColumns(rootId);
        for (Map<String,Object> map : childrens) {
            Map<String, Object> child = new HashMap<String, Object>();
            child.put("id", map.get("columnId"));
            child.put("text", map.get("columnName"));
            childs.add(child);
        }
        return childs;

    }
    /**
     * 插入新栏目
     * @param reqMap
     * @return
     * @throws BizFailException
     */
    public Map<String, Object> addColumn(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnName")))){
            throw new BizFailException(RET_FAIL, "栏目名称未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnLevel")))){
            throw new BizFailException(RET_FAIL, "栏目等级未传!");
        }
        String count = columnMapper.getColumnCount(reqMap);

        if(!StringUtils.equals(count,"0")){
            throw new BizFailException(RET_FAIL, "此栏目此排序位置已存在!");
        }
        //插入新栏目
        columnMapper.addColumn(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errCode","000000");
        map.put("errMsg","插入成功");
        return map;
    }
    /**
     * 修改新栏目
     * @param reqMap
     * @return
     * @throws BizFailException
     */
    public Map<String, Object> updateColumn(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnName")))){
            throw new BizFailException(RET_FAIL, "栏目名称未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnId")))){
            throw new BizFailException(RET_FAIL, "栏目Id未传!");
        }
        String count = columnMapper.getColumnCount(reqMap);

        if(!StringUtils.equals(count,"0")){
            throw new BizFailException(RET_FAIL, "此栏目此排序位置已存在!");
        }
        //插入新栏目
        columnMapper.updateColumn(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errCode","000000");
        map.put("errMsg","修改成功");
        return map;
    }
    /**
     * 删除新栏目
     * @param reqMap
     * @return
     * @throws BizFailException
     */
    public Map<String, Object> delColumn(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnId")))){
            throw new BizFailException(RET_FAIL, "栏目Id未传!");
        }
        //插入新栏目
        columnMapper.delColumn(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errCode","000000");
        map.put("errMsg","删除成功");
        return map;
    }
    /**
     * 修改栏目展示状态
     * @param reqMap
     * @return
     * @throws BizFailException
     */
    public Map<String, Object> updateShow(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnId")))){
            throw new BizFailException(RET_FAIL, "栏目Id未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("isShow")))){
            throw new BizFailException(RET_FAIL, "展示状态未传!");
        }
        //插入新栏目
        columnMapper.updateShow(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errCode","000000");
        map.put("errMsg","删除成功");
        return map;
    }
}
