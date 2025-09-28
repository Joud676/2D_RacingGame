import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpaceInvaders extends JFrame implements Commons {

	private static final long serialVersionUID = -4905230094675077405L;

	private JButton start, help;
	private JRadioButton easyGame, hardGame;
	private ButtonGroup difficultyGroup;
	public static String selectedDifficulty = "Easy";

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
			+ "<br><br>Shoot with Fire Shot: <br>F Letter";

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

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		tekst.setAlignmentX(Component.CENTER_ALIGNMENT);
		difficultyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		centerPanel.add(tekst);
		centerPanel.add(difficultyPanel);

		frame2.setTitle("Space Invaders");
		frame2.add(toptekst, BorderLayout.PAGE_START);
		frame2.add(centerPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(help);
		buttonPanel.add(start);

		frame2.add(buttonPanel, BorderLayout.SOUTH);
		frame2.setSize(500, 400);
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
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(BOARD_WIDTH, BOARD_HEIGTH);
			frame.getContentPane().add(Board.getInstance());
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			closeIntro();
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
