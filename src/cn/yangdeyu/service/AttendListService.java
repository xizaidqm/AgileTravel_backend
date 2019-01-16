package cn.yangdeyu.service;

import cn.yangdeyu.bean.AttendList;
import cn.yangdeyu.bean.peopleAttend;
import cn.yangdeyu.dao.AttendListDao;

public class AttendListService {
    private AttendListDao attendListDao = new AttendListDao();

    public void attendActivity(AttendList attendList){
        attendListDao.add(attendList);
    }

    public void quitActivity(AttendList attendList){
        attendListDao.delete(attendList);
    }

    public peopleAttend isInActivity(String travelid, String openid){
        return attendListDao.findById(travelid,openid);
    }
}
