package com.soap.site.service;

import com.soap.constant.Const;
import com.soap.exception.BizFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author fenglei
 * @Date 2018/10/5
 * @Version 1.0
 **/
@Service
public class IndexService {

    @Autowired
    private ColumnService columnService;

    public List<Map<String, Object>> index(Map<String, Object> params) throws BizFailException {
        try {
            return columnService.qryList(params);

        }catch (BizFailException e) {
            throw e;
        }
        catch (Exception e) {
            throw new BizFailException(Const.RET_FAIL,"首页初始化失败");
        }
    }
}
