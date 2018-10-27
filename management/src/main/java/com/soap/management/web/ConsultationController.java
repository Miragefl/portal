package com.soap.management.web;

import com.soap.exception.BizFailException;
import com.soap.management.service.ConsultationService;
import com.soap.management.util.ConfigUtil;
import com.soap.management.util.Helper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
                                  @RequestParam(value = "remarks", required = false) String remarks,@RequestParam(value = "images", required = false) String images) throws BizFailException{
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
        reqMap.put("images",images);
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

    /**
     * 获取参数列表
     * @param code
     * @return
     */

    @RequestMapping(value="/qryApppar.do")
    @ResponseBody
    public JSONObject qryApppar(@RequestParam(value = "code", required = false) String code){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("code",code);
        try{
            result = consultationService.qryApppar(reqMap);
        } catch (BizFailException e){
            return Helper.retFailJson(e);
        }
        return Helper.getSuccJSON(result);
    }

    /**
     * 上传图片
     */
    @RequestMapping("/uploadImg.do")
    @ResponseBody
    public JSONObject uploadAppriseImg(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> data = new HashMap<String,Object>();
        JSONObject obj = new JSONObject();
        String imagePath ="";
        try {
            logger.info("122222222"+Helper.inputStream2String(request.getInputStream()));
        } catch (IOException e1) {
            logger.info("发生异常",e1);
        }
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名

            Iterator<String> iter = multiRequest.getFileNames();
            List<String> urls=new ArrayList<String>();
            List<String> orUrl=new ArrayList<String>();
            while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        logger.info(myFileName);
                        //定义上传路径
                        String returnPath="Upload/"+Helper.getCurrentTime("yyyyMM")+"/";
                        String path = ConfigUtil.get("UPLOAD_FILE_PATH") + returnPath;
                        try {
                            Helper.mkdirs(path);
                        } catch (Exception e1) {
                            logger.error("创建文件夹失败",e1);
                        }
                        String suffix = myFileName.substring(myFileName.indexOf("."));
                        //重命名上传后的文件名
                        String newFileName = Helper.getCurrentTime("dd-HHmmss")+"_"+Helper.getRandom(1000, 9999)+"_"+Helper.getRandomChar(10)+suffix;
                        File localFile = new File(path+newFileName);
                        imagePath = returnPath+newFileName;
                        try {
                            file.transferTo(localFile);
                            urls.add(returnPath+newFileName);
                            orUrl.add(myFileName);


//                            if(flag==0){
//                                List<Map<String,Object>> PhotoAppraiseList = appraiseService.qryPhotoAppraiseList(set_map);
//                                if(PhotoAppraiseList.size()>0){
//                                    appraiseService.delete(set_map);
//                                }
//                                flag++;
//                            }

                        } catch (IllegalStateException e) {
                            logger.error("",e);
                        } catch (IOException e) {
                            logger.error("",e);
                        }
                    }
                }
            }

           /* data.put("imageURL", urls);
            data.put("orImageURL", orUrl);*/
            obj.put("error", 0);
            obj.put("url", "http://localhost:8001/management/"+imagePath);
        }
        return  obj;
    }
}
