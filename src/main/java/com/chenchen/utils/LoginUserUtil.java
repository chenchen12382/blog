package com.chenchen.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Tony on 2016/8/23.
 */
public class LoginUserUtil {

	/**
	 * 从cookie中获取userId
	 * @param request
	 * @return
	 */
	public static Integer releaseUserIdFromCookie(HttpServletRequest request) {
		String userIdString = CookieUtil.getCookieValue(request, "userIdString");
		if (StringUtils.isBlank(userIdString)) {
			return null;
		}
		Integer userId = UserIDBase64.decoderUserID(userIdString);
		return userId;
	}

	/**
	 * 从cookie中获取userId
	 * @param request
	 * @return
	 */
	public static String releaseUserNameFromCookie(HttpServletRequest request) {
		String userName = CookieUtil.getCookieValue(request, "userName");
		return userName;
	}

}
