package basicjava;

import java.util.ArrayList;

public class CCArrayList {

	public static int indexOfIgnoreCase(ArrayList<String> strs, String toFind) {
		for (int i = 0; i < strs.size(); i++) {
	        String str = strs.get(i);
	        if (str.equalsIgnoreCase(toFind)) {
	            return i;
	        }
	    } 
		return -1;
	}

	public static void insert(ArrayList<Double> nums, double numToInsert, int insertAtIndex) {
		if (insertAtIndex >= 0 && insertAtIndex <= nums.size()) {
	        nums.add(insertAtIndex, numToInsert);
	    }		
	}
	

	
	
	
}
