package com.soap.site.service;

import com.soap.constant.Const;
import com.soap.exception.BizFailException;
import com.soap.site.mapper.ColumnMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    @Autowired
    private ColumnMapper columnMapper;


    public List<Map<String, Object>> qryList(Map<String, Object> params) throws BizFailException {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try {
            List<Map<String, Object>> list = columnMapper.qryList(params);
            logger.info("{}", list);
            if (list.size() == 0) {
                throw new BizFailException(Const.RET_FAIL, "菜单列表为空");
            }

            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> columns = list.get(i);
                if (i == 0 || !String.valueOf(list.get(i - 1).get("parId")).equals(String.valueOf(list.get(i).get("parId")))) { // 如果是第一条或者当前parId与之前parId不同 则直接拼接
                    Map<String, Object> col = new HashMap<String, Object>();
                    col.put("parId", columns.get("parId"));
                    col.put("parName", columns.get("parName"));
                    col.put("parLink", columns.get("parLink"));
                    if (!col.containsKey("list")) {
                        col.put("list", new ArrayList<Map<String, Object>>());
                    }
                    if (columns.containsKey("sonId") && null != columns.get("sonId")) {
                        Map<String, Object> sonColumn = new HashMap<String, Object>();
                        sonColumn.put("sonId", columns.get("sonId"));
                        sonColumn.put("sonName", columns.get("sonName"));
                        sonColumn.put("sonLink", columns.get("sonLink"));
                        ((List) col.get("list")).add(sonColumn);
                    }
                    result.add(col);
                } else {
                    if (columns.containsKey("sonColumnId") && null != columns.get("sonId")) {
                        Map<String, Object> sonColumn = new HashMap<String, Object>();
                        sonColumn.put("sonId", columns.get("sonId"));
                        sonColumn.put("sonName", columns.get("sonName"));
                        sonColumn.put("sonLink", columns.get("sonLink"));
                        ((List) result.get(result.size() - 1).get("list")).add(sonColumn);
                    }
                }


            }
        } catch (BizFailException e) {
            throw e;
        } catch (Exception e) {
            throw new BizFailException(Const.RET_FAIL, "查询菜单列表异常");
        }
        return result;
    }

    /**
     * 查询栏目
     * @param params
     * @return
     */
    public List<Map<String, Object>> qryColumns(Map<String, Object> params) {
        return columnMapper.qryColumns(params);
    }


}
