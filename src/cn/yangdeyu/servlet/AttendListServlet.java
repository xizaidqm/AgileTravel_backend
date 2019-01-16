package cn.yangdeyu.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.yangdeyu.bean.Activities;
import cn.yangdeyu.bean.AttendList;
import cn.yangdeyu.bean.User;
import cn.yangdeyu.bean.peopleAttend;
import cn.yangdeyu.dao.AttendListDao;
import cn.yangdeyu.myJSONUtils.beanToJSON;
import cn.yangdeyu.service.ActivitiesService;
import cn.yangdeyu.service.AttendListService;
import cn.yangdeyu.service.UserService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AttendListServlet")
public class AttendListServlet extends BaseServlet {
    private AttendListService attendListService = new AttendListService();
    private String failRes = "{\"success\":1, \"content\":0}";

    public String AttendActivity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String openid=request.getParameter("openid");
        String travelid = request.getParameter("travelid");
        peopleAttend peopleAttend = new AttendListDao().findById(travelid,openid);

        if(peopleAttend !=null){
            response.getWriter().write(failRes);
        }else{
            User user = new UserService().findById(openid);
            Activities activities = new ActivitiesService().ViewDetail(travelid);
            AttendList attendList = new AttendList(activities,user);
            //插入数据库
            attendListService.attendActivity(attendList);
            JSONObject jsonObject = JSONObject.fromObject(peopleAttend);
            response.getWriter().write( beanToJSON.frontJson(jsonObject).toString());
        }
        return null;
    }

    public String QuitActivity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String openid=request.getParameter("openid");
        String travelid = request.getParameter("travelid");
        peopleAttend peopleAttend = new AttendListDao().findById(travelid,openid);

        if(peopleAttend !=null){
            User user = new UserService().findById(openid);
            Activities activities = new ActivitiesService().ViewDetail(travelid);
            AttendList attendList = new AttendList(activities,user);
            attendListService.quitActivity(attendList);
            response.getWriter().write("{\"success\":1,\"content\":1}");
        }else{
            response.getWriter().write(failRes);
        }
        return null;
    }
}
