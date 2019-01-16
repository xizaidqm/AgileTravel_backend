package cn.yangdeyu.dao;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yangdeyu.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
	private QueryRunner qr = new TxQueryRunner();
	
	public User findById(String openid) {
		try {
			String sql="select * from users where openid=?";
			return qr.query(sql, new BeanHandler<User>(User.class),openid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void addUser(User user) {
		try {
			String sql="insert into users values(?,?,?,?,?,?,?,?)";
			Object[] params= {user.getOpenid(),user.getNickname(),user.getGender(),user.getCountry(),
								user.getProvince(),user.getCity(),user.getAge(),user.getPhonenumber()};
			qr.update(sql,params);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateUser(User user) {
		try{
			String sql="update users set nickname=?,  phonenumber=? where openid=?";
			qr.update(sql,user.getNickname(),user.getPhonenumber(),user.getOpenid());
		}catch(SQLException e){
			throw  new RuntimeException(e);
		}
	}

}
