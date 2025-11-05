import java.awt.*;

import java.awt.event.*;

import javax.swing.*;


public class SpaceInvaders extends JFrame implements Commons {


    private static final long serialVersionUID = -4905230094675077405L;


    Board board;
    private JButton start, help;
    private JRadioButton easyGame, hardGame;
    private JRadioButton normalAlien, rathAlien;
    private ButtonGroup difficultyGroup;
    private ButtonGroup alienTypeGroup;
    public static String selectedDifficulty = "Easy";
    public static String selectedAlienType = "NORMAL";


    // Shield attributes
    private JRadioButton withShield, withoutShield;
    private ButtonGroup shieldGroup;
    public static boolean wantsShield = false;
    private static final String TOP_MESSAGE = "Space Invaders <br> Java Version";
    private static final String INITIAL_MESSAGE = "Help us, amazing captain!!"
            + "<br>The aliens are trying to invade our planet."
            + "<br><br><br>Your mission:"
            + "<br><br>Destroy all alien invaders before they reach Earth."
            + "<br>And preferably, don’t die during the battle!"
            + "<br><br><br>GOOD LUCK!!!";

    private static final String HELP_TOP_MESSAGE = "Help";
    private static final String HELP_MESSAGE = "Controls: "
            + "<br><br>Move Left: <br>Left Arrow Key"
            + "<br><br>Move Right: <br>Right Arrow Key"
            + "<br><br>Shoot with Normal Shot: <br>Space Bar"
            + "<br><br>Shoot with Water Shot: <br>W Letter"
            + "<br><br>Shoot with Fire Shot: <br>F Letter"
            + "<br><br>Select Player: "
            + "<br>1 → Red Player (Normal Speed)"
            + "<br>2 → Green Player (Medium Speed)"
            + "<br>3 → Blue Player (Fast Speed)";

    JFrame frame = new JFrame("Space Invaders");
    JFrame frame2 = new JFrame("Space Invaders");
    JFrame frame3 = new JFrame("Help");

    public SpaceInvaders() {

        String topmessage = "<html><br><br>" + TOP_MESSAGE + "</html>";
        String message = "<html>" + INITIAL_MESSAGE + "</html>";

        start = new JButton("Start Mission");
        start.addActionListener(new ButtonListener());


        help = new JButton("Help");
        help.addActionListener(new HelpButton());

        JLabel tekst = new JLabel(message, SwingConstants.CENTER);
        JLabel toptekst = new JLabel(topmessage, SwingConstants.CENTER);
        Font font = new Font("Helvetica", Font.BOLD, 12);
        tekst.setFont(font);
        Font font2 = new Font("Helvetica", Font.BOLD, 20);
        toptekst.setFont(font2);

        // إعداد أزرار نوع الصعوبة
        easyGame = new JRadioButton("Easy", true);
        hardGame = new JRadioButton("Hard");
        difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easyGame);
        difficultyGroup.add(hardGame);
        ActionListener difficultyListener = e -> selectedDifficulty = e.getActionCommand();
        easyGame.addActionListener(difficultyListener);
        hardGame.addActionListener(difficultyListener);

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.add(easyGame);
        difficultyPanel.add(hardGame);

        // إعداد أزرار نوع الفضائي
        normalAlien = new JRadioButton("Normal Alien", true);
        rathAlien = new JRadioButton("Rath Alien");


        alienTypeGroup = new ButtonGroup();
        alienTypeGroup.add(normalAlien);
        alienTypeGroup.add(rathAlien);

        ActionListener alienTypeListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == normalAlien) {
                    selectedAlienType = "NORMAL";
                } else if (e.getSource() == rathAlien) {
                    selectedAlienType = "RATH";
                }
                System.out.println("Selected Alien Type: " + selectedAlienType);
            }
        };

        normalAlien.addActionListener(alienTypeListener);
        rathAlien.addActionListener(alienTypeListener);

        // Shield options
        withShield = new JRadioButton("Yes, I want shield", false);
        withoutShield = new JRadioButton("No shield", true);


        // adding radio button to group
        shieldGroup = new ButtonGroup();
        shieldGroup.add(withShield);
        shieldGroup.add(withoutShield);


        // check if the user selects the shield radio button or not, if so change wantsShield to true
        ActionListener shieldListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == withShield) {
                    wantsShield = true;
                }
            }
        };

        withShield.addActionListener(shieldListener);
        withoutShield.addActionListener(shieldListener);

        // shield panel
        JPanel shieldPanel = new JPanel();
        shieldPanel.add(new JLabel("Activate Shield? "));
        shieldPanel.add(withShield);
        shieldPanel.add(withoutShield);

        //  إنشاء panel لنوع الفضائي
        JPanel alienTypePanel = new JPanel();
        alienTypePanel.add(new JLabel("Alien Type: "));
        alienTypePanel.add(normalAlien);
        alienTypePanel.add(rathAlien);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        tekst.setAlignmentX(Component.CENTER_ALIGNMENT);
        difficultyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        alienTypePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        shieldPanel.setAlignmentX(Component.CENTER_ALIGNMENT);  // adding shield


        centerPanel.add(tekst);
        centerPanel.add(difficultyPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(alienTypePanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // مسافة
        centerPanel.add(shieldPanel);


        frame2.setTitle("Space Invaders");
        frame2.add(toptekst, BorderLayout.PAGE_START);
        frame2.add(centerPanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(help);
        buttonPanel.add(start);

        frame2.add(buttonPanel, BorderLayout.SOUTH);
        frame2.pack();
        frame2.setSize(500, 650);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        frame2.setResizable(false);

    }


    public void closeIntro() {
        frame2.dispose();
        frame3.dispose();
    }


    public void closeHelp() {
        frame3.dispose();
    }


    public static void main(String[] args) {
        new SpaceInvaders();
    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            boolean shieldAccessGranted = false;

            if (wantsShield) {
                ShieldAccess access = new ShieldAccessProxy();
                access.grantAccess();
                shieldAccessGranted = access.isGranted();

                if (!shieldAccessGranted) {
                    JOptionPane.showMessageDialog(frame2,
                            "❌ Wrong answer! You will play without shield.",
                            "Shield Locked",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame2,
                            "✅ Correct! Shield activated!",
                            "Shield Unlocked",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

            closeIntro();

            board = Board.getInstance();

            board.setDifficulty(selectedDifficulty);
            board.setAlienType(selectedAlienType);
            board.setWantsShield(wantsShield);
            board.setshieldAccess(shieldAccessGranted);

            board.startGame();

            // Frame setup
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(BOARD_WIDTH, BOARD_HEIGTH);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);

            frame.getContentPane().add(board);
            frame.setVisible(true);

            board.requestFocusInWindow();
        }
    }

    private class CloseHelp implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            closeHelp();
        }
    }

    private class HelpButton implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            JButton close = new JButton("Close");

            close.addActionListener(new CloseHelp());

            String topmessage = "<html><br>" + HELP_TOP_MESSAGE + "</html>";
            String message = "<html>" + HELP_MESSAGE + "</html>";
            JLabel tekst = new JLabel(message, SwingConstants.CENTER);
            JLabel toptekst = new JLabel(topmessage, SwingConstants.CENTER);

            Font font = new Font("Helvetica", Font.BOLD, 12);
            tekst.setFont(font);
            JScrollPane scrollPane = new JScrollPane(tekst);

            Font font2 = new Font("Helvetica", Font.BOLD, 20);

            toptekst.setFont(font2);

            frame3.getContentPane().removeAll();
            frame3.setLayout(new BorderLayout());
            frame3.add(toptekst, BorderLayout.NORTH);
            frame3.add(scrollPane, BorderLayout.CENTER);
            frame3.add(close, BorderLayout.SOUTH);


            frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame3.setSize(400, 350);
            frame3.setResizable(false);
            frame3.setLocationRelativeTo(null);
            frame3.setVisible(true);
        }

    }

}