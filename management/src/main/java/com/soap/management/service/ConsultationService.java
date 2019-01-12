package com.soap.management.service;

import com.soap.exception.BizFailException;
import com.soap.management.mapper.ConsultationMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ConsultationService {

    @Autowired
    private ConsultationMapper consultationMapper;

    public List<Map<String, Object>> getConsultation(Map<String,Object> reqMap) throws BizFailException {
        List<Map<String, Object>> consultation = consultationMapper.getConsultation(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        return consultation;
    }

    /**
     * 新增新闻资讯
     *  @param columnId
     *  @param title
     *  @param desc
     *  @param consuType
     *  @param consuPlace
     *  @param consuClass
     *  @param context
     *  @param consuLink
     *  @param remarks
     *  @return
     *  @throws BizFailException
     */
    public Map<String, Object> addConsultation(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnId")))){
            throw new BizFailException(RET_FAIL, "关联栏目未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("title")))){
            throw new BizFailException(RET_FAIL, "标题未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("consuDesc")))){
            throw new BizFailException(RET_FAIL, "描述未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("consuType")))){
            throw new BizFailException(RET_FAIL, "类型未传!");
        }
/*        if(StringUtils.isBlank(String.valueOf(reqMap.get("consuPlace")))){
            throw new BizFailException(RET_FAIL, "位置未传!");
        }*/
     /*   if(StringUtils.isBlank(String.valueOf(reqMap.get("consuClass")))){
            throw new BizFailException(RET_FAIL, "类别未传!");
        }*/
       /* if(StringUtils.isBlank(String.valueOf(reqMap.get("context")))){
            throw new BizFailException(RET_FAIL, "文本内容未传!");
        }*/
        /*if(StringUtils.isBlank(String.valueOf(reqMap.get("remarks")))){
            throw new BizFailException(RET_FAIL, "备注未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("images")))){
            throw new BizFailException(RET_FAIL, "图片未传!");
        }*/
        //插入新栏目
        consultationMapper.addConsultation(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errCode","000000");
        map.put("errMsg","插入成功");
        return map;
    }
    /**
     * 修改新闻资讯
     * @param reqMap
     * @return
     * @throws BizFailException
     */
    public Map<String, Object> updateConsultation(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("consulId")))){
            throw new BizFailException(RET_FAIL, "id未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("columnId")))){
            throw new BizFailException(RET_FAIL, "关联栏目未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("title")))){
            throw new BizFailException(RET_FAIL, "标题未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("consuDesc")))){
            throw new BizFailException(RET_FAIL, "描述未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("consuType")))){
            throw new BizFailException(RET_FAIL, "类型未传!");
        }
      /*  if(StringUtils.isBlank(String.valueOf(reqMap.get("consuPlace")))){
            throw new BizFailException(RET_FAIL, "位置未传!");
        }*/
   /*     if(StringUtils.isBlank(String.valueOf(reqMap.get("consuClass")))){
            throw new BizFailException(RET_FAIL, "类别未传!");
        }*/
       /* if(StringUtils.isBlank(String.valueOf(reqMap.get("remarks")))){
            throw new BizFailException(RET_FAIL, "备注未传!");
        }
        if(StringUtils.isBlank(String.valueOf(reqMap.get("images")))){
            throw new BizFailException(RET_FAIL, "图片未传!");
        }*/
        //插入新栏目
        consultationMapper.updateConsultation(reqMap);
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
    public Map<String, Object> delConsultation(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("consulId")))){
            throw new BizFailException(RET_FAIL, "Id未传!");
        }
        //插入新栏目
        consultationMapper.delConsultation(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errCode","000000");
        map.put("errMsg","删除成功");
        return map;
    }
    /**
     * 查看新闻资讯
     * @param reqMap
     * @return
     * @throws BizFailException
     */
    public Map<String, Object> qryConsultationById(Map<String,Object> reqMap) throws BizFailException {

        if(StringUtils.isBlank(String.valueOf(reqMap.get("consulId")))){
            throw new BizFailException(RET_FAIL, "Id未传!");
        }
        //插入新栏目
        Map<String,Object> result = consultationMapper.qryConsultationById(reqMap);
      /*  if (null == columns) {
            throw new BizFailException(RET_FAIL,"用户不存在");
        }*/
        return result;
    }


    public List<Map<String,Object>> qryApppar(Map<String, Object> params) throws BizFailException {
        if(StringUtils.isBlank(String.valueOf(params.get("code")))){
         throw new BizFailException(RET_FAIL, "code!");
         }
        List<Map<String,Object>> Apppar = consultationMapper.qryApppar(params);

        return Apppar;
    }
}
