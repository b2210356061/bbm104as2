public class GoSquare extends Square {
    @Override
    public String takeAction(Player player, int dice) throws BankruptException {
        player.addBalance(200);
        Monopoly.banker.removeBalance(200);
        return "";
    }
}
