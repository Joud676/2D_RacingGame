

public class ShieldedState implements PlayerState {

    @Override
    public void hit(Player p) {

        // تتغير حالته عادي الى محمي
        ShieldedPlayer sp = (ShieldedPlayer) p;
        sp.hitByBomb();

        if (sp.getShieldHits() >= ShieldedPlayer.MAX_HITS) {
            System.out.println("Shield destroyed! Becoming vulnerable...");
            if (sp.getShieldHits() >= ShieldedPlayer.MAX_HITS) {
                System.out.println("Shield destroyed! Becoming vulnerable...");

                Player original = sp.getDecoratedPlayer();
                original.setState(new VulnerableState());
                Board.getInstance().setPlayer(original);
            }

        }
    }
}
