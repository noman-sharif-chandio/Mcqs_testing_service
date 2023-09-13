package main;

public class MCQ {
    private String question;
    private String[] options;
    private int correctOptionIndex;
    private int selectedOptionIndex = -1;

    public MCQ(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setSelectedOptionIndex(int selectedOptionIndex) {
        this.selectedOptionIndex = selectedOptionIndex;
    }

    public boolean isCorrect() {
        return selectedOptionIndex == correctOptionIndex;
    }
}
