package cn.yangdeyu.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.yangdeyu.bean.Activities;
import cn.yangdeyu.bean.AttendList;
import cn.yangdeyu.bean.peopleAttend;
import cn.yangdeyu.dao.ActivitiesDao;
import cn.yangdeyu.dao.AttendListDao;
import cn.yangdeyu.dao.UserDao;
import cn.yangdeyu.myJSONUtils.listToJSON;
import cn.yangdeyu.service.ActivitiesService;
import cn.yangdeyu.service.AttendListService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ActivitiesServlet")
public class ActivitesServlet extends BaseServlet
{
    private ActivitiesService activitiesService = new ActivitiesService();
    private String failRes = "{\"success\":1, \"content\":0}";

    public String ReleaseInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        Activities activities = CommonUtils.toBean(request.getParameterMap(),Activities.class);
        activities.setTravelid(CommonUtils.uuid());
        activities.setFlag(1);
        String context = activities.getDescription();
        activitiesService.ReleaseInfo(activities);
        /* 添加至AttendList表中
        * */
        AttendList attendList = new AttendList(activities,new UserDao().findById(activities.getOpenid()));
        new AttendListDao().add(attendList);

        JSONObject jsonb = JSONObject.fromObject(activities.toString());
        response.getWriter().write(jsonb.toString());
        return null;
    }

    public String ModifyInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Activities activities = CommonUtils.toBean(request.getParameterMap(),Activities.class);
        Activities findActivities = new ActivitiesDao().findById(activities.getTravelid());
        if(findActivities!=null){
            activitiesService.ModifyInfo(activities);
            findActivities = new ActivitiesDao().findById(activities.getTravelid());
            JSONObject jsonObject = JSONObject.fromObject(findActivities.toString());
            response.getWriter().write(jsonObject.toString());
        }else{
            response.getWriter().write(failRes);
        }
        return null;
    }

    public String CancleActivity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String travelid=request.getParameter("travelid");
        activitiesService.CancleActivity(travelid);
        response.getWriter().write(failRes);
        return null;
    }


    public String ViewAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<Activities> activityList = activitiesService.ViewAll();
        JSONObject jsonObject = new listToJSON().ActivityJSONList(activityList);
        response.getWriter().write(jsonObject.toString());
        return null;
    }

    public String ViewDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String travelid = request.getParameter("travelid");
        String openid = request.getParameter("openid");

        peopleAttend peopleAttend = new AttendListService().isInActivity(travelid,openid);

        if(peopleAttend != null){
            response.getWriter().write( "{\"success\":1, \"content\":1}");
        }else{
            response.getWriter().write("{\"success\":1, \"content\":0}");
        }
        return null;

    }

//    public String ViewTimeBetween(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException{
//        String starttime=request.getParameter("starttime");
//        String endtime=request.getParameter("endtime");
//        List<Activities> activityList = activitiesService.ViewTimeBetween(starttime,endtime);
//        JSONObject jsonObject = new listToJSON().ActivityJSONList(activityList);
//        if(jsonObject!=null){
//            response.getWriter().write(jsonObject.toString());
//        }else{
//            response.getWriter().write(failRes);
//        }
//        return null;
//    }

    public String ViewBlank(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String searchString = request.getParameter("searchString");
        searchString = "%"+searchString+"%";
        List<Activities> activityList = activitiesService.ViewBlank(searchString);
        JSONObject jsonObject = new listToJSON().ActivityJSONList(activityList);
        if(jsonObject!=null){
            response.getWriter().write(jsonObject.toString());
        }else {
            response.getWriter().write(failRes);
        }
        return null;
    }

    public String ViewMyRelease(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String openid = request.getParameter("openid");
        List<Activities> activityList = activitiesService.ViewMyRelease(openid);
        JSONObject jsonObject = new listToJSON().ActivityJSONList(activityList);
        response.getWriter().write(jsonObject.toString());
        return null;
    }

}
