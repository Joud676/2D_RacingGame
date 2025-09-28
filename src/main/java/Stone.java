import javax.swing.*;
import java.util.Objects;

public class Stone extends Bomb{
    private static final String IMG = "/img/stone.png";
    public Stone(int x, int y) {
        super(x, y);
        speed = 1;
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(IMG)));
        setImage(ii.getImage());}
    @Override
    public void move() {
        setY(getY() + speed); }}
