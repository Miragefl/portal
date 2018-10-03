package com.soap.management.web;

import com.soap.exception.BizFailException;
import com.soap.management.service.ColumnService;
import com.soap.management.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>栏目相关</p>
 *
 * @Author mabiao
 * @Date 2018/10/03
 * @Version 1.0
 **/
@Controller("/column")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    /**
     * 获取栏目信息
     * @param
     * @return
     * @throws BizFailException
     */
    @RequestMapping(value="/getCoulums")
    public String getColumns() throws BizFailException{
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try {
            result = columnService.getColumns();
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }

    /**
     * 新增栏目
     *  @param columnName
     *  @param columnLevel
     *  @param columnParent
     *  @param remarks
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/addCoulum")
    public String addCoulum(@RequestBody Map<String,Object> reqMap) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result = columnService.addColumn(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }

    /**
     * 修改栏目
     *  @param columnName
     *  @param columnId
     *  @param remarks
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/updateCoulum")
    public String updateCoulum(@RequestBody Map<String,Object> reqMap) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result = columnService.updateCoulum(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }
    /**
     * 删除栏目
     *  @param columnId
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/delCoulum")
    public String delCoulum(@RequestBody Map<String,Object> reqMap) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result = columnService.delCoulum(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }
    /**
     * 修改栏目展示
     *  @param columnId
     *  @param isShow
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/updateShow")
    public String updateShow(@RequestBody Map<String,Object> reqMap) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result = columnService.updateShow(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }


}
