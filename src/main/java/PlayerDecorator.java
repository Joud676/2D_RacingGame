import java.awt.*;
import java.awt.event.KeyEvent;

public  abstract class PlayerDecorator extends Player {
    protected Player decoratedPlayer;

    protected int shieldHits = 0;
    public static final int MAX_HITS = 2;

    public PlayerDecorator(Player decoratedPlayer){
        this.decoratedPlayer=decoratedPlayer;
        //for movement drawing starts correctly
        this.x = decoratedPlayer.getX();
        this.y = decoratedPlayer.getY();
        this.speed = decoratedPlayer.getSpeed();
        setImage(decoratedPlayer.getImage());

    }

    @Override
    public String getImagePath() {
        return decoratedPlayer.getImagePath();
    }
    @Override
    public int getSpeed() {
        return decoratedPlayer.getSpeed();
    }

    @Override
    public void draw(Graphics g) {
        decoratedPlayer.draw(g); //Delegation of the drawing method
    }

    @Override
    public void shoot() {
        decoratedPlayer.shoot(); //Delegation of the shooting method
    }

    @Override
    public void act() {
        decoratedPlayer.act();


        this.x = decoratedPlayer.getX();
        this.y = decoratedPlayer.getY();
        this.dx = decoratedPlayer.dx;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        decoratedPlayer.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        decoratedPlayer.keyReleased(e);
    }

}