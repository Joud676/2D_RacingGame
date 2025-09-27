import javax.swing.*;

public class NormalShot extends Shot {

    final String NORMAL_SHOT ="/img/normalShot.png";


    public NormalShot(){

    }

    @Override
    public void setupShot(int x, int y){

        ImageIcon ii = new ImageIcon(this.getClass().getResource(NORMAL_SHOT));
        setImage(ii.getImage());
        setX(x + H_SPACE);
        setY(y - V_SPACE);

    }
}
