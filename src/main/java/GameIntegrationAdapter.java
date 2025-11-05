import com.spaceinvaders.main.Sound;
public class GameIntegrationAdapter {

    private Sound backgroundMusic;
    private Sound explosionSound;

    // تشغيل موسيقى الخلفية (تكرار مستمر)
    public void playBackgroundMusic(String path) {
        backgroundMusic = new Sound(path);
        backgroundMusic.loop();  // ← نداء مباشر
    }

    // تشغيل صوت الانفجار مرة واحدة
    public void playExplosionSound(String path) {
        explosionSound = new Sound(path);
        explosionSound.play(); // ← نداء مباشر
    }
}

