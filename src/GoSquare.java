public class GoSquare extends Square {
    @Override
    public String takeAction(Player player, int dice) throws BankruptException {
        return player.getName() + " is in GO square";
    }
}
