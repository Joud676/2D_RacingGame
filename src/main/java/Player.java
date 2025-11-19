import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author
 */
public abstract class Player extends Sprite implements Commons {

	private final int START_Y = 400;
	private final int START_X = 270;

	protected int width;
	protected int speed;
	protected PlayerState state;
	private final List<PlayerObserver> observers = new ArrayList<>();

	public Player() {
	// removed image
		setX(START_X);
		setY(START_Y);
		this.state = new VulnerableState();
	//	this.speed = getSpeed();
	}

	public void setState(PlayerState state) {
		this.state = state;
	}

	public void hit() {
		state.hit(this);
	}
	public abstract String getImagePath();
	public abstract int getSpeed();

	//method for Decorator called by Board and modified by ShieldedPlayer.
	public abstract void draw(Graphics g);
	public void shoot() {
		// Base shooting logic (all concrete players inherit this)
		System.out.println(this.getClass().getSimpleName() + ": Base player fires a standard shot.");
	}
	// ====== Observer methods ======
	public void addObserver(PlayerObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(PlayerObserver observer) {
		observers.remove(observer);
	}

	protected void notifyObservers() {
		for (PlayerObserver observer : observers) {
			observer.update(this);
		}
	}

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
			notifyObservers();
		}
	}

	
}