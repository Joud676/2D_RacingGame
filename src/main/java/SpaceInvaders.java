import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Space Invaders Game
 * @author
 */
public class SpaceInvaders extends JFrame implements Commons {

	private static final long serialVersionUID = -4905230094675077405L;

	private JButton start, help;
	/*
	private JRadioButton normalShot, waterShot, fireShot;
	private ButtonGroup shotGroup;
	*/

	// Messages in English
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

	// public static String selectedShot = "Normal"; // Default shot type

	/*
	 * Constructor
	 */
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

		/*
		// Radio buttons for shot selection
		normalShot = new JRadioButton("Normal", true);
		waterShot = new JRadioButton("Water");
		fireShot = new JRadioButton("Fire");

		shotGroup = new ButtonGroup();
		shotGroup.add(normalShot);
		shotGroup.add(waterShot);
		shotGroup.add(fireShot);

		// Panel for shot selection
		JPanel shotPanel = new JPanel();
		shotPanel.setBorder(BorderFactory.createTitledBorder("Choose Shot Type"));
		shotPanel.add(normalShot);
		shotPanel.add(waterShot);
		shotPanel.add(fireShot);

		// Listen for selection
		ActionListener shotListener = e -> selectedShot = e.getActionCommand();
		normalShot.setActionCommand("Normal");
		waterShot.setActionCommand("Water");
		fireShot.setActionCommand("Fire");

		normalShot.addActionListener(shotListener);
		waterShot.addActionListener(shotListener);
		fireShot.addActionListener(shotListener);
		*/

		frame2.setTitle("Space Invaders");
		frame2.add(tekst);
		frame2.add(toptekst, BorderLayout.PAGE_START);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());

		/*
		// Commented shotPanel since we're not using radio buttons anymore
		bottomPanel.add(shotPanel, BorderLayout.NORTH);
		*/

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(help);
		buttonPanel.add(start);

		bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
		frame2.add(bottomPanel, BorderLayout.PAGE_END);
		frame2.setSize(500, 500);
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

	/*
	 * Main
	 */
	public static void main(String[] args) {
		new SpaceInvaders();
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			//Board board = Board.getInstance();
			// board.setSelectedShotType(SpaceInvaders.selectedShot);

			/*
			AbstractFactory shotFactory = FactoryProducer.getFactory("shot"); // Get The Shot Factory
			Shot shot  = shotFactory.getShot(selectedShot);
			*/

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
