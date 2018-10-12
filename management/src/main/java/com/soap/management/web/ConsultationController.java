package com.soap.management.web;

import com.soap.exception.BizFailException;
import com.soap.management.service.ConsultationService;
import com.soap.management.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>新闻编辑相关</p>
 *
 * @Author mabiao
 * @Date 2018/10/04
 * @Version 1.0
 **/
@Controller
@RequestMapping("/consultation")
public class ConsultationController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ConsultationService consultationService;

    /**
     * 获取新闻信息
     * @param
     * @return
     * @throws BizFailException
     */
    @RequestMapping(value="/getConsultation")
    @ResponseBody
    public List<Map<String, Object>> getConsultation(@RequestParam(value = "columnName", required = false) String columnName, @RequestParam(value = "title", required = false) String title, @RequestParam(value = "consuPlace", required = false) String consuPlace) throws BizFailException{
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("columnName",columnName);
        reqMap.put("title",title);
        reqMap.put("consuPlace",consuPlace);
        try {
            result = consultationService.getConsultation(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            /*   return Helper.retFail(e);*/
        }
        return result;
    }

    /**
     * 新增新闻资讯
     *  @param columnId
     *  @param title
     *  @param consuDesc
     *  @param consuType
     *  @param consuClass
     *  @param context
     *  @param consuPlace
     *  @param consuLink
     *  @param remarks
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/addConsultation")
    @ResponseBody
    public String addConsultation(@RequestParam(value = "columnId", required = false) String columnId,@RequestParam(value = "title", required = false) String title,
                                  @RequestParam(value = "consuDesc", required = false) String consuDesc,@RequestParam(value = "consuType", required = false) String consuType,@RequestParam(value = "consuClass", required = false) String consuClass,
                                  @RequestParam(value = "context", required = false) String context,@RequestParam(value = "consuPlace", required = false) String consuPlace,@RequestParam(value = "consuLink", required = false) String consuLink,
                                  @RequestParam(value = "remarks", required = false) String remarks) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("columnId",columnId);
        reqMap.put("title",title);
        reqMap.put("consuDesc",consuDesc);
        reqMap.put("consuType",consuType);
        reqMap.put("consuClass",consuClass);
        reqMap.put("context",context);
        reqMap.put("consuPlace",consuPlace);
        reqMap.put("consuLink",consuLink);
        reqMap.put("remarks",remarks);
        try {
            logger.info("1111111111111111111111ReqMap"+reqMap);
            result = consultationService.addConsultation(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }

    /**
     * 修改新闻资讯
     *  @param consulId
     *  @param columnId
     *  @param title
     *  @param consuDesc
     *  @param consuType
     *  @param consuClass
     *  @param context
     *  @param consuLink
     *  @param remarks
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/updateConsultation")
    @ResponseBody
    public String updateConsultation(@RequestParam(value = "consulId", required = false) String consulId,@RequestParam(value = "columnId", required = false) String columnId,@RequestParam(value = "title", required = false) String title,
                                     @RequestParam(value = "consuDesc", required = false) String consuDesc,@RequestParam(value = "consuType", required = false) String consuType,@RequestParam(value = "consuClass", required = false) String consuClass,
                                     @RequestParam(value = "context", required = false) String context,@RequestParam(value = "consuPlace", required = false) String consuPlace,@RequestParam(value = "consuLink", required = false) String consuLink,
                                     @RequestParam(value = "remarks", required = false) String remarks) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("consulId",consulId);
        reqMap.put("columnId",columnId);
        reqMap.put("title",title);
        reqMap.put("consuDesc",consuDesc);
        reqMap.put("consuType",consuType);
        reqMap.put("consuClass",consuClass);
        reqMap.put("context",context);
        reqMap.put("consuPlace",consuPlace);
        reqMap.put("consuLink",consuLink);
        reqMap.put("remarks",remarks);
        try {
            result = consultationService.updateConsultation(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }
    /**
     * 删除新闻资讯
     *  @param consulId
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/delConsultation")
    @ResponseBody
    public String delConsultation(@RequestParam(value = "consulId", required = false) String consulId) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("consulId",consulId);
        try {
            result = consultationService.delConsultation(reqMap);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            return Helper.retFail(e);
        }
        return Helper.retSucc(result);
    }


    /**
     * 查看新闻资讯
     *  @param consulId
     *  @return
     *  @throws BizFailException
     */
    @RequestMapping(value="/qryConsultationById")
    @ResponseBody
    public Map<String,Object> qryConsultationById(@RequestParam(value = "consulId", required = false) String consulId) throws BizFailException{
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("consulId",consulId);
        try {
            result = consultationService.qryConsultationById(reqMap);
            logger.info("1111111111111111111111result"+result);
            String context = new String((byte[])result.get("context"));
            logger.info("2222222222222context"+context);
            result.put("context",context);
        } catch (BizFailException e) {
            /*logger.error("获取列表信息出错",e);*/
            //  return Helper.retFail(e);
        }
        return result;
    }


}
