import javax.swing.*;

public class NormalShot extends Shot {

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon(getClass().getResource("/img/normalShot.png"));
        setImage(ii.getImage());
    }

}
