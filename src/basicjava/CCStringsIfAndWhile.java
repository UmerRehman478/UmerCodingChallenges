package basicjava;

public class CCStringsIfAndWhile {

	public static boolean isDigit(char aChar) {
		return Character.isDigit(aChar);
	}

	public static int count(String str, String chars) {
		int count = 0;
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
	        if (chars.contains(String.valueOf(str.charAt(i)))) {
	            count++;
	        }
	    }
	    return count;
	}
	

	public static int smallestDigit(int num) {
		if (num < 0) {
			num = num * -1;
		}
		int min = num%10;
		while (num > 0) {
			if(num % 10 < min) {
				min = num % 10;
			}
			num = num/10;
		}
		return min;
	}
}
