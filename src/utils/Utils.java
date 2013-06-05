package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Utils {
	public static String MungPass(String pass) {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			byte[] data = pass.getBytes();
			m.update(data, 0, data.length);
			BigInteger i = new BigInteger(1, m.digest());
			return String.format("%1$032X", i);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return "******";
	}
	
	public static void main(String[] args) {
		String str = "2013-06-04 00:00:45";
		System.out.println(Timestamp.valueOf(str));
	}
}
