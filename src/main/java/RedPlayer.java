import javax.swing.*;
import java.awt.*;

public class RedPlayer extends Player {
    public RedPlayer(){
        this.speed = getSpeed();
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/craft.png"));
        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());

    }
    @Override
    public String getImagePath() {
        return "/img/craft.png";
    }

    @Override
    public int getSpeed() {
        return 2;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }
}