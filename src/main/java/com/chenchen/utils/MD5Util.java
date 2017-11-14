package com.chenchen.utils;

import java.security.MessageDigest;

public class MD5Util {

    /**
     * md5加密
     * @param str
     * @return
     */
	public static String md5Method(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(str.getBytes("UTF-8"));
			byte[] byteArray = md.digest();

			StringBuffer md5StrBuff = new StringBuffer();

			for (int i = 0; i < byteArray.length; i++)
			{
				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
					md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
				else
					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
			return md5StrBuff.toString();
		}
		catch (Exception e) {
			return "";
		}
	}
}
