public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("Shot")){
            return new ShotFactory();
        } else if (choice.equalsIgnoreCase("Bomb")){
            return new BombFactory();
        }
        return null;
    }


}
