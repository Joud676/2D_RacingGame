import javax.swing.*;
import java.awt.*;

public class ShieldAccessProxy implements ShieldAccess {
    private RealShieldAccess realAccess;

    public ShieldAccessProxy() {
        this.realAccess = new RealShieldAccess();
    }

    @Override
    public void grantAccess() {

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
            realAccess.grantAccess();
        }
    }

    @Override
    public boolean isGranted() {
        return realAccess.isGranted();
    }
}