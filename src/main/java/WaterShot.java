import javax.swing.*;

public class WaterShot extends Shot{
    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon(getClass().getResource("/img/waterShot.png"));
        setImage(ii.getImage());
    }

}
