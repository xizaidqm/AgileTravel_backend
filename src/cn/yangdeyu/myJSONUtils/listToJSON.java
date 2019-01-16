package cn.yangdeyu.myJSONUtils;

import cn.yangdeyu.bean.Activities;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class listToJSON {
    public JSONObject ActivityJSONList(List<Activities> activitiesList){
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> jsonObjectList = new ArrayList<>();
        jsonObject.put("success",1);
        for (Activities ac: activitiesList
             ) {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("travelid",ac.getTravelid());
            jsonObject1.put("openid",ac.getOpenid());
            jsonObject1.put("city",ac.getCity());
            jsonObject1.put("starttime",ac.getStarttime().toString());
            jsonObject1.put("endtime",ac.getEndtime().toString());
            jsonObject1.put("travelname",ac.getTravelname());
            jsonObject1.put("description",ac.getDescription());
            jsonObject1.put("flag",ac.getFlag());
            jsonObject1.put("kind",ac.getKind());
            jsonObject1.put("cost",ac.getCost());
            jsonObject1.put("totalnumber",ac.getTotalnumber());
            jsonObjectList.add(jsonObject1);
        }
        jsonObject.put("content",jsonObjectList);
        return jsonObject;
    }
}
