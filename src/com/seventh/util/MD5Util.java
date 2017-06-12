package com.seventh.util;

import java.security.MessageDigest;

public class MD5Util {
	public final static String md5(String password){
		String md5Password;
		if(password.equals("")||password==null)
		{
			md5Password="";
		}
		else
			md5Password=password;
		char hexDigits[]={
				'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
		};
		try{
			byte[] strTemp=md5Password.getBytes();
			MessageDigest mdTemp=MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md= mdTemp.digest();
			int j=md.length;
			char str[] = new char[j*2];
			int k=0;
			for(int i=0;i<j;i++){
				byte byte0 =md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 &0xf];
			}
			return new String(str);
		}
		catch(Exception e){
			return null;
		}
	}
}
