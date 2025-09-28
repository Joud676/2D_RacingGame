
public class BombFactory extends AbstractFactory {

    public  Bomb getBomb( int x,int y,String difficulty){
        if(difficulty == null){
            return null; }
        else if (difficulty.equalsIgnoreCase("easy")) {
            return new Stone(x,y);
        } else if (difficulty.equalsIgnoreCase("medium")) {
            return new Missiles(x,y);
        }
        return null;
    }

    public Shot getShot(String shotType){
        return null;}}

