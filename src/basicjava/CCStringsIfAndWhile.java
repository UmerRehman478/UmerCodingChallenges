package basicjava;

public class CCStringsIfAndWhile {

	public static boolean isDigit(char aChar) {
		// TODO Auto-generated method stub
		return Character.isDigit(aChar);
	}

	public static int count(String string, String chars) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if(chars.indexOf(c) != -1) {
				count++;
			}
		}
		return count;
	}

	public static int smallestDigit(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
