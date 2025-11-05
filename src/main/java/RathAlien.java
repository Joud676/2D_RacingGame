import javax.swing.*;
import java.util.Objects;
import java.awt.Image;

public class RathAlien extends Alien {

    private final String RATH_ALIEN = "/img/Rath.png";

    public RathAlien(Image sharedImage) {
        //  was Empty constructor
        super();
        //الي في السبرايت غيرناها عشان تاخد ريفرنس الصورة المشتركة
        super.setImage(sharedImage);
    }
    @Override
    public void setupAlien(int x, int y, String difficulty, Alien alien) {
        this.x = x;
        this.y = y;
        this.difficulty = difficulty;
        this.alien = alien;

        // Create bomb using factory
        bomb = bombFactory.getBomb(x, y, difficulty);

        // remove Setup image
        // ImageIcon ii = new ImageIcon(this.getClass().getResource(RATH_ALIEN));
        // setImage(ii.getImage());
    }
}
