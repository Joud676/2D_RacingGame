import javax.swing.*;
import java.util.Objects;

public class Missiles extends Bomb {
    private static final String IMG = "/img/Missiles.png";
    public Missiles(int x, int y) {
        super(x, y);
        speed = 3;
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(IMG)));
        setImage(ii.getImage());}
    @Override
    public void move() {
        setY(getY() + speed); }}
