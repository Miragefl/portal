package com.soap.site.web;

import com.soap.exception.BizFailException;
import com.soap.site.service.IndexService;
import com.soap.site.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>首页</p>
 *
 * @Author fenglei
 * @Date 2018/10/5
 * @Version 1.0
 **/
@RestController
@RequestMapping("/index")
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IndexService indexService;

//    @RequestMapping("/index")
//    public String index(@RequestBody(required = false) Map<String, Object> params) {
//        //  获取栏目列表
//        try {
//            List<Map<String, Object>> result = indexService.index(params);
//            return Helper.retSucc(result);
//        } catch (BizFailException e) {
//            return Helper.retFail(e);
//        }
//    }


}
