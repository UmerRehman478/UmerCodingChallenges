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

	public static int count(String string, String chars) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public static int smallestDigit(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
