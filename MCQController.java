package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class MCQController {
    @FXML
    private Label questionLabel;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private RadioButton option4;
    @FXML
    private Button showResultButton;

    @FXML
    private Label resultLabel;
    @FXML Button nextButton;

    private ToggleGroup toggleGroup = new ToggleGroup();

    private int currentQuestionIndex = 0;
    private MCQ[] mcqs;

    public void initialize() {
        option1.setToggleGroup(toggleGroup);
        option2.setToggleGroup(toggleGroup);
        option3.setToggleGroup(toggleGroup);
        option4.setToggleGroup(toggleGroup);

        mcqs = new MCQ[] {
                new MCQ("Q1. C++ is ___ language?", new String[]{"a)procedural", "b) OOP", "c) both", "d) NOT"}, 1),
                new MCQ("Q2. Who is the father of C language?", new String[]{"a) Steve Jobs", "b) James Gosling", "c) Dennis Ritchie", "d) Rasmus Lerdorf"}, 2),
                new MCQ("Q3. Which of the following is not a valid C variable name?", new String[]{"a) int number;", "b) float rate;", "c) int variable_count;", "d) int $main"}, 3),
                new MCQ("Q4. All keywords in C are in ____________", new String[]{"a) LowerCase letters", "b) UpperCase letters", "c) CamelCase letters", "d) None of the mentioned"}, 0),
                new MCQ("Q5. Which is valid C expression?", new String[]{"a) int my_num = 100,000;", "b) int my_num = 100000;", "c) int my num = 1000;", "d) int $my_num = 10000;"}, 1),
                new MCQ("Q6. Which of the following cannot be a variable name in C?", new String[]{"a) volatile", "b) true", "c) friend", "d) export"}, 1),
                new MCQ("Q7. What is short int in C programming?", new String[]{"a) The basic data type of C", "b) Qualifier", "c) Short is the qualifier and int is the basic data type", "d) All of the mentioned"}, 0),
                new MCQ("Q8. Which of the following declaration is not supported by C language?", new String[]{"a) String str;", "b) char *str;", "c) float str = 3e2;", "d) Both “String str;"}, 0),
                new MCQ("Q9. Which keyword is used to prevent any changes in the variable within a C program?", new String[]{"a) immutable", "b) mutable", "c) const", "d) volatile"}, 2),
                new MCQ("Q10. Which of the following typecasting is accepted by C language?", new String[]{"a) Widening conversions", "b) Narrowing conversions", "c) Widening & Narrowing conversions", "d) None of the mentioned"}, 2),
        };

        showQuestion();
    }

    @FXML
    private void onNextButtonClicked() {
        int selectedOptionIndex = getSelectedOptionIndex();
        mcqs[currentQuestionIndex].setSelectedOptionIndex(selectedOptionIndex);
        currentQuestionIndex++;

        if (currentQuestionIndex < mcqs.length) {
            showQuestion();
        } else {
            int correctAnswers = calculateCorrectAnswers();
            questionLabel.setVisible(false);
            option1.setVisible(false);
            option2.setVisible(false);
            option3.setVisible(false);
            option4.setVisible(false);
            showResultButton.setVisible(false);
            nextButton.setVisible(false);
            resultLabel.setVisible(true);
            resultLabel.setText("Correct Answers: " + correctAnswers + "/" + mcqs.length+"\n\nYOUR TEST HAS BEEN ENDED");
        }
    }

    @FXML
    private void onShowResultButtonClicked() {
        showResult();
    }

    private void showResult() {
        int correctAnswers = calculateCorrectAnswers();
        questionLabel.setVisible(false);
        option1.setVisible(false);
        option2.setVisible(false);
        option3.setVisible(false);
        option4.setVisible(false);
        showResultButton.setVisible(false);
        nextButton.setVisible(false);
        resultLabel.setVisible(true);
        resultLabel.setText("Correct Answers: " + correctAnswers + "/" + mcqs.length+"\n\nYOUR TEST HAS BEEN ENDED");

    }

    private void showQuestion() {
        MCQ currentMCQ = mcqs[currentQuestionIndex];
        questionLabel.setText(currentMCQ.getQuestion());
        option1.setText(currentMCQ.getOptions()[0]);
        option2.setText(currentMCQ.getOptions()[1]);
        option3.setText(currentMCQ.getOptions()[2]);
        option4.setText(currentMCQ.getOptions()[3]);
        toggleGroup.selectToggle(null);
    }

    private int getSelectedOptionIndex() {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        if (selectedRadioButton == option1) {
            return 0;
        } else if (selectedRadioButton == option2) {
            return 1;
        } else if (selectedRadioButton == option3) {
            return 2;
        } else if (selectedRadioButton == option4) {
            return 3;
        }
        return -1;
    }

    private int calculateCorrectAnswers() {
        int correctAnswers = 0;
        for (MCQ mcq : mcqs) {
            if (mcq.isCorrect()) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }
}



