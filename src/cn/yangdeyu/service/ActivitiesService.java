package cn.yangdeyu.service;

import cn.yangdeyu.bean.Activities;
import cn.yangdeyu.dao.ActivitiesDao;

import java.util.List;

public class ActivitiesService {
    private ActivitiesDao activitiesDao = new ActivitiesDao();

    public void ReleaseInfo(Activities activities){
         activitiesDao.addActivities(activities);
         /*
         * 此处在发布信息之后，需要在attendlist表中添加相应记录？？
         * */
    }

    public void ModifyInfo(Activities activities){
            activitiesDao.updateActivities(activities);
    }

    public void CancleActivity(String tavelId){
        //0代表失效，1代表进行中
        activitiesDao.cancleActivities(tavelId,0);
    }

    public List<Activities> ViewAll(){

        return activitiesDao.findAll();
    }

    public List<Activities> ViewBlank(String searchString){
        return activitiesDao.findByBlank(searchString);
    }

    public List<Activities> ViewMyRelease(String openid){
        return activitiesDao.findByOpenid(openid);
    }
    public List<Activities> ViewTimeBetween(String starttime, String endtime){
        return activitiesDao.findBetweenTime(starttime,endtime);
    }

    public Activities ViewDetail(String travelid){

        return activitiesDao.findById(travelid);
    }
}
