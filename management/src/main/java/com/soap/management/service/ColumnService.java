package com.soap.management.service;

import com.soap.exception.BizFailException;
import com.soap.management.mapper.ColumnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

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

    public List<Map<String, Object>> getColumns() throws BizFailException {
        List<Map<String, Object>> columns = columnMapper.getColumns();
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        return columns;
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
    public Map<String, Object> updateCoulum(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnName")))){
            throw new BizFailException(RET_FAIL, "栏目名称未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnId")))){
            throw new BizFailException(RET_FAIL, "栏目Id未传!");
        }
        //插入新栏目
        columnMapper.updateCoulum(reqMap);
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
    public Map<String, Object> delCoulum(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnId")))){
            throw new BizFailException(RET_FAIL, "栏目Id未传!");
        }
        //插入新栏目
        columnMapper.delCoulum(reqMap);
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
