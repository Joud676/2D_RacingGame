import com.spaceinvaders.main.Sound;
public class GameIntegrationAdapter {

    private Sound backgroundMusic;
    private Sound explosionSound;

    public void playBackgroundMusic(String path) {
        backgroundMusic = new Sound(path);
        backgroundMusic.loop();
    }

    public void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }

    public void playExplosionSound(String path) {
        explosionSound = new Sound(path);
        explosionSound.play();
    }
}

