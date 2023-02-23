package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GradeCalculatorController {
	Stage applicationStage;
	double averageQuizGrade = 0.0;
	double optionalaverageQuizGrade = 0.0;

    @FXML
    private ChoiceBox<Integer> optionalCodingChallengesPassedChoiceBox;

    @FXML
    private ChoiceBox<Integer> quizzesChoiceBox;
    
    @FXML
    private Label requiredQuizGrade;
    
    @FXML
    private ChoiceBox<Integer> optionalQuizzesChoiceBox;
    
    @FXML
    private Label optionalQuizGrade;

    @FXML
    private TextField projectGradeTextfield;

    @FXML
    private ChoiceBox<Integer> codingChallengesPassedChoiceBox;
    
    @FXML
    private Label courseGradeLabel; 
    
    @FXML
    private Label projectGradeErrorLabel;
    
    /**
     * Checks if the value provided is a valid project grade. A project grade must be numeric and 
     * a percentage (between 0 and 100). If valid, the equivalent double is returned, if not, this method returns zero.
     *   
     * @param valueEntered the value entered as the project grade 
     * @return the double value of valueEntered if it is numeric and a valid percentage and 0 otherwise.
     */
    double getProjectGrade(String valueEntered) {
    	// Check that the user entered a numeric value
    	boolean validProjectGrade = true;
    	boolean singalDecimalPoint = false;
    	//For loop through each character in string 
    	for (char c : valueEntered.toCharArray()) {
    		// If any character is not a digit, set flag to false: it is not a number 
    		if (!Character.isDigit(c)) {
    			// Checking if the character is a digit or not
    			if (c == '.' && !singalDecimalPoint && valueEntered.indexOf(c) == valueEntered.lastIndexOf(c)) {
    				singalDecimalPoint = true;
    			} else {
    			validProjectGrade = false;
    			projectGradeErrorLabel.setText("Dont include the character: " + c +
    					". Project grade should be percentage. ");
    		}
    		}
    	}
    	/* Default project grade to 0. If valid number entered, convert user input to 
    	 * floating point number.
    	 */ 
    	double projectGrade = 0;
    	if (validProjectGrade) {
    		projectGrade = Double.parseDouble(valueEntered);
    	}
    	
    	// Check if projectGrade is a valid percentage grade. If not, reset to default grade of 0.
    	if (projectGrade < 0 || projectGrade > 100) {
    		projectGradeErrorLabel.setText("Project grade should be between 0% and 100%. Invalid project grade: " 
    				+ projectGrade);
    		projectGrade = 0;
    	} 
    	
    	return projectGrade;
    }
    
    void calculateQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextfields) {
    	averageQuizGrade = 0.0;
    	for (TextField textfield : quizGradeTextfields) {
        	averageQuizGrade += Double.parseDouble(textfield.getText());
    	}

    	averageQuizGrade = averageQuizGrade / 15;
    	//requiredQuizGrade.setText(String.format("Average: %.2f/10", averageQuizGrade));
    	applicationStage.setScene(mainScene);
    	requiredQuizGrade.setText(String.format("Average: %.2f/10", averageQuizGrade));


    }
    
    @FXML
    void getQuizGrades(ActionEvent enterQuizGradesEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	int numberOfQuizzes = quizzesChoiceBox.getValue();
    	int rowCounter = 0;
    	VBox allRows = new VBox();
    	ArrayList<TextField> quizTextFields = new ArrayList<TextField>();
    	while(rowCounter < numberOfQuizzes) {
    		rowCounter++;
        	HBox quizRow = new HBox();
        	Label requiredQuizTitle = new Label("Required quiz grade");
        	
        	Label quizLabel = new Label("Quiz" + rowCounter + " grade");
        	TextField quizGradeTextfield = new TextField();
        	quizTextFields.add(quizGradeTextfield);
   
        	quizRow.getChildren().addAll(quizLabel,quizGradeTextfield,requiredQuizTitle);    	
    		allRows.getChildren().add(quizRow);
    	}
    	
    	Button doneButton = new Button("Done");
        doneButton.setOnAction(doneEvent -> calculateQuizGrade(mainScene, quizTextFields));
        allRows.getChildren().add(doneButton);
    	
    	Scene quizScene = new Scene(allRows);
    	applicationStage.setScene(quizScene);
    	
    }
    
    
    
    void calculateoptionalQuizGrade(Scene mainScene, ArrayList<TextField> optionalquizTextFields) {
    	optionalaverageQuizGrade = 0.0;
    	for (TextField textfield : optionalquizTextFields) {
    		optionalaverageQuizGrade += Double.parseDouble(textfield.getText());

    	}
    	
    	optionalaverageQuizGrade = optionalaverageQuizGrade / 5;
    	optionalQuizGrade.setText(String.format("Average: %.2f/10", optionalaverageQuizGrade));
    	applicationStage.setScene(mainScene);
    }
    
    @FXML
    void getoptionalQuizGrades(ActionEvent enteroptionalQuizGradesEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	int numberOfoptionalQuizzes = optionalQuizzesChoiceBox.getValue();
    	int rowCounter = 0;
    	VBox optionalquizGrade = new VBox();
    	ArrayList<TextField> optionalquizTextFields = new ArrayList<TextField>();
    	while(rowCounter < numberOfoptionalQuizzes) {
    		rowCounter++;
        	HBox quizRow = new HBox();
        	Label optionalQuizTitle = new Label("Optional quiz grade");
        	
        	Label quizLabel = new Label("Quiz" + rowCounter + " grade");
        	TextField optionalquizGradeTextfield = new TextField();
        	optionalquizTextFields.add(optionalquizGradeTextfield);
   
        	quizRow.getChildren().addAll(quizLabel,optionalquizGradeTextfield,optionalQuizTitle);    	
        	optionalquizGrade.getChildren().add(quizRow);
    	}
    	
    	Button optionaldoneButton = new Button("Done");
    	optionaldoneButton.setOnAction(doneEvent -> calculateoptionalQuizGrade(mainScene, optionalquizTextFields));
        optionalquizGrade.getChildren().add(optionaldoneButton);
    	
    	Scene quizScene = new Scene(optionalquizGrade);
    	applicationStage.setScene(quizScene);
    }
    /**
     * Checks and calculates the overall course grade based on the project grade, quiz grade, 
     * coding challenges passed, and optional coding challenges passed.
     * @param event when the calculateGrade button is pressed a action occurs, which triggers the calculation of the course grade. 
     */

    @FXML
    void calculateGrade(ActionEvent event) {
    	projectGradeErrorLabel.setText("");
    	double courseGrade = 0.0;
    	
    	String projectValueEntered = projectGradeTextfield.getText();
    	
    	// Check if user entered a percentage grade. IF not, display error message
    	double projectGrade  = getProjectGrade(projectValueEntered);
    	courseGrade = courseGrade + projectGrade * 50 / 100;
    	System.out.println("Project grade entered: " + projectGrade + 
    			" Course grade so far: " + courseGrade);
    	
    	double quizGrade = (((averageQuizGrade)*10)*0.1875);
    	double optionalquizGrade = (((optionalaverageQuizGrade)*10)*0.0625);
    	courseGrade = courseGrade + (((quizGrade)+(optionalquizGrade)));
    	System.out.println("Quiz grade: " + courseGrade);
    	
    	
    	int codingChallengesPassed = codingChallengesPassedChoiceBox.getValue();
    	courseGrade += (codingChallengesPassed * 1.25);
    	System.out.println("Coding challenges passed: " + codingChallengesPassed + 
    			" Course grade so far: " + courseGrade);
    	int optionalcodingChallengesPassed = optionalCodingChallengesPassedChoiceBox.getValue();
    	courseGrade += (optionalcodingChallengesPassed * 1.25);
    	System.out.println("Optional coding challenges passed: " + optionalcodingChallengesPassed + 
    			" Course grade so far: " + courseGrade);
    	
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
    	

    }

}
