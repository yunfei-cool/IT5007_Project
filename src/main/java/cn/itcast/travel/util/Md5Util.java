package cn.itcast.travel.util;

import java.security.MessageDigest;

/**
 * 写一个MD5算法,运行结果与MySQL的md5()函数相同
 * 将明文密码转成MD5密码
 * 123456->e10adc3949ba59abbe56e057f20f883e
 */
public final class Md5Util {
	private Md5Util(){}
	/**
	 * converted to an MD5 password
	 */
	public static String encodeByMd5(String password) throws Exception{

		MessageDigest md5 = MessageDigest.getInstance("MD5");
		//Invokes the MD5 algorithm, which returns 16 byte values
		byte[] byteArray = md5.digest(password.getBytes());
		return byteArrayToHexString(byteArray);
	}
	/**
	 * Converts byte[] to a hexadecimal string
	 */
	private static String byteArrayToHexString(byte[] byteArray) {
		StringBuffer sb = new StringBuffer();
		//loop
		for(byte b : byteArray){//16 times
			//Take each byte type and convert it
			String hex = byteToHexString(b);
			//Put the converted value into a StringBuffer
			sb.append(hex);
		}
		return sb.toString();
	}
	/**
	 * Converts byte to a hexadecimal string
	 */
	private static String byteToHexString(byte b) {
		//convert to int
		int n = b;
		//negative
		if(n < 0){
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hex[d1] + hex[d2];
	}
	private static String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	/**
	 * test
	 */
	public static void main(String[] args) throws Exception{
		String password = "123456";
		String passwordMD5 = Md5Util.encodeByMd5(password);
		System.out.println(password);
		System.out.println(passwordMD5);
	}
}
