
public class BombFactory extends AbstractFactory {

    public  Bomb getBomb( int x,int y,String difficulty){
        if(difficulty == null){
            return null; }
        else if (difficulty.equalsIgnoreCase("easy")) {
            return new Stone(x,y);
        } else if (difficulty.equalsIgnoreCase("hard")) {
            return new Missiles(x,y);
        }
        return null;
    }

    @Override
    Alien getAlien(String alienType) {
        return null;
    }
   @Override
    public Shot getShot(String shotType){
        return null;}
    @Override
    public Player getPlayer(String type) {
        return null;
    }

}

