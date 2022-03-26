public class GoSquare extends Square {
    @Override
    public void takeAction(Player player, int dice) throws Exception {
        // Player takes 200tl from the banker
        player.addBalance(200);
        new Banker().removeBalance(200);
    }
}
