package com.soap.site.util;

import com.soap.exception.BaseException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
        } else if (object instanceof List) {
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

}