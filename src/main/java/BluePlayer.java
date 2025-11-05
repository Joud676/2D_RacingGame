import javax.swing.*;
import java.awt.*;

public class BluePlayer extends Player {

    public BluePlayer(){
        this.speed = getSpeed();
        ImageIcon ii = new ImageIcon(this.getClass().getResource(getImagePath()));
        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());
    }
    @Override
    public String getImagePath() {
        return "/img/craft_blue.png";
    }

    @Override
    public int getSpeed() {
        return 4;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }
}
