
public class RedPlayer extends Player {
    public RedPlayer(){

    }
    @Override
    public String getImagePath() {
        return "/img/craft.png";
    }

    @Override
    public int getSpeed() {
        return 2;
    }
}