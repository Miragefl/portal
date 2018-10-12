package com.soap.management.util;

import com.soap.exception.BaseException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.soap.constant.Const.RET_SUCC;

/**
 * @Author fenglei
 * @Date 2018/10/3
 * @Version 1.0
 **/
public class Helper {

    public static String retSucc(Object object) {
        JSONObject jsonObject = null;
        if (object instanceof Map) {
            jsonObject = JSONObject.fromObject(object);
        } else if (object instanceof JSONArray) {
            return dealSucc(JSONArray.fromObject(object));
        }
        return dealSucc(jsonObject);
    }

    public static String retFail(BaseException e) {
        JSONObject result = new JSONObject();
        result.put("errorCode", e.getErrCode());
        result.put("errorMsg", e.getErrMsg());
        return result.toString();
    }

    private static String dealSucc(JSONObject json) {
        JSONObject result = new JSONObject();
        result.put("errorCode", RET_SUCC);
        if (null != json) {
            result.put("data", json);
        }
        return result.toString();
    }

    private static String dealSucc(JSONArray json) {
        JSONObject result = new JSONObject();
        result.put("errorCode", RET_SUCC);
        if (null != json) {
            result.put("data", json);
        }
        return result.toString();
    }
    public static JSONObject getJSON(String status, String desc) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("desc", "");
        map.put("status", "0");
        return JSONObject.fromObject(map);
    }

    public static JSONObject getSuccJSON(List<Map<String, Object>> list) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (list != null) {
            for (Map<String, Object> tmpMap : list) {
                replaceNull(tmpMap);
            }
            map.put("body", list);
        }
        map.put("desc", "");
        map.put("status", "0");
        return JSONObject.fromObject(map);
    }

    public static JSONObject getFailJSON(String code, String msg) {
        return getJSON(code, msg, null);
    }

    public static JSONObject getSuccJSON(Map<String, Object> data) {
        return getJSON("0", "", data);
    }

    public static JSONObject getJSON(String code, String msg, Map<String, Object> data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", code);
        map.put("desc", msg);
        if (data != null) {
            replaceNull(data);
            map.put("body", data);
        }
        return JSONObject.fromObject(map);
    }

    public static JSONObject getJSON(Map<String, Object> map) {
        replaceNull(map);
        return JSONObject.fromObject(map);
    }

    public static void replaceNull(Map<String,Object>map){
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            if(map.get(key)==null){
                map.put(key, "");
            }
        }

    }
}