package com.example.apublic.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017/4/20.
 */

public class JsonUtils {
    /**
     * 把一个map变成json字符串
     * @param map
     * @return
     */
    public synchronized static String parseMapToJson(Map<?, ?> map) {
        try {
            if(gson ==null){
                gson = new Gson();
            }
            return gson.toJson(map);
        } catch (Exception e) {
        }
        return null;
    }



    public static String parseObjectToJson(Object obj) {
        try {
            if(gson ==null){
                gson = new Gson();
            }

            return gson.toJson(obj);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 把一个json字符串变成对象
     * @param json
     * @param cls
     * @return
     */
   private static Gson gson;
    public synchronized static <T> T parseJsonToBean(String json, Class<T> cls) {
        if(gson ==null){
            gson = new Gson();
        }
        T t = null;
        try {
            t = gson.fromJson(json, cls);
        } catch (Exception e) {
            if(!TextUtils.isEmpty(e.getMessage())){
//                XLog.d("Exception",e.getMessage());
            }
        }
        return t;
    }

    /**
     * 把json字符串变成map
     * @param json
     * @return
     */
    public synchronized static HashMap<String, Object> parseJsonToMap(String json) {
        if(gson ==null){
            gson = new Gson();
        }
        Type type = new TypeToken<HashMap<String, Object>>() {
        }.getType();
        HashMap<String, Object> map = null;
        try {
            map = gson.fromJson(json, type);
        } catch (Exception e) {
        }
        return map;
    }

    /**
     * 把json字符串变成集合
     * params: new TypeToken<List<yourbean>>(){}.getType(),
     *
     * @param json
     * @param type  new TypeToken<List<yourbean>>(){}.getType()
     * @return
     */
    public synchronized static List<?> parseJsonToList(String json, Type type) {
        if(gson ==null){
            gson = new Gson();
        }
        List<?> list = gson.fromJson(json, type);
        return list;
    }

    /**
     *
     * 获取json串中某个字段的值，注意，只能获取同一层级的value
     *
     * @param json
     * @param key
     * @return
     */
    public static String getFieldValue(String json, String key) {
        if (TextUtils.isEmpty(json))
            return null;
        if (!json.contains(key))
            return "";
        JSONObject jsonObject = null;
        String value = null;
        try {
            jsonObject = new JSONObject(json);
            value = jsonObject.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

}
