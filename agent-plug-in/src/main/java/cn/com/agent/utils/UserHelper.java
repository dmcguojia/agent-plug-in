package cn.com.agent.utils;

import javax.servlet.http.HttpServletRequest;

public class UserHelper {

	public static UserBean getCurrentUser(HttpServletRequest request) {
		return (UserBean) request.getSession().getAttribute("LOGIN_USER");
	}
}
