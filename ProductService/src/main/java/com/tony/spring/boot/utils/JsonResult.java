package com.tony.spring.boot.utils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;


@SuppressWarnings("unused")
public class JsonResult implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	private int code;   //返回码 非0即失败
    private String msg; //消息提示
    private Map<String, Object> data; //返回的数据
 
    public JsonResult(){};
 
    public JsonResult(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
 
    public static String success() {
        return success(new HashMap<>(0));
    }
    public static String success(Map<String, Object> data) {
        return JSON.toJSONString(new JsonResult(0, "解析成功", data));
    }
 
    public static JsonResult failed() {
        return failed("解析失败");
    }
    public static JsonResult failed(String msg) {
        return failed(-1, msg);
    }
    public static JsonResult failed(int code, String msg) {
    	
    	JsonResult jsonResult = new JsonResult(code, msg, new HashMap<>(0));
    	return jsonResult;
    }
}
