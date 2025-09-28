public class ShotFactory extends AbstractFactory {

    @Override
    public Shot getShot(String shotType) {

        if (shotType == null) {
            return null;
        }
        if (shotType.equalsIgnoreCase("NORMAL")) {
            return new NormalShot();
        } else if (shotType.equalsIgnoreCase("WATER")) {
            return new WaterShot();
        } else if (shotType.equalsIgnoreCase("FIRE")) {
            return new FireShot();
        }

        return null;
    }

       @Override
    Bomb getBomb(int x, int y, String difficulty) {
        return null;
    }
}
