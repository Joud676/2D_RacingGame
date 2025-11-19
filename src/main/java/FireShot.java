import javax.swing.*;

public class FireShot extends Shot{

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon(getClass().getResource("/img/fireShot.png"));
        setImage(ii.getImage());
    }
}
