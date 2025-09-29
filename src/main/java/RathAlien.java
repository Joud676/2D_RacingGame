import javax.swing.*;
import java.util.Objects;

public class RathAlien extends Alien {

    private final String RATH_ALIEN = "/img/Rath.png";

    public RathAlien() {
        // Empty constructor
    }
    @Override
    public void setupAlien(int x, int y, String difficulty) {
        this.x = x;
        this.y = y;
        this.difficulty = difficulty;

        // Create bomb using factory
        bomb = bombFactory.getBomb(x, y, difficulty);

        // Setup image
        ImageIcon ii = new ImageIcon(this.getClass().getResource(RATH_ALIEN));
        setImage(ii.getImage());
    }
}