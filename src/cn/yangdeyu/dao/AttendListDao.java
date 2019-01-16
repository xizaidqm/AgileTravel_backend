package cn.yangdeyu.dao;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yangdeyu.bean.AttendList;
import cn.yangdeyu.bean.peopleAttend;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AttendListDao {
    private QueryRunner qr = new TxQueryRunner();

    public void add(AttendList attendList){
        try {
            String sql = "insert into attendlist values(?,?,?)";
            Object[] params = {attendList.getActivities().getTravelid(), attendList.getUser().getOpenid(),
                    attendList.getComment()};
            qr.update(sql, params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(AttendList attendList){
        try{
            String sql="delete from attendlist where travelid=? and openid=?";
            qr.update(sql,attendList.getActivities().getTravelid(),attendList.getUser().getOpenid());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public peopleAttend findById(String travelid, String openid){
        try{
            String sql="select * from attendlist where travelid=? and openid=?";
            return qr.query(sql,new BeanHandler<peopleAttend>(peopleAttend.class),travelid,openid);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
