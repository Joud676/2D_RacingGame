import javax.swing.*;
import java.awt.*;

public class ShieldAccessProxy implements ShieldAccess {
    private RealShieldAccess realAccess;
    private boolean questionSolved = false;

    public ShieldAccessProxy() {
        this.realAccess = new RealShieldAccess();
    }

    @Override
    public boolean grantAccess() {
//        if (questionSolved) {
//            System.out.println("Proxy: Puzzle already solved.");
//            return realAccess.grantAccess();
//        }

        System.out.println("Proxy: Shield locked! Determine which design pattern is suitable with the scenario to unlock...");

        QuestionBank bank = new QuestionBank();
        Question question = bank.getRandomQuestion();

        JTextArea textArea = new JTextArea(question.getScenario());
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Helvetica", Font.PLAIN, 14));
        textArea.setColumns(30);
        textArea.setRows(5);

        JScrollPane scrollPane = new JScrollPane(textArea);

        String userAnswer = JOptionPane.showInputDialog(
                null,
                scrollPane,
                "Shield Activation Question",
                JOptionPane.QUESTION_MESSAGE
        );

        boolean correct = (userAnswer != null && userAnswer.equalsIgnoreCase(question.getCorrectAnswer()));

        if (correct) {
            questionSolved = true;
            System.out.println("✅ Proxy: Correct answer! Delegating to real access...");
            return realAccess.grantAccess();
        } else {
            System.out.println("❌ Proxy: Wrong answer! Access denied.");
            return false;
        }
    }

    @Override
    public boolean isGranted() {
        return realAccess.isGranted();
    }
}