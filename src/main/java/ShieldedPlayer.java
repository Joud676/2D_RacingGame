import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ShieldedPlayer extends PlayerDecorator{
    private final Image shieldOverlay = new ImageIcon(this.getClass().getResource("/img/shield.png")).getImage();

    protected int shieldHits = 0;
    static final int MAX_HITS = 2;

    public ShieldedPlayer(Player player) {
        super(player);
    }
    @Override
    public void draw(Graphics g) {
        // أول نرسم اللاعب الأصلي
        decoratedPlayer.draw(g);

        // بعدين نرسم الدرع فوقه (طبقة شفافة)
        g.drawImage(shieldOverlay, decoratedPlayer.getX() + 7, decoratedPlayer.getY() + 8, null);
    }

    @Override
    public void shoot() {
        super.shoot();
        System.out.println("Player is protected by a shield!");
    }
    public Player getDecoratedPlayer() {
        return decoratedPlayer;
    }

    public void hitByBomb() {
        if (shieldHits < MAX_HITS) {
            shieldHits++;
            System.out.println("Shield hit! Remaining hits: " + (MAX_HITS - shieldHits));
        }
    }

    public int getShieldHits() {
        return shieldHits;
    }
}


