package basicjava;

import java.util.Arrays;

public class CCArrays {

	public static void replace(char[] charArray, char toreplace, char replaceWith) {
		for (int i = 0; i < charArray.length; i++) {
	        if (Character.toLowerCase(charArray[i]) == Character.toLowerCase(toreplace)) {
	            charArray[i] = replaceWith;
	        }
	    }
	}
		
	
	public static void sortAlphabetic(String[] strArray) {
		Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);
	}
}
