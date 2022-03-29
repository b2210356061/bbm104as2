public class GoSquare extends Square {
    @Override
    public void takeAction(Player player, int dice) throws BankruptException {
        // Player takes 200tl from the banker
        player.addBalance(200);
        banker.removeBalance(200);
    }
}
