package com.soap.management.util;

import com.soap.exception.BaseException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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

    public static JSONObject retFailJson(BaseException e) {
        JSONObject result = new JSONObject();
        result.put("errorCode", e.getErrCode());
        result.put("errorMsg", e.getErrMsg());
        return result;
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

    // 流转化成字符
    public static String inputStream2String(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }

    public static String getCurrentTime(String format) {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);
        Date now = new Date();
        return formatter.format(now);
    }


    /**
     * 创建目录，如果目录以存在直接返回，否则创建目�?
     *
     * @param filePath
     * @throws IOException
     */
    public static void mkdirs(String filePath) throws Exception {
        // String[] dirArray = filePath.split("/");
        File file = new File(filePath);
        if (file.exists())
            return;
        boolean result = file.mkdirs();
        // result = file.mkdir();

        if (!result)
            throw new Exception("创建目录失败");
    }
    /**
     * 产生Min-Max之间的数
     *
     * @return
     */
    public static String getRandom(int min, int max) {
        double d = Math.round(Math.random() * (max - min) + min);
        return String.valueOf((int) d);
    }

    /**
     * 生成指定长度的随机码
     *
     * @param len
     * @return
     */
    public static String getRandomChar(int len) {
        Random random = new Random();
        char ch = '0';
        LinkedList<String> ls = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {// 0-9
            ls.add(String.valueOf(48 + i));
        }
        for (int i = 0; i < 26; i++) {// A-Z
            ls.add(String.valueOf(65 + i));
        }
        for (int i = 0; i < 26; i++) {// a-z
            ls.add(String.valueOf(97 + i));
        }
        StringBuilder sb = new StringBuilder();
        int index;
        for (int i = 0; i < len; i++) {
            index = random.nextInt(ls.size());
            if (index > (ls.size() - 1)) {
                index = ls.size() - 1;
            }
            ch = (char) Integer.parseInt(String.valueOf(ls.get(index)));
            sb.append(ch);
        }
        return sb.toString();
    }
}