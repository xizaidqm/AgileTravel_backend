package cn.yangdeyu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yangdeyu.bean.User;

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
	
	public void updateUser() {
		
	}

}
