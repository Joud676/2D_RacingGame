import javax.swing.ImageIcon;
import java.util.Objects;

/**
 * 
 * @author 
 */
public class Alien extends Sprite {

    private AbstractFactory bombFactory = FactoryProducer.getFactory("Bomb");
    Bomb bomb;
    private final String alien = "/img/alien.png";

    /*
     * Constructor we add difficulty
     */
    public Alien(int x, int y,String difficulty ) {
        this.x = x;
        this.y = y;

        bomb = bombFactory.getBomb(x,y,difficulty);
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(alien)));
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
