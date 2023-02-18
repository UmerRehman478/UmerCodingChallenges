package basicjava;

public class CCStringsIfAndWhile {

	public static boolean isDigit(char aChar) {
		// TODO Auto-generated method stub
	    String digits = "0123456789";
	    int i = 0;
	    while (i < digits.length()) {
	        if (aChar == digits.charAt(i)) {
	            return true;
	        }
	        i++;
	    }

		return false;
	}

	public static int count(String str, String chars) {
		// TODO Auto-generated method stub
	    int count = 0;
	    str = str.toLowerCase();
	    chars = chars.toLowerCase();
	    for (int i = 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        for (int j = 0; j < chars.length(); j++) {
	            if (ch == chars.charAt(j)) {
	                count++;
	            }
	        }
	    } 
	    return count;
	}

	public static int smallestDigit(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
