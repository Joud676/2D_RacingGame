public class Question {
    private String scenario;
    private String correctAnswer;

    public Question(String scenario, String correctAnswer) {
        this.scenario = scenario;
        this.correctAnswer = correctAnswer;
    }

    public String getScenario() {
        return scenario;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}