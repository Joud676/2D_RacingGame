import javax.swing.*;

public class FireShot extends Shot{

    final String FIRE_SHOT ="/img/fireShot.png";
    final int H_SPACE = 6;
    final int V_SPACE = 1;

    public FireShot(){

    }

    @Override
    public void selectShot(int x, int y){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(FIRE_SHOT));
        setImage(ii.getImage());
        setX(x + H_SPACE);
        setY(y - V_SPACE);
    }

}
