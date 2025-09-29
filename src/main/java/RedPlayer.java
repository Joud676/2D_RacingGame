public class RedPlayer extends Player {
    @Override
    protected String getImagePath() {
        return "/img/craft.png";
    }

    @Override
    protected int getSpeed() {
        return 2;
    }
}