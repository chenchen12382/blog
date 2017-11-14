package com.chenchen.base;
import com.chenchen.exception.ParamException;
import org.apache.commons.lang3.StringUtils;

public class AssertUtil {

	/**
	 * 对象不能为空
	 * @param value
	 * @param code
	 * @param message
	 */
	public static void notNull(Object value, String... message) {
		if (value == null) {
			throw new ParamException(loadMessage(message));
		}
	}
	
	/**
	 * 对象不能为空
	 * @param value
	 * @param code
	 * @param message
	 */
	public static void notNull(Object value, Integer code, String... message) {
		if (value == null) {
			throw new ParamException(code, loadMessage(message));
		}
	}
	
	/**
	 * 字符串不能为空
	 * @param value
	 * @param code
	 * @param message
	 */
	public static void isNotEmpty(String value, String... message) {
		if (StringUtils.isBlank(value)) {
			throw new ParamException(loadMessage(message));
		}
	}
	
	/**
	 * 字符串不能为空
	 * @param value
	 * @param code
	 * @param message
	 */
	public static void isNotEmpty(String value, Integer code, String... message) {
		if (StringUtils.isBlank(value)) {
			throw new ParamException(code, loadMessage(message));
		}
	}
	
	/**
	 * Integer不能为空
	 * @param value
	 * @param message
	 */
	public static void intIsNotEmpty(Integer value, String... message) {
		isTrue(value == null || value < 1, loadMessage(message));
	}
	
	public static void isTrue(boolean isTrue, String... message) {
		if (isTrue) {
			throw new ParamException(loadMessage(message));
		}
	}
	
	/**
	 * 获取打印消息
	 * @param message
	 * @return
	 */
	private static String loadMessage(String... message) {
		String msg = "";
		if (message == null || message.length == 0 || StringUtils.isBlank(message[0])) {
			msg = Constant.ERROR_MSG;
		} else {
			msg = message[0];
		}
		return msg;
	}
	
	
}
