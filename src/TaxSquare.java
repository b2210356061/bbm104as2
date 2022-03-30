public class TaxSquare extends Square {
    @Override
    public String takeAction(Player player, int dice) throws BankruptException {
        player.removeBalance(100);
        Monopoly.banker.addBalance(100);
        return player.getName() + " paid Tax";
    }
}
