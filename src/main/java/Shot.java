public abstract class Shot extends Sprite {

    final int H_SPACE = 6;
    final int V_SPACE = 1;

    public final void build(int x, int y) {
        loadImage();
        position(x, y);
        System.out.println("templet method is working");

    }

    protected abstract void loadImage();

    protected void position(int x, int y) {
        setX(x + H_SPACE);
        setY(y - V_SPACE);
    }
}