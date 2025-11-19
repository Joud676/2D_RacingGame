import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class AlienFactory extends AbstractFactory {

    private static final Map<String, Image> alienImages = new HashMap<>();

    private Image getSharedAlienImage(String alienType) {
        String key = alienType.toUpperCase();

        if (!alienImages.containsKey(key)) {
            String imagePath = "";

            if (key.equals("NORMAL")) {
                imagePath = "/img/alien.png";
            } else if (key.equals("RATH")) {
                imagePath = "/img/Rath.png";
            }
                ImageIcon ii = new ImageIcon(getClass().getResource(imagePath));
                alienImages.put(key, ii.getImage());

        }
        return alienImages.get(key);
    }

    @Override
    public Alien getAlien(String alienType) {

        Image sharedImage = getSharedAlienImage(alienType);

        Alien alien = null;
        if (alienType.equalsIgnoreCase("NORMAL")) {
            alien = new NormalAlien(sharedImage);

        } else if (alienType.equalsIgnoreCase("RATH")) {
            alien = new RathAlien(sharedImage);
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

