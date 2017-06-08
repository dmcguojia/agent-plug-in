package cn.com.agent.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * cookie的增加、删除、查询
 */
public class CookieUtils {
	public static final String USER_COOKIE = "user.cookie";

	// 添加一个cookie
	public Cookie addCookie(String clientIp,int count) {
		Cookie cookie = new Cookie(USER_COOKIE, clientIp + "," + count);
		cookie.setMaxAge(60 * 60 * 24 );// cookie保存一天
		return cookie;
	}

	// 得到cookie
	public static String getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		//System.out.println("cookies: " + cookies);
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				//System.out.println("cookie: " + cookie.getName());
				if (CookieUtils.USER_COOKIE.equals(cookie.getName())) {
					String value = cookie.getValue();
					if (StringUtils.isNotBlank(value)) {
						String[] split = value.split(",");
						//String clientIp = split[0];
						String count = split[0];
						//System.out.println(count);
						return count;
					}
				}
			}
		}
		return null;
	}

	// 删除cookie
	public Cookie delCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (USER_COOKIE.equals(cookie.getName())) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					return cookie;
				}
			}
		}
		return null;
	}
}
