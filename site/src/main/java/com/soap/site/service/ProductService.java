package com.soap.site.service;

import com.soap.site.mapper.ProductMapper;
import com.soap.site.util.Helper;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能说明<br/>
 * 此处填写功能描述<br/>
 *
 * @author fengleiA
 * @version 1.0
 * @Date 2018/10/28 14:51
 **/
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public JSONObject list(String columnId, int page) {
        JSONObject result = new JSONObject();
        int size = 9;
        int count = productMapper.count(columnId);
        int totalPage = (count + size - 1) / size;
        page = page > totalPage ? totalPage : page;
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("columnId", columnId);
        params.put("startPos", start);
        params.put("size", size);
        List<Map<String, Object>> list = productMapper.list(params);
        JSONArray root = JSONArray.fromObject(list);
        result.put("total", count);
        result.put("pageSize", size);
        result.put("start", start);
        result.put("root", root);
        result.put("totalPage", totalPage);
        result.put("currPage", page);
        String pager = getPager("/site/product/list?columnId=" + columnId + "&", result);
        result.put("pager", pager);
        return result;
//		return productMapper.list(columnId);
    }


    public Map<String, Object> detail(String consulId) {
        return productMapper.detail(consulId);
    }

    public int count(String columnId) {
        return productMapper.count(columnId);
    }


    protected String getPager(String url, JSONObject page) {


        String prev = "<<";
        String next = ">>";
        String pager = "";

        int totalPage = page.getInt("totalPage");
        int nowPage = page.getInt("currPage");
        int pageFrom = 1;
        int pageTo = totalPage;


        if (totalPage <= 1) {
            return "";
        }

        if (totalPage > 9) {
            if ((nowPage + 4) > totalPage) {
                pageTo = totalPage;
                pageFrom = pageTo - 8;
            } else if (nowPage < 4) {
                pageFrom = 1;
                pageTo = pageFrom + 8;
            } else {
                pageFrom = nowPage - 3;
                pageTo = nowPage + 4;
            }
        }

        if (nowPage > 1) {
            pager += "<a class=\"wst-prev\" href=\"" + url + "page=" + (nowPage - 1) + "\">" + prev + "</a>";
        }

        if (pageFrom > 1) {
            pager += "<a class=\"wst-first\" href=\"" + url + "page=1\">1</a>";
        }

        for (int i = pageFrom; i <= pageTo; i++) {
            if (i != nowPage) {
                pager += "<a class=\"wst-num\" href=\"" + url + "page=" + i + "\">" + i + "</a>";
            } else {
                pager += "<span class=\"wst-current\">" + i + "</span>";
            }
        }

        if (pageTo < totalPage) {
            pager += "<a class=\"wst-end\" href=\"" + url + "page=" + totalPage + "\">" + totalPage + "</a>";
        }

        if (nowPage < totalPage) {
            pager += "<a class=\"wst-next\" href=\"" + url + "page=" + (nowPage + 1) + "\">" + next + "</a>";
        }

        return "<div class=\"wst-pagination\">" + pager + "</div>";
    }

    public JSONObject query(String columnId, int page) {
        Map<String, Object> columnDetail = productMapper.columnDetail(columnId);
        String isJump = String.valueOf(columnDetail.get("isJump"));
        JSONObject result = new JSONObject();
        if ("1".equals(isJump)) { // 列表
            result = list(columnId, page);
        } else if ("0".equals(isJump)) { // 文章
            Map<String, Object> stringObjectMap = productMapper.qryConsulByColumnId(columnId);
            stringObjectMap.put("context", new String((byte[]) (stringObjectMap.get("context"))));
            result = JSONObject.fromObject(stringObjectMap);
        } else { // 固定页面
            result = JSONObject.fromObject(columnDetail);
        }
        result.put("isJump", isJump);

        return result;
    }

    public List<Map<String, Object>> queryGCSL() {
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("columnId", "4");
        params.put("startPos", 0);
        params.put("size", 5);
        List<Map<String, Object>> list = productMapper.list(params);
        return add(list);
    }

    private List<Map<String, Object>> add(List<Map<String, Object>> list){
        if (list.size()<6) {
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("consulId",-1);
            params.put("images","images/b3.jpg");
            list.add(params);
            add(list);
        }
        return list;
    }

}

    