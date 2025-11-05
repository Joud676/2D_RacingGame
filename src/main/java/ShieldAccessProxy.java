import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ShieldAccessProxy implements ShieldAccess {
    private final RealShieldAccess realAccess;
    private final QuestionBank bank;

    public ShieldAccessProxy() {
        this.realAccess = new RealShieldAccess();
        this.bank = new QuestionBank();
    }

    @Override
    public void grantAccess() {
        System.out.println("Proxy: Shield locked! Answer the question to activate...");

        Map.Entry<String, String> question = bank.getRandomQuestion();
        String correctAnswer = question.getKey();
        String scenario = question.getValue();

        JTextArea textArea = new JTextArea(scenario);
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

        if (userAnswer != null && userAnswer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("✅ Correct! Shield access granted.");
            realAccess.grantAccess();
        } else {
            System.out.println("❌ Wrong answer. Shield remains locked.");
        }
    }

    @Override
    public boolean isGranted() {
        return realAccess.isGranted();
    }
}
