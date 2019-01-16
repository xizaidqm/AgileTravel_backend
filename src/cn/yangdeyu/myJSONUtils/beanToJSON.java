package cn.yangdeyu.myJSONUtils;

import net.sf.json.JSONObject;

public class beanToJSON {
    public static JSONObject frontJson(JSONObject jsonObject){
        JSONObject object = new JSONObject();
        object.put("success",1);
        object.put("content",jsonObject);
        return object;
    }


}
