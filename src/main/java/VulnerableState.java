

public class VulnerableState implements PlayerState {

    @Override
    public void hit(Player p) {
        p.setDying(true);
        System.out.println("Player died – vulnerable state.");
    }
}