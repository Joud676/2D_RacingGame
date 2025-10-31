import java.util.HashMap;

public class AlienFactory extends AbstractFactory {

    private static final HashMap<String, Alien> alienMap = new HashMap<>();
    @Override
    public Alien getAlien(String alienType) {

        Alien alien = alienMap.get(alienType);
        if (alien == null) {
            if (alienType.equalsIgnoreCase("NORMAL")) {
                alien = new NormalAlien();
            } else if (alienType.equalsIgnoreCase("RATH")) {
                alien = new RathAlien();
            }
            alienMap.put(alienType, alien);
        }
        return alien;
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
