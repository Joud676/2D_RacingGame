import com.spaceinvaders.main.Barrier;
import com.spaceinvaders.main.Handler;
import com.spaceinvaders.main.ID;
import com.spaceinvaders.main.Sound;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
public class GameIntegrationAdapter {

    // Adaptee objects
    private ArrayList<Barrier> barriers;
    private Handler spaceInvadersHandler;
    private Sound explosionSound;
    private Sound backgroundMusic;

    public GameIntegrationAdapter() {
        barriers = new ArrayList<>();
        spaceInvadersHandler = new Handler();
    }

    // ============ Sound Adapter Methods ============
    public void playExplosionSound(String soundPath) {
        try {
            if (explosionSound == null) {
                explosionSound = new Sound(soundPath);
            }
            explosionSound.play();
        } catch (Exception e) {
            System.out.println("Error playing explosion: " + e.getMessage());
        }
    }

    public void playBackgroundMusic(String soundPath) {
        try {
            if (backgroundMusic == null) {
                backgroundMusic = new Sound(soundPath);
                Thread musicThread = new Thread(backgroundMusic);
                musicThread.start();
            }
        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
        }
    }

    public void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }

    // ============ Barrier Adapter Methods ============

    public void createBarrier(int x, int y) {
        Barrier barrier = new Barrier(x, y, ID.Barrier, spaceInvadersHandler);
        barriers.add(barrier);
        spaceInvadersHandler.addObject(barrier);
    }

    public void createBarrierGroup(int startX, int startY, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                createBarrier(startX + j * 8, startY + i * 8);
            }
        }
    }

    public void renderBarriers(Graphics g) {
        for (Barrier barrier : barriers) {
            barrier.render(g);
        }
    }

    public void updateBarriers() {
        for (Barrier barrier : barriers) {
            barrier.tick();
        }
    }

    public boolean checkShotCollisionWithBarriers(Shot shot) {
        if (shot == null || !shot.isVisible()) {
            return false;
        }

        Iterator<Barrier> iterator = barriers.iterator();
        while (iterator.hasNext()) {
            Barrier barrier = iterator.next();

            Rectangle shotBounds = new Rectangle(shot.getX(), shot.getY(), 5, 10);
            if (barrier.getBounds().intersects(shotBounds)) {

                iterator.remove();
                spaceInvadersHandler.removeObject(barrier);

                shot.die();

                System.out.println(" Barrier destroyed! Remaining: " + barriers.size());

                return true;
            }
        }

        return false;
    }
    public boolean checkBombCollisionWithBarriers(Bomb bomb) {
        if (bomb == null || bomb.isDestroyed()) {
            return false;
        }

        Iterator<Barrier> iterator = barriers.iterator();
        while (iterator.hasNext()) {
            Barrier barrier = iterator.next();

            Rectangle bombBounds = new Rectangle(bomb.getX(), bomb.getY(), 5, 5);
            if (barrier.getBounds().intersects(bombBounds)) {

                iterator.remove();
                spaceInvadersHandler.removeObject(barrier);

                bomb.setDestroyed(true);

                System.out.println(" Barrier destroyed by bomb! Remaining: " + barriers.size());

                return true;
            }
        }

        return false;
    }

    public int getBarriersCount() {
        return barriers.size();
    }
}