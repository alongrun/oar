package org.oar.module.config.jcommand;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class MapConverter{
    public static HashMap<String, String>  convert(String params) {
        String ss = params;
                //"{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
                //params;
        HashMap<String, String> hashMap= JSON.parseObject(ss, HashMap.class);
        return  hashMap;
    }
}
