public abstract class AbstractFactory {

     abstract Shot getShot(String shotType);
     abstract Bomb getBomb(int x, int y, String difficulty);
     abstract Alien getAlien (String alienType);
}

