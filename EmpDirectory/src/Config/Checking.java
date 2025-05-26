package Config;

import java.util.Vector;

public class Checking {
    // Method to check if a string is empty or contains only whitespaces
    public static boolean isEmptyOrWhitespace(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Method to validate phone number format (basic validation)
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10}");  // Assuming 10 digits for phone numbers
    }
    
    public static boolean IsAllDigit(String str) {
	    for(int i=0; i<str.length(); i++) {
	    	if(Character.isLetter(str.charAt(i))) {
	    		return true;   	
	    }
	}
	   	return false;
	}
	
	public static boolean IsContain(String s,Vector str) {
		for(int i=0; i<str.size(); i++) {
			if(s.equals((String)str.elementAt(i))) {
				return true;
			}
			
		}
		return false;
	}
	public static boolean IsValidName(String str) {
		if(Character.isSpace(str.charAt(0))) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean IsEmailformat(String str) {
		boolean b = false;
		int dot = str.lastIndexOf(".");
		int at = str.indexOf("@");
		if((dot<0) || (at <0) ||(str.indexOf(" ")>0)) {
			return b;
		}
		String st = str.substring(0,at);
		String st1 = str.substring(dot+1);
		if(!st.trim().equals("")&&(st1.equals("com"))) {
			b = true;
			return b;
		}else {
			return b;
		}
		
	}
	
	
	public static boolean isPhoneNo(String str) {
		if(str !=null && str.length()<=11) {
			return str.startsWith("09");
		}
		return false;
	}



	
	
	
	
	
	
	public static boolean isValidNRC(String nrc) {
       
      String nrcPattern = "\\d{1,2}/[A-Za-z]+\\([NA]\\)\\d{6}";

        return nrc.matches(nrcPattern);
    }
}	