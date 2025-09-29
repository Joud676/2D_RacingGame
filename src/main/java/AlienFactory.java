public class AlienFactory extends AbstractFactory {

    @Override
    public Alien getAlien(String alienType) {
        if (alienType == null) {
            return null;
        }
        if (alienType.equalsIgnoreCase("NORMAL")) {
            return new NormalAlien();
        } else if (alienType.equalsIgnoreCase("RATH")) {
            return new RathAlien();
        }
        return null;
    }

    @Override
    Shot getShot(String shotType) {
        return null;
    }

    @Override
    Bomb getBomb(int x, int y, String difficulty) {
        return null;
    }

    @Override
     Player getPlayer(String type) {
        return null;
    }
}
