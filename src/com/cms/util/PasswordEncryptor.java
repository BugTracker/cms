package com.cms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {
	public static String encryptPassword(String password) throws NoSuchAlgorithmException{
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte [] bs;
		messageDigest.reset();
		bs = messageDigest.digest(password.getBytes());
			
		StringBuilder stringBuilder = new StringBuilder();
			
		//hex encode the digest
		for(int i = 0; i < bs.length; i++){
			String hexVal = Integer.toHexString(0xFF & bs[i]);
			if (hexVal.length() == 1)
				stringBuilder.append("0");
			stringBuilder.append(hexVal);
		}
			
		return stringBuilder.toString();
	}
}
