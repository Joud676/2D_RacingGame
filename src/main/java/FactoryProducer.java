public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("Shot")){
            return new ShotFactory();
        } else if (choice.equalsIgnoreCase("Bomb")){
            return new BombFactory();
        } else if (choice.equalsIgnoreCase("Alien")) {
            return new AlienFactory();
        }
        else if (choice.equalsIgnoreCase("Player")) {
            return new PlayerFactory();
        }
        return null;
    }


}
