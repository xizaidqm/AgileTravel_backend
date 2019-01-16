package cn.yangdeyu.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.yangdeyu.Exception.UserException;
import cn.yangdeyu.bean.User;
import cn.yangdeyu.myJSONUtils.beanToJSON;
import cn.yangdeyu.service.UserService;
import net.sf.json.JSONObject;

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
	private String failRes = "{\"success\":1, \"content\":0}";

	public String register(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		/*
		 * */
		try{
			User userInfo = CommonUtils.toBean(request.getParameterMap(),User.class);
			userService.addUser(userInfo);
			User findUser = userService.findById(userInfo.getOpenid());
			JSONObject jsonob = beanToJSON.frontJson(JSONObject.fromObject(findUser));
			response.getWriter().write(jsonob.toString());
		}catch(UserException e){
			throw new RuntimeException(e);
		}
		return null;
	}
	public String login(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{

			String userInfo = request.getParameter("userInfo");
			User addInfo = userService.findById(userInfo);
			if(addInfo==null){
				response.getWriter().write(failRes);
				return null;
			}
			JSONObject jsonObject = beanToJSON.frontJson(JSONObject.fromObject(addInfo));
			response.getWriter().write(jsonObject.toString());

		return null;
	}
	
	public String updateInfo(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		/*
		 * */
		User userInfo = CommonUtils.toBean(request.getParameterMap(),User.class);
		User findUser = userService.findById(userInfo.getOpenid());
		if(findUser!=null){
			findUser.setNickname(userInfo.getNickname());
			findUser.setPhonenumber(userInfo.getPhonenumber());
			userService.updateUser(findUser);
			JSONObject jsonb = beanToJSON.frontJson(JSONObject.fromObject(findUser));
			response.getWriter().write(jsonb.toString());
		}else{
			response.getWriter().write(failRes);
		}
		return null;
	}
	
	
}
