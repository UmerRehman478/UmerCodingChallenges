package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GradeCalculatorController {

    @FXML
    private ChoiceBox<Integer> optionalCodingChallengesPassedChoiceBox;

    @FXML
    private Slider quizSlider;

    @FXML
    private TextField projectGradeTextfield;

    @FXML
    private ChoiceBox<Integer> codingChallengesPassedChoiceBox;
    
    @FXML
    private Label courseGradeLabel; 

    @FXML
    void calculateGrade(ActionEvent event) {
    	double courseGrade = 0.0;
    	
    	String projectGrade = projectGradeTextfield.getText();
    	courseGrade = courseGrade + Double.parseDouble(projectGrade) * 50 / 100;
    	System.out.println("Project grade entered: " + projectGrade + 
    			" Course grade so far: " + courseGrade);
    	
    	
    	double quizGrade = quizSlider.getValue();
    	courseGrade += (quizGrade * 100 / 10) * .25;
    	System.out.println("Quiz grade entered: " + quizGrade + 
    			" Course grade so far: " + courseGrade);
    	
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
