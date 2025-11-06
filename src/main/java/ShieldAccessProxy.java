import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ShieldAccessProxy {
    private PlayerDecorator player;
    private final QuestionBank bank;

    public ShieldAccessProxy() {
        this.bank = new QuestionBank();
    }

    public Player grantShieldAccess(Player player) {
        System.out.println("Proxy: Shield locked! Answer the question to activate...");

        Map.Entry<String, String> question = bank.getRandomQuestion();
        String correctAnswer = question.getKey();
        String scenario = question.getValue();

        String userAnswer = showQuestion(scenario);

        if (userAnswer != null && userAnswer.equalsIgnoreCase(correctAnswer)) {
            JOptionPane.showMessageDialog(null,
                    "✅ Correct! Shield activated!",
                    "Shield Unlocked",
                    JOptionPane.INFORMATION_MESSAGE);

        this.player = new ShieldedPlayer(player, 0);
            return this.player;
        } else {

        JOptionPane.showMessageDialog(null,
                "❌ Wrong answer! You will play without shield.",
                "Shield Locked",
                JOptionPane.WARNING_MESSAGE);
        }
        return player;
    }


    private String showQuestion(String scenario) {
        JTextArea textArea = new JTextArea(scenario);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Helvetica", Font.PLAIN, 14));
        textArea.setColumns(30);
        textArea.setRows(5);

        JScrollPane scrollPane = new JScrollPane(textArea);

        return JOptionPane.showInputDialog(
                null,
                scrollPane,
                "Shield Activation Question",
                JOptionPane.QUESTION_MESSAGE
        );
    }
}



