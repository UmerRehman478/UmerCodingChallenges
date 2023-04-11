package application;

/**
 * Calculate grade for course
 * @author CS219-user
 */
public class Grade {
	//attributes/data
	double value;
	/**
	 * weight of grade
	 */
	double weight;
	/**
	 * max value for a grade
	 */
	int maxValue = 100; 
	
	/**
	 * creates a grade
	 * @param gradeValue numeric value of grade
	 * @param maxGradeValue the max grade value
	 * @param weightTowardsCourseGrade the weight of the grade
	 * 
	 */
	//Constructor method
	Grade(String gradeValue, int maxGradeValue, double weightTowardsCourseGrade) throws InvalidGradeException{
		/*value = gradeValue;
		maxValue = maxGradeValue;
		weight = weightTowardsCourseGrade;*/
		
	       try {
	            value = Double.parseDouble(gradeValue);
	        } catch (NumberFormatException e) {
	            // If an error is detected in the conversion, throw an InvalidGradeException
	            throw new InvalidGradeException("Grade should be a number. Invalid grade: " + gradeValue);
	        }
	        
	        // Set the other instance variables
	        maxValue = maxGradeValue;
	        weight = weightTowardsCourseGrade;

	        // Handle input validations
	        if (value < 0 || value > maxValue) {
	            throw new InvalidGradeException(String.format("Grade should be between 0 and %d. Invalid grade: %.02f", maxValue, value));
	        }
		


	}

	public Grade(double d, int maxGradeValue, double weightTowardsCourseGrade) { 
		// TODO Auto-generated constructor stub
	    value = d;
	    maxValue = maxGradeValue;
	    weight = weightTowardsCourseGrade;
	}

	/**
	 * gets and calculates the weight percentage value of the grade
	 * @return weighted percentage value 
	 */
	//Used to calculate weighted percentage value
	double getWeightedPercentageValue() {
		return value * 100 * weight / maxValue;
	}

	
	/**
	 * method to set values and handle input validations
	 * @param valueAsString the string value of the grade
	 * @return an error message if the user has a wrong input
	 */
	//actions	
	/*String setValue(String valueAsString) {
		String errorMessage = ""; // Start with assuming no error
	
	   	// Check that the user entered a numeric value
    	boolean validGrade = true;
    	boolean singalDecimalPoint = false;
    	//For loop through each character in string 
    	for (char c : valueAsString.toCharArray()) {
    		// Any character is not a digit, set flag to false: it is not a number 
    		if (!Character.isDigit(c)) {
    			// Checking if the character is a digit or not
    			if (c == '.' && !singalDecimalPoint && valueAsString.indexOf(c) == valueAsString.lastIndexOf(c)) {
    				singalDecimalPoint = true;
    			} else {
    			validGrade = false;
    			errorMessage = "Dont include the character: " + c +
    					". Grade should be a number. ";
    		}
    		}
    	}
    	
    	//ValidGrade
    	if (validGrade) {
    		value = Double.parseDouble(valueAsString);
    	}
    	
    	//User enters in a number <0 or >maxValue which is 10
    	if (value < 0 || value > maxValue) {
    		errorMessage = String.format("Grade should be between 0 and %d. "
    				+ " Invalid grade: %.02f", maxValue, value);
    		value = 0;
    	} 
    	
    	return errorMessage;
    	
	}*/
 
	

}
