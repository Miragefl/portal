package com.soap.management.web;

import com.soap.exception.BizFailException;
import com.soap.management.service.ColumnService;
import com.soap.management.util.Helper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Controller
@RequestMapping("/column")
public class ColumnController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ColumnService columnService;

    /**
     * 获取栏目信息
     * @param
     * @return
     * @throws BizFailException
     */
    @RequestMapping(value="/getCoulums")
    @ResponseBody
    public  JSONObject getColumns(@RequestParam(value = "columnId") String columnId) throws BizFailException{
       /* List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();*/
        Map<String, Object> result = new HashMap<String,Object>();
        try {
            logger.info("1111111111111111111111");
            result = columnService.getColumns(columnId);
            logger.info("22222222222222"+result);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFailJson(e);
        }
        return Helper.getSuccJSON(result);
    }

    /**
     * 获取栏目信息
     * @param
     * @return
     * @throws BizFailException
     */
    @RequestMapping(value="/getTreeNode")
    @ResponseBody
    public Object  getTreeNode() throws BizFailException{
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        result = columnService.getTreeNode();

        return result;
    }

    /**
     * 新增栏目
     *  @param columnName
     *  @param columnLevel
     *  @param columnParent
     *  @param columnSort
     *  @param remarks
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/addCoulum")
    @ResponseBody
    public JSONObject addCoulum(@RequestParam(value = "columnName", required = false) String columnName,@RequestParam(value = "images", required = false) String images,@RequestParam(value = "columnLevel", required = false) String columnLevel,@RequestParam(value = "isJump", required = false) String isJump,@RequestParam(value = "columnSort", required = false) String columnSort,@RequestParam(value = "columnLink", required = false) String columnLink,@RequestParam(value = "columnParent", required = false) String columnParent,@RequestParam(value = "remarks", required = false) String remarks) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("columnName",columnName);
        reqMap.put("columnLevel",columnLevel);
        reqMap.put("isJump",isJump);
        reqMap.put("columnSort",columnSort);
        reqMap.put("columnLink",columnLink);
        reqMap.put("columnParent",columnParent);
        reqMap.put("remarks",remarks);
        reqMap.put("images",images);
        try {
            result = columnService.addColumn(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFailJson(e);
        }
        return Helper.getSuccJSON(result);
    }

    /**
     * 修改栏目
     *  @param columnName
     *  @param columnId
     *  @param remarks
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/updateColumn")
    @ResponseBody
    public JSONObject updateColumn(@RequestParam(value = "columnId", required = false) String columnId,@RequestParam(value = "images", required = false) String images, @RequestParam(value = "columnName", required = false) String columnName, @RequestParam(value = "isJump", required = false) String isJump, @RequestParam(value = "columnLink", required = false) String columnLink, @RequestParam(value = "columnSort", required = false) String columnSort, @RequestParam(value = "remarks", required = false) String remarks) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("columnId",columnId);
        reqMap.put("columnName",columnName);
        reqMap.put("isJump",isJump);
        reqMap.put("columnLink",columnLink);
        reqMap.put("columnSort",columnSort);
        reqMap.put("remarks",remarks);
        reqMap.put("images",images);
        logger.info("reqmap+++"+reqMap);
        try {
            result = columnService.updateColumn(reqMap);
            logger.info("result_+++"+result);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFailJson(e);
        }
        return Helper.getSuccJSON(result);
    }
    /**
     * 删除栏目
     *  @param columnId
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/delColumn")
    @ResponseBody
    public JSONObject delColumn(@RequestParam(value = "columnId", required = false) String columnId) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("columnId",columnId);
        try {
            result = columnService.delColumn(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFailJson(e);
        }
        return Helper.getSuccJSON(result);
    }
    /**
     * 修改栏目展示
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/updateShow")
    @ResponseBody
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
