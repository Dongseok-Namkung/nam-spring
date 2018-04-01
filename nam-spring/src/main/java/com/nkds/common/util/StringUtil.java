package com.nkds.common.util;

public class StringUtil {
	public static boolean isNull(String str) {
		return null == str;
	}
	
	public static boolean isEmpty(String str) {
		return null == str || "".equals(str);
	}
	
	public static String nvl(String orgnStr, String destStr) {
		return null == orgnStr ? destStr : orgnStr;
	}
}
