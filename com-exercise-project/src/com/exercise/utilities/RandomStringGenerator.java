package com.exercise.utilities;

import java.security.SecureRandom;

public class RandomStringGenerator {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public String randomString(int len){
	   StringBuilder sb = new StringBuilder(len);
	   for(int i = 0; i < len; i++) 
	      sb.append(AB.charAt(rnd.nextInt(AB.length())));
	   return sb.toString();
	}
}