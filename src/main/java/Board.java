import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Board extends JPanel implements Runnable, Commons,PlayerObserver  {

    private boolean gameInitialized = false;
    private static final long serialVersionUID = 1L;
    private static Board instance = null;

    private Dimension d;
    private ArrayList aliens;
    private Player player;
    private Shot shot;
    private GameOver gameend;
    private Won vunnet;

    private int alienX = 150;
    private int alienY = 25;
    private int direction = -1;
    private int deaths = 0;

    private String selectedAlienType = "NORMAL";

    private boolean ingame = true;
    private boolean havewon = true;
    private final String expl = "/img/explosion.png";
    private String message = "Your planet belongs to us now...";

    private Thread animator;
    private String difficulty = null;

    private String selectedShotType = "Normal";
    private String selectedPlayerType = "RED";

    // shield attributes
    private boolean wantsShield;
    private boolean shieldActive = false;

    Random generator = new Random();

    // adapter
    private GameIntegrationAdapter adapter;




    /*
     * Constructor
     */

    private Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGTH);
        setBackground(Color.black);
        setDoubleBuffered(true);
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public void startGame() {
        if (!gameInitialized) {
            gameInit();
            gameInitialized = true;
        }
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setAlienType(String alienType) {
        this.selectedAlienType = alienType.toUpperCase();
    }


    public void setWantsShield(boolean wantsShield) {
        this.wantsShield = wantsShield;
    }

    public void addNotify() {
        super.addNotify();
        if (animator != null && !animator.isAlive()) {
            animator.start();
        }
    }

    public void gameInit() {
        if (gameInitialized) {
            return;
        }
        aliens = new ArrayList();
        AbstractFactory alienFactory = FactoryProducer.getFactory("Alien");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                Alien alien = alienFactory.getAlien(selectedAlienType);
                alien.setupAlien(alienX + 18 * j, alienY + 18 * i, difficulty, alien);
                aliens.add(alien);
            }

			//  نطبع اـ hashCode للصور
			System.out.println("\n Checking Image im memory :");
			for (Object obj : aliens) {
				Alien alien = (Alien) obj;
				System.out.println("Image Hash: " + alien.getImage().hashCode());
			}
        }
        AbstractFactory playerFactory = FactoryProducer.getFactory("Player");
        player = playerFactory.getPlayer(selectedPlayerType);
        player.addObserver(this);

        if (wantsShield) {
            ShieldAccessProxy proxy = new ShieldAccessProxy();

            player = proxy.grantShieldAccess(player);


            if (player instanceof ShieldedPlayer) {
                shieldActive = true; // to draw the method according to the player type
            }
        }

        AbstractFactory shotFactory = FactoryProducer.getFactory("Shot");
        shot = shotFactory.getShot(selectedShotType);
        // ====== Adapter Integration (Simplified) ======
        adapter = new GameIntegrationAdapter();
        adapter.playBackgroundMusic("./src/com/spaceinvaders/main/ChillingMusic.wav");
// ==============================================

        if (animator == null || !ingame) {
            animator = new Thread(this);
        }
    }
    @Override
    public void update(Player player) {
        System.out.println(
                "[Observer] Player updated → X: " + player.getX() +
                        " | Y: " + player.getY() +
                        " | Speed: " + player.getSpeed() +
                        " | Type: " + player.getClass().getSimpleName()
        );
    }


    public void drawAliens(Graphics g) {
        Iterator it = aliens.iterator();
        while (it.hasNext()) {
            Alien alien = (Alien) it.next();
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
            if (alien.isDying()) {
                alien.die();
            }
        }
    }

    public void drawPlayer(Graphics g) {
        // if shielded or any normal player
        if (player.isVisible()) {
            if (shieldActive) {
                 player.draw(g); // shielded player
            } else {
                g.drawImage(player.getImage(), player.getX(), player.getY(), this); // basic player
            }
        }
        if (player.isDying()) {
            player.die();
            havewon = false;
            ingame = false;
        }
    }

    public void drawShot(Graphics g) {
        if (shot.isVisible())
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
    }

    public void drawBombing(Graphics g) {
        Iterator i3 = aliens.iterator();
        while (i3.hasNext()) {
            Alien a = (Alien) i3.next();
            Bomb b = a.getBomb();
            if (b != null && !b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);
        if (ingame) {
            g.drawLine(0, GROUND, BOARD_WIDTH, GROUND);
            drawAliens(g);
            drawPlayer(g);
            drawShot(g);
            drawBombing(g);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    Graphics g;

    public void gameOver() {
        g = this.getGraphics();
        gameend = new GameOver();
        vunnet = new Won();
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGTH);
        if (havewon) {
            g.drawImage(vunnet.getImage(), 0, 0, this);
        } else {
            g.drawImage(gameend.getImage(), 0, 0, this);
        }
        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, BOARD_WIDTH / 2 - 30, BOARD_WIDTH - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, BOARD_WIDTH / 2 - 30, BOARD_WIDTH - 100, 50);
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (BOARD_WIDTH - metr.stringWidth(message)) / 2, BOARD_WIDTH / 2);

            adapter.stopBackgroundMusic();


    }

    public void animationCycle() {
        if (deaths == NUMBER_OF_ALIENS_TO_DESTROY) {
            ingame = false;
            message = "Congratulations! You saved the galaxy!";
        }
        player.act();
        if (shot.isVisible()) {
            Iterator it = aliens.iterator();
            int shotX = shot.getX();
            int shotY = shot.getY();

            while (it.hasNext()) {

                Alien alien = (Alien) it.next();
                int alienX = alien.getX();
                int alienY = alien.getY();
                if (alien.isVisible() && shot.isVisible()) {

                    if (shotX >= alienX && shotX <= (alienX + ALIEN_WIDTH)
                            && shotY >= alienY && shotY <= (alienY + ALIEN_HEIGHT)) {
                        ImageIcon ii = new ImageIcon(getClass().getResource(expl));
                        alien.setImage(ii.getImage());
                        alien.setDying(true);
                        deaths++;
                        shot.die();
                        if (adapter != null) {

                            adapter.playExplosionSound("./src/com/spaceinvaders/main/explosion.wav");
                        }
                    }
                }
            }
            int y = shot.getY();
            y -= 8;
            if (y < 0) shot.die();
            else shot.setY(y);
        }
        // aliens
        Iterator it1 = aliens.iterator();
        while (it1.hasNext()) {
            Alien a1 = (Alien) it1.next();
            int x = a1.getX();
            if (x >= BOARD_WIDTH - BORDER_RIGHT && direction != -1) {
                direction = -1;
                for (Object o : aliens) {
                    Alien a2 = (Alien) o;
                    a2.setY(a2.getY() + GO_DOWN);
                }
            }
            if (x <= BORDER_LEFT && direction != 1) {
                direction = 1;
                for (Object o : aliens) {
                    Alien a = (Alien) o;
                    a.setY(a.getY() + GO_DOWN);
                }
            }
        }
        for (Object o : aliens) {
            Alien alien = (Alien) o;
            if (alien.isVisible()) {
                int y = alien.getY();
                if (y > GROUND - ALIEN_HEIGHT) {
                    havewon = false;
                    ingame = false;
                    message = "Aliens are invading the galaxy!";
                }
                alien.act(direction);
            }
        }
        //bomb
        for (Object o : aliens) {
            Alien a = (Alien) o;
            Bomb b = a.getBomb();
            if (b != null) {
                int shotChance = generator.nextInt(15);
                if (shotChance == CHANCE && a.isVisible() && b.isDestroyed()) {
                    b.setDestroyed(false);
                    b.setX(a.getX());
                    b.setY(a.getY());
                }
                int bombX = b.getX();
                int bombY = b.getY();
                int playerX = player.getX();
                int playerY = player.getY();

                // shield
                if (player.isVisible() && !b.isDestroyed()) {
                    if (bombX >= playerX && bombX <= (playerX + PLAYER_WIDTH)
                            && bombY >= playerY && bombY <= (playerY + PLAYER_HEIGHT)) {
                        b.setDestroyed(true);
                        if (shieldActive) { // hits logic
                            ShieldedPlayer shieldedPlayer = (ShieldedPlayer) player;
                            shieldedPlayer.hitByBomb(); // add to the hit number
                            if (shieldedPlayer.getShieldHits() >= ShieldedPlayer.MAX_HITS) {
                                player = shieldedPlayer.getDecoratedPlayer();
                                shieldActive = false;
                                System.out.println("Shield destroyed! Access revoked.");
                            }
                        } else {
                            ImageIcon ii = new ImageIcon(this.getClass().getResource(expl));
                            player.setImage(ii.getImage());
                            player.setDying(true);
                        }
                    }
                }
                if (!b.isDestroyed()) {
                    b.move();
                    if (b.getY() >= GROUND - BOMB_HEIGHT) {
                        b.setDestroyed(true);
                    }
                }
            }
        }

    }

    public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        while (ingame) {
            repaint();
            animationCycle();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if (sleep < 0) sleep = 1;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            beforeTime = System.currentTimeMillis();
        }
        gameOver();
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            AbstractFactory shotFactory = FactoryProducer.getFactory("Shot");
            player.keyPressed(e);
            int x = player.getX();
            int y = player.getY();
            if (ingame) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_SPACE && !shot.isVisible()) {
                    selectedShotType = "Normal";
                    shot = shotFactory.getShot(selectedShotType);
                    shot.setupShot(x, y);
                } else if (key == KeyEvent.VK_W && !shot.isVisible()) {
                    selectedShotType = "Water";
                    shot = shotFactory.getShot(selectedShotType);
                    shot.setupShot(x, y);
                } else if (key == KeyEvent.VK_F && !shot.isVisible()) {
                    selectedShotType = "Fire";
                    shot = shotFactory.getShot(selectedShotType);
                    shot.setupShot(x, y);
                }

                if (key == KeyEvent.VK_1 || key == KeyEvent.VK_2 || key == KeyEvent.VK_3) {

                    int oldX = player.getX();
                    int oldY = player.getY();
                    int oldShieldHits = 0;


                    if (player instanceof ShieldedPlayer) {
                        oldShieldHits = ((ShieldedPlayer) player).getShieldHits(); // compiler
                        player = ((ShieldedPlayer) player).getDecoratedPlayer();
                    }


                    if (key == KeyEvent.VK_1) selectedPlayerType = "RED";
                    if (key == KeyEvent.VK_2) selectedPlayerType = "GREEN";
                    if (key == KeyEvent.VK_3) selectedPlayerType = "BLUE";



                    Player newPlayer = FactoryProducer.getFactory("Player").getPlayer(selectedPlayerType);
                    newPlayer.setX(oldX);
                    newPlayer.setY(oldY);

                    if (shieldActive) {
                        player = new ShieldedPlayer(newPlayer, oldShieldHits);
                    } else {
                        player = newPlayer;
                    }

                    if (player instanceof ShieldedPlayer) {
                        ((ShieldedPlayer) player).getDecoratedPlayer().addObserver(Board.this);
                    } else {
                        player.addObserver(Board.this);
                    }

                }
            }
        }
    }
}
