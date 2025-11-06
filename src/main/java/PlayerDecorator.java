import java.awt.*;
import java.awt.event.KeyEvent;

public  abstract class PlayerDecorator extends Player {
    protected Player decoratedPlayer;

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
        decoratedPlayer.draw(g);
    }

    @Override
    public void shoot() {
        decoratedPlayer.shoot();
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