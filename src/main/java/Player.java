import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

/**
 * 
 * @author
 */
public abstract class Player extends Sprite implements Commons {

	private final int START_Y = 400;
	private final int START_X = 270;

	private int width;
	private int speed;

	public Player() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(getImagePath()));
		width = ii.getImage().getWidth(null);
		setImage(ii.getImage());
		setX(START_X);
		setY(START_Y);

		this.speed = getSpeed();
	}

	public abstract String getImagePath();
	public abstract int getSpeed();

	public void act() {
		x += dx;
		if (x <= 2) x = 2;
		if (x >= BOARD_WIDTH - 2 * width)
			x = BOARD_WIDTH - 2 * width;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -speed;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = speed;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
}