
public abstract class Bomb extends Sprite {
	// change here to protected so the concrete classes can change
	protected boolean destroyed;
	protected int speed;
	public Bomb(int x, int y) {
		setDestroyed(true);
		setX(x);
		setY(y);
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public int getSpeed(){
		return speed;
	}
	// we will use it in class board instaid of +1 polymorphisim
	public abstract void move();

}
