public class PlayerFactory extends AbstractFactory {

    @Override
    public Player getPlayer(String type) {
        if (type == null) return null;

        if (type.equalsIgnoreCase("RED")) {
            return new RedPlayer();
        } else if (type.equalsIgnoreCase("GREEN")) {
            return new GreenPlayer();
        } else if (type.equalsIgnoreCase("BLUE")) {
            return new BluePlayer();
        }
        return null;
    }

    @Override
    public Shot getShot(String type) { return null; }

    @Override
    public Bomb getBomb(int x, int y, String difficulty) { return null; }

    @Override
    public Alien getAlien (String alienType){return null;}
}