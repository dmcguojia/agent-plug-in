package cn.com.agent.utils;

import javax.servlet.http.HttpServletRequest;

import cn.com.agent.pojo.UserDO;

public class UserHelper {

	public static UserDO getCurrentUser(HttpServletRequest request) {
		return (UserDO) request.getSession().getAttribute("login_user");
	}
}
