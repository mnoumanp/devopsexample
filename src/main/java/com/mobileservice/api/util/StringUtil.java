package com.mobileservice.api.util;

import java.util.Random;
import java.util.UUID;

public class StringUtil {
	public static String getUniqueString() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String generateOTP() 
    {
        int len = 4;
        // Using numeric values 
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[len]; 
  
        for (int i = 0; i < len; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        return new String(otp); 
    } 
}
