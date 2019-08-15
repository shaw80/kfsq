package com.jzhl.kfsq.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringEncrypt {
	/**
	 * 对字符串加密,加密算法使用MD5,SHA-1,SHA-256,默认使用SHA-256
	 * 
	 * @param strSrc
	 *            要加密的字符串
	 * @param encName
	 *            加密类型
	 * @return
	 */
	public static String encrypt(String strSrc, String encName) {

		MessageDigest md = null;
		String strDes = null;

		try {
			byte[] bt = strSrc.getBytes("UTF-8");
			md = MessageDigest.getInstance(encName);
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			return null;
		} catch (UnsupportedEncodingException e) {
			return null;
		}

		return strDes;

	}
	
	public static String MD5(String strSrc) {
		
		if (ValidateUtil.isEmpty(strSrc)) {
			return null;
		}
		
		return encrypt(strSrc + "XXWuHH", "MD5");
		
	}
	
	public static String encrypt(String strSrc) {
		return encrypt(strSrc, "SHA-256");
	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	public static void main(String args[]) {
		
		String md51 = encrypt("123456", "MD5");
		System.out.println(md51);
		String md52 = MD5(md51);
		System.out.println(md52);
	}
}
