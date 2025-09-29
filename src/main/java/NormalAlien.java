import javax.swing.*;
import java.util.Objects;

public class NormalAlien extends Alien {

    private final String NORMAL_ALIEN = "/img/alien.png";

    public NormalAlien() {
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
        ImageIcon ii = new ImageIcon(this.getClass().getResource(NORMAL_ALIEN));
        setImage(ii.getImage());
    }
}