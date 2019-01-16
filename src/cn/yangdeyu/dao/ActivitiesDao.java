package cn.yangdeyu.dao;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yangdeyu.bean.Activities;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ActivitiesDao {
    private QueryRunner qr = new TxQueryRunner();

    public void addActivities(Activities activities){
        try{
            String sql = "insert into activities values(?,?,?,?,?,?,?,?,?,?,?)";
            Timestamp startTime = new Timestamp(activities.getStarttime().getTime());
            Timestamp endTime = new Timestamp(activities.getEndtime().getTime());
            Object[] params = {activities.getTravelid(),activities.getOpenid(),activities.getCity(),
                                startTime,endTime,activities.getTravelname(),activities.getDescription(),
                                activities.getFlag(),activities.getKind(),activities.getCost(),activities.getTotalnumber()};
            qr.update(sql,params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateActivities(Activities activities){
        try{
            String sql = "update activities set city=?,starttime=?,endtime=?,travelname=?," +
                        " description=?,kind=?,cost=?, totalnumber=? where travelid=?";
            qr.update(sql,activities.getCity(),activities.getStarttime(),
                        activities.getEndtime(),activities.getTravelname(),activities.getDescription(),
                        activities.getKind(),activities.getCost(),activities.getTotalnumber(),activities.getTravelid());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    //取消活动，0表示过期，1表示进行中
    public void cancleActivities(String travelId,int flag){
        try{
            String sql="update activities set flag=? where travelid=?";
            qr.update(sql,flag,travelId);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Activities> findAll(){
        try{
            String sql="select * from activities where flag=1";
            return  qr.query(sql, new BeanListHandler<Activities>(Activities.class));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Activities> findByKind(String kind){
        try{
            String sql="select * from activities where kind=? and flag=1";
            return qr.query(sql,new BeanListHandler<Activities>(Activities.class),kind);
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public List<Activities> findByBlank(String searchString){
        try{
            String sql="select * from activities where city like ?  or travelname like ? and flag=1";
            System.out.println(sql);
            return qr.query(sql,new BeanListHandler<Activities>(Activities.class),searchString,searchString);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Activities> findByOpenid(String openid){
        try{
            String sql="select * from activities where openid=?";
            return qr.query(sql,new BeanListHandler<Activities>(Activities.class),openid);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Activities> findBetweenTime(String starttime,String endtime){
        try{
            String sql="select * from activities where starttime>? and endtime<? and flag=1";
            return qr.query(sql,new BeanListHandler<Activities>(Activities.class),starttime,endtime);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Activities findById(String travelid){
        try{
            String sql="select * from activities where travelid=?";
            return qr.query(sql,new BeanHandler<Activities>(Activities.class),travelid);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
