import javax.swing.ImageIcon;
import java.util.Objects;

/**
 *
 * @author
 */
public abstract class Alien extends Sprite {

    protected AbstractFactory bombFactory = FactoryProducer.getFactory("Bomb");
    protected Bomb bomb;
    protected String difficulty;

    public Alien() {
        // Empty constructor
    }

    // Common methods for all alien types
    public void act(int direction) {
        this.x += direction;
    }
    public Bomb getBomb() {
        return bomb;
    }
    // this method overridden by concrete classes
    public abstract void setupAlien(int x, int y, String difficulty, Alien alien);
}
