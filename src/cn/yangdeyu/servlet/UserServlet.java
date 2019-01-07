package cn.yangdeyu.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.yangdeyu.Exception.UserException;
import cn.yangdeyu.bean.User;
import cn.yangdeyu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	
	private UserService userService = new UserService();
	
	public String login(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		/*
		 * */
		try {
			String userInfo = request.getParameter("userInfo");
//			JSONObject jsonObj = JSONObject.fromObject(userInfo);
//			User addInfo = (User) jsonObj.toBean(jsonObj, User.class);
			System.out.println(userInfo);
			System.out.println(request.getParameterMap());
			User addInfo = CommonUtils.toBean(request.getParameterMap(), User.class);
			userService.addUser(addInfo);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(us.toString());
//		JSONObject usera = JSONObject.fromObject(us);
//		System.out.println(usera.toString());
		return null;
	}
	
	public String updateInfo(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		/*
		 * */

		return null;
	}
	
	
}
