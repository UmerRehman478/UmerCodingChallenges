package application;

import java.util.ArrayList;
import java.util.Arrays;

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
    
    @FXML
    private Label quizGradeErrorLabel;
    
    @FXML
    private Label optquizGradeErrorLabel;
    

    void calculateQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextfields) {
    	quizGradeErrorLabel.setText("");
    	averageQuizGrade = 0.0;
    	boolean noErrors = true;
    	double weightOfEachQuiz = 1.0/15;
    	for (TextField textfield : quizGradeTextfields) {
    		//Grade quizGrade;
			try {
				quizGrade = new Grade(0, 10, weightOfEachQuiz);
			} catch (InvalidGradeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} 
    		String errorMessage = quizGrade.setValue(textfield.getText());
    		//InvalidGradeException errorMessage = new InvalidGradeException("A");
    		if (!errorMessage.equals("")) {
    			noErrors = false;
    			quizGradeErrorLabel.setText(errorMessage);
    		}
        	averageQuizGrade += quizGrade.getWeightedPercentageValue();
    	}
    	if(noErrors) {
    	applicationStage.setScene(mainScene);
    	requiredQuizGrade.setText(String.format("Average: %.2f%%", averageQuizGrade));
    	}
    	System.out.println(averageQuizGrade);
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
    	
    	
    	quizGradeErrorLabel = new Label();
    	allRows.getChildren().add(quizGradeErrorLabel);
        
    	Scene quizScene = new Scene(allRows);
    	applicationStage.setScene(quizScene);
    	
    }
    
    void calculateoptionalQuizGrade(Scene mainScene, ArrayList<TextField> optionalquizTextFields) {
    	optquizGradeErrorLabel.setText("");
    	optionalaverageQuizGrade = 0.0;
    	boolean noErrors = true;
    	double weightOfEachoptQuiz = 1.0/5;
    	
    	Double[] arrayTexts = new Double[7];
    	Arrays.fill(arrayTexts, 0.0);
    	int i = 0;
                
        for (TextField textfield : optionalquizTextFields) {
            Grade optionalquizGrade = new Grade(0, 10, weightOfEachoptQuiz); 
            String errorMessage = optionalquizGrade.setValue(textfield.getText());
            if (!errorMessage.equals("")) {
                noErrors = false;
                optquizGradeErrorLabel.setText(errorMessage);
            } 
            arrayTexts[i] = Double.parseDouble(textfield.getText());
            i++;            
        }

        if(noErrors) {
        	Arrays.sort(arrayTexts);   
        	for (int j = 6; j > 1; j--) {
        		optionalaverageQuizGrade += arrayTexts[j] * 10;

            //Remove the two lowest grades
            if (optionalquizTextFields.size() == 6) {
            	optionalquizTextFields.remove(0);
            } 
            
            if (optionalquizTextFields.size() == 7) {
            	optionalquizTextFields.remove(0);
            	optionalquizTextFields.remove(1);
            }
            
        	}
            optionalaverageQuizGrade = optionalaverageQuizGrade / (5);
            
            optionalQuizGrade.setText(String.format("Average: %.2f%%", optionalaverageQuizGrade));
            applicationStage.setScene(mainScene);
        }
        System.out.println(optionalaverageQuizGrade);
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
        
        optquizGradeErrorLabel = new Label();
        optionalquizGrade.getChildren().add(optquizGradeErrorLabel);
    	
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
    	
    	Grade projectGrade = new Grade(0, 100, .5);
    	projectGradeErrorLabel.setText(projectGrade.setValue(projectGradeTextfield.getText()));
    	
    	Grade quizGrade = new Grade(averageQuizGrade, 100, .1875);
    	
    	Grade optionalquizGrade = new Grade(optionalaverageQuizGrade, 100, .0625);
    	
    	Grade codingChallengesPassed = new Grade(codingChallengesPassedChoiceBox.getValue(), 100, 1.25);
    	
    	Grade optionalcodingChallengesPassed = new Grade(optionalCodingChallengesPassedChoiceBox.getValue(), 100, 1.25);
    	
    	
    	// Check if user entered a percentage grade. IF not, display error message
    	//double projectGrade  = getProjectGrade(projectValueEntered);
    	courseGrade = projectGrade.getWeightedPercentageValue() +
    			quizGrade.getWeightedPercentageValue() +
    			optionalquizGrade.getWeightedPercentageValue() +
    			codingChallengesPassed.getWeightedPercentageValue() +
    			optionalcodingChallengesPassed.getWeightedPercentageValue();
    	
    	// Display result of calculation to the user in the window 
    	//Display result to two digits after decimal point
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
    	

    }

}
