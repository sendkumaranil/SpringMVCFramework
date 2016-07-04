package com.springmvcexample.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	
	public static boolean isValidEmail(String email){
		
		String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern=Pattern.compile(EMAIL_PATTERN);
		
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
        //validating phone number with -, . or spaces
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        else return false;
         
    }

}
