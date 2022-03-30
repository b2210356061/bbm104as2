public class TaxSquare extends Square {
    @Override
    public void takeAction(Player player, int dice) throws BankruptException {
        player.removeBalance(100);
        Monopoly.banker.addBalance(100);
    }
}
