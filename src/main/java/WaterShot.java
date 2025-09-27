import javax.swing.*;

public class WaterShot extends Shot{

    final String WATER_SHOT ="/img/waterShot.png";
    final int H_SPACE = 6;
    final int V_SPACE = 1;

    public WaterShot(){

    }

    @Override
    public void selectShot(int x, int y){

        ImageIcon ii = new ImageIcon(this.getClass().getResource(WATER_SHOT));
        setImage(ii.getImage());
        setX(x + H_SPACE);
        setY(y - V_SPACE);

    }
}
