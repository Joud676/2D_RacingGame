import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ShieldAccessProxy implements ShieldAccess {
    private RealShieldAccess realAccess;
    private QuestionBank bank;


    public ShieldAccessProxy() {
        this.realAccess = new RealShieldAccess();
        this.bank = new QuestionBank();
    }

    @Override
    public void grantAccess() {

        System.out.println("Proxy: Shield locked! Determine which design pattern is suitable with the scenario to unlock...");

        QuestionBank bank = new QuestionBank();
        Map<String, String> question = bank.getRandomQuestion();

        JTextArea textArea = new JTextArea(question.get("scenario"));
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

        boolean correct = (userAnswer != null && userAnswer.equalsIgnoreCase(question.get("answer")));

        if (correct) {
            realAccess.grantAccess();
        }
    }

    @Override
    public boolean isGranted() {
        return realAccess.isGranted();
    }
}