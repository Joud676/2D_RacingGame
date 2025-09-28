import javax.swing.ImageIcon;

/**
 * 
 * @author 
 */
public class Alien extends Sprite {

	private AbstractFactory bombFactory = FactoryProducer.getFactory("Bomb");
    private Bomb bomb;
    private final String alien = "/img/alien.png";

    /*
     * Constructor
     */
    public Alien(int x, int y) {
        this.x = x;
        this.y = y;

       bomb = bombFactory.getBomb(x,y,difficulty);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(alien));
        setImage(ii.getImage());

    }

    public void act(int direction) {
        this.x += direction;
    }

    /*
     * Getters & Setters
     */
    
	public Bomb getBomb() {
		return bomb;
	}

}
